/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.ui.home;

import id.co.next_innovation.go_mik.ui.base.MvpPresenter;

public interface HomeMvpPresenter<V extends HomeView> extends MvpPresenter<V> {

    void loadCategory();
}
