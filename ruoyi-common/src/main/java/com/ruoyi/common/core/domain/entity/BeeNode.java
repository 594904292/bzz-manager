package com.ruoyi.common.core.domain.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 数字密码对象 bee_node
 * 
 * @author ruoyi
 * @date 2021-06-26
 */
public class BeeNode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主机ID */
    private Long nodeId;

    /** 主机IP */
    @Excel(name = "主机IP")
    private String userId;

    /** $column.columnComment */
    @Excel(name = "主机IP")
    private Long hostId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String nodeName;

    /** 密码 */
    @Excel(name = "密码")
    private String nodePass;

    /** $column.columnComment */
    @Excel(name = "密码")
    private String ethereum;

    /** $column.columnComment */
    @Excel(name = "密码")
    private Long peersnum;

    /** $column.columnComment */
    @Excel(name = "密码")
    private Long balancenum;

    /** 状态（0正常 1关闭） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;




    public void setNodeId(Long nodeId) 
    {
        this.nodeId = nodeId;
    }

    public Long getNodeId() 
    {
        return nodeId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setHostId(Long hostId) 
    {
        this.hostId = hostId;
    }

    public Long getHostId() 
    {
        return hostId;
    }
    public void setNodeName(String nodeName) 
    {
        this.nodeName = nodeName;
    }

    public String getNodeName() 
    {
        return nodeName;
    }
    public void setNodePass(String nodePass) 
    {
        this.nodePass = nodePass;
    }

    public String getNodePass() 
    {
        return nodePass;
    }
    public void setEthereum(String ethereum) 
    {
        this.ethereum = ethereum;
    }

    public String getEthereum() 
    {
        return ethereum;
    }
    public void setPeersnum(Long peersnum) 
    {
        this.peersnum = peersnum;
    }

    public Long getPeersnum() 
    {
        return peersnum;
    }
    public void setBalancenum(Long balancenum) 
    {
        this.balancenum = balancenum;
    }

    public Long getBalancenum() 
    {
        return balancenum;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    private BeeHost beeHost;

    public BeeHost getBeeHost()
    {
        return beeHost;
    }

    public void setBeeHost(BeeHost beeHost)
    {
        this.beeHost = beeHost;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("nodeId", getNodeId())
            .append("userId", getUserId())
            .append("hostId", getHostId())
            .append("nodeName", getNodeName())
            .append("nodePass", getNodePass())
            .append("ethereum", getEthereum())
            .append("peersnum", getPeersnum())
            .append("balancenum", getBalancenum())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("beeHost", getBeeHost())
            .toString();
    }
}
