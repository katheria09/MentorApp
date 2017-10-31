package hackathonayush.mentor.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import hackathonayush.mentor.Adapter.AnswerQuestionAdapter;
import hackathonayush.mentor.Model.Answers;
import hackathonayush.mentor.Model.MentorMediumTextView;
import hackathonayush.mentor.R;
import hackathonayush.mentor.Utils.CustomToast;
import hackathonayush.mentor.network.ApiClient;
import hackathonayush.mentor.network.ListResponse;

/**
 * Created by as on 07-Sep-17.
 */

public class AnswerFragment extends MentorFragment {

    private String jsonString = "";
    private String question;
    private String id;
    public RecyclerView recyclerView;
    @BindView(R.id.question)
    MentorMediumTextView ques;
    List<Answers> answer;
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_answer;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        question = bundle.getString("question");
        id = bundle.getString("id");
        Log.d("ayush", question + " " + id);
        answer = new ArrayList<Answers>();
        recyclerView = view.findViewById(R.id.recycle);

        ApiClient.getApiClient().getAnswers(id).enqueue(new ApiClient.Callback<ListResponse<Answers>>() {
            @Override
            public void success(ListResponse<Answers> response) {
                answer.addAll(response.getData());
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setHasFixedSize(true);
                final AnswerQuestionAdapter adapter = new AnswerQuestionAdapter(answer);
                recyclerView.setAdapter(adapter);
                Log.i("ayush", response.toString());

            }

            @Override
            public void failure(Error error) {
                CustomToast.show("oops ! Try Again ");
            }
        });
        ques.setText(question);

    }

    public static AnswerFragment getNewInstance(String question, String questionID) {
        Bundle bundle = new Bundle();
        bundle.putString("question", question);
        bundle.putString("id", questionID);
        AnswerFragment answerFragment = new AnswerFragment();
        answerFragment.setArguments(bundle);
        return answerFragment;
    }


}
