package com.e3mall.service;

import java.util.List;

import com.e3mall.pojo.TbItem;
import com.e3mall.utils.PageResult;



public interface ItemService {

	//根据商品ID查询商品
	public TbItem getItemById(Long id);
	
	//分页查询商品的数量
	public PageResult findItemByPage(Integer page,Integer rows);
}
