package mauricio.com.br.kotlinwithdagger2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import mauricio.com.br.kotlinwithdagger2.domain.boundary.GithubService
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    var myAdapter = MyAdapter()

    @Inject
    lateinit var githubService: GithubService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.myComponent.inject(this)
        recycler.adapter = myAdapter
        btn_test.setOnClickListener { doSomething() }
    }

    private fun doSomething() {
        githubService.getGithubUser("mauriciocoelho")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    data ->
                    myAdapter.addObject(data.login)
                },{ e ->
                    print(message = "error:${e.message}")
                })
    }


}
