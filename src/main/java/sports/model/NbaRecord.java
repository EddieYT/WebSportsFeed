package sports.model;

/**
 * A class to make a team object with name and team stats
 * Created by obinnaasinugo on 4/29/17.
 */
public class NbaRecord implements Record{

    private final String rank;
    private final String record;
    private String team;

    public NbaRecord(String[] rankingInfo) {
        this.rank = rankingInfo[0];
        this.record = rankingInfo[1];
        this.team = "";

        for(int i = 2; i < rankingInfo.length; i++){
            this.team = this.team + rankingInfo[i] + " ";
        }
    }

    public String getRank() {
        return rank;
    }

    public String getRecord(){
        return record;
    }

    public String getTeam(){
        return team;
    }
}