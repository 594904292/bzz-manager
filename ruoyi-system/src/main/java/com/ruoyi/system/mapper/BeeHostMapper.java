package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.common.core.domain.entity.BeeHost;

/**
 * 数字密码Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-26
 */
public interface BeeHostMapper 
{
    /**
     * 查询数字密码
     * 
     * @param hostId 数字密码ID
     * @return 数字密码
     */
    public BeeHost selectBeeHostById(Long hostId);

    /**
     * 查询数字密码列表
     * 
     * @param beeHost 数字密码
     * @return 数字密码集合
     */
    public List<BeeHost> selectBeeHostList(BeeHost beeHost);

    /**
     * 新增数字密码
     * 
     * @param beeHost 数字密码
     * @return 结果
     */
    public int insertBeeHost(BeeHost beeHost);

    /**
     * 修改数字密码
     * 
     * @param beeHost 数字密码
     * @return 结果
     */
    public int updateBeeHost(BeeHost beeHost);

    /**
     * 删除数字密码
     * 
     * @param hostId 数字密码ID
     * @return 结果
     */
    public int deleteBeeHostById(Long hostId);

    /**
     * 批量删除数字密码
     * 
     * @param hostIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBeeHostByIds(Long[] hostIds);
}
