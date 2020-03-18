package com.example.dailybabytrucker.fragments.ExpandableFragments;

import android.view.View;
import android.widget.TextView;

import com.example.dailybabytrucker.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ProductViewHolder extends ChildViewHolder {

    private TextView pTextView;

    public ProductViewHolder(View itemView) {
        super(itemView);

        pTextView = (TextView) itemView.findViewById(R.id.option1);
    }

    public void bind(Product product) {
        pTextView.setText(product.name);
    }
}
