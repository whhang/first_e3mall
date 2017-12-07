package com.e3mall.service;

import com.e3mall.pojo.TbItem;


public interface ItemService {

	//根据商品ID查询商品
	public TbItem getItemById(Long id);
}
