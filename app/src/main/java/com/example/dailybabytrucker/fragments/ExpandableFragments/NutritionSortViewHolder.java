package com.example.dailybabytrucker.fragments.ExpandableFragments;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dailybabytrucker.R;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class NutritionSortViewHolder extends GroupViewHolder {

    private TextView sortTitle;
    private ImageView expandArrow;

    public NutritionSortViewHolder(View itemView) {
        super(itemView);
        sortTitle= (TextView) itemView.findViewById(R.id.sortTitle);
        expandArrow= (ImageView) itemView.findViewById(R.id.expandArrow);
    }

    public void bind (NutritionSort nutritionSort){
        sortTitle.setText(nutritionSort.getTitle());
    }

    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }

    private void animateExpand() {
        RotateAnimation rotate =
                new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        expandArrow.setAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        expandArrow.setAnimation(rotate);
    }

}