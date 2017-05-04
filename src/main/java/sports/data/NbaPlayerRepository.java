package sports.data;

import org.springframework.stereotype.Component;
import sports.model.LeagueStats;
import sports.model.NbaPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Eddie on 4/26/17.
 */
@Component
public class NbaPlayerRepository {
    private final List<NbaPlayer> ALL_PLAYERS;

    public NbaPlayerRepository() throws IOException {
        ALL_PLAYERS = new ArrayList<NbaPlayer>(Arrays.asList(new LeagueStats().getAllPlayerStats()));
    }

    public NbaPlayer findByName(String name) {
        for (NbaPlayer player: ALL_PLAYERS) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    public List<NbaPlayer> getAllPlayers() {
        return  ALL_PLAYERS;
    }
}
