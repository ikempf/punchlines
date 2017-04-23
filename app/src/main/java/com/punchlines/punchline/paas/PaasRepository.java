package com.punchlines.punchline.paas;

import java.util.List;

import java8.util.concurrent.CompletableFuture;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.punchlines.configuration.Configuration.ARTISTS;
import static com.punchlines.configuration.Configuration.ARTIST_ARGUMENT;
import static com.punchlines.configuration.Configuration.ARTIST_PUNCHLINES;
import static com.punchlines.configuration.Configuration.DAILY;
import static com.punchlines.configuration.Configuration.RANDOM;

public interface PaasRepository {

    @GET(DAILY)
    CompletableFuture<Punchline> dailyPunchline();

    @GET(RANDOM)
    CompletableFuture<Punchline> randomPunchline();

    @GET(ARTISTS)
    CompletableFuture<List<String>> artists();

    @GET(ARTIST_PUNCHLINES)
    CompletableFuture<List<Punchline>> artistPunchlines(@Path(ARTIST_ARGUMENT) String artist);

}