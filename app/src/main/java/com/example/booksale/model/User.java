package com.example.booksale.model;
//实体类方法（model-User）
public class User {
    private String username ;
    private String password ;
    private int id;

//    public User(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }
//    @Override
//    public String toString() {
//        return "UserLoginBean{" +
//                "Username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

}