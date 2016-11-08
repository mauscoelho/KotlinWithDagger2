package mauricio.com.br.kotlinwithdagger2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var myDependency : SomeDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.myComponent.inject(this)
        setClick()
    }

    private fun setClick() {
        var btn : Button = findViewById(R.id.btn_test) as Button
        btn.setOnClickListener { doSomething() }
    }

    private fun doSomething() {
        var txt : TextView = findViewById(R.id.txt_dosomething) as TextView
        txt.text = "Do Something"
        myDependency.doSomething()
    }


}
