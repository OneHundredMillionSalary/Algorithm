package kakao;

// TODO : 효율성 고려해서 다시 풀어야함
// https://programmers.co.kr/learn/courses/30/lessons/60060
// 가사 검색

public class KAKAO_BLIND_RECRUITMENT_2020 {
    public int[] solution(String[] words, String[] queries) {
        final int queryLen = queries.length;
        int[] answer = new int[queryLen];

        for (int i = 0; i < queryLen; i++) {
            queries[i] = queries[i].replace('?', '.');
        }

        for (String word : words) {
            for (int i = 0; i < queryLen; i++) {
                if (word.matches(queries[i])) answer[i]++;
            }
        }

        return answer;
    }
}
