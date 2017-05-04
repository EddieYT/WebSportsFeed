package sports.data;

import org.springframework.stereotype.Component;
import sports.model.LeagueStats;
import sports.model.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Eddie on 4/26/17.
 */
@Component
public class PlayerRepository {
    private final List<Player> ALL_PLAYERS;

    public PlayerRepository() throws IOException {
        ALL_PLAYERS = new ArrayList<Player>(Arrays.asList(new LeagueStats().getAllPlayerStats()));
    }

    public Player findByName(String name) {
        for (Player player: ALL_PLAYERS) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    public List<Player> getAllPlayers() {
        return  ALL_PLAYERS;
    }
}
