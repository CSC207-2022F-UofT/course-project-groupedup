package edit_group_profile_use_case;


public interface EditGroupProfileInputBoundary {
    /**
     * Triggers the EditGroupProfileUseCase.
     * @param requestModel
     * @return
     */
    void editGroup(EditGroupProfileRequestModel requestModel);

}

