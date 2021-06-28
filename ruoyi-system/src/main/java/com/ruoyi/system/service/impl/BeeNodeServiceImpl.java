package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.BeeHost;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.mapper.BeeHostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BeeNodeMapper;
import com.ruoyi.common.core.domain.entity.BeeNode;
import com.ruoyi.system.service.IBeeNodeService;

/**
 * 数字密码Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-26
 */
@Service
public class BeeNodeServiceImpl implements IBeeNodeService 
{
    @Autowired
    private BeeNodeMapper beeNodeMapper;

    @Autowired
    private BeeHostMapper beeHostMapper;

    /**
     * 查询数字密码
     * 
     * @param nodeId 数字密码ID
     * @return 数字密码
     */
    @Override
    public BeeNode selectBeeNodeById(Long nodeId)
    {
        BeeNode node= beeNodeMapper.selectBeeNodeById(nodeId);

        BeeHost beehost = beeHostMapper.selectBeeHostById(node.getHostId());
        node.setBeeHost(beehost);
        return node;
    }

    /**
     * 查询数字密码列表
     * 
     * @param beeNode 数字密码
     * @return 数字密码
     */
    @Override
    public List<BeeNode> selectBeeNodeList(BeeNode beeNode)
    {
        return beeNodeMapper.selectBeeNodeList(beeNode);
    }

    /**
     * 新增数字密码
     * 
     * @param beeNode 数字密码
     * @return 结果
     */
    @Override
    public int insertBeeNode(BeeNode beeNode)
    {
        beeNode.setCreateTime(DateUtils.getNowDate());
        return beeNodeMapper.insertBeeNode(beeNode);
    }

    /**
     * 修改数字密码
     * 
     * @param beeNode 数字密码
     * @return 结果
     */
    @Override
    public int updateBeeNode(BeeNode beeNode)
    {
        beeNode.setUpdateTime(DateUtils.getNowDate());
        return beeNodeMapper.updateBeeNode(beeNode);
    }

    /**
     * 批量删除数字密码
     * 
     * @param nodeIds 需要删除的数字密码ID
     * @return 结果
     */
    @Override
    public int deleteBeeNodeByIds(Long[] nodeIds)
    {
        return beeNodeMapper.deleteBeeNodeByIds(nodeIds);
    }

    /**
     * 删除数字密码信息
     * 
     * @param nodeId 数字密码ID
     * @return 结果
     */
    @Override
    public int deleteBeeNodeById(Long nodeId)
    {
        return beeNodeMapper.deleteBeeNodeById(nodeId);
    }
}
