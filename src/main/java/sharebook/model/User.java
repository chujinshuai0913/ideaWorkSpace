package sharebook.model;

public class User {
    private Integer id;

    private String username;

    private Integer password;

    private String tbWord;

    public User(Integer id, String username, Integer password, String tbWord) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.tbWord = tbWord;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public String getTbWord() {
        return tbWord;
    }

    public void setTbWord(String tbWord) {
        this.tbWord = tbWord == null ? null : tbWord.trim();
    }
}