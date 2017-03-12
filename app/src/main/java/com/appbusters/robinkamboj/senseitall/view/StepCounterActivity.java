package com.appbusters.robinkamboj.senseitall.view;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.appbusters.robinkamboj.senseitall.R;

public class StepCounterActivity extends AppCompatActivity {

    String sensor_name, results[];
    TextView textView;
    TextView step_counter, accuracy, sampling_rate, minimum_delay, name, vendor, version, power, maximum_delay, resolution, maximum_range;
    private Sensor sensor;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter);

        Intent i = getIntent();
        sensor_name = i.getStringExtra("sensorName");
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(sensor_name);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        step_counter = (TextView) findViewById(R.id.step_counter);
        accuracy = (TextView) findViewById(R.id.accuracy);
        sampling_rate = (TextView) findViewById(R.id.sampling_rate);
        minimum_delay = (TextView) findViewById(R.id.minimum_delay);
        name = (TextView) findViewById(R.id.name);
        vendor = (TextView) findViewById(R.id.vendor);
        version = (TextView) findViewById(R.id.version);
        power = (TextView) findViewById(R.id.power);
        maximum_delay = (TextView) findViewById(R.id.maximum_delay);
        resolution = (TextView) findViewById(R.id.resolution);
        maximum_range = (TextView) findViewById(R.id.maximum_range);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                setResults();
                setTextviews();
            }
        });

        sensorManager.registerListener(stepCounterEventListener, sensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    SensorEventListener stepCounterEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float steps = sensorEvent.values[0];
            step_counter.setText((int) steps + "");
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    private void setResults(){
        results = new String[]{String.valueOf(sensor.getMinDelay()), sensor.getName(), sensor.getVendor(), String.valueOf(sensor.getVersion()),
                String.valueOf(sensor.getPower()), String.valueOf(sensor.getMaxDelay()), String.valueOf(sensor.getResolution()), String.valueOf(sensor.getMaximumRange())};
    }

    private void setTextviews(){
        minimum_delay.setText(results[0]);
        name.setText(results[1]);
        vendor.setText(results[2]);
        version.setText(results[3]);
        power.setText(results[4]);
        maximum_delay.setText(results[5]);
        resolution.setText(results[6]);
        maximum_range.setText(results[7]);
    }

}
