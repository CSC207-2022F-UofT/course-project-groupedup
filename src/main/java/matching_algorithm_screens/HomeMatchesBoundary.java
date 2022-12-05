package matching_algorithm_screens;


import apply_to_group_screens.ApplyToGroupController;
import cancel_application_screens.ViewApplicationsListController;
import leave_group_screens.ViewMyGroupsController;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

/**
 * Boundary between Matching Algorithm View and Home Screen
 */
public interface HomeMatchesBoundary extends ListSelectionListener {

    void setMatches(JList<String> matches);
    void setMatchingAlgorithmController(MatchingAlgorithmController matchingAlgorithmController);
    void buildScrollPane();

    public void setViewApplicationsListController(ViewApplicationsListController viewApplicationsListController);

    public void setViewMyGroupsController(ViewMyGroupsController viewMyGroupsController);

    public void applyToGroupController(ApplyToGroupController applyToGroupController);
}
