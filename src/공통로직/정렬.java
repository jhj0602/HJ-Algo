package 공통로직;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 정렬 {
    static class Player {
        int score;
        String name;

        public Player(int score, String name) {
            this.score = score;
            this.name = name;
        }
        public String toString(){
            return this.score + " "+this.name;
        }
    }

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player(15, "z"));
        players.add(new Player(50, "zz"));
        players.add(new Player(15, "a"));
        players.add(new Player(25, "b"));
        players.add(new Player(25, "a"));
        Collections.sort(players, (a, b) -> b.score - a.score);

    }

}
