package org.example.flab.pattern.factory.oauth;

public class GithubOAuth2Provider implements OAuth2Provider {
    @Override
    public String getAuthorizationUrl() {
        return "http//github.com/oauth/authorize";
    }

    @Override
    public String getAccessToken(String code) {
        // code를 이용해 access token을 요청하는 로직
        return "github_access_token";
    }

    @Override
    public UserProfile getUserProfile(String accessToken) {
        return UserProfile.from("github_user_id", "github_user_name", "github_user_email");
    }
}
