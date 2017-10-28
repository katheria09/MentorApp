package hackathonayush.mentor.Fragments;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import hackathonayush.mentor.Model.Invite;
import hackathonayush.mentor.Model.MentorDetails;
import hackathonayush.mentor.Model.Proflile;
import hackathonayush.mentor.R;
import hackathonayush.mentor.Utils.CustomToast;
import hackathonayush.mentor.Utils.SharedPrefs;
import hackathonayush.mentor.network.ApiClient;
import hackathonayush.mentor.network.ApiInterface;
import hackathonayush.mentor.network.ItemResponse;
import retrofit2.Call;

/**
 * Created by as on 08-Sep-17.
 */

public class ProfileFragment extends MentorFragment {

    @BindView(R.id.profileImage)
    CircleImageView circleImageView;


    @BindView(R.id.profileName)
    TextView profileName;

    @BindView(R.id.techSkill)
    TextView techSkill;

    @BindView(R.id.tech)
    TextView tech;

    @BindView(R.id.invitation)
    ImageView invitation;

    static int mentorId;

    ProgressDialog progressDialog;


    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_profile;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    public static Fragment getNewInstance(int id) {
        mentorId = id;
        ProfileFragment profileFragment = new ProfileFragment();
        return profileFragment;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressDialog = new ProgressDialog(this.getActivity());
        progressDialog.setMessage("Loading");
        DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://hackathon-new.firebaseio.com/").child("mentorName");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {

                    Proflile proflile = dataSnapshot.getValue(Proflile.class);

                    Log.i("kunwar", "" + proflile);

                    techSkill.setText(proflile.getTechs());

                    //    tech.setText(proflile.ge);


                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        final ApiInterface apiInterface = ApiClient.getApiClient();
        Call<ItemResponse<MentorDetails>> call = apiInterface.getMentor(mentorId);
        call.enqueue(new ApiClient.Callback<ItemResponse<MentorDetails>>() {
            @Override
            public void success(ItemResponse<MentorDetails> response) {
                profileName.setText(response.getData().getName());
                progressDialog.dismiss();


            }

            @Override
            public void failure(Error error) {
                progressDialog.dismiss();
                CustomToast.show(error.getMessage());

            }
        });


        invitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(ProfileFragment.this.getActivity());
                progressDialog.setMessage("Sending request");
                ApiInterface api = ApiClient.getApiClient();
                SharedPreferences sharedPreferences = SharedPrefs.getPrefrences();
                Call<ItemResponse<Invite>> cal = api.sendInvite(SharedPrefs.getID(ProfileFragment.this.getActivity()), mentorId, "Received", "Sent");
                cal.enqueue(new ApiClient.Callback<ItemResponse<Invite>>() {
                    @Override
                    public void success(ItemResponse<Invite> response) {
                        progressDialog.dismiss();
                        CustomToast.show(response.getData().getMentorStatus());
                        Log.i("kunwar", "" + response.getData().getMentorStatus());
                    }

                    @Override
                    public void failure(Error error) {
                        CustomToast.show(error.getMessage());
                        progressDialog.dismiss();
                    }
                });
            }
        });
    }
}
