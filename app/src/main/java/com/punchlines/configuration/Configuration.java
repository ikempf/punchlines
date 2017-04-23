package com.punchlines.configuration;

public class Configuration {

    public static final String API_URL = "http://punchlines-as-a-service.cleverapps.io/";

    public static final String DAILY = "/punchlines/daily";
    public static final String RANDOM = "/punchlines/random";
    public static final String ARTISTS = "/artists";

    public static final String ARTIST_ARGUMENT = "artist";
    public static final String ARTIST_PUNCHLINES = "/punchlines/artist/{" + ARTIST_ARGUMENT + "}";

}
