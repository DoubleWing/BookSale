package com.example.booksale.fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.booksale.R;
import com.example.booksale.view.UserLoginActivity;


public class MineFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_4, container, false);
        Button PresentLoc = (Button) view.findViewById(R.id.Login); //此处使得Button和xml中的按钮联系
        PresentLoc.setOnClickListener(new LocationCheckedListener()); //这一行是在将button和监听器捆帮
        return view;


    }
    class LocationCheckedListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), UserLoginActivity.class);//用getActivity()来获取当前的activity
            getActivity().startActivity(intent);
        }
    }



}
