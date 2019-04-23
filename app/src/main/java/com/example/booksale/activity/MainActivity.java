package com.example.booksale.activity;

import android.support.annotation.IdRes;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.example.booksale.R;
import com.example.booksale.fragment.CategoryFragment;
import com.example.booksale.fragment.FindFragment;
import com.example.booksale.fragment.HomeFragment;
import com.example.booksale.fragment.MineFragment;
import com.example.booksale.adapter.PagerMainAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private ViewPager vp;
    private RadioGroup rg;
    private int[] rbs = {R.id.radio0, R.id.radio1, R.id.radio2,R.id.radio3};
    private List<Fragment> mFragments;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        vp = f(R.id.vp);
        rg = f(R.id.radioGroup1);
    }
    @Override
    protected void initData() {

        mFragments=new ArrayList<>();
        HomeFragment one=new HomeFragment();
        CategoryFragment two=new CategoryFragment();
        FindFragment three=new FindFragment();
        MineFragment four= new MineFragment();
        mFragments.add(one);
        mFragments.add(two);
        mFragments.add(three);
        mFragments.add(four);

        // 设置填充器
        vp.setAdapter(new PagerMainAdapter(getSupportFragmentManager(),mFragments));
        // 设置缓存页面数
        vp.setOffscreenPageLimit(2);

    }

    @Override
    protected void initListener() {
        //radioGroup的点击事件
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                for (int i = 0; i < rbs.length; i++) {
                    if (rbs[i] != checkedId) continue;
                    //加载滑动
                    vp.setCurrentItem(i);
                }
            }
        });
        //ViewPager的点击事件 vp-rg互相监听：vp
        vp.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                rg.check(rbs[position]);
            }
        });
        //设置一个默认页
        rg.check(rbs[0]);
    }


//登录
}
