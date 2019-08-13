package com.nplat.convert.provider;

import com.nplat.convert.entity.EnterpriseInfo;
import org.apache.ibatis.jdbc.SQL;

import java.util.HashMap;

public class EnterpriseInfoProvider {
    final static String tableName = "enterprise_info";
    final static String columns = "id,reference_id,person_id,s_type,s_name,s_phone,s_image,open_time,wx_number,s_description,s_address,latitude,longitude,status,create_date";

    public String insert(final EnterpriseInfo enterpriseInfo) {
        SQL sql = new SQL();
        sql.INSERT_INTO(tableName);
        if (enterpriseInfo.getPersonId() != null) {
            sql.VALUES("person_id", "'" + enterpriseInfo.getPersonId() + "'");
        }
        if (enterpriseInfo.getReferenceId() != null) {
            sql.VALUES("reference_id", "'" + enterpriseInfo.getReferenceId() + "'");
        }
        if (enterpriseInfo.getsType() != null) {
            sql.VALUES("s_type","'"+ String.valueOf(enterpriseInfo.getsType())+"'");
        }
        if (enterpriseInfo.getsName() != null) {
            sql.VALUES("s_name", "'" + enterpriseInfo.getsName() + "'");
        }
        if (enterpriseInfo.getsPhone() != null) {
            sql.VALUES("s_phone", "'" + enterpriseInfo.getsPhone() + "'");
        }
        if (enterpriseInfo.getsImage() != null) {
            sql.VALUES("s_image", "'" + enterpriseInfo.getsImage() + "'");
        }
        if (enterpriseInfo.getOpenTime() != null) {
            sql.VALUES("open_time", "'" + enterpriseInfo.getOpenTime() + "'");
        }
        if (enterpriseInfo.getWxNumber() != null) {
            sql.VALUES("wx_number", "'" + enterpriseInfo.getWxNumber() + "'");
        }
        if (enterpriseInfo.getsDescription() != null) {
            sql.VALUES("s_description", "'" + enterpriseInfo.getsDescription() + "'");
        }
        if (enterpriseInfo.getsAddress() != null) {
            sql.VALUES("s_address", "'" + enterpriseInfo.getsAddress() + "'");
        }
        if (enterpriseInfo.getLatitude() != null) {
            sql.VALUES("latitude", "'" + enterpriseInfo.getLatitude() + "'");
        }
        if (enterpriseInfo.getLongitude() != null) {
            sql.VALUES("longitude", "'" + enterpriseInfo.getLongitude() + "'");
        }
        if (enterpriseInfo.getStatus() != null) {
            sql.VALUES("status", "'"+String.valueOf(enterpriseInfo.getStatus())+"'");
        }
        sql.VALUES("create_date", " now()");
        return sql.toString();
    }

    public String getPersonInfoByDynamic(final HashMap hashMap) {
        return  new SQL(){{
            SELECT(columns);
            FROM(tableName);
            if(null != hashMap.get("id")) {
                WHERE("id = #{id}");
            }
            if(null != hashMap.get("personId")) {
                WHERE("person_id = #{personId}");
            }
        }}.toString();
    }


    public String updateById(final HashMap hashMap) {
        return new SQL() {{
            UPDATE(tableName);
            //条件写法.
            if (hashMap.get("referenceId") != null) {
                SET("reference_id=#{referenceId}");
            }
            if (hashMap.get("personId") != null) {
                SET("person_id=#{personId}");
            }
            if (hashMap.get("sType") != null) {
                SET("s_type=#{sType}");
            }
            if (hashMap.get("sName") != null) {
                SET("s_name=#{sName}");
            }
            if (hashMap.get("sPhone") != null){
                SET("s_phone=#{sPhone}");
            }
            if (hashMap.get("sImage") != null) {
                SET("s_image=#{sImage}");
            }
            if (hashMap.get("openTime") != null) {
                SET("open_time=#{openTime}");
            }
            if (hashMap.get("wxNumber") != null) {
                SET("wx_number=#{wxNumber}");
            }
            if (hashMap.get("sDescription") != null) {
                SET("s_description=#{sDescription}");
            }
            if (hashMap.get("sAddress") != null) {
                SET("s_address=#{sAddress}");
            }
            if (hashMap.get("latitude") != null) {
                SET("latitude=#{latitude}");
            }
            if (hashMap.get("longitude") != null) {
                SET("longitude=#{longitude}");
            }
            if (hashMap.get("status") != null) {
                SET("status=#{status}");
            }
            WHERE("id=#{id}");
        }}.toString();
    }

    public String getInfoPageAndSize(final HashMap hashMap) {
        Object currentPosition = hashMap.get("currentPosition");
        Object size =hashMap.get("size");
        SQL sql =  new SQL(){{
            SELECT("id ,s_name ,s_image ,round((6371 * acos (cos ( radians(#{latitude}) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(#{longitude}) )+ sin ( radians(#{latitude}) ) * sin( radians( latitude ) ) )),3) AS distance");
            FROM(tableName);
            WHERE("status = 0");
            ORDER_BY("distance asc");
        }};
        StringBuilder builder = new StringBuilder(sql.toString());
        builder.append(" limit ");
        builder.append(currentPosition);
        builder.append(",");
        builder.append(size);
        return builder.toString();
    }

}
