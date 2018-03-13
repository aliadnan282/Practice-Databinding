package com.workout.sixpacksabs.binder;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.workout.sixpacksabs.R;

import static com.workout.sixpacksabs.helper.AppConstant.mContext;

/**
 * Created by AdnanAli on 3/9/2018.
 */

public class CustomBindingAdapter {


    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String resId) {
         Picasso.get()
                .load("https://images.pexels.com/photos/34950/pexels-photo.jpg?h=350&auto=compress&cs=tinysrgb")
                .placeholder(R.drawable.ic_card_abs)
                .into(imageView);
    /*    Glide.with(mContext)
                .load("https://images.pexels.com/photos/33109/fall-autumn-red-season.jpg?h=350&auto=compress&cs=tinysrgb")
                .into(imageView);*/
    }
}












