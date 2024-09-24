package org.example.flab.pattern.factory.oauth;

public class OAuth2ProviderFactory {
    public static OAuth2Provider getProvider(OAuth2ProviderType type) {
        return switch (type) {
            case GOOGLE -> new GoogleOAuth2Provider();
            case KAKAO -> new KakaoOAuth2Provider();
            case GITHUB -> new GithubOAuth2Provider();
            default -> throw new IllegalArgumentException("Unsupported OAuth2ProviderType: " + type);
        };
    }
}
