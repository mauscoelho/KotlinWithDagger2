package mauricio.com.br.kotlinwithdagger2.infraestruture.interactor

import mauricio.com.br.kotlinwithdagger2.model.Github
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable


interface GithubNetwork {
    @GET("users/{username}")
    fun getGithubUser(@Path("username") username : String) : Observable<Github>
}