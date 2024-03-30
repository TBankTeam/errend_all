package com.example.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.example.entity.Comment;
import com.example.mapper.CommentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 评论信息表业务处理
 **/
@Service
public class CommentService {

    @Resource
    private CommentMapper commentMapper;

    /**
     * 新增
     */
    public void add(Comment comment) {
        comment.setTime(DateUtil.now());
        if (comment.getPid() != null) {  // 表示这是一个回复
            Comment pComment = this.selectById(comment.getPid());  // 查出父级的评论
            if (pComment == null) {
                return;
            }
            if (pComment.getRootId() != null) {  // 这不是根节点
                comment.setRootId(pComment.getRootId());
            } else {
                comment.setRootId(pComment.getId());  // 这是根节点
            }
        }
        commentMapper.insert(comment);
    }

    /**
     * 后台删除
     */
    public void deleteById(Integer id) {
        commentMapper.deleteById(id);
    }

    /**
     * 前台递归删除
     */
    public void deepDelete(Integer pid) {
        commentMapper.deleteById(pid);
        List<Comment> children = commentMapper.selectByPid(pid);
        if (CollUtil.isNotEmpty(children)) {
            for (Comment comment : children) {
                pid = comment.getId();
                this.deepDelete(pid);
            }
        }
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            commentMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Comment comment) {
        commentMapper.updateById(comment);
    }

    /**
     * 根据ID查询
     */
    public Comment selectById(Integer id) {
        return commentMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Comment> selectAll(Comment comment) {
        return commentMapper.selectAll(comment);
    }

    /**
     * 分页查询
     */
    public PageInfo<Comment> selectPage(Comment comment, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Comment> list = commentMapper.selectAll(comment);
        return PageInfo.of(list);
    }

    public List<Comment> selectTree(Integer fid, String module) {
        List<Comment> commentList = commentMapper.selectTree(fid, module);
        // 筛选出最外层的节点
        List<Comment> rootList = commentList.stream().filter(comment -> comment.getPid() == null).collect(Collectors.toList());
        for (Comment root : rootList) {
            Integer rootId = root.getId();
            List<Comment> children = commentList.stream().filter(comment -> rootId.equals(comment.getRootId())).collect(Collectors.toList());
            root.setChildren(children);
        }
        return rootList;
    }

    public Integer selectCount(Integer fid, String module) {
        return commentMapper.selectCount(fid, module);
    }

}
