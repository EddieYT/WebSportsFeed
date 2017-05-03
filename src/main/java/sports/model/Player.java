package sports.model;

import java.util.Comparator;

/**
 * Created by Eddie on 4/26/17.
 */
public class Player {
    private String name;
    private String imageName;
    private String urlName;
    private String team;
    private String avgPoint;
    private String avgRebound;
    private String avgSteal;
    private String avgBlock;
    private String avgAssist;
    private String position;
    private String height;
    private String weight;
    private double impact;
    private double pointsFactor;
    private double assistsFactor;
    private double reboundsFactor;
    private double stealsFactor;
    private double blocksFactor;


    public Player(String name, String team) {
        this.name = name;
        this.team = team;
        setImageName();
        setUrlName();
        impact = 0;
        pointsFactor = 10;
        assistsFactor = 7;
        reboundsFactor = 5;
        stealsFactor = 2;
        blocksFactor = 2;
    }

    public Player(String name) {
        this.name = name;
    }


    public void setTeam(String team) {
        this.team = team;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getName() { return this.name; }

    public String getImageName(){
        return this.imageName;
    }

    public void setImageName(){
        String[] splitName;

        if(this.name.contains("-")){
            this.imageName = new String(this.name);
            this.imageName = this.imageName.toLowerCase();
        }
        else if(this.name.contains(" ")){
            splitName = this.name.split(" ");
            this.imageName = splitName[0] + "-" + splitName[1];
            this.imageName = this.imageName.toLowerCase();
        }
        else{
            this.imageName = "";
        }
    }

    public String getUrlName(){
        return this.urlName;
    }

    public void setUrlName(){
        String[] splitName;

        if(this.name.contains("-")){
            this.urlName = new String(this.name);
        }
        else if(this.name.contains(" ")){
            splitName = this.name.split(" ");
            this.urlName = splitName[0] + "-" + splitName[1];
        }
        else{
            this.urlName = "";
        }
    }

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

    public double getImpact(){
        return impact;
    }

    public void setImpact(){
        impact = Double.parseDouble(getAvgPoint())*pointsFactor +
                 Double.parseDouble(getAvgAssist())*assistsFactor +
                 Double.parseDouble(getAvgRebound())*reboundsFactor +
                 Double.parseDouble(getAvgSteal())*stealsFactor +
                 Double.parseDouble(getAvgBlock())*blocksFactor;
    }

}
