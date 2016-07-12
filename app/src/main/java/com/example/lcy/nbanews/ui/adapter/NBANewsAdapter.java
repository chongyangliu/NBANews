package com.example.lcy.nbanews.ui.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lcy.nbanews.R;
import com.example.lcy.nbanews.entity.NBANewsEntity;
import com.example.lcy.nbanews.util.DateFormatterUtils;
import com.example.lcy.nbanews.widget.ImageManager;

import org.joda.time.DateTime;

import java.util.List;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-7-12.
 */
public class NBANewsAdapter extends BaseMultiItemQuickAdapter<NBANewsEntity.NewslistBean> {
    public static final int TEXT = 1;
    public static final int IMG = 2;
    public static final int MORE_IMG = 3;
    public NBANewsAdapter(List<NBANewsEntity.NewslistBean> data) {
        super(data);
        addItemType(TEXT, R.layout.item_fragment_news_nopic);
        addItemType(IMG, R.layout.item_fragment_news_normal);
        addItemType(MORE_IMG, R.layout.item_fragment_news_morepic);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, NBANewsEntity.NewslistBean newslistBean) {
        switch (baseViewHolder.getItemViewType()) {
            case TEXT:
                baseViewHolder.setText(R.id.tv_title, newslistBean.getTitle())
                              .setText(R.id.tv_time, DateFormatterUtils.getRecentlyTimeFormatText(new DateTime(newslistBean.getPutdate())))
                              .setText(R.id.tv_description, newslistBean.getDescription())
                              .setText(R.id.tv_source, newslistBean.getSourceType());

                break;
            case IMG:
                ImageManager.getInstance().loadUrlImage(mContext, newslistBean.getImgUrlList().get(0), (ImageView) baseViewHolder.getView(R.id.iv_image));
                baseViewHolder.setText(R.id.tv_title, newslistBean.getTitle())
                        .setText(R.id.tv_time, DateFormatterUtils.getRecentlyTimeFormatText(new DateTime(newslistBean.getPutdate())));
                break;
            case MORE_IMG:
                baseViewHolder.setText(R.id.tv_title, newslistBean.getTitle())
                        .setText(R.id.tv_time, DateFormatterUtils.getRecentlyTimeFormatText(new DateTime(newslistBean.getPutdate())))
                        .setText(R.id.tv_source, newslistBean.getSourceType());
                ImageManager.getInstance().loadUrlImage(mContext, newslistBean.getImgUrlList().get(0), (ImageView) baseViewHolder.getView(R.id.iv_image1));
                ImageManager.getInstance().loadUrlImage(mContext, newslistBean.getImgUrlList().get(1), (ImageView) baseViewHolder.getView(R.id.iv_image2));
                ImageManager.getInstance().loadUrlImage(mContext, newslistBean.getImgUrlList().get(2), (ImageView) baseViewHolder.getView(R.id.iv_image3));
                break;
        }
    }
}
