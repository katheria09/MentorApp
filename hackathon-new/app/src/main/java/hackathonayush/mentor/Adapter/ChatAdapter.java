package hackathonayush.mentor.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hackathonayush.mentor.R;
import hackathonayush.mentor.View.ChatViewHolder;

/**
 * Created by as on 05-Sep-17.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder> {
    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.rv_single_msg_row, parent, false);
        return new ChatViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
