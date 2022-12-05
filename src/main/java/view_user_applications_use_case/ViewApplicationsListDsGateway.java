package view_user_applications_use_case;

import Entities.User;

/**
 * The data access interface for the view applications use case.
 */
public interface ViewApplicationsListDsGateway {
    User getUser(String username);
}
