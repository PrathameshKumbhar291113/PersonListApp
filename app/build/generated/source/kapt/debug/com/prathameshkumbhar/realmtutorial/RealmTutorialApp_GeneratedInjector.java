package com.prathameshkumbhar.realmtutorial;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = RealmTutorialApp.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface RealmTutorialApp_GeneratedInjector {
  void injectRealmTutorialApp(RealmTutorialApp realmTutorialApp);
}
