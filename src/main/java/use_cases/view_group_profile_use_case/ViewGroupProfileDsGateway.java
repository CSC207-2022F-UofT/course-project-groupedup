package use_cases.view_group_profile_use_case;

import entities.Group;

/**
 * The data access interface for the view group profile use case.
 */
public interface ViewGroupProfileDsGateway {
    boolean groupIdentifierExists(String groupName);
    Group getGroup(String groupName);
}
