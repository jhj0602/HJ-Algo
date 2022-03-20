package programmers.level3;

import org.junit.Test;

import java.util.*;

public class P42579 {
    @Test
    public void 정답() {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> genresMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        System.out.println(genresMap);
        List<String> genresList = new ArrayList<>(genresMap.keySet());
        Collections.sort(genresList, (o1, o2) -> genresMap.get(o2) - genresMap.get(o1));

        ArrayList<Integer> answerList = new ArrayList<>();
        for (String s : genresList) {
            HashMap<Integer, Integer> playsMap = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if (s.equals(genres[i])) {
                    playsMap.put(i, plays[i]);
                }
            }
            List<Integer> playList = new ArrayList<>(playsMap.keySet());
            Collections.sort(playList, (o1, o2) -> playsMap.get(o2) - playsMap.get(o1));
            int j = 0;
            for (Integer i : playList) {
                if (j > 1) {
                    break;
                }
                answerList.add(i);
                j++;
            }
        }
        answer = answerList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
