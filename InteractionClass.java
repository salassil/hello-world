package controller;

import java.util.Scanner;

import ennumerators.Genre;
import ennumerators.Region;
import model.Album;
import model.Interpreter;
import model.Jukebox;
import model.Song;

/**
 * Class that models the interaction window with the user.
 * @author Pedro Guillermo Feijóo-García
 */
public class InteractionClass 
{
	/**
	 * Main method of the application. It controls the excecution of the program.
	 * @param args arguments input by the Java Virtual Machine and the environment.
	 */
	public static void main(String[] args) 
	{
		Jukebox model = new Jukebox();
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to JukeboxApp!");


		boolean continueExcecution = true;
		while(continueExcecution == true)
		{
			System.out.println("*******************************************");
			System.out.println("Please select one of the following actions:");
			System.out.println("Add a new album [1]");
			System.out.println("Add a new song to an existing album [2]");
			System.out.println("Add a new hit [3]");
			System.out.println("Search for an existing album [4]");
			System.out.println("Search for a song in an album [5]");
			System.out.println("Search for a hit [6]");
			System.out.println("Delete an album [7]");
			System.out.println("Delete a song from an existing album [8]");
			System.out.println("Delete a hit [9]");
			System.out.println("Retrieve the most expensive album [10]");
			System.out.println("Retrieve the least expensive album [11]");
			System.out.println("Retrieve the longest song in an existing album [12]");
			System.out.println("Retrieve longest hit [13]");
			System.out.println("Retrieve shortest hit [14]");
			System.out.println("Retrieve the number of existing albums [15]");
			System.out.println("Retrieve the number of existing hits [16]");
			System.out.println("*******************************************");


			String txtResponse = input.nextLine();
			int response = Integer.parseInt(txtResponse);

			//TODO Complete this method for each functional requirement

			if(response == 1)
			{

				System.out.println("Let's create the Interpreter first");

				System.out.println("What is the name of the interpreter");
				String nameInterpreter = input.nextLine();

				System.out.println("What is the Surname of the Interpreter");
				String surnameInterpreter = input.nextLine();

				System.out.println("What is the age of the Interpreter");
				String txtAge = input.nextLine();
				int ageInterpreter = Integer.parseInt(txtAge);


				System.out.println("What is the Interpreter Region:");
				System.out.println("NORTH_AMERICA [1]");
				System.out.println("SOUTH_AMERICA [2]");
				System.out.println("EUROPE [3]");
				System.out.println("AFRICA [4]");
				System.out.println("ASIA [5]");
				System.out.println("AUSTURALIA [6]");

				String txtRegion = input.nextLine();
				int regionInterpeter = Integer.parseInt(txtRegion);

				Region getRegion1= null;

				if(regionInterpeter == 1)
				{
					getRegion1 = Region.NORTH_AMERICA;

					System.out.println(Region.NORTH_AMERICA);
				}

				else if( regionInterpeter == 2)
				{
					getRegion1 = Region.SOUTH_AMERICA;
					System.out.println(Region.SOUTH_AMERICA);
				}

				else if( regionInterpeter == 3)
				{
					getRegion1 = Region.EUROPE;
					System.out.println(Region.EUROPE);
				}
				else if(regionInterpeter == 4)
				{
					getRegion1 = Region.AFRICA;
					System.out.println(Region.AFRICA);
				}

				else if(regionInterpeter == 5)
				{
					getRegion1 = Region.ASIA;
					System.out.println(Region.ASIA);
				}

				else if(regionInterpeter == 6)
				{
					getRegion1 = Region.AUSTURALIA;
					System.out.println(Region.AUSTURALIA);
				}


				Interpreter interpreter = new Interpreter(nameInterpreter, surnameInterpreter, ageInterpreter, getRegion1);


				System.out.println("");
				System.out.println("Now let's create the Album");

				System.out.println("What is the name of the Album");
				String nameAlbum = input.nextLine();


				System.out.println("What is the genre of the Album:");

				System.out.println("GOSPEL [1]");
				System.out.println("SALSA [2]");
				System.out.println("HIPHOP [3]");
				System.out.println("RNB [4]");
				System.out.println("CLASSICAL [5]");

				String txtGenre = input.nextLine();
				int genreInterpeter = Integer.parseInt(txtGenre);

				Genre getgenre= null;

				if(genreInterpeter == 1)
				{
					getgenre = Genre.GOSPEL;			
					System.out.println(Genre.GOSPEL);
				}

				else if( genreInterpeter == 2)
				{
					getgenre = Genre.SALSA;	
					System.out.println(Genre.SALSA);
				}

				else if( genreInterpeter == 3)
				{
					getgenre = Genre.HIPHOP;	
					System.out.println(Genre.HIPHOP);
				}
				else if(genreInterpeter== 4)
				{
					getgenre = Genre.RNB;	
					System.out.println(Genre.RNB);
				}

				else if(genreInterpeter == 5)
				{
					getgenre = Genre.CLASSICAL;
					System.out.println(Genre.CLASSICAL);
				}



				System.out.println("What is the price of the Album");
				String txtPrice = input.nextLine();
				double priceAlbum = Double.parseDouble(txtPrice);


				boolean methodAnswer = model.addAlbum(nameAlbum, getgenre, priceAlbum, interpreter);

				if(methodAnswer == true)
				{
					System.out.println(" " + "Your Album was succesfully added to the Jukebox!");
					System.out.println("");
				}
				else 
				{
					System.out.println(" " + " Sorry... The Album was not added. Please try again");
					System.out.println("");
				}

			}

			//Add a new Song to an Existing Album		
			else if(response == 2)
			{
				System.out.println("Please input the name of the Album");
				String nameAlbum = input.nextLine();

				System.out.println("Please input the name of the Song");
				String nameSong = input.nextLine();

				System.out.println("Please input the Duration of the Song");
				String txtDuration = input.nextLine();
				int durationSong = Integer.parseInt(txtDuration);

				boolean methodResponse = model.addSong(nameSong, durationSong, nameAlbum);

				if(methodResponse == true)
				{
					System.out.println(" " +" The Song was Succesfully added to the Album!");
					System.out.println("");
				}
				else
				{
					System.out.println(" " + " Sorry...The Song was not added to the Album. Please try again");
					System.out.println("");
				}
			}
			//Add a new hit			
			else if (response == 3)
			{
				System.out.println("Please input the name of the Album");
				String nameAlbum = input.nextLine();

				System.out.println("Please input the name of the Song");
				String nameSong = input.nextLine();

				boolean methodResponse = model.addhit(nameAlbum,nameSong);


				if(methodResponse == true)
				{
					System.out.println(" The hit has been added to the Song: " + nameSong + " succesfully! ");
					System.out.println("");

				}

				else 
				{
					System.out.println(" Sorry..There is no Song under this info..Please try again ");
				}
			}

			// Search for an Existing Album		
			else if(response == 4)
			{
				System.out.println("Please input the name of the Album ");
				String nameAlbum = input.nextLine();

				Album searchAlbum = model.searchAlbum(nameAlbum);
				if(searchAlbum == null)
				{
					System.out.println(" " + " Sorry.. There is no Album under this name. Please try agaib");
					System.out.println("");

				}
				else 
				{
					System.out.println("The Album named " + nameAlbum + " has the following details: ");
					System.out.println("\t b. Interpreter: " + searchAlbum.getInterpreter().getName() + " " + searchAlbum.getInterpreter().getSurname());
					System.out.println("\t c. Genre " + searchAlbum.getGenre());
					System.out.println("\t a. price: " + searchAlbum.getPrice());
					System.out.println("");

				}
			}


			// Search for a Song in an Album

			else if(response == 5)
			{
				System.out.println("Please input the name of Album");
				String nameAlbum = input.nextLine();

				System.out.println("Please input the Song Name");
				String nameSong = input.nextLine();


				Song searchSong = model.searchSong(nameSong, nameAlbum);

				if (searchSong == null)
				{
					System.out.println(" " + " Sorry the Album or the Song do not exist. Please check your input");
					System.out.println("");
				}

				else 
				{

					System.out.println(" The Song named "  + nameSong + " has the follwing details");
					System.out.println("\t a. Album name: " + nameAlbum);
					System.out.println("\t b. Duration: " + " " + searchSong.getDuration());

					System.out.println("");
				}
				System.out.println("");
			}



			//Search for a hit
			else if(response == 6)
			{
				System.out.println(" Please input the name of the Song");
				String nameSong = input.nextLine();


				Song searchSong = model.searchHit(nameSong);
				if(searchSong ==null)
				{
					System.out.println(" Sorry.. ");
					System.out.println("");
				}
				else 
				{
					System.out.println(" The Song named " + nameSong + " has the hit");
					System.out.println(" ");
				}
			}

			//Remove an Album
			else if (response == 7)
			{
				System.out.println("Please input the name of the Album ");
				String nameAlbum = input.nextLine();

				Album searAlbum = model.searchAlbum(nameAlbum);
				if(searAlbum == null)
				{
					System.out.println(" Sorry there is no Album under this name " + nameAlbum );
					System.out.println("");
				}
				else 
				{
					boolean methodResponse = model.removeAlbum(nameAlbum);
					if(methodResponse == true)
					{
						System.out.println(" The Album named " + nameAlbum + " " + "has been succefully removed");
						System.out.println("");
					}
				}
			}


			//Remove a Song From an Existing Album
			else if( response == 8)
			{
				System.out.println("Please input the Album name");
				String nameAlbum = input.nextLine();

				System.out.println("Please input the Song name");
				String nameSong = input.nextLine();

				boolean remove = model.removeSongFromAlbum(nameSong, nameAlbum);
				if(remove == false)
				{
					System.out.println(" Album name or Song name might not exist.. Please try again");
					System.out.println("");
				}
				else 
				{
					System.out.println(" The Song named " + nameSong + " has been removed succesfully!");
					System.out.println();
				}
			}



			//Delete a hit
			else if(response == 9)
			{

			}

			//Retrieve the Most Expensive Album
			else if (response == 10)
			{
				Album mostExpensive = model.getMostExpensiveAlbum();
				if(mostExpensive == null)
				{
					System.out.println(" There are no albums in the Jukebox yet!");
					System.out.println("");
				}
				else

					System.out.println(" The most Expensive Album named " + mostExpensive.getName() + " and has the following details:");
				System.out.println("\t a. Gener: " + mostExpensive.getGenre());
				System.out.println("\t b. Number of Songs: " + mostExpensive.getNumberOfExistingSongs());
				System.out.println("\t c. Intrepreter: " + mostExpensive.getInterpreter().getName() + " " + mostExpensive.getInterpreter().getSurname());
				System.out.println("\t d. Price of Album: " + mostExpensive.getPrice());
				System.out.println("");
			}

			//Retrieve the Least Expensive Album
			else if(response == 11)
			{
				Album leastExpensive = model.getLeastExpensiveAlbum();
				if(leastExpensive == null)
				{
					System.out.println(" There are no albums in the Jukebox yet!");
					System.out.println("");
				}
				else

					System.out.println(" The Least Album named " + leastExpensive.getName() + " and has the following details:");
				System.out.println("\t a. Gener: " + leastExpensive.getGenre());
				System.out.println("\t b. Number of Songs: " + leastExpensive.getNumberOfExistingSongs());
				System.out.println("\t c. Intrepreter: " + leastExpensive.getInterpreter().getName() + " " + leastExpensive.getInterpreter().getSurname());
				System.out.println("\t d. Price of Album: " + leastExpensive.getPrice());
				System.out.println("");
			}

			//Retrieve the Longest Song in an existing Album
			else if(response == 12)
			{
				System.out.println(" Please input the name of the Album");
				String nameAlbum = input.nextLine();

				Album searchAlbum = model.searchAlbum(nameAlbum);

				if(searchAlbum == null)
				{
					System.out.println(" Sorry.. No Album under this name");
					System.out.println("");
				}

				else 
				{
					Song longSong = searchAlbum.getLongestSong();
					if (longSong == null)
					{
						System.out.println(" There are no Songs under " + nameAlbum + " Album");
						System.out.println("");
					}
					else
					{
						System.err.println(" The longest Song is named " + longSong.getName());
						System.out.println("\t * Song Duration: " + longSong.getDuration());
						System.out.println("");
					}
				}
			}


			//Retrieve Longest hit
			else if(response == 13)
			{
				Song longHits = model.getLongestHit();

				if(longHits == null)
				{
					System.out.println(" There are no hits in the Jukebox yet!");
					System.out.println("");
				}
				else

					System.out.println(" The longest hit is: " + longHits.getName());
				System.out.println("");
			}

			//Retrieve Shortest Hit
			else if (response == 14)
			{
				Song shortHits = model.getShortestHit();

				if(shortHits == null)
				{
					System.out.println(" There are no hits in the Jukebox yet!");
					System.out.println("");
				}
				else

					System.out.println(" The longest hit is: " + shortHits.getName());
				System.out.println("");
			}


			//Retrieve the Number of Existing Albums
			else if (response == 15)
			{
				int numberOfAlbums = model.getNumberOfExistingAlbums();
				System.out.println(" The number of Existing Albums are: " + numberOfAlbums);
				System.out.println("");	
			}


			//Retrieve the Number of Existing Hits

			else if(response == 16)
			{
				int numberOfHits = model.getNumberOfExistingHits();
				System.out.println(" The number of the existing Hits are: " + numberOfHits);
				System.out.println("");
			}
		}

		input.close();

	}
}
