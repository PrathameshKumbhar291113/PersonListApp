package com.prathameshkumbhar.realmtutorial

import com.prathameshkumbhar.realmtutorial.data.RealmTutorialAppRepoImpl
import com.prathameshkumbhar.realmtutorial.data.RealmTutorialAppRepository
import com.prathameshkumbhar.realmtutorial.model.Address
import com.prathameshkumbhar.realmtutorial.model.Person
import com.prathameshkumbhar.realmtutorial.model.Pet
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RealmTutorialAppModule {
    @Singleton
    @Provides
    fun provideRealm(): Realm {
        val config = RealmConfiguration.Builder(
            schema = setOf(
                Person::class, Address::class, Pet::class
            )
        )
            .compactOnLaunch()
            .build()
        return Realm.open(config)
    }

    @Singleton
    @Provides
    fun provideRealmTutorialAppRepository(realm: Realm): RealmTutorialAppRepository {
        return RealmTutorialAppRepoImpl(realm = realm)
    }
}