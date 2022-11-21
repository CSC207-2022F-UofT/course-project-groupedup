package view_user_public_profile_usecase;
import java.util.HashMap;

/**
 * The view user public profile response model.
 */
public class ViewUserPublicProfileResponseModel {
    private HashMap<String, String> userPreferences;
    private String userCoursePreferences;
    private String bio;

    /**
     *
     * @param userPreferences The user's current preferences.
     * @param userCoursePreferences The user's current course preferences.
     * @param bio The user's current bio.
     */
    ViewUserPublicProfileResponseModel(HashMap<String, String> userPreferences,
                                       String userCoursePreferences,
                                       String bio) {
        this.userPreferences = userPreferences;
        this.userCoursePreferences = userCoursePreferences;
        this.bio = bio;
    }
}
