<!DOCTYPE html>
<html lang="en" >

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
		<link href="../assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		<link href="../assets/vendor/skycons/css/skycons.css" rel="stylesheet" />
		<link href="../assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
		
		<!-- Plugins CSS-->		
		<link href="../assets/plugins/bootkit/css/bootkit.css" rel="stylesheet" />	
		<link href="../assets/plugins/scrollbar/css/mCustomScrollbar.css" rel="stylesheet" />
		<link href="../assets/plugins/fullcalendar/css/fullcalendar.css" rel="stylesheet" />
		<link href="../assets/plugins/jquery-ui/css/jquery-ui-1.10.4.min.css" rel="stylesheet" />
		<link href="../assets/plugins/xcharts/css/xcharts.min.css" rel="stylesheet" />
		<link href="../assets/plugins/morris/css/morris.css" rel="stylesheet" />
		
		<!-- Theme CSS -->
		<link href="../assets/css/jquery.mmenu.css" rel="stylesheet" />
		
		<!-- Page CSS -->		
		<link href="../assets/css/style.css" rel="stylesheet" />
		<link href="../assets/css/add-ons.min.css" rel="stylesheet" />
		
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
		<!--<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>-->
		
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
		
		<script>
		
		 $(function(){
			 
			 if(${Session.user.sex} == 0){
				 $('#sex_b').attr("checked",'true');
			 }else if(${Session.user.sex} == 1){
				 $('#sex_g').attr("checked",'true');
			 }else{
				 $('#sex_s').attr("checked",'true');
			 }
			 
			 $('.form_date').datetimepicker({
			        language:  'zh-CN',
			        weekStart: 1,
			        todayBtn:  1,
					autoclose: 1,
					todayHighlight: 1,
					startView: 2,
					minView: 2,
					forceParse: 0,
					format: "yyyy-mm-dd"
			    });
			 
		 }); 
		 
		 function checkPassWord(){
			 
			 if($('#oldPassWord').val()=="${Session.user.passWord}"){
				 if($('#newPassWord').val()==$('#againPassWord').val()){
					 var param={};
					 param.passWord=$('#newPassWord').val();
					 param.userId = "${Session.user.userId}";
					 $.ajax({
							url:"../updateUserPassWord",
							type:"POST",
							data:param,
							dataType:"json",
							success:function(data){
								if(data.flag == 1){
									location.href="../login";
									
								}else{
									alert("一个预期之外的错误！");
									return false;
								}
							},
							error:function(){
								alert("网络异常");
								return false;
							}
						});
					 return false;
				 }else{
					 alert("两次密码不一致！");
					 return false;
				 }
			 }else{
				 alert("原密码输入错误！");
				 return false;
			 }
		 }
		 

		</script>
	</head>
	
	<body>
	
		<!-- Start: Header -->
		<div class="navbar" role="navigation">
			<div class="container-fluid container-nav">				
				<!-- Navbar Action -->
				<ul class="nav navbar-nav navbar-actions navbar-left">
					<li class="visible-md visible-lg"><a  id="main-menu-toggle"><i class="fa fa-th-large"></i></a></li>
					<li class="visible-xs visible-sm"><a  id="sidebar-menu"><i class="fa fa-navicon"></i></a></li>			
				</ul>
				
				
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
											<img src="images/${Session.user.headUrl}" class="img-circle bk-img-60" alt="" />
										</div>
										<div class="bk-padding-top-10">
											<i class="fa fa-circle text-success"></i> <small>${Session.user.userName}</small>
										</div>
									</div>
									<div class="divider2"></div>
									<li class="active">
										<a href="${request.contextPath}/index">
											<i class="fa fa-laptop" aria-hidden="true"></i><span>首页</span>
										</a>
									</li>
									<li>
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
										<a href="${request.contextPath}/comment/commentList">
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
				<div class="main">
					<!-- Page Header -->
					<div class="page-header">
						<div class="pull-left">
							<ol class="breadcrumb visible-sm visible-md visible-lg">								
								<li><a href="index.html"><i class="icon fa fa-home"></i>Home</a></li>
								<li class="active"><i class="fa fa-laptop"></i>Dashboard</li>
							</ol>						
						</div>
						<div class="pull-right">
							<h2>Dashboard</h2>
						</div>					
					</div>
					
				<div class="row profile">
				
					
				
						<div class="bk-padding-top-5 bk-padding-bottom-10 bk-padding-left-10 bk-padding-right-10" >
							<div class="panel">
								<div class="panel-body text-center">
									
									<div class="bk-ltr bk-padding-bottom-20 bk-padding-left-20 text-center">
										<div class="row">
											<div class="tabs">
												<ul class="nav nav-tabs">
													<li class="active">
														<a href="#overview" data-toggle="tab">个人信息</a>
													</li>
													<li>
														<a href="#edit" data-toggle="tab">编辑</a>
													</li>
													<li>
														<a href="#editPassword" data-toggle="tab">更改密码</a>
													</li>
												</ul>
												<div class="tab-content">
													<div id="overview" class="tab-pane active">	
														<table class="table " style="width:60%;margin-right: auto; margin-left: auto ;border:0px">
															<tr>
																<td style="border:0px;text-align:right;padding-right:5%"><h4><span></span></h4></td>
																<td style="border:0px;text-align:left;padding-left:5%">
																	<div class="bk-avatar">
																		<img src="images/${Session.user.headUrl}" alt="" class="img-circle bk-img-120 bk-border-light-gray bk-border-3x" />
																	</div>
																</td>
															</tr>
															<tr>
																<td style="border:0px;text-align:right;padding-right:5%"><h4><span>邮箱</span></h4></td>
																<td style="border:0px;text-align:left;padding-left:5%"><h4>${Session.user.email}</h4></td>
															</tr>
															<tr>
																<td style="border:0px;text-align:right;padding-right:5%"><h4><span>昵称</span></h4> </td>
																<td style="border:0px;text-align:left;padding-left:5%"><h4>${Session.user.userName}</h4></td>
															</tr>
															<tr>
																<td style="border:0px;text-align:right;padding-right:5%"><h4><span>性别</span></h4></td>
																<td style="border:0px;text-align:left;padding-left:5%">
																	<h4>
																		<#if Session.user.sex == -1 >
																			保密
																		<#elseif Session.user.sex == 0>
																			男
																		<#else>
																			女
																		</#if>
																	</h4>
																</td>
															</tr>
															<tr>
																<td style="border:0px;text-align:right;padding-right:5%"><h4><span>出生日期</span></h4></td>
																<td style="border:0px;text-align:left;padding-left:5%"><h4>${Session.user.birthDate}</h4></td>
															</tr>
															<tr>
																<td style="border:0px;text-align:right;padding-right:5%"><h4><span>个人介绍</span></h4></td>
																<td style="border:0px;text-align:left;padding-left:5%"><h4>${Session.user.introduction}</h4></td>
															</tr>
														</table>
													</div>
													<div id="edit" class="tab-pane updateProfile">
														<form action="${request.contextPath}/updateUser" method="post" enctype="multipart/form-data" >
															<input type="hidden" name="email" value="${Session.user.email}"  />
															<input type="hidden" name="userId" value="${Session.user.userId}"  />
															<input type="hidden" name="passWord" value="${Session.user.passWord}"  />
															<table class="table " style="width:60%;margin-right: auto; margin-left: auto ;border:0px">
																<tr>
																	<td style="border:0px;text-align:right;padding-right:5%"><h4><span></span></h4></td>
																	<td style="border:0px;text-align:left;padding-left:5%">
																		<div class="bk-avatar">
																			
																			<input id="btnUpload" name="headImg" type="file" onchange="chooseImg(this)" style="display:none" accept="image/jpeg,image/jpg,image/png" >
														
																			<img id="tx_img" src="images/${Session.user.headUrl}"  class="img-circle bk-img-120 bk-border-light-gray bk-border-3x" onclick="btnUpload.click()" />
																			<script type="text/javascript" src="../../assets/js/SimpleAjaxUploader.js"></script>																			
																			<script>
																				//图片预览
																				function chooseImg(file){    
																					var file=file.files[0];   
																					if(file.size>(1024*1024)){
																						alert("=====图片不能大于2M=====");
																						$("#btnUpload").val('');
																					}else{
																						var reader=new FileReader();    
																						reader.readAsDataURL(file);    
																						reader.onload=function(){           
																							var img=document.getElementById('tx_img');           
																							img.src=this.result; 
																						};
																					}
																				}
																				
																			</script>
																			
																		</div>
																	</td>
																</tr>
																<tr>
																	<td style="border:0px;text-align:right;padding-right:5%"><h4><span>邮箱</span></h4></td>
																	<td style="border:0px;text-align:left;padding-left:5%"><h4>${Session.user.email}</h4></td>
																</tr>
																<tr>
																	<td style="border:0px;text-align:right;padding-right:5%"><h4><span>昵称</span></h4> </td>
																	<td style="border:0px;text-align:left;padding-left:5%"><h4><input type="text" name="userName" value="${Session.user.userName}" required="required" /></h4></td>
																</tr>
																<tr>
																	<td style="border:0px;text-align:right;padding-right:5%"><h4><span>性别</span></h4></td>
																	<td style="border:0px;text-align:left;padding-left:5%">
																		<h4>
																			<label class="radio-inline"><input type="radio" value="0" id="sex_b" name="sex">男</label>
																		    <label class="radio-inline"><input type="radio" value="1" id="sex_g" name="sex">女</label>
																		    <label class="radio-inline"><input type="radio" value="-1" id="sex_s" name="sex">保密</label>
																		</h4>
																	</td>
																</tr>
																<tr>
																	<td style="border:0px;text-align:right;padding-right:5%"><h4><span>出生日期</span></h4></td>
																	<td style="border:0px;text-align:left;padding-left:5%"><h4>
																			<div class="input-group date form_date col-md-5" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
															                    <input name="birthDate" class="form-control" size="16" type="text" value="${Session.user.birthDate}" readonly>
															                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
																				<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
															                </div>
																	</h4></td>
																</tr>
																<tr>
																	<td style="border:0px;text-align:right;padding-right:5%"><h4><span>个人介绍</span></h4></td>
																	<td style="border:0px;text-align:left;padding-left:5%"><textarea name="introduction" style="resize:none;font-size:20px" class="form-control" rows="5" cols="8" id="comment" >${Session.user.introduction}</textarea></td>
																</tr>
																<tr>
																	<td style="border:0px;text-align:right;padding-right:5%"><h4><span></span></h4></td>
																	<td style="border:0px;text-align:left;padding-left:5%"><button type="submit" class="btn btn-primary btn-lg">Submit</button></td>
																</tr>
															</table>
														</form>
															
														</div>
														<div id="editPassword" class="tab-pane updateProfile">
															<form onsubmit="return checkPassWord()">
																<input type="hidden" name="userId" value="${Session.user.userId}"  />
																
																<table class="table " style="width:60%;margin-right: auto; margin-left: auto ;border:0px">
																	
																	<tr>
																		<td style="border:0px;text-align:right;padding-right:5%"><h4><span>原密码</span></h4></td>
																		<td style="border:0px;text-align:left;padding-left:5%"><h4><input type="password" id="oldPassWord" required="required" /></h4></td>
																	</tr>
																	<tr>
																		<td style="border:0px;text-align:right;padding-right:5%"><h4><span>新密码</span></h4> </td>
																		<td style="border:0px;text-align:left;padding-left:5%"><h4><input type="password" id="newPassWord" name="passWord"  required="required" /></h4></td>
																	</tr>
																	<tr>
																		<td style="border:0px;text-align:right;padding-right:5%"><h4><span>确认密码</span></h4> </td>
																		<td style="border:0px;text-align:left;padding-left:5%"><h4><input type="password" id="againPassWord"  required="required" /></h4></td>
																	</tr>
																	<tr>
																		<td style="border:0px;text-align:right;padding-right:5%"><h4><span></span></h4></td>
																		<td style="border:0px;text-align:left;padding-left:5%"><button class="btn btn-primary btn-lg" >Submit</button></td>
																	</tr>
																</table>
															</form>
														</div>
														
													</div>
												</div>
										</div>
									</div>									
								</div>
							</div>							
						</div>
						</div>
					</div>
					
							
				</div>
				
				<!-- End Main Page -->			

			</div>
			
		</div><!--/container-->
		</div>
		
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