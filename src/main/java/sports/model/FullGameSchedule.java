package sports.model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for tracking information pertaining to the full schedule 
 * of a particular team. 
 * @author obinnaasinugo
 *
 */
public class FullGameSchedule {
	
	private FileDownloader dl; // used for downloading file 
	private FileReaderv3  fullGameSchedule; // used for reading in data
	private String team; // team
	
	/**
	 * Constructor for initializing objects. Download the data file and read into respective object. 
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public FullGameSchedule(String team) throws MalformedURLException, IOException{
		dl = new FileDownloader("src/main/resources/");
		dl.fullSchedule();
		fullGameSchedule = new FileReaderv3("src/main/resources/full_game_schedule.csv");
		this.team = team;
	}
	
	/**
	 * Method will return the file read in for the full game schedule. 
	 * @return file read in for the full game schedule 
	 */
	public FileReaderv3 getFile(){
		return fullGameSchedule; 
	}

	public String getTeam() {
		return team;
	}
	
	/**
	 * Method will create a list of all the games for a particular team of interest during a season. 
	 * @param team
	 * @return full schedule of games for the season 
	 */
	public ArrayList<String[]> getSeasonGames(String team){
		ArrayList<String[]> teamSchedule = new ArrayList<String[]>(); // create a list of games
		String[] gameInfoArray; // store game info as an array 
		// store all games of the 'team' into a list 
		for(String gameInfo : fullGameSchedule.getLines()){
			gameInfoArray = gameInfo.split(","); 
			if(gameInfoArray[6].equalsIgnoreCase(team) || 
					gameInfoArray[10].equalsIgnoreCase(team))
				teamSchedule.add(gameInfoArray);
		}
		return teamSchedule; 
	}
	
	/**
	 * Method will create and return a list of all the games being played on a specific date 
	 * @param date
	 * @return list of all games on specific date 
	 */
	public ArrayList<String[]> getGamesOnDay(String date){
		ArrayList<String[]> games = new ArrayList<String[]>();
		String[] gameInfoArray; // store game info as an array 
		
		// store all games of the 'team' into a list 
		for(String gameInfo : fullGameSchedule.getLines()){
			gameInfoArray = gameInfo.split(","); 
			if(gameInfoArray[1].equalsIgnoreCase(date))
				games.add(gameInfoArray);
		}
		return games; 
	}
	
	/**
	 * This method is responsible for returning game information (away team, home team, time, and location)
	 * for a team playing on a certain day. 
	 * @param team
	 * @param date
	 * @return game information 
	 */
	public String[] getGame(String team, String date){
		String[] game = new String[4]; // store game details 
		ArrayList<String[]> games = getGamesOnDay(date); // store all games on a given day 
		
		// cycle through the list of games and determine if team is playing for a given day 
		for(String[] matchUp : games){
			// if team is either the home or away team, store game details 
			if(matchUp[6].equals(team) || matchUp[10].equals(team)){
				game[0] = matchUp[6]; // store away team   
				game[1] = matchUp[10]; // store home team 
				game[2] = matchUp[2]; // store time of game 
				game[3] = matchUp[11]; // store location of the game 
				return game; 
			}
		}
		return null;
	}

	/**
	 * List of all games
	 * @return
	 */
	public List<Game> getAllGames(){
		ArrayList<String[]> allGames = getSeasonGames(team);
		ArrayList<Game> season = new ArrayList<>();
		for (String[] match : allGames){
			if(match[6].equals(team))
				season.add(new Game(match[10], match[1], match[2], match[11]));
			else
				season.add(new Game(match[6], match[1], match[2], match[11]));
		}
		return season;
	}
}
