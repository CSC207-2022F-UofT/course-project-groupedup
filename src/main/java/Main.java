import entities.*;
import interface_adapters.apply_to_group_adapters.ApplyToGroupController;
import interface_adapters.apply_to_group_adapters.ApplyToGroupPresenter;
import interface_adapters.cancel_application_adapters.CancelApplicationController;
import interface_adapters.cancel_application_adapters.CancelApplicationPresenter;
import interface_adapters.cancel_application_adapters.ViewApplicationsListController;
import interface_adapters.cancel_application_adapters.ViewApplicationsListPresenter;
import interface_adapters.edit_group_profile_adapters.EditGroupProfileController;
import interface_adapters.edit_group_profile_adapters.EditGroupProfilePresenter;
import interface_adapters.edit_group_profile_adapters.EditGroupProfileScreenBoundary;
import interface_adapters.edit_user_public_profile_adapters.EditUserPublicProfileController;
import interface_adapters.edit_user_public_profile_adapters.EditUserPublicProfilePresenter;
import interface_adapters.edit_user_public_profile_adapters.EditUserPublicProfileScreenBoundary;
import interface_adapters.group_register_adapters.GroupCreationScreenBoundary;
import interface_adapters.group_register_adapters.GroupRegisterController;
import interface_adapters.group_register_adapters.GroupRegisterPresenter;
import interface_adapters.leave_and_view_my_groups_adapters.LeaveGroupController;
import interface_adapters.leave_and_view_my_groups_adapters.LeaveGroupPresenter;
import interface_adapters.leave_and_view_my_groups_adapters.ViewMyGroupsController;
import interface_adapters.leave_and_view_my_groups_adapters.ViewMyGroupsPresenter;
import interface_adapters.login_adapters.LoginController;
import interface_adapters.login_adapters.LoginPresenter;
import interface_adapters.login_adapters.LoginScreenInterface;
import interface_adapters.logout_adapters.LogoutController;
import interface_adapters.logout_adapters.LogoutPresenter;
import interface_adapters.matching_algorithm_adapters.MatchesPresenter;
import interface_adapters.matching_algorithm_adapters.MatchingAlgorithmController;
import interface_adapters.matching_algorithm_adapters.MatchingAlgorithmScreenBoundary;
import interface_adapters.pending_list_adapters.EditPendingListController;
import interface_adapters.pending_list_adapters.EditPendingListPresenter;
import interface_adapters.pending_list_adapters.ViewPendingListController;
import interface_adapters.pending_list_adapters.ViewPendingListPresenter;
import interface_adapters.user_registration_adapters.UserRegistrationController;
import interface_adapters.user_registration_adapters.UserRegistrationPresenter;
import interface_adapters.user_registration_adapters.UserRegistrationScreenInterface;
import interface_adapters.view_group_members_adapters.ViewGroupMembersController;
import interface_adapters.view_group_members_adapters.ViewGroupMembersPresenter;
import interface_adapters.view_group_profile_adapters.ViewGroupProfileController;
import interface_adapters.view_group_profile_adapters.ViewGroupProfilePresenter;
import interface_adapters.view_user_public_profile_adapters.ViewUserPublicProfileController;
import interface_adapters.view_user_public_profile_adapters.ViewUserPublicProfilePresenter;
import interface_adapters.view_user_public_profile_adapters.ViewUserPublicProfileScreenBoundary;
import use_cases.apply_to_group_use_case.ApplyToGroupInputBoundary;
import use_cases.apply_to_group_use_case.ApplyToGroupInteractor;
import use_cases.apply_to_group_use_case.ApplyToGroupOutputBoundary;
import use_cases.cancel_application_use_case.CancelApplicationInputBoundary;
import use_cases.cancel_application_use_case.CancelApplicationInteractor;
import use_cases.cancel_application_use_case.CancelApplicationOutputBoundary;
import use_cases.edit_group_profile_use_case.EditGroupProfileInputBoundary;
import use_cases.edit_group_profile_use_case.EditGroupProfileInteractor;
import use_cases.edit_group_profile_use_case.EditGroupProfileOutputBoundary;
import use_cases.edit_pending_list_use_case.EditPendingListInputBoundary;
import use_cases.edit_pending_list_use_case.EditPendingListInteractor;
import use_cases.edit_pending_list_use_case.EditPendingListOutputBoundary;
import use_cases.edit_user_public_profile_use_case.EditUserPublicProfileInteractor;
import use_cases.edit_user_public_profile_use_case.EditUserPublicProfileOutputBoundary;
import use_cases.group_creation_use_case.*;
import use_cases.leave_group_use_case.LeaveGroupInputBoundary;
import use_cases.leave_group_use_case.LeaveGroupInteractor;
import use_cases.leave_group_use_case.LeaveGroupOutputBoundary;
import use_cases.matching_algorithm_use_case.MatchingAlgorithmInputBoundary;
import use_cases.matching_algorithm_use_case.MatchingAlgorithmInteractor;
import use_cases.matching_algorithm_use_case.MatchingAlgorithmOutputBoundary;
import use_cases.user_login_use_case.LoginInputBoundary;
import use_cases.user_login_use_case.LoginInteractor;
import use_cases.user_login_use_case.LoginOutputBoundary;
import use_cases.user_logout_use_case.LogoutInputBoundary;
import use_cases.user_logout_use_case.LogoutInteractor;
import use_cases.user_logout_use_case.LogoutOutputBoundary;
import use_cases.user_registration_use_case.*;
import use_cases.view_group_members_use_case.ViewGroupMembersInputBoundary;
import use_cases.view_group_members_use_case.ViewGroupMembersInteractor;
import use_cases.view_group_members_use_case.ViewGroupMembersOutputBoundary;
import use_cases.view_group_profile_use_case.ViewGroupProfileInputBoundary;
import use_cases.view_group_profile_use_case.ViewGroupProfileInteractor;
import use_cases.view_group_profile_use_case.ViewGroupProfileOutputBoundary;
import use_cases.view_my_groups_use_case.ViewMyGroupsInputBoundary;
import use_cases.view_my_groups_use_case.ViewMyGroupsInteractor;
import use_cases.view_my_groups_use_case.ViewMyGroupsOutputBoundary;
import use_cases.view_pending_list_use_case.ViewPendingListInputBoundary;
import use_cases.view_pending_list_use_case.ViewPendingListInteractor;
import use_cases.view_pending_list_use_case.ViewPendingListOutputBoundary;
import use_cases.view_user_applications_use_case.ViewApplicationsListInputBoundary;
import use_cases.view_user_applications_use_case.ViewApplicationsListInteractor;
import use_cases.view_user_applications_use_case.ViewApplicationsListOutputBoundary;
import use_cases.view_user_public_profile_use_case.ViewUserPublicProfileInteractor;
import use_cases.view_user_public_profile_use_case.ViewUserPublicProfileOutputBoundary;
import view_and_data_access.data_access.SerializeDataAccess;
import view_and_data_access.screens.HomePage;
import view_and_data_access.screens.group_creation_screens.GroupRegisterScreen;
import view_and_data_access.screens.group_creation_screens.NewGroupPageScreen;
import view_and_data_access.screens.group_list_screens.ApplicationsListScreen;
import view_and_data_access.screens.group_list_screens.GroupMembersScreen;
import view_and_data_access.screens.group_list_screens.MyGroupsScreen;
import view_and_data_access.screens.group_list_screens.PendingListScreen;
import view_and_data_access.screens.group_profile_screens.EditGroupProfileScreen;
import view_and_data_access.screens.group_profile_screens.GroupProfileScreen;
import view_and_data_access.screens.login_and_registration_screens.LoginScreen;
import view_and_data_access.screens.login_and_registration_screens.UserRegistrationScreen;
import view_and_data_access.screens.matching_algorithm_screens.MatchingAlgorithmScreen;
import view_and_data_access.screens.user_public_profile_screens.EditUserPublicProfileScreen;
import view_and_data_access.screens.user_public_profile_screens.ViewUserPublicProfileScreen;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

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

        CurrentUser currentUser = CurrentUser.getInstance();

        User userLeader = new NormalUser("userLeader", "userLeader", "userLeader", "userLeader",
                new UserPublicProfile());

        CurrentUser.getInstance().setUser(userLeader);

        /**
         *  Initial call for data access
         */
        //SerializeDataAccess dataAccess = initialize(userLeader);

        /**
         *  Data access call for subsequent runs
         */
        SerializeDataAccess dataAccess = new SerializeDataAccess();
        LogoutOutputBoundary logoutPresenter = new LogoutPresenter();
        LogoutInputBoundary logoutInputBoundary = new LogoutInteractor(logoutPresenter);
        LogoutController logoutController = new LogoutController(logoutInputBoundary);



        UserRegistrationScreenInterface registrationScreen = new UserRegistrationScreen(screens, cardLayout);
        UserRegistrationOutputBoundary registrationPresenter = new UserRegistrationPresenter(registrationScreen);
        UserFactory normalUserFactory = new NormalUserFactory();
        UserRegistrationInteractor registrationInteractor =
                new UserRegistrationInteractor(normalUserFactory, dataAccess, registrationPresenter);
        UserRegistrationController registrationController = new UserRegistrationController(registrationInteractor);
        registrationScreen.setView(registrationController);

        EditGroupProfileScreenBoundary editGroupScreen = new EditGroupProfileScreen(cardLayout, screens);
        EditGroupProfileOutputBoundary presenter2 = new EditGroupProfilePresenter(editGroupScreen);
        EditGroupProfileInputBoundary interactor2 = new EditGroupProfileInteractor(dataAccess, presenter2);
        EditGroupProfileController editGroupController = new EditGroupProfileController(interactor2);
        editGroupScreen.setEditGroupController(editGroupController);
        editGroupScreen.setView(editGroupController);
        screens.add((Component) editGroupScreen, "editGroupScreen");

        GroupProfileScreen groupProfileScreen = new GroupProfileScreen();
        ApplicationsListScreen applicationsListScreen = new ApplicationsListScreen(CurrentUser.getInstance().getUser().getUsername(), cardLayout,
                screens);
        screens.add(applicationsListScreen, "applicationListScreen");

        MyGroupsScreen myGroupsScreen = new MyGroupsScreen(cardLayout, screens, CurrentUser.getInstance().getUser().getUsername());
        screens.add(myGroupsScreen, "myGroupsScreen");
        HomePage homepageTest = new HomePage(cardLayout, screens, CurrentUser.getInstance().getUser().getUsername());
        screens.add(homepageTest, "homepage");
        homepageTest.setLogoutController(logoutController);

        MatchingAlgorithmScreenBoundary matchingAlgorithmScreenBoundary = new MatchingAlgorithmScreen(homepageTest);
        MatchingAlgorithmOutputBoundary matchingAlgorithmOutputBoundary =
                new MatchesPresenter(matchingAlgorithmScreenBoundary);
        MatchingAlgorithmInputBoundary matchingAlgorithmInputBoundary =
                new MatchingAlgorithmInteractor(matchingAlgorithmOutputBoundary, dataAccess);
        MatchingAlgorithmController matchingAlgorithmController = new MatchingAlgorithmController(matchingAlgorithmInputBoundary);
        homepageTest.setMatchingAlgorithmController(matchingAlgorithmController);

        ApplyToGroupOutputBoundary applyToGroupPresenter = new ApplyToGroupPresenter();
        ApplyToGroupInputBoundary applyToGroupInteractor = new ApplyToGroupInteractor(dataAccess, applyToGroupPresenter);
        ApplyToGroupController applyToGroupController = new ApplyToGroupController(applyToGroupInteractor);
        homepageTest.setApplyToGroupController(applyToGroupController);

        ViewUserPublicProfileScreenBoundary viewUserPublicProfileScreen = new ViewUserPublicProfileScreen(screens, cardLayout);
        ViewUserPublicProfileOutputBoundary viewUserPublicProfilePresenter = new ViewUserPublicProfilePresenter(viewUserPublicProfileScreen);
        ViewUserPublicProfileInteractor viewUserPublicProfileInteractor = new ViewUserPublicProfileInteractor(dataAccess, viewUserPublicProfilePresenter);
        ViewUserPublicProfileController viewUserPublicProfileController = new ViewUserPublicProfileController(viewUserPublicProfileInteractor);
        viewUserPublicProfileScreen.setController(viewUserPublicProfileController);
        viewUserPublicProfileScreen.setUsername(CurrentUser.getInstance().getUser().getUsername());
        homepageTest.setViewUserProfileController(viewUserPublicProfileController);
        screens.add((Component) viewUserPublicProfileScreen, "viewUserProfileScreen");

        EditUserPublicProfileScreenBoundary editUserPublicProfileScreen = new EditUserPublicProfileScreen(cardLayout, screens);
        EditUserPublicProfileOutputBoundary editUserPublicProfilePresenter = new EditUserPublicProfilePresenter(editUserPublicProfileScreen);
        EditUserPublicProfileInteractor editUserPublicProfileInteractor = new EditUserPublicProfileInteractor(dataAccess, editUserPublicProfilePresenter);
        EditUserPublicProfileController editUserPublicProfileController = new EditUserPublicProfileController(editUserPublicProfileInteractor);
        editUserPublicProfileScreen.setController(editUserPublicProfileController);
        editUserPublicProfileScreen.setUsername(CurrentUser.getInstance().getUser().getUsername());
        screens.add((Component) editUserPublicProfileScreen, "editUserProfileScreen");

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

        ViewGroupProfileController viewGroupProfileController = new ViewGroupProfileController(viewGroupProfileInteractor);
        ViewApplicationsListController viewApplicationsListController = new ViewApplicationsListController(viewApplicationsInteractor);
        ViewMyGroupsController viewMyGroupsController = new ViewMyGroupsController(viewMyGroupsInteractor);
        CancelApplicationController cancelApplicationController = new CancelApplicationController(cancelApplicationInteractor);
        LeaveGroupController leaveGroupController = new LeaveGroupController(leaveGroupInteractor);

        groupProfileScreen.setViewGroupProfileController(viewGroupProfileController);
        homepageTest.setViewMyGroupsController(viewMyGroupsController);
        homepageTest.setViewApplicationsListController(viewApplicationsListController);
        homepageTest.setViewGroupProfileController(viewGroupProfileController);
        applicationsListScreen.setViewGroupController(viewGroupProfileController);
        applicationsListScreen.setCancelApplicationController(cancelApplicationController);
        myGroupsScreen.setViewGroupProfileController(viewGroupProfileController);
        myGroupsScreen.setLeaveGroupController(leaveGroupController);

        GroupFactory groupFactory = new GroupFactory();

        PendingListScreen pendingListScreen = new PendingListScreen(cardLayout, screens);
        screens.add(pendingListScreen,"pendingListScreen");
        ViewPendingListOutputBoundary viewPendingListPresenter = new ViewPendingListPresenter(pendingListScreen);
        ViewPendingListInputBoundary viewPendingListInteractor = new ViewPendingListInteractor(
                dataAccess, viewPendingListPresenter);
        ViewPendingListController viewPendingListController = new ViewPendingListController(
                viewPendingListInteractor);
        pendingListScreen.setViewPendingListController(viewPendingListController);


        GroupMembersScreen groupMembersScreen = new GroupMembersScreen(cardLayout, screens);
        screens.add(groupMembersScreen, "groupMembersScreen");
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
                viewPendingListController, viewGroupMembersController, editGroupScreen);

        GroupCreationScreenBoundary groupRegisterScreen = new GroupRegisterScreen(newGroupPageScreen,
                cardLayout, screens);
        GroupRegisterOutputBoundary presenter = new GroupRegisterPresenter(groupRegisterScreen);
        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(dataAccess, presenter, groupFactory);
        GroupRegisterController groupRegisterController = new GroupRegisterController(
                interactor);
        groupRegisterScreen.setView(groupRegisterController);

        newGroupPageScreen.setView(groupRegisterController);
        myGroupsScreen.setNewGroupPageScreen(newGroupPageScreen);

        LoginScreenInterface loginScreen = new LoginScreen(screens, cardLayout, homepageTest);
        LoginOutputBoundary loginPresenter = new LoginPresenter(loginScreen);
        LoginInputBoundary loginInteractor = new LoginInteractor(dataAccess, loginPresenter);
        LoginController loginController = new LoginController(loginInteractor);
        loginScreen.setView(loginController);
        cardLayout.show(screens, "login page");

        //application.pack();
        application.setVisible(true);



    }

    public static SerializeDataAccess initialize(User userLeader){
        SerializeDataAccess dataAccess = new SerializeDataAccess("Initialize");
        CurrentUser currentUser = CurrentUser.getInstance();

        dataAccess.saveNewUser(new UserRegistrationDSRequestPackage(userLeader, userLeader.getUsername()));
        currentUser.setUser(userLeader);

        Group group1 = new NormalGroup("Jonathan's Fan Club!!");
        group1.getProfile().setDescription("Jonathan is goat");
        group1.addMember(userLeader.getUsername());
        group1.setGroupLeader(userLeader.getUsername());
        HashMap<String, String> preferences1 = new HashMap<>();
        preferences1.put("Location", "Online");
        preferences1.put("Meeting Time", "Tuesday");
        preferences1.put("Time Commitment","0-2 hours");
        group1.getProfile().setPreferences(preferences1);
        group1.getProfile().setCourseCode("csc207");
        dataAccess.saveNewGroups(new GroupRegisterDSRequestModel(group1, group1.getGroupName()));

        Group group2 = new NormalGroup("Rui's Disciples");
        group2.getProfile().setDescription("Rui is a legend");
        group2.addMember(userLeader.getUsername());
        group2.setGroupLeader(userLeader.getUsername());
        HashMap<String, String> preferences2 = new HashMap<>();
        preferences2.put("Location", "In-Person");
        preferences2.put("Meeting Time", "Friday");
        preferences2.put("Time Commitment","2-4 hours");
        group2.getProfile().setPreferences(preferences2);
        group2.getProfile().setCourseCode("csc236");

        dataAccess.saveNewGroups(new GroupRegisterDSRequestModel(group2, group2.getGroupName()));


        User user1 = new NormalUser("test", "test", "test", "test", new UserPublicProfile());
        dataAccess.saveNewUser(new UserRegistrationDSRequestPackage(user1, user1.getUsername()));

        // TESTING SERIALIZED DATA ACCESS FOR LEAVE GROUP AND CANCEL APPLICATION
        currentUser = CurrentUser.getInstance();
        currentUser.setUser(user1);

        User bob = new NormalUser("bob", "bob", "bob", "bob", new UserPublicProfile());
        currentUser.setUser(bob);
        dataAccess.saveNewUser(new UserRegistrationDSRequestPackage(bob, bob.getUsername()));

        Group group = new NormalGroup("Bob's group");
        group.getProfile().setDescription("bobby's club.");
        group.addRequest(user1.getUsername());
        dataAccess.saveNewGroups(new GroupRegisterDSRequestModel(group, group.getGroupName()));


        Group group3 = new NormalGroup("Paul's Fan Club");
        group3.getProfile().setDescription("Hi guys. My name is Paul Gries and I am 52 years old and I have" +
                " brown hair and blue eyes. I made this group because I think it would be nice to get together" +
                " with abstract people and talk about things in the abstract sense. BTW i love art, especially" +
                " drawing arrows :)");
        group3.addRequest(user1.getUsername());
        dataAccess.saveNewGroups(new GroupRegisterDSRequestModel(group3, group3.getGroupName()));

        user1.getApplicationsList().put("Bob's group", "Bob's group");
        user1.getApplicationsList().put("Paul's Fan Club", "Paul's Fan Club");
        dataAccess.updateUser(user1);

        return dataAccess;
    }
}