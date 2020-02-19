package com.example.advancedcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;
import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity {
    private  String[] normalString = new String[]{
            "Android","Android Blog","Android Market","Android Sdk",
            "Android AVD","BlackBerry","BlackBerry JDE","Symbian",
            "Symbian Carbide","Java 2ME","Nokia","Sun",
            "Nokia Symbian","Nokia forum","WindowsMobile","Broncho",
            "Windows XP","Google","Google Android","Google 浏览器",
            "IBM","MicroSoft","Java","C++","C","C#","J#","VB"
    };
    AutoCompleteTextView completeTextView;
    ListView listView;
    Button clean;
    ArrayAdapter adapter;
    GridView gridView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 适配器数组
        adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, normalString);

        completeTextView = findViewById(R.id.autoCompleteTextView);
        clean = findViewById(R.id.button);
        listView = findViewById(R.id.ListView);
        gridView = findViewById(R.id.GridView);


        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        gridView.setAdapter(adapter);
        completeTextView.setAdapter(adapter);
        listView.setAdapter(adapter);


        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                completeTextView.setText(" ");
            }
        });



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, String.valueOf(parent.getItemAtPosition(position)), Toast.LENGTH_SHORT).show();
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, String.valueOf(parent.getItemAtPosition(position)), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
