package com.dao;

import com.entity.ToudijianliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ToudijianliVO;
import com.entity.view.ToudijianliView;


/**
 * 投递简历
 * 
 * @author 
 * @email 
 * @date 2024-04-21 21:30:21
 */
public interface ToudijianliDao extends BaseMapper<ToudijianliEntity> {
	
	List<ToudijianliVO> selectListVO(@Param("ew") Wrapper<ToudijianliEntity> wrapper);
	
	ToudijianliVO selectVO(@Param("ew") Wrapper<ToudijianliEntity> wrapper);
	
	List<ToudijianliView> selectListView(@Param("ew") Wrapper<ToudijianliEntity> wrapper);

	List<ToudijianliView> selectListView(Pagination page,@Param("ew") Wrapper<ToudijianliEntity> wrapper);

	
	ToudijianliView selectView(@Param("ew") Wrapper<ToudijianliEntity> wrapper);
	

}
