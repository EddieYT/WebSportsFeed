package sports.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This interface covers basic behaviors of standings
 * Created by obinnaasinugo on 5/3/17.
 */
public interface Standings {
    /**
     * Gets a list of records for teams in the league.
     * @return a list of records
     */
    public ArrayList<Record> getLeagueStandings();

    /**
     * Gets an array of ranking info of a team
     * @return
     */
    public String[] getTeamRankings();
}
