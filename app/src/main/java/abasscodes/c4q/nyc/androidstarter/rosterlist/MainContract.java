package abasscodes.c4q.nyc.androidstarter.rosterlist;

import java.util.List;

import abasscodes.c4q.nyc.androidstarter.base.BaseContract;
import abasscodes.c4q.nyc.androidstarter.model.HockeyPlayer;

public interface MainContract {

    interface View extends BaseContract.View {
        void showRosterList(List<HockeyPlayer> data);

        void showDetailScreen(HockeyPlayer hockeyPlayer);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void onItemClicked(int position);
    }
}
