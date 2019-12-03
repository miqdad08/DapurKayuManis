package id.com.miqdad.basicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class UtamaActivity extends AppCompatActivity {

    TextView txtJumlah, tvHarga, txtGetNama;
    EditText edtNama;
    CheckBox cbxAymGeprek, cbxAymBkr, cbxBbkGrng, cbxLele;
    int jumlah, total, harga=10, geprek, bakar, bebek, lele;
    String nama, statusGeprek="tidak", statusBakar="tidak", statusBebek="tidak", statusLele="tidak";
    boolean iscbx_lele, iscbx_bakar, iscbx_geprek, iscbx_bebek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);

        txtJumlah = findViewById(R.id.txt_Jumlah);
        tvHarga = findViewById(R.id.tv_harga);
        txtGetNama = findViewById(R.id.txt_getNama);
        edtNama = findViewById(R.id.etNama);
        cbxAymBkr = findViewById(R.id.cbx__aymBakr);
        cbxAymGeprek = findViewById(R.id.cbx__aymGeprek);
        cbxBbkGrng = findViewById(R.id.cbx__bbkGrng);
        cbxLele = findViewById(R.id.cbx_lele);

    }

    public void makanan(){
        if (cbxLele.isChecked()){
            iscbx_lele=true;
            statusLele="Pecel Lele";
            lele=4;
        }else {
            iscbx_lele=false;
            statusLele="";
            lele=0;
        }

        if (cbxBbkGrng.isChecked()){
            iscbx_bebek=true;
            statusBebek="Bebek Goreng";
            bebek=3;
        }else {
            iscbx_bebek=false;
            statusBebek="";
            bebek=0;
        }

        if (cbxAymGeprek.isChecked()){
            iscbx_geprek=true;
            statusGeprek="Ayam geprek";
            geprek=1;
        }else {
            iscbx_geprek=false;
            statusGeprek="";
            geprek=0;
        }

        if (cbxAymBkr.isChecked()){
            iscbx_bakar=true;
            statusBakar="Pecel Lele";
            bakar=2;
        }else {
            iscbx_bakar=false;
            statusBakar="";
            bakar=0;
        }

    }

    public void tambah(View view) {
        jumlah = jumlah + 1;
        txtJumlah.setText("" + jumlah);
    }

    public void kurang(View view) {
        jumlah = jumlah - 1;
        txtJumlah.setText("" + jumlah);
    }

    public void order(View view) {
        display(harga);
    }
    public void display(int harga){
        makanan();
        total = jumlah*harga;
        if (iscbx_bakar){
            total+=(jumlah * harga);
        }
        total = jumlah*harga;
        if (iscbx_geprek){
            total+=(jumlah * harga);
        }
        total = jumlah*harga;
        if (iscbx_bebek){
            total+=(jumlah * harga);
        }
        total = jumlah*harga;
        if (iscbx_lele){
            total+=(jumlah * harga);
        }
        Log.i("Harga : ", "" + total );
        nama =  edtNama.getText().toString();
        txtGetNama.setText("Nama : " + nama +
                "\n" + statusBakar +
                     "\n"+ statusGeprek +
                     "\n"+ statusBebek +
                     "\n"+ statusLele +
                     "\nTerima Kasih");
        tvHarga.setText("Harga : Rp" +total+"000");
    }
    public void share(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "miqdaddeveloper@gmail.com");
        intent.putExtra(intent.EXTRA_SUBJECT, "Pesanan Makanan");
        intent.putExtra(intent.EXTRA_TEXT,
                "Nama : "+nama +
                "\n" + statusBebek +
                "\n" + statusGeprek +
                "\n" + statusLele +
                "\n" + statusBakar +
                "\n" + "Harga : RP." + total +"000"+
                "\nTerima Kasih");

        startActivity(Intent.createChooser(intent, "Send Email"));
    }
}
