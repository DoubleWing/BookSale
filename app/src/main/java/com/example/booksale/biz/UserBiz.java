package com.example.booksale.biz;

import android.util.Log;

import com.example.booksale.model.User;
import com.example.booksale.view.UserLoginActivity;
import com.example.booksale.webUtils.OkHttpUtils;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.example.booksale.webUtils.Urls.login_url;


/*
* 登录业务实现类
*
* 1.实现接口方法
* 2.开辟了子线程
* 3.回调接口来通知登陆状态
*
* */


public class UserBiz implements IUserBiz {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener)
    {
        //子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
//                if ("zz".equals(username) && "123".equals(password))
//                {
//                    User user = new User();
//                    user.setUsername(username);
//                    user.setPassword(password);
//                    loginListener.loginSuccess(user);
//                } else
//                {
//                    loginListener.loginFailed();
//                }

                 final User user = new User();

                user.setUsername(username);
                user.setPassword(password);
                //判断用户名和密码是否为空
                if (username.isEmpty()||password.isEmpty()){
                    loginListener.loginFailed();
                }else {
                    //实现工具类进行网络请求
                    OkHttpUtils.sendOkHttpRequest(login_url, user, new Callback() {

                        @Override
                        public void onFailure(Call call, IOException e) {
                            loginListener.loginFailed();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String responseData = response.body().string();
                            System.out.println("1-服务器Json信息： " + responseData);
                            //gson解析
                            Gson gson = new Gson();
                            User user1 = gson.fromJson(responseData, User.class);
                            Log.d(UserLoginActivity.TAG,"id = " + user1.getId());
                            Log.d(UserLoginActivity.TAG,"username " + user1.getUsername());
                            Log.d(UserLoginActivity.TAG,"password = " + user1.getPassword());
                            //判断登陆
                            int code = user1.getId();
                            if(code==0){
                                System.out.println("2-用户ID： " + user1.getId());
                                loginListener.loginFailed();

                            }else {
                                System.out.println("2-用户ID： " + user1.getId());
                                loginListener.loginSuccess(user);
                            }
                        }
                    });

                }






            }
        }.start();
    }

}
