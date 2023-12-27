function inputCheck(){
	// regForm태그의 id가 id인 값이 빈값이라면
	if(document.regForm.id.value=="") {
		alert("아이디를 입력해 주세요");
		// id를 입력하게 포커스를 맞춤
		document.regForm.id.focus();
		return;
	}
	
	
	if(document.regForm.pwd.value=="") {
		alert("비밀번호를 입력해 주세요");
		document.regForm.pwd.focus();
		return;
	}
	
	if(document.regForm.pwd2.value=="") {
		alert("비밀번호 확인를 입력해 주세요");
		document.regForm.pwd2.focus();
		return;
	}
	
	if(document.regForm.name.value=="") {
		alert("이름를 입력해 주세요");
		document.regForm.name.focus();
		return;
	}
	
	if(document.regForm.birth.value=="") {
		alert("생년월일를 입력해 주세요");
		document.regForm.birth.focus();
		return;
	}
	
	if(document.regForm.email.value=="") {
		alert("이메일를 입력해 주세요");
		document.regForm.email.focus();
		return;
	}
	
	if(document.regForm.pwd.value != document.regForm.pwd2.value){
		alert("비밀번호가 일치하지 않습니다")
		document.regForm.pwd2.focus();
		return;
	}
	
	document.regForm.submit();
}