package hackathonayush.mentor.View;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hackathonayush.mentor.R;

/**
 * Created by kunwar on 8/9/17.
 */

public class InviteViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.mentorName)
    public TextView mentorName;

    @BindView(R.id.status)
    public TextView status;


    public InviteViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
