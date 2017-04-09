package abasscodes.c4q.nyc.androidstarter.rosterdetail;

import android.support.annotation.NonNull;

import abasscodes.c4q.nyc.androidstarter.R;
import abasscodes.c4q.nyc.androidstarter.base.BaseMvpActivity;

public class DetailActivity extends BaseMvpActivity<DetailContract.Presenter> implements DetailContract.View{
    @NonNull
    @Override
    public DetailContract.Presenter createPresenter() {
       return new DetailPresenter(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_detail;
    }
}
