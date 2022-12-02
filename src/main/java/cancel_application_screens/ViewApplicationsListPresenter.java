package cancel_application_screens;

import view_user_applications_use_case.ViewApplicationsListOutputBoundary;
import view_user_applications_use_case.ViewApplicationsListResponseModel;

import javax.swing.*;
import java.util.ArrayList;

public class ViewApplicationsListPresenter implements ViewApplicationsListOutputBoundary {
    private final ApplicationsListScreenBoundary screen;

    /**
     * @param screen the initial empty pending list screen
     */
    public ViewApplicationsListPresenter(ApplicationsListScreenBoundary screen) {
        this.screen = screen;
    }

    @Override
    public void prepareSuccessView(ViewApplicationsListResponseModel responseModel) {
        DefaultListModel<String> userApplicationsModel = new DefaultListModel<>();
        ArrayList<String> groupNames = responseModel.getApplicationsList();
        for (String groupName : groupNames) {
            userApplicationsModel.addElement(groupName);
        }

        JList<String> userApplications = new JList<>(userApplicationsModel);
        userApplications.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        userApplications.setSelectedIndex(0);
        userApplications.addListSelectionListener(screen);
        userApplications.setVisibleRowCount(5);

        screen.setUserApplications(userApplications);
        screen.setUserApplicationsModel(userApplicationsModel);
    }
}
