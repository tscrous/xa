<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>

<%@page import="com.xa.webui.persistence.domain.component.Menu"%>
<%@page import="com.xa.webui.persistence.domain.component.MenuItem"%>
<%@page import="com.xa.webui.persistence.domain.component.page.PageDescriptor"%>

<jsp:useBean id="pageDescriptor" class="com.xa.webui.persistence.domain.component.page.BasicPageDescriptor" scope="page">
    <jsp:setProperty name="pageDescriptor" property="name" value="${actionBean.descriptor.name}"/>
    <jsp:setProperty name="pageDescriptor" property="content" value="${actionBean.descriptor.content}"/>
</jsp:useBean>

<%
    Menu topMenu = pageDescriptor.getDependency(Menu.class);

    String currentPage = pageDescriptor.getContent() != null ? pageDescriptor.getContent().getValue().getValue() : null;
    boolean isHome = currentPage == null || currentPage.contains("home");
    boolean isAbout = currentPage.contains("about");
    boolean isOpenCases = currentPage.contains("open");
    boolean isContactUs = currentPage.contains("contact");
    boolean isHomeOption = currentPage.contains("q_");
    
    /* check if predefined tab is ACTIVE */
    boolean tempTabRequired = true;
    for (MenuItem item : topMenu.getItems()) {
        if (item.isActive()) {
            tempTabRequired = false;
            break;
        }
    }
    /* create temporary tab (if required) */
    if (tempTabRequired) {
        MenuItem temp = new MenuItem("", "Other");
        temp.setActive(true);
        topMenu.getItems().add(temp);
    }
%>

    <!-------------------------- Start: Top Nav -------------------------->
    <div class="topnav">
        <div class="page-content">
            
            <div class="top-menu">
                <ul class="pull-right">
                    <li><a href="#"><i class="icon-user"></i><t>Login</t></a></li>
                </ul>
            </div>
            
        </div>
    </div>
    <!-------------------------- End: Top Nav -------------------------->

    <!-------------------------- Start: Main Nav -------------------------->
    <div class="navbar">
        <div class="page-content">

            <div class="brand">
                <a class="brand_large" href=""><img src="image/xalogo_2.png" al alt="XA - International Trade Advisors"></a>
            </div>
            <ul class="nav-tabs">
<%  
    String label;
    String isActive;
    for (MenuItem item : topMenu.getItems()) {
        isActive = item.isActive() ? "class='active'" : "";
        label = "<error>";
        if (item.getIcon() != null || item.getLabel() != null) {
            label = item.getIcon() != null ? item.getIcon() : "";
            label += label.length() > 0 && item.getLabel() != null ? " " : "";
            label += item.getLabel() != null ? item.getLabel() : "";
        }
        if (item.getName() == null || item.getName().isEmpty()) {
%>
                <li <%=isActive %>><a href="#"><%=label %></a></li>
<%      } else { %>
                <li <%=isActive %>><a href="/Workflow.action?mediate=<%=item.getName() %>"/><%=label %></a></li>
<%
        }
    } 
%>
            </ul>

        </div>
    </div>
    <!-------------------------- End: Main Nav -------------------------->
                    