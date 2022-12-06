package view_group_profile_use_case;

import Entities.Group;
import Entities.GroupProfile;

import java.util.HashMap;

/**
 * The view group profile use case.
 * Allows the user to view this group's profile.
 */
public class ViewGroupProfileInteractor implements ViewGroupProfileInputBoundary {
    final ViewGroupProfileDsGateway dsGateway;
    final ViewGroupProfileOutputBoundary outputBoundary;
    final ViewGroupProfileErrorMessages errorMessages = new ViewGroupProfileErrorMessages();

    /**
     * @param dsGateway the data access interface
     * @param outputBoundary the output boundary implemented by ViewGroupPresenter
     */
    public ViewGroupProfileInteractor(ViewGroupProfileDsGateway dsGateway, ViewGroupProfileOutputBoundary outputBoundary) {
        this.dsGateway = dsGateway;
        this.outputBoundary = outputBoundary;
    }

    /**
     * @param requestModel the requestModel for the view group use case
     */
    @Override
    public void viewGroup(ViewGroupProfileRequestModel requestModel) {
        String groupName = requestModel.getGroupName();

        if (!dsGateway.groupIdentifierExists(groupName)) {
            throw new RuntimeException(errorMessages.getGroupDoesNotExist());
        } else {
            Group group = dsGateway.getGroup(groupName);
            GroupProfile groupProfile = group.getProfile();

            String description = groupProfile.getDescription();
            HashMap<String, String> preferences = new HashMap<>(groupProfile.getPreferences());

            if (description == null) {
                description = "This group has no description.";
            }

            ViewGroupProfileResponseModel groupInfo = new ViewGroupProfileResponseModel(groupName,
                    description, preferences);

            outputBoundary.prepareSuccessView(groupInfo);
        }
    }
}
