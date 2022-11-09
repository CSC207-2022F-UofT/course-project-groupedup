package group_creation_screens;


// Need?

/**
 * Used by Spring to know what data to maintain. It's used by JpaRepository,
 * Spring's root of the programmer-written persistence classes mapping data to =
 * storage.
 */
class GroupDataMapper {

    String groupname;


    public GroupDataMapper() {
    }

    public GroupDataMapper(String groupname) {
        super();
        this.groupname = groupname;
    }

    public String getGroupName() {
        return groupname;
    }

    public void setGroupName(String name) {
        this.groupname = groupname;
    }
}
