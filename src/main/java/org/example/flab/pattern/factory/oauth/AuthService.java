package org.example.flab.pattern.factory.oauth;

public class AuthService {
    public void login(OAuth2ProviderType providerType, String code) {
        OAuth2Provider provider = OAuth2ProviderFactory.getProvider(providerType);
        String url = provider.getAuthorizationUrl();
        String accessToken = provider.getAccessToken(code);
        UserProfile userProfile = provider.getUserProfile(accessToken);
    }
}
