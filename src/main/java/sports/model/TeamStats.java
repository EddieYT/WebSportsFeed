package sports.model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class will store the performance of all players for a specified
 * team.
 * 
 * @author Eddie
 *
 */

public class TeamStats {
	private FileDownloader dl;
	private FileReaderv3 cumu;
	private String teamName;
	private ArrayList<String> lines;
	private HashMap<String, Double> scores;
	private HashMap<String, Double> rebounds;
	private HashMap<String, Double> assists;
	private HashMap<String, Double> steals;
	private HashMap<String, Double> blocks;

	private ArrayList<String> top5Scorer;
	private ArrayList<String> top5Rebounder;
	private ArrayList<String> top5Assistant;
	private ArrayList<String> top5Stealer;
	private ArrayList<String> top5Blocker;

	private ArrayList<String>top5Score;
	private ArrayList<String>top5Block;
	private ArrayList<String>top5Assist;
	private ArrayList<String>top5Rebound;
	private ArrayList<String>top5Steal;

	/**
	 * Constructor will read in cumulative_player_stats.csv and store it to
	 * lines for further parsing.
	 * 
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public TeamStats(String team) throws MalformedURLException, IOException {
		dl = new FileDownloader("src/main/resources/");
		dl.cumulativePlayers();
		cumu = new FileReaderv3("src/main/resources/cumulative_player_stats.csv");
		lines = cumu.getLines();
		teamName = team;
		blocks = new HashMap<String, Double>();
		rebounds = new HashMap<String, Double>();
		assists = new HashMap<String, Double>();
		steals = new HashMap<String, Double>();
		scores = new HashMap<String, Double>();

		top5Scorer = new ArrayList<String>();
		top5Rebounder = new ArrayList<String>();
		top5Stealer = new ArrayList<String>();
		top5Assistant = new ArrayList<String>();
		top5Blocker = new ArrayList<String>();

		top5Score = new ArrayList<String>();
		top5Block = new ArrayList<String>();
		top5Assist = new ArrayList<String>();
		top5Rebound = new ArrayList<String>();
		top5Steal = new ArrayList<String>();

		scoresGenerator();
		blocksGenerator();
		stealsGenerator();
		assistsGenerator();
		reboundsGenerator();
		top5Generator(scores, top5Scorer);
		top5Generator(rebounds, top5Rebounder);
		top5Generator(assists, top5Assistant);
		top5Generator(steals, top5Stealer);
		top5Generator(blocks, top5Blocker);

		allStatsGenerator();
	}

	/**
	 * This method will generate top5 team players of specified category in an ArrayList
	 * @param input the HashMap for specified category of team stats
	 * @param stats	the specified Top5 category we want to generate 
	 */
	private void top5Generator(HashMap <String, Double> input, ArrayList<String> stats) {
		for (String name : input.keySet()){
			if (stats.isEmpty()) {
				stats.add(name);
			} else {
				int i = 0;
				for (String rank: stats) {
					if ( input.get(name) >= input.get(rank) ) {
						if (stats.size() < 5) {
							stats.add(i, name);
							break;
						} else {
							stats.remove(4);
							stats.add(i, name);
							break;
						}
					} 
					i++;
				}
				if (stats.size() < 5) {
					stats.add(name) ;
				}
			}
		}

	}

	private void allStatsGenerator() {
		for(String name: top5Scorer) {
			top5Score.add(this.getScores().get(name).toString());
		}

		for(String name: top5Blocker) {
			top5Block.add(this.getBlocks().get(name).toString());
		}

		for(String name: top5Assistant) {
			top5Assist.add(this.getAssists().get(name).toString());
		}
		for(String name: top5Rebounder) {
			top5Rebound.add(this.getRebounds().get(name).toString());
		}

		for(String name: top5Stealer) {
			top5Steal.add(this.getSteals().get(name).toString());
		}
	}


	/**
	 * This method will generate a HashMap list storing team players and BPG.
	 */
	private void blocksGenerator() {
		for(String line: lines) {
			String[] str = line.split(",");
			if (str.length < 19) {
				continue;
			}
			else if ( str[16].equalsIgnoreCase(teamName) ) {
				blocks.put(str[3] + " " + str[2], Double.parseDouble(str[53]));
			} else if ( str[17].equalsIgnoreCase(teamName) ) {
				blocks.put(str[3] + " " + str[2], Double.parseDouble(str[54]));
			}
		}
	}
	/**
	 * This method will generate a HashMap list storing team players and PPG.
	 */
	private void scoresGenerator() {
		for(String line: lines) {
			String[] str = line.split(",");
			if (str.length < 19) {
				continue;
			} else if ( str[16].equalsIgnoreCase(teamName) ) {
				scores.put(str[3] + " " + str[2], Double.parseDouble(str[47]));
			} else if ( str[17].equalsIgnoreCase(teamName) ) {
				scores.put(str[3] + " " + str[2], Double.parseDouble(str[48]));
			}
		}
	}

	/**
	 * This method will generate a HashMap list storing team players and SPG.
	 */
	private void stealsGenerator() {
		for(String line: lines) {
			String[] str = line.split(",");
			if (str.length < 19) {
				continue;
			}
			else if ( str[16].equalsIgnoreCase(teamName) ) {
				steals.put(str[3] + " " + str[2], Double.parseDouble(str[51]));
			} else if ( str[17].equalsIgnoreCase(teamName) ) {
				steals.put(str[3] + " " + str[2], Double.parseDouble(str[52]));
			}
		}
	}

	/**
	 * This method will generate a HashMap list storing team players and APG.
	 */
	private void assistsGenerator() {
		for(String line: lines) {
			String[] str = line.split(",");
			if (str.length < 19) {
				continue;
			}
			else if ( str[16].equalsIgnoreCase(teamName) ) {
				assists.put(str[3] + " " + str[2], Double.parseDouble(str[45]));
			} else if ( str[17].equalsIgnoreCase(teamName) ) {
				assists.put(str[3] + " " + str[2], Double.parseDouble(str[46]));
			}
		}
	}

	/**
	 * This method will generate a HashMap list storing team players and RPG.
	 */
	private void reboundsGenerator() {
		for(String line: lines) {
			String[] str = line.split(",");
			if (str.length < 19) {
				continue;
			}
			else if ( str[16].equalsIgnoreCase(teamName) ) {
				rebounds.put(str[3] + " " + str[2], Double.parseDouble(str[43]));
			} else if ( str[17].equalsIgnoreCase(teamName) ) {
				rebounds.put(str[3] + " " + str[2], Double.parseDouble(str[44]));
			}
		}
	}

	/**
	 * @return the blocks
	 */
	public HashMap<String, Double> getBlocks() {
		return blocks;
	}


	/**
	 * @return the scores
	 */
	public HashMap<String, Double> getScores() {
		return scores;
	}

	/**
	 * @return the rebounds
	 */
	public HashMap<String, Double> getRebounds() {
		return rebounds;
	}

	/**
	 * @return the assists
	 */
	public HashMap<String, Double> getAssists() {
		return assists;
	}

	/**
	 * @return the steals
	 */
	public HashMap<String, Double> getSteals() {
		return steals;
	}

	/**
	 * @return the top5Scorer
	 */
	public ArrayList<String> getTop5Scorer() {
		return top5Scorer;
	}

	/**
	 * @return the top5Rebounder
	 */
	public ArrayList<String> getTop5Rebounder() {
		return top5Rebounder;
	}

	/**
	 * @return the top5Assistant
	 */
	public ArrayList<String> getTop5Assistant() {
		return top5Assistant;
	}

	/**
	 * @return the top5Stealer
	 */
	public ArrayList<String> getTop5Stealer() {
		return top5Stealer;
	}

	/**
	 * @return the top5Blocker
	 */
	public ArrayList<String> getTop5Blocker() {
		return top5Blocker;
	}


	/**
	 * @return the top5Score
	 */
	public ArrayList<String> getTop5Score() {
		return top5Score;
	}

	/**
	 * @return the top5Block
	 */
	public ArrayList<String> getTop5Block() {
		return top5Block;
	}

	/**
	 * @return the top5Assist
	 */
	public ArrayList<String> getTop5Assist() {
		return top5Assist;
	}

	/**
	 * @return the top5Rebound
	 */
	public ArrayList<String> getTop5Rebound() {
		return top5Rebound;
	}

	/**
	 * @return the top5Steal
	 */
	public ArrayList<String> getTop5Steal() {
		return top5Steal;
	}

}
