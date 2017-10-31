package hackathonayush.mentor.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hackathonayush.mentor.Model.Answers;
import hackathonayush.mentor.R;
import hackathonayush.mentor.Utils.CustomToast;
import hackathonayush.mentor.View.AnswerViewHolder;
import hackathonayush.mentor.network.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 08-Sep-17.
 */

public class AnswerQuestionAdapter extends RecyclerView.Adapter<AnswerViewHolder> {

    List<Answers> list;

    public AnswerQuestionAdapter(List<Answers> jsonString) {
        Log.i("ayush", "yaha tk aaya" + jsonString);
        this.list = jsonString;
    }

    @Override
    public AnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.rv_single_answer_row, parent, false);
        return new AnswerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnswerViewHolder holder, int position) {
        final Answers answers = list.get(position);
        holder.name.setText(answers.getMentor().getDetails().getName());
        holder.answer.setText(answers.getAnswer());
        holder.upvote.setText(answers.getUpvote() + "");
        holder.downvote.setText(answers.getDownvote() + "");
        holder.upvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiClient.getApiClient().upvote(answers.getId()).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {

                        } else
                            CustomToast.show("Try Again !");
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
