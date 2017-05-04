package sports.model;

/**
 * Created by obinnaasinugo on 5/3/17.
 */
public interface Player{
    public void setName(String name);
    public void setImageName();
    public void setUrlName();
    public void setTeam(String team);
    public void setHeight(String height);
    public void setWeight(String weight);
    public void setPosition(String position);

    public String getName();
    public String getImageName();
    public String getUrlName();
    public String getTeam();
    public String getHeight();
    public String getWeight();
    public String getPosition();
}