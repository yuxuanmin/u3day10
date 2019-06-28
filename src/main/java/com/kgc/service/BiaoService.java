package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Biao;

public interface BiaoService {
    public PageInfo<Biao> selectByExample(int page, int pageSize);
    public int deleteAjax(int id);
}
