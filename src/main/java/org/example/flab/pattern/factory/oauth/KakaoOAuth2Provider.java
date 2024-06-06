package org.example.flab.pattern.factory.oauth;

public class KakaoOAuth2Provider implements OAuth2Provider {
    @Override
    public String getAuthorizationUrl() {
        return "https://kauth.kakao.com/oauth/authorize";
    }

    @Override
    public String getAccessToken(String code) {
        // code를 이용해 access token을 요청하는 로직
        return "kakao_access_token";
    }

    @Override
    public UserProfile getUserProfile(String accessToken) {
        // access token을 이용해 사용자 정보를 요청하는 로직
        return UserProfile.from("kakao_user_id", "kakao_user_name", "kakao_user_email");
    }
}
