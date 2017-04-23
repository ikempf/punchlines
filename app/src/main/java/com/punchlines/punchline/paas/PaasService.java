package com.punchlines.punchline.paas;

import java.util.List;

import java8.util.concurrent.CompletableFuture;

public class PaasService {

    private PaasRepository repository;

    public PaasService(PaasRepository repository) {
        this.repository = repository;
    }

    public CompletableFuture<Punchline> dailyPunchline() {
        return repository.dailyPunchline();
    }

    public CompletableFuture<Punchline> randomPunchline() {
        return repository.randomPunchline();
    }

    public CompletableFuture<List<String>> artists() {
        return repository.artists();
    }

    public CompletableFuture<List<Punchline>> artistPunchlines(String artist) {
        return repository.artistPunchlines(artist);
    }

}