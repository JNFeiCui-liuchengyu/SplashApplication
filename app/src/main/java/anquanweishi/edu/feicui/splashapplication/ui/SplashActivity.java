package anquanweishi.edu.feicui.splashapplication.ui;

import android.content.Intent;
import android.opengl.Visibility;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.StaticLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import anquanweishi.edu.feicui.splashapplication.R;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private ViewPager       mViewPager;
    private ArrayList<View> mList;
    int[] pics = {R.mipmap.adware_style_applist,
            R.mipmap.adware_style_banner,
            R.mipmap.adware_style_creditswall};
    private Button mBtnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        mBtnSkip= (Button) findViewById(R.id.btn_skip);
        mBtnSkip.setOnClickListener(this);
        mList = new ArrayList<>();
        mViewPager = (ViewPager) findViewById(R.id.view_page);
        for (int i = 0; i < pics.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(pics[i]);
            mList.add(iv);
mViewPager.addOnPageChangeListener(this);
        }
        mViewPager.setAdapter(new MyPagerAdapter(mList));
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 2) {
            mBtnSkip.setVisibility(View.VISIBLE);
        }else{
            mBtnSkip.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class MyPagerAdapter extends PagerAdapter {
        private ArrayList<View> mList;

        public MyPagerAdapter(ArrayList<View> list) {
            mList = list;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mList.get(position), 0);
            return mList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mList.get(position));
        }

        @Override
        public int getCount() {
            if (mList != null) {
                return mList.size();
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
