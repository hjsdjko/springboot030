package com.entity.model;

import com.entity.JianlimobanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 简历模板
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-21 21:30:22
 */
public class JianlimobanModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 模板类型
	 */
	
	private String mobanleixing;
		
	/**
	 * 模板附件
	 */
	
	private String mobanfujian;
		
	/**
	 * 模板介绍
	 */
	
	private String mobanjieshao;
		
	/**
	 * 模板封面
	 */
	
	private String mobanfengmian;
				
	
	/**
	 * 设置：模板类型
	 */
	 
	public void setMobanleixing(String mobanleixing) {
		this.mobanleixing = mobanleixing;
	}
	
	/**
	 * 获取：模板类型
	 */
	public String getMobanleixing() {
		return mobanleixing;
	}
				
	
	/**
	 * 设置：模板附件
	 */
	 
	public void setMobanfujian(String mobanfujian) {
		this.mobanfujian = mobanfujian;
	}
	
	/**
	 * 获取：模板附件
	 */
	public String getMobanfujian() {
		return mobanfujian;
	}
				
	
	/**
	 * 设置：模板介绍
	 */
	 
	public void setMobanjieshao(String mobanjieshao) {
		this.mobanjieshao = mobanjieshao;
	}
	
	/**
	 * 获取：模板介绍
	 */
	public String getMobanjieshao() {
		return mobanjieshao;
	}
				
	
	/**
	 * 设置：模板封面
	 */
	 
	public void setMobanfengmian(String mobanfengmian) {
		this.mobanfengmian = mobanfengmian;
	}
	
	/**
	 * 获取：模板封面
	 */
	public String getMobanfengmian() {
		return mobanfengmian;
	}
			
}
