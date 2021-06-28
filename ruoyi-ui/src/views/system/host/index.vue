<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="归属用户" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入归属用户"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="操作系统 " prop="hostOs">
        <el-input
          v-model="queryParams.hostOs"
          placeholder="请输入操作系统 "
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="主机IP" prop="hostIp">
        <el-input
          v-model="queryParams.hostIp"
          placeholder="请输入主机IP"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="管理员帐号" prop="hostUser">
        <el-input
          v-model="queryParams.hostUser"
          placeholder="请输入管理员帐号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="管理员密码" prop="hostPass">
        <el-input
          v-model="queryParams.hostPass"
          placeholder="请输入管理员密码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="节点数" prop="nodeCnt">
        <el-input
          v-model="queryParams.nodeCnt"
          placeholder="请输入节点数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable size="small">
          <el-option
                                   v-for="dict in statusOptions"
                                   :key="dict.dictValue"
                                   :label="dict.dictLabel"
                                   :value="dict.dictValue"
                                 />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:host:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:host:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:host:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:host:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="hostList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主机ID" align="center" prop="hostId" />
      <el-table-column label="归属用户" align="center" prop="userId" />
      <el-table-column label="操作系统 " align="center" prop="hostOs" />
      <el-table-column label="主机IP" align="center" prop="hostIp" />
      <el-table-column label="管理员帐号" align="center" prop="hostUser" />
      <el-table-column label="节点数" align="center" prop="nodeCnt" />
       <el-table-column label="状态" align="center" prop="status">
            <template slot-scope="scope">
                          <el-switch
                            v-model="scope.row.status"
                            active-value="0"
                            inactive-value="1"
                          ></el-switch>
                        </template>
           </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:host:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:host:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改矿机对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="归属用户" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入归属用户" />
        </el-form-item>
        <el-form-item label="操作系统 " prop="hostOs">
          <el-input v-model="form.hostOs" placeholder="请输入操作系统 " />
        </el-form-item>
        <el-form-item label="主机IP" prop="hostIp">
          <el-input v-model="form.hostIp" placeholder="请输入主机IP" />
        </el-form-item>
        <el-form-item label="管理员帐号" prop="hostUser">
          <el-input v-model="form.hostUser" placeholder="请输入管理员帐号" />
        </el-form-item>
        <el-form-item label="管理员密码" prop="hostPass">
          <el-input v-model="form.hostPass" placeholder="请输入管理员密码" />
        </el-form-item>
        <el-form-item label="节点数" prop="nodeCnt">
          <el-input v-model="form.nodeCnt" placeholder="请输入节点数" />
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.status">
           <el-radio
                          v-for="dict in statusOptions"
                          :key="dict.dictValue"
                          :label="dict.dictValue"
                        >{{dict.dictLabel}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listHost, getHost, delHost, addHost, updateHost, exportHost } from "@/api/system/host";

export default {
  name: "Host",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 矿机表格数据
      hostList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 状态数据字典
            statusOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        hostOs: null,
        hostIp: null,
        hostUser: null,
        hostPass: null,
        nodeCnt: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        hostIp: [
          { required: true, message: "主机IP不能为空", trigger: "blur" }
        ],
        hostUser: [
          { required: true, message: "管理员帐号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
     /** 查询节点状态 */
        this.getDicts("sys_normal_disable").then(response => {
              this.statusOptions = response.data;
        });
  },
  methods: {
    /** 查询矿机列表 */
    getList() {
      this.loading = true;
      listHost(this.queryParams).then(response => {
        this.hostList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        hostId: null,
        userId: null,
        hostOs: null,
        hostIp: null,
        hostUser: null,
        hostPass: null,
        nodeCnt: null,
        status: "0",
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.hostId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加矿机";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const hostId = row.hostId || this.ids
      getHost(hostId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改矿机";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.hostId != null) {
            updateHost(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addHost(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const hostIds = row.hostId || this.ids;
      this.$confirm('是否确认删除矿机编号为"' + hostIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delHost(hostIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有矿机数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportHost(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
