package interface_adapters.cancel_application_adapters;

import use_cases.view_user_applications_use_case.ViewApplicationsListOutputBoundary;
import use_cases.view_user_applications_use_case.ViewApplicationsListResponseModel;

import javax.swing.*;
import java.util.ArrayList;

public class ViewApplicationsListPresenter implements ViewApplicationsListOutputBoundary {
    private final ApplicationsListScreenBoundary applicationListScreen;

    /**
     * The presenter class for the view applications list use case.
     * @param screen the initial empty applications list screen
     */
    public ViewApplicationsListPresenter(ApplicationsListScreenBoundary screen) {
        this.applicationListScreen = screen;
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
        userApplications.setSelectedIndex(-1);
        userApplications.addListSelectionListener(applicationListScreen);
        userApplications.setVisibleRowCount(5);

        applicationListScreen.setUserApplications(userApplications);
        applicationListScreen.setUserApplicationsModel(userApplicationsModel);

    }
}
