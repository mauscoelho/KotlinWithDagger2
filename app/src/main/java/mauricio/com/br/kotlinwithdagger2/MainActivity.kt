package mauricio.com.br.kotlinwithdagger2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var myDependency : SomeDependency

    @BindView(R.id.txt_dosomething)
    lateinit var txt : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.myComponent.inject(this)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.btn_test)
    fun click(btn: Button) {
         doSomething()
    }

    private fun doSomething() {
        txt.text = "Do Something"
        myDependency.doSomething()
    }


}
