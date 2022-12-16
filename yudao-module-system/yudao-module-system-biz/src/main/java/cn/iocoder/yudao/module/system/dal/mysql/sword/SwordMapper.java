package cn.iocoder.yudao.module.system.dal.mysql.sword;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.sword.SwordDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.sword.vo.*;

/**
 * 求剑用户 Mapper
 *
 * @author 超级管理员
 */
@Mapper
public interface SwordMapper extends BaseMapperX<SwordDO> {

    default PageResult<SwordDO> selectPage(SwordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SwordDO>()
                .likeIfPresent(SwordDO::getNickname, reqVO.getNickname())
                .eqIfPresent(SwordDO::getMobile, reqVO.getMobile())
                .betweenIfPresent(SwordDO::getLoginTime, reqVO.getLoginTime())
                .eqIfPresent(SwordDO::getStatus, reqVO.getStatus())
                .eqIfPresent(SwordDO::getShared, reqVO.getShared())
                .orderByDesc(SwordDO::getId));
    }

    default List<SwordDO> selectList(SwordExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SwordDO>()
                .likeIfPresent(SwordDO::getNickname, reqVO.getNickname())
                .eqIfPresent(SwordDO::getMobile, reqVO.getMobile())
                .betweenIfPresent(SwordDO::getLoginTime, reqVO.getLoginTime())
                .eqIfPresent(SwordDO::getStatus, reqVO.getStatus())
                .eqIfPresent(SwordDO::getShared, reqVO.getShared())
                .orderByDesc(SwordDO::getId));
    }

}
