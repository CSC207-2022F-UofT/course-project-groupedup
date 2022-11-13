package matching_algorithm_use_case;

import Entities.Group;
import Entities.User;
import Entities.UserMatches.UserMatches;

import java.util.ArrayList;
import java.util.List;
/**
 * Description: The matching algorithm use case interactor. It will get groups from the DsGateWay. If the list of groups
 * is empty it will have the presenter report error. Otherwise, it will make a UserMatches instance to rank the groups
 * according to similarity with the user's preferences. After that, the interactor will make a list of the groups' as
 * Strings and return a success message and the list to Presenter.
 *
 * */

public class MatchingAlgorithmInteractor implements MatchingAlgorithmInputBoundary{

    final MatchingAlgorithmPresenter matchingAlgorithmPresenter;
    final MatchingAlgorithmDsGateWay matchingAlgorithmDsGateWay;
    final User currentUser;

    public MatchingAlgorithmInteractor(MatchingAlgorithmPresenter presenter,
                                       MatchingAlgorithmDsGateWay dsGateWay, User user){
        this.matchingAlgorithmPresenter = presenter;
        this.matchingAlgorithmDsGateWay = dsGateWay;
        this.currentUser = user;

    }

    @Override
    public MatchingAlgorithmResponseModel create(MatchingAlgorithmRequestModel requestModel) {
            //This might change based on serialization
            //If we decide to do a csv, this might be a list of strings and I will have to manually make the groups
            //so would probably need a GroupFactory interface
            List<Group> groups = matchingAlgorithmDsGateWay.getGroups();
            if (groups.isEmpty()) {
                return matchingAlgorithmPresenter.prepareFailView("No Matches Found");
            }
            UserMatches userMatches = new UserMatches(currentUser, groups);
            groups = userMatches.getMatches();
            List<String> groupsAsString = new ArrayList<>();
            for (Group g : groups) {
                groupsAsString.add(g.toString());
            }
            MatchingAlgorithmResponseModel matchingAlgorithmResponseModel =
                    new MatchingAlgorithmResponseModel("Matches Updated", groupsAsString);

            return matchingAlgorithmPresenter.prepareSuccessView(matchingAlgorithmResponseModel);
    }
}
