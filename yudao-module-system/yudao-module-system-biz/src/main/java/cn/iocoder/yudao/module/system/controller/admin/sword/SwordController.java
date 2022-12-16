package cn.iocoder.yudao.module.system.controller.admin.sword;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.system.controller.admin.sword.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.sword.SwordDO;
import cn.iocoder.yudao.module.system.convert.sword.SwordConvert;
import cn.iocoder.yudao.module.system.service.sword.SwordService;

@Api(tags = "管理后台 - 求剑用户")
@RestController
@RequestMapping("/system/sword")
@Validated
public class SwordController {

    @Resource
    private SwordService swordService;

    @PostMapping("/create")
    @ApiOperation("创建求剑用户")
    @PreAuthorize("@ss.hasPermission('system:sword:create')")
    public CommonResult<Long> createSword(@Valid @RequestBody SwordCreateReqVO createReqVO) {
        return success(swordService.createSword(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新求剑用户")
    @PreAuthorize("@ss.hasPermission('system:sword:update')")
    public CommonResult<Boolean> updateSword(@Valid @RequestBody SwordUpdateReqVO updateReqVO) {
        swordService.updateSword(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除求剑用户")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('system:sword:delete')")
    public CommonResult<Boolean> deleteSword(@RequestParam("id") Long id) {
        swordService.deleteSword(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得求剑用户")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('system:sword:query')")
    public CommonResult<SwordRespVO> getSword(@RequestParam("id") Long id) {
        SwordDO sword = swordService.getSword(id);
        return success(SwordConvert.INSTANCE.convert(sword));
    }

    @GetMapping("/list")
    @ApiOperation("获得求剑用户列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('system:sword:query')")
    public CommonResult<List<SwordRespVO>> getSwordList(@RequestParam("ids") Collection<Long> ids) {
        List<SwordDO> list = swordService.getSwordList(ids);
        return success(SwordConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得求剑用户分页")
    @PreAuthorize("@ss.hasPermission('system:sword:query')")
    public CommonResult<PageResult<SwordRespVO>> getSwordPage(@Valid SwordPageReqVO pageVO) {
        PageResult<SwordDO> pageResult = swordService.getSwordPage(pageVO);
        return success(SwordConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出求剑用户 Excel")
    @PreAuthorize("@ss.hasPermission('system:sword:export')")
    @OperateLog(type = EXPORT)
    public void exportSwordExcel(@Valid SwordExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<SwordDO> list = swordService.getSwordList(exportReqVO);
        // 导出 Excel
        List<SwordExcelVO> datas = SwordConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "求剑用户.xls", "数据", SwordExcelVO.class, datas);
    }

}
