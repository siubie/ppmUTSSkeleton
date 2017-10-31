package id.putraprima.ppmutsskeleton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import id.putraprima.ppmutsskeleton.adapter.ProfilAdapter;
import id.putraprima.ppmutsskeleton.models.Profil;

public class MainActivity extends AppCompatActivity {
    public Button btnTambah;
    public List<Profil> listProfil = new ArrayList<>();
    public Profil itemProfil;
    public ProfilAdapter mAdapter;
    public RecyclerView mRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listProfil = Profil.listAll(Profil.class);
        mRecycler = (RecyclerView) findViewById(R.id.listProfil);
        mAdapter = new ProfilAdapter(R.layout.item_profil,listProfil);

        btnTambah = (Button) findViewById(R.id.btnTambah);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setItemAnimator(new DefaultItemAnimator());
        mRecycler.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Profil itemProfil = listProfil.get(position);
                switch (view.getId()){
                    case R.id.btnEdit:
                        Intent i = new Intent(getApplicationContext(),EditProfil.class);
                        i.putExtra("id",itemProfil.getId());
                        i.putExtra("nama",itemProfil.getNama());
                        i.putExtra("nomorTelepon",itemProfil.getNomorTelepon());
                        i.putExtra("nim",itemProfil.getNim());
                        i.putExtra("hobby",itemProfil.getHobby());
                        startActivity(i);
                        break;
                    case R.id.btnDelete:
                        itemProfil.delete();
                        listProfil.clear();
                        listProfil = Profil.listAll(Profil.class);
                        mAdapter.setNewData(listProfil);
                        mAdapter.notifyDataSetChanged();
                        break;
                    case R.id.nama:
                        Intent j = new Intent(getApplicationContext(),DetailProfil.class);
                        j.putExtra("id",itemProfil.getId());
                        j.putExtra("nama",itemProfil.getNama());
                        j.putExtra("nomorTelepon",itemProfil.getNomorTelepon());
                        j.putExtra("nim",itemProfil.getNim());
                        j.putExtra("hobby",itemProfil.getHobby());
                        startActivity(j);
                        break;

                }
            }
        });


        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TambahProfil.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        listProfil.clear();
        listProfil = Profil.listAll(Profil.class);
        mAdapter.setNewData(listProfil);
        mAdapter.notifyDataSetChanged();
        super.onResume();
    }
}
