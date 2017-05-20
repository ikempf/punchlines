package com.punchlines.punchline.common.dagger

import com.punchlines.common.Java8CallAdapterFactory
import com.punchlines.application.Configuration
import com.punchlines.punchline.paas.PaasRepository
import com.punchlines.punchline.paas.PaasService

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Module
class PunchlineModule {

    @Provides @Singleton
    internal fun providesRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
                .client(client)
                .baseUrl(Configuration.API_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(Java8CallAdapterFactory.create())
                .build()
    }

    @Provides @Singleton
    internal fun providesPaasRepository(retrofit: Retrofit): PaasRepository =
            retrofit.create(PaasRepository::class.java)

    @Provides @Singleton
    internal fun providesPaasService(repository: PaasRepository): PaasService =
            PaasService(repository)

}