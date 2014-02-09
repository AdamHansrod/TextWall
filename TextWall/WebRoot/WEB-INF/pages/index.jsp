<%@ taglib prefix="s" uri="/struts-tags"%><!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title></title>
<meta name="description"
	content="University of Portsmouth Bus Timetable">
<meta name="viewport" content="width=device-width">
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/images/favicon.ico">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/normalize.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css">

<script
	src="${pageContext.request.contextPath}/js/vendor/livevalidation_standalone.compressed.js"></script>
<script
	src="${pageContext.request.contextPath}/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>
<body>
	<!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->
	<div class="screen">

		<div class="header-container">
			<header class="wrapper clearfix">
				<h1 class="title">Text Wall</h1>
			</header>
		</div>

		<div class="main-container">
			<div class="main wrapper clearfix">
				<article>
					<header>
						<noscript>
							<h2>Please enable javascript for this page to function
								correctly</h2>
						</noscript>
						<h1>Text's sent in to number 01777322044:</h1>
					</header>


					<s:iterator value="users" id='user'>
						<p class="busy">
							<s:property value="#user.username" />
							:<br>
							<s:iterator value="#user.messages" id="msg">
								<s:property value="#msg.content" /><br>

							</s:iterator>
						</p>

					</s:iterator>

				</article>

				<%--                 <aside>
                	<header>
                		<h2>Or choose your own bus stop</h2>
                	</header>                    
				    <section>
						<s:form id="getLangBusTimes" action="timetableAjax.action" name="input"
							method="post" enctype="multipart/form-data">
							<s:select name="StopNumber" list="locationListLangstone" listKey="StopNumber"
								listValue="Location" label="Select a bus stop" />
							<s:submit value="Submit" id="LangBusTimesBtn" />
						</s:form>
						<p id="LangstoneCampusTimes"></p>
					</section>
					<section>
						<s:form id="getUniBusTimes" action="timetableAjax.action" name="input"
							method="post" enctype="multipart/form-data">
							<s:select name="StopNumber" list="locationListUni" listKey="StopNumber"
								listValue="Location" label="Select a bus stop" />
							<s:submit value="Submit" id="UniBusTimesBtn" />
						</s:form>
						<p id="UniCampusTimes"></p>
					</section>								
                </aside>      --%>



			</div>
			<!-- #main -->
		</div>
		<!-- #main-container -->
		<div id="push"></div>
	</div>
	<div class="footer-container">
		<footer class="wrapper">
			<%-- <p>
					<a href="<s:property value="mon_fri_link" />">Mon to Fri</a>
					and <a href="<s:property value="weekend_link" />">Weekend</a>
					 full timetables. Other information <a href="<s:url action='info'/>"><img src="${pageContext.request.contextPath}/images/information.png"></a>
				</p>
				<p>
				&copy; University of Portsmouth
				</p> --%>
		</footer>
	</div>

	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="${pageContext.request.contextPath}/js/vendor/jquery-1.9.1.min.js"><\/script>')
	</script>

	<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
    <script>
    setTimeout(function(){
   window.location.reload(1);
}, 5000);
</script>
</html>
