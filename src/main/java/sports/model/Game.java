package sports.model;

/**
 * Created by obinnaasinugo on 4/29/17.
 */
/**
 * A class to make a game object with information pertaining to each game (opponent, date, time, and location)
 */
public class Game {

    private String opponent;
    private String date;
    private String time;
    private String location;

    /**
     * Constructor for game object
     * @param opponent
     * @param date
     * @param time
     * @param location
     */
    public Game(String opponent, String date, String time, String location) {
        this.opponent = new String(opponent);
        this.date = new String(date);
        this.time = new String(time);
        this.location = new String(location);

    }
    /**
     * get opponent
     * @return
     */
    public String getOpponent() {
        return opponent;
    }
    /**
     * get date
     * @return
     */
    public String getDate() {
        return date;
    }
    /**
     * get time
     * @return
     */
    public String getTime() {
        return time;
    }
    /**
     * get location
     * @return
     */
    public String getLocation() {
        return location;
    }
}