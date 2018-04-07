function submitForm(){
          var form = document.getElementById("myform ");
              form.submit();
           }
          var aa=new zturn({
							id:"zturn",
							opacity:0.9,
							width:300,
							Awidth:900,
							scale:0.9
					})
						
		$(".bodyPagesecond_nav_li1").hover(
		 	function(){
		 	$(this).css("color","red");
		 	$(this).siblings().css("color","black");
		 	$(".bodyPagesecondbody_1").css("display","block");
		 	$(".bodyPagesecondbody_1").siblings().css("display","none");
		    });
		 $(".bodyPagesecond_nav_li2").hover(
		 	function(){
		 			$(this).css("color","red");
		 	$(this).siblings().css("color","black");
		    $(".bodyPagesecondbody_2").css("display","block");
		 	$(".bodyPagesecondbody_2").siblings().css("display","none");
		    });
		   $(".bodyPagesecond_nav_li3").hover(
		 	function(){
		 			$(this).css("color","red");
		 	$(this).siblings().css("color","black");
		    $(".bodyPagesecondbody_3").css("display","block");
		 	$(".bodyPagesecondbody_3").siblings().css("display","none");
		    });
		     $(".bodyPagesecond_nav_li4").hover(
		 	function(){
		 			$(this).css("color","red");
		 	$(this).siblings().css("color","black");
		    $(".bodyPagesecondbody_4").css("display","block");
		 	$(".bodyPagesecondbody_4").siblings().css("display","none");
		    });
		     $(".bodyPagesecond_nav_li5").hover(
		 	function(){
		 			$(this).css("color","red");
		 	$(this).siblings().css("color","black");
		    $(".bodyPagesecondbody_5").css("display","block");
		 	$(".bodyPagesecondbody_5").siblings().css("display","none");
		    });
		    $(".bodyPagesecond_nav_li6").hover(
		 	function(){
		 			$(this).css("color","red");
		 	$(this).siblings().css("color","black");
		    $(".bodyPagesecondbody_6").css("display","block");
		 	$(".bodyPagesecondbody_6").siblings().css("display","none");
		    });
		    $(".bodyPagethree_nav_li1").hover(
		 	function(){
		 			$(this).css("color","red");
		 	$(this).siblings().css("color","black");
		 	$(".bodyPagethreebody_1").css("display","block");
		 	$(".bodyPagethreebody_1").siblings().css("display","none");
		    });
		$(".bodyPagethree_nav_li2").hover(
		 	function(){
		 			$(this).css("color","red");
		 	$(this).siblings().css("color","black");
		 	$(".bodyPagethreebody_2").css("display","block");
		 	$(".bodyPagethreebody_2").siblings().css("display","none");
		    });
		    $(".bodyPagethree_nav_li3").hover(
		 	function(){
		 			$(this).css("color","red");
		 	$(this).siblings().css("color","black");
		 	$(".bodyPagethreebody_3").css("display","block");
		 	$(".bodyPagethreebody_3").siblings().css("display","none");
		    });
		    $(".bodyPagethree_nav_li4").hover(
		 	function(){
		 			$(this).css("color","red");
		 	$(this).siblings().css("color","black");
		 	$(".bodyPagethreebody_4").css("display","block");
		 	$(".bodyPagethreebody_4").siblings().css("display","none");
		    });
		    $(".bodyPagethree_nav_li5").hover(
		 	function(){
		 			$(this).css("color","red");
		 	$(this).siblings().css("color","black");
		 	$(".bodyPagethreebody_5").css("display","block");
		 	$(".bodyPagethreebody_5").siblings().css("display","none");
		    });
		    $(".bodyPagethree_nav_li6").hover(
		 	function(){
		 			$(this).css("color","red");
		 	$(this).siblings().css("color","black");
		 	$(".bodyPagethreebody_6").css("display","block");
		 	$(".bodyPagethreebody_6").siblings().css("display","none");
		    });
		$(function(){
			
			$(".carousel-content ").carousel({
				carousel : ".carousel ",//轮播图容器
				indexContainer : ".img-index ",//下标容器
				prev : ".carousel-prev ",//左按钮
				next : ".carousel-next ",//右按钮
				timing : 3000,//自动播放间隔
				animateTime : 700,//动画时间
				autoPlay : true,//是否自动播放 true/false
				direction : "left ",//滚动方向 right/left
			});

			$(".carousel-content ").hover(function(){
				$(".carousel-prev,.carousel-next ").fadeIn(300);
			},function(){
				$(".carousel-prev,.carousel-next ").fadeOut(300);
			});

			$(".carousel-prev ").hover(function(){
				$(this).find("img ").attr("src ","./img/left2.png ");
			},function(){
				$(this).find("img ").attr("src ","./img/left1.png ");
			});
			$(".carousel-next ").hover(function(){
				$(this).find("img ").attr("src ","./img/right2.png ");
			},function(){
				$(this).find("img ").attr("src ","./img/right1.png ");
			});

				$('.fenlei ul li').mouseenter(function() {

					$(this).stop().animate({
						'height': '300px'
					}, 300).siblings().stop().animate({
						'height': '44px'
					}, 300);

					$(this).siblings().css('background', '#F5F5F5');

					$('.fenleiright').fadeTo(0, 0.8).stop().animate({
						'width': '700px'
					}, 300);

				}).mouseleave(function() {

					$('.fenlei ul li').stop().animate({
						'height': '80px'
					}, 300)

					$(this).siblings().css('background', '#ffffff');

				});

				$('.navLeft').mouseleave(function() {

					$('.fenleiright').stop().animate({
						'width': '0px'
					}, 300);

				})

		
		});
		$(function(){
			$('.mhn-slide').owlCarousel({
				nav:true,
				//loop:true,
				slideBy:'page',
				rewind:false,
				responsive:{
					0:{items:1},
					480:{items:2},
					600:{items:3},
					1000:{items:4}
				},
				smartSpeed:70,
				onInitialized:function(e){
					$(e.target).find('img').each(function(){
						if(this.complete){
							$(this).closest('.mhn-inner').find('.loader-circle').hide();
							$(this).closest('.mhn-inner').find('.mhn-img').css('background-image','url('+$(e.target).attr('src')+')');
						}else{
							$(this).bind('load',function(e){
								$(e.target).closest('.mhn-inner').find('.loader-circle').hide();
								$(e.target).closest('.mhn-inner').find('.mhn-img').css('background-image','url('+$(e.target).attr('src')+')');
							});
						}
					});
				},
				navText:['<svg viewBox="0 0 24 24 "><path d="M15.41 7.41L14 6l-6 6 6 6 1.41-1.41L10.83 12z "></path></svg>','<svg viewBox="0 0 24 24 "><path d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z "></path></svg>']
			});
		});