/*
 * Reads an input file that contains the users selections. 
 * Creates an object of type FoothillTunesStore which parses the JSON file via
 * an object of type MillionSongSubset in class cs1c.
 * 
 * Note: Due to a few data points in the json file, such as:
 * ,
{
        "genre": "classic pop and rock",
        "artist_name": "Crosby_ Stills_ Nash and Young",
        "title": "Carry On",
        "duration": "0.80934"
},
 *
 * We modify the constructor for class MillionSongDataSubset to save "duration" as follows:
			int duration = (int)Math.ceil(Double.parseDouble(currentJson.get("duration").toString()));

 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import cs1c.BubbleSort;
import cs1c.FoothillTunesStore;
import cs1c.SongEntry;
import cs1c.TimeConverter;

public class MyTunes 
{
	private static final int QUIT = 0;
	private static final int HELP_MENU = 1;
	private static final int LIST_SONG_TITLES = 2;
	private static final int LIST_SONGS_BY_GENRE = 3;
	private static final int BUY_SONG_TITLE = 4;
	private static final int CREATE_RANDOM_PLAYLIST = 5;	/* finds the songs that meets the playlist time requirement */
	private static final int ADD_SONG_TO_JUKEBOX = 6;
	private static final int ADD_VIP_SONG_TO_JUKEBOX = 7;

	private static final boolean ENABLE_RANDOM_PURCHASE = false;

	/* By default the price of a song is $1 
	 * If the user wants to bring their song to the front, then they must
	 * pay greater the price of a regular song or the top-most song in the VIP playlist,
	 * whichever greater.
	 */
	private static final double REGULAR_JUKEBOX_PRICE = 1;
	private static final boolean ENABLE_DEBUG_SELECTION = false;

	/* Once a user purchases a song, they can make various selections such as
	 * add the song to their play list, play the song, etc.
	 * We'll gradually give the user more options.
	 */
	private ArrayList<SongEntry> purchasedTunes;
	private ArrayList<ArrayList<SongEntry>> playlist;
	
	/*
	 * Where all songs from MillionSongSubset are stored.
	 */
	private FoothillTunesStore theStore;

	//MyTunes constructor 
    public MyTunes(FoothillTunesStore store)
    {
        // TODO Auto-generated constructor stub
        this.theStore = store;
        purchasedTunes = new ArrayList<SongEntry>();
        playlist = new ArrayList<>();
    }

    public static ArrayList<String> readTestFile(String tunesTestFilePath)
        throws NoSuchElementException, IOException, FileNotFoundException
    {
        final ArrayList<String> storedLines = new ArrayList<>();
        // open scanner to read file
        final BufferedReader fileReader = new BufferedReader(new FileReader(tunesTestFilePath));
        String line;

        while ((line = fileReader.readLine()) != null)
        {
            storedLines.add(line);
        }
        fileReader.close();
        return storedLines;
    }

    public ArrayList<SongEntry> getPurchasedTunes()
    {
        return purchasedTunes;
    }

    public void addSongs(ArrayList<SongEntry> search)
    {
        for (SongEntry s : search)
        {
            if (s != null)
                purchasedTunes.add(s);
        }
    }
    
    public SongEntry containsTitle(String title)
    {
		return theStore.buySongByTitle(title).get(0);
    }

    // finds the subset sum of an array given a length of time for the playlist
    public ArrayList<SongEntry> makePlayList(int seconds)
    {
        int playlistSize = 0;
        playlist.add(new ArrayList<SongEntry>());

        if (seconds > sumDuration(purchasedTunes))
            return purchasedTunes;

        for (int currentSong = 0; currentSong < purchasedTunes.size(); currentSong++)
        {
            playlistSize = playlist.size();
            for (int k = 0; k < playlistSize; k++)
            {
                final ArrayList<SongEntry> currentSongArray = new ArrayList<>(
                        playlist.get(k));

                if ((sumDuration(currentSongArray) + purchasedTunes.get(
                        currentSong).getDuration()) < seconds)
                {
                    currentSongArray.add(purchasedTunes.get(currentSong));
                    playlist.add(currentSongArray);
                } 
                else if ((sumDuration(currentSongArray) + purchasedTunes.get(
                        currentSong).getDuration()) == seconds)
                {
                    currentSongArray.add(purchasedTunes.get(currentSong));
                    playlist.add(currentSongArray);
                    return currentSongArray;
                }
            }
        }
        return playlist.get(findMaxDuration());
    }
    
    //helper  method to find an array of with maxDuration if playlist duration
        //subset doesn't have an exact match
    private int findMaxDuration()
    {
        double maxDuration = 0;
        int maxDurationIndex = 0;
        
        for (int i = 0; i < playlist.size(); i++)
        {
            if (sumDuration(playlist.get(i)) > maxDuration)
            {
                maxDuration = sumDuration(playlist.get(i));
                maxDurationIndex = i;
            }
        }
        return maxDurationIndex;
    }
    
    // helper method to sum the duration of an array
    private double sumDuration(ArrayList<SongEntry> array)
    {
        double sum = 0;
        for (int i = 0; i < array.size(); i++)
            sum += array.get(i).getDuration();
        return sum;
    }
	/*
	 * Show all songs that have been purchased.
	 */
	public void showLibrary()
	{
		System.out.println(purchasedTunes);
	}

	/*
	 * Selections user can make.
	 */
	public static void printMenu()
	{
		System.out.println("\nMenu:");
		System.out.println("0. Quit");
		System.out.println("1. Output this menu");
		System.out.println("2. Show all song titles");
		System.out.println("3. Show all songs by genre ");
		System.out.println("4. Buy songs by title");
		System.out.println("5. Create a playlist");
		System.out.println("6. Play my song title (regular priority)");
		System.out.println("7. Play my song title first (high priority)");
	}

	public static void main(String[] args) {
		final String jsonFilePath = "resources/music_genre_subset.json";
		final String tunesTestFilePath = "resources/test_tunes.txt";

		try {
			FoothillTunesStore store = new FoothillTunesStore(jsonFilePath);
			ArrayList<SongEntry> storeTitles = store.getTitles();
			System.out.println("Welcome! We have over " + storeTitles.size()
					+ " in FoothillTunes Jukebox!");

			ArrayList<String> tunesTestFile = MyTunes.readTestFile(tunesTestFilePath);

			MyTunes.printMenu();

			MyTunes personalTunes = new MyTunes(store);

			ArrayList<String> linesInFile = MyTunes
					.readTestFile(tunesTestFilePath);
			int selection = -1;
			long startTime, estimatedTime;
			long containsTitleEstimatedTime = 0;
			int numCallsToContainsTitle = 0;

			JukeBox touchTunes = new JukeBox("TouchTunes",
					REGULAR_JUKEBOX_PRICE);

			for (int i = 0; i < linesInFile.size() && selection != QUIT;) /*no need to increment here */
			{
				String line = linesInFile.get(i++);
				String[] tokens = line.split(" ");
				if (line.contains("selection"))
					selection = Integer.parseInt(tokens[1]);
				else {
					// invalid selection format
					System.out.printf("WARNING: Invalid selection %d at line %d\n",selection, i);
					continue;
				}

				if (ENABLE_DEBUG_SELECTION)
					System.out.println("\nselected option:" + selection);
				switch (selection) {
				case QUIT:
					break;
				case HELP_MENU:
					MyTunes.printMenu();
					break;
				case LIST_SONG_TITLES:
					System.out.println("Number of titles in store = "
							+ personalTunes.getPurchasedTunes().size());
					personalTunes.showLibrary();
					break;
				case LIST_SONGS_BY_GENRE:
					// capture start time
					startTime = System.nanoTime();

					// implement grouping songs by genre
					store.groupSongsByGenre();

					// stop and calculate elapsed time
					estimatedTime = System.nanoTime() - startTime;

					// report algorithm time
					System.out.println("\nAlgorithm Elapsed Time: "
							+ TimeConverter.convertTimeToString(estimatedTime)
							+ "\n");

					store.printNumOfSongsInEachGenre();
					break;
				case BUY_SONG_TITLE:
					String title = linesInFile.get(i++);
					if (ENABLE_DEBUG_SELECTION)
						System.out.println("selected song title: " + title);

					// implement searching for songs by title
					ArrayList<SongEntry> searchResult = store
							.buySongByTitle(title);

					if (ENABLE_DEBUG_SELECTION) {
						System.out.println("Found " + searchResult.size()
								+ " song(s):");
						System.out.println(searchResult);
					}

					personalTunes.addSongs(searchResult);
					break;

				case CREATE_RANDOM_PLAYLIST:
					int numSongsToBuy = Integer.parseInt(linesInFile.get(i++));
					System.out.println("selected number of songs to buy: "
							+ numSongsToBuy);

					personalTunes.addSongs(store.getFirstNTitles(numSongsToBuy,
							ENABLE_RANDOM_PURCHASE));

					int lengthInMinutes = Integer
							.parseInt(linesInFile.get(i++));
					int seconds = lengthInMinutes * 60;
					System.out
							.println("selected playlist length (in seconds): "
									+ seconds);

					// capture start time
					startTime = System.nanoTime();

					// implement finding subset of songs that is closest to the
					// requested length of play list
					// HINT: Use same approach as buying a subset of groceries
					// within budget
					ArrayList<SongEntry> myPlayList = personalTunes
							.makePlayList(seconds);

					// stop and calculate elapsed time
					estimatedTime = System.nanoTime() - startTime;

					// output the result
					int totalTime = 0;
					for (SongEntry song : myPlayList) {
						totalTime += song.getDuration();
					}
					System.out.println("length of play list (in seconds): "
							+ totalTime);
					System.out.println("songs in play list: " + myPlayList);

					// report algorithm time
					System.out.println("\nAlgorithm Elapsed Time: "
							+ TimeConverter.convertTimeToString(estimatedTime)
							+ "\n");
					break;
				case ADD_SONG_TO_JUKEBOX:
					title = linesInFile.get(i++);
					System.out.println("\njukebox song title: " + title);

					// to simplify implementation we will assume first result is
					// what user wants
					SongEntry songFound = personalTunes.containsTitle(title);
					if (songFound == null) {
						System.out.println("Warning! requested song " + title
								+ "  not found.");
						continue;
					}

					touchTunes.addSong(songFound, REGULAR_JUKEBOX_PRICE);

					System.out.println(touchTunes);
					break;
				case ADD_VIP_SONG_TO_JUKEBOX:
					title = linesInFile.get(i++);
					System.out.println("\njukebox VIP song title: " + title);
					double pricePaid = Double.parseDouble(linesInFile.get(i++));

					// capture start time
					startTime = System.nanoTime();

					// to simplify implementation we will assume first result is
					// what user wants
					songFound = personalTunes.containsTitle(title);

					// stop and calculate elapsed time
					containsTitleEstimatedTime += System.nanoTime() - startTime;
					numCallsToContainsTitle++;

					if (songFound == null) {
						System.out.println("Warning! requested song " + title
								+ "  not found.");
						continue;
					}

					touchTunes.addSong(songFound, pricePaid);
					System.out.println(touchTunes);
					break;
				default:
					System.out.println("ERROR : invalid selection.");
					MyTunes.printMenu();
					break;
				} // switch

				/*
				 * In this project we'll use a very basic simulation of deciding
				 * when to play the next song. In this way, we avoid complicated
				 * Thread calls (which are outside the scope of this class), as
				 * well as avoiding requiring user input to test our new data
				 * structures.
				 * 
				 * If both VIP stack and regular queue are empty, then there is
				 * nothing to play.
				 * 
				 * Note: for clarity of interface we are making the call to
				 * determine if song is played here.
				 */
				boolean playNextSong = touchTunes.determineIfSongIsPlayed();
				if (playNextSong) {
					touchTunes.playSong();
				}
			} // for lines in the file

			// report algorithm time for searching for a title for our jukebox
			// NOTE: only keeps track of the regular play list
			System.out
					.println("\nAlgorithm containsTitle Average Elapsed Time: "
							+ TimeConverter
									.convertTimeToString(containsTitleEstimatedTime
											/ numCallsToContainsTitle) + "\n");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchElementException e) {
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // main method
}

