package matching_algorithm_screens;

import Entities.*;
import matching_algorithm_use_case.MatchingAlgorithmDsGateWay;

import java.util.HashMap;

/**
 * Mock repo for Matching Algorithm testing. No groups for fail case
 */
public class InMemoryMatchesFail implements MatchingAlgorithmDsGateWay {
    User user;

    public InMemoryMatchesFail(){

    }

    @Override
    public User getUser(String username) {
        UserPublicProfile userPublicProfile = new UserPublicProfile();
        User user = new NormalUser("username", "password", "name", "emai@gmail.com",
                userPublicProfile);
        HashMap<String, String> preferences1 = new HashMap<>();
        preferences1.put("Remote or In-Person", "Remote");
        preferences1.put("Lays or Ruffles", "Ruffles");
        preferences1.put("Chocolate", "Yes");
        preferences1.put("Summer or Winter", "Summer");
        user.getUserPublicProfile().setCoursePreferences("csc236, csc207");
        this.user = user;

        return user;
    }

    @Override
    public HashMap<String, Group> loadGroups() {
        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUser(user);

        return new HashMap<String, Group>();
    }
}

