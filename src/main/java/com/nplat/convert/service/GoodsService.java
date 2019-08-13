package com.nplat.convert.service;

import com.nplat.convert.basePackage.response.GoodsResponse;
import com.nplat.convert.dao.EnterpriseGoodsMapper;
import com.nplat.convert.dao.GoodsImagesMapper;
import com.nplat.convert.entity.EnterpriseGoods;
import com.nplat.convert.entity.GoodsImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private EnterpriseGoodsMapper enterpriseGoodsMapper;
    @Autowired
    private GoodsImagesMapper goodsImagesMapper;

    @Transactional
    public Long createGoods(String personId,String bName,String bDesc,
                            BigDecimal bRealPrise,BigDecimal bPrice,
                            BigDecimal latitude,BigDecimal longitude, List<String> goodImages) {
        EnterpriseGoods enterpriseGoods = new EnterpriseGoods();
        enterpriseGoods.setPersonId(personId);
        enterpriseGoods.setbName(bName);
        enterpriseGoods.setbDesc(bDesc);
        enterpriseGoods.setbRealPrise(bRealPrise);
        enterpriseGoods.setbPrice(bPrice);
        enterpriseGoods.setLatitude(latitude);
        enterpriseGoods.setLongitude(longitude);
        enterpriseGoods.setStatus(0);
        enterpriseGoodsMapper.insert(enterpriseGoods);
        for(String imgUrl : goodImages) {
            GoodsImages goodsImage = new GoodsImages();
            goodsImage.setGoodId(enterpriseGoods.getId());
            goodsImage.setGoodUrl(imgUrl);
            goodsImagesMapper.insert(goodsImage);
        }
        return enterpriseGoods.getId();
    }


    public List<GoodsResponse>  searchByPersonId(String personId){
        List<GoodsResponse>  enterpriseGoods =  enterpriseGoodsMapper.selectByPersonId(personId);
        for(GoodsResponse response : enterpriseGoods) {
            List<HashMap> imgUrls = goodsImagesMapper.selectUrlByGoodId(response.getId());
            response.setCreateDate(response.getCreateDate().substring(0,19));
            response.setImages(imgUrls);
        }
        return enterpriseGoods;
    }

}
