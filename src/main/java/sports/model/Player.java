package sports.model;

/**
 * Created by Eddie on 4/26/17.
 */
public class Player {
    private String name;
    private String team;
    private double avgPoint;
    private double avgRebound;
    private double avgSteal;
    private double avgBlock;
    private double avgAssist;

    public Player(String name, String team) {
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public double getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(double avgPoint) {
        this.avgPoint = avgPoint;
    }

    public double getAvgRebound() {
        return avgRebound;
    }

    public void setAvgRebound(double avgRebound) {
        this.avgRebound = avgRebound;
    }

    public double getAvgSteal() {
        return avgSteal;
    }

    public void setAvgSteal(double avgSteal) {
        this.avgSteal = avgSteal;
    }

    public double getAvgBlcok() {
        return avgBlock;
    }

    public void setAvgBlcok(double avgBlcok) {
        this.avgBlock = avgBlcok;
    }

    public double getAvgAssist() {
        return avgAssist;
    }

    public void setAvgAssist(double avgAssist) {
        this.avgAssist = avgAssist;
    }
}
