package seth.nelson.sportmatching;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import seth.nelson.sportmatching.R;

public class Home1 extends AppCompatActivity {

    MediaPlayer welBgm;
    Button button1, button2, button3, button4,btnShop;

    private View decorView;
    TextView tv_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);

        welBgm = MediaPlayer.create(Home1.this,R.raw.bgm_wel);
        welBgm.start();
        welBgm.setLooping(true);
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0) {
                    decorView.setSystemUiVisibility(hideSystemBars());
                }
            }
        });
        Animation animation= AnimationUtils.loadAnimation(Home1.this,R.anim.bounce);


        tv_1 = (TextView)findViewById(R.id.tv_1);

        tv_1.startAnimation(animation);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.but_letsgo);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        btnShop= (Button)findViewById(R.id.button_shop);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp!=null){
                    mp.start();
                }
                startActivity(new Intent(Home1.this, GameLevel1.class));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMsg2Football();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMsg3Football();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home1.this, GetFootball.class));
            }
        });

    }

    public void showMsg2Football() {
        final Dialog dialog=new Dialog(Home1.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.msg_dialog);
        Button sure_guide=dialog.findViewById(R.id.sure_guide);
        TextView resultShow=dialog.findViewById(R.id.msgShow);
        resultShow.setText("Please pass Level-1 first");

        sure_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void showMsg3Football() {
        final Dialog dialog=new Dialog(Home1.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.msg_dialog);
        Button sure_guide=dialog.findViewById(R.id.sure_guide);
        TextView resultShow=dialog.findViewById(R.id.msgShow);
        resultShow.setText("Please pass Level-2 first");

        sure_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    private int hideSystemBars() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        welBgm.release();
        finish();
    }

}