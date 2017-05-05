package sports.model;

/**
 * A class to make a game object with information pertaining to each game (opponent, date, time, and location)
 * Created by obinnaasinugo on 4/29/17.
 */
public class NbaGame implements Game{

    private String opponent;
    private String date;
    private String time;
    private String location;

    /**
     * Constructor for game object
     * @param opponent the opponent's name
     * @param date the date
     * @param time the starting time of this match
     * @param location the location of this match
     */
    public NbaGame(String opponent, String date, String time, String location) {
        this.opponent = new String(opponent);
        this.date = new String(date);
        this.time = new String(time);
        this.location = new String(location);

    }
    /**
     * Gets opponent
     * @return opponent's name
     */
    public String getOpponent() {
        return opponent;
    }
    /**
     * Gets date
     * @return the date of match
     */
    public String getDate() {
        return date;
    }
    /**
     * Gets time
     * @return the starting time of this game
     */
    public String getTime() {
        return time;
    }
    /**
     * Gets location
     * @return the location of this game
     */
    public String getLocation() {
        return location;
    }
}