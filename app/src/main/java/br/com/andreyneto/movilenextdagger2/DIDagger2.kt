package br.com.andreyneto.movilenextdagger2

import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideOkHttpClient() = OkHttpClient()

    @Provides
    fun proviteTwitterApi(client: OkHttpClient) = TwitterApi(client)
}