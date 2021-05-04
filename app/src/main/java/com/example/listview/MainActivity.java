package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    ArrayList<MonHoc> arrayMonHoc;
    MonHocAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        Anhxa();

        adapter = new MonHocAdapter(this, R.layout.dong_mon_hoc, arrayMonHoc);
        lvMonHoc.setAdapter(adapter);






    }

    private void Anhxa() {
        lvMonHoc = (ListView) findViewById(R.id.listviewMonHoc);
        arrayMonHoc = new ArrayList<>();
        arrayMonHoc.add(new MonHoc("Android", "Hệ điều hành Android", R.drawable.androi));
        arrayMonHoc.add(new MonHoc("PHP", "Lập trình PHP", R.drawable.php));
        arrayMonHoc.add(new MonHoc("RUBY", getString(R.string.mota), R.drawable.ruby));
        arrayMonHoc.add(new MonHoc("CSS", "CSS", R.drawable.css));
        arrayMonHoc.add(new MonHoc("HTML", "HTML", R.drawable.html));
        arrayMonHoc.add(new MonHoc("Java", "Lập trình Java", R.drawable.java));

    }

}