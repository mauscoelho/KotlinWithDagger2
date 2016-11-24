package mauricio.com.br.kotlinwithdagger2.infraestruture.boundary

import mauricio.com.br.kotlinwithdagger2.model.Github
import rx.Observable


interface GithubRepository {
    fun getGithubUser(username:String) : Observable<Github>
}