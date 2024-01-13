package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager2 myViewPager2;
    Adapter myAdapter;

    ArrayList<StudentModel> object;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
         object = (ArrayList<StudentModel>) args.getSerializable("ARRAYLIST");
        myViewPager2 = findViewById(R.id.viewPager2);

        myAdapter = new Adapter(getSupportFragmentManager(), getLifecycle());


        myViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        myViewPager2.setAdapter(myAdapter);
        createAllFragments();
    }

    private void createAllFragments(){
        for (StudentModel model:object
             ) {
            myAdapter.addFragment(StudentFragment.newInstance(model.getName(),model.getSubject()));

        }

    }


    private List<StudentModel> getStudentList(){
        List<StudentModel> list = new ArrayList<>();
        list.add(new StudentModel("Purnendu","Android"));
        list.add(new StudentModel("Rishabh","Android"));
        list.add(new StudentModel("Jovan","IOS"));
        list.add(new StudentModel("Amit","IOS"));


return list;
    }
}