package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZujiedianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZujiedianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZujiedianView;


/**
 * 租借点
 *
 * @author 
 * @email 
 * @date 2021-01-20 17:21:57
 */
public interface ZujiedianService extends IService<ZujiedianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZujiedianVO> selectListVO(Wrapper<ZujiedianEntity> wrapper);
   	
   	ZujiedianVO selectVO(@Param("ew") Wrapper<ZujiedianEntity> wrapper);
   	
   	List<ZujiedianView> selectListView(Wrapper<ZujiedianEntity> wrapper);
   	
   	ZujiedianView selectView(@Param("ew") Wrapper<ZujiedianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZujiedianEntity> wrapper);
   	
}

