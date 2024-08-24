package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscusszhiweixinxiDao;
import com.entity.DiscusszhiweixinxiEntity;
import com.service.DiscusszhiweixinxiService;
import com.entity.vo.DiscusszhiweixinxiVO;
import com.entity.view.DiscusszhiweixinxiView;

@Service("discusszhiweixinxiService")
public class DiscusszhiweixinxiServiceImpl extends ServiceImpl<DiscusszhiweixinxiDao, DiscusszhiweixinxiEntity> implements DiscusszhiweixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhiweixinxiEntity> page = this.selectPage(
                new Query<DiscusszhiweixinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusszhiweixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhiweixinxiEntity> wrapper) {
		  Page<DiscusszhiweixinxiView> page =new Query<DiscusszhiweixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusszhiweixinxiVO> selectListVO(Wrapper<DiscusszhiweixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszhiweixinxiVO selectVO(Wrapper<DiscusszhiweixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszhiweixinxiView> selectListView(Wrapper<DiscusszhiweixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhiweixinxiView selectView(Wrapper<DiscusszhiweixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
