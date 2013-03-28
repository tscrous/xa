<jsp:useBean id="pageDescriptor" class="com.xa.webui.persistence.domain.component.page.PageSingleDescriptor" scope="page">
    <jsp:setProperty name="pageDescriptor" property="topMenu" value="${actionBean.descriptor.topMenu}"/>  
</jsp:useBean>

<% if (pageDescriptor.getTopMenu() != null) { %>



<html lang="en">
    <head>
        <meta charset="utf-8">
        <!-- Always force latest IE rendering engine or request Chrome Frame -->
        <!-- Always force latest IE rendering engine or request Chrome Frame -->
        <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
        <!-- Use title if it's in the page YAML frontmatter -->
        <meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0">
        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!-- there's an IE separated stylesheet with the following resets for IE -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <link rel="shortcut icon" href="favicon.ico">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <title>XA - International Trade Advisors</title>

        <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
        <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
        <![endif]-->

        <link href="css/bootstrap-responsive.css" media="all" rel="stylesheet" type="text/css">
        <link href="css/font-awesome.css" media="all" rel="stylesheet" type="text/css">
<link href="css/application.css" media="all" rel="stylesheet" type="text/css">
        <link href="css/style.css" media="all" rel="stylesheet" type="text/css">
        <link href="css/style-responsive.css" media="all" rel="stylesheet" type="text/css">
    </head>
    <body>

        
<div id="wrap">

        <!-- Start Top Nav -->
        
    <div class="row-fluid">

        <div class="topnav">
            <div class="offset1 span10">

                <div class="container center">
                    <div class="span2">
                        <div class="brand">
                            <a class="brand_small" href=""><img src="image/xalogo_small.png" al alt="XA -"><span>&nbsp;International Trade Advisors</span></a>
                        </div>
                    </div>
                    <div class="span1"></div>
                    <div class="span6">
                        <div class="main-menu-alt nav-collapse collapse navbar-responsive-collapse">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="index.jsp"><i class="icon-home"></i> Home</a></li>
                                <li><a href="#">About XA</a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Open cases <b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="about.html">Case 1</a></li>
                                        <li><a href="services.html">Case 2</a></li>
                                        <li><a href="full_width.html">Case 3</a></li>
                                        <li><a href="sidebar_right.html">Case 4</a></li>
                                    </ul>
                                </li>
                                <li><a href="contact.html">Contact us</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="span3">
                        <div class="top-menu">
                            <ul class="pull-right">
                                <li><a href="#"><i class="icon-user"></i><t>Login</t></a></li>
                                <li><a href="#"><i class="icon-group"></i><t>Our Team</t></a></li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>

        
        <!-- Start Main Nav -->

    <div class="row-fluid">

        <div class="navbar">
            <div class="offset1 span10">

                    <div class="container">
                        <div class="span2">
                            <div class="brand">
                                    <a class="brand_large" href=""><img src="image/xalogo.png" al alt="XA - International Trade Advisors"></a>
                            </div>
                        </div>
                        <div class="span1"></div>
                        <div class="span9">

                            <div class="nav-collapse collapse navbar-responsive-collapse">
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="index.jsp"><i class="icon-home"></i> Home</a></li>
                                    <li><a href="#">About XA</a></li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Open cases <b class="caret"></b></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="about.html">Case 1</a></li>
                                            <li><a href="services.html">Case 2</a></li>
                                            <li><a href="full_width.html">Case 3</a></li>
                                            <li><a href="sidebar_right.html">Case 4</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="contact.html">Contact us</a></li>
                                </ul>
                            </div>

                        </div>
                    </div>

            </div>
        </div>

    </div>

        <!-- Start Body -->

    <div class="row-fluid">

        <img class="body-background-img" src="image/xa_herobanner_3.png"/>
        <div class="offset1 span10">
            <div class="offset1 options center">

                <div class="option-container">
                    <div class="option-content">
                        <input type="button" style="color: transparent; background-color: transparent; border-color: transparent; cursor: default;">
                        <div class="option-name"><span>Facing import competition ?</span></div>
                        <div class="option-description"><p>Are you struggling to compete with low priced imports?<br/><br/>Would you like to access protection against such imports?</p></div>
                        <div class="option-actions  action-tooltip"><span><a href="#">TELL ME MORE <i class="icon-arrow-right icon-white"></i></a></span></div>
                        <div class="option-watermark"><span>?</span></div>
                        <div class="option-stats">
                            <div class="item-group-vertical">
                                <span class="option-stats-item group-item"><a href="#"><i class="icon-search icon-white"></i></a><div class="option-stats-info">viewed 116 times</div></span>
                                <span class="option-stats-item group-item"><a href="#"><i class="icon-star"></i></a><div class="option-stats-info">useful to 1,965,400,000,000 people</div></span>
                                <span class="option-stats-item group-item"><a href="#"><i class="icon-folder-open"></i></a><div class="option-stats-info">10 open cases related to topic</div></span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="option-container">
                    <div class="option-content">
                        <div class="option-name"><span>Facing duty increases ?</span></div>
                        <div class="option-description"><p>Have you just found out about a duty increase application?<br/><br/>Are you on the receiving end of an anti-dumping or safeguard application?</p></div>
                        <div class="option-actions"><span><a href="#">TELL ME MORE <i class="icon-arrow-right icon-white"></i></a></span></div>
                        <div class="option-watermark"><span>?</span></div>
                        <div class="option-stats">
                            <div class="item-group-vertical">
                                <span class="option-stats-item group-item"><a href="#"><i class="icon-search icon-white"></i></a><div class="option-stats-info">viewed 1 time</div></span>
                                <span class="option-stats-item group-item"><a href="#"><i class="icon-star"></i></a><div class="option-stats-info">useful to 1 person</div></span>
                                <span class="option-stats-item group-item"><a href="#" class="disabled"><i class="icon-folder-open"></i></a><div class="option-stats-info"></div></span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="option-container">
                    <div class="option-content">
                        <div class="option-name"><span>Trying to improve competitiveness ?</span></div>
                        <div class="option-description"><p>There are many options to make competitors more competitive.<br/><br/>We can help you to achieve that.</p></div>
                        <div class="option-actions"><span><a href="#">TELL ME MORE <i class="icon-arrow-right icon-white"></i></a></span></div>
                        <div class="option-watermark"><span>?</span></div>
                        <div class="option-stats">
                            <div class="item-group-vertical">
                                <span class="option-stats-item group-item"><a href="#" class="disabled"><i class="icon-search icon-white"></i></a><div class="option-stats-info"></div></span>
                                <span class="option-stats-item group-item"><a href="#" class="disabled"><i class="icon-star"></i></a><div class="option-stats-info"></div></span>
                                <span class="option-stats-item group-item"><a href="#" class="disabled"><i class="icon-folder-open"></i></a><div class="option-stats-info"></div></span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="option-container">
                    <div class="option-content">
                        <div class="option-name"><span>Looking for incentives ?</span></div>
                        <div class="option-description"><p>If you are planning to make any sort of significant investment in your business, there may be cash or tax incentives available to you.</p></div>
                        <div class="option-actions"><span><a href="#">TELL ME MORE <i class="icon-arrow-right icon-white"></i></a></span></div>
                        <div class="option-watermark"><span>?</span></div>
                        <div class="option-stats">
                            <div class="item-group-vertical">
                                <span class="option-stats-item group-item"><a href="#" class="disabled"><i class="icon-search icon-white"></i></a><div class="option-stats-info"></div></span>
                                <span class="option-stats-item group-item"><a href="#" class="disabled"><i class="icon-star"></i></a><div class="option-stats-info"></div></span>
                                <span class="option-stats-item group-item"><a href="#"><i class="icon-folder-open"></i></a><div class="option-stats-info">1 open case related to topic</div></span>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>

</div>
        
        
        <!-- Start Footer -->
        
    <div class="row-fluid">

        <div class="footer">
            <div class="offset1 span10">

                <div class="container">
                    <div class="span4">
                        <div class="links">
                            <ul class="unstyled">
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Press</a></li>
                                <li><a href="#">Partner with maJoo</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="span4">
                        <div class="links">
                            <ul class="unstyled">
                                <li><a href="#">Terms</a></li>
                                <li><a href="#">Privacy Policy</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="span4">
                        <div class="links">
                            <ul class="unstyled">
                                <li><a href="#">Jobs</a></li>
                                <li><a href="#">Contact Us</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>

    
        <!-- Javascripts  ================================================== -->

        <script src="js/jquery.js"></script>
        <script src="js/jquery.fitvids.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/bootstrap-tab.js"></script>
        <script src="js/bootstrap-transition.js"></script>
        <script src="js/bootstrap-tooltip.js"></script>

        
        
    <!-- Screen maximization via LOGO -->

    <script type="text/javascript">
        $(document).ready(function(){
            $(".brand_large").click(function(){
                maximiseScreen(true);
                return false;
            });
            $(".brand_small").click(function(){
                maximiseScreen(false);
                return false;
            });
        });

        var maximiseScreen = function(maximise){
            if (maximise) {
                $(".navbar").hide();
                $(".topnav").css('border-bottom-color','#FFE0BF')
                $(".brand_small").show();
                $(".main-menu-alt").show();
            } else {
                $(".main-menu-alt").hide();
                $(".brand_small").hide();
                $(".topnav").css('border-bottom-color','#404040')
                $(".navbar").show();
            }
        }
    </script>

    <script>
        $.fn.extend({ 
            disableSelection: function() { 
                this.each(function() { 
                    if (typeof this.onselectstart != 'undefined') {
                        this.onselectstart = function() { return false; };
                    } else if (typeof this.style.MozUserSelect != 'undefined') {
                        this.style.MozUserSelect = 'none';
                    } else {
                        this.onmousedown = function() { return false; };
                    }
                }); 
            } 
        });

        $(document).ready(function() {
            $('.option-content').disableSelection();            
            $('.option-stats').disableSelection();            
        });
    </script>
    
    <script type="text/javascript">
        $(document).ready(function(){
            $(".brand_large").click(function(){
                maximiseScreen(true);
                return false;
            });
            $(".brand_small").click(function(){
                maximiseScreen(false);
                return false;
            });
        });

        var maximiseScreen = function(maximise){
            if (maximise) {
                $(".navbar").hide();
                $(".topnav").css('border-bottom-color','#FFE0BF')
                $(".brand_small").show();
                $(".main-menu-alt").show();
            } else {
                $(".main-menu-alt").hide();
                $(".brand_small").hide();
                $(".topnav").css('border-bottom-color','#404040')
                $(".navbar").show();
            }
        }
    </script>

</div>
        
</body>
</html>


<% } %>








