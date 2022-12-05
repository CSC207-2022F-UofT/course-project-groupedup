package edit_group_profile_use_case;

import java.util.HashMap;

/**
 * A data bundle which is passed to the database.
 */

public class EditGroupProfileDsRequestModel {

    private String groupName;
    private String courseCode;
    private String description;
    private String timeCommitment; //make sure not negative number
    private String location;
    private String meetingTime; //morning, afternoon, evening or day of the week

    public EditGroupProfileDsRequestModel(String groupName, String description, String timeCommitment,
                                          String location, String meetingTime, String courseCode) {
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

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     *
     * @return the group's selected course code.
     */
    public String getCourseCode() {
        return this.courseCode;
    }

    /**
     *
     * @return the group description.
     */
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return the group's time commitment (hours per week)
     */
    public String getTimeCommitment() {
        return this.timeCommitment;
    }

    public void setTimeCommitment(String timeCommitment) {
        this.timeCommitment = timeCommitment;
    }

    /**
     *
     * @return the group's meeting location (online or in-person)
     */
    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return the group's meeting time (day of the week?)
     */
    public String getMeetingTime() {
        return this.meetingTime;
    }

    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime;
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

