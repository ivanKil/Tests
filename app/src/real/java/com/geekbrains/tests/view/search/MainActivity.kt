package com.geekbrains.tests.view.search

import com.geekbrains.tests.presenter.RepositoryContract
import com.geekbrains.tests.repository.GitHubApi
import com.geekbrains.tests.repository.GitHubRepository

class MainActivity : MainActivityBase() {
    override fun createRepository(): RepositoryContract =
        GitHubRepository(createRetrofit().create(GitHubApi::class.java))
}
