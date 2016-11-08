package mauricio.com.br.kotlinwithdagger2

import android.app.Application


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