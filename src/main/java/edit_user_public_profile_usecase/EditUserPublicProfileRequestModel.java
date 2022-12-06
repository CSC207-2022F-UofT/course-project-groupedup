package edit_user_public_profile_usecase;

import java.util.HashMap;

/**
 * The data that is being bundled for the edit user public profile use case.
 */
public class EditUserPublicProfileRequestModel {
    private final String username;
    private String bio;
    private String courseCodes;
    private String location;
    private String meetingTime;
    private String timeCommitment;

    /**
     *
     * @param username the user's username.
     * @param bio the user's profile's biography.
     * @param courseCodes the user's preferred courses.
     * @param timeCommitment the user's preferred time commitment.
     * @param location the user's preferred location.
     * @param meetingTime the user's preferred meeting time.
     */
    public EditUserPublicProfileRequestModel(String username, String bio, String courseCodes,
                                             String location, String meetingTime, String timeCommitment) {
        this.bio = bio;
        this.courseCodes = courseCodes;
        this.username = username;
        this.location = location;
        this.meetingTime = meetingTime;
        this.timeCommitment = timeCommitment;
    }

    public String getUsername() {
        return this.username;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setCoursePreferences(String courseCodes) {
        this.courseCodes = courseCodes;
    }
    public String getCoursePreferences() {
        return courseCodes;
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
        HashMap<String, String> newPreferences = new HashMap<>();
        newPreferences.put("Location", this.location);
        newPreferences.put("Time Commitment", this.timeCommitment);
        newPreferences.put("Meeting Time", this.meetingTime);
        return newPreferences;
    }
}
