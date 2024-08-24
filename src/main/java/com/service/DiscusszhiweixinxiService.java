package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszhiweixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszhiweixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszhiweixinxiView;


/**
 * 职位信息评论表
 *
 * @author 
 * @email 
 * @date 2024-04-21 21:30:22
 */
public interface DiscusszhiweixinxiService extends IService<DiscusszhiweixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszhiweixinxiVO> selectListVO(Wrapper<DiscusszhiweixinxiEntity> wrapper);
   	
   	DiscusszhiweixinxiVO selectVO(@Param("ew") Wrapper<DiscusszhiweixinxiEntity> wrapper);
   	
   	List<DiscusszhiweixinxiView> selectListView(Wrapper<DiscusszhiweixinxiEntity> wrapper);
   	
   	DiscusszhiweixinxiView selectView(@Param("ew") Wrapper<DiscusszhiweixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszhiweixinxiEntity> wrapper);

   	

}

