package id.putraprima.ppmutsskeleton.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import id.putraprima.ppmutsskeleton.R;
import id.putraprima.ppmutsskeleton.models.Profil;

/**
 * Created by putraprima on 31/10/17.
 */

public class ProfilAdapter extends BaseQuickAdapter<Profil,BaseViewHolder>{

    public ProfilAdapter(@LayoutRes int layoutResId, @Nullable List<Profil> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Profil item) {
        helper.setText(R.id.nama,item.getNama());
        helper.addOnClickListener(R.id.btnDelete);
        helper.addOnClickListener(R.id.btnEdit);
        helper.addOnClickListener(R.id.nama);
    }
}
