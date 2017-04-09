package abasscodes.c4q.nyc.androidstarter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import abasscodes.c4q.nyc.androidstarter.model.HockeyPlayer;
import abasscodes.c4q.nyc.androidstarter.rosterlist.MainActivity;

public class HockeyAdapter extends RecyclerView.Adapter<MainActivity.HockeyVH> {

    private final List<HockeyPlayer> data = new ArrayList<>();

    @Override
    public MainActivity.HockeyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainActivity.HockeyVH(parent);
    }

    @Override
    public void onBindViewHolder(MainActivity.HockeyVH holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
