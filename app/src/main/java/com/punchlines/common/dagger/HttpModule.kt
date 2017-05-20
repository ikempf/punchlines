package com.punchlines.common.dagger

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.punchlines.application.Configuration
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
class HttpModule {

    @Provides @Singleton
    internal fun providesObjectMapper(): ObjectMapper =
        ObjectMapper().registerModule(KotlinModule())

    @Provides @Singleton
    internal fun providesRetrofit(objectMapper: ObjectMapper): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
                .client(client)
                .baseUrl(Configuration.API_URL)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .addCallAdapterFactory(Java8CallAdapterFactory.create())
                .build()
    }

}