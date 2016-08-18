function formCheck(obj){
	if(!obj.name.value){
		alert('이름은 반드시 입력해야 합니다.');
		obj.name.focus();
		return false;
	}
	
	if(!obj.pw.value){
		alert('암호는 반드시 입력해야 합니다.');
		obj.pw.focus();
		return false;
	}
	
	if(!obj.title.value){
		alert('제목은 반드시 입력해야 합니다.');
		obj.title.focus();
		return false;
	}
	
	if(!obj.content.value){
		alert('내용은 반드시 입력해야 합니다.');
		obj.content.focus();
		return false;
	}
	return true;
}