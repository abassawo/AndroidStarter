package abasscodes.c4q.nyc.androidstarter.rosterlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import abasscodes.c4q.nyc.androidstarter.R;
import abasscodes.c4q.nyc.androidstarter.base.BaseMvpActivity;
import abasscodes.c4q.nyc.androidstarter.model.HockeyPlayer;
import abasscodes.c4q.nyc.androidstarter.rosterdetail.DetailActivity;

public class MainActivity extends BaseMvpActivity<MainContract.Presenter> implements MainContract.View{
    private RecyclerView recyclerView;

    @NonNull
    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showRosterList(List<HockeyPlayer> data) {
//        adapter.setData(data);
    }

    @Override
    public void showDetailScreen(HockeyPlayer hockeyPlayer) {
        Intent intent = new Intent(this, DetailActivity.class);
    }

    public class HockeyAdapter extends RecyclerView.Adapter<MainActivity.HockeyVH> {

        private final List<HockeyPlayer> data = new ArrayList<>();

        @Override
        public MainActivity.HockeyVH onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater infl =  LayoutInflater.from(parent.getContext());
            View view = infl.inflate(R.layout.row_item, parent, false);
            return new MainActivity.HockeyVH(view);
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

    public class HockeyVH extends RecyclerView.ViewHolder {

        public HockeyVH(View parent) {
            super(parent);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.onItemClicked(getAdapterPosition());
                }
            });
        }

        public void bind(HockeyPlayer hockeyPlayer) {
            // Picasso. show hockeyplayer image
            //text view set right text
        }
    }

}
