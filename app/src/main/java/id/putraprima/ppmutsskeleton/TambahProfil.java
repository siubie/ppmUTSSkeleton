package id.putraprima.ppmutsskeleton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import id.putraprima.ppmutsskeleton.models.Profil;

public class TambahProfil extends AppCompatActivity {
    EditText txtNama,txtNim,txtHobby,txtNomorTelepon;
    Button btnSaveProfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_profil);
        txtNama = (EditText) findViewById(R.id.txtNama);
        txtNim = (EditText) findViewById(R.id.txtNim);
        txtHobby = (EditText) findViewById(R.id.txtHobby);
        txtNomorTelepon = (EditText) findViewById(R.id.txtNomorTelepon);

        btnSaveProfil = (Button) findViewById(R.id.btnSaveProfil);

        btnSaveProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Profil itemProfil = new Profil(txtNama.getText().toString(),txtNomorTelepon.getText().toString(),txtNim.getText().toString(),txtHobby.getText().toString());
                itemProfil.save();
            }
        });

    }
}
