package com.nplat.convert.dao;

import com.nplat.convert.entity.EnterpriseInfo;
import com.nplat.convert.provider.EnterpriseInfoProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface EnterpriseInfoMapper {



    @InsertProvider(type = EnterpriseInfoProvider.class ,method = "insert")
    @Options(useGeneratedKeys = true,keyProperty ="id",keyColumn = "id")
    int createInfo(EnterpriseInfo record);

    @UpdateProvider(type = EnterpriseInfoProvider.class ,method = "updateById")
    void updateInfoById(HashMap hashMap);

    @SelectProvider(type = EnterpriseInfoProvider.class ,method = "getPersonInfoByDynamic")
    EnterpriseInfo getEnterpriseInfoBy(HashMap hashMap);

    @Select("select id,person_id,s_name,s_image,create_date from enterprise_info where reference_id = #{personId}")
    HashMap selectAskEnterprises(String personId);

    @SelectProvider(type = EnterpriseInfoProvider.class ,method = "getInfoPageAndSize")
    List<HashMap> searchEnterpriseInfoPageSize(HashMap hashMap);

}