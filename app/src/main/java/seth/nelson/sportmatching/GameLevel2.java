package seth.nelson.sportmatching;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import seth.nelson.sportmatching.R;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;

public class GameLevel2 extends AppCompatActivity {

    MediaPlayer l2Bgm;
    MediaPlayer goodluck;
    MediaPlayer highscore;
    MediaPlayer wrong2;
    MediaPlayer great;

    Button restart;
    Button home;
    private View decorView;
    TextView tv_tried, tv_correct;
    TextView score;
    ImageView iv_1, iv_2, iv_3, iv_4, iv_5, iv_6, iv_7, iv_8, iv_9, iv_10, iv_11, iv_12, iv_13, iv_14, iv_15, iv_16;

    Integer [] cardsArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
    int image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13, image14, image15, image16;

    int firstCard, secondCard;
    int clickFirst, clickSecond;
    int cardNumber = 1;

    int playerPoints = 0, cpuPoints = 0;

    DecimalFormat df = new DecimalFormat("######0.0");

    double score2;
    double score1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_level2);

        score1 = getIntent().getExtras().getDouble("Value1");

        l2Bgm = MediaPlayer.create(GameLevel2.this,R.raw.bgm_l2);
        l2Bgm.start();
        l2Bgm.setLooping(true);
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0) {
                    decorView.setSystemUiVisibility(hideSystemBars());
                }
            }
        });

        showGuideFootball();

        restart = (Button)findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameLevel2.class);
                intent.putExtra("Value1",score1);
                startActivity(intent);
                finish();
            }
        });

        home = (Button)findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Home2.class);
                intent.putExtra("Value1",score1);
                startActivity(intent);
                finish();
            }
        });


        tv_tried = (TextView)findViewById(R.id.tv_tried);
        tv_correct = (TextView)findViewById(R.id.tv_correct);
        score = (TextView)findViewById(R.id.score);

        iv_1 = (ImageView) findViewById(R.id.im_1);
        iv_2 = (ImageView) findViewById(R.id.im_2);
        iv_3 = (ImageView) findViewById(R.id.im_3);
        iv_4 = (ImageView) findViewById(R.id.im_4);
        iv_5 = (ImageView) findViewById(R.id.im_5);
        iv_6 = (ImageView) findViewById(R.id.im_6);
        iv_7 = (ImageView) findViewById(R.id.im_7);
        iv_8 = (ImageView) findViewById(R.id.im_8);
        iv_9 = (ImageView) findViewById(R.id.im_9);
        iv_10 = (ImageView) findViewById(R.id.im_10);
        iv_11 = (ImageView) findViewById(R.id.im_11);
        iv_12 = (ImageView) findViewById(R.id.im_12);
        iv_13 = (ImageView) findViewById(R.id.im_13);
        iv_14 = (ImageView) findViewById(R.id.im_14);
        iv_15 = (ImageView) findViewById(R.id.im_15);
        iv_16 = (ImageView) findViewById(R.id.im_16);

        iv_1.setTag("0");
        iv_2.setTag("1");
        iv_3.setTag("2");
        iv_4.setTag("3");
        iv_5.setTag("4");
        iv_6.setTag("5");
        iv_7.setTag("6");
        iv_8.setTag("7");
        iv_9.setTag("8");
        iv_10.setTag("9");
        iv_11.setTag("10");
        iv_12.setTag("11");
        iv_13.setTag("12");
        iv_14.setTag("13");
        iv_15.setTag("14");
        iv_16.setTag("15");

        frontOfCardsResources();

        Collections.shuffle(Arrays.asList(cardsArray));

        iv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuffFootball(iv_1, theCard);
            }
        });

        iv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuffFootball(iv_2, theCard);
            }
        });

        iv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuffFootball(iv_3, theCard);
            }
        });

        iv_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuffFootball(iv_4, theCard);
            }
        });

        iv_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuffFootball(iv_5, theCard);
            }
        });

        iv_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuffFootball(iv_6, theCard);
            }
        });

        iv_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuffFootball(iv_7, theCard);
            }
        });

        iv_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuffFootball(iv_8, theCard);
            }
        });

        iv_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuffFootball(iv_9, theCard);
            }
        });

        iv_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuffFootball(iv_10, theCard);
            }
        });

        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuffFootball(iv_11, theCard);
            }
        });

        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuffFootball(iv_12, theCard);
            }
        });

        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuffFootball(iv_13, theCard);
            }
        });

        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuffFootball(iv_14, theCard);
            }
        });

        iv_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuffFootball(iv_15, theCard);
            }
        });

        iv_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuffFootball(iv_16, theCard);
            }
        });


    }

    private void doStuffFootball(ImageView iv, int card) {
        if (cardsArray[card] == 1) {
            iv.setImageResource(image1);
        } else if (cardsArray[card] == 2) {
            iv.setImageResource(image2);
        } else if (cardsArray[card] == 3) {
            iv.setImageResource(image3);
        } else if (cardsArray[card] == 4) {
            iv.setImageResource(image4);
        } else if (cardsArray[card] == 5) {
            iv.setImageResource(image5);
        } else if (cardsArray[card] == 6) {
            iv.setImageResource(image6);
        } else if (cardsArray[card] == 7) {
            iv.setImageResource(image7);
        } else if (cardsArray[card] == 8) {
            iv.setImageResource(image8);
        } else if (cardsArray[card] == 9) {
            iv.setImageResource(image9);
        } else if (cardsArray[card] == 10) {
            iv.setImageResource(image10);
        } else if (cardsArray[card] == 11) {
            iv.setImageResource(image11);
        } else if (cardsArray[card] == 12) {
            iv.setImageResource(image12);
        } else if (cardsArray[card] == 13) {
            iv.setImageResource(image13);
        } else if (cardsArray[card] == 14) {
            iv.setImageResource(image14);
        } else if (cardsArray[card] == 15) {
            iv.setImageResource(image15);
        } else if (cardsArray[card] == 16) {
            iv.setImageResource(image16);
        }

        if (cardNumber == 1) {
            firstCard = cardsArray[card];
            if (firstCard > 8) {
                firstCard = firstCard - 8;
            }
            cardNumber = 2;
            clickFirst = card;

            iv.setEnabled(false);
        } else if (cardNumber == 2) {
            secondCard = cardsArray[card];
            if (secondCard > 8) {
                secondCard = secondCard - 8;
            }
            cardNumber = 1;
            clickSecond = card;

            iv_1.setEnabled(false);
            iv_2.setEnabled(false);
            iv_3.setEnabled(false);
            iv_4.setEnabled(false);
            iv_5.setEnabled(false);
            iv_6.setEnabled(false);
            iv_7.setEnabled(false);
            iv_8.setEnabled(false);
            iv_9.setEnabled(false);
            iv_10.setEnabled(false);
            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);
            iv_15.setEnabled(false);
            iv_16.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculateFootball();
                }
            },500);

        }

    }

    private void calculateFootball() {
        Animation animation= AnimationUtils.loadAnimation(GameLevel2.this,R.anim.sample_anim);
        Animation animation2= AnimationUtils.loadAnimation(GameLevel2.this,R.anim.sample_anim2);
        if (firstCard == secondCard) {
            if (clickFirst == 0) {
                iv_1.startAnimation(animation);
                iv_1.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 1) {
                iv_2.startAnimation(animation);
                iv_2.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 2) {
                iv_3.startAnimation(animation);
                iv_3.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 3) {
                iv_4.startAnimation(animation);
                iv_4.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 4) {
                iv_5.startAnimation(animation);
                iv_5.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 5) {
                iv_6.startAnimation(animation);
                iv_6.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 6) {
                iv_7.startAnimation(animation);
                iv_7.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 7) {
                iv_8.startAnimation(animation);
                iv_8.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 8) {
                iv_9.startAnimation(animation);
                iv_9.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 9) {
                iv_10.startAnimation(animation);
                iv_10.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 10) {
                iv_11.startAnimation(animation);
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 11) {
                iv_12.startAnimation(animation);
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 12) {
                iv_13.startAnimation(animation);
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 13) {
                iv_14.startAnimation(animation);
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 14) {
                iv_15.startAnimation(animation);
                iv_15.setVisibility(View.INVISIBLE);
            } else if (clickFirst == 15) {
                iv_16.startAnimation(animation);
                iv_16.setVisibility(View.INVISIBLE);
            }

            if (clickSecond == 0) {
                iv_1.startAnimation(animation2);
                iv_1.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 1) {
                iv_2.startAnimation(animation2);
                iv_2.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 2) {
                iv_3.startAnimation(animation2);
                iv_3.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 3) {
                iv_4.startAnimation(animation2);
                iv_4.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 4) {
                iv_5.startAnimation(animation2);
                iv_5.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 5) {
                iv_6.startAnimation(animation2);
                iv_6.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 6) {
                iv_7.startAnimation(animation2);
                iv_7.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 7) {
                iv_8.startAnimation(animation2);
                iv_8.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 8) {
                iv_9.startAnimation(animation2);
                iv_9.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 9) {
                iv_10.startAnimation(animation2);
                iv_10.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 10) {
                iv_11.startAnimation(animation2);
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 11) {
                iv_12.startAnimation(animation2);
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 12) {
                iv_13.startAnimation(animation2);
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 13) {
                iv_14.startAnimation(animation2);
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 14) {
                iv_15.startAnimation(animation2);
                iv_15.setVisibility(View.INVISIBLE);
            } else if (clickSecond == 15) {
                iv_16.startAnimation(animation2);
                iv_16.setVisibility(View.INVISIBLE);
            }

            great = MediaPlayer.create(GameLevel2.this,R.raw.but_great);
            great.start();

            playerPoints++;
            tv_correct.setText("Correct: "+playerPoints);

        } else {
            iv_1.setImageResource(R.drawable.cover);
            iv_2.setImageResource(R.drawable.cover);
            iv_3.setImageResource(R.drawable.cover);
            iv_4.setImageResource(R.drawable.cover);
            iv_5.setImageResource(R.drawable.cover);
            iv_6.setImageResource(R.drawable.cover);
            iv_7.setImageResource(R.drawable.cover);
            iv_8.setImageResource(R.drawable.cover);
            iv_9.setImageResource(R.drawable.cover);
            iv_10.setImageResource(R.drawable.cover);
            iv_11.setImageResource(R.drawable.cover);
            iv_12.setImageResource(R.drawable.cover);
            iv_13.setImageResource(R.drawable.cover);
            iv_14.setImageResource(R.drawable.cover);
            iv_15.setImageResource(R.drawable.cover);
            iv_16.setImageResource(R.drawable.cover);

            wrong2 = MediaPlayer.create(GameLevel2.this,R.raw.but_wrong2);
            if(wrong2!=null){
                wrong2.start();
            }
        }

        cpuPoints++;
        tv_tried.setText("Tried: "+cpuPoints);
        score.setText("Score: "+df.format(20 * (double)playerPoints/cpuPoints));

        iv_1.setEnabled(true);
        iv_2.setEnabled(true);
        iv_3.setEnabled(true);
        iv_4.setEnabled(true);
        iv_5.setEnabled(true);
        iv_6.setEnabled(true);
        iv_7.setEnabled(true);
        iv_8.setEnabled(true);
        iv_9.setEnabled(true);
        iv_10.setEnabled(true);
        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);
        iv_15.setEnabled(true);
        iv_16.setEnabled(true);

        checkEndFootball();
    }

    private void checkEndFootball() {
        if (iv_1.getVisibility() == View.INVISIBLE &&
                iv_2.getVisibility() == View.INVISIBLE &&
                iv_3.getVisibility() == View.INVISIBLE &&
                iv_4.getVisibility() == View.INVISIBLE &&
                iv_5.getVisibility() == View.INVISIBLE &&
                iv_6.getVisibility() == View.INVISIBLE &&
                iv_7.getVisibility() == View.INVISIBLE &&
                iv_8.getVisibility() == View.INVISIBLE &&
                iv_9.getVisibility() == View.INVISIBLE &&
                iv_10.getVisibility() == View.INVISIBLE &&
                iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&
                iv_13.getVisibility() == View.INVISIBLE &&
                iv_14.getVisibility() == View.INVISIBLE &&
                iv_15.getVisibility() == View.INVISIBLE &&
                iv_16.getVisibility() == View.INVISIBLE) {
            highscore = MediaPlayer.create(GameLevel2.this,R.raw.but_highscore);
            if(highscore!=null){
                highscore.start();
            }

            showRewardFootball();

        }
    }

    public void showGuideFootball() {
        final Dialog dialog=new Dialog(GameLevel2.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.guidel2_dialog);
        Button home_guide=dialog.findViewById(R.id.home_guide);
        Button sure_guide=dialog.findViewById(R.id.sure_guide);
        TextView guideShow=dialog.findViewById(R.id.guideShow);
        guideShow.setText("Congratulations to level-2, here are more question cards than last level, Good luck");

        home_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Home2.class);
                intent.putExtra("Value1",score1);
                startActivity(intent);
                finish();
            }
        });

        sure_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goodluck = MediaPlayer.create(GameLevel2.this,R.raw.but_goodluck);
                if(goodluck!=null){
                    goodluck.start();
                }
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void showRewardFootball() {
        final Dialog dialog=new Dialog(GameLevel2.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.reward_dialog);
        Button home_guide=dialog.findViewById(R.id.home_guide);
        Button sure_guide=dialog.findViewById(R.id.sure_guide);
        TextView tv_paired=dialog.findViewById(R.id.tv_paired);
        TextView tv_tried=dialog.findViewById(R.id.tv_tried);
        TextView tv_accuracy=dialog.findViewById(R.id.tv_accuracy);
        TextView tv_score=dialog.findViewById(R.id.tv_score);
        tv_paired.setText("Number of paired: "+playerPoints);
        tv_tried.setText("Number of tired: "+cpuPoints);
        tv_accuracy.setText("Accuracy: "+df.format ((double)playerPoints/cpuPoints));
        tv_score.setText("Score: "+df.format(20 * (double)playerPoints/cpuPoints));
        home_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Home3.class);
                score2 = 20 * (double)playerPoints/cpuPoints;
                intent.putExtra("Value1",score2);
                intent.putExtra("Value2",score1);
                startActivity(intent);
                finish();
            }
        });

        sure_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameLevel3.class);
                score2 = 20 * (double)playerPoints/cpuPoints + score1;
                intent.putExtra("Value2",score2);
                intent.putExtra("Value1",score1);
                startActivity(intent);
                finish();
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

    private void frontOfCardsResources() {
        image1 = R.drawable.a1;
        image2 = R.drawable.a2;
        image3 = R.drawable.a3;
        image4 = R.drawable.a4;
        image5 = R.drawable.a9;
        image6 = R.drawable.a6;
        image7 = R.drawable.a7;
        image8 = R.drawable.a8;
        image9 = R.drawable.a1;
        image10 = R.drawable.a2;
        image11 = R.drawable.a3;
        image12 = R.drawable.a4;
        image13 = R.drawable.a9;
        image14 = R.drawable.a6;
        image15 = R.drawable.a7;
        image16 = R.drawable.a8;

    }

    @Override
    protected void onPause() {
        super.onPause();
        l2Bgm.release();
        finish();
    }
}