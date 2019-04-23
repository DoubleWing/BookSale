package com.example.booksale.view;

import com.example.booksale.model.User;

//操作登录视图的接口方法
public interface IUserLoginView {
    //得到用户名的操作
    String getUserName();

    //得到密码的操作
    String getPassword();

    //清空用户名
    void clearUserName();

    //清空密码
    void clearPassword();

    //展示加载控件
    void showLoading();

    //隐藏加载的控件
    void hideLoading();

    //成功跳转到主界面
    void toMainActivity(User user);

    //失败显示提醒
    void showFailedError();




}
