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

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        JFrame application = new JFrame("Group Creation Screen");
//        CardLayout cardLayout = new CardLayout();
//        JPanel screens = new JPanel(cardLayout);
//        application.add(screens);
//
//        SerializeDataAccess dataAccess = null;
//        try {
//            dataAccess = new SerializeDataAccess();
//        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
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

        String groupName = "csc207";
        String username = "sharonh";
        String username1 = "aarya";

        User user = new NormalUser(username, "pw", "Sharon", "sharon@gmail.com",
                new UserPublicProfile());
        User user1 = new NormalUser(username1, "pww", "Aarya", "aarya@gmail.com",
                new UserPublicProfile());
        CurrentUser currentUser = CurrentUser.getInstance();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                new UserPublicProfile());
        currentUser.setUser(testUser);

        Group group = new NormalGroup(groupName);
        group.addRequest(username);
        group.addRequest(username1);

        user.getApplicationsList().put(groupName, group);
        user1.getApplicationsList().put(groupName, group);

        HashMap<String, User> userMap = new HashMap<>();
        userMap.put(username, user);
        userMap.put(username1, user1);

        HashMap<String, Group> groupMap = new HashMap<>();
        groupMap.put(groupName, group);

        ViewPendingListDsGateway dsGateway = new PendingListDataAccess(userMap, groupMap);
        EditPendingListDsGateway dsGateway1 = new PendingListDataAccess(userMap, groupMap);

        EditPendingListOutputBoundary presenter2 = new EditPendingListPresenter();
        EditPendingListInputBoundary editPendingListInputBoundary = new EditPendingListInteractor(
                dsGateway1, presenter2);
        EditPendingListController editPendingListController = new EditPendingListController(
                editPendingListInputBoundary);

        PendingListScreenBoundary pendingListScreenBoundary = new PendingListScreen(groupName);

        ViewPendingListOutputBoundary presenter1 = new ViewPendingListPresenter(pendingListScreenBoundary);
        ViewPendingListInputBoundary viewPendingListInputBoundary = new ViewPendingListInteractor(
                dsGateway, presenter1);
        ViewPendingListController viewPendingListController = new ViewPendingListController(
                viewPendingListInputBoundary);

        // pending list button pressed
        pendingListScreenBoundary.setViewPendingListController(viewPendingListController);
        pendingListScreenBoundary.setEditPendingListController(editPendingListController);
        pendingListScreenBoundary.view();

        //ViewGroupMembersDsGateway dsGateway2 = new PendingListDataAccess(userMap, groupMap);
        //ViewGroupMembersOutputBoundary presenter3 = new ViewGroupMembersPresenter();
        //ViewGroupMembersInputBoundary viewGroupMembersInputBoundary = new ViewGroupMembersInteractor(
                //dsGateway2, presenter3);
        //ViewGroupMembersController viewGroupMembersController = new ViewGroupMembersController(
               // viewGroupMembersInputBoundary);

        //PendingListScreen pendingList = new PendingListScreen(editPendingListController, viewPendingListController,
                //groupName);
        //GroupMembersScreen groupMembers = new GroupMembersScreen(viewGroupMembersController, groupName);
    }
}
