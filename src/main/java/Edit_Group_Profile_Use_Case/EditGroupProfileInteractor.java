package Edit_Group_Profile_Use_Case;
import Entities.NormalGroup;
import Entities.Group;

import java.util.ArrayList;

public class EditGroupProfileInteractor implements EditGroupProfileInputBoundary {

    final EditGroupProfileDsGateway profileDSGateway;
    final EditGroupProfileOutputBoundary profileOutputBoundary;

    public EditGroupProfileInteractor(EditGroupProfileDsGateway profileDSGateway, EditGroupProfileOutputBoundary profileOutputBoundary) {
        this.profileDSGateway = profileDSGateway;
        this.profileOutputBoundary = profileOutputBoundary;
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
    public EditGroupProfileResponseModel editGroup(EditGroupProfileRequestModel requestModel) {
        EditGroupProfileResponseModel editFailResponseModel =
                new EditGroupProfileResponseModel(requestModel.getPreferences(), requestModel.getCourseCode(),
                        requestModel.getDescription(), "");

        if (!validateCourseCode(requestModel.getCourseCode())) {
            return profileOutputBoundary.prepareFailView("Invalid Course Code Entered.");
        }

        if (!validateMeetingTime(requestModel.getMeetingTime())) {
            return profileOutputBoundary.prepareFailView("Invalid Meeting Time Entered.");
        }

        if (profileDSGateway.existsByGroupName(requestModel.getGroupName())) {
            NormalGroup group = profileDSGateway.findGroup(requestModel.getGroupName());
            // group.getGroupProfile().setPreferences(requestModel.getPreferences());
            // group.getGroupProfile().setCourseCode(requestModel.getCourseCode());
            // group.getGroupProfile().setDescription(requestModel.getDescription());


            EditGroupProfileResponseModel profileResponseModel = new EditGroupProfileResponseModel(
                    requestModel.getPreferences(),
                    requestModel.getCourseCode(),
                    requestModel.getDescription(),
                    "Edits made successfully.");

            return profileOutputBoundary.prepareSuccessView(profileResponseModel);
        } else {
            return profileOutputBoundary.prepareFailView("Group does not exist. Please try again.");
        }
    }
}