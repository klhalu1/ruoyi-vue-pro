import request from '@/utils/request'

// 创建求剑用户
export function createSword(data) {
  return request({
    url: '/system/sword/create',
    method: 'post',
    data: data
  })
}

// 更新求剑用户
export function updateSword(data) {
  return request({
    url: '/system/sword/update',
    method: 'put',
    data: data
  })
}

// 删除求剑用户
export function deleteSword(id) {
  return request({
    url: '/system/sword/delete?id=' + id,
    method: 'delete'
  })
}

// 获得求剑用户
export function getSword(id) {
  return request({
    url: '/system/sword/get?id=' + id,
    method: 'get'
  })
}

// 获得求剑用户分页
export function getSwordPage(query) {
  return request({
    url: '/system/sword/page',
    method: 'get',
    params: query
  })
}

// 导出求剑用户 Excel
export function exportSwordExcel(query) {
  return request({
    url: '/system/sword/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
