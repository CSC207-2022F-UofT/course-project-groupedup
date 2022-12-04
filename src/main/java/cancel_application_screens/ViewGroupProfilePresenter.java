package cancel_application_screens;

import view_group_profile_use_case.ViewGroupProfileOutputBoundary;
import view_group_profile_use_case.ViewGroupProfileResponseModel;

/**
 * The presenter class for the view group profile use case
 */
public class ViewGroupProfilePresenter implements ViewGroupProfileOutputBoundary {
    private final GroupProfileScreenBoundary screen;

    public ViewGroupProfilePresenter(GroupProfileScreenBoundary groupProfileScreen) {
        this.screen = groupProfileScreen;
    }

    @Override
    public void prepareSuccessView(ViewGroupProfileResponseModel groupInfo) {
        screen.setGroupName(groupInfo.getGroupName());
        screen.setGroupDescription(groupInfo.getDescription());
        screen.setGroupPreferences(groupInfo.getPreferences());
        screen.view();
    }
}
