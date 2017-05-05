package sports.model;

import org.json.JSONObject;


/**
 * This class parses the JSON string for a player to extract related information.
 * Created by Eddie on 4/27/17.
 */
public class PlayerStatsParser {
    private static String name;
    private static String requestStats = "https://www.mysportsfeeds.com/api/feed/pull/nba/" +
            "2016-2017-regular/cumulative_player_stats.json?player=%s";
    private static String requestInfo = "https://www.mysportsfeeds.com/api/feed/pull/nba/" +
            "2016-2017-regular/active_players.json?player=%s";
    private  static  String responseStats = null;
    private  static  String responseInfo = null;
    private static String timeStamp = null;

    /**
     * This method sets all information pertaining to a player.
     * @param player
     */
    public static void setAllPlayerInfo(Player player) {
        name = player.getUrlName().toLowerCase();
        responseStats = APIHandler.getJSONResponse(String.format(requestStats, name));
        responseInfo = APIHandler.getJSONResponse(String.format(requestInfo, name));
        if (player.getClass().equals(NbaPlayer.class)) {
            NbaPlayer nbaPlayer = (NbaPlayer) player;
            nbaPlayer.setAvgAssist(PlayerStatsParser.getPLayerAstPerGame(player));
            nbaPlayer.setAvgBlock(PlayerStatsParser.getPLayerBlkPerGame(player));
            nbaPlayer.setAvgPoint(PlayerStatsParser.getPLayerPtsPerGame(player));
            nbaPlayer.setAvgRebound(PlayerStatsParser.getPLayerRebPerGame(player));
            nbaPlayer.setAvgSteal(PlayerStatsParser.getPLayerStlPerGame(player));
        }
        player.setHeight(PlayerStatsParser.getPlayerHeight(player));
        player.setWeight(PlayerStatsParser.getPlayerWeight(player));
        player.setPosition(PlayerStatsParser.getPlayerPosition(player));
        player.setTeam(PlayerStatsParser.getPlayerTeam(player));
    }

    /**
     * Gets the player's Steal Per Game from JSON.
     * @param player
     * @return
     */
    public static String getPLayerStlPerGame(Player player) {
        String output = PlayerStatsParser.parseToStats("StlPerGame", responseStats);
        return output;
    }

    /**
     * Gets the player's Rebound Per Game.
     * @param player
     * @return
     */
    public static String getPLayerRebPerGame(Player player) {
        String output = PlayerStatsParser.parseToStats("RebPerGame", responseStats);
        return output;
    }

    /**
     * Gets the player's Assist Per Game.
     * @param player
     * @return
     */
    public static String getPLayerAstPerGame(Player player) {
        String output = PlayerStatsParser.parseToStats("AstPerGame", responseStats);
        return output;
    }

    /**
     * Gets the player's Block Per Game.
     * @param player
     * @return
     */
    public static String getPLayerBlkPerGame(Player player) {
        String output = PlayerStatsParser.parseToStats("BlkPerGame", responseStats);
        return output;
    }

    /**
     * Gets the player's Points Per Game.
     * @param player
     * @return
     */
    public static String getPLayerPtsPerGame(Player player) {
        String output = PlayerStatsParser.parseToStats("PtsPerGame", responseStats);
        return output;
    }

    /**
     * Gets the player's height.
     * @param player
     * @return
     */
    public static String getPlayerHeight(Player player) {
        return PlayerStatsParser.getPlayerInfo(player, "Height");
    }

    /**
     * Gets the player's weight.
     * @param player
     * @return
     */
    public static String getPlayerWeight(Player player) {
        return PlayerStatsParser.getPlayerInfo(player, "Weight");
    }

    /**
     * Gets the player's position.
     * @param player
     * @return
     */
    public static String getPlayerPosition(Player player) {
        return PlayerStatsParser.getPlayerInfo(player, "Position");
    }

    /**
     * Gets the player's team.
     * @param player
     * @return
     */
    public static String getPlayerTeam(Player player) {
        String output = PlayerStatsParser.parseToPlayerTeam(responseInfo);
        return output;
    }

    /**
     * Helper function for extracting specified statistic from a player's JSON file.
     * @param category the category of statistics
     * @param input the JSON string response
     * @return the output of stats
     */
    private static String parseToStats(String category, String input) {
        JSONObject obj = new JSONObject(input);
        JSONObject obj1 = (JSONObject) obj.getJSONObject("cumulativeplayerstats").getJSONArray("playerstatsentry").get(0);
        JSONObject stats = obj1.getJSONObject("stats");
        String output =  stats.getJSONObject(category).getString("#text");
        return output;
    }

    /**
     * Helper function for extracting specified category from a player's profile JSON file.
     * @param category the category of a profile
     * @param input the JSON string response
     * @return the specified profile info
     */
    private static String parseToProfile(String category, String input) {
        JSONObject obj = new JSONObject(input);
        JSONObject obj1 = (JSONObject) obj.getJSONObject("activeplayers").getJSONArray("playerentry").get(0);
        timeStamp = obj.getJSONObject("activeplayers").getString("lastUpdatedOn");
        JSONObject playerInfo = obj1.getJSONObject("player");
        String output =  playerInfo.getString(category);
        return output;
    }

    /**
     * Helper function for extracting team from a player's profile JSON file.
     * @param input the JSON string response
     * @return team's name
     */
    private static String parseToPlayerTeam(String input) {
        JSONObject obj = new JSONObject(input);
        JSONObject obj1 = (JSONObject) obj.getJSONObject("activeplayers").getJSONArray("playerentry").get(0);
        JSONObject playerInfo = obj1.getJSONObject("team");
        String output =  playerInfo.getString("Name");
        return output;
    }

    /**
     * Helper function for getting a player's specified info.
     * @param player the player
     * @param info the aimed category of the profile
     * @return the corresponding info
     */
    private static String getPlayerInfo(Player player, String info) {
        String output = PlayerStatsParser.parseToProfile(info, responseInfo);
        return output;
    }

    /**
     * Gets when the data updated last time.
     * @return timestamp
     */
    public static String getTimeStamp() {
        return "Last updated on: : "+ timeStamp;
    }
}
