package org.example.flab.pattern.factory.oauth;

public class GoogleOAuth2Provider implements OAuth2Provider {
    @Override
    public String getAuthorizationUrl() {
        return "https://accounts.google.com/o/oauth2/auth";
    }

    @Override
    public String getAccessToken(String code) {
        // code를 이용해 access token을 요청하는 로직
        return "google_access_token";
    }

    @Override
    public UserProfile getUserProfile(String accessToken) {
        // access token을 이용해 사용자 정보를 요청하는 로직
        return UserProfile.from("google_user_id", "google_user_name", "google_user_email");
    }
}
