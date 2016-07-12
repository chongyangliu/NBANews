package com.example.lcy.nbanews.ui.activity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.lcy.nbanews.R;
import com.example.lcy.nbanews.base.BaseAppCompatActivity;
import com.example.lcy.nbanews.entity.NBANewsEntity;
import com.example.lcy.nbanews.ui.presenter.NewsDetailPresenter;
import com.example.lcy.nbanews.ui.view.NewsDetailView;
import com.example.lcy.nbanews.util.SnackBarUtils;
import com.example.lcy.nbanews.widget.ImageManager;

import butterknife.BindView;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-7-12.
 */
public class NewsDetailActivity extends BaseAppCompatActivity implements NewsDetailView {
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.iv_title)
    ImageView mIvTitle;

    @BindView(R.id.webLayout)
    FrameLayout mFrameLayout;

    private WebView mWebView;

    private WebSettings mWebSettings;

    @Override
    protected boolean swipeBackEnable() {
        return true;
    }

    @Override
    protected void initViewsAndDatas(Bundle savedInstanceState) {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setTitle("NBANews");

        NBANewsEntity.NewslistBean newslistBean = (NBANewsEntity.NewslistBean) getIntent().getSerializableExtra("data");
        NewsDetailPresenter newsDetailPresenter = new NewsDetailPresenter(this);
        newsDetailPresenter.getNewsDetails(newslistBean.getArticleUrl());


        mCollapsingToolbarLayout.setTitle(newslistBean.getTitle());
        ImageManager.getInstance().loadUrlImage(this, newslistBean.getImgUrlList().get(0), mIvTitle);

        mWebView = new WebView(getApplicationContext());
        mFrameLayout.addView(mWebView);
        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true); //如果访问的页面中有Javascript，则WebView必须设置支持Javascript
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        mWebSettings.setSupportZoom(true); //支持缩放
        mWebSettings.setBuiltInZoomControls(true); //支持手势缩放
        mWebSettings.setDisplayZoomControls(false); //是否显示缩放按钮

        // >= 19(SDK4.4)启动硬件加速，否则启动软件加速
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            mWebSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        } else {
            mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            mWebSettings.setLoadsImagesAutomatically(false);
        }
        mWebSettings.setTextSize(WebSettings.TextSize.LARGEST);
        mWebSettings.setUseWideViewPort(true); //将图片调整到适合WebView的大小
        mWebSettings.setLoadWithOverviewMode(true); //自适应屏幕
        mWebSettings.setDomStorageEnabled(true);
        mWebSettings.setSaveFormData(true);
        mWebSettings.setSupportMultipleWindows(true);
        mWebSettings.setAppCacheEnabled(true);
        mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); //优先使用缓存

        mWebView.setHorizontalScrollbarOverlay(true);
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.setOverScrollMode(View.OVER_SCROLL_NEVER); // 取消WebView中滚动或拖动到顶部、底部时的阴影
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); // 取消滚动条白边效果
        mWebView.requestFocus();
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mWebView.setLayerType(View.LAYER_TYPE_NONE, null);
                if (!mWebSettings.getLoadsImagesAutomatically()) {
                    mWebSettings.setLoadsImagesAutomatically(true);
                }
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mFrameLayout != null) {
            mFrameLayout.removeAllViews();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setNewsContent(String content) {
        mWebView.loadDataWithBaseURL("", content, "text/html", "UTF-8", null);
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void showErrorMsg(String msg) {
        SnackBarUtils.showSnackBar(mCollapsingToolbarLayout, msg);
    }
}
