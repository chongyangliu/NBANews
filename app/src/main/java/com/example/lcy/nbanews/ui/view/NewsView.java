package com.example.lcy.nbanews.ui.view;

import com.example.lcy.nbanews.entity.NBANewsEntity;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-7-12.
 */
public interface NewsView extends BaseView {
    void setList(NBANewsEntity nbaNewsEntity, boolean isRefresh);
}
