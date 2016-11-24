package mauricio.com.br.kotlinwithdagger2.domain.interactor

import mauricio.com.br.kotlinwithdagger2.infraestruture.boundary.GithubRepository
import mauricio.com.br.kotlinwithdagger2.domain.boundary.GithubService
import mauricio.com.br.kotlinwithdagger2.model.Github
import rx.Observable


class GithubServiceImpl(val githubRepository: GithubRepository) : GithubService{

    override fun getGithubUser(username: String): Observable<Github> {
        return githubRepository.getGithubUser(username)
    }
}