package cn.iocoder.yudao.module.system.service.sword;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.sword.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.sword.SwordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.system.convert.sword.SwordConvert;
import cn.iocoder.yudao.module.system.dal.mysql.sword.SwordMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 求剑用户 Service 实现类
 *
 * @author 超级管理员
 */
@Service
@Validated
public class SwordServiceImpl implements SwordService {

    @Resource
    private SwordMapper swordMapper;

    @Override
    public Long createSword(SwordCreateReqVO createReqVO) {
        // 插入
        SwordDO sword = SwordConvert.INSTANCE.convert(createReqVO);
        swordMapper.insert(sword);
        // 返回
        return sword.getId();
    }

    @Override
    public void updateSword(SwordUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateSwordExists(updateReqVO.getId());
        // 更新
        SwordDO updateObj = SwordConvert.INSTANCE.convert(updateReqVO);
        swordMapper.updateById(updateObj);
    }

    @Override
    public void deleteSword(Long id) {
        // 校验存在
        this.validateSwordExists(id);
        // 删除
        swordMapper.deleteById(id);
    }

    private void validateSwordExists(Long id) {
        if (swordMapper.selectById(id) == null) {
            throw exception(SWORD_NOT_EXISTS);
        }
    }

    @Override
    public SwordDO getSword(Long id) {
        return swordMapper.selectById(id);
    }

    @Override
    public List<SwordDO> getSwordList(Collection<Long> ids) {
        return swordMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<SwordDO> getSwordPage(SwordPageReqVO pageReqVO) {
        return swordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<SwordDO> getSwordList(SwordExportReqVO exportReqVO) {
        return swordMapper.selectList(exportReqVO);
    }

}
