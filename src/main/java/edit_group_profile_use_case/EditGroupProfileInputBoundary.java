package edit_group_profile_use_case;
/**
 * This is an interface between the controller and the interactor.
 * The interactor implements this interface to create dependency inversion.
 */

public interface EditGroupProfileInputBoundary {
    /**
     * Triggers the EditGroupProfileUseCase.
     * @param requestModel
     * @return
     */
    boolean editGroup(EditGroupProfileRequestModel requestModel);

}

