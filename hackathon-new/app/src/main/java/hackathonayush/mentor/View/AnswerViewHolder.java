package hackathonayush.mentor.View;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import hackathonayush.mentor.Model.MentorLightTextView;
import hackathonayush.mentor.Model.MentorRegularTextView;
import hackathonayush.mentor.R;

/**
 * Created by as on 07-Sep-17.
 */

public class AnswerViewHolder extends RecyclerView.ViewHolder {

    public MentorLightTextView name, upvote, downvote;
    public MentorRegularTextView answer;

    public AnswerViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        upvote = itemView.findViewById(R.id.thumbs_up);
        downvote = itemView.findViewById(R.id.thumbs_down);
        answer = itemView.findViewById(R.id.answer);

    }
}
