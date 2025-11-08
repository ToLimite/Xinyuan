package com.xinyuan.service.serviceImpl;

import com.xinyuan.exception.BusinessException;
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

    @Override
    public void starupXinyuan(Long userId, Long itemId) {
        Xinyuan item = xinyuanMapper.getById(itemId);
        if(item == null){
            throw new BusinessException("心愿不存在！");
        }else if(item.getState() == 1){
            throw new BusinessException("心愿已被点亮！");
        }else{
            xinyuanMapper.starupXinyuan(userId, itemId);
        }
    }

    @Override
    public List<Xinyuan> getItemsByStarUser(Long userId) {
        List<Xinyuan> xyItemsByStarUser = xinyuanMapper.getXyItemsByStarUser(userId);
        return xyItemsByStarUser;
    }


}
