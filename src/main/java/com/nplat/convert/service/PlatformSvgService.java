package com.nplat.convert.service;

import com.nplat.convert.dao.PlatformSvgMapper;
import com.nplat.convert.entity.PlatformSvg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatformSvgService {
    @Autowired
    private PlatformSvgMapper platformSvgMapper;

    public PlatformSvg selectPlatformSvg(Integer id){
        return platformSvgMapper.selectById(id);
    }

}
