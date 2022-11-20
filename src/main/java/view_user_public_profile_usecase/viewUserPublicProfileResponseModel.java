package view_user_public_profile_usecase;
import java.util.HashMap;

public class viewUserPublicProfileResponseModel {
    private HashMap<String, String> userPreferences;
    private String userCoursePreferences;
    private String bio;

    viewUserPublicProfileResponseModel(HashMap<String, String> userPreferences,
                                       String userCoursePreferences,
                                       String bio) {
        this.userPreferences = userPreferences;
        this.userCoursePreferences = userCoursePreferences;
        this.bio = bio;
    }
}
