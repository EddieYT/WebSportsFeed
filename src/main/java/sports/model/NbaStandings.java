package sports.model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/**
 * This class is responsible for evaluating data pertaining to
 * the overall standings, conference team standings, division
 * team standings, and playoff team standings.
 * @author ?
 *
 */
public class NbaStandings implements Standings{

	private FileReaderv3 teamStandings;
	private HashMap<String, String[]> teamStatsMap;
	private FileDownloader fd ;

	/**
	 * @throws IOException 
	 * @throws MalformedURLException 
	 *
	 */
	public NbaStandings() throws MalformedURLException, IOException{
		fd = new FileDownloader("src/main/resources/");
		fd.allStandings();
		teamStandings = new FileReaderv3("src/main/resources/overall_team_standings.csv");
		teamStatsMap = new HashMap<String, String[]>();
		makeTeamStandingsMap();
	}
 
	/**
	 * This method will return the file read in by the program
	 * @return file read in by the program
	 */
	public FileReaderv3 getFile(){
		return teamStandings;
	}

	/**
	 * This method will populate the team standings map. The key is the rank of the team; the
	 * value is the team info (name, record, etc.)
	 */
	public void makeTeamStandingsMap(){
		String[] teamInfo = null;
		String teamName;

		for(String team : teamStandings.getLines()){
			teamInfo = team.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			teamName = teamInfo[3] + " " + teamInfo[4];
			teamStatsMap.put(teamName, teamInfo);
		}
	}

	public HashMap<String, String[]> getteamStatsMap(){
		return teamStatsMap;
	}

	public String[] getTeamRankings(){
		int numberOfTeams = teamStatsMap.size();
		String[] rankings = new String[numberOfTeams];
		int i = 0;
		String[] temp;
		String winLoss;
		String rank;
		String store;

		for(String team : teamStatsMap.keySet()){
			temp = teamStatsMap.get(team);
			winLoss = temp[70] +"-"+ temp[71];
			rank = temp[5];
			if(temp[5].length() == 1){
				rank = "0"+rank;
			}
			rankings[i] = String.format("%1$-2s.) %3$-21s %2$-5s", rank, team, winLoss);
			i++;
		}
		Arrays.sort(rankings);

		return rankings;
	}

	/**
	 * This method will take in the rank of a team and return the team's info (name, record, etc.)
	 * @param rank
	 * @return team's info as an array
	 */
	public String[] getTeamInfo(int rank){
		return teamStatsMap.get(rank);
	}

	public ArrayList<Record> getLeagueStandings(){
		String[] rankings = getTeamRankings();
		ArrayList<Record> leagueStandings = new ArrayList<>();

		for(int i=0; i< rankings.length; i++){
			leagueStandings.add(new NbaRecord(parseRankingInfo(rankings[i])));
		}

		return leagueStandings;
	}

	public String[] parseRankingInfo(String rankingInfo){
		return rankingInfo.split("\\s+");
	}

}
