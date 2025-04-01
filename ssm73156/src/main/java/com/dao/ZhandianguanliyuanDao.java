package com.dao;

import com.entity.ZhandianguanliyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhandianguanliyuanVO;
import com.entity.view.ZhandianguanliyuanView;


/**
 * 站点管理员
 * 
 * @author 
 * @email 
 * @date 2021-01-20 17:21:57
 */
public interface ZhandianguanliyuanDao extends BaseMapper<ZhandianguanliyuanEntity> {
	
	List<ZhandianguanliyuanVO> selectListVO(@Param("ew") Wrapper<ZhandianguanliyuanEntity> wrapper);
	
	ZhandianguanliyuanVO selectVO(@Param("ew") Wrapper<ZhandianguanliyuanEntity> wrapper);
	
	List<ZhandianguanliyuanView> selectListView(@Param("ew") Wrapper<ZhandianguanliyuanEntity> wrapper);

	List<ZhandianguanliyuanView> selectListView(Pagination page,@Param("ew") Wrapper<ZhandianguanliyuanEntity> wrapper);
	
	ZhandianguanliyuanView selectView(@Param("ew") Wrapper<ZhandianguanliyuanEntity> wrapper);
	
}
