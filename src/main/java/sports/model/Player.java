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
    private double impact;
    private final double pointsFactor;
    private final double assistsFactor;
    private final double reboundsFactor;
    private final double stealsFactor;
    private final double blocksFactor;


    public Player(String name, String team) {
        this.name = name;
        this.team = team;
        impact = 0;
        pointsFactor = 10;
        assistsFactor = 7;
        reboundsFactor = 5;
        stealsFactor = 2;
        blocksFactor = 2;
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

    public double getAvgBlock() {
        return avgBlock;
    }

    public void setAvgBlock(double avgBlcok) {
        this.avgBlock = avgBlcok;
    }

    public double getAvgAssist() {
        return avgAssist;
    }

    public void setAvgAssist(double avgAssist) {
        this.avgAssist = avgAssist;
    }

    public double getImpact(){
        return impact;
    }

    public void setImpact(){
        impact = getAvgPoint()*pointsFactor + getAvgAssist()*assistsFactor +
                 getAvgRebound()*reboundsFactor + getAvgSteal()*stealsFactor +
                 getAvgBlock()*blocksFactor;
    }
}
