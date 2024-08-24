package com.entity.view;

import com.entity.ZhiweixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 职位信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-21 21:30:21
 */
@TableName("zhiweixinxi")
public class ZhiweixinxiView  extends ZhiweixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhiweixinxiView(){
	}
 
 	public ZhiweixinxiView(ZhiweixinxiEntity zhiweixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, zhiweixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
