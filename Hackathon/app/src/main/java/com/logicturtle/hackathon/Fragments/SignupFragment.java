package com.logicturtle.hackathon.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.jaredrummler.materialspinner.MaterialSpinner;

import butterknife.BindView;
import butterknife.OnClick;
import com.logicturtle.hackathon.Activity.HomeActivity;
import com.logicturtle.hackathon.Model.MentorSignUp;
import com.logicturtle.hackathon.Model.StudentSignUp;
import com.logicturtle.hackathon.R;
import com.logicturtle.hackathon.Utils.CustomToast;
import com.logicturtle.hackathon.network.ApiClient;
import com.logicturtle.hackathon.network.ApiInterface;
import com.logicturtle.hackathon.network.ItemResponse;
import retrofit2.Call;


public class SignupFragment extends MentorFragment {


    String selectedItem;

    @BindView(R.id.username)
    EditText userName;

    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.password)
    EditText password;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_signup;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    public static Fragment getNewInstance() {
        SignupFragment signupFragment = new SignupFragment();
        return signupFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialSpinner materialSpinner = (MaterialSpinner) view.findViewById(R.id.spinner);
        materialSpinner.setItems("SignUp As", "Mentor", "Student");
        materialSpinner.setSelectedIndex(0);
        materialSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                Log.i("kunwar", "" + item + position);
                selectedItem = (String) item;

            }
        });
    }


    @OnClick(R.id.sign_up)
    public void signUp() {
        if (selectedItem == null) {

            CustomToast.show("Please Select Login Type");

        } else if (selectedItem.equals("Mentor")) {

            ApiInterface apiInterface = ApiClient.getApiClient();
            Call<ItemResponse<MentorSignUp>> call = apiInterface.signUpMentor(getStringFromEditText(userName), getStringFromEditText(email), getStringFromEditText(password));
            call.enqueue(new ApiClient.Callback<ItemResponse<MentorSignUp>>() {
                @Override
                public void success(ItemResponse<MentorSignUp> response) {
                    Log.i("kunwar", "" + response);
                    if (response.getData().getStatus().equals("successfull")) {
                            CustomToast.show("Sign Up Successfull !");
                            Intent intent = HomeActivity.getNewInstance(SignupFragment.this.getContext());
                            startActivity(intent);
                    } else {
                        CustomToast.show(response.getData().getStatus().toString());
                        }
                }

                @Override
                public void failure(Error error) {
                    CustomToast.show(error.getMessage());

                }
            });


        } else if (selectedItem.equals("Student")) {

            ApiInterface apiInterface = ApiClient.getApiClient();
            Call<ItemResponse<StudentSignUp>> call = apiInterface.signUpStudent(getStringFromEditText(userName), getStringFromEditText(email), getStringFromEditText(password));
            call.enqueue(new ApiClient.Callback<ItemResponse<StudentSignUp>>() {
                @Override
                public void success(ItemResponse<StudentSignUp> response) {
                    Log.i("kunwar", "" + response);
                    if (response.getData().getStatus().equals("successfull")) {
                        CustomToast.show("Sign Up Successfull !");
                        replaceFragment(DialogFragment.getNewInstance(), R.id.container, SignupFragment.this);
//                        Intent intent = HomeActivity.getNewInstance(SignupFragment.this.getContext());
//                        startActivity(intent);
                    } else {
                        CustomToast.show(response.getData().getStatus().toString());
                        }
                }

                @Override
                public void failure(Error error) {
                    CustomToast.show(error.getMessage());

                }
            });


        }
    }
}
