package hackathonayush.mentor.Fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jaredrummler.materialspinner.MaterialSpinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hackathonayush.mentor.Model.Proflile;
import hackathonayush.mentor.R;

/**
 * Created by kunwar on 7/9/17.
 */

public class DialogFragment extends android.support.v4.app.DialogFragment {


    @BindView(R.id.spinner)
    MaterialSpinner materialSpinner;


    @BindView(R.id.techs)
    EditText techs;


    String selectedItem = "";

    public static DialogFragment getNewInstance() {

        DialogFragment fragment = new DialogFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        materialSpinner.setBackgroundColor(Color.TRANSPARENT);
        materialSpinner.setTextColor(Color.WHITE);
        materialSpinner.setArrowColor(Color.WHITE);
        materialSpinner.setItems("Login As", "Mentor", "Student");
        materialSpinner.setSelectedIndex(0);
        materialSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                selectedItem = selectedItem.concat(",").concat((String) item);
                techs.setText(selectedItem);
            }

        });
    }


    @OnClick(R.id.submit)
    public void submit() {


        Task<Void> task = FirebaseDatabase.getInstance().getReferenceFromUrl("https://hackathon-new.firebaseio.com/").child("mentorName").setValue(new Proflile("ayush", "ayush@gmail.com", selectedItem));
        task.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

            }
        });


    }
}
