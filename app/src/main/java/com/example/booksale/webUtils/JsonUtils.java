package com.example.booksale.webUtils;

import android.util.Log;

import com.example.booksale.model.User;
import com.example.booksale.view.UserLoginActivity;
import com.google.gson.Gson;

public class JsonUtils {


    //解析返回的JSON数据
        public static User parseJSONWithGSON(String jsonData){
        Gson gson = new Gson();
        User user1 = gson.fromJson(jsonData, User.class);
        Log.d(UserLoginActivity.TAG,"id = " + user1.getId());
        Log.d(UserLoginActivity.TAG,"username " + user1.getUsername());
        Log.d(UserLoginActivity.TAG,"password = " + user1.getPassword());
        System.out.print(user1.getId());

        return user1;
    }



}
