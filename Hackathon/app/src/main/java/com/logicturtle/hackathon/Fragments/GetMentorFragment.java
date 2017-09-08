package com.logicturtle.hackathon.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import com.logicturtle.hackathon.Adapter.GetMentorAdapter;
import com.logicturtle.hackathon.Model.AllMentors;
import com.logicturtle.hackathon.R;
import com.logicturtle.hackathon.Utils.CustomToast;
import com.logicturtle.hackathon.network.ApiClient;
import com.logicturtle.hackathon.network.ApiInterface;
import com.logicturtle.hackathon.network.ListResponse;
import retrofit2.Call;


public class GetMentorFragment extends MentorFragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    List<AllMentors> mentors;

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

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final GetMentorAdapter adapter = new GetMentorAdapter(mentors);
        recyclerView.setAdapter(adapter);

        ApiInterface apiInterface = ApiClient.getApiClient();
        Call<ListResponse<AllMentors>> call = apiInterface.getAllMentors();
        call.enqueue(new ApiClient.Callback<ListResponse<AllMentors>>() {
            @Override
            public void success(ListResponse<AllMentors> response) {
                mentors.addAll(response.getData());
                adapter.notifyDataSetChanged();
                Log.i("kunwar", "" + mentors.toString());


            }

            @Override
            public void failure(Error error) {
                CustomToast.show(error.getMessage());
            }
        });


    }

    public static GetMentorFragment getNewInstance(){
        GetMentorFragment getMentorFragment=new GetMentorFragment();
        return getMentorFragment;
    }
}
