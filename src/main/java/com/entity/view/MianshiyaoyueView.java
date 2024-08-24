package com.entity.view;

import com.entity.MianshiyaoyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 面试邀约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-21 21:30:21
 */
@TableName("mianshiyaoyue")
public class MianshiyaoyueView  extends MianshiyaoyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MianshiyaoyueView(){
	}
 
 	public MianshiyaoyueView(MianshiyaoyueEntity mianshiyaoyueEntity){
 	try {
			BeanUtils.copyProperties(this, mianshiyaoyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
