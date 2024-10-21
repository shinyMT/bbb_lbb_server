package com.thy.bbb_lbb.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thy.bbb_lbb.anno.UsePage;
import com.thy.bbb_lbb.mapper.PoopMapper;
import com.thy.bbb_lbb.domain.po.PoopPO;
import com.thy.bbb_lbb.service.PoopService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
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
    public List<PoopPO> listByYearMonth(int year, int month) {
        return mapper.listByYearMonth(year, month);
    }

    @Override
    public boolean insert(PoopPO poop) {
        return this.save(poop);
    }

    @Override
    public boolean updateById(PoopPO poop) {
        return mapper.updateById(poop) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.removeById(id);
    }
}
