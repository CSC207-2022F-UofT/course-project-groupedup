package edit_user_public_profile_screens;

import javax.swing.*;

public interface EditUserPublicProfileScreenBoundary {
    void setController(EditUserPublicProfileController editUserPublicProfileController);
    void setUsername(String username);
    void buildButtons();
    JPanel buildTimeCommitmentOptions();
    JPanel buildLocationOptions();
    JPanel buildMeetingTimeOptions();
    void buildScrollPane();
    JPanel buildProfileInfo();

}
