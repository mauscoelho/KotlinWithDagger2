package mauricio.com.br.kotlinwithdagger2.infraestruture.interactor

import mauricio.com.br.kotlinwithdagger2.infraestruture.boundary.GithubRepository
import mauricio.com.br.kotlinwithdagger2.model.Github
import rx.Observable

class GithubRepositoryImpl(val githubNetwork: GithubNetwork) : GithubRepository {
    override fun getGithubUser(username: String): Observable<Github> {
        return githubNetwork.getGithubUser(username)
    }
}