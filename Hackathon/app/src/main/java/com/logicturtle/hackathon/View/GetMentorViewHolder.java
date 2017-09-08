package com.logicturtle.hackathon.View;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.logicturtle.hackathon.R;


public class GetMentorViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.name)
    public TextView name;

    @BindView(R.id.list_item)
    public CardView cardView;

    public GetMentorViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
