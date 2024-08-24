package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MianshiyaoyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MianshiyaoyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MianshiyaoyueView;


/**
 * 面试邀约
 *
 * @author 
 * @email 
 * @date 2024-04-21 21:30:21
 */
public interface MianshiyaoyueService extends IService<MianshiyaoyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MianshiyaoyueVO> selectListVO(Wrapper<MianshiyaoyueEntity> wrapper);
   	
   	MianshiyaoyueVO selectVO(@Param("ew") Wrapper<MianshiyaoyueEntity> wrapper);
   	
   	List<MianshiyaoyueView> selectListView(Wrapper<MianshiyaoyueEntity> wrapper);
   	
   	MianshiyaoyueView selectView(@Param("ew") Wrapper<MianshiyaoyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MianshiyaoyueEntity> wrapper);

   	

}

