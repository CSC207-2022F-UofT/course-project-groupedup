package view_user_public_profile_usecase;
import java.util.HashMap;

/**
 * The view user public profile response model.
 */
public class ViewUserPublicProfileResponseModel {
    private String username;
    private HashMap<String, String> userPreferences;
    private String userCoursePreferences;
    private String bio;

    /**
     *
     * @param userPreferences The user's current preferences.
     * @param userCoursePreferences The user's current course preferences.
     * @param bio The user's current bio.
     */
    ViewUserPublicProfileResponseModel(String username,
                                       HashMap<String, String> userPreferences,
                                       String userCoursePreferences,
                                       String bio) {
        this.username = username;
        this.userPreferences = userPreferences;
        this.userCoursePreferences = userCoursePreferences;
        this.bio = bio;
    }

    public String getUsername() {
        return this.username;
    }

    public HashMap<String, String> getUserPreferences() {
        return this.userPreferences;
    }

    public String getUserCoursePreferences() {
        return this.userCoursePreferences;
    }

    public String getBio() {
        return this.bio;
    }
}

