package com.example.booksale.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.booksale.R;
import com.example.booksale.fragment.HomeFragment;
import com.example.booksale.model.User;
import com.example.booksale.presenter.UserLoginPresenter;

//LoginView的实现类————就是LoginActivity
public class UserLoginActivity extends AppCompatActivity implements IUserLoginView
{


    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);
    public static final String TAG="Login";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        initViews();
    }

    private void initViews()
    {
        mEtUsername = (EditText) findViewById(R.id.login_edit_account);
        mEtPassword = (EditText) findViewById(R.id.login_edit_pwd);

        mBtnClear = (Button) findViewById(R.id.btn_clear);
        mBtnLogin = (Button) findViewById(R.id.login_btn_login);

        mPbLoading = (ProgressBar) findViewById(R.id.progress_bar);

        mBtnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserLoginPresenter.login();
                //启动
               startActivity(intent);
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserLoginPresenter.clear();


            }
        });
    }


    @Override
    public String getUserName()
    {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword()
    {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName()
    {
        mEtUsername.setText("");
    }

    @Override
    public void clearPassword()
    {
        mEtPassword.setText("");
    }

    @Override
    public void showLoading()
    {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading()
    {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user)
    {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(UserLoginActivity.this, HomeFragment.class);


    }

    @Override
    public void showFailedError()
    {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
}