package controllers_presenters_and_screen_boundaries.group_register_adapters;

import use_cases.group_creation_use_case.GroupRegisterInputBoundary;
import use_cases.group_creation_use_case.GroupRegisterRequestModel;

/**
 * This is the controller of the use case. It will trigger the interactor and bundle up
 * data to pass to the interactor.
 */
public class GroupRegisterController {
    final GroupRegisterInputBoundary groupInput;

    public GroupRegisterController(GroupRegisterInputBoundary groupInput){ this.groupInput = groupInput;}

    /**
     * This method triggers the Group Creation Use Case.
     * It will create a bundle of data, called the request model with the input from the user
     * which is necessary to create the group.
     * Then, it will call the input boundary to trigger the use case, passing in the request model.
     * @param groupName the input from the user
     */
    public void create(String groupName){
        GroupRegisterRequestModel requestModel = new GroupRegisterRequestModel(groupName);
        groupInput.create(requestModel);
    }

}
