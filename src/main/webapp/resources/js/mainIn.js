function pop(){
	$("#overlay").show("slow");
	$("#overlay").fadeTo(100, .3);
	$('.joinForm').show();
	$('.joinForm').center();
}

function event(i){
	pop();
	$('.joinForm').html("<h1>Event</h1>");					
	$('.joinForm').append("<span id='img_tag'><a href='javascript:pop_hide()'><img src='/resources/Image/ic_clear.png'></a></span>");
	$('.joinForm').append("<p>" + i + "</p>");
	$('.joinForm').append("<br><br>");
	$('.joinForm').append("<label class='findthing'><a href='javascript:event_add(\""+i+"\")'><img src='/resources/Image/ic_event_available_2x.png'></a><span class='small'>일정 추가</span></label>");
	$('.joinForm').append("<label class='findthing'><a href='javascript:beforeEvent(\""+i+"\")'><img src='/resources/Image/ic_event_note_2x.png'></a><span class='small'> 일정 보기</span></label>");
	$('.joinForm').append("<label class='findthing'><a href='javascript:addPerson(\"Welcom\")'><img src='/resources/Image/ic_person_add_2x.png'></a><span class='small'>자세히 보기</span></label>");
}

function beforeEvent(i){
	pop();
	$('.joinForm').html("<h1>일정확인</h1>");
	$('.joinForm').append("<span id='img_tag'><a href='javascript:pop_hide()'><img src='/resources/Image/ic_clear.png'></a></span>");
	$('.joinForm').append("<p>" + i + "</p>");
}

function event_add(i){
	$('.joinForm').html("<h1>Event ADD</h1>");					
	$('.joinForm').append("<span id='img_tag'><a href='javascript:pop_hide()'><img src='/resources/Image/ic_clear.png'></a></span>");
	$('.joinForm').append("<p>" + i + "</p>");
	$('.joinForm').append('<textarea rows="8" cols="60" id="b_modiContent"></textarea>');
	$('.joinForm').append("<span id='img_tag'><a href='javascript:event_addOk(\""+i+"\")'><img src='/resources/Image/ic_done.png'></a></span>");
}




function cal_date(data){
	data = eval("(" + data + ")");
	var date = data.year+"/"+data.month;
	var today = data.today;
	$('.arrow-btn-container').html("<a class='arrow-btn left' href='javascript:cal_down(\""+date+"\")'><span class='icon fontawesome-angle-left'></span></a>");
	$('.arrow-btn-container').append('<h2 class="titular" id="calendar">'+data.year+'/'+data.month+'</h2>')
	$('.arrow-btn-container').append('<h2 class="titular" id="calendar"></h2>');
	$('.arrow-btn-container').append("<a class='arrow-btn right' href='javascript:cal_up(\""+date+"\")'><span class='icon fontawesome-angle-right'></span></a>");
	var line = 0;
	$('.calendar_N').html('<tr>')
	for(i=1 ;i< data.firstDay;++i){
		$('.calendar_N').append('<td></td>')
		++line;
	}
	  for(i=1; i<=data.lastDay; ++i) {
		  if(i<10){
			  var date = data.year+"/"+data.month+"/0"+i;			  
		  }else var date = data.year+"/"+data.month+"/"+i;
 
          var d1 = date.replace("/","");
          var d2 = d1.replace("/",""); 
          var t1 = today.replace("/","");
          var t2 = t1.replace("/",""); 
          if(d2>=t2){
        	  if(today == date)
        		  $('.calendar_N').append("<td><a class='today' href='javascript:event(\"" +date+"\")'>"+ i +"</a></td>")  
        	  else
        		  $('.calendar_N').append("<td><a class='scnd-font-color'href='javascript:event(\"" +date+"\")'>"+ i +"</a></td>")        		  
          }
         else
        	 $('.calendar_N').append("<td><a class='scnd-font-color'href='javascript:beforeEvent(\"" +date+"\")')'>"+ i +"</a></td>");        		  
        
          line+=1;
          if(line==7 && i!=data.lastDay) {
              $('.calendar_N').append('</tr><tr>')
              line = 0;
          }
      }
}	

function cal_ajax(subStr){
	$.ajax({
		url:'/calendar',
		data:{
			'year' : subStr[0],
			'month': subStr[1]
		}	
	}).done(function(date){
		cal_date(date);
	})
}

function cal_down(date){
	var subStr = date.split('/');
	subStr[1] -=1;
//	alert(subStr[1]);
	cal_ajax(subStr);
}
function cal_up(date){
	var subStr = date.split('/');
	subStr[1] = (subStr[1] -1 +2);
	cal_ajax(subStr);
}



$(document).ready(function(){
	$.ajax({
		url:'/calendar'	
	}).done(function(date){
		cal_date(date);
	});
	
});
