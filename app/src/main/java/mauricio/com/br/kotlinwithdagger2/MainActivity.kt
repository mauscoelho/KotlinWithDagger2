package mauricio.com.br.kotlinwithdagger2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import mauricio.com.br.kotlinwithdagger2.R.id.recycler
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    var myAdapter = MyAdapter()

    @Inject
    lateinit var myDependency : SomeDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.myComponent.inject(this)
        recycler.adapter = myAdapter
        btn_test.setOnClickListener { doSomething() }
    }

    private fun doSomething() {
        myDependency.doSomething()
        val listStrings = listOf<String>("E ai", "blz", "testando", "som")
        listStrings.map { myAdapter.addObject(it) }
    }


}
