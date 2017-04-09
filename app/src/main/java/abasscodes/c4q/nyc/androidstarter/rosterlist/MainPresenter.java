package abasscodes.c4q.nyc.androidstarter.rosterlist;

import java.util.ArrayList;
import java.util.List;

import abasscodes.c4q.nyc.androidstarter.base.BasePresenter;
import abasscodes.c4q.nyc.androidstarter.model.HockeyPlayer;
import abasscodes.c4q.nyc.androidstarter.model.ModelRepository;

public class MainPresenter extends BasePresenter<MainContract.View> implements  MainContract.Presenter{
    ArrayList<HockeyPlayer> data;

    public MainPresenter(MainContract.View view) {
        super(view);
    }

    @Override
    public void onViewCreated() {
        data = (ArrayList<HockeyPlayer>) ModelRepository.getHockeyRoster();
        view.showRosterList(data);
    }

    @Override
    public void onViewDestroyed() {

    }

    @Override
    public void onItemClicked(int position) {
        showDetailPage(position);
    }

    private void showDetailPage(int position) {
        HockeyPlayer player = data.get(position);
        view.showDetailScreen(player);
    }
}
