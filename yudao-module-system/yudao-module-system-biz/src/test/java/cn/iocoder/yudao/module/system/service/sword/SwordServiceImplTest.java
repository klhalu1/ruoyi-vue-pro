package cn.iocoder.yudao.module.system.service.sword;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.system.controller.admin.sword.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.sword.SwordDO;
import cn.iocoder.yudao.module.system.dal.mysql.sword.SwordMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link SwordServiceImpl} 的单元测试类
*
* @author 超级管理员
*/
@Import(SwordServiceImpl.class)
public class SwordServiceImplTest extends BaseDbUnitTest {

    @Resource
    private SwordServiceImpl swordService;

    @Resource
    private SwordMapper swordMapper;

    @Test
    public void testCreateSword_success() {
        // 准备参数
        SwordCreateReqVO reqVO = randomPojo(SwordCreateReqVO.class);

        // 调用
        Long swordId = swordService.createSword(reqVO);
        // 断言
        assertNotNull(swordId);
        // 校验记录的属性是否正确
        SwordDO sword = swordMapper.selectById(swordId);
        assertPojoEquals(reqVO, sword);
    }

    @Test
    public void testUpdateSword_success() {
        // mock 数据
        SwordDO dbSword = randomPojo(SwordDO.class);
        swordMapper.insert(dbSword);// @Sql: 先插入出一条存在的数据
        // 准备参数
        SwordUpdateReqVO reqVO = randomPojo(SwordUpdateReqVO.class, o -> {
            o.setId(dbSword.getId()); // 设置更新的 ID
        });

        // 调用
        swordService.updateSword(reqVO);
        // 校验是否更新正确
        SwordDO sword = swordMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, sword);
    }

    @Test
    public void testUpdateSword_notExists() {
        // 准备参数
        SwordUpdateReqVO reqVO = randomPojo(SwordUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> swordService.updateSword(reqVO), SWORD_NOT_EXISTS);
    }

    @Test
    public void testDeleteSword_success() {
        // mock 数据
        SwordDO dbSword = randomPojo(SwordDO.class);
        swordMapper.insert(dbSword);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbSword.getId();

        // 调用
        swordService.deleteSword(id);
       // 校验数据不存在了
       assertNull(swordMapper.selectById(id));
    }

    @Test
    public void testDeleteSword_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> swordService.deleteSword(id), SWORD_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSwordPage() {
       // mock 数据
       SwordDO dbSword = randomPojo(SwordDO.class, o -> { // 等会查询到
           o.setNickname(null);
           o.setMobile(null);
           o.setLoginTime(null);
           o.setStatus(null);
           o.setShared(null);
       });
       swordMapper.insert(dbSword);
       // 测试 nickname 不匹配
       swordMapper.insert(cloneIgnoreId(dbSword, o -> o.setNickname(null)));
       // 测试 mobile 不匹配
       swordMapper.insert(cloneIgnoreId(dbSword, o -> o.setMobile(null)));
       // 测试 loginTime 不匹配
       swordMapper.insert(cloneIgnoreId(dbSword, o -> o.setLoginTime(null)));
       // 测试 status 不匹配
       swordMapper.insert(cloneIgnoreId(dbSword, o -> o.setStatus(null)));
       // 测试 shared 不匹配
       swordMapper.insert(cloneIgnoreId(dbSword, o -> o.setShared(null)));
       // 准备参数
       SwordPageReqVO reqVO = new SwordPageReqVO();
       reqVO.setNickname(null);
       reqVO.setMobile(null);
       reqVO.setLoginTime((new LocalDateTime[]{}));
       reqVO.setStatus(null);
       reqVO.setShared(null);

       // 调用
       PageResult<SwordDO> pageResult = swordService.getSwordPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbSword, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSwordList() {
       // mock 数据
       SwordDO dbSword = randomPojo(SwordDO.class, o -> { // 等会查询到
           o.setNickname(null);
           o.setMobile(null);
           o.setLoginTime(null);
           o.setStatus(null);
           o.setShared(null);
       });
       swordMapper.insert(dbSword);
       // 测试 nickname 不匹配
       swordMapper.insert(cloneIgnoreId(dbSword, o -> o.setNickname(null)));
       // 测试 mobile 不匹配
       swordMapper.insert(cloneIgnoreId(dbSword, o -> o.setMobile(null)));
       // 测试 loginTime 不匹配
       swordMapper.insert(cloneIgnoreId(dbSword, o -> o.setLoginTime(null)));
       // 测试 status 不匹配
       swordMapper.insert(cloneIgnoreId(dbSword, o -> o.setStatus(null)));
       // 测试 shared 不匹配
       swordMapper.insert(cloneIgnoreId(dbSword, o -> o.setShared(null)));
       // 准备参数
       SwordExportReqVO reqVO = new SwordExportReqVO();
       reqVO.setNickname(null);
       reqVO.setMobile(null);
       reqVO.setLoginTime((new LocalDateTime[]{}));
       reqVO.setStatus(null);
       reqVO.setShared(null);

       // 调用
       List<SwordDO> list = swordService.getSwordList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbSword, list.get(0));
    }

}
