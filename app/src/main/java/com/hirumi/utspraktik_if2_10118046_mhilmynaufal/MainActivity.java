package com.hirumi.utspraktik_if2_10118046_mhilmynaufal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

//        Nama              : M Hilmy Naufal
//        Kelas             : If-2
//        NIM               : 10118046
//        Tanggal Pengerjaan: 05 Juni 2021

    private EditText edtNIK, edtNama, edtTanggal;
    private RadioGroup rgKelamin, rgHubungan;
    private Button selanjutnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNIK = findViewById(R.id.edtNIK);
        edtNama = findViewById(R.id.edtNama);
        edtTanggal = findViewById(R.id.edtTanggal);

        rgKelamin = findViewById(R.id.rgKelamin);
        rgHubungan = findViewById(R.id.rgHubungan);

        selanjutnya = findViewById(R.id.selanjutnya);

        selanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama, nik, tanggal, kelamin, hubungan;
                RadioButton rbKelamin, rbHubungan;

                nama = edtNama.getText().toString();
                nik = edtNIK.getText().toString();
                tanggal = edtTanggal.getText().toString();

                int selectedID = rgKelamin.getCheckedRadioButtonId();
                rbKelamin = (RadioButton) findViewById(selectedID);
                kelamin = rbKelamin.getText().toString();

                selectedID = rgHubungan.getCheckedRadioButtonId();
                rbHubungan = (RadioButton) findViewById(selectedID);
                hubungan = rbHubungan.getText().toString();

                Intent intent = new Intent(MainActivity.this, CekActivity.class);
                intent.putExtra("nama", nama);
                intent.putExtra("nik", nik);
                intent.putExtra("tanggal", tanggal);
                intent.putExtra("kelamin", kelamin);
                intent.putExtra("hubungan", hubungan);

                startActivity(intent);
            }
        });


    }
}