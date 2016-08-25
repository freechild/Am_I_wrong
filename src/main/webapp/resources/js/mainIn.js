function ee(i){
		alert();
}


$(document).ready(function(){
	$.ajax({
		url:'/calendar'	
	}).done(function(data){
		data = eval("(" + data + ")");
		var date = data.year+"" +"/"+data.month+"" +"/";
		$('#calendar').text(data.year+"/"+data.month);
		alert(date);
		var line = 0;
		$('.calendar_N').html('<tr>')
		for(i=1 ;i< data.firstDay;++i){
			$('.calendar_N').append('<td></td>')
			++line;
		}
		  for(i=1; i<=data.lastDay; ++i) {
              
			  $('.calendar_N').append('<td><a class="scnd-font-color" href="javascript:ee('
					  +date+(i+"")+')">'+ i +'</a></td>')
             
              line+=1;
              if(line==7 && i!=data.lastDay) {
                  $('.calendar_N').append('</tr><tr>')
                  line = 0;
              }
          }
	
	});

	
	
});
