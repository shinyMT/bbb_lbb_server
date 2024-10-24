package com.thy.bbb_lbb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thy.bbb_lbb.anno.UsePage;
import com.thy.bbb_lbb.domain.bo.PoopBO;
import com.thy.bbb_lbb.mapper.PoopMapper;
import com.thy.bbb_lbb.domain.po.PoopPO;
import com.thy.bbb_lbb.service.PoopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author thy
 * 2024-10-17 14:47:27
 */
@Service("poopService")
public class PoopServiceImpl extends ServiceImpl<PoopMapper, PoopPO> implements PoopService {
    @Resource
    private PoopMapper mapper;

    @Override
    public PoopPO getDetails(Integer id) {
        return this.getById(id);
    }

    @UsePage
    @Override
    public List<PoopPO> listByYearMonth(int userId, String year, String month) {
        return mapper.listByYearMonth(userId, year, month);
    }

    @Override
    public boolean insert(PoopPO poop) {
        return mapper.insert(poop) > 0;
    }

    @Override
    public boolean updateById(PoopPO poop) {
        return mapper.updateById(poop) > 0;
    }

    @Override
    public boolean deleteById(PoopPO po) {
        return mapper.updateById(po) > 0;
    }

    @Override
    public List<PoopBO> selectStatisticsByYear(Integer year, int userId) {
        return mapper.listStatisticsByYear(year, userId);
    }
}
