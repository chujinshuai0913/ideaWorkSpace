package common.model;

public class SearchHistory {
    private Integer id;

    private Integer userId;

    private String bookId;

    private Integer searchTime;

    private Integer num;

    public SearchHistory(Integer id, Integer userId, String bookId, Integer searchTime, Integer num) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.searchTime = searchTime;
        this.num = num;
    }

    public SearchHistory() {
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

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }

    public Integer getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Integer searchTime) {
        this.searchTime = searchTime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}