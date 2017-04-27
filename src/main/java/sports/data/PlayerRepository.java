package sports.data;

import org.springframework.stereotype.Component;
import sports.model.Player;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Eddie on 4/26/17.
 */
@Component
public class PlayerRepository {
    private static final List<Player> ALL_PLAYERS = asList(
            new Player("Lebron-James", "Cavaliers")
    );

    public Player findByName(String name) {
        for (Player player: ALL_PLAYERS) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

//    public List<Player> findByTeam(String team) {
//        List<Player> players = new ArrayList<>();
//        return players;
//    }

    public List<Player> getAllPlayers() {
        return  ALL_PLAYERS;
    }
}
