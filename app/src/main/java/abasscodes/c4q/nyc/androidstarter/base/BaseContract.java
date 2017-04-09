package abasscodes.c4q.nyc.androidstarter.base;

public interface BaseContract {

    public interface View {
    }

    public interface Presenter<T extends View> {

        void bindView(T view);

        void unbindView();

        void onViewCreated();

        void onViewDestroyed();
    }
}
