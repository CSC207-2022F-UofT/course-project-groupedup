import Entities.*;
import MultiUsecaseUtil.SerializeDataAccess;
import UserRegistrationUsecase.NewUserDSGateway;
import edit_pending_list.EditPendingListDsGateway;
import edit_pending_list.EditPendingListInputBoundary;
import edit_pending_list.EditPendingListInteractor;
import edit_pending_list.EditPendingListOutputBoundary;
import group_creation_use_case.NewGroupDSGateway;
import group_creation_screens.*;
import group_creation_use_case.*;
import leave_group_screens.LeaveGroupController;
import leave_group_screens.LeaveGroupDataAccess;
import leave_group_screens.LeaveGroupPresenter;
import leave_group_screens.LeaveGroupScreen;
import leave_group_use_case.LeaveGroupDsGateway;
import leave_group_use_case.LeaveGroupInputBoundary;
import leave_group_use_case.LeaveGroupInteractor;
import leave_group_use_case.LeaveGroupOutputBoundary;
import pending_list_screens.*;
import view_pending_list.ViewPendingListDsGateway;
import view_pending_list.ViewPendingListInputBoundary;
import view_pending_list.ViewPendingListInteractor;
import view_pending_list.ViewPendingListOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        // Build the main program window
        JFrame application = new JFrame("GroupedUp");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        // Create the parts to plug into the Use Case+Entities engine
        SerializeDataAccess dataAccess;
        try {
            dataAccess = new SerializeDataAccess();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        LeaveGroupDsGateway gateway = dataAccess;
        LeaveGroupOutputBoundary presenter = new LeaveGroupPresenter(cardLayout, screens);
        LeaveGroupInputBoundary inputBoundary = new LeaveGroupInteractor(gateway, presenter);
        LeaveGroupController controller = new LeaveGroupController(inputBoundary);

        // Build the GUI, plugging in the parts
        LeaveGroupScreen leaveGroupScreen = new LeaveGroupScreen("aarya", "aarya's group",
        controller);

        String groupName = "csc207";
        String username = "sharonh";

        User user = new NormalUser(username, "pw", "Sharon", "sharon@gmail.com",
                new UserPublicProfile());
        CurrentUser currentUser = CurrentUser.getInstance();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                new UserPublicProfile());
        currentUser.setUser(testUser);

        Group group = new NormalGroup(groupName);
        group.addRequest(username);

        user.getApplicationsList().put(groupName, group);

        ViewPendingListDsGateway dsGateway = new PendingListDataAccess(username, user, groupName, group);
        EditPendingListDsGateway dsGateway1 = new PendingListDataAccess(username, user, groupName, group);

        ViewPendingListOutputBoundary presenter1 = new ViewPendingListPresenter();
        EditPendingListOutputBoundary presenter2 = new EditPendingListPresenter();

        ViewPendingListInputBoundary viewPendingListInputBoundary = new ViewPendingListInteractor(
                dsGateway, presenter1);
        ViewPendingListController viewPendingListController = new ViewPendingListController(
                viewPendingListInputBoundary);

        EditPendingListInputBoundary editPendingListInputBoundary = new EditPendingListInteractor(
                dsGateway1, presenter2);
        EditPendingListController editPendingListController = new EditPendingListController(
                editPendingListInputBoundary);

        PendingListScreen pendingListScreen = new PendingListScreen(editPendingListController, viewPendingListController);

//        JFrame application = new JFrame("Group Creation Screen");
//        CardLayout cardLayout = new CardLayout();
//        JPanel screens = new JPanel(cardLayout);
//        application.add(screens);
//

//        NewGroupDSGateway newGroup = dataAccess;
//
//        GroupRegisterPresenter presenter = new GroupRegisterResponseFormatter();
//        GroupFactory groupFactory = new GroupFactory();
//        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(newGroup, presenter, groupFactory);
//        GroupRegisterController userRegisterController = new GroupRegisterController(
//                interactor
//        );
//
//        // Build the GUI, plugging in the parts
//        GroupRegisterScreen registerScreen = new GroupRegisterScreen(userRegisterController);
//        screens.add(registerScreen, "welcome");
//        cardLayout.show(screens, "register");
//        application.pack();
//        application.setVisible(true);
//
//        NewGroupPageScreen newGroupPageScreen = new NewGroupPageScreen();
//        screens.add(newGroupPageScreen, "register");

        User testUser = new NormalUser("Bob", "testUser", "testUser", "testUser",
                new UserPublicProfile());

        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUser(testUser);
        String groupName = "Bob's group";
        Group group = new NormalGroup(groupName);

        User testUser2 = new NormalUser("testUser2", "testUser2", "testUser2", "testUser2",
                new UserPublicProfile());
        testUser2.getGroups().put(groupName, group);
        group.addMember(testUser2.getUsername());

        String username = "aarya";
        User user = new NormalUser(username, "aarya", "Aarya", "aarya@gmail.com",
                new UserPublicProfile());
        user.getGroups().put(groupName, group);
        group.addMember(user.getUsername());

        HashMap<String, User> users = new HashMap<>();
        users.put(testUser.getUsername(), testUser);
        users.put(testUser2.getUsername(), testUser2);
        users.put(user.getUsername(), user);

        HashMap<String, Group> groups = new HashMap<>();
        groups.put(groupName, group);

    }
}
