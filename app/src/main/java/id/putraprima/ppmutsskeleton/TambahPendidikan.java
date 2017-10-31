package id.putraprima.ppmutsskeleton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import id.putraprima.ppmutsskeleton.models.Pendidikan;
import id.putraprima.ppmutsskeleton.models.Profil;

public class TambahPendidikan extends AppCompatActivity {
    EditText txtNamaSekolah;
    Button btnSavePendidikan;
    Long idProfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pendidikan);
        Intent i = getIntent();
        idProfil = i.getLongExtra("idProfil",0L);
        txtNamaSekolah= (EditText) findViewById(R.id.txtNamaSekolah);
        btnSavePendidikan = (Button) findViewById(R.id.btnSimpanPendidikan);
        btnSavePendidikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Profil profil = Profil.findById(Profil.class,TambahPendidikan.this.idProfil);
                Pendidikan itemPendidikan = new Pendidikan(txtNamaSekolah.getText().toString(),profil);
                itemPendidikan.save();
            }
        });
    }
}
