<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台管理</title>
    <#include  "common/css.ftl">
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
    <#include "common/header.ftl">
    <#include "common/sidebar.ftl" >
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>用户列表</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">首页</a></li>
                            <li class="breadcrumb-item active">系统管理</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">用户列表</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <div class="row mb-2">
                                    <div class="col-sm-3">
                                        <a class="btn btn-primary" data-toggle="modal" data-target="#addModal">
                                            <i class="fas fa-plus"></i> 添加
                                        </a>
                                    </div>
                                </div>

                                <table id="dataTable" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>登陆账号</th>
                                        <th>用户名称</th>
                                        <th>用户头像</th>
                                        <th>用户角色</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    </tbody>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <#include "common/footer.ftl">
    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
<#include "common/js.ftl" >
</body>
</html>

<div id="delModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="delSysUser" method="post">
                <input type="hidden" id="sysUserId" name="id">
                <div class="modal-header">
                    <h4 id="delModalLabel" class="modal-title">删除提示框</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <p>确定要删除吗？</p>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-default">确定</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div id="addModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="addSysUser" method="post">
                <div class="modal-header">
                    <h4 id="addModalLabel" class="modal-title">添加用户</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">用户账号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userCode" name="userCode" placeholder="用户账号">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">用户密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userPwd" name="userPwd" placeholder="用户密码">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">用户名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userName" name="userName" placeholder="用户名称">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">用户头像</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userImg" name="userImg" placeholder="用户头像">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">用户角色</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="roleId" name="roleId" placeholder="角色名称">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-default">确定</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div id="editModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="updSysUser" method="post">
                <input type="hidden" id="editUserId" name="id">
                <div class="modal-header">
                    <h4 id="addModalLabel" class="modal-title">修改角色</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">用户账号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="editUserCode" name="userCode" placeholder="用户账号">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">用户密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="editUserPwd" name="userPwd" placeholder="用户密码">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">用户名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="editUserName" name="userName" placeholder="用户名称">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">用户头像</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="editUserImg" name="userImg" placeholder="用户头像">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">用户角色</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="editRoleId" name="roleId" placeholder="角色名称">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-default">确定</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    function editSysUser(roleId) {
        $.ajax({
            type: "GET",//请求类型
            url: "getsysuserbyid",//请求的url
            data: {id: roleId},//请求参数
            dataType: "json",//ajax接口（请求url）返回的数据类型
            success: function (data) {//data：返回数据（json对象）
                $("#editUserId").val(data.id);
                $("#editUserCode").val(data.userCode);
                $("#editUserName").val(data.userName);
                $("#editUserPwd").val(data.userPwd);
                $("#editUserImg").val(data.userImg);
                $("#editRoleId").val(data.roleId);
                $("#editModal").modal();
            }
        });
    }

    function delSysUser(userId) {
        $("#sysUserId").val(userId);
        $("#delModal").modal();
    }

    $(function () {
        $("#dataTable").dataTable({
            bProcessing: true, //DataTables 载入数据时，是否显示‘进度’提示
            bAutoWidth: false, //自动宽度
            bSort: false, //排序功能
            bInfo: true, //页脚信息,默认为 true
            bStateSave: true, //状态保存
            sPaginationType: "full_numbers", //分页显示样式
            serverSide: true, //启用服务器分页
            sAjaxSource: "sysUserListPage", //服务端请求数据接口
            searching: false, //关闭 datatables 的搜索框
            destroy: true, //解决重新渲染问题
            iDisplayLength: 10, //每页显示数量
            // 自定义参数
            // fnServerParams: function(aoData){
            //     aoData.push(
            //         {
            //             name: "current",
            //             value: p
            //         }
            //     );
            // },

            // post 方法提交
            fnServerData: function (sSource, aoData, fnCallback) {
                $.ajax({
                    type: 'post',
                    url: sSource,
                    dataType: 'json',
                    data: aoData,
                    success: function (res) {
                        fnCallback(res);
                    }
                });
            },

            aoColumns: [
                {"data": "id"},
                {"data": "userCode"},
                {"data": "userName"},
                {"data": "userImg"},
                {"data": "roleName"},
                {
                    "sTitle": '操作',
                    "orderable": false,
                    'render': function (data, type, row) {
                        let id = row.id;
                        let optdom = "<a class='btn btn-primary' onclick='editSysUser(" + id + ")'    data-toggle='modal' > " +
                            "<i class='fas fa-edit' ></i> 编辑</a>" +
                            "<a class='btn btn-danger ' onclick='delSysUser("+id+")' data-toggle='modal' >" +
                            " <i class='fas fa-times'></i> 删除</a>";
                        return optdom;
                    }
                }
            ],
            oLanguage: { //国际化配置
                sProcessing: "正在获取数据，请稍后...",
                sLengthMenu: "",
                sZeroRecords: "没有您要搜索的内容",
                sInfo: "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
                sInfoFiltered:"",
                sInfoEmpty: "记录数为0",
                sInfoPostFix: "",
                sSearch: "从当前数据中检索： ",
                sUrl: "",
                oPaginate: {
                    sFirst: "首页",
                    sPrevious: "上一页",
                    sNext: "下一页",
                    sLast: "尾页"
                }
            }
        });
    })
</script>
