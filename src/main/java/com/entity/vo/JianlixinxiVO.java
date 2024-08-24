package com.entity.vo;

import com.entity.JianlixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 简历信息
 * @author 
 * @email 
 * @date 2024-04-21 21:30:21
 */
public class JianlixinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 年龄
	 */
	
	private Integer nianling;
		
	/**
	 * 院系
	 */
	
	private String yuanxi;
		
	/**
	 * 专业
	 */
	
	private String zhuanye;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 求职意向
	 */
	
	private String qiuzhiyixiang;
		
	/**
	 * 求职城市
	 */
	
	private String qiuzhichengshi;
		
	/**
	 * 工作经历
	 */
	
	private String gongzuojingli;
		
	/**
	 * 专业技能
	 */
	
	private String zhuanyejineng;
		
	/**
	 * 荣誉奖项
	 */
	
	private String rongyujiangxiang;
		
	/**
	 * 自我评价
	 */
	
	private String ziwopingjia;
				
	
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
	 * 设置：年龄
	 */
	 
	public void setNianling(Integer nianling) {
		this.nianling = nianling;
	}
	
	/**
	 * 获取：年龄
	 */
	public Integer getNianling() {
		return nianling;
	}
				
	
	/**
	 * 设置：院系
	 */
	 
	public void setYuanxi(String yuanxi) {
		this.yuanxi = yuanxi;
	}
	
	/**
	 * 获取：院系
	 */
	public String getYuanxi() {
		return yuanxi;
	}
				
	
	/**
	 * 设置：专业
	 */
	 
	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}
	
	/**
	 * 获取：专业
	 */
	public String getZhuanye() {
		return zhuanye;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
				
	
	/**
	 * 设置：求职意向
	 */
	 
	public void setQiuzhiyixiang(String qiuzhiyixiang) {
		this.qiuzhiyixiang = qiuzhiyixiang;
	}
	
	/**
	 * 获取：求职意向
	 */
	public String getQiuzhiyixiang() {
		return qiuzhiyixiang;
	}
				
	
	/**
	 * 设置：求职城市
	 */
	 
	public void setQiuzhichengshi(String qiuzhichengshi) {
		this.qiuzhichengshi = qiuzhichengshi;
	}
	
	/**
	 * 获取：求职城市
	 */
	public String getQiuzhichengshi() {
		return qiuzhichengshi;
	}
				
	
	/**
	 * 设置：工作经历
	 */
	 
	public void setGongzuojingli(String gongzuojingli) {
		this.gongzuojingli = gongzuojingli;
	}
	
	/**
	 * 获取：工作经历
	 */
	public String getGongzuojingli() {
		return gongzuojingli;
	}
				
	
	/**
	 * 设置：专业技能
	 */
	 
	public void setZhuanyejineng(String zhuanyejineng) {
		this.zhuanyejineng = zhuanyejineng;
	}
	
	/**
	 * 获取：专业技能
	 */
	public String getZhuanyejineng() {
		return zhuanyejineng;
	}
				
	
	/**
	 * 设置：荣誉奖项
	 */
	 
	public void setRongyujiangxiang(String rongyujiangxiang) {
		this.rongyujiangxiang = rongyujiangxiang;
	}
	
	/**
	 * 获取：荣誉奖项
	 */
	public String getRongyujiangxiang() {
		return rongyujiangxiang;
	}
				
	
	/**
	 * 设置：自我评价
	 */
	 
	public void setZiwopingjia(String ziwopingjia) {
		this.ziwopingjia = ziwopingjia;
	}
	
	/**
	 * 获取：自我评价
	 */
	public String getZiwopingjia() {
		return ziwopingjia;
	}
			
}
