	var editable = true;

	$(document).ready(function(){
		editable = true;
		$("#editArea").attr('contentEditable',true);		
		$("#editArea").focus();
	});
	
	
	$("#editArea").keypress(function(ev){
	    if(ev.which == 13) {
	        document.execCommand('formatBlock', false, 'p');
	    }
	});
	
	$("#editToggleButton").click(function() {
		if(editable) {
			$("#editToggleButton").html("수정하기");
			$("#editArea").attr('contentEditable',false);		
			editable = false;
		} else {
			$("#editToggleButton").html("저장하기");
			$("#editArea").attr('contentEditable',true);		
			$("#editArea").focus();
			editable = true;
		}
	});	

	$("#insertTextButton").click(function() {
		$("#insertTextWrapper").toggle();	
	});	
	
	$("#removeTextTagButton").click(function() {
		$("#insertTextArea").html($("#insertTextArea").html().replace(/(<([^>]+)>)/gi, ""));
	});
	
	$("#insertImageButton").click(function() {
		var range = window.getSelection().getRangeAt(0); 
		var newElement = document.createElement('br');
		range.insertNode(newElement);
	});
	
	$(function(){
	    //ajax form submit
	    $('#fileUploadForm').ajaxForm({
	            beforeSubmit: function (data,form,option) {
	                //validation체크 
	                //막기위해서는 return false를 잡아주면됨
	                return true;
	            },
	            success: function(response,status){
	                //성공후 서버에서 받은 데이터 처리
	                insertImageTag(response);
	            },
	            error: function(){
	                //에러발생을 위한 code페이지
	            }                               
	        });
	});
	
	function insertImageTag(path) {
		alert(path);
		var range = window.getSelection().getRangeAt(0);
		var newElement = document.createElement('img');
		newElement.setAttribute('src', path);
		newElement.setAttribute('width', '100');
		newElement.setAttribute('height', '100');
		range.insertNode(newElement);
	}
