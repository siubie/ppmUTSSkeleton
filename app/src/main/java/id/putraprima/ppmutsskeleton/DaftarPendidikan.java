package id.putraprima.ppmutsskeleton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import id.putraprima.ppmutsskeleton.adapter.PendidikanAdapter;
import id.putraprima.ppmutsskeleton.models.Pendidikan;

public class DaftarPendidikan extends AppCompatActivity {
    private RecyclerView rvPendidikan;
    private Button btnTambahPendidikan;
    private PendidikanAdapter adPendidikan;
    private List<Pendidikan> listPendidikan = new ArrayList<>();
//    public List<Profil> listProfil = new ArrayList<>();
    private Long idProfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_pendidikan);
        rvPendidikan  = (RecyclerView) findViewById(R.id.rvPendidikan);
        btnTambahPendidikan = (Button) findViewById(R.id.btnTambahPendidikan);
        Intent i = getIntent();
        idProfil= i.getLongExtra("idProfil",0L);
        listPendidikan = Pendidikan.find(Pendidikan.class,"profil = ?", String.valueOf(idProfil));
        rvPendidikan = (RecyclerView) findViewById(R.id.rvPendidikan);
        adPendidikan = new PendidikanAdapter(R.layout.item_pendidikan,listPendidikan);

        btnTambahPendidikan = (Button) findViewById(R.id.btnTambahPendidikan);
        btnTambahPendidikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(getApplicationContext(),TambahPendidikan.class);
                j.putExtra("idProfil",DaftarPendidikan.this.idProfil);
                startActivity(j);
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvPendidikan.setLayoutManager(mLayoutManager);
        rvPendidikan.setItemAnimator(new DefaultItemAnimator());
        rvPendidikan.setAdapter(adPendidikan);
        adPendidikan.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        listPendidikan.clear();
        listPendidikan = Pendidikan.find(Pendidikan.class,"profil = ?", String.valueOf(idProfil));
        adPendidikan.setNewData(listPendidikan);
        adPendidikan.notifyDataSetChanged();
        super.onResume();
    }
}
