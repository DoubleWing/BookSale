package com.example.booksale.view;

import com.example.booksale.model.User;

public interface IUserRegView {
    //得到用户名的操作
    String getUserName();

    //得到密码的操作
    String getPassword();

    //成功跳转到主界面
    void toLoginActivity(User user);

    //失败显示提醒
    void showFailedError();

}
