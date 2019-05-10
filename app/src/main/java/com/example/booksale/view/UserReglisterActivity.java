package com.example.booksale.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.booksale.R;
import com.example.booksale.model.User;
import com.example.booksale.presenter.UserRegPresenter;

public class UserReglisterActivity extends AppCompatActivity implements IUserRegView {

    private EditText mEtUsername,mEtPassword,mEtCode;
    private Button mBtnReg,mBtCode;
    private UserRegPresenter mUserRegPresenter = new UserRegPresenter(this);

    public static final String TAG="Reglister";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reglister);

        initViews();
    }

    private void initViews()
    {
        mEtUsername = (EditText)findViewById(R.id.register_edit_account);
        mEtPassword = (EditText)findViewById(R.id.register_edit_pwd);
        mBtnReg = (Button)findViewById(R.id.register_btn_register);
        mBtCode = (Button)findViewById(R.id.register_btn_code);
        mEtCode = (EditText) findViewById(R.id.register_edit_code);
        mBtnReg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(UserReglisterActivity.this, UserLoginActivity.class);
                startActivity(intent);
            }
        });


        mBtnReg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserRegPresenter.reglister();
                //启动

            }
        });

    }


    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void toLoginActivity(User user) {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
        //跳转到主页面
        Intent intent = new Intent(UserReglisterActivity.this, UserLoginActivity.class);
        startActivity(intent);

    }

    @Override
    public void showFailedError() {

    }
}
