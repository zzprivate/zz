package com.nplat.convert.dao;

import com.nplat.convert.entity.EnterpriseType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnterpriseTypeMapper {

    @Select("select id,t_name from enterprise_type")
    List<EnterpriseType> getEnterpriseType();

    @Insert("insert into enterprise_type(t_name)  values(#{name})")
    @Options(useGeneratedKeys = true,keyProperty ="id",keyColumn = "id")
    void createInfo(String name);

}