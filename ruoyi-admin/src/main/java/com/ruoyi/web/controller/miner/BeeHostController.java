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
import com.ruoyi.common.core.domain.entity.BeeHost;
import com.ruoyi.system.service.IBeeHostService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 数字密码Controller
 * 
 * @author ruoyi
 * @date 2021-06-26
 */
@RestController
@RequestMapping("/system/host")
public class BeeHostController extends BaseController
{
    @Autowired
    private IBeeHostService beeHostService;

    /**
     * 查询数字密码列表
     */
    @PreAuthorize("@ss.hasPermi('system:host:list')")
    @GetMapping("/list")
    public TableDataInfo list(BeeHost beeHost)
    {
        startPage();
        List<BeeHost> list = beeHostService.selectBeeHostList(beeHost);
        return getDataTable(list);
    }

    /**
     * 导出数字密码列表
     */
    @PreAuthorize("@ss.hasPermi('system:host:export')")
    @Log(title = "数字密码", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BeeHost beeHost)
    {
        List<BeeHost> list = beeHostService.selectBeeHostList(beeHost);
        ExcelUtil<BeeHost> util = new ExcelUtil<BeeHost>(BeeHost.class);
        return util.exportExcel(list, "host");
    }

    /**
     * 获取数字密码详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:host:query')")
    @GetMapping(value = "/{hostId}")
    public AjaxResult getInfo(@PathVariable("hostId") Long hostId)
    {
        return AjaxResult.success(beeHostService.selectBeeHostById(hostId));
    }

    /**
     * 新增数字密码
     */
    @PreAuthorize("@ss.hasPermi('system:host:add')")
    @Log(title = "数字密码", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BeeHost beeHost)
    {
        return toAjax(beeHostService.insertBeeHost(beeHost));
    }

    /**
     * 修改数字密码
     */
    @PreAuthorize("@ss.hasPermi('system:host:edit')")
    @Log(title = "数字密码", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BeeHost beeHost)
    {
        return toAjax(beeHostService.updateBeeHost(beeHost));
    }

    /**
     * 删除数字密码
     */
    @PreAuthorize("@ss.hasPermi('system:host:remove')")
    @Log(title = "数字密码", businessType = BusinessType.DELETE)
	@DeleteMapping("/{hostIds}")
    public AjaxResult remove(@PathVariable Long[] hostIds)
    {
        return toAjax(beeHostService.deleteBeeHostByIds(hostIds));
    }
}
