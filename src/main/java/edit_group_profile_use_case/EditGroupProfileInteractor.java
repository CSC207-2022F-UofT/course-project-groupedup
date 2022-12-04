package edit_group_profile_use_case;
import edit_group_profile_screens.EditGroupProfilePresenter;
import Entities.NormalGroup;

import java.util.ArrayList;

public class EditGroupProfileInteractor implements EditGroupProfileInputBoundary {

    final EditGroupProfileDsGateway profileDSGateway;
    final EditGroupProfileOutputBoundary profileOutputBoundary;
    final EditGroupProfilePresenter editGroupProfilePresenter;

    public EditGroupProfileInteractor(EditGroupProfileDsGateway profileDSGateway,
                                      EditGroupProfileOutputBoundary profileOutputBoundary, EditGroupProfilePresenter editGroupProfilePresenter) {
        this.profileDSGateway = profileDSGateway;
        this.profileOutputBoundary = profileOutputBoundary;
        this.editGroupProfilePresenter = editGroupProfilePresenter;
    }

    public boolean validateCourseCode(String courseCode) {
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
    }

    public boolean validateMeetingTime(String meetingTime) {
        ArrayList<String> daysOfWeek = new ArrayList<String>();
        daysOfWeek.add("Monday");
        daysOfWeek.add("Tuesday");
        daysOfWeek.add("Wednesday");
        daysOfWeek.add("Thursday");
        daysOfWeek.add("Friday");
        daysOfWeek.add("Saturday");
        daysOfWeek.add("Sunday");
        return daysOfWeek.contains(meetingTime);
    }

    @Override
    public void editGroup(EditGroupProfileRequestModel requestModel) {
        EditGroupProfileResponseModel editFailResponseModel =
                new EditGroupProfileResponseModel(requestModel.getGroupName(), requestModel.getPreferences(),
                        requestModel.getCourseCode(),
                        requestModel.getDescription(), "");

        if (!validateCourseCode(requestModel.getCourseCode())) {
            editGroupProfilePresenter.prepareFailView("Invalid Course Code Entered.");
        }

        if (!validateMeetingTime(requestModel.getMeetingTime())) {
            editGroupProfilePresenter.prepareFailView("Invalid Meeting Time Entered.");
        }

        if (profileDSGateway.existsByGroupName(requestModel.getGroupName())) {
            NormalGroup group = profileDSGateway.findGroup(requestModel.getGroupName());
            //group.getGroupProfile().setPreferences(requestModel.getPreferences());
            //group.getGroupProfile().setCourseCode(requestModel.getCourseCode());
            //group.getGroupProfile().setDescription(requestModel.getDescription());


            EditGroupProfileResponseModel profileResponseModel = new EditGroupProfileResponseModel(
                    requestModel.getGroupName(),
                    requestModel.getPreferences(),
                    requestModel.getCourseCode(),
                    requestModel.getDescription(),
                    "Edits made successfully.");

            editGroupProfilePresenter.prepareSuccessView(profileResponseModel);
        } else {
            editGroupProfilePresenter.prepareFailView("Group does not exist. Please try again.");
        }
    }
}