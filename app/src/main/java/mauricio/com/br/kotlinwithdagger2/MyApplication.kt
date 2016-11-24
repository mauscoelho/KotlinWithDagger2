package mauricio.com.br.kotlinwithdagger2

import android.app.Application
import mauricio.com.br.kotlinwithdagger2.dagger.AndroidModule
import mauricio.com.br.kotlinwithdagger2.dagger.DaggerMyComponent
import mauricio.com.br.kotlinwithdagger2.dagger.MyComponent


class MyApplication : Application() {

    companion object {
        @JvmStatic lateinit var myComponent: MyComponent
    }

    override fun onCreate() {
        super.onCreate()
        myComponent = DaggerMyComponent.builder().androidModule(AndroidModule(this)).build()
    }
}