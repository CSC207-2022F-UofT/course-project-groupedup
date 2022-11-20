package edit_user_public_profile_usecase;
import java.util.HashMap;

public class EditUserPublicProfileRequestModel {
    private final String username;
    private String bio;
    private String courseCodes;
    private String timeCommitment;
    private String location;
    private String meetingTime;

    public EditUserPublicProfileRequestModel(String username, String bio,
                                             String courseCodes, String timeCommitment,
                                             String location, String meetingTime) {
        this.username = username;
        this.bio = bio;
        this.courseCodes = courseCodes;
        this.timeCommitment = timeCommitment;
        this.location = location;
        this.meetingTime = meetingTime;
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
        HashMap<String, String> preferences = new HashMap<>();
        preferences.put("Time Commitment", this.timeCommitment);
        preferences.put("Location", this.location);
        preferences.put("MeetingTime", this.meetingTime);

        return preferences;
    }
}
