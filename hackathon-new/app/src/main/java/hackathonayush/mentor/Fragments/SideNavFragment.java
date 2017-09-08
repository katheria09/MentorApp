package hackathonayush.mentor.Fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.intentservice.chatui.ChatView;
import co.intentservice.chatui.models.ChatMessage;
import hackathonayush.mentor.Adapter.MentorChatAdapter;
import hackathonayush.mentor.Model.Invite;
import hackathonayush.mentor.Model.Message;
import hackathonayush.mentor.R;
import hackathonayush.mentor.Utils.CustomToast;
import hackathonayush.mentor.network.ApiClient;
import hackathonayush.mentor.network.ApiInterface;
import hackathonayush.mentor.network.ListResponse;
import retrofit2.Call;

/**
 * Created by kunwar on 7/9/17.
 */

public class SideNavFragment extends Fragment {


    @BindView(R.id.chat_view)
    ChatView chatView;


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    List<Invite.Mentor> invites;

    ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        invites = new ArrayList<Invite.Mentor>();
        progressDialog = new ProgressDialog(this.getActivity());
        progressDialog.setMessage("Loading");
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        final MentorChatAdapter adapter = new MentorChatAdapter(invites, this);
        recyclerView.setAdapter(adapter);
        progressDialog.show();
        ApiInterface apiInterface = ApiClient.getApiClient();
        Call<ListResponse<Invite>> call = apiInterface.getInvites(1);
        call.enqueue(new ApiClient.Callback<ListResponse<Invite>>() {
            @Override
            public void success(ListResponse<Invite> response) {
                for (int i = 0; i < response.getData().size(); i++) {

                    if (response.getData().get(i).getMentorStatus().equalsIgnoreCase("Accepted")) {
                        progressDialog.dismiss();
                        invites.add(response.getData().get(i).getMentor());
                        adapter.notifyDataSetChanged();

                    }


                }
            }

            @Override
            public void failure(Error error) {
                CustomToast.show(error.getMessage());
                progressDialog.dismiss();
            }
        });

    }


    public void chatWith(final String name) {
        recyclerView.setVisibility(View.GONE);
        chatView.setVisibility(View.VISIBLE);

        chatView.setOnSentMessageListener(new ChatView.OnSentMessageListener() {
            @Override
            public boolean sendMessage(final ChatMessage chatMessage) {


                Long currentTimeMillis = System.currentTimeMillis();
                String time = currentTimeMillis.toString();
                Task<Void> task = FirebaseDatabase.getInstance().getReferenceFromUrl("https://hackathon-new.firebaseio.com/").child("7835073887").push().setValue(new Message(chatMessage.getMessage(), time, "kunwar"));
                task.addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                    }
                });

                task.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
                return true;
            }
        });

        chatView.setTypingListener(new ChatView.TypingListener() {
            @Override
            public void userStartedTyping() {

            }

            @Override
            public void userStoppedTyping() {

            }
        });

        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://hackathon-new.firebaseio.com/").child("7835073887");

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (dataSnapshot.exists()) {
                    Log.i("kunwar", "fragment" + dataSnapshot);
                    Message message = dataSnapshot.getValue(Message.class);
                    if (message.getSender().equals(name)) {
                        String content = message.getMessage();
                        Long time = Long.parseLong(message.getTime());
                        String sender = message.getSender();
                        chatView.addMessage(new ChatMessage(content, time, ChatMessage.Type.RECEIVED));
                    } else {

                        String content = message.getMessage();
                        Long time = Long.parseLong(message.getTime());
                        String sender = message.getSender();
                        chatView.addMessage(new ChatMessage(content, time, ChatMessage.Type.SENT));

                    }
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
