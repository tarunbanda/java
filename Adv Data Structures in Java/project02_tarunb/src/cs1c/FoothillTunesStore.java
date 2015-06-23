package cs1c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FoothillTunesStore
{
    ArrayList<SongEntry> tunes; // tunes arrayList to store all songs from json
    ArrayList<SongsInGenre> genres; //genres array with count of songs by genre
    
    // hashmap to group songs by genre
    HashMap<String, ArrayList<SongEntry>> genre = new HashMap<String, ArrayList<SongEntry>>();
    public static boolean ENABLE_RANDOM_PURCHASE = true;

    //FoothillTunesStore constructor creates an ArrayList of SongEntries
    public FoothillTunesStore(String jsonFilePath) throws IOException,
            ParseException
    {
        tunes = new ArrayList<SongEntry>();
        final JSONParser jsonParser = new JSONParser();

        final FileReader fileReader = new FileReader(jsonFilePath);
        final JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
        final JSONArray allSongs = (JSONArray) jsonObject.get("songs");
        final Iterator<?> iterator = allSongs.iterator();

        while (iterator.hasNext())
        {
            final JSONObject currentJson = (JSONObject) iterator.next();
            final String title = currentJson.get("title").toString();
            final int duration = (int) Math.ceil(Double.parseDouble(currentJson.get(
                    "duration").toString()));
            final String artist = currentJson.get("artist_name").toString();
            final String genre = currentJson.get("genre").toString();

            final SongEntry currentSong = new SongEntry(title, duration, artist,
                    genre);
            tunes.add(currentSong);
        }
    }

    public int getSize()
    {
        return tunes.size();
    }

    public ArrayList<SongEntry> getTitles()
    {
        return tunes;
    }

    // groups songs by genre and stores them in a map
    public void groupSongsByGenre()
    {
        for (SongEntry song : tunes)
        {
            final String key = song.getGenre();
            if (genre.get(key) == null)
            {
                genre.put(key, new ArrayList<SongEntry>());
            }
            genre.get(key).add(song);
        }
    }

    // prints out the num of sungs in genre
    public void printNumOfSongsInEachGenre()
    {
        final Set<String> keys = genre.keySet();
        genres = new ArrayList<>();
        for (String x : keys)
        {
            final SongsInGenre tempGenreArray = new SongsInGenre(x, genre.get(x).size());
            genres.add(tempGenreArray);
        }
        for (SongsInGenre s : genres)
            System.out.println(s.getGenreName() + " " + s.getCounter());
    }

    //searches for songs by title and returns and arrayList of SongEntry for all results
    public ArrayList<SongEntry> buySongByTitle(String title)
    {
        SongEntry.setSortType(SongEntry.SORT_BY_TITLE);
        final ArrayList<SongEntry> songsByTitle = new ArrayList<SongEntry>();
        for (SongEntry searchString : tunes)
        {
            if (searchString.getTitle().matches(title))
            {
                songsByTitle.add(searchString);
            }
        }
        return songsByTitle;
    }

    //gets n number of songs from tunes and retunrs to user, option to randomize
        //set of songs
    public ArrayList<SongEntry> getFirstNTitles(int numSongsToBuy,
            boolean enableRandomPurchase)
    {
        final ArrayList<SongEntry> NumSongs = new ArrayList<SongEntry>();

        if (enableRandomPurchase == ENABLE_RANDOM_PURCHASE)
        {
            for (int i = 0; i < numSongsToBuy; i++)
            {
                final int rand = (int) (Math.random() * tunes.size());
                NumSongs.add(tunes.get(rand));
            }
        } 
        else
        {
            for (int i = 0; i < numSongsToBuy; i++)
            {
                NumSongs.add(tunes.get(i));
            }
        }
        return NumSongs;
    }
}
