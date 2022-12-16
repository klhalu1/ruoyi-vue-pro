package cn.iocoder.yudao.module.system.dal.dataobject.sword;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 求剑用户 DO
 *
 * @author 超级管理员
 */
@TableName("system_sword")
@KeySequence("system_sword_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SwordDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 微信标识
     */
    private String openid;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String headimgurl;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 打卡时间
     */
    private LocalDateTime loginTime;
    /**
     * 求剑时间
     */
    private LocalDateTime startTime;
    /**
     * 结束时间
     */
    private LocalDateTime endTime;
    /**
     * 状态
     *
     * 枚举 {@link TODO member_sword_status 对应的类}
     */
    private Integer status;
    /**
     * 是否分享
     *
     * 枚举 {@link TODO infra_boolean_string 对应的类}
     */
    private Boolean shared;

}
