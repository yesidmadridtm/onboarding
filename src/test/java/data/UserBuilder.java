package data;

public class UserBuilder implements Builder{
    private String username;
    private String password;

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public User getResult() {
        return new User(username, password);
    }
}

//username = "Admin";
  //      password = "admin123";