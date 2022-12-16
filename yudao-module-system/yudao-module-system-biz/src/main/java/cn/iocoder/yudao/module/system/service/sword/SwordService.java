package cn.iocoder.yudao.module.system.service.sword;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.sword.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.sword.SwordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 求剑用户 Service 接口
 *
 * @author 超级管理员
 */
public interface SwordService {

    /**
     * 创建求剑用户
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createSword(@Valid SwordCreateReqVO createReqVO);

    /**
     * 更新求剑用户
     *
     * @param updateReqVO 更新信息
     */
    void updateSword(@Valid SwordUpdateReqVO updateReqVO);

    /**
     * 删除求剑用户
     *
     * @param id 编号
     */
    void deleteSword(Long id);

    /**
     * 获得求剑用户
     *
     * @param id 编号
     * @return 求剑用户
     */
    SwordDO getSword(Long id);

    /**
     * 获得求剑用户列表
     *
     * @param ids 编号
     * @return 求剑用户列表
     */
    List<SwordDO> getSwordList(Collection<Long> ids);

    /**
     * 获得求剑用户分页
     *
     * @param pageReqVO 分页查询
     * @return 求剑用户分页
     */
    PageResult<SwordDO> getSwordPage(SwordPageReqVO pageReqVO);

    /**
     * 获得求剑用户列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 求剑用户列表
     */
    List<SwordDO> getSwordList(SwordExportReqVO exportReqVO);

}
