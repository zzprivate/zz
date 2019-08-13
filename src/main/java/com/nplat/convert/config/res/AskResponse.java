package com.nplat.convert.config.res;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by roy on 2019/6/20.
 */
@Getter
@Setter
public class AskResponse {
    Long id;
    Integer personId;
    String nickName;
    String avataUrl;
    Integer enterpriseId;
    Integer status;
    String createDate;
}
