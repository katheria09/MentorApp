package hackathonayush.mentor.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import hackathonayush.mentor.Adapter.ChatAdapter;
import hackathonayush.mentor.R;

/**
 * Created by as on 05-Sep-17.
 */

public class ChatFragment extends MentorFragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_chat;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ChatAdapter());
    }

    public static ChatFragment getNewInstance() {
        ChatFragment chatFragment = new ChatFragment();
        return chatFragment;
    }
}

