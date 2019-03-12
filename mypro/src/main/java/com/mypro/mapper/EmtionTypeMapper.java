package com.mypro.mapper;

import com.mypro.model.EmtionType;

import java.util.List;

public interface EmtionTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmtionType record);

    int insertSelective(EmtionType record);

    EmtionType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmtionType record);

    int updateByPrimaryKey(EmtionType record);

    List<EmtionType> getListByPage();
}