import request from '@/utils/request'

// 查询节点管理列表
export function listNode(query) {
  return request({
    url: '/system/node/list',
    method: 'get',
    params: query
  })
}

// 查询节点管理详细
export function getNode(nodeId) {
  return request({
    url: '/system/node/' + nodeId,
    method: 'get'
  })
}

// 新增节点管理
export function addNode(data) {
  return request({
    url: '/system/node',
    method: 'post',
    data: data
  })
}

// 修改节点管理
export function updateNode(data) {
  return request({
    url: '/system/node',
    method: 'put',
    data: data
  })
}

// 删除节点管理
export function delNode(nodeId) {
  return request({
    url: '/system/node/' + nodeId,
    method: 'delete'
  })
}

// 导出节点管理
export function exportNode(query) {
  return request({
    url: '/system/node/export',
    method: 'get',
    params: query
  })
}