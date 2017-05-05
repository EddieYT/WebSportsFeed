package sports.model;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class stores all information pertaining to a team.
 * Created by obinnaasinugo on 4/27/17.
 */
public class Team {
    private String name;
    private String topScorer;
    private String topAssister;
    private String topRebounder;
    private String topStealer;
    private String topBlocker;
    private TeamStats teamStats;

    /**
     * Constructor
     * @param name the team's name
     */
    public Team(String name) {
        this.name = name;
        try {
            teamStats = new TeamStats(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the name of the team.
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Gets the name of the team.
     * @return the name
     */
    public String getName(){
        return name;
    }

    /**
     * @return the top5Scorer
     */
    public ArrayList<String> getTop5Scorer() {
        return teamStats.getTop5Scorer();
    }

    /**
     * @return the top5Rebounder
     */
    public ArrayList<String> getTop5Rebounder() {
        return teamStats.getTop5Rebounder();
    }

    /**
     * @return the top5Assistant
     */
    public ArrayList<String> getTop5Assistant() {
        return teamStats.getTop5Assistant();
    }

    /**
     * @return the top5Stealer
     */
    public ArrayList<String> getTop5Stealer() {
        return teamStats.getTop5Stealer();
    }

    /**
     * @return the top5Blocker
     */
    public ArrayList<String> getTop5Blocker() {
        return teamStats.getTop5Blocker();
    }


    /**
     * @return the top5Score
     */
    public ArrayList<String> getTop5Score() {
        return teamStats.getTop5Score();
    }

    /**
     * @return the top5Block
     */
    public ArrayList<String> getTop5Block() {
        return teamStats.getTop5Block();
    }

    /**
     * @return the top5Assist
     */
    public ArrayList<String> getTop5Assist() {
        return teamStats.getTop5Assist();
    }

    /**
     * @return the top5Rebound
     */
    public ArrayList<String> getTop5Rebound() {
        return teamStats.getTop5Rebound();
    }

    /**
     * @return the top5Steal
     */
    public ArrayList<String> getTop5Steal() {
        return teamStats.getTop5Steal();
    }

}
