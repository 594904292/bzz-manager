package com.ruoyi.common.core.domain.entity;

import com.ruoyi.common.core.domain.entity.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 数字密码对象 bee_host
 * 
 * @author ruoyi
 * @date 2021-06-26
 */
public class BeeHost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主机ID */
    private Long hostId;

    /** 用户 */
    @Excel(name = "用户")
    private Long userId;

    /** 操作系统  */
    @Excel(name = "操作系统 ")
    private String hostOs;

    /** 主机IP */
    @Excel(name = "主机IP")
    private String hostIp;

    /** 用户名 */
    @Excel(name = "用户名")
    private String hostUser;

    /** 密码 */
    @Excel(name = "密码")
    private String hostPass;

    /** 节点数 */
    @Excel(name = "节点数")
    private Long nodeCnt;

    /** 状态（0正常 1关闭） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;




    public void setHostId(Long hostId) 
    {
        this.hostId = hostId;
    }

    public Long getHostId() 
    {
        return hostId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setHostOs(String hostOs) 
    {
        this.hostOs = hostOs;
    }

    public String getHostOs() 
    {
        return hostOs;
    }
    public void setHostIp(String hostIp) 
    {
        this.hostIp = hostIp;
    }

    public String getHostIp() 
    {
        return hostIp;
    }
    public void setHostUser(String hostUser) 
    {
        this.hostUser = hostUser;
    }

    public String getHostUser() 
    {
        return hostUser;
    }
    public void setHostPass(String hostPass) 
    {
        this.hostPass = hostPass;
    }

    public String getHostPass() 
    {
        return hostPass;
    }
    public void setNodeCnt(Long nodeCnt) 
    {
        this.nodeCnt = nodeCnt;
    }

    public Long getNodeCnt() 
    {
        return nodeCnt;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("hostId", getHostId())
            .append("userId", getUserId())
            .append("hostOs", getHostOs())
            .append("hostIp", getHostIp())
            .append("hostUser", getHostUser())
            .append("hostPass", getHostPass())
            .append("nodeCnt", getNodeCnt())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
