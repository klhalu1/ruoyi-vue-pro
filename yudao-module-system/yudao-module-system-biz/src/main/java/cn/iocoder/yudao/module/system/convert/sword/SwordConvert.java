package cn.iocoder.yudao.module.system.convert.sword;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.system.controller.admin.sword.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.sword.SwordDO;

/**
 * 求剑用户 Convert
 *
 * @author 超级管理员
 */
@Mapper
public interface SwordConvert {

    SwordConvert INSTANCE = Mappers.getMapper(SwordConvert.class);

    SwordDO convert(SwordCreateReqVO bean);

    SwordDO convert(SwordUpdateReqVO bean);

    SwordRespVO convert(SwordDO bean);

    List<SwordRespVO> convertList(List<SwordDO> list);

    PageResult<SwordRespVO> convertPage(PageResult<SwordDO> page);

    List<SwordExcelVO> convertList02(List<SwordDO> list);

}
