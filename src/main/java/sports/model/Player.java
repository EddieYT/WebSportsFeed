package sports.model;

/**
 * This interface covers basic information pertaining to a player.
 * Created by obinnaasinugo on 5/3/17.
 */
public interface Player{
    /**
     * Sets the name of this player.
     * @param name
     */
    public void setName(String name);

    /**
     * Sets the formatted image name of this player.
     */
    public void setImageName();

    /**
     * Sets the formatted url name of this player.
     */
    public void setUrlName();

    /**
     * Sets the name of this player's team
     * @param team
     */
    public void setTeam(String team);

    /**
     * Sets the height of this player.
     * @param height
     */
    public void setHeight(String height);

    /**
     * Sets the weight of this player.
     * @param weight
     */
    public void setWeight(String weight);

    /**
     * Sets the position of this player.
     * @param position
     */
    public void setPosition(String position);

    /**
     * Gets the name
     * @return the name
     */
    public String getName();

    /**
     * Gets the formatted image name.
     * @return the Image name
     */
    public String getImageName();

    /**
     * Gets the formatted url name.
     * @return the url name
     */
    public String getUrlName();

    /**
     * Gets the name of this team.
     * @return the team's name
     */
    public String getTeam();

    /**
     * Gets the height.
     * @return the height
     */
    public String getHeight();

    /**
     * Gets the weight.
     * @return the wight
     */
    public String getWeight();

    /**
     * Gets the position.
     * @return the position
     */
    public String getPosition();
}