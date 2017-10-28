package hackathonayush.mentor.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import hackathonayush.mentor.Activity.MentorApp;
import hackathonayush.mentor.Adapter.AnswerQuestionAdapter;
import hackathonayush.mentor.Adapter.QuestionAdapter;
import hackathonayush.mentor.Model.AllQuestions;
import hackathonayush.mentor.Model.Answers;
import hackathonayush.mentor.Model.JsonParsing;
import hackathonayush.mentor.Model.MentorMediumTextView;
import hackathonayush.mentor.R;
import hackathonayush.mentor.Utils.CustomToast;
import hackathonayush.mentor.network.ApiClient;
import hackathonayush.mentor.network.ListResponse;

/**
 * Created by user on 08-Sep-17.
 */

public class TrendingQuestionsFragment extends MentorFragment {
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_get_mentor;

    }

    @Override
    protected String setToolbarTitle() {
        return "Trending";
    }

    String jsonString;
    public RecyclerView recyclerView;
    public ProgressDialog progressDialog;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        setToolBarTitleOnFragment();
        if (!MentorApp.hasNetwork())
            CustomToast.show("No Internet Connection.Try Again!");
        recyclerView = view.findViewById(R.id.recycler_view);
        progressDialog.show();
        ApiClient.getApiClient().getQuestionsTrending().enqueue(new ApiClient.Callback<ListResponse<AllQuestions>>() {
            @Override
            public void success(ListResponse<AllQuestions> response) {
                Log.d("ayush", "success called");
                if (response.getData().size() == 0) {
                    CustomToast.show("No Data found");
                } else if (response != null) {
                    jsonString = JsonParsing.ToString(response);
                    Log.d("ayush", jsonString);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(new QuestionAdapter(jsonString));
                }

                progressDialog.dismiss();

            }

            @Override
            public void failure(Error error) {
                progressDialog.dismiss();
            }

        });
    }
}
