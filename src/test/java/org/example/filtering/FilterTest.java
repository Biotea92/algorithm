package org.example.filtering;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterTest {

    @Test
    void test() {
        Filter filter = new Filter();

        // 금칙어 추가
        filter.addKeyword("금칙어");
        filter.addKeyword("비속어");
        filter.addKeyword("나쁜말");
        filter.addKeyword("시발");

        // 정규표현식 패턴 추가
        filter.addRegexPattern("ㅅ[ㅣi!1\\|][ㅂb][ㅏa][ㄹr]"); // '시발'의 변형 패턴

        // 화이트리스트에 단어 추가
        filter.addToWhitelist("시발점"); // 오탐지를 방지하기 위한 단어

        // 실패 링크 구축
        filter.buildFailureLinks();

        // 필터링할 텍스트
        String text = "이건 ㅅ1발 문제가 아니야. 시발점은 중요해. ㅅI발이라고 쓰면 어떻게 될까? 나쁜말을 쓰면 안 돼.";

        // 필터링 수행
        String filteredText = filter.filter(text);

        // 결과 출력
        System.out.println("원본 텍스트: " + text);
        System.out.println("필터링된 텍스트: " + filteredText);
    }
}
