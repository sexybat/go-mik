/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.di.component;

import id.co.next_innovation.go_mik.di.PerService;
import id.co.next_innovation.go_mik.di.module.ServiceModule;
import id.co.next_innovation.go_mik.service.SyncService;

import dagger.Component;

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(SyncService service);
}
