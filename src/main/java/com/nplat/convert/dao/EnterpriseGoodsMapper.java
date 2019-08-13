package com.nplat.convert.dao;

import com.nplat.convert.basePackage.response.GoodsResponse;
import com.nplat.convert.entity.EnterpriseGoods;
import com.nplat.convert.provider.EnterpriseGoodsProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnterpriseGoodsMapper {

    @InsertProvider(type = EnterpriseGoodsProvider.class ,method = "insert")
    @Options(useGeneratedKeys = true,keyProperty ="id",keyColumn = "id")
    int insert(EnterpriseGoods record);


    @Select("select id,person_id,b_name,b_desc,b_real_prise ,b_price  ,create_date  from enterprise_goods where person_id = #{personId} and status = 0")
    List<GoodsResponse> selectByPersonId(String personId);



}