$().ready(function() {
	$('.summernote').summernote({
		height : '220px',
		lang : 'zh-CN',
        callbacks: {
            onImageUpload: function(files, editor, $editable) {
                console.log("onImageUpload");
                sendFile(files);
            }
        }
    });
	var content = $("#content").val();

	$('#content_sn').summernote('code', content);
	$.ajax({
		// get请求地址
		url : "/common/dict/list/blog_type",
		dataType : "json",
		success : function(data) {
			var optArr = [];
			for (var i = 0; i < data.length; i++) {
				if(oldCategories == data[i].value){
					$('.selectpicker').append(
							"<option selected='selected' value=" + data[i].value + ">"
									+ data[i].name + "</option>");
				}
				else{
					$('.selectpicker').append(
							"<option value=" + data[i].value + ">"
									+ data[i].name + "</option>");
				}
				
			}

		}
	});
	
	layui.use('upload', function () {
        var upload = layui.upload;
        //执行实例
        var uploadInst = upload.render({
            elem: '#btnUpload', //绑定元素
            url: '/common/sysFile/upload', //上传接口
            size: 10000,
            accept: 'file',
            done: function (r) {
                layer.msg(r.msg);
                
                var d = '<a class="btn btn-warning btn-sm '+'" href="#" title="删除"  mce_href="#" onclick="removeAttatch(\''
				+ r.fid
				+ '\')"><i class="fa fa-remove"></i></a> ';
                $('#attatchList').append("<span id='attatch"+r.fid+"'>"+r.originalName+" "+d+"</span>");
                var attatch = $('#attatch').val();
                attatch += r.fid+",";
                $('#attatch').val(attatch);
            },
            error: function (r) {
                layer.msg(r.msg);
            }
        });
    });
	
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save(status) {
	$("#status").val(status);

	var content_sn = $("#content_sn").summernote('code');
	$("#content").val(content_sn);
	$.ajax({
		cache : true,
		type : "POST",
		url : "/blog/bContent/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(r) {
			if (r.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				$("#cid").val(r.cid);
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);

			} else {
				parent.layer.alert(r.msg)
			}

		}
	});

}

function removeAttatch(fid){
	layer.confirm('确定要删除此附件？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : "/common/sysFile/remove",
			type : "post",
			data : {
				'id' : fid
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					var obj = $('#attatch'+fid);
					obj.remove();
					var attatchStr = $('#attatch').val();
					attatchStr = attatchStr.replace(fid+",","");
					$('#attatch').val(attatchStr);
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
	
}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			}
		}
	})
}

function returnList() {
	var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
	parent.layer.close(index);
}

