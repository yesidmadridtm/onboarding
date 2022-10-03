package data;

public class UserBuilder {
    private String username;
    private String password;

    public UserBuilder(){
        username = "";
        password = "";
    }

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public static User getUser() {
        return new UserBuilder().setUsername("Admin").setPassword("admin123").build();
    }

    public User build(){
        return new User(username, password);
    }
}

//username = "Admin";
  //      password = "admin123";