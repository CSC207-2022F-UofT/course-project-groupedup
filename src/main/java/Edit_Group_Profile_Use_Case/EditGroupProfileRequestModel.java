package Edit_Group_Profile_Use_Case;
import java.util.HashMap;
import java.util.*;

public class EditGroupProfileRequestModel {
    private String groupName;
    private String courseCode;
    private String description;
    private String timeCommitment; //make sure not negative number
    private String location;
    private String meetingTime; //morning, afternoon, evening or day of the week

    public EditGroupProfileRequestModel(String groupName, String description, String timeCommitment, String location, String meetingTime, String courseCode) {
        this.groupName = groupName;
        this.description = description;
        this.timeCommitment = timeCommitment;
        this.location = location;
        this.meetingTime = meetingTime;
        this.courseCode = courseCode;
    }


    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean setCourseCode(String courseCode) {
        if (validateCourseCode(courseCode)) {
            this.courseCode = courseCode;
            return true;
        }
        return false;
    }

    public String getCourseCode() {
        return this.courseCode;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeCommitment() {
        return this.timeCommitment;
    }

    public void setTimeCommitment(String timeCommitment) {
        this.timeCommitment = timeCommitment;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMeetingTime() {
        return this.meetingTime;
    }

    public boolean setMeetingTime(String meetingTime) {
        if (validateMeetingTime(meetingTime)) {
            this.meetingTime = meetingTime;
            return true;
        }
        return false;
    }
    public boolean validateMeetingTime(String meetingTime) {
        ArrayList<String> daysOfWeek = new ArrayList<String>();
        return daysOfWeek.contains(meetingTime);
    }

    public HashMap<String, String> getPreferences() {
        HashMap<String, String> preferences = new HashMap<String, String>();
        preferences.put("Time Commitment", this.timeCommitment);
        preferences.put("Location", this.location);
        preferences.put("Meeting Time", this.meetingTime);
        preferences.put("Course Code", this.courseCode);

        return preferences;
    }
}
