package hackathonayush.mentor.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import hackathonayush.mentor.Activity.MentorApp;
import hackathonayush.mentor.Adapter.QuestionAdapter;
import hackathonayush.mentor.Model.AllQuestions;
import hackathonayush.mentor.Model.JsonParsing;
import hackathonayush.mentor.R;
import hackathonayush.mentor.Utils.CustomToast;
import hackathonayush.mentor.network.ApiClient;
import hackathonayush.mentor.network.ListResponse;

/**
 * Created by user on 07-Sep-17.
 */

public class YourQuestionFragment extends MentorFragment {
    String jsonString;
    public RecyclerView recyclerView;
    public ProgressDialog progressDialog;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_get_mentor;
    }

    @Override
    protected String setToolbarTitle() {
        return "Question";
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setToolBarTitleOnFragment();
        if (!MentorApp.hasNetwork())
            CustomToast.show("No Internet Connection.Try Again!");
        recyclerView = view.findViewById(R.id.recycler_view);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        ApiClient.getApiClient().getQuestions(1).enqueue(new ApiClient.Callback<ListResponse<AllQuestions>>() {
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
                CustomToast.show("Try Again");
                progressDialog.dismiss();
            }
        });

    }

    public static YourQuestionFragment getNewInstance() {
        YourQuestionFragment questionFragment = new YourQuestionFragment();
        return questionFragment;
    }
}
