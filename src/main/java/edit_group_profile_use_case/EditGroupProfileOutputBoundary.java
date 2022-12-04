package edit_group_profile_use_case;

public interface EditGroupProfileOutputBoundary {

    void prepareSuccessView(EditGroupProfileResponseModel newChanges);

    void prepareFailView(String error);
}
