/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.data;

import id.co.next_innovation.go_mik.data.network.ApiHelper;
import id.co.next_innovation.go_mik.data.prefs.PreferencesHelper;
import id.co.next_innovation.go_mik.data.db.DbHelper;

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {
}
