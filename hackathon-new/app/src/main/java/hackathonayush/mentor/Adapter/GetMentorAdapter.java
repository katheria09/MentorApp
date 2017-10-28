package hackathonayush.mentor.Adapter;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hackathonayush.mentor.Fragments.GetMentorFragment;
import hackathonayush.mentor.Model.AllMentors;
import hackathonayush.mentor.R;
import hackathonayush.mentor.View.GetMentorViewHolder;

/**
 * Created by user on 02-Sep-17.
 */

public class GetMentorAdapter extends RecyclerView.Adapter<GetMentorViewHolder> {


    List<AllMentors> mentors;
    GetMentorFragment fragment;


    public GetMentorAdapter(List<AllMentors> mentors, GetMentorFragment fragment) {
        this.fragment = fragment;
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
    public void onBindViewHolder(GetMentorViewHolder holder, final int position) {
        holder.name.setText(mentors.get(position).getName());
        Log.i("kunwar", "mentor" + mentors.size() + mentors.get(position).getEmail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.goToProfieFragment(mentors.get(position).getId());
            }
        });


    }

    @Override
    public int getItemCount() {
        return mentors.size();
    }
}
