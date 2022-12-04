package edit_group_profile_use_case;

import Entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TestEditGroupProfileInteractor {
    @BeforeEach
    void beforeEach(){
        CurrentUser currentUser1 = CurrentUser.getInstance();
        UserPublicProfile testProfile = new UserPublicProfile();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                testProfile);
        currentUser1.setUser(testUser);
    }

    @Test
    void test_use_case_success() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("Location", "Online");
        hashMap.put("Meeting Time", "Monday");
        hashMap.put("Time Commitment", "0-2 hours");

        NormalGroup testGroup = new NormalGroup("Julia's Group");
        testGroup.getGroupProfile().setCourseCode("CSC207");
        testGroup.getGroupProfile().setPreferences(hashMap);
        testGroup.getGroupProfile().setDescription("Julia's new study group for CSC207!");

        EditGroupProfileViewModel editGroupProfileViewModel = new EditGroupProfileView(new CardLayout(), new JPanel()){
            @Override
            public void displaySuccess(EditGroupProfileResponseModel editGroupProfileResponseModel) {
                assertEquals("Julia's Group", editGroupProfileResponseModel.getGroupName());
                assertEquals("CSC207", editGroupProfileResponseModel.getNewCourseCode());
                assertEquals("Monday", editGroupProfileResponseModel.getEditedPreferences().get("Meeting Time"));
                assertEquals("Julia's new study group for CSC207!", editGroupProfileResponseModel.getEditedDescription());
            }

            @Override
            public void displayFailure(String error) {
                fail("Use case failure is unexpected.");
            }
        };
    }
}
