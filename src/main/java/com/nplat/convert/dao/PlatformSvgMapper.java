package com.nplat.convert.dao;

import com.nplat.convert.entity.PlatformSvg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface PlatformSvgMapper {

    @Select("select id,s_count,description from platform_svg where id = #{id}")
    PlatformSvg selectById(Integer id);

}