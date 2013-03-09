<jsp:useBean id="pageDescriptor" class="com.xa.webui.persistence.domain.component.page.PageSingleDescriptor" scope="page">
    <jsp:setProperty name="pageDescriptor" property="topMenu" value="${actionBean.descriptor.topMenu}"/>  
</jsp:useBean>

<% if (pageDescriptor.getTopMenu() != null) { %>



<html lang="en">
    <head>
        <link rel="shortcut icon" href="favicon.ico">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>XA - International Trade Advisors</title>

        <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
        <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
        <![endif]-->

        <link href="css/bootstrap.css" media="all" rel="stylesheet" type="text/css">
        <link href="css/font-awesome.css" media="all" rel="stylesheet" type="text/css">
        <link href="css/style.css" media="all" rel="stylesheet" type="text/css">
        <link href="css/style-responsive.css" media="all" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" media="all" href="css/colors/black.css" id="colors">
        <link href="css/flexslider.css" media="all" rel="stylesheet" type="text/css">

        <!-- Styles Switcher -->
        <link rel="stylesheet" type="text/css" href="css/switcher.css">

    </head>
    <body>

        <!-- Start Top Nav -->

        <div class="topnav">
            <div class="container">
                <ul class="pull-right">
                    <li><a href="#"></a></li>
                    <li><a href="#"><i class="icon-user"></i><t>Login</t></a></li>
                    <li><a href="#"><i class="icon-group"></i><t>Our Team</t></a></li>
                </ul>
            </div>
        </div>

        <!-- End Top Nav -->

        <!-- Start Main Nav -->

        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a href="index.html" class="brand">
                        <img id="logo" alt="XA - International Trade Advisors" src="image/xalogo.png">
                    </a>
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

        <!-- Start Footer -->     

        <div id="footer">
            <div class="container">

                <div class="links">
                    <ul class="unstyled">
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Press</a></li>
                        <li><a href="#">Partner with maJoo</a></li>
                        <li><a href="#">Terms</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Jobs</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- End Footer -->

        <!-- Javascripts  ================================================== -->

        <div class="fit-vids-style">­<style>               .fluid-width-video-wrapper {                 width: 100%;                              position: relative;                       padding: 0;                            }                                                                                   .fluid-width-video-wrapper iframe,        .fluid-width-video-wrapper object,        .fluid-width-video-wrapper embed {           position: absolute;                       top: 0;                                   left: 0;                                  width: 100%;                              height: 100%;                          }                                       </style></div><script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/bootstrap-tab.js"></script>
        <script src="js/bootstrap-transition.js"></script>
        <script src="js/fancybox.js"></script>
        <script src="js/custom.js"></script>
        <script src="js/jquery.fitvids.js"></script>
        <script src="js/sliderjs.js"></script>
        <script src="js/switcher.js"></script>
        <script src="js/flexslider.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('.image-slider').flexslider({
                    animation: "fade",
                    slideshowSpeed: 4000,
                    animationDuration: 1000,
                    controlNav: false,
                    keyboardNav: true,
                    directionNav: true,
                    pauseOnHover: true,
                    pauseOnAction: true    
                });

    	
            });
        </script>
        <script>
            //  Slider
   $(document).ready(function(){
        $('#slides').slides({
            effect: 'fade',
            play: 2000,
            pause: 2500,
            autoWidth: true,
            hoverPause: true,
            paginationClass: 'paging',
            start: 1
          
        });
    });

//Slider End
</script>
        <script>
            $(".feature-tab").click(function(){
                show_feature($(this).attr("id"),this)
                return false;
            });

            var show_feature = function(feature,from){
                $(".feature-tab").removeClass("current");
                $("#" + feature).addClass("current");
                $(".slide-content").hide();
                if(from != 'link'){
                    $("#" + feature + "-content").removeClass("hide");
                }else{
                    $("#" + feature + "-content").fadeIn('slow');
                }
            }
        </script>
    
    </body>
</html>


<% } %>
