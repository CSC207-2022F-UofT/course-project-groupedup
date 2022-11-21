package matching_algorithm_use_case;

import Entities.Group;
import Entities.User;
import Entities.UserMatches.UserMatches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * The matching algorithm use case interactor. It will get groups from the DsGateWay. If the list of groups
 * is empty it will have the presenter report error. Otherwise, it will make a UserMatches instance to rank the groups
 * according to similarity with the user's preferences. Next, the interactor will make a list of the groups' as
 * Strings and return a success message and the list to Presenter
 * */

public class MatchingAlgorithmInteractor implements MatchingAlgorithmInputBoundary{

    final MatchingAlgorithmOutputBoundary matchingAlgorithmOutputBoundary;
    final MatchingAlgorithmDsGateWay matchingAlgorithmDsGateWay;

    public MatchingAlgorithmInteractor(MatchingAlgorithmOutputBoundary presenter,
                                       MatchingAlgorithmDsGateWay dsGateWay){
        this.matchingAlgorithmOutputBoundary = presenter;
        this.matchingAlgorithmDsGateWay = dsGateWay;

    }

    /**
     * matchGroups() has the purpose of interacting with the entities, and provide appropriate return value for the
     * Matching Algorithm Use Case
     * @param requestModel: gets the current User's username
     * @return fail or success message Output Boundary
     */
    @Override
    public MatchingAlgorithmResponseModel matchGroups(MatchingAlgorithmRequestModel requestModel) {
            User currentUser = matchingAlgorithmDsGateWay.loadUser(requestModel.getUsername());
            HashMap<String, Group> groupMap = matchingAlgorithmDsGateWay.loadGroups();

            List<Group> groups = (List<Group>) groupMap.values();
            if (groups.isEmpty()) {
                return matchingAlgorithmOutputBoundary.prepareFailView("No Matches Found");
            }
            UserMatches userMatches = new UserMatches(currentUser, groups);
            groups = userMatches.getMatchesWithoutScore();
            List<String> groupsAsString = new ArrayList<>();
            for (Group g : groups) {
                groupsAsString.add(g.toString());
            }
            MatchingAlgorithmResponseModel matchingAlgorithmResponseModel =
                    new MatchingAlgorithmResponseModel("Matches Updated", groupsAsString);

            return matchingAlgorithmOutputBoundary.prepareSuccessView(matchingAlgorithmResponseModel);
    }
}
