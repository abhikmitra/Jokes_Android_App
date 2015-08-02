package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.test.UiThreadTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by abmitra on 8/2/2015.
 */
public class AsyncTaskTest extends AndroidTestCase implements IDownloadListener {
    AsyncJokeDownloader downloader;
    CountDownLatch signal;
    String joke ="";

    protected void setUp() throws Exception {
        super.setUp();

        signal = new CountDownLatch(1);
        downloader = new AsyncJokeDownloader(this);
    }

    @UiThreadTest
    public void testDownload() throws InterruptedException
    {
        downloader.downloadJoke();
        signal.await(30, TimeUnit.SECONDS);

        assertTrue("Valid joke is returned", joke !=null);
    }

    @Override
    public void downloadCompleted(String j) {
        joke = j;
        signal.countDown();
    }


}
