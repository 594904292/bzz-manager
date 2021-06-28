package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.common.core.domain.entity.BeeNode;

/**
 * 数字密码Service接口
 * 
 * @author ruoyi
 * @date 2021-06-26
 */
public interface IBeeNodeService 
{
    /**
     * 查询数字密码
     * 
     * @param nodeId 数字密码ID
     * @return 数字密码
     */
    public BeeNode selectBeeNodeById(Long nodeId);

    /**
     * 查询数字密码列表
     * 
     * @param beeNode 数字密码
     * @return 数字密码集合
     */
    public List<BeeNode> selectBeeNodeList(BeeNode beeNode);

    /**
     * 新增数字密码
     * 
     * @param beeNode 数字密码
     * @return 结果
     */
    public int insertBeeNode(BeeNode beeNode);

    /**
     * 修改数字密码
     * 
     * @param beeNode 数字密码
     * @return 结果
     */
    public int updateBeeNode(BeeNode beeNode);

    /**
     * 批量删除数字密码
     * 
     * @param nodeIds 需要删除的数字密码ID
     * @return 结果
     */
    public int deleteBeeNodeByIds(Long[] nodeIds);

    /**
     * 删除数字密码信息
     * 
     * @param nodeId 数字密码ID
     * @return 结果
     */
    public int deleteBeeNodeById(Long nodeId);
}
