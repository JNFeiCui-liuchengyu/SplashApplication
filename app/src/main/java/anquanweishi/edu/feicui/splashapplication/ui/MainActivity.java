package anquanweishi.edu.feicui.splashapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import anquanweishi.edu.feicui.splashapplication.R;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;
    private Animation mAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.iv_logo);
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.anim_logo);
        mImageView.startAnimation(mAnimation);

    }
}
