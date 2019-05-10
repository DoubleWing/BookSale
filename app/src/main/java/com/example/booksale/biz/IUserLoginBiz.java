package com.example.booksale.biz;

/*
*login登录业务类接口
*/
public interface IUserLoginBiz
{
     void login(String username, String password, OnLoginListener loginListener);
}
