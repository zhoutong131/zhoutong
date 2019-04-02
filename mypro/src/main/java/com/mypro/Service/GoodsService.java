package com.mypro.Service;

import com.mypro.model.Goods;

import java.util.Map;

public interface GoodsService {
    String getGoodsList(Map data);

    String addGood(Goods good);
}
