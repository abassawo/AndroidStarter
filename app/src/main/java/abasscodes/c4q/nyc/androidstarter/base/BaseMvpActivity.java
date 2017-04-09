package abasscodes.c4q.nyc.androidstarter.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseMvpActivity<T extends BaseContract.Presenter> extends AppCompatActivity implements BaseContract.View {

    protected T presenter;

    @NonNull
    public abstract T createPresenter();

    protected abstract int getLayoutResourceId();

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        presenter = createPresenter();
        onViewCreated(savedInstanceState);
        presenter.onViewCreated();
    }

    /**
     * Override this method to do any additional view initialization (ex: setup RecycleView adapter)
     */
    protected void onViewCreated(Bundle savedInstanceState) {
        //initialize views. rv and stuff should not be null after this is called
    }

    @Override
    @CallSuper
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        presenter.bindView(this);
    }

    @Override
    @CallSuper
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.bindView(this);
    }

    @Override
    @CallSuper
    public void onStart() {
        super.onStart();
        presenter.bindView(this);
    }

    @Override
    @CallSuper
    public void onStop() {
        super.onStop();
        presenter.unbindView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onViewDestroyed();
    }
}