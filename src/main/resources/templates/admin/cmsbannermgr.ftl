<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台管理</title>
    <#include  "common/css.ftl">
    <link rel="stylesheet" type="text/css" href="css/lib/fileinput.min.css">
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
                        <h1>横幅列表</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">首页</a></li>
                            <li class="breadcrumb-item active">内容管理</li>
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
                                <h3 class="card-title">横幅列表</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <div class="row mb-2">
                                    <div class="col-sm-3">
                                        <a class="btn btn-primary addModal" data-toggle="modal" >
                                            <i class="fas fa-plus"></i> 添加
                                        </a>
                                    </div>
                                </div>

                                <table id="dataTable" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>横幅图片</th>
                                        <th>横幅标签</th>
                                        <th>横幅描述</th>
                                        <th>创建时间</th>
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
<script type="text/javascript" src="/js/fileinput.min.js"></script>
</body>
</html>

<div id="delModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="delCmsBanner" method="post">
                <input type="hidden" id="bannerId" name="id">
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
            <form action="addCmsBanner" method="post">
                <div class="modal-header">
                    <h4 id="addModalLabel" class="modal-title">添加横幅</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">横幅标签</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="bannerLabel" name="bannerLabel" placeholder="横幅标签">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">横幅描述</label>
                        <div class="col-sm-10">
                            <textarea id="bannerDesc" name="bannerDesc"  class="form-control" rows="3" placeholder="横幅描述"></textarea>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="id_title_url" class="col-sm-2 col-form-label">横幅图片</label>
                        <div class="col-sm-8">
                            <label class="control-label" for="bannerImgUpd">上传文件</label>
                            <input type="file" id="bannerImgUpd" name="file" class="file-loading" />
                            <input type="hidden" id="bannerImg" name="bannerImg" />
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
            <form action="updCmsBanner" method="post">
                <input type="hidden" id="editBannerId" name="id">
                <div class="modal-header">
                    <h4 id="addModalLabel" class="modal-title">修改角色</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">横幅标签</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="eidtBannerLabel" name="bannerLabel" placeholder="横幅标签">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">横幅描述</label>
                        <div class="col-sm-10">
                            <textarea id="editBannerDesc" name="bannerDesc"  class="form-control" rows="3" placeholder="横幅描述"></textarea>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="id_title_url" class="col-sm-2 col-form-label">横幅图片</label>
                        <div class="col-sm-8">
                            <label class="control-label" for="bannerImgUpd">上传文件</label>
                            <input type="file" id="editBannerImgUpd" name="file" class="file-loading" />
                            <input type="hidden" id="editBannerImg" name="bannerImg" />
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
    function initEditFileInput(bannerImage){
        $('#editBannerImgUpd').fileinput('destroy');
        $('#editBannerImgUpd').fileinput({
            language: 'zh',
            uploadUrl: '/admin/upload',
            showCaption: true,
            showUpload: false,
            showRemove: false,
            showClose: false,
            layoutTemplates:{
                actionDelete: ''
            },
            initialPreview: [
                '<img width="180" src="'+bannerImage+'" />'
            ],
            enctype: 'multipart/form-data',
            allowedFileExtensions: ['jpg','gif','png'],
            browseClass: 'btn btn-primary'
        }).on('filebatchselected', function (event, files) {//选中文件事件
            $(this).fileinput("upload");
        });
        //图片上传成功后的代码
        $("#editBannerImgUpd").on("fileuploaded", function (event, data, previewId, index) {
            //  console.log(data.response.pathurl);
            $("#editBannerImg").val(data.response.pathurl);
        });
    }
    function initAddFileInput(){
        $('#bannerImgUpd').fileinput('destroy');
        $('#bannerImgUpd').fileinput({
            language: 'zh',
            uploadUrl: '/admin/upload',
            showCaption: true,
            showUpload: false,
            showRemove: false,
            showClose: false,
            layoutTemplates:{
                actionDelete: ''
            },
            enctype: 'multipart/form-data',
            allowedFileExtensions: ['jpg','gif','png'],
            browseClass: 'btn btn-primary'
        }).on('filebatchselected', function (event, files) {//选中文件事件
            $(this).fileinput("upload");
        });
        //图片上传成功后的代码
        $("#bannerImgUpd").on("fileuploaded", function (event, data, previewId, index) {
            //  console.log(data.response.pathurl);
            $("#bannerImg").val(data.response.pathurl);
        });
    }
    function addModalClick(){
        initAddFileInput();
    }
    function editCmsBanner(bannerId) {
        $.ajax({
            type: "GET",//请求类型
            url: "getCmsBannerById",//请求的url
            data: {id: bannerId},//请求参数
            dataType: "json",//ajax接口（请求url）返回的数据类型
            success: function (data) {//data：返回数据（json对象）
                $("#editBannerId").val(data.id);
                $("#eidtBannerLabel").val(data.bannerLabel);
                $("#editBannerDesc").val(data.bannerDesc);
                $("#editBannerImg").val(data.bannerImg);
                initEditFileInput(data.bannerImg);
                $("#editModal").modal();
            }
        });
    }
    function delCmsBanner(bannerId) {
        $("#bannerId").val(bannerId);
        $("#delModal").modal();
    }
    $(function () {
        $(".addModal").click(function (){
            addModalClick();
            $("#addModal").modal();
        });
        $("#dataTable").dataTable({
            bProcessing: true, //DataTables 载入数据时，是否显示‘进度’提示
            bAutoWidth: false, //自动宽度
            bSort: false, //排序功能
            bInfo: true, //页脚信息,默认为 true
            bStateSave: true, //状态保存
            sPaginationType: "full_numbers", //分页显示样式
            serverSide: true, //启用服务器分页
            sAjaxSource: "cmsBannerListPage", //服务端请求数据接口
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
                // {"data": "bannerImg"},
                {
                    "sTitle": '横幅图片',
                    "orderable": false,
                    'render': function (data, type, full) {
                        let imgDom = "<img src='"+full.bannerImg+"' width='200px' />";
                        return imgDom;
                    }
                },
                {"data": "bannerLabel"},
                {"data": "bannerDesc"},
                {"data": "createDate"},
                {
                    "sTitle": '操作',
                    "orderable": false,
                    'render': function (data, type, row) {
                        let id = row.id;
                        let optdom = "<a class='btn btn-primary' onclick='editCmsBanner(" + id + ")'    data-toggle='modal' > " +
                            "<i class='fas fa-edit' ></i> 编辑</a>" +
                            "<a class='btn btn-danger ' onclick='delCmsBanner("+id+")' data-toggle='modal' >" +
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
