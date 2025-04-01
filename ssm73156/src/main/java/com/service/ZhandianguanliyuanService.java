package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhandianguanliyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhandianguanliyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhandianguanliyuanView;


/**
 * 站点管理员
 *
 * @author 
 * @email 
 * @date 2021-01-20 17:21:57
 */
public interface ZhandianguanliyuanService extends IService<ZhandianguanliyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhandianguanliyuanVO> selectListVO(Wrapper<ZhandianguanliyuanEntity> wrapper);
   	
   	ZhandianguanliyuanVO selectVO(@Param("ew") Wrapper<ZhandianguanliyuanEntity> wrapper);
   	
   	List<ZhandianguanliyuanView> selectListView(Wrapper<ZhandianguanliyuanEntity> wrapper);
   	
   	ZhandianguanliyuanView selectView(@Param("ew") Wrapper<ZhandianguanliyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhandianguanliyuanEntity> wrapper);
   	
}

