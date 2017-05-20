package com.punchlines.punchline.common.dagger

import com.punchlines.punchline.paas.PaasRepository
import com.punchlines.punchline.paas.PaasService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class PunchlineModule {

    @Provides @Singleton
    internal fun providesPaasRepository(retrofit: Retrofit): PaasRepository =
            retrofit.create(PaasRepository::class.java)

    @Provides @Singleton
    internal fun providesPaasService(repository: PaasRepository): PaasService =
            PaasService(repository)

}