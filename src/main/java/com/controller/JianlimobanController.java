package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JianlimobanEntity;
import com.entity.view.JianlimobanView;

import com.service.JianlimobanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 简历模板
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-21 21:30:22
 */
@RestController
@RequestMapping("/jianlimoban")
public class JianlimobanController {
    @Autowired
    private JianlimobanService jianlimobanService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianlimobanEntity jianlimoban,
		HttpServletRequest request){
        EntityWrapper<JianlimobanEntity> ew = new EntityWrapper<JianlimobanEntity>();

		PageUtils page = jianlimobanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianlimoban), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianlimobanEntity jianlimoban, 
		HttpServletRequest request){
        EntityWrapper<JianlimobanEntity> ew = new EntityWrapper<JianlimobanEntity>();

		PageUtils page = jianlimobanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianlimoban), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianlimobanEntity jianlimoban){
       	EntityWrapper<JianlimobanEntity> ew = new EntityWrapper<JianlimobanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianlimoban, "jianlimoban")); 
        return R.ok().put("data", jianlimobanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianlimobanEntity jianlimoban){
        EntityWrapper< JianlimobanEntity> ew = new EntityWrapper< JianlimobanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianlimoban, "jianlimoban")); 
		JianlimobanView jianlimobanView =  jianlimobanService.selectView(ew);
		return R.ok("查询简历模板成功").put("data", jianlimobanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianlimobanEntity jianlimoban = jianlimobanService.selectById(id);
        return R.ok().put("data", jianlimoban);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianlimobanEntity jianlimoban = jianlimobanService.selectById(id);
        return R.ok().put("data", jianlimoban);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianlimobanEntity jianlimoban, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jianlimoban);
        jianlimobanService.insert(jianlimoban);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianlimobanEntity jianlimoban, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jianlimoban);
        jianlimobanService.insert(jianlimoban);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianlimobanEntity jianlimoban, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianlimoban);
        jianlimobanService.updateById(jianlimoban);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianlimobanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
