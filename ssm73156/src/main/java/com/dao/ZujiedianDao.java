package com.dao;

import com.entity.ZujiedianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZujiedianVO;
import com.entity.view.ZujiedianView;


/**
 * 租借点
 * 
 * @author 
 * @email 
 * @date 2021-01-20 17:21:57
 */
public interface ZujiedianDao extends BaseMapper<ZujiedianEntity> {
	
	List<ZujiedianVO> selectListVO(@Param("ew") Wrapper<ZujiedianEntity> wrapper);
	
	ZujiedianVO selectVO(@Param("ew") Wrapper<ZujiedianEntity> wrapper);
	
	List<ZujiedianView> selectListView(@Param("ew") Wrapper<ZujiedianEntity> wrapper);

	List<ZujiedianView> selectListView(Pagination page,@Param("ew") Wrapper<ZujiedianEntity> wrapper);
	
	ZujiedianView selectView(@Param("ew") Wrapper<ZujiedianEntity> wrapper);
	
}
