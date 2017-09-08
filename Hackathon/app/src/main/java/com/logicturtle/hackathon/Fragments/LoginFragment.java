package com.logicturtle.hackathon.Fragments;

import android.content.Intent;
import android.graphics.Color;
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
import com.logicturtle.hackathon.Model.MentorLogin;
import com.logicturtle.hackathon.Model.StudentLogin;
import com.logicturtle.hackathon.R;
import com.logicturtle.hackathon.Utils.CustomToast;
import com.logicturtle.hackathon.network.ApiClient;
import com.logicturtle.hackathon.network.ApiInterface;
import com.logicturtle.hackathon.network.ItemResponse;
import retrofit2.Call;


public class LoginFragment extends MentorFragment {


    String selectedItem;

    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.pass)
    EditText password;

    public LoginFragment() {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_signin;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    public static Fragment getNewInstance() {
        LoginFragment loginFragment = new LoginFragment();
        return loginFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialSpinner materialSpinner = (MaterialSpinner) view.findViewById(R.id.spinner);
        materialSpinner.setBackgroundColor(Color.TRANSPARENT);
        materialSpinner.setTextColor(Color.WHITE);
        materialSpinner.setArrowColor(Color.WHITE);
        materialSpinner.setItems("Login As", "Mentor", "Student");
        materialSpinner.setSelectedIndex(0);
        materialSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                selectedItem = (String) item;

            }
        });
    }


    @OnClick(R.id.login)
    public void signUp() {
        if (selectedItem == null) {

            CustomToast.show("Please Select Login Type");

        } else if (selectedItem.equals("Mentor")) {

            ApiInterface apiInterface = ApiClient.getApiClient();
            Call<ItemResponse<MentorLogin>> call = apiInterface.loginMentor(getStringFromEditText(email), getStringFromEditText(password));
            call.enqueue(new ApiClient.Callback<ItemResponse<MentorLogin>>() {
                @Override
                public void success(ItemResponse<MentorLogin> response) {
                    Log.i("kunwar", "" + response);
                    if (response != null) {
                        if (response.getData().getValidation().equals("successfull")) {
                            CustomToast.show("Sign Up Successfull !");
                            Intent intent = HomeActivity.getNewInstance(LoginFragment.this.getContext());
                            startActivity(intent);
                        } else {
                            CustomToast.show(response.getData().getValidation().toString());
                        }
                    } else
                        CustomToast.show("Wrong Email/Password;");
                }

                @Override
                public void failure(Error error) {
                    CustomToast.show(error.getMessage());

                }
            });


        } else if (selectedItem.equals("Student")) {

            ApiInterface apiInterface = ApiClient.getApiClient();
            Call<ItemResponse<StudentLogin>> call = apiInterface.loginStudent(getStringFromEditText(email), getStringFromEditText(password));
            call.enqueue(new ApiClient.Callback<ItemResponse<StudentLogin>>() {
                @Override
                public void success(ItemResponse<StudentLogin> response) {
                    if (response != null) {
                        Log.i("kunwar", "" + response);
                        if (response.getData().getValidation().equals("successfull")) {
                            CustomToast.show("Sign Up Successfull !");
                            Intent intent = HomeActivity.getNewInstance(LoginFragment.this.getContext());
                            startActivity(intent);
                        } else {
                            CustomToast.show(response.getData().getValidation().toString());
                        }
                    } else
                        CustomToast.show("Wrong Email/Password");
                }

                @Override
                public void failure(Error error) {
                    CustomToast.show(error.getMessage());

                }
            });


        }
    }

}
