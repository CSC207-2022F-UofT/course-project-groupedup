package cancel_application_screens;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

public interface ApplicationsListScreenBoundary extends ListSelectionListener {
    void setUserApplications(JList<String> userApplications);

    void setUserApplicationsModel(DefaultListModel<String> userApplicationsModel);

    void setCancelApplicationController(CancelApplicationController cancelApplicationController);

    void setViewApplicationsListController(ViewApplicationsListController viewApplicationsListController);

    void view();

    void buildButtons();

    void buildScrollPane();
}
