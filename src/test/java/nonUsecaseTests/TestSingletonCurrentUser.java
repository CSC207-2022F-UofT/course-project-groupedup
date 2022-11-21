package nonUsecaseTests;

import Entities.CurrentUser;
import Entities.NormalUser;
import Entities.User;
import Entities.UserPublicProfile;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Objects;

class TestSingletonCurrentUser {

    @Test
    public void singletonSameInstance() {
        CurrentUser currentUser1 = CurrentUser.getInstance();
        CurrentUser currentUser2 = CurrentUser.getInstance();
        assert currentUser1 == currentUser2;
    }
    @Test
    public void singletonSaveInitialUser() {
        CurrentUser currentUser1 = CurrentUser.getInstance();
        UserPublicProfile testProfile = new UserPublicProfile();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                testProfile);
        currentUser1.setUser(testUser);
        assert currentUser1.getUser() == testUser;
    }
    @Test
    public void singletonSaveNewUser() {
        CurrentUser currentUser1 = CurrentUser.getInstance();
        UserPublicProfile testProfile1 = new UserPublicProfile();
        User testUser1 = new NormalUser("testUser1", "testUser1", "testUser1", "testUser1",
                testProfile1);
        UserPublicProfile testProfile2 = new UserPublicProfile();
        User testUser2 = new NormalUser("testUser2", "testUser2", "testUser2", "testUser2",
                testProfile2);
        currentUser1.setUser(testUser1);
        System.out.println("current user:" + currentUser1.getUser().getUsername());
        currentUser1.setUser(testUser2);
        System.out.println("current user:" + currentUser1.getUser().getUsername());
        assert currentUser1.getUser() == testUser2;
    }
    @Test
    public void singletonDeleteUser() {
        CurrentUser currentUser1 = CurrentUser.getInstance();
        UserPublicProfile testProfile = new UserPublicProfile();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                testProfile);
        currentUser1.setUser(testUser);
        currentUser1.deleteUser();
        assert Objects.isNull(currentUser1.getUser());
    }
    @Test
    public void singletonGetUser() {
        // in main
        CurrentUser currentUser1 = CurrentUser.getInstance();
        UserPublicProfile testProfile = new UserPublicProfile();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                testProfile);
        currentUser1.setUser(testUser);
        // in specific use case
        User assertUser = CurrentUser.getInstance().getUser();
        assert assertUser == testUser;
    }
}
