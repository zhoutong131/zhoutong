package com.mypro.Service;

import com.mypro.model.Goods;

public interface GoodsService {
    String getGoodsList(Integer pageNo,Integer pageSize);

    String addGood(Goods good);
}
