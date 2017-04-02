package com.appbusters.robinkamboj.senseitall.view.robin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.appbusters.robinkamboj.senseitall.R;

public class SoundActivity extends AppCompatActivity {

    private ImageButton play, pause;
    private SeekBar volume;
    private ImageView bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        play = (ImageButton) findViewById(R.id.play);
        pause = (ImageButton) findViewById(R.id.pause);
        volume = (SeekBar) findViewById(R.id.volume);
        bg = (ImageView) findViewById(R.id.bg);
    }
}
