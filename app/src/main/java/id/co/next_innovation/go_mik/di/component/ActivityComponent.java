/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.di.component;

import id.co.next_innovation.go_mik.di.module.ActivityModule;
import id.co.next_innovation.go_mik.ui.category.CategoryFragment;
import id.co.next_innovation.go_mik.ui.comic.ComicFragment;
import id.co.next_innovation.go_mik.ui.episode.EpisodeFragment;
import id.co.next_innovation.go_mik.ui.home.HomeActivity;
import id.co.next_innovation.go_mik.ui.splash.SplashActivity;
import id.co.next_innovation.go_mik.di.PerActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity splashActivity);

    void inject(HomeActivity homeActivity);

    void inject(CategoryFragment categoryFragment);

    void inject(ComicFragment comicFragment);

    void inject(EpisodeFragment episodeFragment);

}
