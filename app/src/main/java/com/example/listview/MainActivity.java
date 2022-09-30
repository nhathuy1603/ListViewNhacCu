package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvNhacCu;
    Button btnThem, btnCapNhat;
    EditText edt;
    ArrayList<String> arrayCourse;

    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lvNhacCu = (ListView) findViewById(R.id.ListViewMonHoc);
        btnThem = (Button) findViewById(R.id.buttonThem);
        edt = (EditText) findViewById(R.id.editText);
        btnCapNhat = (Button) findViewById(R.id.btncapnhat);


        arrayCourse = new ArrayList<>();
        arrayCourse.add("Guitar Electric");
        arrayCourse.add("Cajon");
        arrayCourse.add("Drum");
        arrayCourse.add("Sao");
        arrayCourse.add("Violin");
        arrayCourse.add("Harmonica");
        arrayCourse.add("Piano");


         final ArrayAdapter adapter = new ArrayAdapter(
                 MainActivity.this,
                 android.R.layout.simple_list_item_1,
                 arrayCourse
         );
        lvNhacCu.setAdapter(adapter)    ;

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nhaccu = edt.getText().toString();
                arrayCourse.add(nhaccu);
                adapter.notifyDataSetChanged();

            }
        });
        lvNhacCu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edt.setText(arrayCourse.get(i));
                vitri = i;
            }
        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.set(vitri, edt.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        lvNhacCu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayCourse.remove(i);
                adapter.notifyDataSetChanged();

            }
        });
    }
}