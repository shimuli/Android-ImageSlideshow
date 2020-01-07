package com.example.imageslide;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class ImageAdapter extends
        SliderViewAdapter<ImageAdapter.ImageAdapterViewHolder> {
    private Context context;
    private int mCount;

    public ImageAdapter(Context context){
        this.context = context;
    }

    public void setCount(int count){
        this.mCount =count;
    }

    @Override

    public ImageAdapterViewHolder onCreateViewHolder(ViewGroup parent){
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list,null);
        return new ImageAdapterViewHolder(inflate);
    }
    @Override
    public void onBindViewHolder(ImageAdapterViewHolder viewHolder,final int position){
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is just about Jerry", Toast.LENGTH_SHORT).show();
            }
        });

        switch (position){
            case 0:
                viewHolder.textViewDescription.setText("Jerry stealing");
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.VISIBLE);
                Glide.with(viewHolder.itemView)
                        .load("https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto/gigs/93798826/original/08ccf00a3595b1fd5d88fae7f2362bd251f389da/create-funny-cartoon-characters.png")
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;
            case 1:
                viewHolder.textViewDescription.setText("Jerry wondering why he's too short!!");
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.VISIBLE);
                Glide.with(viewHolder.itemView)
                        .load("https://images-na.ssl-images-amazon.com/images/I/61tgp9FI8kL._SX466_.jpg")
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                Glide.with(viewHolder.itemView)
                        .asGif()
                        .load(R.drawable.skipping)
                        .into(viewHolder.imageGifContainer);
                break;

            case 3:
                viewHolder.textViewDescription.setText("Jerry just saw food");
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.VISIBLE);
                Glide.with(viewHolder.itemView)
                        .load("https://images-na.ssl-images-amazon.com/images/I/61l9vKGxd5L._SY450_.jpg")
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                Glide.with(viewHolder.itemView)
                        .asGif()
                        .load(R.drawable.skipping)
                        .into(viewHolder.imageGifContainer);
                break;

            default:
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.textViewDescription.setText("Jerry teasing Tom");
                viewHolder.imageGifContainer.setVisibility(View.VISIBLE);
                Glide.with(viewHolder.itemView)
                        .load("https://i.pinimg.com/originals/47/1a/da/471ada93aa90e8202d2168a8772395b1.jpg")
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                Glide.with(viewHolder.itemView)
                        .asGif()
                        .load(R.drawable.skipping)
                        .into(viewHolder.imageGifContainer);
                break;
        }
    }

    @Override
    public int getCount(){
        return mCount;
    }

    class ImageAdapterViewHolder extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;
        TextView textViewDescription;

        public ImageAdapterViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }

}
