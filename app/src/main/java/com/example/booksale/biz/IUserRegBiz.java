package com.example.booksale.biz;

public interface IUserRegBiz {
    //注册
    void reglister(String username, String password, OnRegListener RegListener);
}
