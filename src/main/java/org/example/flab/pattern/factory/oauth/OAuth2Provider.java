package org.example.flab.pattern.factory.oauth;

public interface OAuth2Provider {
    String getAuthorizationUrl();
    String getAccessToken(String code);
    UserProfile getUserProfile(String accessToken);
}
