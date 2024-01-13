package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{
    RecyclerView recyclerView;
    private MyRecyclerViewAdapter adapter;
    ArrayList<String> animalNames;
    List<StudentModel> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = findViewById(R.id.recyclerView);
        animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");
        list = new ArrayList<>();
        list.add(new StudentModel("Purnendu","Android"));
        list.add(new StudentModel("Rishabh","Android"));
        list.add(new StudentModel("Jovan","IOS"));
        list.add(new StudentModel("Amit","IOS"));
        list.add(new StudentModel("ransh","react"));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, list);
        adapter.setClickListener(this);

        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {
        Intent in = new Intent(this, MainActivity.class);
        Bundle args = new Bundle();
        args.putSerializable("ARRAYLIST",(Serializable)list);
        in.putExtra("BUNDLE",args);
        startActivity(in);
    }
}
