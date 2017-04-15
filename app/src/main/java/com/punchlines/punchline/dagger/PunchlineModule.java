package com.punchlines.punchline.dagger;

import com.punchlines.common.Java8CallAdapterFactory;
import com.punchlines.configuration.Configuration;
import com.punchlines.punchline.paas.PaasRepository;
import com.punchlines.punchline.paas.PaasService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module
public class PunchlineModule {

    @Provides
    @Singleton
    Retrofit providesRetrovit() {
        return new Retrofit.Builder()
                .baseUrl(Configuration.API_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(Java8CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    PaasRepository providesPaasRepository(Retrofit retrofit) {
        return retrofit.create(PaasRepository.class);
    }

    @Provides
    @Singleton
    PaasService providesPaasService(PaasRepository repository) {
        return new PaasService(repository);
    }

}