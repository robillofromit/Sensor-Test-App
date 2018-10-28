package com.appbusters.robinkamboj.senseitall.view.tab_dashboard_activity.sections.sensors_fragment.featured_sensors_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appbusters.robinkamboj.senseitall.R;
import com.appbusters.robinkamboj.senseitall.utils.AppConstants;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeaturedSensorsAdapter extends RecyclerView.Adapter<FeaturedSensorsAdapter.FeaturedSensorsHolder> {

    private List<String> sensorsList = new ArrayList<>();
    private List<Integer> colorsList;
    private Context context;
    private Random random;

    public FeaturedSensorsAdapter(List<String> sensorsList, Context context) {
        random = new Random();
        colorsList = AppConstants.featuredColors;
        this.sensorsList.add(null);
        this.sensorsList.addAll(sensorsList);
        this.context = context;
    }

    @NonNull
    @Override
    public FeaturedSensorsHolder onCreateViewHolder(@NonNull ViewGroup parent, int type) {
        return new FeaturedSensorsHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_featured_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedSensorsHolder holder, int position) {
        if(sensorsList.get(position) == null) {
            holder.itemView.setVisibility(View.GONE);
        }
        else {
            holder.itemView.setVisibility(View.VISIBLE);
            holder.featuredSensorCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                            context,
                            colorsList.get(random.nextInt(colorsList.size()))
                    )
            );
            Glide.with(context)
                    .load(AppConstants.imageUrlMap.get(sensorsList.get(position)))
                    .into(holder.sensorImageView);
        }
    }

    @Override
    public int getItemCount() {
        return sensorsList == null ? 0 : sensorsList.size();
    }

    class FeaturedSensorsHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.sensor_image_view)
        ImageView sensorImageView;

        @BindView(R.id.featured_sensor_card)
        CardView featuredSensorCard;

        FeaturedSensorsHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
