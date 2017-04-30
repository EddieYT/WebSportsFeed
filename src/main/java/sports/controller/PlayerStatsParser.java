package sports.controller;

import org.json.JSONObject;
import sports.model.Player;



/**
 * Created by Eddie on 4/27/17.
 */
public class PlayerStatsParser {
    private static String name;
    private static String requestFormat = "https://www.mysportsfeeds.com/api/feed/pull/nba/" +
            "2016-2017-regular/cumulative_player_stats.json?player=%s";
    private  static  String response = null;

    public static String getPLayerStlPerGame(Player player) {
        name = player.getName().toLowerCase();

        response = APIHandler.getJSONResponse(String.format(requestFormat, name));
        String output = PlayerStatsParser.parseToStats("StlPerGame", response);
        return output;
    }

    public static String getPLayerRebPerGame(Player player) {
        name = player.getName().toLowerCase();
        response = APIHandler.getJSONResponse(String.format(requestFormat, name));
        String output = PlayerStatsParser.parseToStats("RebPerGame", response);
        return output;
    }

    public static String getPLayerAstPerGame(Player player) {
        name = player.getName().toLowerCase();
        response = APIHandler.getJSONResponse(String.format(requestFormat, name));
        String output = PlayerStatsParser.parseToStats("AstPerGame", response);
        return output;
    }

    public static String getPLayerBlkPerGame(Player player) {
        name = player.getName().toLowerCase();
        response = APIHandler.getJSONResponse(String.format(requestFormat, name));
        String output = PlayerStatsParser.parseToStats("BlkPerGame", response);
        return output;
    }

    public static String getPLayerPtsPerGame(Player player) {
        name = player.getName().toLowerCase();
        response = APIHandler.getJSONResponse(String.format(requestFormat, name));
        String output = PlayerStatsParser.parseToStats("PtsPerGame", response);
        return output;
    }

    /**
     * Helper function for extracting specified category from a player's JSON file.
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
}
