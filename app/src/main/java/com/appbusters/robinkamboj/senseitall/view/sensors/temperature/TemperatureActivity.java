package com.appbusters.robinkamboj.senseitall.view.sensors.temperature;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.appbusters.robinkamboj.senseitall.R;

public class TemperatureActivity extends AppCompatActivity {

    private String sensor_name, results[];
    private TextView textView;
    private Sensor sensor;
    private SensorManager sensorManager;
    private TextView name, vendor, version, maximum_range, power, minimum_delay, maximum_delay, resolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        Intent i = getIntent();
        sensor_name = i.getStringExtra("sensorName");
        textView = (TextView) findViewById(R.id.data_name);
        textView.setText(sensor_name);

        name = (TextView) findViewById(R.id.name);
        vendor = (TextView) findViewById(R.id.vendor);
        version = (TextView) findViewById(R.id.version);
        maximum_range = (TextView) findViewById(R.id.maximum_range);
        power = (TextView) findViewById(R.id.power);
        minimum_delay = (TextView) findViewById(R.id.minimum_delay);
        maximum_delay = (TextView) findViewById(R.id.maximum_delay);
        resolution = (TextView) findViewById(R.id.resolution);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE);

        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                setResults();
                setTextviews();
            }
        });
    }

    private void setResults(){
        results = new String[]{
                "Name:    " + sensor.getName(), "Vendor:    " + sensor.getVendor(),
                "Version:    " + String.valueOf(sensor.getVersion()),
                "Maximum Range:    " + String.valueOf(sensor.getMaximumRange()),
                "Power:    " + String.valueOf(sensor.getPower()),
                "Minimum Delay:    " + String.valueOf(sensor.getMinDelay()),
                "Maximum Delay:    " + String.valueOf(sensor.getMaxDelay()),
                "Resolution:    " + String.valueOf(sensor.getResolution())
        };
    }

    private void setTextviews(){
        name.setText(results[0]);
        vendor.setText(results[1]);
        version.setText(results[2]);
        maximum_range.setText(results[3]);
        power.setText(results[4]);
        minimum_delay.setText(results[5]);
        maximum_delay.setText(results[6]);
        resolution.setText(results[7]);
    }
}
