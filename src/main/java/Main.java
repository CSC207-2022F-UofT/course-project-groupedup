import Entities.*;
import edit_pending_list.EditPendingListDsGateway;
import edit_pending_list.EditPendingListInputBoundary;
import edit_pending_list.EditPendingListInteractor;
import edit_pending_list.EditPendingListOutputBoundary;
import group_creation_use_case.*;
import pending_list_screens.*;
import view_group_members.ViewGroupMembersDsGateway;
import view_group_members.ViewGroupMembersInputBoundary;
import view_group_members.ViewGroupMembersInteractor;
import view_group_members.ViewGroupMembersOutputBoundary;
import view_pending_list.ViewPendingListDsGateway;
import view_pending_list.ViewPendingListInputBoundary;
import view_pending_list.ViewPendingListInteractor;
import view_pending_list.ViewPendingListOutputBoundary;

import Entities.NormalUser;
import Entities.User;
import Entities.UserPublicProfile;
import MultiUsecaseUtil.SerializeDataAccess;
import UserSignupLoginScreens.*;
import UserRegistrationUsecase.*;
import group_creation_screens.*;
import userloginusecase.LoginInputBoundary;
import userloginusecase.LoginInteractor;
import userloginusecase.LoginOutputBoundary;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        // Runs registration, login, homepage, create group, new group profile, pending list
        JFrame application = new JFrame("Grouped Up");
        application.setSize(350, 400);
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setLocationRelativeTo(null);

        SerializeDataAccess dataAccess = new SerializeDataAccess();
        User user1 = new NormalUser("test", "test", "test", "test", new UserPublicProfile());
        dataAccess.saveNewUser(new UserRegistrationDSRequestPackage(user1, user1.getUsername()));
        HomePage homepageTest = new HomePage(cardLayout, screens);
        screens.add(homepageTest, "homepage");

        LoginScreenInterface loginScreen = new LoginScreen(screens, cardLayout);
        LoginOutputBoundary loginPresenter = new LoginPresenter(loginScreen);
        LoginInputBoundary loginInteractor = new LoginInteractor(dataAccess, loginPresenter);
        LoginController loginController = new LoginController(loginInteractor);
        loginScreen.setView(loginController);
        cardLayout.show(screens, "login page");

        UserRegistrationScreenInterface registrationScreen = new UserRegistrationScreen(screens, cardLayout);
        UserRegistrationOutputBoundary registrationPresenter = new UserRegistrationPresenter(registrationScreen);
        UserFactory normalUserFactory = new NormalUserFactory();
        UserRegistrationInteractor registrationInteractor =
                new UserRegistrationInteractor(normalUserFactory, dataAccess, registrationPresenter);
        UserRegistrationController registrationController = new UserRegistrationController(registrationInteractor);
        registrationScreen.setView(registrationController);

        NewGroupDSGateway dataAccess1 = new InMemoryFileGroup();
        GroupRegisterViewModel groupRegisterView = new GroupRegisterView(cardLayout, screens);
        GroupRegisterOutputBoundary presenter = new GroupRegisterPresenter(groupRegisterView);
        GroupFactory groupFactory = new GroupFactory();
        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(dataAccess1, presenter, groupFactory);
        GroupRegisterController groupRegisterController = new GroupRegisterController(
                interactor);

        GroupRegisterScreen groupRegisterScreen = new GroupRegisterScreen(groupRegisterController);
        screens.add(groupRegisterScreen, "groupRegisterScreen");

//        application.pack();
        application.setVisible(true);

//      PENDINGLIST STUFF ---------------------------------------------------------------------------------------------
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
//
//        ViewGroupMembersDsGateway dsGateway2 = new PendingListDataAccess(userMap, groupMap);
//        ViewGroupMembersOutputBoundary presenter3 = new ViewGroupMembersPresenter();
//        ViewGroupMembersInputBoundary viewGroupMembersInputBoundary = new ViewGroupMembersInteractor(
//                dsGateway2, presenter3);
//        ViewGroupMembersController viewGroupMembersController = new ViewGroupMembersController(
//                viewGroupMembersInputBoundary);
//
//        GroupMembersScreen groupMembers = new GroupMembersScreen(viewGroupMembersController, groupName);
//     ----------------------------------------------------------------------------------------------------------------

    }
}
