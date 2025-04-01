package com.dao;

import com.entity.JiechexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiechexinxiVO;
import com.entity.view.JiechexinxiView;


/**
 * 借车信息
 * 
 * @author 
 * @email 
 * @date 2021-01-20 17:21:57
 */
public interface JiechexinxiDao extends BaseMapper<JiechexinxiEntity> {
	
	List<JiechexinxiVO> selectListVO(@Param("ew") Wrapper<JiechexinxiEntity> wrapper);
	
	JiechexinxiVO selectVO(@Param("ew") Wrapper<JiechexinxiEntity> wrapper);
	
	List<JiechexinxiView> selectListView(@Param("ew") Wrapper<JiechexinxiEntity> wrapper);

	List<JiechexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiechexinxiEntity> wrapper);
	
	JiechexinxiView selectView(@Param("ew") Wrapper<JiechexinxiEntity> wrapper);
	
}
