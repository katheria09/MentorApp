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
import hackathonayush.mentor.Adapter.GetMentorAdapter;
import hackathonayush.mentor.Model.AllMentors;
import hackathonayush.mentor.R;
import hackathonayush.mentor.Utils.CustomToast;
import hackathonayush.mentor.network.ApiClient;
import hackathonayush.mentor.network.ApiInterface;
import hackathonayush.mentor.network.ListResponse;
import retrofit2.Call;

/**
 * Created by user on 02-Sep-17.
 */

public class GetMentorFragment extends MentorFragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    List<AllMentors> mentors;
    ProgressDialog progressDialog;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_get_mentor;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mentors = new ArrayList<AllMentors>();
        progressDialog = new ProgressDialog(this.getActivity());
        progressDialog.setMessage("Loading");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final GetMentorAdapter adapter = new GetMentorAdapter(mentors, this);
        recyclerView.setAdapter(adapter);
        progressDialog.show();
        ApiInterface apiInterface = ApiClient.getApiClient();
        Call<ListResponse<AllMentors>> call = apiInterface.getAllMentors();
        call.enqueue(new ApiClient.Callback<ListResponse<AllMentors>>() {
            @Override
            public void success(ListResponse<AllMentors> response) {
                mentors.addAll(response.getData());
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
                Log.i("kunwar", "" + mentors.toString());


            }

            @Override
            public void failure(Error error) {
                CustomToast.show(error.getMessage());
                progressDialog.dismiss();
            }
        });


    }

    public static GetMentorFragment getNewInstance(){
        GetMentorFragment getMentorFragment=new GetMentorFragment();
        return getMentorFragment;
    }


    public void goToProfieFragment(int id) {

        replaceFragment(ProfileFragment.getNewInstance(id), R.id.container, GetMentorFragment.this);

    }
}
