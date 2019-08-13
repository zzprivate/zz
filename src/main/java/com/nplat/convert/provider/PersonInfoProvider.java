package com.nplat.convert.provider;

import com.nplat.convert.entity.PersonInfo;
import org.apache.ibatis.jdbc.SQL;

import java.util.HashMap;

public class PersonInfoProvider {

    final static String tableName = "person_info";
    final static String columns = "id,person_id,u_level,nick_name,avata_url,gender,country,province,city,personal_qr_code,my_fans,u_phone_number,create_date";

    public String insert(final PersonInfo personInfo) {
        SQL sql = new SQL();
        sql.INSERT_INTO(tableName);
        if (personInfo.getOpenId() != null) {
            sql.VALUES("person_id", "'" + personInfo.getOpenId() + "'");
        }
        if (personInfo.getuLevel() != null) {
            sql.VALUES("u_level", String.valueOf(personInfo.getuLevel()));
        }
        if (personInfo.getNickName() != null) {
            sql.VALUES("nick_name", personInfo.getNickName());
        }
        if (personInfo.getAvataUrl() != null) {
            sql.VALUES("avata_url", personInfo.getAvataUrl());
        }
        if (personInfo.getGender() != null) {
            sql.VALUES("gender", String.valueOf(personInfo.getGender()));
        }
        if (personInfo.getCountry() != null) {
            sql.VALUES("country", personInfo.getCountry());
        }
        if (personInfo.getProvince() != null) {
            sql.VALUES("province", personInfo.getProvince());
        }
        if (personInfo.getCity() != null) {
            sql.VALUES("city", personInfo.getCity());
        }
        if (personInfo.getMyFans() != null) {
            sql.VALUES("my_fans", String.valueOf(personInfo.getMyFans()));
        }
        if (personInfo.getuPhoneNumber() != null) {
            sql.VALUES("u_phone_number", personInfo.getuPhoneNumber());
        }
        sql.VALUES("create_date", " now()");
        return sql.toString();
    }

    public String updateBy(final HashMap hashMap) {
        return new SQL() {{
            UPDATE(tableName);
            //条件写法.
            if (hashMap.get("uLevel") != null) {
                SET("u_level=#{uLevel}");
            }
            if (hashMap.get("nickName") != null) {
                SET("nick_name=#{nickName}");
            }
            if (hashMap.get("avataUrl") != null) {
                SET("avata_url=#{avataUrl}");
            }
            if (hashMap.get("gender") != null){
                SET("gender=#{gender}");
            }
            if (hashMap.get("country") != null) {
                SET("country=#{country}");
            }
            if (hashMap.get("province") != null) {
                SET("province=#{province}");
            }
            if (hashMap.get("city") != null) {
                SET("city=#{city}");
            }
            if (hashMap.get("personalQrCode") != null) {
                SET("personal_qr_code=#{personalQrCode}");
            }
            if (hashMap.get("myFans") != null) {
                SET("my_fans=#{myFans}");
            }
            if (hashMap.get("uPhone_Number") != null) {
                SET("u_phone_number=#{status}");
            }
            if(null != hashMap.get("personId") ) {
                WHERE("person_id=#{personId}");
            }
            if(null != hashMap.get("id") ) {
                WHERE("id=#{id}");
            }
        }}.toString();
    }

    public String getPersonInfoByDynamic(final  HashMap hashMap) {
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

}
