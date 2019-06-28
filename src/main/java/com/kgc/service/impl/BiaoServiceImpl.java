package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.Biao;
import com.kgc.entity.BiaoExample;
import com.kgc.mapper.BiaoMapper;
import com.kgc.service.BiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping
public class BiaoServiceImpl implements BiaoService {

    @Autowired
    private BiaoMapper biaoMapper;


    public PageInfo<Biao> selectByExample(int page, int pageSize){
        PageHelper.startPage(page,pageSize);
        BiaoExample biaoExample = new BiaoExample();
        PageInfo pageInfo = new  PageInfo(biaoMapper.selectByExample(biaoExample)) ;
        return pageInfo;
    }

    @Override
    public int deleteAjax(int id) {
        return biaoMapper.deleteByPrimaryKey(id);
    }
}
