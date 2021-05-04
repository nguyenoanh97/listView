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
    Button btnThem;
    EditText edtMOnHoc;
    ArrayList<String> arrayCourse;
    Button btnCapNhat;
    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        btnCapNhat = (Button) findViewById(R.id.buttonCapNhat);
        btnThem = (Button) findViewById(R.id.buttonThem);
        edtMOnHoc = (EditText) findViewById(R.id.editTextMonHoc);
        lvMonHoc = (ListView) findViewById(R.id.listviewMonHoc);
        arrayCourse = new ArrayList<>();

        arrayCourse.add("Android");
        arrayCourse.add("PHP");
        arrayCourse.add("RUBY");
        arrayCourse.add("CSS");
        arrayCourse.add("HTML");
        arrayCourse.add("JAVA");

        // Bước 3
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayCourse);
        lvMonHoc.setAdapter(adapter);

        // bắt sự kiện từng item listview
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position : trả về vị trí ng dùng click trên listview -> 0
                Toast.makeText(MainActivity.this, arrayCourse.get(position), Toast.LENGTH_SHORT).show();

            }
        });

        // bắt sự kiện từng item listview lấy nội dung (giữ lâu)
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Long click: " + position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // bắt sự kiện ấn nút btnThem
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monhọc = edtMOnHoc.getText().toString(); // lấy nội dung từ editMonHoc
                // add vào mảng Môn học
                arrayCourse.add(monhọc);
                //cập nhật lại adepter
                adapter.notifyDataSetChanged();

            }
        });
        // bắt sự kiện đổ nội dung từng item lên edit text sau khi click
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtMOnHoc.setText(arrayCourse.get(position));
                vitri = position;
            }
        });
        // bắt sự kiện ấn button Cập Nhật
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCourse.set(vitri, edtMOnHoc.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        // bắt sự kiện xóa item
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayCourse.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });


    }

}