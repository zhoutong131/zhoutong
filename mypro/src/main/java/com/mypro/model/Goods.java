package com.mypro.model;

import java.util.Date;

public class Goods {
    private Integer id;

    private String goods_name;

    private String goods_desc;

    private Long goods_price;

    private String goods_img;

    private Integer stock;

    private Byte status;

    private Date create_time;

    private Date update_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name == null ? null : goods_name.trim();
    }

    public String getGoods_desc() {
        return goods_desc;
    }

    public void setGoods_desc(String goods_desc) {
        this.goods_desc = goods_desc == null ? null : goods_desc.trim();
    }

    public Long getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Long goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img == null ? null : goods_img.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}