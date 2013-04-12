<%@page import="com.xa.webui.persistence.domain.component.page.PageDescriptor"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>

<jsp:useBean id="pageDescriptor" class="com.xa.webui.persistence.domain.component.page.BasicPageDescriptor" scope="page">
    <jsp:setProperty name="pageDescriptor" property="topMenu" value="${actionBean.descriptor.topMenu}"/>  
    <jsp:setProperty name="pageDescriptor" property="content" value="${actionBean.descriptor.content}"/>  
</jsp:useBean>

<%
    String currentPage = pageDescriptor.getContent() != null ? pageDescriptor.getContent().getValue().getValue() : null;
    boolean isHome = currentPage == null || currentPage.contains("home");
    boolean isAbout = currentPage.contains("about");
    boolean isOpenCases = currentPage.contains("open");
    boolean isOurTeam = currentPage.contains("team");
    boolean isContactUs = currentPage.contains("contact");
%>
    <!-------------------------- Start: Top Nav -------------------------->
    <div class="row-fluid">

        <div class="topnav">
            <div class="offset1 span10">

                <div class="container">
                    <div class="span2">
                        <div class="brand">
                            <a class="brand_small" href=""><img src="image/xalogo_small.png" al alt="XA -"><span>&nbsp;International Trade Advisors</span></a>
                        </div>
                    </div>
                    <div class="span1"></div>
                    <div class="span7"></div>
                    <div class="span2">
                        <div class="top-menu">
                            <ul class="pull-right">
                                <li><a href="#"><i class="icon-user"></i><t>Login</t></a></li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>
    <!-------------------------- End: Top Nav -------------------------->

    <!-------------------------- Start: Main Nav -------------------------->
    <div class="row-fluid">

        <div class="navbar">
            <div class="offset1 span10">

                    <div class="container">
                        <div class="span2">
                            <div class="brand">
                                <a class="brand_large" href=""><img src="image/xalogo_2.png" al alt="XA - International Trade Advisors"></a>
                            </div>
                        </div>
                        <div class="span1"></div>
                        <div class="span9">
                            <div class="nav-collapse collapse navbar-responsive-collapse">
                                <ul class="nav nav-tabs">
                                    <li <%=isHome ? "class='active'":""%>><stripes:link href="/Workflow.action"><i class="icon-home"></i> Home<stripes:param name="parm.trigger.workflow" value="default.navbar.home"/></stripes:link></li>
                                    <li <%=isAbout ? "class='active'":""%>><stripes:link href="/Workflow.action">About XA<stripes:param name="parm.trigger.workflow" value="navbar.about"/></stripes:link></li>
                                    <li <%=isOpenCases ? "class='active'":""%>><stripes:link href="/Workflow.action">Open cases<stripes:param name="parm.trigger.workflow" value="navbar.opencases"/></stripes:link></li>
                                    <li <%=isOurTeam ? "class='active'":""%>><stripes:link href="/Workflow.action">Our team<stripes:param name="parm.trigger.workflow" value="navbar.ourteam"/></stripes:link></li>
                                    <li <%=isContactUs ? "class='active'":""%>><stripes:link href="/Workflow.action">Contact us<stripes:param name="parm.trigger.workflow" value="navbar.contact"/></stripes:link></li>
                                </ul>
                            </div>
                        </div>
                    </div>

            </div>
        </div>

    </div>
    <!-------------------------- End: Main Nav -------------------------->

