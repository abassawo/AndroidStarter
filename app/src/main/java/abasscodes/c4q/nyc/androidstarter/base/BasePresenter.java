package abasscodes.c4q.nyc.androidstarter.base;

public abstract class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter<T> {
    protected T view;

    public BasePresenter(T view){
        this.view = view;
    }

    @Override
    public void bindView(T view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        this.view = null;
    }
}
