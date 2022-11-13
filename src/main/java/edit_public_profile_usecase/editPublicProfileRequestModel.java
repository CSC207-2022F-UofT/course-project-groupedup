package edit_public_profile_usecase;

import java.util.HashMap;

public class editPublicProfileRequestModel {
    private String bio;
    private String timeCommitment;
    private String location;
    private String meetingTime;

    public editPublicProfileRequestModel(String bio, String timeCommitment, String location, String meetingTime) {
        this.bio = bio;
        this.timeCommitment = timeCommitment;
        this.location = location;
        this.meetingTime = meetingTime;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String Bio) {
        this.bio = bio;
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
        preferences.put("Time Commitment", this.timeCommitment);
        preferences.put("Location", this.location);
        preferences.put("meetingTime", this.meetingTime);

        return preferences;
    }
}
