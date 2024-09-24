package org.example.flab.pattern.factory.oauth;

public record UserProfile(String userId, String userName, String email) {
    public static UserProfile from(String userId, String userName, String email) {
        return new UserProfile(userId, userName, email);
    }
}
