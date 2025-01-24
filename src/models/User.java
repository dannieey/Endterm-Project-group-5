package models;

public class User {
    private String name;
    private String surname;
    private String user_name;
    private String email;


    public User(String name, String surname, String user_name, String email) {
        this.name=name;
        this.surname=surname;
        this.user_name=user_name;
        this.email=email;
    }

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getUserName(){
        return user_name;
    }
    public String getEmail(){
        return email;
    }
}


