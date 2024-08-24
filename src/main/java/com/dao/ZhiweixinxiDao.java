package com.dao;

import com.entity.ZhiweixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhiweixinxiVO;
import com.entity.view.ZhiweixinxiView;


/**
 * 职位信息
 * 
 * @author 
 * @email 
 * @date 2024-04-21 21:30:21
 */
public interface ZhiweixinxiDao extends BaseMapper<ZhiweixinxiEntity> {
	
	List<ZhiweixinxiVO> selectListVO(@Param("ew") Wrapper<ZhiweixinxiEntity> wrapper);
	
	ZhiweixinxiVO selectVO(@Param("ew") Wrapper<ZhiweixinxiEntity> wrapper);
	
	List<ZhiweixinxiView> selectListView(@Param("ew") Wrapper<ZhiweixinxiEntity> wrapper);

	List<ZhiweixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiweixinxiEntity> wrapper);

	
	ZhiweixinxiView selectView(@Param("ew") Wrapper<ZhiweixinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhiweixinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhiweixinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhiweixinxiEntity> wrapper);



}
