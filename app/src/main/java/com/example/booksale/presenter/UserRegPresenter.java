package com.example.booksale.presenter;

import android.os.Handler;

import com.example.booksale.biz.IUserRegBiz;
import com.example.booksale.biz.OnRegListener;
import com.example.booksale.biz.RegBiz;
import com.example.booksale.model.User;
import com.example.booksale.view.IUserRegView;

public class UserRegPresenter {

    private IUserRegBiz userBiz;
    private IUserRegView userRegView;
    private Handler mHandler = new Handler();

    public UserRegPresenter(IUserRegView userRegView)
    {
        this.userRegView = userRegView;
        this.userBiz = new RegBiz();
    }

    public void reglister()
    {
//        userRegView.showLoading();
        userBiz.reglister(userRegView.getUserName(), userRegView.getPassword(), new OnRegListener()
        {

            @Override
            public void regSuccess(final User user)
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {

                        userRegView.toLoginActivity(user);

//                        userRegView.hideLoading();
                    }
                });

            }

            @Override
            public void regFailed()
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userRegView.showFailedError();
//                        userRegView.hideLoading();
                    }
                });

            }







        });
    }

}
