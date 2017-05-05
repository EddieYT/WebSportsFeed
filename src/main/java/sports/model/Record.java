package sports.model;

/**
 * The interface covers the basic behaviors of a team's record.
 * Created by obinnaasinugo on 5/3/17.
 */
public interface Record{
    /**
     * Gets the team's rank
     * @return the rank
     */
    public String getRank();

    /**
     * Gets the team's records.
     * @return the record
     */
    public String getRecord();

    /**
     * Gets the team's name
     * @return the team
     */
    public String getTeam();

}