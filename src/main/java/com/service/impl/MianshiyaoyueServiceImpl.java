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


import com.dao.MianshiyaoyueDao;
import com.entity.MianshiyaoyueEntity;
import com.service.MianshiyaoyueService;
import com.entity.vo.MianshiyaoyueVO;
import com.entity.view.MianshiyaoyueView;

@Service("mianshiyaoyueService")
public class MianshiyaoyueServiceImpl extends ServiceImpl<MianshiyaoyueDao, MianshiyaoyueEntity> implements MianshiyaoyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MianshiyaoyueEntity> page = this.selectPage(
                new Query<MianshiyaoyueEntity>(params).getPage(),
                new EntityWrapper<MianshiyaoyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MianshiyaoyueEntity> wrapper) {
		  Page<MianshiyaoyueView> page =new Query<MianshiyaoyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MianshiyaoyueVO> selectListVO(Wrapper<MianshiyaoyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MianshiyaoyueVO selectVO(Wrapper<MianshiyaoyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MianshiyaoyueView> selectListView(Wrapper<MianshiyaoyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MianshiyaoyueView selectView(Wrapper<MianshiyaoyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
