package com.nplat.convert.dao;

import com.nplat.convert.entity.GoodsImages;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface GoodsImagesMapper {

    @Insert("insert into goods_images (good_url, good_id) values(#{goodUrl},#{goodId})")
    void insert(GoodsImages record);

    @Select("select good_url from goods_images where good_id = #{goodId}")
    List<HashMap> selectUrlByGoodId(Long goodId);

}