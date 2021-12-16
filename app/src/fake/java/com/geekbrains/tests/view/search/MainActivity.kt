package com.geekbrains.tests.view.search

import com.geekbrains.tests.presenter.RepositoryContract
import com.geekbrains.tests.repository.FakeGitHubRepository

class MainActivity : MainActivityBase() {
    override fun createRepository(): RepositoryContract = FakeGitHubRepository()
}

