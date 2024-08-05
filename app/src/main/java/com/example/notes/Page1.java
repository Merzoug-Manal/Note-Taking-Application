package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Page1 extends AppCompatActivity{

    ArrayList<Post> posts;
    Dialog dialog;
    RecyclerView recyclerView;
    EditText txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        recyclerView = findViewById(R.id.recycler_view);

        posts = new ArrayList<Post>();
        posts.add(new Post("Fatima Zohra YAGOUB", "Tweet N 1",R.drawable.photo));


        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new PostsAdapter(posts,this));

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        dialog.setTitle("Twitter");
        Button btnValider = dialog.findViewById(R.id.btn);
        txt = dialog.findViewById(R.id.edit_text);
        btnValider.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                posts.add(new Post("Fatima Zohra YAGOUB",txt.getText().toString(),R.drawable.photo));
                dialog.dismiss();}

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.menu_item){
            dialog.show();
        }

        return true;

    }
}


