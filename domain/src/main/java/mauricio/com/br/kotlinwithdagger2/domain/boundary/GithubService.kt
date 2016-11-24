package mauricio.com.br.kotlinwithdagger2.domain.boundary

import mauricio.com.br.kotlinwithdagger2.model.Github
import rx.Observable


interface GithubService {

    fun getGithubUser(username: String) : Observable<Github>

}