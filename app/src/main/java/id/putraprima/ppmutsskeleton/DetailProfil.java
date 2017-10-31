package id.putraprima.ppmutsskeleton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailProfil extends AppCompatActivity {
    TextView txtNama,txtNim,txtHobby,txtNomorTelepon;
    Button btnDaftarPendidikan,btnDaftarKeluarga;
    Long idProfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_profil);
        Intent i = getIntent();

        idProfil = i.getLongExtra("id",0L);
        txtNama = (TextView) findViewById(R.id.txtNama);
        txtNama.setText(i.getStringExtra("nama"));
        txtNim = (TextView) findViewById(R.id.txtNim);
        txtNim.setText(i.getStringExtra("nim"));
        txtHobby = (TextView) findViewById(R.id.txtHobby);
        txtHobby.setText(i.getStringExtra("hobby"));
        txtNomorTelepon = (TextView) findViewById(R.id.txtNomorTelepon);
        txtNomorTelepon.setText(i.getStringExtra("nomorTelepon"));

        btnDaftarPendidikan = (Button) findViewById(R.id.btnDaftarPendidikan);
        btnDaftarKeluarga = (Button) findViewById(R.id.btnDaftarKeluarga);
        btnDaftarPendidikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toPendidikan = new Intent(getApplicationContext(),DaftarPendidikan.class);
                toPendidikan.putExtra("idProfil",DetailProfil.this.idProfil);
                startActivity(toPendidikan);
            }
        });
    }
}
