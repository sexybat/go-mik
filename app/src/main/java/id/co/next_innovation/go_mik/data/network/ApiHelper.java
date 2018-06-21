/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.data.network;

import io.reactivex.Observable;

public interface ApiHelper {

    ApiHeader getApiHeader();

    Observable<ComicResponse> fetchAllComics();

    Observable<ComicResponse> fetchComicsByCategory(int category_id);

    Observable<CategoryResponse> fetchCategories();

    Observable<EpisodeResponse> fetchAllEpisodes();

    Observable<EpisodeResponse> fetchEpisodes(int comic_id);
}
