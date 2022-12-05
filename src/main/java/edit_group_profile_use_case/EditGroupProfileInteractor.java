package edit_group_profile_use_case;
import edit_group_profile_screens.EditGroupProfilePresenter;
import edit_group_profile_use_case.EditGroupProfileErrorMessages;
import Entities.NormalGroup;

import java.util.ArrayList;

public class EditGroupProfileInteractor implements EditGroupProfileInputBoundary {

    final EditGroupProfileDsGateway profileDSGateway;
    final EditGroupProfileOutputBoundary profileOutputBoundary;
    final EditGroupProfileErrorMessages errorMessages = new EditGroupProfileErrorMessages();

    public EditGroupProfileInteractor(EditGroupProfileDsGateway profileDSGateway,
                                      EditGroupProfileOutputBoundary profileOutputBoundary) {
        this.profileDSGateway = profileDSGateway;
        this.profileOutputBoundary = profileOutputBoundary;
    }

    public boolean validateCourseCode(String courseCode) {
        if (!(courseCode.equals("Other") | courseCode.equals("other"))) {
            char[] letters = courseCode.substring(0, 3).toCharArray();
            char[] numbers = courseCode.substring(3, 6).toCharArray();
            for (char c : letters) {
                if (!Character.isLetter(c)) {
                    return false;
                }
            }
            for (char c : numbers) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return courseCode.length() == 6;
        } else {
            return true;
        }
    }

    /** Executes the Edit Group Profile Use Case.
     * Takes in a request model and checks if the group exists, given a unique group name.
     * If the group name is empty then it will get the presenter to display failure.
     * If the group exists, its group profile will be edited, saved to
     * the database, and the presenter will display success.
     * @param requestModel
     * @return
     */

    @Override
    public boolean editGroup(EditGroupProfileRequestModel requestModel) {
        EditGroupProfileResponseModel editFailResponseModel =
                new EditGroupProfileResponseModel(requestModel.getGroupName(), requestModel.getPreferences(),
                        requestModel.getCourseCode(),
                        requestModel.getDescription(), "");

        if (!validateCourseCode(requestModel.getCourseCode())) {
            profileOutputBoundary.prepareFailView(errorMessages.getInvalidCourseCodeFailureMessage());
            return false;
        }

        if (!profileDSGateway.existsByGroupName(requestModel.getGroupName())) {
            profileOutputBoundary.prepareFailView(errorMessages.getGroupNotFoundFailureMessage());
            return false;
        } else {

            NormalGroup group = profileDSGateway.findGroup(requestModel.getGroupName());
            group.getProfile().setPreferences(requestModel.getPreferences());
            group.getProfile().setCourseCode(requestModel.getCourseCode());
            group.getProfile().setDescription(requestModel.getDescription());


            EditGroupProfileResponseModel profileResponseModel = new EditGroupProfileResponseModel(
                    requestModel.getGroupName(),
                    requestModel.getPreferences(),
                    requestModel.getCourseCode(),
                    requestModel.getDescription(),
                    "Edits made successfully.");

            profileOutputBoundary.prepareSuccessView(profileResponseModel);
            return true;
        }
    }
}