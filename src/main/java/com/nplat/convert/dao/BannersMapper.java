package com.nplat.convert.dao;

import com.nplat.convert.entity.Banners;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BannersMapper {

    @Select("select id,enterprise_id,pic_url,status,create_date from banners where status = 0")
    List<Banners> selectBanners();

}