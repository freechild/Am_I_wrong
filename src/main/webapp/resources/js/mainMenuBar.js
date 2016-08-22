function Tmenu_bar(obj){
	whichBtn = $('#' + obj).attr('id');
	var session = $('#scope').val();
	var test = session + "/" + whichBtn;
//	alert(test);
	$(location).attr('href',test);
//	$.ajax({
//		
//	})
}