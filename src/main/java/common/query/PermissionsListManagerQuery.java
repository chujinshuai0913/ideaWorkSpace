package common.query;

public class PermissionsListManagerQuery extends QueryParam {
    private Integer id;

    private String url;

    private String urlName;

    private Integer status;

    public PermissionsListManagerQuery(Integer id, String url, String urlName, Integer status) {
        this.id = id;
        this.url = url;
        this.urlName = urlName;
        this.status = status;
    }

    public PermissionsListManagerQuery() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName == null ? null : urlName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}