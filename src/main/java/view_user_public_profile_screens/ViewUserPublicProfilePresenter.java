package view_user_public_profile_screens;
import view_user_public_profile_usecase.ViewUserPublicProfileOutputBoundary;
import view_user_public_profile_usecase.ViewUserPublicProfileResponseModel;


public class ViewUserPublicProfilePresenter implements ViewUserPublicProfileOutputBoundary {
    private final ViewUserPublicProfileScreenBoundary screen;

    public ViewUserPublicProfilePresenter(ViewUserPublicProfileScreenBoundary screen) {
        this.screen = screen;
    }

    /**
     * Displays success by building the user's profile screen.
     * @param userPublicProfileInfo has the user's public profile information.
     */
    @Override
    public void prepareSuccessView(ViewUserPublicProfileResponseModel userPublicProfileInfo) {
        screen.setBio(userPublicProfileInfo.getBio());
        screen.setUsername(userPublicProfileInfo.getUsername());
        screen.setCourses(userPublicProfileInfo.getUserCoursePreferences());
        screen.setUserPreferences(userPublicProfileInfo.getUserPreferences());
        screen.build();
    }
}
