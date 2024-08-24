package com.dao;

import com.entity.JianlimobanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JianlimobanVO;
import com.entity.view.JianlimobanView;


/**
 * 简历模板
 * 
 * @author 
 * @email 
 * @date 2024-04-21 21:30:22
 */
public interface JianlimobanDao extends BaseMapper<JianlimobanEntity> {
	
	List<JianlimobanVO> selectListVO(@Param("ew") Wrapper<JianlimobanEntity> wrapper);
	
	JianlimobanVO selectVO(@Param("ew") Wrapper<JianlimobanEntity> wrapper);
	
	List<JianlimobanView> selectListView(@Param("ew") Wrapper<JianlimobanEntity> wrapper);

	List<JianlimobanView> selectListView(Pagination page,@Param("ew") Wrapper<JianlimobanEntity> wrapper);

	
	JianlimobanView selectView(@Param("ew") Wrapper<JianlimobanEntity> wrapper);
	

}
