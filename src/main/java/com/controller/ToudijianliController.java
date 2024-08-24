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

import com.entity.ToudijianliEntity;
import com.entity.view.ToudijianliView;

import com.service.ToudijianliService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 投递简历
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-21 21:30:21
 */
@RestController
@RequestMapping("/toudijianli")
public class ToudijianliController {
    @Autowired
    private ToudijianliService toudijianliService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ToudijianliEntity toudijianli,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			toudijianli.setQiyemingcheng((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			toudijianli.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ToudijianliEntity> ew = new EntityWrapper<ToudijianliEntity>();

		PageUtils page = toudijianliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, toudijianli), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ToudijianliEntity toudijianli, 
		HttpServletRequest request){
        EntityWrapper<ToudijianliEntity> ew = new EntityWrapper<ToudijianliEntity>();

		PageUtils page = toudijianliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, toudijianli), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ToudijianliEntity toudijianli){
       	EntityWrapper<ToudijianliEntity> ew = new EntityWrapper<ToudijianliEntity>();
      	ew.allEq(MPUtil.allEQMapPre( toudijianli, "toudijianli")); 
        return R.ok().put("data", toudijianliService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ToudijianliEntity toudijianli){
        EntityWrapper< ToudijianliEntity> ew = new EntityWrapper< ToudijianliEntity>();
 		ew.allEq(MPUtil.allEQMapPre( toudijianli, "toudijianli")); 
		ToudijianliView toudijianliView =  toudijianliService.selectView(ew);
		return R.ok("查询投递简历成功").put("data", toudijianliView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ToudijianliEntity toudijianli = toudijianliService.selectById(id);
        return R.ok().put("data", toudijianli);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ToudijianliEntity toudijianli = toudijianliService.selectById(id);
        return R.ok().put("data", toudijianli);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ToudijianliEntity toudijianli, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(toudijianli);
        toudijianliService.insert(toudijianli);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ToudijianliEntity toudijianli, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(toudijianli);
        toudijianliService.insert(toudijianli);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ToudijianliEntity toudijianli, HttpServletRequest request){
        //ValidatorUtils.validateEntity(toudijianli);
        toudijianliService.updateById(toudijianli);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ToudijianliEntity> list = new ArrayList<ToudijianliEntity>();
        for(Long id : ids) {
            ToudijianliEntity toudijianli = toudijianliService.selectById(id);
            toudijianli.setSfsh(sfsh);
            toudijianli.setShhf(shhf);
            list.add(toudijianli);
        }
        toudijianliService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        toudijianliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
