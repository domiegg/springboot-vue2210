package com.entity.view;

import com.entity.ZujiedianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 租借点
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-20 17:21:57
 */
@TableName("zujiedian")
public class ZujiedianView  extends ZujiedianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZujiedianView(){
	}
 
 	public ZujiedianView(ZujiedianEntity zujiedianEntity){
 	try {
			BeanUtils.copyProperties(this, zujiedianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
