package view_user_public_profile_screens;

import java.util.HashMap;

public interface ViewUserPublicProfileScreenBoundary {
    void build();

    /**
     * Sets the controller so that the screen can call the view use case.
     * @param viewUserPublicProfileController view user public profile controller.
     */
    void setController(ViewUserPublicProfileController viewUserPublicProfileController);
    void setUsername(String username);
    void setBio(String bio);
    void setCourses(String courses);

    void setUserPreferences(HashMap<String, String> preferences);
}
