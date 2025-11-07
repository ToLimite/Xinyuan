package com.xinyuan.service;

import com.xinyuan.pojo.Xinyuan;
import org.springframework.stereotype.Service;

import java.util.List;


public interface XinyuanService {
    List<Xinyuan> getItems(Long state);

    void starupXinyuan(Long userId, Long itemId);
}
