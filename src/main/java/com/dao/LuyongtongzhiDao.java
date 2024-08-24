package com.dao;

import com.entity.LuyongtongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LuyongtongzhiVO;
import com.entity.view.LuyongtongzhiView;


/**
 * 录用通知
 * 
 * @author 
 * @email 
 * @date 2024-04-21 21:30:21
 */
public interface LuyongtongzhiDao extends BaseMapper<LuyongtongzhiEntity> {
	
	List<LuyongtongzhiVO> selectListVO(@Param("ew") Wrapper<LuyongtongzhiEntity> wrapper);
	
	LuyongtongzhiVO selectVO(@Param("ew") Wrapper<LuyongtongzhiEntity> wrapper);
	
	List<LuyongtongzhiView> selectListView(@Param("ew") Wrapper<LuyongtongzhiEntity> wrapper);

	List<LuyongtongzhiView> selectListView(Pagination page,@Param("ew") Wrapper<LuyongtongzhiEntity> wrapper);

	
	LuyongtongzhiView selectView(@Param("ew") Wrapper<LuyongtongzhiEntity> wrapper);
	

}
