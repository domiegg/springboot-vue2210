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


import com.dao.ZhandianguanliyuanDao;
import com.entity.ZhandianguanliyuanEntity;
import com.service.ZhandianguanliyuanService;
import com.entity.vo.ZhandianguanliyuanVO;
import com.entity.view.ZhandianguanliyuanView;

@Service("zhandianguanliyuanService")
public class ZhandianguanliyuanServiceImpl extends ServiceImpl<ZhandianguanliyuanDao, ZhandianguanliyuanEntity> implements ZhandianguanliyuanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhandianguanliyuanEntity> page = this.selectPage(
                new Query<ZhandianguanliyuanEntity>(params).getPage(),
                new EntityWrapper<ZhandianguanliyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhandianguanliyuanEntity> wrapper) {
		  Page<ZhandianguanliyuanView> page =new Query<ZhandianguanliyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhandianguanliyuanVO> selectListVO(Wrapper<ZhandianguanliyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhandianguanliyuanVO selectVO(Wrapper<ZhandianguanliyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhandianguanliyuanView> selectListView(Wrapper<ZhandianguanliyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhandianguanliyuanView selectView(Wrapper<ZhandianguanliyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
