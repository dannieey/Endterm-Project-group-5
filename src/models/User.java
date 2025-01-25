package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    //setters?

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

    //создала сеттерс на всякий если пользователь захочет их изменить в будущем
    public void setName(String name){
        this.name=name;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public void setUserName(String user_name){
        this.user_name=user_name;
    }
    public void setEmail(String email){
        this.email=email;
    }

    //1st sub-issue of RegisterUser issue - checking the data
    public void registerUser(String name, String surname, String user_name, String email) throws SQLException {
        if(name==null || name.isEmpty() || surname==null || surname.isEmpty() || user_name==null || user_name.isEmpty() || email==null || email.isEmpty()){
            throw new IllegalArgumentException("All fields are required!"); //тип RuntimeException, который возникает, когда метод вызывается с недопустимым или неподходящим аргументом
        }
        //2nd subset-checking email address
        if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
            throw new IllegalArgumentException("Email address is invalid!");
        }


        //3d subset-save user data to the database (users table)

        //это SQL запрос, который добавляет все данные пользователя в таблицу users
        String sql="INSERT INTO users(name, surname, user_name, email) VALUES(?,?,?,?)";

        //метод возвращающий объект Connectionкоторый помогает взаимодействовать с бд
        try (Connection connection = DatabaseConnection.getConnection()) {
            //PreparedStatement - классЮ для выполнения самих скл запросов(+защищает)
            PreparedStatement statement = connection.prepareStatement(sql);

                //здесь просто связываем все значения с запросом
                statement.setString(1, name);
                statement.setString(2, surname);
                statement.setString(3, user_name);
                statement.setString(4, email);
                statement.executeUpdate(); //отвечает за обновление данных в бд
                System.out.println(statement.toString());
            }

        catch(SQLException error){ //если все таки возникнет ошибка
            //error.printStackTrace(); //просто чтобы чекать где произошла ошибка и потом выводит в каком месте(крч вывод в консоль)
            throw new RuntimeException("Error during user registration.");
            //общий класс для всех исключений времени выполнений (без конкретики если сравниват с предыдущим эксепшн)

        }


    }

    @Override
    public String toString() {
        return user_name+' '+"has been successfully registered!";
    }
}


