package com.entity.view;

import com.entity.JiechexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 借车信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-20 17:21:57
 */
@TableName("jiechexinxi")
public class JiechexinxiView  extends JiechexinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiechexinxiView(){
	}
 
 	public JiechexinxiView(JiechexinxiEntity jiechexinxiEntity){
 	try {
			BeanUtils.copyProperties(this, jiechexinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
