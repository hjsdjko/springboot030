package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 简历模板
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-21 21:30:22
 */
@TableName("jianlimoban")
public class JianlimobanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JianlimobanEntity() {
		
	}
	
	public JianlimobanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 模板名称
	 */
					
	private String mobanmingcheng;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：模板名称
	 */
	public void setMobanmingcheng(String mobanmingcheng) {
		this.mobanmingcheng = mobanmingcheng;
	}
	/**
	 * 获取：模板名称
	 */
	public String getMobanmingcheng() {
		return mobanmingcheng;
	}
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
