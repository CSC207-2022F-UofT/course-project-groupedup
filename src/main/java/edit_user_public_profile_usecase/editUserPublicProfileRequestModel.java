package edit_user_public_profile_usecase;

import java.util.HashMap;

public class editUserPublicProfileRequestModel {
    private String bio;
    private String courseCode;
    private String timeCommitment;
    private String location;
    private String meetingTime;

    public editUserPublicProfileRequestModel(String bio, String courseCode, String timeCommitment, String location, String meetingTime) {
        this.bio = bio;
        this.courseCode = courseCode;
        this.timeCommitment = timeCommitment;
        this.location = location;
        this.meetingTime = meetingTime;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
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

    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime;
    }

    public HashMap<String, String> getPreferences() {
        HashMap<String, String> preferences = new HashMap<String, String>();
        preferences.put("courseCode", this.courseCode);
        preferences.put("timeCommitment", this.timeCommitment);
        preferences.put("location", this.location);
        preferences.put("meetingTime", this.meetingTime);

        return preferences;
    }
}
