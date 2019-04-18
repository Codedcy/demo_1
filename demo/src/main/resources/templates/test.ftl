<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../assets/vendor/js/jquery.min.js"></script>
<script src="../assets/vendor/js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=rQP7j1hUTagCPynZ2gnZNv1vkD8VEd4K"></script>

<script type="text/javascript" src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
<script type="text/javascript">
	var goEasy = new GoEasy({
		appkey: 'BC-9c088edbd6ca4ca6b34e2d20033f727d'
	});
	goEasy.subscribe({
		channel:'demo_channel',
		onMessage: function(message){
			$('#channel').val(message.content);
		}
	});
</script>

</head>
<body>
<div>
	<input type="text" id="channel"  />
</div>
<button id="button1" onclick = "selectMap()" value="223333" >222222222</button>
<button id="button2" onclick = "setMap()">33333333</button>
<button id="button3" class="btn" value ="7">44444444444</button>
<div>
	<div id = "gra" style="width:1000px;height:800px;border:#ccc solid 1px;font-size:12px">
							
						</div>
</div>
	
</body>
</html>