package sports.model;

/**
 * Game interface covers the basic behaviors of a game.
 * Created by obinnaasinugo on 5/3/17.
 */
public interface Game{
    /**
     * get opponent
     * @return
     */
    public String getOpponent();
    /**
     * get date
     * @return
     */
    public String getDate();
    /**
     * get time
     * @return
     */
    public String getTime();
    /**
     * get location
     * @return
     */
    public String getLocation();
}