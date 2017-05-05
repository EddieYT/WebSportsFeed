package sports.model;

import java.util.Comparator;

/**
 * This class stores all information pertaining to a player.
 * Created by Eddie on 4/26/17.
 */
public class NbaPlayer implements Player{
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
    private ImpactMatrix impactMatrix;

    /**
     * Constructor for NbaPlayer
     * @param name the name of the player
     * @param team the team this player belongs
     * @param impactMatrix the impactMatrix for evaluating a player
     */
    public NbaPlayer(String name, String team, ImpactMatrix impactMatrix) {
        this.name = name;
        this.team = team;
        setImageName();
        setUrlName();
        this.impactMatrix = impactMatrix;
    }

    /**
     * Gets the player's name.
     * @param name the name of the player
     */
    public NbaPlayer(String name) {
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

    public void setName(String name){
        this.name = name;
    }

    public String getName() { return this.name; }

    public String getImageName(){
        return this.imageName;
    }

    public void setImageName(){
        String[] splitName;

        if(this.name.contains(" ")){
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
        if(this.name.contains(" ")){
            splitName = this.name.split(" ");
            splitName[0] =splitName[0].replace("-", "");
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

    public void calculateImpact(){
        this.impact = this.impactMatrix.countImpact(this);
    }
}
