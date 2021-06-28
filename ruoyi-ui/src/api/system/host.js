import request from '@/utils/request'

// 查询矿机列表
export function listHost(query) {
  return request({
    url: '/system/host/list',
    method: 'get',
    params: query
  })
}

// 查询矿机详细
export function getHost(hostId) {
  return request({
    url: '/system/host/' + hostId,
    method: 'get'
  })
}

// 新增矿机
export function addHost(data) {
  return request({
    url: '/system/host',
    method: 'post',
    data: data
  })
}

// 修改矿机
export function updateHost(data) {
  return request({
    url: '/system/host',
    method: 'put',
    data: data
  })
}

// 删除矿机
export function delHost(hostId) {
  return request({
    url: '/system/host/' + hostId,
    method: 'delete'
  })
}

// 导出矿机
export function exportHost(query) {
  return request({
    url: '/system/host/export',
    method: 'get',
    params: query
  })
}
