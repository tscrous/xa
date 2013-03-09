<jsp:useBean id="pageDescriptor" class="com.xa.webui.persistence.domain.component.page.PageSingleDescriptor" scope="page">
    <jsp:setProperty name="pageDescriptor" property="topMenu" value="${actionBean.descriptor.topMenu}"/>  
</jsp:useBean>


<% if (pageDescriptor.getTopMenu() != null) { %>

    <style type="text/css">
        #wrap {
            min-height: 100%;
            height: auto !important;
            height: 100%;
            margin: 0 auto -60px;
        }
        #push {
            height: 60px;
        }
    </style>

    <div id="wrap">
        <div class="container">
            <div class="row-fluid">
                <div class="span12">

                        <div class="navbar">
                          <div class="navbar-inner">
                            <div class="container">
                              <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                              </a>
                              <a class="brand" href="#"><img alt="" src="images/logo.png"></a>
                              <div class="nav-collapse collapse navbar-responsive-collapse">
                                <ul class="nav">
                                  <li class="active "><a href="#">Home</a></li>
                                  <li><a href="#">Link</a></li>
                                  <li><a href="#">Link</a></li>
                                  <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                      <li><a href="#">Action</a></li>
                                      <li><a href="#">Another action</a></li>
                                      <li><a href="#">Something else here</a></li>
                                      <li class="divider"></li>
                                      <li class="nav-header">Nav header</li>
                                      <li><a href="#">Separated link</a></li>
                                      <li><a href="#">One more separated link</a></li>
                                    </ul>
                                  </li>
                                </ul>
                                <form class="navbar-search pull-right span2" action="">
                                  <input type="text" class="search-query span12" placeholder="Search">
                                </form>
                                <ul class="nav pull-right">
                                  <li><a href="#">Link</a></li>
                                  <li class="divider-vertical"></li>
                                  <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Device <b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                      <li><a href="#">Action</a></li>
                                      <li><a href="#">Another action</a></li>
                                      <li><a href="#">Something else here</a></li>
                                      <li class="divider"></li>
                                      <li><a href="#">Separated link</a></li>
                                    </ul>
                                  <li class="divider-vertical"></li>
                                  </li>
                                </ul>
                              </div><!-- /.nav-collapse -->
                            </div>
                          </div><!-- /navbar-inner -->
                        </div><!-- /navbar -->

                </div>
            </div>
        </div>

        <div id="push"></div>
    </div>

<% } %>
