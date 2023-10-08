package org.example.programmers.lv1;

public class 신규_아이디_추천 {

    public String solution(String new_id) {
        // 길이 3 ~ 15
        // 알파벳 소문자, 숫자, 빼기(-), 밑줄(_),마침표(.)문자만 사용할 수 있음
        // 단 마침표는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        new_id = new_id.replaceAll("(\\.)+", ".");
        if (new_id.startsWith(".")) {
            new_id = new_id.substring(1);
        }
        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        if (new_id.isBlank()) {
            new_id = "a";
        }
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            if (new_id.endsWith(".")) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        StringBuilder sb = new StringBuilder(new_id);
        while (sb.length() < 3) {
            sb.append(sb.substring(sb.length() - 1));
        }
        return sb.toString();
    }
}
