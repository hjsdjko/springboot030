package com.entity.vo;

import com.entity.MianshiyaoyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 面试邀约
 * @author 
 * @email 
 * @date 2024-04-21 21:30:21
 */
public class MianshiyaoyueVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 职位类型
	 */
	
	private String zhiweileixing;
		
	/**
	 * 职位图片
	 */
	
	private String zhiweitupian;
		
	/**
	 * 面试时间
	 */
	
	private String mianshishijian;
		
	/**
	 * 面试地点
	 */
	
	private String mianshididian;
		
	/**
	 * 面试准备
	 */
	
	private String mianshizhunbei;
		
	/**
	 * 学号
	 */
	
	private String xuehao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 企业名称
	 */
	
	private String qiyemingcheng;
		
	/**
	 * 回复内容
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：职位类型
	 */
	 
	public void setZhiweileixing(String zhiweileixing) {
		this.zhiweileixing = zhiweileixing;
	}
	
	/**
	 * 获取：职位类型
	 */
	public String getZhiweileixing() {
		return zhiweileixing;
	}
				
	
	/**
	 * 设置：职位图片
	 */
	 
	public void setZhiweitupian(String zhiweitupian) {
		this.zhiweitupian = zhiweitupian;
	}
	
	/**
	 * 获取：职位图片
	 */
	public String getZhiweitupian() {
		return zhiweitupian;
	}
				
	
	/**
	 * 设置：面试时间
	 */
	 
	public void setMianshishijian(String mianshishijian) {
		this.mianshishijian = mianshishijian;
	}
	
	/**
	 * 获取：面试时间
	 */
	public String getMianshishijian() {
		return mianshishijian;
	}
				
	
	/**
	 * 设置：面试地点
	 */
	 
	public void setMianshididian(String mianshididian) {
		this.mianshididian = mianshididian;
	}
	
	/**
	 * 获取：面试地点
	 */
	public String getMianshididian() {
		return mianshididian;
	}
				
	
	/**
	 * 设置：面试准备
	 */
	 
	public void setMianshizhunbei(String mianshizhunbei) {
		this.mianshizhunbei = mianshizhunbei;
	}
	
	/**
	 * 获取：面试准备
	 */
	public String getMianshizhunbei() {
		return mianshizhunbei;
	}
				
	
	/**
	 * 设置：学号
	 */
	 
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：企业名称
	 */
	 
	public void setQiyemingcheng(String qiyemingcheng) {
		this.qiyemingcheng = qiyemingcheng;
	}
	
	/**
	 * 获取：企业名称
	 */
	public String getQiyemingcheng() {
		return qiyemingcheng;
	}
				
	
	/**
	 * 设置：回复内容
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}
			
}
