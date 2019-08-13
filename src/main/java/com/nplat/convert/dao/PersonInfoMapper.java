package com.nplat.convert.dao;

import com.nplat.convert.entity.PersonInfo;
import com.nplat.convert.provider.PersonInfoProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;
import java.util.HashMap;


@Mapper
@Repository
public interface PersonInfoMapper {


    @InsertProvider(type = PersonInfoProvider.class ,method = "insert")
    @Options(useGeneratedKeys = true,keyProperty ="id",keyColumn = "id")
    void createInfo(PersonInfo personInfo);

    @UpdateProvider(type = PersonInfoProvider.class ,method = "updateBy")
    void updateInfoBy(HashMap hashMap);

    @SelectProvider(type = PersonInfoProvider.class ,method = "getPersonInfoByDynamic")
    PersonInfo getPersonInfoBy(HashMap hashMap);

}