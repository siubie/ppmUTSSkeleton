package id.putraprima.ppmutsskeleton.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import id.putraprima.ppmutsskeleton.R;
import id.putraprima.ppmutsskeleton.models.Pendidikan;

/**
 * Created by putraprima on 01/11/17.
 */

public class PendidikanAdapter extends BaseQuickAdapter<Pendidikan,BaseViewHolder>{

    public PendidikanAdapter(@LayoutRes int layoutResId, @Nullable List<Pendidikan> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Pendidikan item) {
        helper.setText(R.id.txtNamaSekolah,item.getNamaSekolah());
    }
}
