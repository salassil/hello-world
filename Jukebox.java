package model;

import java.util.ArrayList;

import ennumerators.Genre;
import model.Album;

/**
 * Class that models a Jukebox
 * @author Pedro Guillermo Feij�o-Garc�a
 */
public class Jukebox 
{

	//--------------------------------------------------------------------------
	// Constants
	// -------------------------------------------------------------------------

	/**
	 * Constant that models the maximum possible number of top hits
	 */
	public final static int TOP_HITS = 10;

	//--------------------------------------------------------------------------
	// Attributes
	// -------------------------------------------------------------------------

	/**
	 * Attribute that models the number of existing albums in the jukebox
	 */
	private int numberOfExistingAlbums;

	/**
	 * Attribute that models the number of existing hits in the jukebox
	 */
	private int numberOfExistingHits;

	//--------------------------------------------------------------------------
	// Relations: Structures
	// -------------------------------------------------------------------------

	/**
	 * Vector that models the albums in the jukebox
	 */
	private ArrayList<Album> albums;

	/**
	 * Array that models the albums in the jukebox
	 */
	private Song[] hits;

	//--------------------------------------------------------------------------
	// Methods
	// -------------------------------------------------------------------------

	/**
	 * Method that creates an object (instance) of the Jukebox class<br>
	 * <b>post: </b>An instance of type Jukebox has been created<br>
	 */
	public Jukebox()
	{
		numberOfExistingAlbums = 0;
		numberOfExistingHits = 0;
		hits = new Song[TOP_HITS];

		//TODO Initialize albums


		albums = new ArrayList<Album>();
	}

	/**
	 * Method that returns the number of existing albums<br>
	 * @return the number of existing albums
	 */
	public int getNumberOfExistingAlbums()
	{
		return numberOfExistingAlbums;
		//TODO Complete this method
	}

	/**
	 * Method that returns the number of existing hits<br>
	 * @return the number of existing hits
	 */
	public int getNumberOfExistingHits()
	{
		//TODO Complete this method
		return numberOfExistingAlbums;

	}

	/**
	 * Method that adds an album to the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * <b>post: </b>An album has been added to the jukebox.<br>
	 * @param pName name of the new album<br>
	 * @param pGenre genre of the new album<br>
	 * @param pPrice price of the new album. pPrice >= 0.0<br>
	 * @param pInterpreter interpreter of the new album. pInterpreter != null<br>
	 * @return true if the album is created. Otherwise it returns false
	 */
	public boolean addAlbum(String pName, Genre pGenre, double pPrice, Interpreter pInterpreter)
	{
		boolean response = false;
		//TODO Complete this method

		Album existingAlbum = searchAlbum(pName);
		if (existingAlbum == null)
		{
			Album album = new Album(pName, pGenre, pPrice, pInterpreter);
			albums.add(album);
			response = true;
			numberOfExistingAlbums++;
		}

		return response;
	}

	/**
	 * Method that searches for an album in the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * @param pName name of the album it will look for. pName != null<br>
	 * @return the album if it exists. Otherwise null
	 */
	public Album searchAlbum(String pName)
	{
		Album response = null;

		//TODO Complete this method


		for (int i = 0; i < albums.size() && response == null; i++)
		{
			Album currentAlbum = albums.get(i);
			if(currentAlbum.getName().equals(pName))
			{
				response = currentAlbum;
			}
		}


		return response;
	}

	/**
	 * Method that adds a song to an album in the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * <b>post: </b>A song has been added to the jukebox.<br>
	 * @param pName name of the song to be added. pName != null<br>
	 * @param pDuration name of the song to be added. pDuration >= 0<br>
	 * @param pNameAlbum name of the album in which the song will be added. pNameAlbum != null<br>
	 * @return true if the song was added. Otherwise false
	 */
	public boolean addSong(String pName, int pDuration, String pNameAlbum)
	{
		boolean response = false;

		//TODO Complete this method
		Album album = searchAlbum(pNameAlbum);

		if(album !=null)
		{
			response = album.addSong(pName, pDuration);

		}

		return response;
	}


	//Search for an existing Song

	public Song searchSong(String pName, String pNameAlbum)
	{
		Song response = null;


		//TODO Complete this method


		Album myAlbum = searchAlbum(pNameAlbum);

		if(myAlbum !=null)
		{
			response = myAlbum.searchSong(pName);

		}

		return response;	
		
	}



	/**
	 * Method that returns the most expensive album in the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * @return the most expensive album in the jukebox. If there are no albums, it should return null
	 */
	public Album getMostExpensiveAlbum()
	{
		Album mostExpensiveAlbum = null;
		//TODO Complete this method
		double maxPrice = 0;

		for (int i = 0; i < albums.size(); i++) 
		{
			Album current = albums.get(i);

			if(mostExpensiveAlbum == null)
			{
				mostExpensiveAlbum = current;
			}
			else if (current.getPrice()<maxPrice)

			{
				mostExpensiveAlbum = current;
			}
		}
		return mostExpensiveAlbum;

	}

	/**
	 * Method that returns the least expensive album in the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * @return the least expensive album in the jukebox. If there are no albums, it should return null
	 */
	public Album getLeastExpensiveAlbum()
	{
		Album mostExpensiveAlbum = null;

		//TODO Complete this method
		double maxPrice = 0;

		for (int i = 0; i < albums.size(); i++) 
		{
			Album current = albums.get(i);

			if(mostExpensiveAlbum == null)
			{
				mostExpensiveAlbum = current;
			}
			else if (current.getPrice()>maxPrice)

			{
				mostExpensiveAlbum = current;
			}
		}

		return mostExpensiveAlbum;
	}

	/**
	 * Method that returns the longest song of an existing album in the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * @param pName name of the album of interest. pName != null <br>
	 * @return the longest song in the album in the jukebox. If there are no albums, it should return null
	 */
	public Song getLongestSongInAlbum(String pName)
	{
		Song longestSong = null;

		Album theAlbum = searchAlbum(pName);

		if(theAlbum != null)
		{
			//TODO Complete this method
			longestSong = theAlbum.getLongestSong();
		}

		return longestSong;
	}

	/**
	 * Method that removes an album from the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * <b>post: </b>An album has been removed from the jukebox.<br>
	 * @param pName name of the album to remove. pName != null<br>
	 * @return true if the album was successfully removed. Otherwise false.
	 */
	public boolean removeAlbum(String pName)
	{
		boolean response = false;

		//TODO Complete this method

		Album existingAlbum = searchAlbum(pName);
		if (existingAlbum != null)
		{
			albums.remove(existingAlbum);
			response = true;
			numberOfExistingAlbums--;
		}

		return response;
	}

	/**
	 * Method that removes a song from an album in the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * <b>post: </b>A song has been removed from the jukebox.<br>
	 * @param pNameSong name of the song to remove. pNameSong != null<br>
	 * @param pNameAlbum name of the album to remove the song from. pNameAlbum != null<br>
	 * @return true if the song was successfully removed. Otherwise false.
	 */
	public boolean removeSongFromAlbum(String pNameSong, String pNameAlbum)
	{
		boolean response = false;

		//TODO Complete this method

		Album myAlbum = searchAlbum(pNameAlbum);

		if(myAlbum !=null)
		{
			response = myAlbum.removeSong(pNameSong); 

		}

		return response;
	}

	/**
	 * Method that searches for a hit in the jukebox<br>
	 * <b>pre: </b>The array of hits has already been initialized.<br>
	 * @param pName name of the hit. pName != null <br>
	 * @return the hit (type Song) if it exists. Otherwise it returns null
	 */
	public Song searchHit(String pName)
	{
		Song response = null;

		//TODO Complete this method
		for (int i = 0; i < hits.length; i++) 
		{
			Song current = hits[i];
			if(current.getName().equals(pName))
			{
				response = current;
			}
		}

		return response;
	}


	/**
	 * Method that adds an existing song to the array of hits in the jukebox<br>
	 * <b>pre: </b>The array of hits has already been initialized.<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * <b>post: </b>A song has been added to the array of hits in the jukebox.<br>
	 * @param pNameSong name of the song that will be added to the hits array. pNameSong != null <br>
	 * @param pNameAlbum name of the album that has the song to be added to the array of hits. pNameAlbum != null <br>
	 * @return true if it was successfully added. Otherwise false
	 */
	public boolean addhit(String pNameSong, String pNameAlbum)
	{
		boolean response = false;

		Album myAlbum = searchAlbum(pNameAlbum);

		if(myAlbum != null)
		{
			Song hitToAdd = myAlbum.searchSong(pNameSong);

			//TODO Complete this method
			
			if(hitToAdd !=null)
			{
				
				ArrayList<Song> hits = new ArrayList<Song>();
				hits.add(hitToAdd);
				response = true;
				numberOfExistingHits++;
			}

			}

		return response;
	}
	


	/**
	 * Method that removes a song from the array of hits in the jukebox<br>
	 * <b>pre: </b>The array of hits has already been initialized.<br>
	 * <b>post: </b>A song has been removed from the array of hits in the jukebox.<br>
	 * @param pName name of the song to be removed. pName != null<br>
	 * @return true if the song was successfully removed from the array of hits. Otherwise false
	 */
	public boolean removeHit(String pName)
	{
		boolean response = false;

		//TODO Complete this method

		return response;
	}

	/**
	 * Method that returns the longest song in the array of hits<br>
	 * <b>pre: </b>The array of hits has already been initialized.<br>
	 * @return the longest song of the array of hits. If there are no songs, returns null.
	 */
	public Song getLongestHit()
	{
		Song longest = null;

		for (int i = 0; i < hits.length; i++) 
		{
			Song current = hits[i];
			if(current != null)
			{
				if(longest == null)
				{
					longest = current;
				}

				else if(current.getDuration() > longest.getDuration())
				{
					longest = current;
				}
			}
		}

		return longest;
	}

	/**
	 * Method that returns the shortest song in the array of hits<br>
	 * <b>pre: </b>The array of hits has already been initialized.<br>
	 * @return the shortest song of the array of hits. If there are no songs, returns null.
	 */
	public Song getShortestHit()
	{
		Song shortest = null;

		//TODO Complete this method
		for (int i = 0; i < hits.length; i++) 
		{
			Song current = hits[i];
			if(current != null)
			{
				if(shortest == null)
				{
					shortest = current;
				}

				else if(current.getDuration() < shortest.getDuration())
				{
					shortest = current;
				}
			}
		}
		return shortest;
	}



}
