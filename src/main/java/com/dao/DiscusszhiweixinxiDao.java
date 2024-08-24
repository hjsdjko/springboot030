package com.dao;

import com.entity.DiscusszhiweixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszhiweixinxiVO;
import com.entity.view.DiscusszhiweixinxiView;


/**
 * 职位信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-21 21:30:22
 */
public interface DiscusszhiweixinxiDao extends BaseMapper<DiscusszhiweixinxiEntity> {
	
	List<DiscusszhiweixinxiVO> selectListVO(@Param("ew") Wrapper<DiscusszhiweixinxiEntity> wrapper);
	
	DiscusszhiweixinxiVO selectVO(@Param("ew") Wrapper<DiscusszhiweixinxiEntity> wrapper);
	
	List<DiscusszhiweixinxiView> selectListView(@Param("ew") Wrapper<DiscusszhiweixinxiEntity> wrapper);

	List<DiscusszhiweixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhiweixinxiEntity> wrapper);

	
	DiscusszhiweixinxiView selectView(@Param("ew") Wrapper<DiscusszhiweixinxiEntity> wrapper);
	

}
