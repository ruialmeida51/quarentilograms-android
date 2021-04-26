package com.ruialmeida.quarentilograms.features

import com.ruialmeida.quarentilograms.features.authenticated.AuthenticatedModule
import com.ruialmeida.quarentilograms.features.authentication.AuthenticationModule
import com.ruialmeida.quarentilograms.features.dms.DmsModule
import com.ruialmeida.quarentilograms.features.feed.FeedModule
import com.ruialmeida.quarentilograms.features.friends.FriendsModule
import com.ruialmeida.quarentilograms.features.login.LoginModule
import com.ruialmeida.quarentilograms.features.newpost.NewPostModule
import com.ruialmeida.quarentilograms.features.profile.ProfileModule
import com.ruialmeida.quarentilograms.features.register.RegisterModule
import com.ruialmeida.quarentilograms.features.search.SearchModule
import com.ruialmeida.quarentilograms.features.settings.SettingsModule
import com.ruialmeida.quarentilograms.sdk.koin.KoinModuleList

object FeaturesModule : KoinModuleList {
    override fun getModules() = LoginModule.getModule() +
            RegisterModule.getModule() +
            FeedModule.getModule() +
            ProfileModule.getModule() +
            SettingsModule.getModule() +
            SearchModule.getModule() +
            NewPostModule.getModule() +
            FriendsModule.getModule() +
            DmsModule.getModule() +
            AuthenticationModule.getModule() +
            AuthenticatedModule.getModule()
}