package com.example.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Dict;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.entity.Reserve;
import com.example.mapper.ReserveMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 服务预约业务处理
 **/
@Service
public class ReserveService {

    @Resource
    private ReserveMapper reserveMapper;

    /**
     * 新增
     */
    public void add(Reserve reserve) {
        reserve.setTime(DateUtil.now());
        reserveMapper.insert(reserve);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        reserveMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            reserveMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Reserve reserve) {
        reserveMapper.updateById(reserve);
    }

    /**
     * 根据ID查询
     */
    public Reserve selectById(Integer id) {
        return reserveMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Reserve> selectAll(Reserve reserve) {
        return reserveMapper.selectAll(reserve);
    }

    /**
     * 分页查询
     */
    public PageInfo<Reserve> selectPage(Reserve reserve, Integer pageNum, Integer pageSize) {
        Account currentUser = TokenUtils.getCurrentUser();
        if (RoleEnum.USER.name().equals(currentUser.getRole())) {
            reserve.setUserId(currentUser.getId());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Reserve> list = reserveMapper.selectAll(reserve);
        return PageInfo.of(list);
    }

    public List<Dict> selectCount() {
        List<Reserve> reserveList = reserveMapper.selectAll(null);
        reserveList = reserveList.stream().filter(reserve -> "审核通过".equals(reserve.getStatus())
                || "待审核".equals(reserve.getStatus())).collect(Collectors.toList());
        Set<String> set = reserveList.stream().map(Reserve::getServeName).collect(Collectors.toSet());
        List<Dict> list = CollUtil.newArrayList();
        for (String name : set) {
            long count = reserveList.stream().filter(reserve -> reserve.getServeName().equals(name)).count();
            Dict dict = Dict.create().set("name", name).set("value", count);
            list.add(dict);
        }
        return list;
    }
}
