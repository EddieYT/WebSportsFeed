package sports.model;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * This class will let you download requested sports feed to specified directory
 * @author Eddie
 *
 */
public class FileDownloader {
	private String src;
	private String statsName;
	private String targetDirectory;
	private String date;
	
	/**
	 * Constructor will require a targetDirectory to store the download.
	 * @param target the directory for the download
	 */
	public FileDownloader(String target) {
		targetDirectory = target;
	}
	
	/**
	 * This method will download Cumulative Player Stats with "csv" format.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void cumulativePlayers() throws MalformedURLException, IOException {
		statsName = "cumulative_player_stats";
		src = "https://www.mysportsfeeds.com/api/feed/pull/nba/2016-2017-regular/"+ statsName + ".csv?";
		String fileName = statsName + ".csv";
		download(src, targetDirectory, fileName);
	}
	/**
	 * @return the statsName
	 */
	public String getStatsName() {
		return statsName;
	}

	/**
	 * @param statsName the statsName to set
	 */
	public void setStatsName(String statsName) {
		this.statsName = statsName;
	}

	/**
	 * @return the targetDirectory
	 */
	public String getTargetDirectory() {
		return targetDirectory;
	}

	/**
	 * This method will download Full Game Schedule with "csv" format.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void fullSchedule() throws MalformedURLException, IOException {
		statsName = "full_game_schedule";
		src = "https://www.mysportsfeeds.com/api/feed/pull/nba/2016-2017-regular/"+ statsName + ".csv?";
		String fileName = statsName + ".csv";
		download(src, targetDirectory, fileName);
	}
	
	/**
	 * This method will download Daily Game Schedule with "csv" format.
	 * @param inputDate the date for which we are searching
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void dailySchedule(String inputDate) throws MalformedURLException, IOException {
		statsName = "daily_game_schedule";
		date = inputDate;
		src = "https://www.mysportsfeeds.com/api/feed/pull/nba/2016-2017-regular/"+ statsName + ".csv?fordate=" + date;
		String fileName = statsName + ".csv";
		download(src, targetDirectory, fileName);
	}
	
	
	/**
	 * This method will download Daily Player Stats with "csv" format.
	 * @param inputDate the date for which we are searching
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void  dailyPlayer(String inputDate) throws MalformedURLException, IOException {
		statsName = "daily_player_stats";
		date = inputDate;
		src = "https://www.mysportsfeeds.com/api/feed/pull/nba/2016-2017-regular/"+ statsName + ".csv?fordate=" + date;
		String fileName = statsName + ".csv";
		download(src, targetDirectory, fileName);
	}
	
	/**
	 * This method will download Scoreboard with "csv" format.
	 * @param inputDate the date for which we are searching
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void  scoreBoard(String inputDate) throws MalformedURLException, IOException {
		statsName = "scoreboard";
		date = inputDate;
		src = "https://www.mysportsfeeds.com/api/feed/pull/nba/2016-2017-regular/"+ statsName + ".csv?fordate=" + date;
		String fileName = statsName + ".csv";
		download(src, targetDirectory, fileName);
	}
	
	/**
	 * This method will download Roster Players with "csv" format.
	 * @param inputDate
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void rosterPlayers(String inputDate) throws MalformedURLException, IOException {
		statsName = "roster_players";
		date = inputDate;
		src = "https://www.mysportsfeeds.com/api/feed/pull/nba/2016-2017-regular/"+ statsName + ".csv?fordate=" + date;
		String fileName = statsName + ".csv";
		download(src, targetDirectory, fileName);
	}
	
	/**
	 * This method will download Overall Team Standings with "csv" format.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void allStandings() throws MalformedURLException, IOException {
		statsName = "overall_team_standings";
		src = "https://www.mysportsfeeds.com/api/feed/pull/nba/2016-2017-regular/"+ statsName + ".csv?";
		String fileName = statsName + ".csv";
		download(src, targetDirectory, fileName);
	}
	
	/**
	 * This method will download Conference Standings with "csv" format.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void conferenceStandings() throws MalformedURLException, IOException {
		statsName = "conference_team_standings";
		src = "https://www.mysportsfeeds.com/api/feed/pull/nba/2016-2017-regular/"+ statsName + ".csv?";
		String fileName = statsName + ".csv";
		download(src, targetDirectory, fileName);
	}
	
	/**
	 * This method will download Division Standings with "csv" format.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void divisionStandings() throws MalformedURLException, IOException {
		statsName = "division_team_standings";
		src = "https://www.mysportsfeeds.com/api/feed/pull/nba/2016-2017-regular/"+ statsName + ".csv?";
		String fileName = statsName + ".csv";
		download(src, targetDirectory, fileName);
	}
	
	/**
	 * This method will download Player Injuries with "csv" format.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void playerInjuries() throws MalformedURLException, IOException {
		statsName = "player_injuries";
		src = "https://www.mysportsfeeds.com/api/feed/pull/nba/2016-2017-regular/"+ statsName + ".csv?";
		String fileName = statsName + ".csv";
		download(src, targetDirectory, fileName);
	}
	
	
	/**
	 *  This method will download a file from URL to specified directory,
	 *  and the desired format of the file can be specified as well.
	 * @param sourceUrl where we request for a file
	 * @param targetDirectory where we put the download
	 * @param targetFile the filename for the download
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static Path download(String sourceUrl, String targetDirectory, String targetFile) 
			throws MalformedURLException, IOException
	{
		// Generate the authentication for requesting
		String name = "Eddie";
		String password = "cit591";
		String authString = name + ":" + password;
		byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		String authStringEnc = new String(authEncBytes);
		
		// Connect to the URL and make a request for file
		URL url = new URL(sourceUrl);
		URLConnection urlConnection = url.openConnection();
		urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
		InputStream is = urlConnection.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		
		// Copy requested file to the targetDirectory with a specified format of "targetFile", ex:test.txt
		String fileName = targetFile;
		Path targetPath = new File(targetDirectory + fileName).toPath();
		Files.copy(is, targetPath, StandardCopyOption.REPLACE_EXISTING);
		

		return targetPath;
	}
}
