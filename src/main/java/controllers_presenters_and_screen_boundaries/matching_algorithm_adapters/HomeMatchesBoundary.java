package controllers_presenters_and_screen_boundaries.matching_algorithm_adapters;


import apply_to_group_screens.ApplyToGroupController;
import cancel_application_screens.ViewApplicationsListController;
import controllers_presenters_and_screen_boundaries.leave_and_view_my_groups_adapters.ViewMyGroupsController;
import view_user_public_profile_screens.ViewUserPublicProfileController;

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
    public void setViewUserProfileController(ViewUserPublicProfileController viewUserPublicProfileController);
}
