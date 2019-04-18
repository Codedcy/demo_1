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
		<script src="../../assets/js/bootstrap-paginator.js"></script>
		<script src="../../assets/js/bootstrap-select.js"></script>
		<link href="../../assets/css/bootstrap-select.css" rel="stylesheet" />
		
		<link href="../../assets/css/star-rating.css" rel="stylesheet" />
		<script src="../../assets/js/star-rating.js"></script>
		
		
		<script>
		
		function getPageOfMemo(page) {
		   
			var param ={};
			param.graId=$("#graId").val();
			param.page=page;
			var urlStr = "";
			if(param.graId == "请选择景区"){
				urlStr = "../comment/commentListAjax";
			}else{
				urlStr = "../comment/commentListByGraId";
			}
		    $.ajax({
		        url : urlStr,
		        type : "POST",
		        data : param,
		        dataType : "json",
		        success : function(data) {
		            var totalPages;
		            if (data.commentList != null) {
		                totalPages = data.totalPages;
		                var html = "";
		                html+='<div id="commentShow" name="commentShow" class="panel-body bk-bg-white bk-padding-top-10 bk-padding-bottom-10">';
		                $.each(data.commentList, function(i, item) {
							html+='<div class="media"><div class="panel-body text-center pull-left"><div class="bk-avatar"><a class="pull-left bk-avatar"><img src="../images/';
							html+=item.user.headUrl;
							html+='" alt="" class="img-circle bk-img-60 bk-border-off" /></a><div class="bk-padding-top-10"><strong class="bk-fg-primary">';
							html+=item.user.userName;
							html+='</strong></div></div></div><div class="media-body"><span class="pull-right bk-fg-primary"><i class="fa fa-clock-o"></i><small> ';
							html+=item.commentTime;
							html+='</small></span><a><div class="media-heading bk-fg-primary"><strong class="bk-fg-primary"> ';
							html+=item.gra.graName;
							html+='</strong></div></a><p>';
							html+=item.commentText;
							html+='</p><label class="form-inline"><input id="graScole" name="graScole" data-size="sm" class="kv-uni-star rating-loading" data-show-clear="false" data-show-caption="true"  readonly="readonly" value="';
							html+=item.commetScole;
							html+='" /></label></div></div><hr class="bk-margin-off" />';
		                });
		                html+='</div>';
						$('#commentShow').replaceWith(html);
						
						$('.kv-uni-star').rating({
				            theme: 'krajee-uni',
				            filledStar: '&#x2605;',
				            emptyStar: '&#x2606;'
				        });
				        $('.kv-uni-rook').rating({
				            theme: 'krajee-uni',
				            defaultCaption: '{rating} rooks',
				            starCaptions: function (rating) {
				                return rating == 1 ? 'One rook' : rating + ' rooks';
				            },
				            filledStar: '&#9820;',
				            emptyStar: '&#9814;'
				        });
		 
		                var element = $('#pageButton');
		                var options = {
		                    bootstrapMajorVersion : 3,
		                    currentPage : page, // 当前页数
		                    numberOfPages : 5, // 显示按钮的数量
		                    totalPages : totalPages, // 总页数
		                    itemTexts : function(type, page, current) {
		                        switch (type) {
		                        case "first":
		                            return "首页";
		                        case "prev":
		                            return "上一页";
		                        case "next":
		                            return "下一页";
		                        case "last":
		                            return "末页";
		                        case "page":
		                            return page;
		                        }
		                    },
		                    // 点击事件，用于通过Ajax来刷新整个list列表
		                    onPageClicked : function(event, originalEvent, type, page) {
		                        getPageOfMemo(page);
		                    }
		                };
		                element.bootstrapPaginator(options);
		            }
		        }
		    });
		}
		
		 $(function(){
			 getPageOfMemo(1);	 
			 $('#graId').change(function(){
				 getPageOfMemo(1);
			 });
			
		 });
			function commentSubmit(){
				if($('#graId').val()=="请选择景区"){
					alert("=====请选择景区=====");
				}else{
					var param ={};
					param.commentText=$('#commentText').val();
					param.userId=$('#userId').val();
					param.commetScole = $('#commetScole').val();
					var currentDate = new Date();
					param.commentTime= currentDate.toLocaleString();
					param.graId = $('#graId').val();
					$.ajax({
						url:"../comment/addComment",
						type:"POST",
						data:param,
						dataType:"json",
						success:function(data){
							if(data.status == 1){
								getPageOfMemo(1);
								$('#commentText').val('');
							}else{
								alert("系统错误");
							}
						},
						error:function(){
							alert("网络异常");
						}
					});
					
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
											<a href="${request.contextPath}/personInfo"><img src="../../images/${Session.user.headUrl}" class="img-circle bk-img-60" alt="" /></a>
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
										<a href="${request.contextPath}/spot/spotInfo" >
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
								<li class="active"><i class="fa fa-list-alt"></i>旅行信息分享</li>
							</ol>						
						</div>
						<div class="pull-right">
							<h2>HRBEU</h2>
						</div>					
					</div>
					<!-- End Page Header -->	
				
					<div class="row">
					
					
							<div class="panel-body bk-bg-white bk-padding-top-15 bk-padding-bottom-15">
							
									<form role="form" action="../comment/addComment">
									<select id="graId" name="graId" class="selectpicker"  data-live-search="true"  >
										<option vlaue="0" >请选择景区</option>
										<#list graList as gl >
											<option value="${gl.graId}">${gl.graName}</option>
										</#list>                     
									</select>
									
									<label class="form-inline">您对该景区的满意度： </label>
									<label class="form-inline"><input id="commetScole" name="commetScole" data-size="sm" class="kv-uni-star rating-loading" data-show-clear="false" data-show-caption="true" required="required" value="5"></label>
									
									
										<div class="input-group">
											<input type="text" id="commentText" name="commentText" class="form-control bk-noradius" />
											<input type="hidden" id="userId" name="userId" value="${Session.user.userId}"  >
											  <span class="input-group-btn">
												<button class="btn btn-default bk-noradius" type="button" onclick="commentSubmit()"><i class="fa fa-send-o"></i></button>
											  </span>
										</div>
									</form>
							</div>
							
							
						<!--<div class="col-md-6" style="width:100%">-->
							<div class="panel bk-widget bk-border-off bk-noradius">
								
								<div class="panel-body bk-bg-white text-center bk-padding-top-10 bk-padding-bottom-10">
									<div class="row">
										<div class="col-xs-8 text-left bk-vcenter">
											<h6 class="bk-margin-off">COMMENT</h6>
										</div>
										<div class="col-xs-4 bk-vcenter text-right">
											<i class="fa fa-comments-o"></i>
										</div>
									</div>
								</div>
								<hr class="bk-margin-off" />
								<div id="commentShow" name="commentShow" class="panel-body bk-bg-white bk-padding-top-10 bk-padding-bottom-10">
									<#list commentList as cl >
									
										<div class="media">
										
											
											<div class="panel-body text-center pull-left">								
												<div class="bk-avatar">
													<a class="pull-left bk-avatar">
														<img src="../images/${cl.user.headUrl}" alt="" class="img-circle bk-img-60 bk-border-off" />
													</a>
												</div>
												<div class="bk-padding-top-10">
													<strong class="bk-fg-primary"> ${cl.user.userName}</strong>
												</div>
											</div>
											
											
											<div class="media-body">
												<span class="pull-right bk-fg-primary"><i class="fa fa-clock-o"></i><small> ${cl.commentTime}</small></span>
												<a>
													<div class="media-heading bk-fg-primary">
														<strong class="bk-fg-primary"> ${cl.user.userName}</strong>
													</div>
												</a>
												<p>${cl.commentText}</p>									
												<label class="form-inline"><input id="graScole" name="graScole" data-size="sm" class="kv-uni-star rating-loading" data-show-clear="false" data-show-caption="true" dir="rtl" readonly="readonly" value="3" ></label>
												
											</div>
										</div>
										<hr class="bk-margin-off" />
									</#list>
								</div>
								<div class="col-lg-12" align="center">
										<ul id="pageButton"></ul>
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