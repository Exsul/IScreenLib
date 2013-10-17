package com.example.IScreenLib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;

import iscreen.IScreenView;
import iscreen.virtualscreen.draw.Drawer;

import java.util.Timer;
import java.util.TimerTask;

public class LoaderActivity extends Activity {
    public class LoaderView extends IScreenView {
        private final Timer screenUpdateTimer = new Timer();

        private Handler handler = new Handler();

        private Paint textPaint = new Paint();

        private int nPoints = 0;

        public LoaderView(final Context context) {
            super(context);

            textPaint.setTextSize(20.0f);
            textPaint.setAntiAlias(true);

            screenUpdateTimer.schedule(new TimerTask() {
                private final Runnable drawCaller = new Runnable() {
                    @Override
                    public void run() {
                        invalidate();
                    }
                };

                @Override
                public void run() {
                    handler.post(drawCaller);
                }
            }, 500, 500);

            resources().loadBitmap(R.drawable.loading_empty, 1.0);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    resources(MenuActivity.MenuView.class).loadBitmap(R.drawable.menu_empty, 1.0);
                    resources(MenuActivity.MenuView.class).loadBitmap(R.drawable.button, 4.0 / 7.0);
                    resources(MenuActivity.MenuView.class).loadBitmap(R.drawable.button_pressed, 4.0 / 7.0);
                    resources(MenuActivity.MenuView.class).loadBitmap(R.drawable.info_button, 1.0 / 14.0);
                    resources(MenuActivity.MenuView.class).loadBitmap(R.drawable.info_button_pressed, 1.0 / 14.0);
                    resources(MenuActivity.MenuView.class).loadBitmap(R.drawable.options_button, 1.0 / 14.0);
                    resources(MenuActivity.MenuView.class).loadBitmap(R.drawable.options_button_pressed, 1.0 / 14.0);
                    resources(MenuActivity.MenuView.class).loadBitmap(R.drawable.sound_button, 1.0 / 14.0);
                    resources(MenuActivity.MenuView.class).loadBitmap(R.drawable.sound_button_pressed, 1.0 / 14.0);

                    try {
                        Thread.sleep(100000L);
                    } catch (InterruptedException e) {}

                    goToMenu();
                }
            }).start();
        }

        @Override
        protected void draw(final Drawer drawer) {
            nPoints++;

            if (nPoints == 6) {
                nPoints = 0;
            }

            drawer.drawBitmap(R.drawable.loading_empty, 0, 0);

            String text = "Loading";

            for (int i = 0; i < nPoints; i++) {
                text += ".";
            }

            drawer.drawText(text, 0.1, 0.1, textPaint);
        }

        private void goToMenu() {
            Intent newIntent = new Intent(LoaderActivity.this, MenuActivity.class);
            startActivity(newIntent);
            finish();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new LoaderView(this));
    }
}
