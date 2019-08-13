package com.nplat.convert.provider;

import com.nplat.convert.entity.EnterpriseGoods;
import org.apache.ibatis.jdbc.SQL;

public class EnterpriseGoodsProvider {

    public String insert(final EnterpriseGoods enterpriseGoods) {
        SQL sql = new SQL();
        sql.INSERT_INTO("enterprise_goods");
        if (enterpriseGoods.getPersonId()!= null) {
            sql.VALUES("person_id", "'" + enterpriseGoods.getPersonId() + "'");
        }
        if (enterpriseGoods.getbName()!= null) {
            sql.VALUES("b_name", "'" + enterpriseGoods.getbName() + "'");
        }
        if (enterpriseGoods.getbDesc()!= null) {
            sql.VALUES("b_desc", "'" + enterpriseGoods.getbDesc() + "'");
        }
        if (enterpriseGoods.getbRealPrise()!= null) {
            sql.VALUES("b_real_prise", "'" + enterpriseGoods.getbRealPrise() + "'");
        }
        if (enterpriseGoods.getbPrice()!= null) {
            sql.VALUES("b_price", "'" + enterpriseGoods.getbPrice() + "'");
        }
        if (enterpriseGoods.getLatitude()!= null) {
            sql.VALUES("latitude", "'" + enterpriseGoods.getLatitude() + "'");
        }
        if (enterpriseGoods.getLongitude()!= null) {
            sql.VALUES("longitude", "'" + enterpriseGoods.getLongitude() + "'");
        }
        if (enterpriseGoods.getStatus()!= null) {
            sql.VALUES("status", "'" + enterpriseGoods.getStatus() + "'");
        }
        sql.VALUES("create_date", " now()");
        return sql.toString();
    }


}
