package id.putraprima.ppmutsskeleton.models;

import android.widget.ProgressBar;

import com.orm.SugarRecord;

/**
 * Created by putraprima on 31/10/17.
 */

public class Profil extends SugarRecord<Profil>{
    private String nama,nomorTelepon,nim,hobby;

    public Profil() {
    }

    public Profil(String nama, String nomorTelepon, String nim, String hobby) {
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.nim = nim;
        this.hobby = hobby;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
