package mauricio.com.br.kotlinwithdagger2.di

import dagger.Component
import mauricio.com.br.kotlinwithdagger2.MainActivity
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AndroidModule::class))
interface MyComponent {
    fun inject(mainActivity: MainActivity)
}