package com.e3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.mapper.TbItemMapper;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.TbItemExample;
import com.e3mall.service.ItemService;
import com.e3mall.utils.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;

	//根据ID查询商品
	public TbItem getItemById(Long id) {
		return itemMapper.selectByPrimaryKey(id);
	}

	//分页查询商品的数量
	public PageResult findItemByPage(Integer page, Integer rows) {
		TbItemExample example = new TbItemExample();
		
		//设置分页的参数
		PageHelper.startPage(page, rows);
		
		
		List<TbItem> list = itemMapper.selectByExample(example);
		//创建pageinfo 获取page对象中的属性
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		long total = pageInfo.getTotal();
		
		PageResult result = new PageResult();
		result.setRows(list);
		result.setTotal(total);
		
		return result;
	}
}
