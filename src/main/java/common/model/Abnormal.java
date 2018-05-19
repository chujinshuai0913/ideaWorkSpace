package common.model;

public class Abnormal {
    private Integer id;

    private Integer userId;

    private Integer num;

    public Abnormal(Integer id, Integer userId, Integer num) {
        this.id = id;
        this.userId = userId;
        this.num = num;
    }

    public Abnormal() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}