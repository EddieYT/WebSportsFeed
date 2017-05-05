package sports.data;

import org.springframework.stereotype.Component;
import sports.model.Team;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * This class Stores all Teams as a collection for future use.
 * Created by obinnaasinugo on 4/27/17.
 */
@Component
public class TeamRepository {
    private static final List<Team> ALL_TEAMS = asList(
            new Team("76ers"),
            new Team("Trail Blazers"),
            new Team("Bucks"),
            new Team("Bulls"),
            new Team("Cavaliers"),
            new Team("Celtics"),
            new Team("Clippers"),
            new Team("Grizzlies"),
            new Team("Hawks"),
            new Team("Heat"),
            new Team("Hornets"),
            new Team("Jazz"),
            new Team("Kings"),
            new Team("Knicks"),
            new Team("Lakers"),
            new Team("Magic"),
            new Team("Mavericks"),
            new Team("Nets"),
            new Team("Nuggets"),
            new Team("Pacers"),
            new Team("Pistons"),
            new Team("Raptors"),
            new Team("Rockets"),
            new Team("Spurs"),
            new Team("Suns"),
            new Team("Thunder"),
            new Team("Timberwolves"),
            new Team("Warriors"),
            new Team("Wizards")
    );

    /**
     * Search for a team by it's name in the repository.
     * @param name the team's name
     * @return the Team if found, otherwise null
     */
    public Team findByName(String name) {
        for (Team team: ALL_TEAMS) {
            if (team.getName().equalsIgnoreCase(name)) {
                return team;
            }
        }
        return null;
    }

    /**
     * Getter for the list of all teams
     * @return a list of all teams
     */
    public List<Team> getAllTeams() {
        return  ALL_TEAMS;
    }
}
