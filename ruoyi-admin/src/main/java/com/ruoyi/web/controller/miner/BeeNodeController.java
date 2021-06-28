package com.ruoyi.web.controller.miner;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.domain.entity.BeeNode;
import com.ruoyi.system.service.IBeeNodeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 数字密码Controller
 * 
 * @author ruoyi
 * @date 2021-06-26
 */
@RestController
@RequestMapping("/system/node")
public class BeeNodeController extends BaseController
{
    @Autowired
    private IBeeNodeService beeNodeService;

    /**
     * 查询数字密码列表
     */
    @PreAuthorize("@ss.hasPermi('system:node:list')")
    @GetMapping("/list")
    public TableDataInfo list(BeeNode beeNode)
    {
        startPage();
        List<BeeNode> list = beeNodeService.selectBeeNodeList(beeNode);
        return getDataTable(list);
    }

    /**
     * 导出数字密码列表
     */
    @PreAuthorize("@ss.hasPermi('system:node:export')")
    @Log(title = "数字密码", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BeeNode beeNode)
    {
        List<BeeNode> list = beeNodeService.selectBeeNodeList(beeNode);
        ExcelUtil<BeeNode> util = new ExcelUtil<BeeNode>(BeeNode.class);
        return util.exportExcel(list, "node");
    }

    /**
     * 获取数字密码详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:node:query')")
    @GetMapping(value = "/{nodeId}")
    public AjaxResult getInfo(@PathVariable("nodeId") Long nodeId)
    {
        return AjaxResult.success(beeNodeService.selectBeeNodeById(nodeId));
    }

    /**
     * 新增数字密码
     */
    @PreAuthorize("@ss.hasPermi('system:node:add')")
    @Log(title = "数字密码", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BeeNode beeNode)
    {
        return toAjax(beeNodeService.insertBeeNode(beeNode));
    }

    /**
     * 修改数字密码
     */
    @PreAuthorize("@ss.hasPermi('system:node:edit')")
    @Log(title = "数字密码", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BeeNode beeNode)
    {
        return toAjax(beeNodeService.updateBeeNode(beeNode));
    }

    /**
     * 删除数字密码
     */
    @PreAuthorize("@ss.hasPermi('system:node:remove')")
    @Log(title = "数字密码", businessType = BusinessType.DELETE)
	@DeleteMapping("/{nodeIds}")
    public AjaxResult remove(@PathVariable Long[] nodeIds)
    {
        return toAjax(beeNodeService.deleteBeeNodeByIds(nodeIds));
    }
}
