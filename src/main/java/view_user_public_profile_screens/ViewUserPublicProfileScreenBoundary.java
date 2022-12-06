package view_user_public_profile_screens;

import java.util.HashMap;

public interface ViewUserPublicProfileScreenBoundary {
    void build();
    void setController(ViewUserPublicProfileController viewUserPublicProfileController);
    void setUsername(String username);
    void setBio(String bio);
    void setCourses(String courses);

    void setUserPreferences(HashMap<String, String> preferences);
//    void view();
}
