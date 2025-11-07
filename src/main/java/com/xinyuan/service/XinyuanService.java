package com.xinyuan.service;

import com.xinyuan.pojo.Xinyuan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface XinyuanService {
    public List<Xinyuan> getItems();
}
