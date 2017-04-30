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
            new Player("Lebron-James", "Cavaliers"), new Player("Andre-Drummond", "Pistons"),
            new Player("Anthony-Davis", "Pelicans"), new Player("Buddy-Hield", "Kings"),
            new Player("Carmelo-Anthony", "Knicks"), new Player("Chris-Paul", "Clippers"),
            new Player("Damian-Lillard", "Blazers"), new Player("Dirk-Nowitzki", "Mavericks"),
            new Player("Eric-Bledsoe", "Suns"), new Player("Giannis-Antetokounmpo", "Bucks"),
            new Player("Gordon-Hayward", "Jazz"), new Player("Hassan-Whiteside", "Heat"),
            new Player("Isaiah-Thomas", "Celtics"), new Player("Jimmy-Butler", "Bulls"),
            new Player("Jeremy-Lin", "Nets"), new Player("Joel-Embiid", "76ers"),
            new Player("John-Wall", "Wizards"), new Player("Jordan-Clarkson", "Lakers"),
            new Player("KarlAnthony-Towns", "Timberwolves"), new Player("Kawhi-Leonard", "Spurs"),
            new Player("Kemba-Walker", "Hornets"), new Player("Kyle-Lowry", "Raptors"),
            new Player("Marc-Gasol", "Grizzlies"), new Player("Nikola-Jokic", "Nuggets"),
            new Player("Nikola-Vucevic", "Magic"), new Player("Paul-George", "Pacers"),
            new Player("Paul-Millsap", "Hawks"), new Player("Russell-Westbrook", "Thunder"),
            new Player("Stephen-Curry", "Warriors"), new Player("James-Harden", "Rockets")
    );

    public Player findByName(String name) {
        for (Player player: ALL_PLAYERS) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public List<Player> getAllPlayers() {
        return  ALL_PLAYERS;
    }
}
