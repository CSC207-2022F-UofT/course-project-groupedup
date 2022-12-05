import edit_pending_list.EditPendingListInputBoundary;
import edit_pending_list.EditPendingListInteractor;
import edit_pending_list.EditPendingListOutputBoundary;
import pending_list_screens.*;
import view_group_members.*;
import view_pending_list.ViewPendingListInputBoundary;
import view_pending_list.ViewPendingListInteractor;
import view_pending_list.ViewPendingListOutputBoundary;

import Entities.*;
import MultiUsecaseUtil.SerializeDataAccess;
import UserSignupLoginScreens.*;
import UserRegistrationUsecase.*;
import cancel_application_screens.*;
import cancel_application_use_case.CancelApplicationInputBoundary;
import cancel_application_use_case.CancelApplicationInteractor;
import cancel_application_use_case.CancelApplicationOutputBoundary;
import group_creation_screens.*;
import group_creation_use_case.*;
import leave_group_screens.*;
import leave_group_use_case.LeaveGroupInputBoundary;
import leave_group_use_case.LeaveGroupInteractor;
import leave_group_use_case.LeaveGroupOutputBoundary;
import userloginusecase.LoginInputBoundary;
import userloginusecase.LoginInteractor;
import userloginusecase.LoginOutputBoundary;
import view_group_profile_screens.GroupProfileScreen;
import view_group_profile_screens.ViewGroupProfileController;
import view_group_profile_screens.ViewGroupProfilePresenter;
import view_group_profile_use_case.ViewGroupProfileInputBoundary;
import view_group_profile_use_case.ViewGroupProfileInteractor;
import view_group_profile_use_case.ViewGroupProfileOutputBoundary;
import view_my_groups_use_case.ViewMyGroupsInputBoundary;
import view_my_groups_use_case.ViewMyGroupsInteractor;
import view_my_groups_use_case.ViewMyGroupsOutputBoundary;
import view_user_applications_use_case.ViewApplicationsListInputBoundary;
import view_user_applications_use_case.ViewApplicationsListInteractor;
import view_user_applications_use_case.ViewApplicationsListOutputBoundary;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Runs registration, login, homepage, create group, new group profile, pending list,
        // application list, my groups list, view group, leave group, cancel application

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

        GroupProfileScreen groupProfileScreen = new GroupProfileScreen();
        ApplicationsListScreen applicationsListScreen = new ApplicationsListScreen(user1.getUsername());
        MyGroupsScreen myGroupsScreen = new MyGroupsScreen(cardLayout, screens, user1.getUsername());
        HomePage homepageTest = new HomePage(cardLayout, screens, user1.getUsername());
        screens.add(homepageTest, "homepage");

        ViewGroupProfileOutputBoundary viewGroupProfilePresenter = new ViewGroupProfilePresenter(groupProfileScreen);
        ViewGroupProfileInputBoundary viewGroupProfileInteractor = new ViewGroupProfileInteractor(dataAccess,
                viewGroupProfilePresenter);
        ViewApplicationsListOutputBoundary viewApplicationsListPresenter = new ViewApplicationsListPresenter(
                applicationsListScreen);
        ViewApplicationsListInputBoundary viewApplicationsInteractor = new ViewApplicationsListInteractor(dataAccess,
                viewApplicationsListPresenter);
        ViewMyGroupsOutputBoundary viewMyGroupsPresenter = new ViewMyGroupsPresenter(myGroupsScreen);
        ViewMyGroupsInputBoundary viewMyGroupsInteractor = new ViewMyGroupsInteractor(dataAccess, viewMyGroupsPresenter);
        CancelApplicationOutputBoundary cancelApplicationPresenter = new CancelApplicationPresenter();
        CancelApplicationInputBoundary cancelApplicationInteractor = new CancelApplicationInteractor(dataAccess,
                cancelApplicationPresenter);
        LeaveGroupOutputBoundary leaveGroupPresenter = new LeaveGroupPresenter();
        LeaveGroupInputBoundary leaveGroupInteractor = new LeaveGroupInteractor(dataAccess, leaveGroupPresenter);
        // ADD EDIT GROUP PROFILE PRESENTER HERE

        ViewGroupProfileController viewGroupProfileController = new ViewGroupProfileController(viewGroupProfileInteractor);
        ViewApplicationsListController viewApplicationsListController = new ViewApplicationsListController(viewApplicationsInteractor);
        ViewMyGroupsController viewMyGroupsController = new ViewMyGroupsController(viewMyGroupsInteractor);
        CancelApplicationController cancelApplicationController = new CancelApplicationController(cancelApplicationInteractor);
        LeaveGroupController leaveGroupController = new LeaveGroupController(leaveGroupInteractor);

        groupProfileScreen.setViewGroupProfileController(viewGroupProfileController);
        homepageTest.setViewMyGroupsController(viewMyGroupsController);
        homepageTest.setViewApplicationsListController(viewApplicationsListController);
        applicationsListScreen.setViewGroupController(viewGroupProfileController);
        applicationsListScreen.setCancelApplicationController(cancelApplicationController);
        myGroupsScreen.setViewGroupProfileController(viewGroupProfileController);
        myGroupsScreen.setLeaveGroupController(leaveGroupController);

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

        //application.pack();
        application.setVisible(true);

    }
}