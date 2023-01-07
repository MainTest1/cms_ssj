<header id="header" class="header">
    <div class="container"><!-- LOGO -->
        <div class="logo text-center"><a href="index-2.html"><img src="images/logo.png" alt=""></a></div>
        <!-- END / LOGO --></div><!-- NAVIGATION -->
    <nav class="pi-navigation" data-menu-responsive="1200">
        <div class="container">
            <div class="open-menu"><span class="item item-1"></span><span class="item item-2"></span><span
                        class="item item-3"></span></div>
            <div class="close-menu"></div>
            <ul class="navlist">
                <#list cmsTitleList as cmsTitle>
                    <li class="current-menu-parent
                        <#if cmsTitle.childList?? && (cmsTitle.childList?size >0) >menu-item-has-children </#if>
                        ">
                        <a href="#">${cmsTitle.titleName}</a>
                        <#if cmsTitle.childList?? && (cmsTitle.childList?size >0) >
                            <ul class="sub-menu">
                                <#list cmsTitle.childList as child >
                                    <li class="menu-item-has-children">
                                        <a href="#">${child.titleName}</a>
                                    </li>
                                </#list>
                            </ul>
                        </#if>
                    </li>
                </#list>
            </ul>
            <div class="search-box"><span class="icon-search"><i class="fa fa-search"></i></span>
                <form action="http://v.bootstrapmb.com/2018/7/fsjud1659/GET"><input type="search"
                                                                                    value="Search and hit enter">
                </form>
            </div>
            <div class="share-box"><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i
                            class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-dribbble"></i></a><a href="#"><i
                            class="fa fa-pinterest"></i></a></div>
        </div>
    </nav><!-- END / NAVIGATION --></header><!-- END / HEADER --><!-- FEATURED -->