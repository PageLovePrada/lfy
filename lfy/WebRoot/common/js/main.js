//气球特效初始参数
	var LeiArrIndex=0
	var LeiColor="black";
	//点击气球特效间隔
	var balloonClick = false;
	//原始数据
	var mapMain = new Map();
	//加载大王的网址
	$.each($.parseJSON($.ajax({url: "dataSource/King.map",async:false}).responseText + "}"),function(key,value){
		mapMain[key]=value
	})  
	//显示数据
	var mapShow = new Map();
	//显示数据
	function dataFilter(selector,page){
		mapShow = new Map();
		//有过滤条件
		//过滤显示数据
		$.each(mapMain,function(key,value){
			//名称网址模糊筛选
			if(key.toLowerCase().indexOf(selector)>-1 || value.toLowerCase().indexOf(selector)>-1){
				mapShow[key]=value
			}
		})
			
		var pageMax = Math.ceil(Object.keys(mapShow).length / 7)
		initPage(pageMax);
		showData(mapShow,page,pageMax);
	}
	//加载分页
	function initPage(pageMax){
			$('#pageBar').pagination({
				pageCount : pageMax,
				jump : true,
				coping : true,
				homePage : '首页',
				endPage : '末页',
				mode : 'fixed',
				callback : function(api) {
					showData(mapShow,api.getCurrent());
				}
			});
	}
	//显示数据
	function showData(mapShow,page,pageMax){
		var i = 0;
		var tbWriter = '';
		$.each(mapShow,function(key,value){
			//当前页的数据
			if(i >= (page-1)*7 && i < page*7){
				tbWriter+=
				'<tr class="event-bgColor">'+
				'<td title="'+key+'">'+key+'</td>'+
				'<td title="'+value+'">'+value+'</td>'+
				'</tr>';
			}
			i++;
		})
		$("#tbContent").html(tbWriter);
		//添加时间
		$('#table tr').on('mouseover', function() {
			//表格行鼠标移入
			$(this).attr('class', 'event-bgColor hover-bgColor');
		}).on('mouseout', function() {
			//表格行鼠标移出
			$(this).attr('class', 'event-bgColor');
		}).on('click', function() {
			//表格行鼠标点击
			if($(this).children("td")[1]){
				window.open($(this).children("td")[1].title);
			}
		});
		
   
		
		
		$('html').on('click', function(e) {
			if(balloonClick){return false;}
			balloonClick = true;
			setTimeout(function(){balloonClick=false;},2000)
	        var LeiArr = new Array("钱大漂亮", "钱大美丽", "钱大善良","钱温柔","钱多多","编不下去了..");
	        var LeiColorArr = new Array("#FFFF00", "#F5F5DC", "#EEDC82","#FF8247","#E0FFFF","#CD5C5C");
	        var spanText = $("<span></span>").text(LeiArr[LeiArrIndex]);  
	        LeiArrIndex = Math.round(Math.random() * LeiArr.length + 1);
	        LeiColor = "#F"+Math.round(Math.random()*9)+Math.round(Math.random()*9)+Math.round(Math.random()*9)+Math.round(Math.random()*9)+Math.round(Math.random()*9);
	        var x = e.pageX, 
	        y = e.pageY; 
	        spanText.css({ 
	            "z-index": 9999999, 
	            "top": y - 20, 
	            "left": x, 
	            "position": "absolute", 
	            "font-weight": "bold", 
	            "color": LeiColor 
	        }); 
	        $("body").append(spanText); 
	        spanText.animate({ 
	            "top": y - 180, 
	            "opacity": 0 
	        }, 
	        1500, 
	        function() { 
	            spanText.remove(); 
	        }); 
   
		});
	}
	
//获取鼠标位置
function getMousePos(event) {
      var e = event || window.event;
      return {'x':e.screenX,'y':screenY}
}
//气球特效
function showBalloon(type){
	setInterval(function(){
        var LeiArr = new Array("钱大漂亮", "钱大美丽", "钱大善良","钱温柔","钱多多","编不下去了..");
        var LeiColorArr = new Array("#FFFF00", "#F5F5DC", "#EEDC82","#FF8247","#E0FFFF","#CD5C5C");
        var spanText = $("<span></span>").text(LeiArr[LeiArrIndex]);  
        LeiArrIndex = Math.round(Math.random() * LeiArr.length + 1);
        LeiColor = "#F"+Math.round(Math.random()*9)+Math.round(Math.random()*9)+Math.round(Math.random()*9)+Math.round(Math.random()*9)+Math.round(Math.random()*9);
        var x =  Math.round(Math.random()*1200+1), 
        y = Math.round(Math.random()*400+1); 
        spanText.css({ 
            "z-index": 9999999, 
            "top": y - 20, 
            "left": x, 
            "position": "absolute", 
            "font-weight": "bold", 
            "color": LeiColor 
        }); 
        $("body").append(spanText); 
        spanText.animate({ 
            "top": y - 180, 
            "opacity": 0 
        }, 
        1500, 
        function() { 
            spanText.remove(); 
        }); 
	},5000)
}
//时钟
var hour=document.getElementById('hour');
var minute=document.getElementById('minute');
var second=document.getElementById('second');
function showTime(){
	var oDate=new Date();
	var iHours=oDate.getHours();
	var iMinute=oDate.getMinutes();
	var iSecond=oDate.getSeconds();
	hour.innerHTML=AddZero(iHours);
	minute.innerHTML=AddZero(iMinute);
	second.innerHTML=AddZero(iSecond);
}
function AddZero(n){
	if(n<10){
		return '0'+n;
	}
	return ''+n;
}
//鼠标格式主题
function mouseStyle(){var a,b = 1;}

//加载完成
$(function() {
	//加载全部数据
	$("#searchBtn").val("");
	dataFilter("",1);
	//搜素
	$("#searchBtn").on('input',function(){
		dataFilter($("#searchBtn").val(),1);
	//挡板显示
	}).on('focus',function(){
		$(".searchAll").show();
	//挡板隐藏
	}).on('blur',function(){
		setTimeout(function(){$(".searchAll").hide()},300)
		
	});
	//点击全部
	$(".searchAll").on('click',function(){
		$("#searchBtn").val("");
		dataFilter("",1);
	});
	//鼠标移入查询
	$(".searchBtn").on('mouseover',function(){
		$("#searchBtn").focus();
	});
	//滚轮翻页
	$(document).on("mousewheel DOMMouseScroll", function (e) {
	    var delta = (e.originalEvent.wheelDelta && (e.originalEvent.wheelDelta > 0 ? 1 : -1)) ||  // chrome & ie
	                (e.originalEvent.detail && (e.originalEvent.detail > 0 ? -1 : 1));              // firefox
	    if (delta > 0) {
	        // 向上滚
	        $(".prev").click();
	    } else if (delta < 0) {
	        // 向下滚
	        $(".next").click();
	    }
	});
	//添加数据
	$(".addURL").on('click',function(){
		swal.mixin({
				  input: 'text',
				  confirmButtonText: '下一步',
				  cancelButtonText: '取消',
				  showCancelButton: true,
				  progressSteps: ['1', '2']
				}).queue([
				  {
				    title: '描述'
				  },
				  '网址'
				]).then((result) => {
						$.ajax({
						type:"POST",
						url:"insertURL.do",
						data:{key : result.value[0], value : result.value[1]},
						success:function(data){
								if(data==1){
								swal({
									  title: "添加成功!",
									  text: "",
									  type: "success"
									})
									.then((willDelete) => {
										window.location.reload()
									});
								}else{
                       				swal("未添加成功!","","error");
								}
							},
                        error: function(data){
                       		swal("添加失败!","","error");
                       		}  
						})

				})
	})
	//时钟
	showTime();
	setInterval(showTime,1000);
	//气球特效
	showBalloon();
	console.log('%c   轻松一下!','color: #8B2252;font-size: 15px');
	console.log('%c 1.愤怒的小鸟　','color: #9ACD32;font-size: 15px');
	console.log('%c http://'+document.domain+':8080/lfy/playAngryBirds.do','color:#FF1493;font-size:15px;');
})

	//页面加载完事件写在此处
	window.onload=function(){
	
	
	}
