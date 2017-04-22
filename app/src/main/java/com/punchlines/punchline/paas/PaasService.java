package com.punchlines.punchline.paas;

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

}