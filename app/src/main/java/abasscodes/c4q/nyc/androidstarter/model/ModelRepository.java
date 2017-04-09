package abasscodes.c4q.nyc.androidstarter.model;

import java.util.ArrayList;
import java.util.List;

public class ModelRepository {

    public static List<HockeyPlayer> getHockeyRoster() {
        List<HockeyPlayer> hockeyPlayers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            hockeyPlayers.add(new HockeyPlayer(" Test " + i, "Defenseman"));
        }
        return hockeyPlayers;
    }
}
