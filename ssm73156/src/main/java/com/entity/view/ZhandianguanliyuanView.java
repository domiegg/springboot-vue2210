package com.entity.view;

import com.entity.ZhandianguanliyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 站点管理员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-20 17:21:57
 */
@TableName("zhandianguanliyuan")
public class ZhandianguanliyuanView  extends ZhandianguanliyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhandianguanliyuanView(){
	}
 
 	public ZhandianguanliyuanView(ZhandianguanliyuanEntity zhandianguanliyuanEntity){
 	try {
			BeanUtils.copyProperties(this, zhandianguanliyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
