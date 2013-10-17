package com.example.IScreenLib;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import iscreen.IScreenView;
import iscreen.virtualscreen.draw.Drawer;

public class MenuActivity extends Activity {
    public class MenuView extends IScreenView {
        public MenuView(final Context context) {
            super(context);
        }

        @Override
        protected void draw(final Drawer drawer) {
        }

        @Override
        protected void resize(final double w, final double h) {
        }

        @Override
        protected boolean touch(MotionEvent e) {
            return false;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new MenuView(this));
    }}
