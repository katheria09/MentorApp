package com.logicturtle.hackathon.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import com.logicturtle.hackathon.Model.AllMentors;
import com.logicturtle.hackathon.R;
import com.logicturtle.hackathon.View.GetMentorViewHolder;

/**
 * Created by user on 02-Sep-17.
 */

public class GetMentorAdapter extends RecyclerView.Adapter<GetMentorViewHolder> {


    List<AllMentors> mentors;


    public GetMentorAdapter(List<AllMentors> mentors) {

        this.mentors = mentors;
    }


    @Override
    public GetMentorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.rv_single, parent, false);
        return new GetMentorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GetMentorViewHolder holder, int position) {
        holder.name.setText(mentors.get(position).getName());
        Log.i("kunwar", "mentor" + mentors.size() + mentors.get(position).getEmail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return mentors.size();
    }
}
