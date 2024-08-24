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

import com.entity.ZhiweixinxiEntity;
import com.entity.view.ZhiweixinxiView;

import com.service.ZhiweixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 职位信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-21 21:30:21
 */
@RestController
@RequestMapping("/zhiweixinxi")
public class ZhiweixinxiController {
    @Autowired
    private ZhiweixinxiService zhiweixinxiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhiweixinxiEntity zhiweixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			zhiweixinxi.setQiyemingcheng((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhiweixinxiEntity> ew = new EntityWrapper<ZhiweixinxiEntity>();

		PageUtils page = zhiweixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiweixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhiweixinxiEntity zhiweixinxi, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			zhiweixinxi.setQiyemingcheng((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhiweixinxiEntity> ew = new EntityWrapper<ZhiweixinxiEntity>();

		PageUtils page = zhiweixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiweixinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhiweixinxiEntity zhiweixinxi){
       	EntityWrapper<ZhiweixinxiEntity> ew = new EntityWrapper<ZhiweixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhiweixinxi, "zhiweixinxi")); 
        return R.ok().put("data", zhiweixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhiweixinxiEntity zhiweixinxi){
        EntityWrapper< ZhiweixinxiEntity> ew = new EntityWrapper< ZhiweixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhiweixinxi, "zhiweixinxi")); 
		ZhiweixinxiView zhiweixinxiView =  zhiweixinxiService.selectView(ew);
		return R.ok("查询职位信息成功").put("data", zhiweixinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhiweixinxiEntity zhiweixinxi = zhiweixinxiService.selectById(id);
		zhiweixinxi.setClicknum(zhiweixinxi.getClicknum()+1);
		zhiweixinxi.setClicktime(new Date());
		zhiweixinxiService.updateById(zhiweixinxi);
        zhiweixinxi = zhiweixinxiService.selectView(new EntityWrapper<ZhiweixinxiEntity>().eq("id", id));
        return R.ok().put("data", zhiweixinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhiweixinxiEntity zhiweixinxi = zhiweixinxiService.selectById(id);
		zhiweixinxi.setClicknum(zhiweixinxi.getClicknum()+1);
		zhiweixinxi.setClicktime(new Date());
		zhiweixinxiService.updateById(zhiweixinxi);
        zhiweixinxi = zhiweixinxiService.selectView(new EntityWrapper<ZhiweixinxiEntity>().eq("id", id));
        return R.ok().put("data", zhiweixinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiweixinxiEntity zhiweixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhiweixinxi);
        zhiweixinxiService.insert(zhiweixinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhiweixinxiEntity zhiweixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhiweixinxi);
    	zhiweixinxi.setUserid((Long)request.getSession().getAttribute("userId"));
        zhiweixinxiService.insert(zhiweixinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhiweixinxiEntity zhiweixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiweixinxi);
        zhiweixinxiService.updateById(zhiweixinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ZhiweixinxiEntity> list = new ArrayList<ZhiweixinxiEntity>();
        for(Long id : ids) {
            ZhiweixinxiEntity zhiweixinxi = zhiweixinxiService.selectById(id);
            zhiweixinxi.setSfsh(sfsh);
            zhiweixinxi.setShhf(shhf);
            list.add(zhiweixinxi);
        }
        zhiweixinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhiweixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ZhiweixinxiEntity zhiweixinxi, HttpServletRequest request,String pre){
        EntityWrapper<ZhiweixinxiEntity> ew = new EntityWrapper<ZhiweixinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = zhiweixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiweixinxi), params), params));
        return R.ok().put("data", page);
    }






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<ZhiweixinxiEntity> ew = new EntityWrapper<ZhiweixinxiEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
            ew.eq("qiyemingcheng", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = zhiweixinxiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ZhiweixinxiEntity> ew = new EntityWrapper<ZhiweixinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ew.eq("qiyemingcheng", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = zhiweixinxiService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<ZhiweixinxiEntity> ew = new EntityWrapper<ZhiweixinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ew.eq("qiyemingcheng", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = zhiweixinxiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ZhiweixinxiEntity> ew = new EntityWrapper<ZhiweixinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ew.eq("qiyemingcheng", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = zhiweixinxiService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<ZhiweixinxiEntity> ew = new EntityWrapper<ZhiweixinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ew.eq("qiyemingcheng", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = zhiweixinxiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,ZhiweixinxiEntity zhiweixinxi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            zhiweixinxi.setQiyemingcheng((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<ZhiweixinxiEntity> ew = new EntityWrapper<ZhiweixinxiEntity>();
        int count = zhiweixinxiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiweixinxi), params), params));
        return R.ok().put("data", count);
    }



}