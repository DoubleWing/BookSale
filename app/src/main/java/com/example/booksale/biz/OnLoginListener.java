package com.example.booksale.biz;

import com.example.booksale.model.User;
//回调方法接口
public interface OnLoginListener
{
    void loginSuccess(User user);

    void loginFailed();
}