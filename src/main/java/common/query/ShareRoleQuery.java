package common.query;

public class ShareRoleQuery extends QueryParam {
    private Integer id;

    private String role;

    private Integer permissions;

    public ShareRoleQuery(Integer id, String role, Integer permissions) {
        this.id = id;
        this.role = role;
        this.permissions = permissions;
    }

    public ShareRoleQuery() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public Integer getPermissions() {
        return permissions;
    }

    public void setPermissions(Integer permissions) {
        this.permissions = permissions;
    }
}