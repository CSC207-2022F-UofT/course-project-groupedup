package view_and_data_access.screens.matching_algorithm_screens;

import controllers_presenters_and_screen_boundaries.matching_algorithm_adapters.HomeMatchesBoundary;
import controllers_presenters_and_screen_boundaries.matching_algorithm_adapters.MatchingAlgorithmScreenBoundary;
import use_cases.matching_algorithm_use_case.MatchingAlgorithmResponseModel;

import javax.swing.*;
import java.util.List;

/**
 * Organizes the returned data into respective state and sends it to the screen
 */
public class MatchingAlgorithmScreen implements MatchingAlgorithmScreenBoundary {
    HomeMatchesBoundary screen;

    public MatchingAlgorithmScreen(HomeMatchesBoundary screen){
        this.screen = screen;
    }

    @Override
    public void displaySuccess(MatchingAlgorithmResponseModel matchingAlgorithmResponseModel) {
        JOptionPane.showMessageDialog(null, matchingAlgorithmResponseModel.getMatchesUpdatedMessage());
        List<String> groups = matchingAlgorithmResponseModel.getGroups();

        DefaultListModel<String> matchDefaultList = new DefaultListModel<>();
        for(String g : groups){
            matchDefaultList.addElement(g);
        }

        JList<String> matchJList = new JList<>(matchDefaultList);

        matchJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        matchJList.setSelectedIndex(-1);
        matchJList.addListSelectionListener(this.screen);
        screen.setMatches(matchJList);

    }
    @Override
    public void displayFailure(String error){
        JOptionPane.showMessageDialog(null, error);
        DefaultListModel<String> matchDefaultList = new DefaultListModel<>();
        JList<String> matchJList = new JList<>(matchDefaultList);
        screen.setMatches(matchJList);
    }
}

