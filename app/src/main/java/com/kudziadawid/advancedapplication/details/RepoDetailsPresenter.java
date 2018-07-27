package com.kudziadawid.advancedapplication.details;

import com.kudziadawid.advancedapplication.data.RepoRepository;
import com.kudziadawid.advancedapplication.di.ScreenScope;

import javax.inject.Inject;
import javax.inject.Named;

@ScreenScope
class RepoDetailsPresenter {

    @Inject
    RepoDetailsPresenter(
            @Named("repo_owner") String repoOwner,
            @Named("repo_name") String repoName,
            RepoRepository repoRepository,
            RepoDetailsViewModel viewModel) {
        repoRepository.getRepo(repoOwner, repoName)
                .doOnSuccess(viewModel.processRepo())
                .doOnError(viewModel.detailsError())
                .flatMap(repo -> repoRepository.getContributors(repo.contributorsUrl())
                        .doOnError(viewModel.contributorError()))
                .subscribe(viewModel.processContributors(), throwable -> {
                    // We handle logging in the view model
                });
    }
}
