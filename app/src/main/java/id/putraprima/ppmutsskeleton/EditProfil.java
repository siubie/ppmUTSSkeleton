package id.putraprima.ppmutsskeleton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import id.putraprima.ppmutsskeleton.models.Profil;

public class EditProfil extends AppCompatActivity {
    EditText txtNama,txtNim,txtHobby,txtNomorTelepon;
    Button btnSaveProfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);
        Intent i = getIntent();

        final Long idProfil = i.getLongExtra("id",0L);
        txtNama = (EditText) findViewById(R.id.txtNama);
        txtNama.setText(i.getStringExtra("nama"));
        txtNim = (EditText) findViewById(R.id.txtNim);
        txtNim.setText(i.getStringExtra("nim"));
        txtHobby = (EditText) findViewById(R.id.txtHobby);
        txtHobby.setText(i.getStringExtra("hobby"));
        txtNomorTelepon = (EditText) findViewById(R.id.txtNomorTelepon);
        txtNomorTelepon.setText(i.getStringExtra("nomorTelepon"));


        btnSaveProfil = (Button) findViewById(R.id.btnSaveProfil);

        btnSaveProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Profil itemProfil = Profil.findById(Profil.class,idProfil);
                itemProfil.setNama(txtNama.getText().toString());
                itemProfil.setNim(txtNim.getText().toString());
                itemProfil.setHobby(txtHobby.getText().toString());
                itemProfil.setNomorTelepon(txtNomorTelepon.getText().toString());
                itemProfil.save();
            }
        });
    }
}
