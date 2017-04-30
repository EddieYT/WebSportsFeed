package sports.model;

/**
 * Created by Eddie on 4/26/17.
 */
public class Player {
    private String name;
    private String team;
    private String avgPoint;
    private String avgRebound;
    private String avgSteal;
    private String avgBlock;
    private String avgAssist;

    public Player(String name, String team) {
        this.name = name;
        this.team = team;
    }

    public String getName() { return name; }

    public String getTeam() {
        return team;
    }

    public String getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(String avgPoint) {
        this.avgPoint = avgPoint;
    }

    public String getAvgBlock() {
        return avgBlock;
    }

    public void setAvgBlock(String avgBlock) {
        this.avgBlock = avgBlock;
    }

    public String getAvgRebound() {
        return avgRebound;
    }

    public void setAvgRebound(String avgRebound) {
        this.avgRebound = avgRebound;
    }

    public String getAvgSteal() {
        return avgSteal;
    }

    public void setAvgSteal(String avgSteal) {
        this.avgSteal = avgSteal;
    }

    public String getAvgAssist() {
        return avgAssist;
    }

    public void setAvgAssist(String avgAssist) {
        this.avgAssist = avgAssist;
    }
}
