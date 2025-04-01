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


import com.dao.JiechexinxiDao;
import com.entity.JiechexinxiEntity;
import com.service.JiechexinxiService;
import com.entity.vo.JiechexinxiVO;
import com.entity.view.JiechexinxiView;

@Service("jiechexinxiService")
public class JiechexinxiServiceImpl extends ServiceImpl<JiechexinxiDao, JiechexinxiEntity> implements JiechexinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiechexinxiEntity> page = this.selectPage(
                new Query<JiechexinxiEntity>(params).getPage(),
                new EntityWrapper<JiechexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiechexinxiEntity> wrapper) {
		  Page<JiechexinxiView> page =new Query<JiechexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiechexinxiVO> selectListVO(Wrapper<JiechexinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiechexinxiVO selectVO(Wrapper<JiechexinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiechexinxiView> selectListView(Wrapper<JiechexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiechexinxiView selectView(Wrapper<JiechexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
