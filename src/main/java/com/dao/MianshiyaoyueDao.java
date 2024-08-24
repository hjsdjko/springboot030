package com.dao;

import com.entity.MianshiyaoyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MianshiyaoyueVO;
import com.entity.view.MianshiyaoyueView;


/**
 * 面试邀约
 * 
 * @author 
 * @email 
 * @date 2024-04-21 21:30:21
 */
public interface MianshiyaoyueDao extends BaseMapper<MianshiyaoyueEntity> {
	
	List<MianshiyaoyueVO> selectListVO(@Param("ew") Wrapper<MianshiyaoyueEntity> wrapper);
	
	MianshiyaoyueVO selectVO(@Param("ew") Wrapper<MianshiyaoyueEntity> wrapper);
	
	List<MianshiyaoyueView> selectListView(@Param("ew") Wrapper<MianshiyaoyueEntity> wrapper);

	List<MianshiyaoyueView> selectListView(Pagination page,@Param("ew") Wrapper<MianshiyaoyueEntity> wrapper);

	
	MianshiyaoyueView selectView(@Param("ew") Wrapper<MianshiyaoyueEntity> wrapper);
	

}
