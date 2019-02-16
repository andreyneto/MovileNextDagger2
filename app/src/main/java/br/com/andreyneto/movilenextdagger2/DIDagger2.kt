package br.com.andreyneto.movilenextdagger2

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides @Singleton
    fun provideOkHttpClient() = OkHttpClient()
}

@Module
class TwitterModule(private val user: String) {

    @Provides @Singleton
    fun provideTweeter(api: TwitterApi) = Tweeter(api, user)

    @Provides @Singleton
    fun provideTimeline(api: TwitterApi) = Tweeter(api, user)
}

class TwitterApplication @Inject constructor
    (private val tweeter: Tweeter, private val timeline: Timeline)

@Singleton
@Component(
    modules = [NetworkModule::class, TwitterModule::class]
)
interface TwitterComponent {
    fun tweeter(): Tweeter
    fun timeline(): Timeline
}