<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<!-- Head BEGIN -->
<head>
  <meta charset="utf-8">
  <%--放置的位置要特别注意,不能放在第三行,否则会有一些样式问题 --%>
  <%@ include file="/WEB-INF/views/base.jsp" %>
  
  <title>数据脉络</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="keywords" content="芜湖市南陵县同城交友相亲" /> 
  <meta name="description" content="南陵交友-南陵相亲-南陵婚介绍" />
 

  <!-- Fonts START -->
  <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css"><!--- fonts for slider on the index page -->  
  <!-- Fonts END -->

  <!-- Global styles START -->          
  <link href="${ctx}/resources/metronic-3.1.3/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="${ctx}/resources/metronic-3.1.3/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Global styles END --> 
   
  <!-- Page level plugin styles START -->
  <link href="${ctx}/resources/metronic-3.1.3/assets/global/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
  <link href="${ctx}/resources/metronic-3.1.3/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.css" rel="stylesheet">
  <link href="${ctx}/resources/metronic-3.1.3/assets/global/plugins/slider-layer-slider/css/layerslider.css" rel="stylesheet">
  <!-- Page level plugin styles END -->

  <!-- Theme styles START -->
  <link href="${ctx}/resources/metronic-3.1.3/assets/global/css/components.css" rel="stylesheet">
  <link href="${ctx}/resources/metronic-3.1.3/assets/frontend/layout/css/style.css" rel="stylesheet">
  <link href="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/css/style-shop.css" rel="stylesheet" type="text/css">
  <link href="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/css/style-layer-slider.css" rel="stylesheet">
  <link href="${ctx}/resources/metronic-3.1.3/assets/frontend/layout/css/style-responsive.css" rel="stylesheet">
  <link href="${ctx}/resources/metronic-3.1.3/assets/frontend/layout/css/themes/red.css" rel="stylesheet" id="style-color">
  <link href="${ctx}/resources/metronic-3.1.3/assets/frontend/layout/css/custom.css" rel="stylesheet">
  <!-- Theme styles END -->
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
    <!-- BEGIN STYLE CUSTOMIZER -->
    <div class="color-panel hidden-sm">
      <div class="color-mode-icons icon-color"></div>
      <div class="color-mode-icons icon-color-close"></div>
      <div class="color-mode">
        <p>THEME COLOR</p>
        <ul class="inline">
          <li class="color-red current color-default" data-style="red"></li>
          <li class="color-blue" data-style="blue"></li>
          <li class="color-green" data-style="green"></li>
          <li class="color-orange" data-style="orange"></li>
          <li class="color-gray" data-style="gray"></li>
          <li class="color-turquoise" data-style="turquoise"></li>
        </ul>
      </div>
    </div>
    <!-- END BEGIN STYLE CUSTOMIZER --> 

    <!-- BEGIN TOP BAR -->
    <div class="pre-header">
        <div class="container">
            <div class="row">
                <!-- BEGIN TOP BAR LEFT PART -->
                <div class="col-md-6 col-sm-6 additional-shop-info">
                    <ul class="list-unstyled list-inline">
                        <li><i class="fa fa-phone"></i><span>18019563065</span></li>
                        <li class="langs-block">
                            <a href="javascript:void(0);" class="current">中文 </a>
                            <div class="langs-block-others-wrapper">
	                            <div class="langs-block-others">
	                              <a href="javascript:void(0);">English</a>
	                            </div>
                            </div>
                        </li>
                        <!-- END LANGS -->
                    </ul>
                </div>
                <!-- END TOP BAR LEFT PART -->
                <!-- BEGIN TOP BAR MENU -->
                <div class="col-md-6 col-sm-6 additional-nav">
                    <ul class="list-unstyled list-inline pull-right">
                        <li><a href="shop-account.html">我的账号</a></li>
                        <li><a href="shop-wishlist.html">我的关注</a></li>
                        <li><a href="page-login.html">登录</a></li>
                    </ul>
                </div>
                <!-- END TOP BAR MENU -->
            </div>
        </div>        
    </div>
    <!-- END TOP BAR -->

    <!-- BEGIN HEADER 横向菜单栏 -->
    <div class="header">
      <div class="container">
        <a class="site-logo" href="shop-index.html"><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/layout/img/logos/logo-shop-red.png" alt="Metronic Shop UI"></a>

        <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>


        <!-- BEGIN NAVIGATION -->
        <div class="header-navigation">
          <ul>
            <li class="dropdown dropdown-megamenu">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
              	  同城有约
              </a>
              <ul class="dropdown-menu">
                <li>
                  <div class="header-navigation-content">
                    <div class="row">
                      <div class="col-md-4 header-navigation-col">
                        <h4>Footwear</h4>
                        <ul>
                          <li><a href="shop-product-list.html">Astro Trainers</a></li>
                          <li><a href="shop-product-list.html">Basketball Shoes</a></li>
                          <li><a href="shop-product-list.html">Boots</a></li>
                          <li><a href="shop-product-list.html">Canvas Shoes</a></li>
                          <li><a href="shop-product-list.html">Football Boots</a></li>
                          <li><a href="shop-product-list.html">Golf Shoes</a></li>
                          <li><a href="shop-product-list.html">Hi Tops</a></li>
                          <li><a href="shop-product-list.html">Indoor and Court Trainers</a></li>
                        </ul>
                      </div>
                      <div class="col-md-4 header-navigation-col">
                        <h4>Clothing</h4>
                        <ul>
                          <li><a href="shop-product-list.html">Base Layer</a></li>
                          <li><a href="shop-product-list.html">Character</a></li>
                          <li><a href="shop-product-list.html">Chinos</a></li>
                          <li><a href="shop-product-list.html">Combats</a></li>
                          <li><a href="shop-product-list.html">Cricket Clothing</a></li>
                          <li><a href="shop-product-list.html">Fleeces</a></li>
                          <li><a href="shop-product-list.html">Gilets</a></li>
                          <li><a href="shop-product-list.html">Golf Tops</a></li>
                        </ul>
                      </div>
                      <div class="col-md-4 header-navigation-col">
                        <h4>Accessories</h4>
                        <ul>
                          <li><a href="shop-product-list.html">Belts</a></li>
                          <li><a href="shop-product-list.html">Caps</a></li>
                          <li><a href="shop-product-list.html">Gloves, Hats and Scarves</a></li>
                        </ul>

                        <h4>Clearance</h4>
                        <ul>
                          <li><a href="shop-product-list.html">Jackets</a></li>
                          <li><a href="shop-product-list.html">Bottoms</a></li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </li>
              </ul>
            </li>
            <li class="dropdown dropdown-megamenu">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
              	  美食天地
              </a>
              <ul class="dropdown-menu">
                <li>
                  <div class="header-navigation-content">
                    <div class="row">
                      <div class="col-md-4 header-navigation-col">
                        <h4>Footwear</h4>
                        <ul>
                          <li><a href="shop-product-list.html">Astro Trainers</a></li>
                          <li><a href="shop-product-list.html">Basketball Shoes</a></li>
                          <li><a href="shop-product-list.html">Boots</a></li>
                          
                        </ul>
                      </div>
                      <div class="col-md-4 header-navigation-col">
                        <h4>Clothing</h4>
                        <ul>
                          <li><a href="shop-product-list.html">Base Layer</a></li>
                          <li><a href="shop-product-list.html">Character</a></li>
                          <li><a href="shop-product-list.html">Chinos</a></li>
                          <li><a href="shop-product-list.html">Combats</a></li>
                          <li><a href="shop-product-list.html">Cricket Clothing</a></li>
                          <li><a href="shop-product-list.html">Fleeces</a></li>
                          <li><a href="shop-product-list.html">Gilets</a></li>
                          <li><a href="shop-product-list.html">Golf Tops</a></li>
                        </ul>
                      </div>
                      <div class="col-md-4 header-navigation-col">
                        <h4>Accessories</h4>
                        <ul>
                          <li><a href="shop-product-list.html">Belts</a></li>
                          <li><a href="shop-product-list.html">Caps</a></li>
                          <li><a href="shop-product-list.html">Gloves, Hats and Scarves</a></li>
                        </ul>

                        <h4>Clearance</h4>
                        <ul>
                          <li><a href="shop-product-list.html">Jackets</a></li>
                          <li><a href="shop-product-list.html">Bottoms</a></li>
                        </ul>
                      </div>
                      
                    </div>
                  </div>
                </li>
              </ul>
            </li>
          </ul>
        </div>
        <!-- END NAVIGATION -->
      </div>
    </div>
    <!-- Header END -->

    <!-- BEGIN SLIDER -->
    <div class="page-slider margin-bottom-35">
      <!-- LayerSlider start -->
      <div id="layerslider" style="width: 100%; height: 494px; margin: 0 auto;">

        <!-- 第一张图  slide one start -->
        <div class="ls-slide ls-slide1" data-ls="offsetxin: right; slidedelay: 7000; transition2d: 24,25,27,28;">

          <img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/layerslider/slide1/bg.jpg" class="ls-bg" alt="Slide background">

          <div class="ls-l ls-title" style="top: 96px; left: 35%; white-space: nowrap;" data-ls="
            fade: true; 
            fadeout: true; 
            durationin: 750; 
            durationout: 750; 
            easingin: easeOutQuint; 
            rotatein: 90; 
            rotateout: -90; 
            scalein: .5; 
            scaleout: .5; 
            showuntil: 4000;
          ">Tones of <strong>shop UI features</strong> designed</div>

          <div class="ls-l ls-mini-text" style="top: 338px; left: 35%; white-space: nowrap;" data-ls="
          fade: true; 
          fadeout: true; 
          durationout: 750; 
          easingin: easeOutQuint; 
          delayin: 300; 
          showuntil: 4000;
          ">Lorem ipsum dolor sit amet  constectetuer diam<br > adipiscing elit euismod ut laoreet dolore.
          </div>
        </div>
        <!-- slide one end -->

        <!-- 第二张图  slide two start -->
        <div class="ls-slide ls-slide2" data-ls="offsetxin: right; slidedelay: 7000; transition2d: 110,111,112,113;">

          <img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/layerslider/slide2/bg.jpg" class="ls-bg" alt="Slide background">
          
          <div class="ls-l ls-title" style="top: 40%; left: 21%; white-space: nowrap;" data-ls="
          fade: true; 
          fadeout: true;  
          durationin: 750; durationout: 109750; 
          easingin: easeOutQuint; 
          easingout: easeInOutQuint; 
          delayin: 0; 
          delayout: 0; 
          rotatein: 90; 
          rotateout: -90; 
          scalein: .5; 
          scaleout: .5; 
          showuntil: 4000;
          "><strong>Unlimted</strong> Layout Options <em>Fully Responsive</em>
            </div>

          <div class="ls-l ls-price" style="top: 50%; left: 45%; white-space: nowrap;" data-ls="
          fade: true; 
          fadeout: true;  
          durationout: 109750; 
          easingin: easeOutQuint; 
          delayin: 300; 
          scalein: .8; 
          scaleout: .8; 
          showuntil: 4000;"><b>from</b> <strong><span>$</span>25</strong>
          </div>

          <a href="#" class="ls-l ls-more" style="top: 72%; left: 21%; display: inline-block; white-space: nowrap;" data-ls="
          fade: true; 
          fadeout: true; 
          durationin: 750; 
          durationout: 750; 
          easingin: easeOutQuint; 
          easingout: easeInOutQuint; 
          delayin: 0; 
          delayout: 0; 
          rotatein: 90; 
          rotateout: -90; 
          scalein: .5; 
          scaleout: .5; 
          showuntil: 4000;">See More Details
          </a>
        </div>
        <!-- slide two end -->

        <!-- 第三张图   slide three start -->
        <div class="ls-slide ls-slide3" data-ls="offsetxin: right; slidedelay: 7000; transition2d: 92,93,105;">

          <img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/layerslider/slide3/bg.jpg" class="ls-bg" alt="Slide background">
          
          <div class="ls-l ls-title" style="top: 83px; left: 33%; white-space: nowrap;" data-ls="
          fade: true; 
          fadeout: true; 
          durationin: 750; 
          durationout: 750; 
          easingin: easeOutQuint; 
          rotatein: 90; 
          rotateout: -90; 
          scalein: .5; 
          scaleout: .5; 
          showuntil: 4000;
          ">Full Admin &amp; Frontend <strong>eCommerce UI</strong> Is Ready For Your Project
          </div>
          <div class="ls-l" style="top: 333px; left: 33%; white-space: nowrap; font-size: 20px; font: 20px 'Open Sans Light', sans-serif;" data-ls="
          fade: true; 
          fadeout: true; 
          durationout: 750; 
          easingin: easeOutQuint; 
          delayin: 300; 
          scalein: .8; 
          scaleout: .8; 
          showuntil: 4000;
          ">
            <a href="#" class="ls-buy">
              Buy It Now!
            </a>
            <div class="ls-price">
              <span>All these for only:</span>
              <strong>25<sup>$</sup></strong>
            </div>
          </div>
        </div>
        <!-- slide three end -->

        <!-- 第四张图  slide four start -->
        <div class="ls-slide ls-slide4" data-ls="offsetxin: right; slidedelay: 7000; transition2d: 110,111,112,113;">

          <img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/layerslider/slide5/bg.jpg" class="ls-bg" alt="Slide background">
          
          <div class="ls-l ls-title" style="top: 35%; left: 60%; white-space: nowrap;" data-ls="
          fade: true; 
          fadeout: true; 
          durationin: 750; 
          durationout: 750; 
          easingin: easeOutQuint; 
          rotatein: 90; 
          rotateout: -90; 
          scalein: .5; 
          scaleout: .5; 
          showuntil: 4000;">
          The most<br>
          wanted bijouterie
          </div>

          <div class="ls-l ls-mini-text" style="top: 70%; left: 60%; white-space: nowrap;" data-ls="
          fade: true; 
          fadeout: true;  
          durationout: 750; 
          easingin: easeOutQuint; 
          delayin: 300; 
          scalein: .8; 
          scaleout: .8; 
          showuntil: 4000;">
          <span>Lorem ipsum and</span>
          <a href="#">Buy It Now!</a>
          </div>

        </div>
        <!-- slide four end -->
      </div>
      <!-- LayerSlider end -->
    </div>
    <!-- END SLIDER -->

    <div class="main">
      <div class="container">
        <!-- BEGIN SALE PRODUCT & NEW ARRIVALS -->
        <div class="row margin-bottom-40">
          <!-- BEGIN SALE PRODUCT -->
          <!-- 轮播图 -->
          <div class="col-md-12 sale-product">
            <h2>新朋友</h2>
            <div class="owl-carousel owl-carousel5">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model1.jpg" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model1.jpg" class="btn btn-default fancybox-button">Zoom</a>
                      <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                    </div>
                  </div>
                  <h3><a href="shop-item.html">Berry Lace Dress</a></h3>
                  <div class="pi-price">李四</div>
                  <a href="#" class="btn btn-default add2cart">添加关注</a>
                  <div class="sticker sticker-sale"></div>
                </div>
              </div>
              
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model2.jpg" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model2.jpg" class="btn btn-default fancybox-button">Zoom</a>
                      <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                    </div>
                  </div>
                  <h3><a href="shop-item.html">Berry Lace Dress2</a></h3>
                  <div class="pi-price">张三</div>
                  <a href="#" class="btn btn-default add2cart">添加关注</a>
                </div>
              </div>
              
              
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model6.jpg" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model6.jpg" class="btn btn-default fancybox-button">Zoom</a>
                      <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                    </div>
                  </div>
                  <h3><a href="shop-item.html">Berry Lace Dress2</a></h3>
                  <div class="pi-price">王五</div>
                  <a href="#" class="btn btn-default add2cart">添加关注</a>
                </div>
              </div>
              
              
              <div>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model4.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model4.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="#">Berry Lace Dress4</a></h3>
                    <div class="pi-price">孙六</div>
                    <a href="#" class="btn btn-default add2cart">添加关注</a>
                    <div class="sticker sticker-new"></div>
                  </div>
              </div>
              
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model5.jpg" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model5.jpg" class="btn btn-default fancybox-button">Zoom</a>
                      <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                    </div>
                  </div>
                  <h3><a href="shop-item.html">Berry Lace Dress5</a></h3>
                  <div class="pi-price">田七</div>
                  <a href="#" class="btn btn-default add2cart">添加关注</a>
                </div>
              </div>
              
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model3.jpg" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model3.jpg" class="btn btn-default fancybox-button">Zoom</a>
                      <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                    </div>
                  </div>
                  <h3><a href="shop-item.html">Berry Lace Dress3</a></h3>
                  <div class="pi-price">钱八</div>
                  <a href="#" class="btn btn-default add2cart">添加关注</a>
                </div>
              </div>
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model7.jpg" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model7.jpg" class="btn btn-default fancybox-button">Zoom</a>
                      <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                    </div>
                  </div>
                  <h3><a href="shop-item.html">Berry Lace Dress3</a></h3>
                  <div class="pi-price">周十</div>
                  <a href="#" class="btn btn-default add2cart">添加关注</a>
                </div>
              </div>
            </div>
          </div>
          <!-- END SALE PRODUCT -->
        </div>
        <!-- END SALE PRODUCT & NEW ARRIVALS -->

        </div>        
        <!-- END TWO PRODUCTS & PROMO -->
      </div>
    </div>

    <!-- BEGIN BRANDS -->
    <div class="brands">
      <div class="container">
            <div class="owl-carousel owl-carousel6-brands">
              <a href="shop-product-list.html"><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/brands/canon.jpg" alt="canon" title="canon"></a>
              <a href="shop-product-list.html"><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/brands/esprit.jpg" alt="esprit" title="esprit"></a>
              <a href="shop-product-list.html"><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/brands/gap.jpg" alt="gap" title="gap"></a>
              <a href="shop-product-list.html"><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/brands/next.jpg" alt="next" title="next"></a>
              <a href="shop-product-list.html"><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/brands/puma.jpg" alt="puma" title="puma"></a>
              <a href="shop-product-list.html"><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/brands/zara.jpg" alt="zara" title="zara"></a>
              <a href="shop-product-list.html"><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/brands/canon.jpg" alt="canon" title="canon"></a>
              <a href="shop-product-list.html"><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/brands/esprit.jpg" alt="esprit" title="esprit"></a>
              <a href="shop-product-list.html"><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/brands/gap.jpg" alt="gap" title="gap"></a>
              <a href="shop-product-list.html"><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/brands/next.jpg" alt="next" title="next"></a>
              <a href="shop-product-list.html"><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/brands/puma.jpg" alt="puma" title="puma"></a>
              <a href="shop-product-list.html"><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/brands/zara.jpg" alt="zara" title="zara"></a>
            </div>
        </div>
    </div>
    <!-- END BRANDS -->

    <!-- BEGIN STEPS -->
    <div class="steps-block steps-block-red">
      <div class="container">
        <div class="row">
          <div class="col-md-4 steps-block-col">
            <i class="fa fa-truck"></i>
            <div>
              <h2>免费注册</h2>
              <em>实名会员注册</em>
            </div>
            <span>&nbsp;</span>
          </div>
          <div class="col-md-4 steps-block-col">
            <i class="fa fa-gift"></i>
            <div>
              <h2>每天惊喜</h2>
              <em>内容实时更新</em>
            </div>
            <span>&nbsp;</span>
          </div>
          <div class="col-md-4 steps-block-col">
            <i class="fa fa-phone"></i>
            <div>
              <h2>18019563065</h2>
              <em>随时提供咨询服务</em>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- END STEPS -->

    <!-- BEGIN PRE-FOOTER -->
    <div class="pre-footer">
      <div class="container">
        <div class="row">
          <!-- BEGIN BOTTOM ABOUT BLOCK -->
          <div class="col-md-3 col-sm-6 pre-footer-col">
            <h2>关于我们</h2>
            <p>致力于打造属于我们自己的同城交流休闲平台,美好家园一起创建,美好事物一起分享</p>
            <p>吃喝玩乐一起来</p>
          </div>
          <!-- END BOTTOM ABOUT BLOCK -->
          <!-- BEGIN BOTTOM INFO BLOCK -->
          <div class="col-md-3 col-sm-6 pre-footer-col">
            <h2>信息</h2>
            <ul class="list-unstyled">
              <!--<li><i class="fa fa-angle-right"></i> <a href="#">Delivery Information</a></li>
              <li><i class="fa fa-angle-right"></i> <a href="#">Customer Service</a></li>
              <li><i class="fa fa-angle-right"></i> <a href="#">Order Tracking</a></li>
              <li><i class="fa fa-angle-right"></i> <a href="#">Shipping &amp; Returns</a></li>
              <li><i class="fa fa-angle-right"></i> <a href="#">Careers</a></li>
               -->
              <li><i class="fa fa-angle-right"></i> <a href="contacts.html">联系我们</a></li>
              <li><i class="fa fa-angle-right"></i> <a href="#">支付方式</a></li>
            </ul>
          </div>
          <!-- END INFO BLOCK -->

          <!-- BEGIN TWITTER BLOCK --> 
          <div class="col-md-3 col-sm-6 pre-footer-col">
            <h2 class="margin-bottom-0">支付宝</h2>
            <a class="twitter-timeline" href="#" data-tweet-limit="2" data-theme="dark" data-link-color="#57C8EB" data-widget-id="455411516829736961" data-chrome="noheader nofooter noscrollbar noborders transparent">wuyechun2010@163.com</a>      
          </div>
          <!-- END TWITTER BLOCK -->

          <!-- BEGIN BOTTOM CONTACTS -->
          <div class="col-md-3 col-sm-6 pre-footer-col">
            <h2>联系我们</h2>
            <address class="margin-bottom-40">
          	      电话: 18019563065<br>
              QQ: 904261233<br>
              Email: <a href="mailto:wuyechun2010@163.com">wuyechun2010@163.com</a><br>
            </address>
          </div>
          <!-- END BOTTOM CONTACTS -->
        </div>
        <hr>
      </div>
    </div>
    <!-- END PRE-FOOTER -->

    <!-- BEGIN FOOTER -->
    <div class="footer">
      <div class="container">
        <div class="row">
          <!-- BEGIN COPYRIGHT -->
          <div class="col-md-6 col-sm-6 padding-top-10">
            © 我爱南陵 所有 皖ICP备16003309号 340223198808230010 违法不良信息举报
          </div>
          <!-- END COPYRIGHT -->
          <!-- BEGIN PAYMENTS -->
          <div class="col-md-6 col-sm-6">
            <ul class="list-unstyled list-inline pull-right">
              <li><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/layout/img/payments/western-union.jpg" alt="We accept Western Union" title="We accept Western Union"></li>
              <li><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/layout/img/payments/american-express.jpg" alt="We accept American Express" title="We accept American Express"></li>
              <li><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/layout/img/payments/MasterCard.jpg" alt="We accept MasterCard" title="We accept MasterCard"></li>
              <li><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/layout/img/payments/PayPal.jpg" alt="We accept PayPal" title="We accept PayPal"></li>
              <li><img src="${ctx}/resources/metronic-3.1.3/assets/frontend/layout/img/payments/visa.jpg" alt="We accept Visa" title="We accept Visa"></li>
            </ul>
          </div>
          <!-- END PAYMENTS -->
        </div>
      </div>
    </div>
    <!-- END FOOTER -->

    <!-- BEGIN fast view of a product -->
    <div id="product-pop-up" style="display: none; width: 700px;">
            <div class="product-page product-pop-up">
              <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-3">
                  <div class="product-main-image">
                    <img src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model7.jpg" alt="Cool green dress with red bell" class="img-responsive">
                  </div>
                  <div class="product-other-images">
                    <a href="#" class="active"><img alt="Berry Lace Dress" src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model3.jpg"></a>
                    <a href="#"><img alt="Berry Lace Dress" src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model4.jpg"></a>
                    <a href="#"><img alt="Berry Lace Dress" src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/img/products/model5.jpg"></a>
                  </div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-9">
                  <h2>Cool green dress with red bell</h2>
                  <div class="price-availability-block clearfix">
                    <div class="price">
                      <strong><span>$</span>47.00</strong>
                      <em>$<span>62.00</span></em>
                    </div>
                    <div class="availability">
                      Availability: <strong>In Stock</strong>
                    </div>
                  </div>
                  <div class="description">
                    <p>Lorem ipsum dolor ut sit ame dolore  adipiscing elit, sed nonumy nibh sed euismod laoreet dolore magna aliquarm erat volutpat 
Nostrud duis molestie at dolore.</p>
                  </div>
                  <div class="product-page-options">
                    <div class="pull-left">
                      <label class="control-label">Size:</label>
                      <select class="form-control input-sm">
                        <option>L</option>
                        <option>M</option>
                        <option>XL</option>
                      </select>
                    </div>
                    <div class="pull-left">
                      <label class="control-label">Color:</label>
                      <select class="form-control input-sm">
                        <option>Red</option>
                        <option>Blue</option>
                        <option>Black</option>
                      </select>
                    </div>
                  </div>
                  <div class="product-page-cart">
                    <div class="product-quantity">
                        <input id="product-quantity" type="text" value="1" readonly name="product-quantity" class="form-control input-sm">
                    </div>
                    <button class="btn btn-primary" type="submit">添加关注</button>
                    <a href="shop-item.html" class="btn btn-default">More details</a>
                  </div>
                </div>

                <div class="sticker sticker-sale"></div>
              </div>
            </div>
    </div>
    <!-- END fast view of a product -->

    <!-- Load javascripts at bottom, this will reduce page load time -->
    <!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
    <!--[if lt IE 9]>
    <script src="${ctx}/resources/metronic-3.1.3/assets/global/plugins/respond.min.js"></script>  
    <![endif]-->
    <script src="${ctx}/resources/metronic-3.1.3/assets/global/plugins/jquery-1.11.0.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/metronic-3.1.3/assets/global/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/metronic-3.1.3/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
    <script src="${ctx}/resources/metronic-3.1.3/assets/frontend/layout/scripts/back-to-top.js" type="text/javascript"></script>
    <script src="${ctx}/resources/metronic-3.1.3/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- END CORE PLUGINS -->

    <!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
    <script src="${ctx}/resources/metronic-3.1.3/assets/global/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
    <script src="${ctx}/resources/metronic-3.1.3/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.min.js" type="text/javascript"></script><!-- slider for products -->
    <script src='${ctx}/resources/metronic-3.1.3/assets/global/plugins/zoom/jquery.zoom.min.js' type="text/javascript"></script><!-- product zoom -->
    <script src="${ctx}/resources/metronic-3.1.3/assets/global/plugins/bootstrap-touchspin/bootstrap.touchspin.js" type="text/javascript"></script><!-- Quantity -->

    <!-- BEGIN LayerSlider -->
    <script src="${ctx}/resources/metronic-3.1.3/assets/global/plugins/slider-layer-slider/js/greensock.js" type="text/javascript"></script><!-- External libraries: GreenSock -->
    <script src="${ctx}/resources/metronic-3.1.3/assets/global/plugins/slider-layer-slider/js/layerslider.transitions.js" type="text/javascript"></script><!-- LayerSlider script files -->
    <script src="${ctx}/resources/metronic-3.1.3/assets/global/plugins/slider-layer-slider/js/layerslider.kreaturamedia.jquery.js" type="text/javascript"></script><!-- LayerSlider script files -->
    <script src="${ctx}/resources/metronic-3.1.3/assets/frontend/pages/scripts/layerslider-init.js" type="text/javascript"></script>
    <!-- END LayerSlider -->

    <script src="${ctx}/resources/metronic-3.1.3/assets/frontend/layout/scripts/layout.js" type="text/javascript"></script>
    <script type="text/javascript">
        jQuery(document).ready(function() {
            Layout.init();    
            Layout.initOWL();
            LayersliderInit.initLayerSlider();
            Layout.initImageZoom();
            Layout.initTouchspin();
            Layout.initTwitter();
        });
    </script>
    <!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>