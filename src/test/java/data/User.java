package data;

public class User {
    public static String username;
    public static String password;

    public User(){
        username = "Admin";
        password = "admin123";
    }

    public User(String user, String pass){
        username = user;
        password = pass;
    }
}
