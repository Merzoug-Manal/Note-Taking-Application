package com.example.notes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostViewHolder> {

    ArrayList<Post> posts;
    Activity context;


    public PostsAdapter(ArrayList posts, Activity context) {
        this.posts=posts;
        this.context=context;

    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View View = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(View);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, final int position) {
        holder.setItem(posts.get(position));
        final Post post = posts.get(position);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder confirm = new AlertDialog.Builder(context);
                confirm.setTitle("Suppression");
                confirm.setIcon(android.R.drawable.ic_dialog_alert);
                confirm.setMessage("Vous confirmez la suppression ?");
                confirm.setPositiveButton(android.R.string.yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int idBtn) {
                                int index= posts.indexOf(post);
                                posts.remove(index);
                                notifyItemRemoved(index);}
                        });
                confirm.setNegativeButton(android.R.string.no, null);
                confirm.show();
                return false;
            }
        });

    }



    public void notifyData(ArrayList newArray) {
        this.posts = newArray;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {

        return posts.size();
    }


}

