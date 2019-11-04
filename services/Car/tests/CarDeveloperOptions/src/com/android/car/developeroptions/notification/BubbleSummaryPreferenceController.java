/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.car.developeroptions.notification;

import static android.provider.Settings.Secure.NOTIFICATION_BUBBLES;

import android.app.settings.SettingsEnums;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;

import com.android.car.developeroptions.R;
import com.android.car.developeroptions.applications.AppInfoBase;
import com.android.car.developeroptions.core.SubSettingLauncher;

import androidx.preference.Preference;

public class BubbleSummaryPreferenceController extends NotificationPreferenceController {

    private static final String KEY = "bubble_link_pref";
    private static final int SYSTEM_WIDE_ON = 1;
    private static final int SYSTEM_WIDE_OFF = 0;

    public BubbleSummaryPreferenceController(Context context, NotificationBackend backend) {
        super(context, backend);
    }

    @Override
    public String getPreferenceKey() {
        return KEY;
    }

    @Override
    public boolean isAvailable() {
        if (!super.isAvailable()) {
            return false;
        }
        if (mAppRow == null && mChannel == null) {
            return false;
        }
        if (mChannel != null) {
            if (Settings.Secure.getInt(mContext.getContentResolver(),
                    NOTIFICATION_BUBBLES, SYSTEM_WIDE_ON) == SYSTEM_WIDE_OFF) {
                return false;
            }
            if (isDefaultChannel()) {
                return true;
            } else {
                return mAppRow == null ? false : mAppRow.allowBubbles;
            }
        }
        return true;
    }

    @Override
    public void updateState(Preference preference) {
        super.updateState(preference);

        if (mAppRow != null) {
            Bundle args = new Bundle();
            args.putString(AppInfoBase.ARG_PACKAGE_NAME, mAppRow.pkg);
            args.putInt(AppInfoBase.ARG_PACKAGE_UID, mAppRow.uid);

            preference.setIntent(new SubSettingLauncher(mContext)
                    .setDestination(AppBubbleNotificationSettings.class.getName())
                    .setArguments(args)
                    .setSourceMetricsCategory(
                            SettingsEnums.NOTIFICATION_APP_NOTIFICATION)
                    .toIntent());
        }
    }

    @Override
    public CharSequence getSummary() {
        boolean canBubble = false;
        if (mAppRow != null) {
            if (mChannel != null) {
                canBubble |= mChannel.canBubble();
            } else {
               canBubble |= mAppRow.allowBubbles
                       && (Settings.Secure.getInt(mContext.getContentResolver(),
                       NOTIFICATION_BUBBLES, SYSTEM_WIDE_ON) == SYSTEM_WIDE_ON);
            }
        }
        return mContext.getString(canBubble ? R.string.switch_on_text : R.string.switch_off_text);
    }
}
