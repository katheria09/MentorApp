package hackathonayush.mentor.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import co.intentservice.chatui.ChatView;
import co.intentservice.chatui.models.ChatMessage;
import hackathonayush.mentor.Model.Message;
import hackathonayush.mentor.R;

/**
 * Created by as on 05-Sep-17.
 */

public class MessagesFragment extends MentorFragment {


    @BindView(R.id.chat_view)
    ChatView chatView;


    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_messages;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    public static Fragment getNewInstance() {
        MessagesFragment messagesFragment = new MessagesFragment();
        return messagesFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
                    // if (!message.getSender().equals("user")) {
                    String content = message.getMessage();
                    Long time = Long.parseLong(message.getTime());
                    String sender = message.getSender();
                    chatView.addMessage(new ChatMessage(content, time, ChatMessage.Type.RECEIVED));
                    // }
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


