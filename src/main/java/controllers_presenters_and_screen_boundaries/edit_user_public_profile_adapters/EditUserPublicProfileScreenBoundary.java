package controllers_presenters_and_screen_boundaries.edit_user_public_profile_adapters;

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
