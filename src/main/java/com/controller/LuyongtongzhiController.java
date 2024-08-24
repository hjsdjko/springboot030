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

import com.entity.LuyongtongzhiEntity;
import com.entity.view.LuyongtongzhiView;

import com.service.LuyongtongzhiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 录用通知
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-21 21:30:21
 */
@RestController
@RequestMapping("/luyongtongzhi")
public class LuyongtongzhiController {
    @Autowired
    private LuyongtongzhiService luyongtongzhiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LuyongtongzhiEntity luyongtongzhi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			luyongtongzhi.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("qiye")) {
			luyongtongzhi.setQiyemingcheng((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LuyongtongzhiEntity> ew = new EntityWrapper<LuyongtongzhiEntity>();

		PageUtils page = luyongtongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, luyongtongzhi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LuyongtongzhiEntity luyongtongzhi, 
		HttpServletRequest request){
        EntityWrapper<LuyongtongzhiEntity> ew = new EntityWrapper<LuyongtongzhiEntity>();

		PageUtils page = luyongtongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, luyongtongzhi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LuyongtongzhiEntity luyongtongzhi){
       	EntityWrapper<LuyongtongzhiEntity> ew = new EntityWrapper<LuyongtongzhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( luyongtongzhi, "luyongtongzhi")); 
        return R.ok().put("data", luyongtongzhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LuyongtongzhiEntity luyongtongzhi){
        EntityWrapper< LuyongtongzhiEntity> ew = new EntityWrapper< LuyongtongzhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( luyongtongzhi, "luyongtongzhi")); 
		LuyongtongzhiView luyongtongzhiView =  luyongtongzhiService.selectView(ew);
		return R.ok("查询录用通知成功").put("data", luyongtongzhiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LuyongtongzhiEntity luyongtongzhi = luyongtongzhiService.selectById(id);
        return R.ok().put("data", luyongtongzhi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LuyongtongzhiEntity luyongtongzhi = luyongtongzhiService.selectById(id);
        return R.ok().put("data", luyongtongzhi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LuyongtongzhiEntity luyongtongzhi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(luyongtongzhi);
        luyongtongzhiService.insert(luyongtongzhi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LuyongtongzhiEntity luyongtongzhi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(luyongtongzhi);
        luyongtongzhiService.insert(luyongtongzhi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LuyongtongzhiEntity luyongtongzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(luyongtongzhi);
        luyongtongzhiService.updateById(luyongtongzhi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        luyongtongzhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
