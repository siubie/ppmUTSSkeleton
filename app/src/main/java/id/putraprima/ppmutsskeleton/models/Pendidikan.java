package id.putraprima.ppmutsskeleton.models;

import com.orm.SugarRecord;

/**
 * Created by putraprima on 01/11/17.
 */

public class Pendidikan extends SugarRecord<Pendidikan>{
    private String namaSekolah;
    private Profil profil;

    public Pendidikan() {
    }

    public Pendidikan(String namaSekolah, Profil profil) {
        this.namaSekolah = namaSekolah;
        this.profil = profil;
    }

    public String getNamaSekolah() {
        return namaSekolah;
    }

    public void setNamaSekolah(String namaSekolah) {
        this.namaSekolah = namaSekolah;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }
}
