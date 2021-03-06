<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>温凯的个人主页</title>
	<!--fonts-->
		<link href='http://fonts.googleapis.com/css?family=Jockey+One' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	<!--//fonts-->
			<link href="css/bootstrap.css" rel="stylesheet">
			<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<!-- for-mobile-apps -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Peak Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //for-mobile-apps -->	
	<!-- js -->
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script src="js/modernizr.custom.97074.js"></script>
	<!-- js -->
	<!-- start-smoth-scrolling -->
		<script type="text/javascript" src="js/move-top.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
		</script>
	<!-- start-smoth-scrolling -->
</head>
<body>
<!-- banner -->
<div id="home" class="banner">
	<div class="container">
		<div class="banner-grids">
			<div class="col-md-4 navigation">
				<div class="nav-left">
					<div class="grid__item color-4">
						<a class="link link--kumya" href="#"><span data-letters="Kevin">温凯</span></a>
					</div>
				</div>
				<div class="nav-right">
						<span class="menu"><img src="images/menu.png" alt="" /></span>
							<nav class="cl-effect-1">
								<ul class="nav1">
									<li><a class="scroll" href="#home">Home</a></li>
									<li><a class="scroll" href="#about">关于我</a></li>
									<li><a class="scroll" href="#portfolio">作品</a></li>
									<li><a class="scroll" href="#services">Services</a></li>
									<li><a class="scroll" href="#contact">Contact</a></li>
								</ul>
							</nav>
							<!-- script for menu -->
							<script> 
								$( "span.menu" ).click(function() {
								$( "ul.nav1" ).slideToggle( 300, function() {
								 // Animation complete.
								});
								});
							</script>
							<!-- //script for menu -->

				</div>
				<div class="clearfix"></div>
			</div>
			<div class="col-md-8 banner-image text-center">
				<img src="images/wenkai.jpg" alt=""/>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- //banner -->
<!-- about -->
<div id="about" class="about">
	<div class="container">
		<div class="about-info">
				<h3>ABOUT ME</h3>
				<h4>Java/C后台开发 || Android开发</h4>
				<p>我呢，性格开朗，待人热情，特别喜欢各种姿势吹牛，喜欢和小伙伴一起搞个想法什么的。<br>
					我也热爱运动：篮球，羽毛球，乒乓等你爱玩，我就能跟你玩到一起~~<br>
					文艺范也是不能少的，我很喜欢看书，特别喜欢经典名著。</p>
				
</p>
		</div>
		<div class="about-grids">
		   	<div class="col-md-6 about-grid">
		   		<h4>擅长的技术</h4>
		   		<p>熟练使用SpringMVC及相关组件进行后台开发，和Android开发。</p>
				<p>	熟练掌握Linux系统原理与Linux下内核与驱动编程和Linux服务器开发。</p>
				<p>	深入理解虚拟化技术，KVM与Xen。对Docker有简单认识。</p>
				<p>	熟练掌握数学建模及相关数学算法。</p>
				<p>	对C，Java语言掌握熟练，编写代码量大于3w行</p>
		   	</div>
		   	<div class="col-md-6 about-grid">
		   		<h4>My goals</h4>
		   		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                   eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                   Ut enim ad minim veniam, quis nostrud exercitation
                   ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
		   	</div>
		   	<div class="clearfix"> </div>
		</div>   
	</div>
</div>
<!-- //about -->
<!-- my skills -->
	<div class="our-skills">
		<div class="container">
			<div class="skill-info">
				<h2>MY SKILLS</h2>
			</div>
			<div class="skill-grids">
					<div class="col-md-3 skills-grid text-center">
						<div class="circle" id="circles-1"></div>
						<p>数学建模及相关数学算法</p>
					</div>
					<div class="col-md-3 skills-grid text-center">
						<div class="circle" id="circles-2"></div>
						<p>虚拟化技术，KVM/Xen</p>
					</div>
					<div class="col-md-3 skills-grid text-center">
						<div class="circle" id="circles-3"></div>
						<p>Spring后台、Android等Java开发</p>
					</div>
					<div class="col-md-3 skills-grid text-center">
						<div class="circle" id="circles-4"></div>
						<p>Linux 内核、驱动及服务器开发</p>
					</div>
					<div class="clearfix"> </div>
				 <script type="text/javascript" src="js/circles.js"></script>
					         <script>
								var colors = [
										['#ced7df', '#76b852'], ['#ced7df', '#76b852'], ['#ced7df', '#76b852'], ['#ced7df', '#76b852']
									];
								for (var i = 1; i <= 5; i++) {
									var child = document.getElementById('circles-' + i),
										percentage = 40 + (i * 10);
										
									Circles.create({
										id:         child.id,
										percentage: percentage,
										radius:     80,
										width:      10,
										number:   	percentage / 1,
										text:       '%',
										colors:     colors[i - 1]
									});
								}
						
				</script>
			</div>
		</div>	
	</div>
<!-- //my skills -->
<div id="portfolio" class="gallery">
		<div class="container">
				<script src="js/jquery.chocolat.js"></script>
			<link rel="stylesheet" href="css/chocolat.css" type="text/css" media="screen" charset="utf-8">
			<!--light-box-files -->
			<script type="text/javascript" charset="utf-8">
			$(function() {
				$('.gallery a').Chocolat();
			});
			</script>
			<h3>PORTFOLIO</h3>
			<section>
				<ul id="da-thumbs" class="da-thumbs">
					<li>
						<a href="images/blog.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/blog.jpg" alt="" />
							<div>
								<h5>VIEW</h5>
							</div>
						</a>
					</li>
					<li>
						<a href="images/a2.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/a2.jpg" alt="" />
							<div>
								<h5>VIEW</h5>
							</div>
						</a>
					</li>
					<li>
						<a href="images/a3.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/a3.jpg" alt="" />
							<div>
								<h5>VIEW</h5>
								
							</div>
						</a>
					</li>
					<li>
						<a href="images/a4.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/a4.jpg" alt="" />
							<div>
								<h5>VIEW</h5>
								
							</div>
						</a>
					</li>
					<li>	
						<a href="images/a5.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/a5.jpg" alt="" />
							<div>
								<h5>VIEW</h5>
								
							</div>
						</a>
					</li>
					<li>
						<a href="images/a6.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/a6.jpg" alt="" />
							<div>
								<h5>VIEW</h5>
								
							</div>
						</a>
					</li>
					<li>
						<a href="images/a7.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/a7.jpg" alt="" />
							<div>
								<h5>VIEW</h5>
								
							</div>
						</a>
					</li>
					<li>
						<a href="images/a1.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/a1.jpg" alt="" />
							<div>
								<h5>VIEW</h5>
								
							</div>
						</a>
					</li>
					<li>
						<a href="images/a2.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/a2.jpg" alt="" />
							<div>
								<h5>VIEW</h5>
								
							</div>
						</a>
					</li>
					<div class="clearfix"> </div>
				</ul>
			</section>
				<script type="text/javascript" src="js/jquery.hoverdir.js"></script>	
				<script type="text/javascript">
					$(function() {
						$(' #da-thumbs > li ').each( function() { $(this).hoverdir(); } );
					});
				</script>
        </div>	
</div>
<!--//gallery-->
<!--services-->
<div id="services" class="services">
	<div class="container">
		<div class="ser-head">
			<h3>FEATURED SERVICES</h3>
		</div>
		<div class="wel-grids">
			<div class="col-md-4 wel-grid text-center">
				<div class="btm-clr">
					<figure class="icon">
						<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
					</figure>
					<h3>VOLUPTATEM</h3>
					<p> Nemo enim ipsam voluptatem
					quia voluptas sit aspernatur aut
					odit aut fugi.</p>
				</div>
			</div>
			<div class="col-md-4 wel-grid btm-gre text-center">
				<div class="btm-clr">
					<figure class="icon">
						<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
					</figure>
					<h3>VOLUPTATEM</h3>
					<p> Nemo enim ipsam voluptatem
					quia voluptas sit aspernatur aut
					odit aut fugi.</p>
				</div>
			</div>
			<div class="col-md-4 wel-grid text-center">
				<div class="btm-clr">
					<figure class="icon">
						<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
					</figure>
					<h3>VOLUPTATEM</h3>
					<p> Nemo enim ipsam voluptatem
					quia voluptas sit aspernatur aut
					odit aut fugi.</p>
				</div>
			</div>
			<div class="col-md-4 wel-grid btm-gre text-center">
				<div class="btm-clr">
					<figure class="icon">
						<span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
					</figure>
					<h3>VOLUPTATEM</h3>
					<p> Nemo enim ipsam voluptatem
					quia voluptas sit aspernatur aut
					odit aut fugi.</p>
				</div>
			</div>
			<div class="col-md-4 wel-grid text-center">
				<div class="btm-clr">
					<figure class="icon">
						<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
					</figure>
					<h3>VOLUPTATEM</h3>
					<p> Nemo enim ipsam voluptatem
					quia voluptas sit aspernatur aut
					odit aut fugi.</p>
				</div>
			</div>
			<div class="col-md-4 wel-grid btm-gre text-center">
				<div class="btm-clr">
					<figure class="icon">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
					</figure>
					<h3>VOLUPTATEM</h3>
					<p> Nemo enim ipsam voluptatem
					quia voluptas sit aspernatur aut
					odit aut fugi.</p>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!--//services-->
<!--news-->
<div class="news">
	<div class="container">
		<h3>NEWSLETTER SIGN UP</h3>
		<p> Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing. </p>
		<div class="na-m">
			<div class="name">
				<form>
					<input type="text" placeholder="Enter email id" required="">
				</form>
			</div>
			<div class="button">
				<form>
					<input type="submit" value="Subscribe">
				</form>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<!--//news-->
<!-- get-in -->
<div id="contact" class="get-in-touch">
	<div class="container">
		<div class="get-info text-center">
			<h3>GET IN TOUCH</h3>
			<h4><i>Feel Free To Contact Us</i></h4>
			<p>Lorem ipsum dolor amet, libero turpis non cras ligula, id commodo, aenean est in volutpat amet sodales, porttitor bibendum facilisi suspendisse</p>
		</div>
	</div>
	
</div>
<!-- //get-in -->
<!-- contact-us -->
<div class="contact-us">
	<div class="container">
		<div class="contact-grids">
			<div class="col-md-4 contact-grid text-center">
				<div class="point-icon"><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span></div>
				<p>Jl. Pahlawan VII No.247-D Sidoarjo-Surabaya-Indonesia</p>
			</div>
			<div class="col-md-4 contact-grid text-center">
				<div class="point-icon"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span></div>
				<p><a href="mailto:info@example.com">rudhisasmito@gmail.com</a></p>
			</div>
			<div class="col-md-4 contact-grid text-center">
				<div class="point-icon"><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span></div>
				<p>+613 0000 0000</p>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="contact-info">
			<form>
				<input type="text" placeholder="Your Name" required>
				<input type="text" placeholder="Your E-Mail" required>
				<input type="text" placeholder="Subject" required>
				<textarea placeholder="Your Message" required></textarea>
				<input type="submit" value="SEND MESSAGE">
			</form>
		</div>
	</div>
</div>
<!-- //contact-us -->
<!-- footer -->
<div class="copy-right">
	<div class="container">
		<p> &copy; 2015 Peak. All Rights Reserved | Design by  <a href="http://w3layouts.com/"> W3layouts</a></p>
	</div>
</div>
<!-- footer -->
<!-- smooth scrolling -->
	<script type="text/javascript">
		$(document).ready(function() {
		/*
			var defaults = {
			containerID: 'toTop', // fading element id
			containerHoverID: 'toTopHover', // fading element hover id
			scrollSpeed: 1200,
			easingType: 'linear' 
			};
		*/								
		$().UItoTop({ easingType: 'easeOutQuart' });
		});
	</script>
	<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- //smooth scrolling -->
</body>
</html>
