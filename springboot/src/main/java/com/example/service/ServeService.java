package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Serve;
import com.example.mapper.ServeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 养老服务表业务处理
 **/
@Service
public class ServeService {

    @Resource
    private ServeMapper serveMapper;

    /**
     * 新增
     */
    public void add(Serve serve) {
        serve.setDate(DateUtil.today());
        serveMapper.insert(serve);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        serveMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            serveMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Serve serve) {
        serveMapper.updateById(serve);
    }

    /**
     * 根据ID查询
     */
    public Serve selectById(Integer id) {
        return serveMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Serve> selectAll(Serve serve) {
        return serveMapper.selectAll(serve);
    }

    /**
     * 分页查询
     */
    public PageInfo<Serve> selectPage(Serve serve, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Serve> list = serveMapper.selectAll(serve);
        return PageInfo.of(list);
    }

}
