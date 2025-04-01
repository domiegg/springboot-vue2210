package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiechexinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiechexinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiechexinxiView;


/**
 * 借车信息
 *
 * @author 
 * @email 
 * @date 2021-01-20 17:21:57
 */
public interface JiechexinxiService extends IService<JiechexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiechexinxiVO> selectListVO(Wrapper<JiechexinxiEntity> wrapper);
   	
   	JiechexinxiVO selectVO(@Param("ew") Wrapper<JiechexinxiEntity> wrapper);
   	
   	List<JiechexinxiView> selectListView(Wrapper<JiechexinxiEntity> wrapper);
   	
   	JiechexinxiView selectView(@Param("ew") Wrapper<JiechexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiechexinxiEntity> wrapper);
   	
}

