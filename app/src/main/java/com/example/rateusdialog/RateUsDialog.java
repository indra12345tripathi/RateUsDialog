package com.example.rateusdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

public class RateUsDialog extends Dialog {
    private float userRate = 0;

    public RateUsDialog(@NonNull Context context) {
        super(context);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_us_dialog_layouts);

        final AppCompatButton rateNowBtn= findViewById(R.id.rateNowBtn);
        final AppCompatButton laterBtn= findViewById(R.id.laterBtn);
        final RatingBar ratingBar= findViewById(R.id.ratingBar);
        final ImageView ratingImage=findViewById(R.id.ratingImage);

        rateNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        laterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hide rating dialog
                dismiss();
            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (rating<= 1){
                    ratingImage.setImageResource(R.drawable.one_star);
                }
                else if (rating <= 2){
                    ratingImage.setImageResource(R.drawable.two_star);
                }
                else if (rating<= 3){
                    ratingImage.setImageResource(R.drawable.three_star);
                }
                else if (rating<= 4){
                    ratingImage.setImageResource(R.drawable.four_star);
                }
                else if (rating<= 5){
                    ratingImage.setImageResource(R.drawable.five_star);
                }
                //animate emoji image
                animateImage(ratingImage);

                //selected rating by user
                userRate = rating;
            }
        });

    }
    private void animateImage(ImageView ratingImage){
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1f,0,1f,
                Animation.RELATIVE_TO_SELF,0.5F,Animation.RELATIVE_TO_SELF,0.5F);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(200);
        ratingImage.startAnimation(scaleAnimation);
    }

}
