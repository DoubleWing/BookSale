package com.example.booksale.biz;

import com.example.booksale.model.User;

public interface OnRegListener {

    //注册成功
    void regSuccess(User user);

    //注册失败
    void regFailed();
}
