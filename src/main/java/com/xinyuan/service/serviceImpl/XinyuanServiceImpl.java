package com.xinyuan.service.serviceImpl;

import com.xinyuan.mapper.XinyuanMapper;
import com.xinyuan.pojo.Xinyuan;
import com.xinyuan.service.XinyuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XinyuanServiceImpl implements XinyuanService {

    @Autowired
    private XinyuanMapper xinyuanMapper;

    @Override
    public List<Xinyuan> getItems(Long state) {
        List<Xinyuan> xyItems = xinyuanMapper.getXyItems(state);
        return xyItems;
    }
}
