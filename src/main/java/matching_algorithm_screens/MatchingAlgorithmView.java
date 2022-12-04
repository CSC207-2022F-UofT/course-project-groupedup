package matching_algorithm_screens;

import matching_algorithm_use_case.MatchingAlgorithmResponseModel;

import javax.swing.*;
import java.util.List;

/**
 * Bundles the returned data into respective state and sends it to the screen
 */
public class MatchingAlgorithmView implements MatchingAlgorithmViewModel {
    HomeMatchesBoundary screen;

    public MatchingAlgorithmView(HomeMatchesBoundary screen){
        this.screen = screen;
    }

    @Override
    public void displaySuccess(MatchingAlgorithmResponseModel matchingAlgorithmResponseModel) {
        List<String> groups = matchingAlgorithmResponseModel.getGroups();
        //Make them into a default list
        DefaultListModel<String> matchDefaultList = new DefaultListModel<>();
        for(String g : groups){
            matchDefaultList.addElement(g);
        }

        JList<String> matchJList = new JList<>(matchDefaultList);

        matchJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //No initial selection
        matchJList.setSelectedIndex(-1);
        matchJList.addListSelectionListener(this.screen);
        screen.setMatches(matchJList);

    }
    @Override
    public void displayFailure(String error){
        throw new MatchingAlgorithmFailed(error);
    }
}

