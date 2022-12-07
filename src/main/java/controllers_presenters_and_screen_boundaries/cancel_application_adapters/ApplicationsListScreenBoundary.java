package controllers_presenters_and_screen_boundaries.cancel_application_adapters;

import controllers_presenters_and_screen_boundaries.view_group_profile_adapters.ViewGroupProfileController;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

/**
 * The interface with methods implemented by the "Applications List" screen.
 */
public interface ApplicationsListScreenBoundary extends ListSelectionListener {
    void setUserApplications(JList<String> userApplications);

    void setUserApplicationsModel(DefaultListModel<String> userApplicationsModel);

    void setCancelApplicationController(CancelApplicationController cancelApplicationController);

    void setViewGroupController(ViewGroupProfileController viewGroupProfileController);

    void view();

    void buildButtons();

    void buildScrollPane();
}
