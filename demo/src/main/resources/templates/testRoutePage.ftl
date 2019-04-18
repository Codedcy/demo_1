<!DOCTYPE html>
<html lang="en">

	<head>
	
		<!-- Basic -->
    	<meta charset="UTF-8" />

		<title>Dashboard | Nadhif - Responsive Admin Template</title>
		
		<!-- Mobile Metas -->
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		
		<!-- Import google fonts -->
        <link href="http://fonts.useso.com/css?family=Open+Sans:300,400,600,700,800|Shadows+Into+Light" rel="stylesheet" type="text/css" />
        
		<!-- Favicon and touch icons -->
		<link rel="shortcut icon" href="../assets/ico/favicon.ico" type="image/x-icon" />
		<link rel="apple-touch-icon" href="../assets/ico/apple-touch-icon.png" />
		<link rel="apple-touch-icon" sizes="57x57" href="../assets/ico/apple-touch-icon-57x57.png" />
		<link rel="apple-touch-icon" sizes="72x72" href="../assets/ico/apple-touch-icon-72x72.png" />
		<link rel="apple-touch-icon" sizes="76x76" href="../assets/ico/apple-touch-icon-76x76.png" />
		<link rel="apple-touch-icon" sizes="114x114" href="../assets/ico/apple-touch-icon-114x114.png" />
		<link rel="apple-touch-icon" sizes="120x120" href="../assets/ico/apple-touch-icon-120x120.png" />
		<link rel="apple-touch-icon" sizes="144x144" href="../assets/ico/apple-touch-icon-144x144.png" />
		<link rel="apple-touch-icon" sizes="152x152" href="../assets/ico/apple-touch-icon-152x152.png" />
		
	    <!-- start: CSS file-->
		
		<!-- Vendor CSS-->
		<link href="../../assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		<link href="../../assets/vendor/skycons/css/skycons.css" rel="stylesheet" />
		<link href="../../assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
		
		<!-- Plugins CSS-->		
		<link href="../../assets/plugins/bootkit/css/bootkit.css" rel="stylesheet" />	
		<link href="../../assets/plugins/scrollbar/css/mCustomScrollbar.css" rel="stylesheet" />
		<link href="../../assets/plugins/fullcalendar/css/fullcalendar.css" rel="stylesheet" />
		<link href="../../assets/plugins/jquery-ui/css/jquery-ui-1.10.4.min.css" rel="stylesheet" />
		<link href="../../assets/plugins/xcharts/css/xcharts.min.css" rel="stylesheet" />
		<link href="../../assets/plugins/morris/css/morris.css" rel="stylesheet" />
		
		<!-- Theme CSS -->
		<link href="../../assets/css/jquery.mmenu.css" rel="stylesheet" />
		
		<!-- Page CSS -->		
		<link href="../../assets/css/style.css" rel="stylesheet" />
		<link href="../../assets/css/add-ons.min.css" rel="stylesheet" />
		
		<!-- end: CSS file-->	
	    <!-- start: JavaScript-->
		
		<!-- Vendor JS-->				
		<script src="../../assets/vendor/js/jquery.min.js"></script>
		<script src="../../assets/vendor/js/jquery-2.1.1.min.js"></script>
		<script src="../../assets/vendor/js/jquery-migrate-1.2.1.min.js"></script>
		<script src="../../assets/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="../../assets/vendor/skycons/js/skycons.js"></script>		
		
		<!-- Plugins JS-->		
		<script src="../../assets/plugins/jquery-ui/js/jquery-ui-1.10.4.min.js"></script>
		<script src="../../assets/plugins/scrollbar/js/jquery.mCustomScrollbar.concat.min.js"></script>
		<script src="../../assets/plugins/bootkit/js/bootkit.js"></script>
		<script src="../../assets/plugins/moment/js/moment.min.js"></script>	
		<script src="../../assets/plugins/fullcalendar/js/fullcalendar.min.js"></script>
		<script src="../../assets/plugins/touchpunch/js/jquery.ui.touch-punch.min.js"></script>
		<script src="../../assets/plugins/flot/js/jquery.flot.min.js"></script>
		<script src="../../assets/plugins/flot/js/jquery.flot.pie.min.js"></script>
		<script src="../../assets/plugins/flot/js/jquery.flot.resize.min.js"></script>
		<script src="../../assets/plugins/flot/js/jquery.flot.stack.min.js"></script>
		<script src="../../assets/plugins/flot/js/jquery.flot.time.min.js"></script>
		<script src="../../assets/plugins/xcharts/js/xcharts.min.js"></script>
		<script src="../../assets/plugins/autosize/jquery.autosize.min.js"></script>
		<script src="../../assets/plugins/placeholder/js/jquery.placeholder.min.js"></script>
		<script src="../../assets/plugins/datatables/js/dataTables.bootstrap.min.js"></script>
		<script src="../../assets/plugins/datatables/js/jquery.dataTables.min.js"></script>
		<script src="../../assets/plugins/raphael/js/raphael.min.js"></script>
		<script src="../../assets/plugins/morris/js/morris.min.js"></script>
		<script src="../../assets/plugins/gauge/js/gauge.min.js"></script>		
		<script src="../../assets/plugins/d3/js/d3.min.js"></script>		
		
		<!-- Theme JS -->		
		<script src="../../assets/js/jquery.mmenu.min.js"></script>
		<script src="../../assets/js/core.min.js"></script>
		
		<!-- end: JavaScript-->
		
		<!-- Head Libs -->
		<script src="../assets/plugins/modernizr/js/modernizr.js"></script>
		
		<script src="../../assets/js/bootstrap-select.js"></script>
		<link href="../../assets/css/bootstrap-select.css" rel="stylesheet" />
		<script src="../../assets/js/bootstrap-select.js"></script>
		<link href="../../assets/css/bootstrap-select.css" rel="stylesheet" />
		<script src="../../assets/js/bootstrap-datetimepicker.min.js"></script>
		<link href="../../assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen" />
		<script src="../../assets/js/bootstrap-datetimepicker.zh-CN.js"></script>
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=rQP7j1hUTagCPynZ2gnZNv1vkD8VEd4K"></script>
		
		<script>
			$(function(){

				
				var maps = new BMap.Map("gra");
				
				var p = {};
				p.graId = $('#graId').val();
			    $.ajax({
					url:"../route/getGraByGraId",
					type:"POST",
					data:p,
					dataType:"json",
					success:function(data){
					    maps.centerAndZoom(new BMap.Point(data.gra.lng,data.gra.lat),data.gra.lv);
					},
					error:function(){
						alert("网络异常");
					}
				});
			    
			    
				$("#graId").change(function(){
					var param ={};
					param.graId=$('#graId').val();
					$('#spotId').empty();
					$('#in').empty();
					$('#out').empty();
					$.ajax({
				
						traditional:true,
						url:"../route/routePageTest",
						type:"POST",
						data:param,
						dataType:"json",
						success:function(data){
							
							for (var i = 0; i < data.spotInfoList.length; i++) {
								var option = '<option value="'+data.spotInfoList[i].spotId+'">'
										+ data.spotInfoList[i].spotName + ' </option>';
								if(data.spotInfoList[i].content == 0){
									$("#in").append(option);
									$("#out").append(option);
								}else{
									$("#spotId").append(option);
								}
							}
							$("#spotId").selectpicker('refresh');
							$("#in").selectpicker('refresh');
							$("#out").selectpicker('refresh');
						},
						error:function(){
							alert("网络异常");
						}
					});
					
					var p2 = {}; 
					p2.graId = $('#graId').val();
				    $.ajax({
						url:"../route/getGraByGraId",
						type:"POST",
						data:p2,
						dataType:"json",
						success:function(data){
						    maps.centerAndZoom(new BMap.Point(data.gra.lng,data.gra.lat),data.gra.lv);
						},
						error:function(){
							alert("网络异常");
						}
					});
					
					
				});
				
				$("#graId").change();
				
				
			    
			    $("#routeShow").click(function(){
			    	var param={};
			    	var spotsArray = new Array();
			    	spotsArray.push($('#in').val());
			    	for(var i=0;i<$('#spotId').val().length;i++){
			    		spotsArray.push($('#spotId').val()[i]);
			    	}
			    	spotsArray.push($('#out').val());
			    	
			    	param.graId=$('#graId').val();
			    	param.spots = spotsArray;
			    	
					$.ajax({
						traditional:true,
						url:"../route/",
						type:"POST",
						data:param,
						dataType:"json",
						success:function(data){
							
							var map = new BMap.Map("gra");
						    map.centerAndZoom(new BMap.Point(data.gra.lng,data.gra.lat),data.gra.lv);
							
							var viaRouteData = new Array();
							var pointName = new Array();
							var walking = new Array();
							var str="为您推荐游览顺序：";
							for(var i=0;i<data.spotsArray.length-1;i++){
								str+=data.spotsArray[i].spotName+"->";
							}
							str+=data.spotsArray[data.spotsArray.length-1].spotName;
							$("#spotShowTextOrder").val(str);
							
							for(var i=0;i<data.spotsArray.length-1;i++){
								walking[i] = new BMap.WalkingRoute(maps, { renderOptions: { map: maps, autoViewport: true} });
								
							    var startpoint = new BMap.Point(data.spotsArray[i].lng,data.spotsArray[i].lat);
							    
							    var endpoint = new BMap.Point(data.spotsArray[i+1].lng,data.spotsArray[i+1].lat);
							    
								if(i != data.spotsArray.length-2){
									viaRouteData.push(endpoint);
									pointName.push(data.spotsArray[i+1].spotName);
									
								}
								walking[i].search(startpoint, endpoint);
							    
							}
							
							$.each(walking, function (item, value) {
					            value.setSearchCompleteCallback(function (rs) {
									var pts = value.getResults().getPlan(0).getRoute(0).getPath();
									map.addOverlay(new BMap.Polyline(pts, { strokeColor: "red", strokeWeight: 2, strokeOpacity: 1 }));
								});
						    });
							
							var startpoint = new BMap.Point(data.spotsArray[0].lng,data.spotsArray[0].lat);
							var endpoint = new BMap.Point(data.spotsArray[data.spotsArray.length-1].lng,data.spotsArray[data.spotsArray.length-1].lat);
							var m1 = new BMap.Marker(startpoint);
					        var m2 = new BMap.Marker(endpoint);
					        map.addOverlay(m1);
					        map.addOverlay(m2);
					        var lab1 = new BMap.Label("起点", { position: startpoint });
					        var lab2 = new BMap.Label("终点", { position: endpoint });
					        map.addOverlay(lab1);
					        map.addOverlay(lab2);

							$.each(viaRouteData, function (item, value) {
								
					            var m = new BMap.Marker(value);
					            map.addOverlay(m);
					            var lab = new BMap.Label(pointName[item], { position: value });
					            map.addOverlay(lab);
					        });
						},
						error:function(){
							alert("网络异常");
						}
					});
			    	
			    	
			    	
			    	
			    });
			    
				$("#spotId").change(function(){
					
					var spotSelect=$("#spotId option:selected");
					var str="";
					$("#spotShowText").val("您已勾选景点："+spotSelect.text().split(" "));
					
				});
			});
			
		
	</script>

	</head>
	
	<body style="overflow:hidden">
	
		<!-- Start: Header -->
		<div class="navbar" role="navigation">
			<div class="container-fluid container-nav">				
				<!-- Navbar Action -->
				<ul class="nav navbar-nav navbar-actions navbar-left">
					<li class="visible-md visible-lg"><a  id="main-menu-toggle"><i class="fa fa-th-large"></i></a></li>
					<li class="visible-xs visible-sm"><a  id="sidebar-menu"><i class="fa fa-navicon"></i></a></li>			
				</ul>
				
				
				</div>
				<!-- End Navbar Right -->
			</div>		
		</div>
		<!-- End: Header -->
		<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>
		<!-- Start: Content -->
		<div class="container-fluid content">	
			<div class="row">
			
				<!-- Sidebar -->
				<div class="sidebar">
					<div class="sidebar-collapse">
						<!-- Sidebar Header Logo-->
						<div class="sidebar-header">
							<img src="../../assets/img/logo1.png" class="img-responsive" alt="" />
						</div>
						<!-- Sidebar Menu-->
						<div class="sidebar-menu">						
							<nav id="menu" class="nav-main" role="navigation">
								<ul class="nav nav-sidebar">
									<div class="panel-body text-center">								
										<div class="bk-avatar">
											<a href="${request.contextPath}/personInfo"><img src="../../images/${Session.user.headUrl}"  class="img-circle bk-img-60" alt="" /></a>
										</div>
										<div class="bk-padding-top-10">
											<i class="fa fa-circle text-success"></i><small> ${Session.user.userName}</small>
										</div>
									</div>
									<div class="divider2"></div>
									<li >
										<a href="${request.contextPath}/index">
											<i class="fa fa-laptop" aria-hidden="true"></i><span>首页</span>
										</a>
									</li>
									<li class="active">
										<a href="${request.contextPath}/route/routePageTests">
											<i class="fa fa-envelope" aria-hidden="true"></i><span>旅游路线推荐</span>
										</a>
									</li>
									<li>
										<a href="${request.contextPath}/spot/spotInfo">
											<i class="fa fa-copy" aria-hidden="true"></i><span>景点信息查询</span>
										</a>

									</li>
									<li>
										<a href="${request.contextPath}/comment/commentList" >
											<i class="fa fa-list-alt" aria-hidden="true"></i><span>旅行信息分享</span>
										</a>

									</li>
									<li>
										<a href="table.html">
											<i class="fa fa-table" aria-hidden="true"></i><span>关于我们</span>
										</a>
									</li>

								</ul>
							</nav>
						</div>
						<!-- End Sidebar Menu-->
					</div>
					<!-- Sidebar Footer-->
					<div class="sidebar-footer">	
						
						<div class="copyright text-center">
							<small>HRBEU@DongChunyin 2019</small>
						</div>							
					</div>
					<!-- End Sidebar Footer-->
				</div>
				<!-- End Sidebar -->
		
				<!-- Main Page -->
				<div class="main" id="main">
					<!-- Page Header -->
					<div class="page-header">
						<div class="pull-left">
							<ol class="breadcrumb visible-sm visible-md visible-lg">								
								<li><a><i class="icon fa fa-home"></i>Home</a></li>
								<li class="active"><i class="fa fa-envelope" ></i>景区路线推荐</li>
							</ol>						
						</div>
						<div class="pull-right">
							<h2>Hrbeu</h2>
						</div>					
					</div>
					<!-- End Page Header -->	
				
				
					<div class="row">
					<select id="graId" name="graId" class="selectpicker"  data-live-search="true" >
							<#list graList as g >
								<option value="${g.graId}" >${g.graName}</option>
							</#list>
							
						</select>
						<select id="spotId" name="spotId" class="selectpicker" multiple data-actions-box="true"  data-live-search="true" >
						</select>
						<span><font size="3"><strong>入口:</strong></font></span><select id="in" name="in" class="selectpicker"  data-actions-box="true"  data-live-search="true" >
						</select>
						<span><font size="3"><strong>出口:</strong></font></span><select id="out" name="out" class="selectpicker"  data-actions-box="true"  data-live-search="true" >
						</select>
						<button id="routeShow" class="btn">查询路径</button>
						<div id="spotShow" name="spotShow" >
							<textarea style="resize:none;font-size:20px" class="form-control" rows="1" id="spotShowText" name="spotShowText" readonly="readonly"  ></textarea>
							<textarea style="resize:none;font-size:20px" class="form-control" rows="1" id="spotShowTextOrder" name="spotShowTextOrder" readonly="readonly"  ></textarea>
						</div>

					<div id = "gra" style="width:100%;height:750px;border:#ccc solid 1px;font-size:12px"></div>
							
					</div>
				
				<!-- End Main Page -->			
				
			
			</div>
		</div><!--/container-->
			
		
		<!-- Modal Dialog -->
		<div class="modal fade" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title bk-fg-primary">Modal title</h4>
					</div>
					<div class="modal-body">
						<p class="bk-fg-danger">Here settings can be configured...</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save changes</button>
					</div>
				</div>
			</div>
		</div><!-- End Modal Dialog -->		
		
		<div class="clearfix"></div>		


	</body>
	
</html>