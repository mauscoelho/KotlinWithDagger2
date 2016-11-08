package mauricio.com.br.kotlinwithdagger2

import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AndroidModule::class))
interface MyComponent {
    fun inject(mainActivity: MainActivity)
}