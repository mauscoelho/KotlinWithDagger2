package mauricio.com.br.kotlinwithdagger2

import android.util.Log


class SomeDependencyImpl : SomeDependency{

    override fun getSomething(): String = "Get Something"

    override fun doSomething() {
        Log.d("Teste", "doSomething")
    }
}