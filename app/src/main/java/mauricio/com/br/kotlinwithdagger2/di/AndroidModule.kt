package mauricio.com.br.kotlinwithdagger2.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import mauricio.com.br.kotlinwithdagger2.SomeDependency
import mauricio.com.br.kotlinwithdagger2.SomeDependencyImpl
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
    fun provideSomeDependency(): SomeDependency {
        return SomeDependencyImpl()
    }
}