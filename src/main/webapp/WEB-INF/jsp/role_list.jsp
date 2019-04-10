<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="roleList" title="用户列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'role/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_role">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'roleId',align:'center',width:150">角色编号</th>
        <th data-options="field:'roleName',align:'center',width:150">角色名</th>
        <th data-options="field:'authority',align:'center',width:150,formatter:formatRole">权限</th>
        <th data-options="field:'available',width:150,align:'center',formatter:formatRoleStatus">状态</th>
    </tr>
    </thead>
</table>

<div  id="toolbar_role" style=" height: 22px; padding: 3px 11px; background: #fafafa;">

    <c:forEach items="${sessionScope.sysPermissionList}" var="per" >
        <c:if test="${per=='role:add' }" >
            <div style="float: left;">
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="role_add()">新增</a>
            </div>
        </c:if>
        <c:if test="${per=='role:edit' }" >
            <div style="float: left;">
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="role_edit()">编辑</a>
            </div>
        </c:if>
        <c:if test="${per=='role:delete' }" >
            <div style="float: left;">
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="role_delete()">删除</a>
            </div>
        </c:if>
    </c:forEach>

    <div class="datagrid-btn-separator"></div>

    <div style="float: left;">
        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="role_reload()">刷新</a>
    </div>

    <div id="search_role" style="float: right;">
        <input id="search_text_role" class="easyui-searchbox"
               data-options="searcher:doSearch_role,prompt:'请输入...',menu:'#menu_role'"
               style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_role" style="width:120px">
            <div data-options="name:'roleId'">角色编号</div>
            <div data-options="name:'roleName'">角色名称</div>
        </div>
    </div>

</div>

<div id="roleEditWindow" class="easyui-window" title="编辑角色" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'role/edit'" style="width:45%;height:60%;padding:10px;">
</div>
<div id="roleAddWindow" class="easyui-window" title="添加角色" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'role/add'" style="width:45%;height:60%;padding:10px;">
</div>
<div id="userRoleWindow" class="easyui-window" title="添加用户" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'user/role'" style="width:45%;height:60%;padding:10px;">
</div>

<script>
    function doSearch_role(value,name){ //用户输入用户名,点击搜素,触发此函数
        if(value == null || value == ''){
            $("#roleList").datagrid({
                title:'角色列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
                nowrap:true, toolbar:"toolbar_role", url:'role/list', method:'get', loadMsg:'数据加载中......',
                fitColumns:true,
                columns : [ [
                    {field : 'ck', checkbox:true },
                    {field : 'roleId', width : 150, align:'center', title : '角色编号'},
                    {field : 'roleName', width : 150, align : 'center', title : '角色名'},
                    {field : 'available', width : 150, title : '状态', align:'center', formatter:formatRoleStatus}
                ] ],
            });
        }else{
            $("#roleList").datagrid({
                title:'角色列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
                nowrap:true, toolbar:"toolbar_role", url:'role/search_role_by_'+name+'?searchValue='+value,
                loadMsg:'数据加载中......', fitColumns:true,
                columns : [ [
                    {field : 'ck', checkbox:true },
                    {field : 'roleId', width : 150, align:'center', title : '角色编号'},
                    {field : 'roleName', width : 150, align : 'center', title : '角色名'},
                    {field : 'available', width : 150, title : '状态', align:'center', formatter:formatRoleStatus}
                ] ],
            });
        }
    }

    function formatRoleStatus(value){
        if (value == 1){
            return '有效';
        }else if(value == 2){
            return '<span style="color:red;">无效</span>';
        }else {
            return '<span style="color:#E5B717;">未知状态</span>';
        }
    }

    //根据index拿到该行值
    function onRoleClickRow(index) {
        var rows = $('#roleList').datagrid('getRows');
        return rows[index];

    }

    //格式化角色信息
    function formatRole(value, row, index){
        return "<a href=javascript:openRole("+index+")>"+row.roleName+"</a>";
    };

    //打开角色信息
    function  openRole(index){
        var row = onUserClickRow(index);
        $.get("role/get/"+row.roleId,'',function(data){
            $("#userRoleWindow").window({
                onLoad :function(){
                    //回显数据
                    $("#userRoleEditForm").form("load", data);
                    userPermissionInit();
                }
            }).window("open");
        });
    };

    function submitUserRoleEditForm(){
        if(!$('#userRoleEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }

        if($("input[name='permissionOption3']:checked").length>0){
            var permission = '';
            $("input[name='permissionOption3']:checked").each(function(){
                permission += $(this).val()+',';
            });
            $("#userRoleEditForm [name=permission]").val(permission);
        }
        $.post("role/update_all",$("#userRoleEditForm").serialize(), function(data){
            if(data.label == 200){
                $.messager.alert('提示', data.msg);
                $("#userRoleInfo").dialog("close");
            }else{
                $.messager.alert('提示', data.msg);
            }
        });
    }

    function getRoleSelectionsIds(){
        var roleList = $("#roleList");
        var sels = roleList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].id);
        }
        ids = ids.join(",");

        return ids;
    }

    function role_add(){
        $.get("role/add_judge",'',function(data){
            if(data.msg != null){
                $.messager.alert('提示', data.msg);
            }else{
                $("#roleAddWindow").window("open");
            }
        });
    }

    function role_edit(){
        $.get("role/edit_judge",'',function(data){
            if(data.msg != null){
                $.messager.alert('提示', data.msg);
            }else{
                var ids = getRoleSelectionsIds();

                if(ids.length == 0){
                    $.messager.alert('提示','必须选择一个角色才能编辑!');
                    return ;
                }
                if(ids.indexOf(',') > 0){
                    $.messager.alert('提示','只能选择一个角色!');
                    return ;
                }

                $("#roleEditWindow").window({
                    onLoad :function(){
                        //回显数据
                        var data = $("#roleList").datagrid("getSelections")[0];
                        $("#roleEditForm").form("load", data);
                    }
                }).window("open");
            }
        });
    }

    function role_delete(){
        $.get("role/delete_judge",'',function(data){
            if(data.msg != null){
                $.messager.alert('提示', data.msg);
            }else{
                var ids = getRoleSelectionsIds();
                if(ids.length == 0){
                    $.messager.alert('提示','未选中角色!');
                    return ;
                }
                $.messager.confirm('确认','确定删除ID为 '+ids+' 的用户吗？',function(r){
                    if (r){
                        var params = {"ids":ids};
                        $.post("role/delete_batch",params, function(data){
                            if(data.status == 200){
                                $.messager.alert('提示','删除用户成功!',undefined,function(){
                                    $("#roleList").datagrid("reload");
                                });
                            }
                        });
                    }
                });
            }
        });
    }

    function role_reload(){
        $("#roleList").datagrid("reload");
    }
</script>