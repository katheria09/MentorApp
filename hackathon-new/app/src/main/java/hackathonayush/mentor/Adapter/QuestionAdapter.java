package hackathonayush.mentor.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import hackathonayush.mentor.Activity.AnswerActivity;
import hackathonayush.mentor.Model.AllQuestions;
import hackathonayush.mentor.Model.JsonParsing;
import hackathonayush.mentor.R;
import hackathonayush.mentor.View.QUestionViewHolder;

/**
 * Created by user on 02-Sep-17.
 */

public class QuestionAdapter extends RecyclerView.Adapter<QUestionViewHolder> {
    private List<AllQuestions> list = new ArrayList<>();

    public QuestionAdapter(String allQuestionsList) {

        Type type = new TypeToken<List<AllQuestions>>() {
        }.getType();
        list = JsonParsing.ToList(allQuestionsList, type);
    }


    @Override
    public QUestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.rv_single_row_question, parent, false);
        return new QUestionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(QUestionViewHolder holder, int position) {
        final AllQuestions allQuestions = list.get(position);
        holder.name.setText(allQuestions.getStudent().getData().getName());
        holder.tech.setText(allQuestions.getTechnology());
        holder.question.setText(allQuestions.getQuestion());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AnswerActivity.getNewInstance(view.getContext(), allQuestions.getQuestion(), String.valueOf(allQuestions.getQuesId()));
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();

    }
}
