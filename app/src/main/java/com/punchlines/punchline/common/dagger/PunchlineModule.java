package com.punchlines.punchline.common.dagger;

import com.punchlines.common.Java8CallAdapterFactory;
import com.punchlines.configuration.Configuration;
import com.punchlines.punchline.paas.PaasRepository;
import com.punchlines.punchline.paas.PaasService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module
public class PunchlineModule {

    @Provides
    @Singleton
    Retrofit providesRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        return new Retrofit.Builder()
                .client(client)
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