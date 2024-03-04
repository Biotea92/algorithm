package org.example.leetcode;

import java.util.Arrays;

/*

you start with an initial power of power, an initial score of 0, and a bag of tokens given as an integer array tokens
, where each tokens[i] donates the value of tokeni.

your goal is to maximize the total score by strategically playing these tokens. in one move,
you can play an unplayed token in one of the two ways (but not both for the same token):

- face-up: if your current power is at least tokens[i], you may play tokeni, losing tokens[i] power and gaining 1 score.
- face-down: if your current score is at least 1, you may play tokeni, gaining tokens[i] power and losing 1 score.

return the maximum possible score you can achieve after playing any number of tokens.

0 <= tokens.length <= 1000
0 <= tokens[i], power < 104
*/
public class Bag_of_Tokens {

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int maxScore = 0;
        int left = 0;
        int right = tokens.length - 1;

        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                left++;
                score++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                power += tokens[right];
                right--;
                score--;
            } else {
                break;
            }
        }

        return maxScore;
    }
}
