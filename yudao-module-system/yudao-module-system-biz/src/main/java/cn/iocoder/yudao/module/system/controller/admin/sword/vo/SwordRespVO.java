package cn.iocoder.yudao.module.system.controller.admin.sword.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 求剑用户 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SwordRespVO extends SwordBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    private Long id;

}
