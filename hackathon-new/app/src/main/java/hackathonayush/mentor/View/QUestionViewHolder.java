package hackathonayush.mentor.View;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import hackathonayush.mentor.Model.MentorLightTextView;
import hackathonayush.mentor.Model.MentorMediumTextView;
import hackathonayush.mentor.Model.MentorRegularTextView;
import hackathonayush.mentor.R;

/**
 * Created by user on 08-Sep-17.
 */

public class QUestionViewHolder extends RecyclerView.ViewHolder {

    public MentorRegularTextView name;

    public MentorMediumTextView question;

    public MentorLightTextView tech;

    public QUestionViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        question = itemView.findViewById(R.id.question);
        tech = itemView.findViewById(R.id.tech);
    }
}
