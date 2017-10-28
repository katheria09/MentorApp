package hackathonayush.mentor.Fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import hackathonayush.mentor.Adapter.InviteAdapter;
import hackathonayush.mentor.Model.Invite;
import hackathonayush.mentor.R;
import hackathonayush.mentor.Utils.CustomToast;
import hackathonayush.mentor.Utils.SharedPrefs;
import hackathonayush.mentor.network.ApiClient;
import hackathonayush.mentor.network.ApiInterface;
import hackathonayush.mentor.network.ListResponse;
import retrofit2.Call;

/**
 * Created by kunwar on 8/9/17.
 */

public class InviteFragment extends MentorFragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    List<Invite> invites;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_invite;
    }

    @Override
    protected String setToolbarTitle() {
        return "Invites";
    }


    public static InviteFragment getNewInstance() {

        InviteFragment inviteFragment = new InviteFragment();
        return inviteFragment;
    }

    ProgressDialog progressDialog;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        invites = new ArrayList<Invite>();
        final InviteAdapter adapter = new InviteAdapter(invites);
        recyclerView.setAdapter(adapter);
        progressDialog = new ProgressDialog(this.getActivity());
        progressDialog.setMessage("Loading");
        ApiInterface apiInterface = ApiClient.getApiClient();
        SharedPreferences sharedPrefs = SharedPrefs.getPrefrences();

        Call<ListResponse<Invite>> call = apiInterface.getInvites(SharedPrefs.getID(this.getActivity()));
        call.enqueue(new ApiClient.Callback<ListResponse<Invite>>() {
            @Override
            public void success(ListResponse<Invite> response) {
                invites.addAll(response.getData());
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void failure(Error error) {
                CustomToast.show(error.getMessage());
                progressDialog.dismiss();
            }
        });
    }
}
