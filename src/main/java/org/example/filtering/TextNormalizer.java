package org.example.filtering;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;

public class TextNormalizer {
    private Map<Integer, Integer> normalizationMap;

    public TextNormalizer() {
        initializeNormalizationMap();
    }

    // 유사 문자 매핑 초기화
    private void initializeNormalizationMap() {
        normalizationMap = new HashMap<>();
        normalizationMap.put((int)'1', (int)'i');
        normalizationMap.put((int)'!', (int)'i');
        normalizationMap.put((int)'I', (int)'i');
        normalizationMap.put((int)'|', (int)'i');
        normalizationMap.put((int)'ㅣ', (int)'ㅣ');
        normalizationMap.put((int)'0', (int)'o');
        normalizationMap.put((int)'3', (int)'e');
        normalizationMap.put((int)'@', (int)'a');
        normalizationMap.put((int)'ㅅ', (int)'ㅅ');
        // 필요에 따라 추가 매핑
    }

    // 문자 정규화 메서드
    public int[] normalize(String text) {
        // 유니코드 정규화 (NFKC 방식)
        String normalizedText = Normalizer.normalize(text, Normalizer.Form.NFKC);
        int[] codePoints = normalizedText.codePoints().toArray();

        for (int i = 0; i < codePoints.length; i++) {
            int cp = codePoints[i];
            if (normalizationMap.containsKey(cp)) {
                codePoints[i] = normalizationMap.get(cp);
            }
        }
        return codePoints;
    }
}
