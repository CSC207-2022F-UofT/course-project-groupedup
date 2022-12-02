import Entities.*;
import cancel_application_screens.*;
import cancel_application_use_case.CancelApplicationDsGateway;
import cancel_application_use_case.CancelApplicationInputBoundary;
import cancel_application_use_case.CancelApplicationInteractor;
import cancel_application_use_case.CancelApplicationOutputBoundary;
import view_user_applications_use_case.ViewApplicationsListDsGateway;
import view_user_applications_use_case.ViewApplicationsListInputBoundary;
import view_user_applications_use_case.ViewApplicationsListInteractor;
import view_user_applications_use_case.ViewApplicationsListOutputBoundary;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

//        // Build the main program window
//        JFrame application = new JFrame("GroupedUp");
//        CardLayout cardLayout = new CardLayout();
//        JPanel screens = new JPanel(cardLayout);
//        application.add(screens);
//
//        // Create the parts to plug into the Use Case+Entities engine
//        SerializeDataAccess dataAccess = new SerializeDataAccess();
//
//        LeaveGroupOutputBoundary leaveGroupPresenter = new LeaveGroupPresenter(cardLayout, screens);
//        LeaveGroupInputBoundary inputBoundary = new LeaveGroupInteractor(dataAccess, leaveGroupPresenter);
//        LeaveGroupController leaveGroupController = new LeaveGroupController(inputBoundary);
//
//        CancelApplicationOutputBoundary cancelApplicationPresenter = new CancelApplicationPresenter();
//        CancelApplicationInputBoundary cancelApplicationInputBoundary = new CancelApplicationInteractor(dataAccess, cancelApplicationPresenter);
//        CancelApplicationController cancelApplicationController = new CancelApplicationController(cancelApplicationInputBoundary);
//
//        LoginOutputBoundary loginPresenter = new LoginPresenter();
//        LoginInputBoundary loginInteractor = new LoginInteractor(dataAccess, loginPresenter);
//        LoginController loginController = new LoginController(loginInteractor);
//
//        // Build the GUI, plugging in the parts
//        LeaveGroupScreen leaveGroupScreen =  new LeaveGroupScreen(
//                "aarya",
//                "aarya's group",
//                leaveGroupController);
//        LoginScreen loginScreen = new LoginScreen();
//        screens.add(leaveGroupScreen, "Leave Group");
//        screens.add(loginScreen, "Login");
//        cardLayout.show(screens, "Leave Group");
//        application.setVisible(true);

        String groupName = "PAUL FAN CLUB";
        String groupName2 = "236 pset pals";
        String groupName3 = "multivariable calcoholics";
        String username = "paul gries";
        String username2 = "aarya";

        User user = new NormalUser(username, "pw", "Paul", "paul@gmail.com",
                new UserPublicProfile());
        User user2 = new NormalUser(username2, "pw", "Aarya", "aarya@gmail.com",
                new UserPublicProfile());

        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUser(user);
        Group group = new NormalGroup(groupName);
        Group group2 = new NormalGroup(groupName2);
        currentUser.setUser(user2);
        Group group3 = new NormalGroup(groupName3);

        group.addRequest(username2);
        group2.addRequest(username2);
        user2.getApplicationsList().put(groupName, groupName);
        user2.getApplicationsList().put(groupName2, groupName2);

        HashMap<String, User> userMap = new HashMap<>();
        userMap.put(username, user);
        userMap.put(username2, user2);

        HashMap<String, Group> groupMap = new HashMap<>();
        groupMap.put(groupName, group);
        groupMap.put(groupName2, group2);
        groupMap.put(groupName3, group3);

        ViewApplicationsListDsGateway viewAppDsGateway = new CancelApplicationDataAccess(userMap, groupMap);
        CancelApplicationDsGateway cancelAppDsGateway = new CancelApplicationDataAccess(userMap, groupMap);

        CancelApplicationOutputBoundary cancelAppPresenter = new CancelApplicationPresenter();
        CancelApplicationInputBoundary cancelAppInputBoundary = new CancelApplicationInteractor(cancelAppDsGateway, cancelAppPresenter);
        CancelApplicationController cancelAppController = new CancelApplicationController(cancelAppInputBoundary);

        ApplicationsListScreenBoundary applicationsListScreenBoundary = new ApplicationsListScreen(username2);

        ViewApplicationsListOutputBoundary viewAppListPresenter = new ViewApplicationsListPresenter(applicationsListScreenBoundary);
        ViewApplicationsListInputBoundary viewAppListInputBoundary = new ViewApplicationsListInteractor(viewAppDsGateway, viewAppListPresenter);
        ViewApplicationsListController viewAppsListController = new ViewApplicationsListController(viewAppListInputBoundary);

        // My applications button pressed
        applicationsListScreenBoundary.setViewApplicationsListController(viewAppsListController);
        applicationsListScreenBoundary.setCancelApplicationController(cancelAppController);
        applicationsListScreenBoundary.view();


    }
}
