package com.nplat.convert.service;

import com.nplat.convert.dao.BannersMapper;
import com.nplat.convert.entity.Banners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    private BannersMapper bannersMapper;

    public List<Banners> banners(){
        List<Banners> bannersList = bannersMapper.selectBanners();
        return bannersList;
    }

}
