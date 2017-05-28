package info.androidhive.fingerprint;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.plattysoft.leonids.ParticleSystem;

public class ScanNow extends AppCompatActivity {

    private ImageView img;
    private LinearLayout ll;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_now);
        img = (ImageView) findViewById(R.id.img_scan);
        ll = (LinearLayout) findViewById(R.id.back_one);
//        txt = (TextView) findViewById(R.id.tick);

//        final int[] imageArray = {R.drawable.atlas_gradient, R.drawable.blue_gradient};

//        final Handler handler = new Handler();
//        Runnable runnable = new Runnable() {
//            int i = 0;
//
//            public void run() {
//                ll.setBackgroundResource(imageArray[i]);
//                i++;
//                if (i > imageArray.length - 1) {
//                    i = 0;
//                }
//                handler.postDelayed(this, 2300);
//                Animation myFadeInAnimation = AnimationUtils.loadAnimation(ScanNow.this, R.anim.fadein);
//                ll.startAnimation(myFadeInAnimation);
//            }
//        };


//        txt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                ParticleSystem ps = new ParticleSystem(this, 50, R.drawable.placeholder, 1000, R.id.background_hook);
//                ps.setSpeedRange(0.1f, 0.25f);
//                ps.setScaleRange(0.7f, 1.3f);
//                ps.setSpeedRange(0.1f, 0.25f);
//                ps.setAcceleration(0.0001f, 90);
//                ps.setRotationSpeedRange(90, 180);
//                ps.setFadeOut(200, new AccelerateInterpolator());
//                ps.emit(arg0, 100);
//            }
//        });

//        handler.postDelayed(runnable, 2300);

        final int[] imgScan = {R.drawable.pic_zero, R.drawable.pic_one, R.drawable.pic_three, R.drawable.pic_four};
        final Handler handler1 = new Handler();
        Runnable runnable1 = new Runnable() {
            int i = 0;

            public void run() {
                img.setImageResource(imgScan[i]);
                i++;
                if (i > imgScan.length - 1) {
                    i = 0;
                }
                handler1.postDelayed(this, 1300);
            }
        };

        handler1.postDelayed(runnable1, 1300);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//
//                Intent i = new Intent(ScanNow.this, ActOK.class);
//                startActivity(i);
//            }
//        }, 6500);

    }
}