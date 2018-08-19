package org.vagrs.english.common;

/**
 * Created by Kirill Zhitelev on 13.05.2018.
 */
public final class Constants {
    public static final String ENG_JNDI_DATA_SOURCE = "java:/EnglishDS";

    /*JWT*/
    public static final String HEADER_PREFIX = "Bearer ";
    public static final String AUTH_HEADER = "Authorization";
    public static final String TOKEN_TIME = System.getenv().getOrDefault("token_time", "6000");
    public static final String SECRET = System.getenv().getOrDefault("secret", "qwaszx123");

    /*Exception messages*/
    public static final String BAD_CRED = "Bad username or password, please verify it";
    public static final String ACCESS_DENIED = "Access denied";
}
