package view_user_public_profile_screens;
import use_cases.view_user_public_profile_use_case.ViewUserPublicProfileOutputBoundary;
import use_cases.view_user_public_profile_use_case.ViewUserPublicProfileResponseModel;

import javax.swing.*;


public class ViewUserPublicProfilePresenter implements ViewUserPublicProfileOutputBoundary {
    private final ViewUserPublicProfileScreenBoundary screen;

    public ViewUserPublicProfilePresenter(ViewUserPublicProfileScreenBoundary screen) {
        this.screen = screen;
    }

    @Override
    public void prepareSuccessView(ViewUserPublicProfileResponseModel userPublicProfileInfo) {
        screen.setBio(userPublicProfileInfo.getBio());
        screen.setUsername(userPublicProfileInfo.getUsername());
        screen.setCourses(userPublicProfileInfo.getUserCoursePreferences());
        screen.setUserPreferences(userPublicProfileInfo.getUserPreferences());
        screen.build();
    }

    @Override
    public void prepareFailView(String error) {
        JOptionPane.showMessageDialog(null, error);
    }
}
