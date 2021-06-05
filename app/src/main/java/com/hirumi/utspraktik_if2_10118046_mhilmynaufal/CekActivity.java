package com.hirumi.utspraktik_if2_10118046_mhilmynaufal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class CekActivity extends AppCompatActivity {

//        Nama              : M Hilmy Naufal
//        Kelas             : If-2
//        NIM               : 10118046
//        Tanggal Pengerjaan: 05 Juni 2021

    private String nama, nik, tanggal, kelamin, hubungan;
    private EditText hasilNama, hasilNIK, hasilKelamin, hasilHubungan, hasilTanggal;
    private Button ubah, cek, ok;

    private BottomSheetBehavior behavior;
    private BottomSheetDialog dialog;
    View bot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            nama = bundle.getString("nama");
            nik = bundle.getString("nik");
            tanggal = bundle.getString("tanggal");
            kelamin = bundle.getString("kelamin");
            hubungan = bundle.getString("hubungan");
        }

        hasilNama = findViewById(R.id.hasilNama);
        hasilNIK = findViewById(R.id.hasilNIK);
        hasilTanggal = findViewById(R.id.hasilTanggal);
        hasilKelamin = findViewById(R.id.hasilJenisKelamin);
        hasilHubungan = findViewById(R.id.hasilHubungan);
        ubah = findViewById(R.id.ubah);
        cek = findViewById(R.id.cek);

        hasilNama.setText(nama);
        hasilNIK.setText(nik);
        hasilTanggal.setText(tanggal);
        hasilKelamin.setText(kelamin);
        hasilHubungan.setText(hubungan);

        ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        bot = findViewById(R.id.bot);
        behavior = BottomSheetBehavior.from(bot);

        cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheet();
            }
        });

    }

    private void showBottomSheet() {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

        dialog = new BottomSheetDialog(this);
        dialog.setContentView(view);

        ok = view.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                System.exit(0);
            }
        });

        dialog.show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                dialog = null;
            }
        });
    }
}