package org.team_rocket_unc.electronica_digital_app;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class GeneralTests {

    @Test
    public void testVersion() {
        int EXPECTED_MIN_SDK_VERSION = 11;
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Assert.assertEquals(EXPECTED_MIN_SDK_VERSION, appContext.getApplicationInfo().minSdkVersion);
    }



}
