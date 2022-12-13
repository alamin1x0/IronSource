package com.developeralamin.ironsource;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.BannerListener;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        IronSource.init(this, "17bd3ad9d");

        LinearLayout bannerContainer = findViewById(R.id.bannerId);
        IronSourceBannerLayout banner = IronSource.createBanner(this, ISBannerSize.BANNER);
        bannerContainer.addView(banner);

        banner.setBannerListener(new BannerListener() {
            @Override
            public void onBannerAdLoaded() {


            }

            @Override
            public void onBannerAdLoadFailed(IronSourceError ironSourceError) {

            }

            @Override
            public void onBannerAdClicked() {

            }

            @Override
            public void onBannerAdScreenPresented() {

            }

            @Override
            public void onBannerAdScreenDismissed() {

            }

            @Override
            public void onBannerAdLeftApplication() {

            }
        });

        IronSource.loadBanner(banner);

        IronSource.loadInterstitial();

        IronSource.setInterstitialListener(new InterstitialListener() {
            @Override
            public void onInterstitialAdReady() {

            }

            @Override
            public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {

            }

            @Override
            public void onInterstitialAdOpened() {

            }

            @Override
            public void onInterstitialAdClosed() {

            }

            @Override
            public void onInterstitialAdShowSucceeded() {

            }

            @Override
            public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {

            }

            @Override
            public void onInterstitialAdClicked() {

            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IronSource.showInterstitial();
            }
        });



        IronSource.loadRewardedVideo();
        IronSource.setRewardedVideoListener(new RewardedVideoListener() {
            @Override
            public void onRewardedVideoAdOpened() {

            }

            @Override
            public void onRewardedVideoAdClosed() {

            }

            @Override
            public void onRewardedVideoAvailabilityChanged(boolean b) {

            }

            @Override
            public void onRewardedVideoAdStarted() {

            }

            @Override
            public void onRewardedVideoAdEnded() {

            }

            @Override
            public void onRewardedVideoAdRewarded(Placement placement) {

            }

            @Override
            public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {

            }

            @Override
            public void onRewardedVideoAdClicked(Placement placement) {

            }
        });

        findViewById(R.id.rewaredBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IronSource.showRewardedVideo();
            }
        });
    }


    protected void onResume() {
        super.onResume();
        IronSource.onResume(this);
    }

    protected void onPause() {
        super.onPause();
        IronSource.onPause(this);
    }

}