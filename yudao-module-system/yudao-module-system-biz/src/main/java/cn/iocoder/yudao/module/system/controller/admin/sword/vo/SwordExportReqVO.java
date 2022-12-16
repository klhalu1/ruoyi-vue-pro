package cn.iocoder.yudao.module.system.controller.admin.sword.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 求剑用户 Excel 导出 Request VO", description = "参数和 SwordPageReqVO 是一致的")
@Data
public class SwordExportReqVO {

    @ApiModelProperty(value = "用户昵称")
    private String nickname;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "打卡时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] loginTime;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "是否分享")
    private Boolean shared;

}
