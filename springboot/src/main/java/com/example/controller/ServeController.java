package com.example.controller;

import com.example.common.Result;
import com.example.entity.Serve;
import com.example.service.ServeService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 养老服务表前端操作接口
 **/
@RestController
@RequestMapping("/serve")
public class ServeController {

    @Resource
    private ServeService serveService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Serve serve) {
        serveService.add(serve);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        serveService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        serveService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Serve serve) {
        serveService.updateById(serve);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Serve serve = serveService.selectById(id);
        return Result.success(serve);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Serve serve ) {
        List<Serve> list = serveService.selectAll(serve);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Serve serve,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Serve> page = serveService.selectPage(serve, pageNum, pageSize);
        return Result.success(page);
    }

}