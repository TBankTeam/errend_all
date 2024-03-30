package com.example.service;

import com.example.entity.NurseHouse;
import com.example.mapper.NurseHouseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 养老院表业务处理
 **/
@Service
public class NurseHouseService {

    @Resource
    private NurseHouseMapper nurseHouseMapper;

    /**
     * 新增
     */
    public void add(NurseHouse nurseHouse) {
        nurseHouseMapper.insert(nurseHouse);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        nurseHouseMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            nurseHouseMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(NurseHouse nurseHouse) {
        nurseHouseMapper.updateById(nurseHouse);
    }

    /**
     * 根据ID查询
     */
    public NurseHouse selectById(Integer id) {
        return nurseHouseMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<NurseHouse> selectAll(NurseHouse nurseHouse) {
        return nurseHouseMapper.selectAll(nurseHouse);
    }

    /**
     * 分页查询
     */
    public PageInfo<NurseHouse> selectPage(NurseHouse nurseHouse, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<NurseHouse> list = nurseHouseMapper.selectAll(nurseHouse);
        return PageInfo.of(list);
    }

    public void updateCount(Integer id) {
        nurseHouseMapper.updateCount(id);
    }

}
