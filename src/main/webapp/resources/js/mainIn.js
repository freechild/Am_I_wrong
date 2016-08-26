function ee(i){
//	var i = $(this).attr('id');
	alert(i);
}


$(document).ready(function(){
	$.ajax({
		url:'/calendar'	
	}).done(function(data){
		data = eval("(" + data + ")");
		$('.arrow-btn-container').html('<a class="arrow-btn left" href="#202"><span class="icon fontawesome-angle-left"></span></a>');
		$('#calendar').text(data.year+"/"+data.month);
//		$('.arrow-btn-container').append('<h2 class="titular" id="calendar"></h2>');
//		$('.arrow-btn-container').append('<a class="arrow-btn right" href="#203"><span class="icon fontawesome-angle-right"></span></a>');
		
		var line = 0;
		$('.calendar_N').html('<tr>')
		for(i=1 ;i< data.firstDay;++i){
			$('.calendar_N').append('<td></td>')
			++line;
		}
		  for(i=1; i<=data.lastDay; ++i) {
              var date = data.year+"/"+data.month+"/"+i;
			  $('.calendar_N').append("<td><a class='scnd-font-color' id=i href='javascript:ee(\"" +date+"\")'>"+ i +"</a></td>")
             
              line+=1;
              if(line==7 && i!=data.lastDay) {
                  $('.calendar_N').append('</tr><tr>')
                  line = 0;
              }
          }
	
	});

	
	
});
