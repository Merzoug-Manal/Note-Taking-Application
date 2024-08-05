package com.example.notes;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PostViewHolder extends RecyclerView.ViewHolder {
    public TextView nom;
    public TextView contenu;
    public ImageView image;


    public PostViewHolder(View view) {
        super(view);
        findViews(view);
    }
    private void findViews(View view) {
        nom =  view.findViewById(R.id.name);
        contenu =  view.findViewById(R.id.content);
        image =  view.findViewById(R.id.image);
    }
    public void setItem(final Post post) {
        nom.setText(post.nom);
        contenu.setText(post.contenu);
        image.setImageResource(post.image);
    }

}


