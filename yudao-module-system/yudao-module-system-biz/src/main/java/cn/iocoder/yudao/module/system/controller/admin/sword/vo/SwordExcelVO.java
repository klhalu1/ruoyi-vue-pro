package cn.iocoder.yudao.module.system.controller.admin.sword.vo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 求剑用户 Excel VO
 *
 * @author 超级管理员
 */
@Data
public class SwordExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("微信标识")
    private String openid;

    @ExcelProperty("用户昵称")
    private String nickname;

    @ExcelProperty("手机号")
    private String mobile;

    @ExcelProperty("打卡时间")
    private LocalDateTime loginTime;

    @ExcelProperty("求剑时间")
    private LocalDateTime startTime;

    @ExcelProperty("结束时间")
    private LocalDateTime endTime;

    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("member_sword_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Integer status;

    @ExcelProperty(value = "是否分享", converter = DictConvert.class)
    @DictFormat("infra_boolean_string") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Boolean shared;

}
