package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BeeHostMapper;
import com.ruoyi.common.core.domain.entity.BeeHost;
import com.ruoyi.system.service.IBeeHostService;

/**
 * 数字密码Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-26
 */
@Service
public class BeeHostServiceImpl implements IBeeHostService 
{
    @Autowired
    private BeeHostMapper beeHostMapper;

    /**
     * 查询数字密码
     * 
     * @param hostId 数字密码ID
     * @return 数字密码
     */
    @Override
    public BeeHost selectBeeHostById(Long hostId)
    {
        return beeHostMapper.selectBeeHostById(hostId);
    }

    /**
     * 查询数字密码列表
     * 
     * @param beeHost 数字密码
     * @return 数字密码
     */
    @Override
    public List<BeeHost> selectBeeHostList(BeeHost beeHost)
    {
        return beeHostMapper.selectBeeHostList(beeHost);
    }

    /**
     * 新增数字密码
     * 
     * @param beeHost 数字密码
     * @return 结果
     */
    @Override
    public int insertBeeHost(BeeHost beeHost)
    {
        beeHost.setCreateTime(DateUtils.getNowDate());
        return beeHostMapper.insertBeeHost(beeHost);
    }

    /**
     * 修改数字密码
     * 
     * @param beeHost 数字密码
     * @return 结果
     */
    @Override
    public int updateBeeHost(BeeHost beeHost)
    {
        beeHost.setUpdateTime(DateUtils.getNowDate());
        return beeHostMapper.updateBeeHost(beeHost);
    }

    /**
     * 批量删除数字密码
     * 
     * @param hostIds 需要删除的数字密码ID
     * @return 结果
     */
    @Override
    public int deleteBeeHostByIds(Long[] hostIds)
    {
        return beeHostMapper.deleteBeeHostByIds(hostIds);
    }

    /**
     * 删除数字密码信息
     * 
     * @param hostId 数字密码ID
     * @return 结果
     */
    @Override
    public int deleteBeeHostById(Long hostId)
    {
        return beeHostMapper.deleteBeeHostById(hostId);
    }
}
