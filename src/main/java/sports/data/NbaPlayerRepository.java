package sports.data;

import org.springframework.stereotype.Component;
import sports.model.LeagueStats;
import sports.model.NbaPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class Stores all NbaPlayers as a collection for future use.
 * Created by Eddie on 4/26/17.
 */
@Component
public class NbaPlayerRepository {
    private final List<NbaPlayer> ALL_PLAYERS;

    /**
     * Constructors
     * @throws IOException
     */
    public NbaPlayerRepository() throws IOException {
        ALL_PLAYERS = new ArrayList<NbaPlayer>(Arrays.asList(new LeagueStats().getAllPlayerStats()));
    }

    /**
     * Search for a player by his name in the repository.
     * @param name the player's name
     * @return the NbaPlayer if found, otherwise null
     */
    public NbaPlayer findByName(String name) {
        for (NbaPlayer player: ALL_PLAYERS) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    /**
     * Getter for the list of all players.
     * @return a list of all players
     */
    public List<NbaPlayer> getAllPlayers() {
        return  ALL_PLAYERS;
    }
}
