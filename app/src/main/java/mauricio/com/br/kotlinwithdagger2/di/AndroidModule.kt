package mauricio.com.br.kotlinwithdagger2.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import mauricio.com.br.kotlinwithdagger2.SomeDependency
import mauricio.com.br.kotlinwithdagger2.SomeDependencyImpl
import mauricio.com.br.kotlinwithdagger2.network.GithubService
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
    fun provideGithubService(retrofit: Retrofit) : GithubService{
        return retrofit.create(GithubService::class.java)
    }

    @Provides
    fun provideSomeDependency(): SomeDependency {
        return SomeDependencyImpl()
    }
}