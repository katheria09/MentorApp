package com.logicturtle.hackathon.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import com.logicturtle.hackathon.Model.Proflile;
import com.logicturtle.hackathon.R;



public class ProfileFragment extends MentorFragment {

    @BindView(R.id.profileImage)
    CircleImageView circleImageView;


    @BindView(R.id.profileName)
    TextView profileName;

    @BindView(R.id.techSkill)
    TextView techSkill;

    @BindView(R.id.tech)
    TextView tech;




    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_profile;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    public static Fragment getNewInstance() {
        ProfileFragment profileFragment = new ProfileFragment();
        return profileFragment;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://hackathon-new.firebaseio.com/").child("mentorName");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {

                    Proflile proflile = dataSnapshot.getValue(Proflile.class);

                    Log.i("kunwar", "" + proflile);
                    profileName.setText(proflile.getName());

                    techSkill.setText(proflile.getTechs());

                    //    tech.setText(proflile.ge);


                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
