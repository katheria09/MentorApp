package hackathonayush.mentor.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hackathonayush.mentor.Fragments.GetMentorFragment;
import hackathonayush.mentor.Fragments.SideNavFragment;
import hackathonayush.mentor.Model.Invite;
import hackathonayush.mentor.R;
import hackathonayush.mentor.View.GetMentorViewHolder;

/**
 * Created by kunwar on 8/9/17.
 */

public class MentorChatAdapter extends RecyclerView.Adapter<GetMentorViewHolder> {

    List<Invite.Mentor> mentors;
    SideNavFragment fragment;

    public MentorChatAdapter(List<Invite.Mentor> mentors, SideNavFragment fragment) {
        this.mentors = mentors;
        this.fragment = fragment;
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

        holder.name.setText(mentors.get(position).getDetails().getName());
        Log.i("kunwar", "mentor" + mentors.size() + mentors.get(position).getDetails().getEmail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.chatWith(mentors.get(position).getDetails().getName());

            }
        });

    }

    @Override
    public int getItemCount() {
        return mentors.size();
    }
}
