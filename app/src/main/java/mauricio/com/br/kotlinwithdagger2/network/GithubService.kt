package mauricio.com.br.kotlinwithdagger2.network

import mauricio.com.br.kotlinwithdagger2.models.Github
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable


interface GithubService {
    @GET("users/{username}")
    fun getGithubUser(@Path("username") username : String) : Observable<Github>
}