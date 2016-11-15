package mauricio.com.br.kotlinwithdagger2

import android.app.Application
import mauricio.com.br.kotlinwithdagger2.di.AndroidModule
import mauricio.com.br.kotlinwithdagger2.di.DaggerMyComponent
import mauricio.com.br.kotlinwithdagger2.di.MyComponent


class MyApplication : Application() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var myComponent: MyComponent
    }

    override fun onCreate() {
        super.onCreate()
        myComponent = DaggerMyComponent.builder().androidModule(AndroidModule(this)).build()
    }
}