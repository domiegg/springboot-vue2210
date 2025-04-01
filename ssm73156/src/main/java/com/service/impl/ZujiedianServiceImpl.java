package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZujiedianDao;
import com.entity.ZujiedianEntity;
import com.service.ZujiedianService;
import com.entity.vo.ZujiedianVO;
import com.entity.view.ZujiedianView;

@Service("zujiedianService")
public class ZujiedianServiceImpl extends ServiceImpl<ZujiedianDao, ZujiedianEntity> implements ZujiedianService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZujiedianEntity> page = this.selectPage(
                new Query<ZujiedianEntity>(params).getPage(),
                new EntityWrapper<ZujiedianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZujiedianEntity> wrapper) {
		  Page<ZujiedianView> page =new Query<ZujiedianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZujiedianVO> selectListVO(Wrapper<ZujiedianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZujiedianVO selectVO(Wrapper<ZujiedianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZujiedianView> selectListView(Wrapper<ZujiedianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZujiedianView selectView(Wrapper<ZujiedianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
