package mauricio.com.br.kotlinwithdagger2.dagger

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import mauricio.com.br.kotlinwithdagger2.infraestruture.boundary.GithubRepository
import mauricio.com.br.kotlinwithdagger2.domain.boundary.GithubService
import mauricio.com.br.kotlinwithdagger2.domain.interactor.GithubServiceImpl
import mauricio.com.br.kotlinwithdagger2.infraestruture.interactor.GithubNetwork
import mauricio.com.br.kotlinwithdagger2.infraestruture.interactor.GithubRepositoryImpl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AndroidModule(private val application: Application) {

    @Provides
    @Singleton
    @ForApplication
    fun provideApplicationContext(): Context {
        return application
    }

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(OkHttpClient())
                .build()
    }

    @Provides
    fun provideGithubService(githubRepository: GithubRepository) : GithubService {
        return GithubServiceImpl(githubRepository)
    }

    @Provides
    fun provideGithubRepository() : GithubRepository {
        return GithubRepositoryImpl(provideGithubNetwork(provideRetrofit()))
    }

    @Provides
    fun provideGithubNetwork(retrofit: Retrofit) : GithubNetwork{
        return retrofit.create(GithubNetwork::class.java)
    }

}