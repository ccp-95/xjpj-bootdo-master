$().ready(
		function() {

			$('.summernote').summernote({
				height : '220px',
				lang : 'zh-CN',
				callbacks : {
					onImageUpload : function(files, editor, $editable) {
						sendFile(files);
					}
				}
			});
			validateRule();

			$.ajax({
				// get请求地址
				url : "/common/dict/list/blog_type",
				dataType : "json",
				success : function(data) {
					var optArr = [];
					for (var i = 0; i < data.length; i++) {
						$('.selectpicker').append(
								"<option value=" + data[i].value + ">"
										+ data[i].name + "</option>");
					}

				}
			});
		});

$.validator.setDefaults({
	submitHandler : function() {
		save(1);
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
				parent.layer.msg(r.msg);
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
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			title : "required",
			content : "required"
		},
		messages : {
			title : "请填写文章标题",
			content : "请填写文章内容"
		}
	});
}

function returnList() {
	var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
	parent.layer.close(index);
}