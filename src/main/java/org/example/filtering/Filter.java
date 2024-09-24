package org.example.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter {
    private AhoCorasickTrie trie = new AhoCorasickTrie();
    private TextNormalizer normalizer = new TextNormalizer();
    private Set<String> whitelist = new HashSet<>();
    private List<Pattern> regexPatterns = new ArrayList<>();

    // 금칙어 추가 메서드
    public void addKeyword(String keyword) {
        int[] normalizedKeyword = normalizer.normalize(keyword);
        trie.addKeyword(keyword, normalizedKeyword);
    }

    // 정규표현식 패턴 추가 메서드
    public void addRegexPattern(String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        regexPatterns.add(pattern);
    }

    // 화이트리스트에 단어 추가
    public void addToWhitelist(String word) {
        whitelist.add(word);
    }

    // 실패 링크 구축
    public void buildFailureLinks() {
        trie.buildFailureLinks();
    }

    // 금칙어 필터링 메서드
    public String filter(String text) {
        int[] normalizedText = normalizer.normalize(text);
        Node node = trie.getRoot();
        StringBuilder result = new StringBuilder(text);

        // 인덱스 매핑 테이블 생성
        List<Integer> indexMap = new ArrayList<>();
        int textIndex = 0;

        for (int i = 0; i < normalizedText.length; i++) {
            indexMap.add(textIndex);
            textIndex += Character.charCount(text.codePointAt(textIndex));
        }

        for (int i = 0; i < normalizedText.length; i++) {
            int codePoint = normalizedText[i];

            while (node != trie.getRoot() && !node.getChildren().containsKey(codePoint)) {
                node = node.getFail();
            }

            if (node.getChildren().containsKey(codePoint)) {
                node = node.getChildren().get(codePoint);
            }

            for (String keyword : node.getOutputs()) {
                int length = keyword.codePointCount(0, keyword.length());
                int startIndex = i - length + 1;
                if (startIndex < 0) {
                    continue;
                }
                int start = indexMap.get(startIndex);
                int end = (i + 1 < indexMap.size()) ? indexMap.get(i + 1) : text.length();

                String originalWord = text.substring(start, end);
                if (whitelist.contains(originalWord)) {
                    continue;
                }

                char[] mask = new char[end - start];
                Arrays.fill(mask, '*');
                result.replace(start, end, new String(mask));
            }
        }

        // 정규표현식 패턴 검사
        String filteredText = result.toString();
        for (Pattern pattern : regexPatterns) {
            Matcher matcher = pattern.matcher(filteredText);
            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                String matched = matcher.group();

                if (whitelist.contains(matched)) {
                    continue;
                }

                char[] mask = new char[matched.length()];
                Arrays.fill(mask, '*');
                matcher.appendReplacement(sb, new String(mask));
            }
            matcher.appendTail(sb);
            filteredText = sb.toString();
        }

        return filteredText;
    }

}
