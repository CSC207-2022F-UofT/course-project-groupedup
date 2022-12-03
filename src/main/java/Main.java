import Entities.*;
import edit_pending_list.EditPendingListDsGateway;
import edit_pending_list.EditPendingListInputBoundary;
import edit_pending_list.EditPendingListInteractor;
import edit_pending_list.EditPendingListOutputBoundary;
import pending_list_screens.*;
import view_group_members.ViewGroupMembersDsGateway;
import view_group_members.ViewGroupMembersInputBoundary;
import view_group_members.ViewGroupMembersInteractor;
import view_group_members.ViewGroupMembersOutputBoundary;
import view_pending_list.ViewPendingListDsGateway;
import view_pending_list.ViewPendingListInputBoundary;
import view_pending_list.ViewPendingListInteractor;
import view_pending_list.ViewPendingListOutputBoundary;

import Entities.CurrentUser;
import Entities.NormalUser;
import Entities.User;
import Entities.UserPublicProfile;
import Entities.AllControllers;
import MultiUsecaseUtil.SerializeDataAccess;
import Screens.*;
import UserSignupLoginScreens.*;
import UserRegistrationUsecase.*;
import UserSignupLoginScreens.UserRegistrationController;
import UserSignupLoginScreens.UserRegistrationPresenter;
import group_creation_screens.*;
import group_creation_use_case.*;
import userloginusecase.LoginDSGateway;
import userloginusecase.LoginInputBoundary;
import userloginusecase.LoginInteractor;
import userloginusecase.LoginOutputBoundary;
import Edit_Group_Profile_Screens.EditGroupProfileScreen;

import java.util.HashMap;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

//        String groupName = "csc207";
//        String username = "sharon";
//        String username1 = "aarya";
//
//        User user = new NormalUser(username, "pw", "Sharon", "sharon@gmail.com",
//                new UserPublicProfile());
//        User user1 = new NormalUser(username1, "pww", "Aarya", "aarya@gmail.com",
//                new UserPublicProfile());
//        CurrentUser currentUser = CurrentUser.getInstance();
//        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
//                new UserPublicProfile());
//        currentUser.setUser(testUser);
//
//        Group group = new NormalGroup(groupName);
//        group.addRequest(username);
//        group.addRequest(username1);
//
//        user.getApplicationsList().put(groupName, groupName);
//        user1.getApplicationsList().put(groupName, groupName);
//
//        HashMap<String, User> userMap = new HashMap<>();
//        userMap.put(username, user);
//        userMap.put(username1, user1);
//
//        HashMap<String, Group> groupMap = new HashMap<>();
//        groupMap.put(groupName, group);
//
//        ViewPendingListDsGateway dsGateway = new PendingListDataAccess(userMap, groupMap);
//        EditPendingListDsGateway dsGateway1 = new PendingListDataAccess(userMap, groupMap);
//
        JFrame application = new JFrame("Grouped Up");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

//        EditPendingListOutputBoundary presenter2 = new EditPendingListPresenter();
//        EditPendingListInputBoundary editPendingListInputBoundary = new EditPendingListInteractor(
//                dsGateway1, presenter2);
//        EditPendingListController editPendingListController = new EditPendingListController(
//                editPendingListInputBoundary);
//
//        PendingListScreenBoundary pendingListScreenBoundary = new PendingListScreen(groupName);
//        ViewPendingListOutputBoundary presenter1 = new ViewPendingListPresenter(pendingListScreenBoundary);
//        ViewPendingListInputBoundary viewPendingListInputBoundary = new ViewPendingListInteractor(
//                dsGateway, presenter1);
//        ViewPendingListController viewPendingListController = new ViewPendingListController(
//                viewPendingListInputBoundary);
//
//        // pending list button pressed
//        pendingListScreenBoundary.setViewPendingListController(viewPendingListController);
//        pendingListScreenBoundary.setEditPendingListController(editPendingListController);
//        pendingListScreenBoundary.view();

//            SerializeDataAccess dataAccess = new SerializeDataAccess();
//            UserRegistrationOutputBoundary userRegistrationPresenter = new UserRegistrationPresenter();
//            UserFactory normalUserFactory = new NormalUserFactory();
//            UserRegistrationInputBoundary userRegistrationInteractor = new UserRegistrationInteractor(
//                    normalUserFactory, dataAccess, userRegistrationPresenter);
//            UserRegistrationController userRegistrationController = new UserRegistrationController(
//                    userRegistrationInteractor);

//        String username = "sharon";
//        String username1 = "aarya";
//        String groupName = "csc207";
//
//        User user = new NormalUser(username, "pw", "Sharon", "sharon@gmail.com",
//                new UserPublicProfile());
//        User user1 = new NormalUser(username1, "pww", "Aarya", "aarya@gmail.com",
//                new UserPublicProfile());
//        CurrentUser currentUser = CurrentUser.getInstance();
//        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
//                new UserPublicProfile());
//        currentUser.setUser(testUser);

//        Group group = new NormalGroup(groupName);
//        group.addRequest(username);
//        group.addRequest(username1);

//        user.getApplicationsList().put(groupName, groupName);
//        user1.getApplicationsList().put(groupName, groupName);
//
//        HashMap<String, User> userMap = new HashMap<>();
//        userMap.put(username, user);
//        userMap.put(username1, user1);
//
//        HashMap<String, Group> groupMap = new HashMap<>();
//        groupMap.put(groupName, group);

//        NewGroupDSGateway dataAccess = new InMemoryFileGroup();

        NewGroupDSGateway dataAccess = new SerializeDataAccess();
        GroupRegisterViewModel groupRegisterView = new GroupRegisterView(cardLayout, screens);
        GroupRegisterOutputBoundary presenter = new GroupRegisterPresenter(groupRegisterView);
        GroupFactory groupFactory = new GroupFactory();
        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(dataAccess, presenter, groupFactory);
        GroupRegisterController groupRegisterController = new GroupRegisterController(
                interactor);

//        LoginOutputBoundary loginPresenter = new LoginPresenter();
//        LoginInputBoundary loginInteractor = new LoginInteractor(dataAccess, loginPresenter);
//        LoginController loginController = new LoginController(loginInteractor);

        // this part is just to activate the group creation use case, can remove later
        // setting up a fake 'logged in' user


        CurrentUser currentUser1 = CurrentUser.getInstance();
        UserPublicProfile testProfile = new UserPublicProfile();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                testProfile);
        currentUser1.setUser(testUser);

        HomePage homepageTest = new HomePage(cardLayout, screens);

        GroupRegisterScreen groupRegisterScreen = new GroupRegisterScreen(groupRegisterController);
        screens.add(homepageTest, "homepageScreen");
        screens.add(groupRegisterScreen, "groupRegisterScreen");
        cardLayout.show(screens, "hompageScreen");
        application.pack();
        application.setVisible(true);

//        ViewGroupMembersDsGateway dsGateway2 = new PendingListDataAccess(userMap, groupMap);
//        ViewGroupMembersOutputBoundary presenter3 = new ViewGroupMembersPresenter();
//        ViewGroupMembersInputBoundary viewGroupMembersInputBoundary = new ViewGroupMembersInteractor(
//                dsGateway2, presenter3);
//        ViewGroupMembersController viewGroupMembersController = new ViewGroupMembersController(
//                viewGroupMembersInputBoundary);
//
//        GroupMembersScreen groupMembers = new GroupMembersScreen(viewGroupMembersController, groupName);

//        AllControllers allControllers = AllControllers.getInstance();
//        allControllers.setLoginController(loginController);
//        allControllers.setUserRegistrationController(userRegistrationController);
        // just commented out Leo's login screen because it hasn't been connected to homepage yet
        // new LoginScreen();


    }
}
