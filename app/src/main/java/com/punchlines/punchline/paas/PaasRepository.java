package com.punchlines.punchline.paas;

import com.punchlines.configuration.Configuration;

import java8.util.concurrent.CompletableFuture;
import retrofit2.http.GET;

public interface PaasRepository {

    @GET(Configuration.DAILY)
    CompletableFuture<Punchline> dailyPunchline();

    @GET(Configuration.RANDOM)
    CompletableFuture<Punchline> randomPunchline();

}