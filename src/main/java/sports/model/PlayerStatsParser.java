package sports.model;

import org.json.JSONObject;


/**
 * Created by Eddie on 4/27/17.
 */
public class PlayerStatsParser {
    private static String name;
    private static String requestStats = "https://www.mysportsfeeds.com/api/feed/pull/nba/" +
            "2016-2017-regular/cumulative_player_stats.json?player=%s";
    private static String requestInfo = "https://www.mysportsfeeds.com/api/feed/pull/nba/" +
            "2016-2017-regular/active_players.json?player=%s";
    private  static  String response = null;

    public static String getPLayerStlPerGame(Player player) {
        name = player.getName().toLowerCase();

        response = APIHandler.getJSONResponse(String.format(requestStats, name));
        String output = PlayerStatsParser.parseToStats("StlPerGame", response);
        return output;
    }

    public static String getPLayerRebPerGame(Player player) {
        name = player.getName().toLowerCase();
        response = APIHandler.getJSONResponse(String.format(requestStats, name));
        String output = PlayerStatsParser.parseToStats("RebPerGame", response);
        return output;
    }

    public static String getPLayerAstPerGame(Player player) {
        name = player.getName().toLowerCase();
        response = APIHandler.getJSONResponse(String.format(requestStats, name));
        String output = PlayerStatsParser.parseToStats("AstPerGame", response);
        return output;
    }

    public static String getPLayerBlkPerGame(Player player) {
        name = player.getName().toLowerCase();
        response = APIHandler.getJSONResponse(String.format(requestStats, name));
        String output = PlayerStatsParser.parseToStats("BlkPerGame", response);
        return output;
    }

    public static String getPLayerPtsPerGame(Player player) {
        name = player.getName().toLowerCase();
        response = APIHandler.getJSONResponse(String.format(requestStats, name));
        String output = PlayerStatsParser.parseToStats("PtsPerGame", response);
        return output;
    }

    public static String getPlayerHeight(Player player) {
        return PlayerStatsParser.getPlayerInfo(player, "Height");
    }

    public static String getPlayerWeight(Player player) {
        return PlayerStatsParser.getPlayerInfo(player, "Weight");
    }

    public static String getPlayerPosition(Player player) {
        return PlayerStatsParser.getPlayerInfo(player, "Position");
    }

    public static String getPlayerTeam(Player player) {
        name = player.getName().toLowerCase();
        response = APIHandler.getJSONResponse(String.format(requestInfo, name));
        String output = PlayerStatsParser.parseToPlayerTeam(response);
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
        name = player.getName().toLowerCase();
        response = APIHandler.getJSONResponse(String.format(requestInfo, name));
        String output = PlayerStatsParser.parseToProfile(info, response);
        return output;
    }
}
