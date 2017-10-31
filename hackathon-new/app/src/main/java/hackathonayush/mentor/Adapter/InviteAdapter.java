package hackathonayush.mentor.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hackathonayush.mentor.Model.Invite;
import hackathonayush.mentor.R;
import hackathonayush.mentor.View.GetMentorViewHolder;
import hackathonayush.mentor.View.InviteViewHolder;

/**
 * Created by kunwar on 8/9/17.
 */

public class InviteAdapter extends RecyclerView.Adapter<InviteViewHolder> {


    List<Invite> invites;

    public InviteAdapter(List<Invite> invites) {
        this.invites = invites;
    }

    @Override
    public InviteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.recycler_invite, parent, false);
        return new InviteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(InviteViewHolder holder, int position) {

        holder.mentorName.setText(invites.get(position).getMentor().getDetails().getName());
        holder.status.setText(invites.get(position).getMentorStatus());

    }

    @Override
    public int getItemCount() {
        return invites.size();
    }
}
