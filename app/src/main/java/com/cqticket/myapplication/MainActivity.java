package com.cqticket.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rl = findViewById(R.id.rl);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rl.setLayoutManager(layoutManager);

        List<Data> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Data data = new Data();
            data.setName("name"+i);
            list.add(data);
        }

        MyAdapter adapter = new MyAdapter(list);
        rl.setAdapter(adapter);
    }
}
