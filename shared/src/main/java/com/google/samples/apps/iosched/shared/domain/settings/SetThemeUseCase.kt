/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.iosched.shared.domain.settings

import com.google.samples.apps.iosched.model.Theme
import com.google.samples.apps.iosched.model.themeFromStorageKey
import com.google.samples.apps.iosched.shared.data.prefs.PreferenceStorage
import com.google.samples.apps.iosched.shared.di.IoDispatcher
import com.google.samples.apps.iosched.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

open class SetThemeUseCase @Inject constructor(
    private val preferenceStorage: PreferenceStorage,
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher
) : UseCase<Theme, Theme>(coroutineDispatcher) {

    override fun execute(parameters: Theme): Theme {
        preferenceStorage.selectedTheme = parameters.storageKey
        return themeFromStorageKey(preferenceStorage.selectedTheme)
    }
}
