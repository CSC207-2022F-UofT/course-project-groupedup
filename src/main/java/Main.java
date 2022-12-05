import edit_pending_list.EditPendingListInputBoundary;
import edit_pending_list.EditPendingListInteractor;
import edit_pending_list.EditPendingListOutputBoundary;
import pending_list_screens.*;
import view_group_members.*;
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
import group_creation_use_case.GroupFactory;
import group_creation_use_case.GroupRegisterInputBoundary;
import group_creation_use_case.GroupRegisterInteractor;
import group_creation_use_case.GroupRegisterOutputBoundary;
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

        /**
         *  Initial call for data access
         */
        SerializeDataAccess dataAccess = new SerializeDataAccess("Initialize");

        /**
         *  Data access call for subsequent runs
         */
        // SerializeDataAccess dataAccess = new SerializeDataAccess();

        User user1 = new NormalUser("test", "test", "test", "test", new UserPublicProfile());
        dataAccess.saveNewUser(new UserRegistrationDSRequestPackage(user1, user1.getUsername()));
        HomePage homepageTest = new HomePage(cardLayout, screens, user1.getUsername());
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


        GroupFactory groupFactory = new GroupFactory();

        PendingListScreen pendingListScreen = new PendingListScreen();
        ViewPendingListOutputBoundary viewPendingListPresenter = new ViewPendingListPresenter(pendingListScreen);
        ViewPendingListInputBoundary viewPendingListInteractor = new ViewPendingListInteractor(
                dataAccess, viewPendingListPresenter);
        ViewPendingListController viewPendingListController = new ViewPendingListController(
                viewPendingListInteractor);
        pendingListScreen.setViewPendingListController(viewPendingListController);


        GroupMembersScreen groupMembersScreen = new GroupMembersScreen();
        ViewGroupMembersOutputBoundary viewGroupMembersPresenter = new ViewGroupMembersPresenter(groupMembersScreen);
        ViewGroupMembersInputBoundary viewGroupMembersInteractor = new ViewGroupMembersInteractor(
                dataAccess, viewGroupMembersPresenter);
        ViewGroupMembersController viewGroupMembersController = new ViewGroupMembersController(
                viewGroupMembersInteractor);
        groupMembersScreen.setViewGroupMembersController(viewGroupMembersController);

        EditPendingListOutputBoundary editPendingListPresenter = new EditPendingListPresenter();
        EditPendingListInputBoundary editPendingListInputBoundary = new EditPendingListInteractor(
                dataAccess, editPendingListPresenter);
        EditPendingListController editPendingListController = new EditPendingListController(
                editPendingListInputBoundary);
        pendingListScreen.setEditPendingListController(editPendingListController);


        NewGroupPageScreen newGroupPageScreen = new NewGroupPageScreen(cardLayout, screens,
                viewPendingListController, viewGroupMembersController);

        GroupCreationScreenBoundary groupRegisterScreen = new GroupRegisterScreen(newGroupPageScreen,
                cardLayout, screens);
        GroupRegisterOutputBoundary presenter = new GroupRegisterPresenter(groupRegisterScreen);
        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(dataAccess, presenter, groupFactory);
        GroupRegisterController groupRegisterController = new GroupRegisterController(
                interactor);
        groupRegisterScreen.setView(groupRegisterController);

        newGroupPageScreen.setView(groupRegisterController);

        application.pack();
        application.setVisible(true);

    }
}