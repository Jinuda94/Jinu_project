/**
 * 
 */
function createFrom(obj){
	if(obj.UserID.value ==""){
		alert("아이디를 반드시 입력하세요.");
		obj.UserID.focus();
		return false;
	}
	
	if(obj.UserPassword.value ==""){
		alert("비밀번호를 반드시 입력하세요.");
		obj.UserPassword.focus();
		return false;
	}
	
	if(obj.UserPassword.value.length < 8){
		alert("비밀번호는 8글자 이상으로 만들어주세요.");
		obj.UserPassword.focus();
		return false;
	}
	
	if(obj.UserPasswordCheck.value ==""){
		alert("비밀번호 확인란에 입력해주세요.");
		obj.passwordCheck.focus();
		return false;
	}
	
	if(obj.UserPassword.value != obj.UserPasswordCheck.value){
		alert("입력하신 비밀번호가 같지 않습니다.");
		obj.UserPasswordCheck.focus();
		return false;
	}
	
	if(obj.UserName.value ==""){
		alert("이름을 반드시 입력하세요.");
		obj.UserName.focus();
		return false;
	}
	
	if(obj.UserEmail.value ==""){
		alert("이메일을 입력하세요.");
		obj.UserEmail.focus();
		return false;
	}

	var check = false;
	for(var i=0;i<obj.mailing.length;i++){
		if(obj.mailing[i].checked==true) check=true;
	}

	if(obj.mailing.value ==""){
		alert("메일수신 여부를 체크해주세요.");
		obj.mailing.focus();
		return false;
	}
	check = false;
	var str="";
	for(var i=0; i<obj.interest.length; i++){
		if(obj.interest[i].checked==true){
			str+=obj.interest[i].value + ",";
		}	
	}	
}
function idCheck(obj, root){

	if(obj.UserID.value ==""){
		alert("아이디를 반드시 입력하세요.");
		obj.id.focus();
		return false;
	}else{
		let url = root + "/IDcheck?UserID=" + obj.UserID.value;
		window.open(url, "", "width=400, height=200");
	}
}
