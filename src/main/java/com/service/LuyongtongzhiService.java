package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LuyongtongzhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LuyongtongzhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LuyongtongzhiView;


/**
 * 录用通知
 *
 * @author 
 * @email 
 * @date 2024-04-21 21:30:21
 */
public interface LuyongtongzhiService extends IService<LuyongtongzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LuyongtongzhiVO> selectListVO(Wrapper<LuyongtongzhiEntity> wrapper);
   	
   	LuyongtongzhiVO selectVO(@Param("ew") Wrapper<LuyongtongzhiEntity> wrapper);
   	
   	List<LuyongtongzhiView> selectListView(Wrapper<LuyongtongzhiEntity> wrapper);
   	
   	LuyongtongzhiView selectView(@Param("ew") Wrapper<LuyongtongzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LuyongtongzhiEntity> wrapper);

   	

}

