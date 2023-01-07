<!DOCTYPE html><!--[if IE 7 ]>
<html class="ie ie7"><![endif]--><!--[if IE 8 ]>
<html class="ie ie8"><![endif]--><!--[if IE 9 ]>
<html class="ie ie9"><![endif]--><!--[if (gt IE 9)|!(IE)]><!-->
<html class="" lang="en"><!--<![endif]-->
<!-- Mirrored from v.bootstrapmb.com/2018/7/fsjud1659/ by HTTrack Website Copier/3.x [XR&CO'2013], Fri, 01 Jul 2022 07:44:37 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-capable" content="yes"><!-- GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>
    <!-- CSS LIBRARY -->
    <link rel="stylesheet" type="text/css" href="css/lib/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/lib/owl.carousel.css">
    <link rel="stylesheet" type="text/css" href="css/lib/font-awesome.min.css"><!-- PAGE STYLE -->
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script><![endif]--><title>
        Winters</title></head>
<body><!-- PRELOADER -->
<div id="preloader">
    <div class="tb-cell">
        <div class="page-loading">
            <div class="item-icon"></div>
        </div>
    </div>
</div><!-- END / PRELOADER --><!-- PAGE WRAP -->
<div id="page-wrap"><!-- HEADER -->
    <#include "public/header.ftl" />
    <section class="featured">
        <div class="featured-slider"><!-- POST -->
            <#list cmsBannerList as cmsBanner>
                <div class="post">
                    <div class="post-media">
                        <div class="image-wrap"><img src="${cmsBanner.bannerImg}" width="400px" alt=""></div>
                    </div>
                    <div class="post-body"><span class="cat"><a href="#">${cmsBanner.bannerLabel}</a></span>
                        <div class="post-title"><h4><a href="#">${cmsBanner.bannerDesc}</a></h4></div>
                        <#--  <div class="post-meta"><span class="post-date">${cmsBanner.createDate?date('yyyy-MM-dd')}</span></div>-->
                    </div>
                </div><!-- END / POST --><!-- POST -->
            </#list>
        </div>
    </section><!-- END / FEATURED --><!-- BLOG MAIN CONTENT -->
    <section class="blog-content blog-standard">
        <div class="container">
            <div class="row"><!-- CONTENT -->
                <div class="col-md-10">
                    <div class="content"><!-- POST -->
                        <#list cmsArticlesList as  cmsArticles>
                            <div class="post">
                                <div class="post-body">
                                    <div class="post-media">
                                        <div class="image-wrap"><img width="945px" src="${cmsArticles.articleImg}" alt=""></div>
                                    </div>
                                    <div class="post-author">
                                        <div class="image-thumb"><img src="images/author/1.jpg" alt=""></div>
                                        <div class="name-author"><cite>作者</cite></div>
                                    </div>
                                    <div class="post-title">
                                        <h2>
                                            <a href="single.ftl">${cmsArticles.articleTitle}</a>
                                        </h2>
                                    </div>
                                    <div class="post-entry"><p>${cmsArticles.articleIntro}</p></div>
                                    <div class="post-link"><a href="singleDetail?articlesId=${cmsArticles.id}" class="pi-btn">详情</a></div>
                                </div>
                            </div><!-- END / POST --><!-- POST -->
                        </#list>
                        <div class="pagination">
                            <a href="#" class="prev">&laquo; 上一页</a>
                            <a href="#" class="next">下一页 &raquo;</a>
                        </div><!-- END / PAGINATION --></div>
                </div><!-- END / CONTENT --><!-- SIDEBAR -->
            </div>
        </div>
    </section><!-- BLOG MAIN CONTENT --><!-- FOOTER -->
    <footer id="footer" class="footer">
        <div class="copyright text-center"><p>Copyrights © 2014 All Rights Reserved by Xgio</p></div>
    </footer><!-- END / FOOTER --></div><!-- END / PAGE WRAP --><!-- LOAD JQUERY -->
<script type="text/javascript" src="js/lib/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/lib/jquery.owl.carousel.js"></script>
<script type="text/javascript" src="js/lib/jquery.tweet.min.js"></script>
<script type="text/javascript" src="js/lib/masonry.pkgd.min.js"></script>
<script type="text/javascript" src="js/lib/retina.min.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
</body>
<!-- Mirrored from v.bootstrapmb.com/2018/7/fsjud1659/ by HTTrack Website Copier/3.x [XR&CO'2013], Fri, 01 Jul 2022 07:45:14 GMT -->
</html>