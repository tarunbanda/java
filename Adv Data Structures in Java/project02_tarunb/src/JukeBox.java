import java.util.ArrayList;
import java.util.Random;


import cs1c.SongEntry;


public class JukeBox 
{
	public Queue<SongEntry> regularPL; //Queue for regular playlist
	public StackList<SongEntry>  vipPL; //vip playlist stack
	public double price; //regular price of a song
	public String name; //takes the name of the jukebox 
	private ArrayList<Double> vipSongs; //Stores values for songs in vipPL
	
	
	//COnstructor with two parameters 
	public JukeBox(String jukeBoxName, double regularPrice) 
	{
		regularPL = new Queue<SongEntry>();
		vipPL = new StackList<SongEntry>();
		name = jukeBoxName;
		price = regularPrice;
		vipSongs = new ArrayList<Double>();
		
	}


	//adds songs to regular or vip PL based on price paid
	public void addSong(SongEntry songFound, double pricePaid) 
	{
		if (pricePaid == price)
			regularPL.enqueue(songFound);
		else
		{
			vipPL.push(songFound);
			vipSongs.add(pricePaid);
		}
	}


	//randomly determins wether to play a song or not if songs can be played
	public boolean determineIfSongIsPlayed() 
	{
		if (!regularPL.isEmpty() || !vipPL.isEmpty())
		{
			Random rand = new Random();
			double coinFlip = rand.nextDouble();
			if (coinFlip >= .50) 
			{
				return true;
			}
		}
		return false;
	}


	//plays song when requested
	public void playSong() 
	{
		if(!vipPL.isEmpty())
			System.out.println("playing song: " + vipPL.pop());
		else
		{
			System.out.println("playing song: " + regularPL.dequeue());
		}
	}
	
	//toString method to print songs
	public String toString()
	{
		if (!vipPL.isEmpty())
			return name + "\nRegular playlist:\n" + regularPL + "\n\nVIP playlist:\n" + vipPL +  " " + vipSongs.get(vipSongs.size()-1);
		else
			return  name + "\nRegular playlist:\n" + regularPL + "\n\nVIP playlist:\n" + vipPL;
	}
	
}
