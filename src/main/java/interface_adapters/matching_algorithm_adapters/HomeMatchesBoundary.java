package interface_adapters.matching_algorithm_adapters;


import interface_adapters.apply_to_group_adapters.ApplyToGroupController;
import interface_adapters.cancel_application_adapters.ViewApplicationsListController;
import interface_adapters.leave_and_view_my_groups_adapters.ViewMyGroupsController;
import interface_adapters.view_user_public_profile_adapters.ViewUserPublicProfileController;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

/**
 * Boundary between Matching Algorithm View and Home Screen
 */
public interface HomeMatchesBoundary extends ListSelectionListener {

    void setMatches(JList<String> matches);
    void setMatchingAlgorithmController(MatchingAlgorithmController matchingAlgorithmController);
    void buildScrollPane();

    void setViewApplicationsListController(ViewApplicationsListController viewApplicationsListController);

    void setViewMyGroupsController(ViewMyGroupsController viewMyGroupsController);

    void setApplyToGroupController(ApplyToGroupController applyToGroupController);
    void setViewUserProfileController(ViewUserPublicProfileController viewUserPublicProfileController);

    void setUsername(String username);
    }

