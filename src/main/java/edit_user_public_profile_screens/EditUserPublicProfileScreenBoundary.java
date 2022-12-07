package edit_user_public_profile_screens;

import javax.swing.*;

public interface EditUserPublicProfileScreenBoundary {
    /**
     * Sets the controller for the screen so that it can call use case when a button is pressed.
     * @param editUserPublicProfileController the edit user public profile controller.
     */
    void setController(EditUserPublicProfileController editUserPublicProfileController);
    void setUsername(String username);
    void buildButtons();
    JPanel buildTimeCommitmentOptions();
    JPanel buildLocationOptions();
    JPanel buildMeetingTimeOptions();
    void buildScrollPane();
    JPanel buildProfileInfo();

}
