<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.xa.webui.system.Constants"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>

<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.xa.webui.system.Constants"%>
<%@page import="com.xa.webui.persistence.domain.component.Menu"%>
<%@page import="com.xa.webui.persistence.domain.component.MenuItem"%>
<%@page import="com.xa.webui.persistence.domain.component.page.PageDescriptor"%>

<jsp:useBean id="pageDescriptor" class="com.xa.webui.persistence.domain.component.page.BasicPageDescriptor" scope="page">
    <jsp:setProperty name="pageDescriptor" property="name" value="${actionBean.descriptor.name}"/>
    <jsp:setProperty name="pageDescriptor" property="content" value="${actionBean.descriptor.content}"/>
    <jsp:setProperty name="pageDescriptor" property="runtimeInfo" value="${actionBean.descriptor.runtimeInfo}"/>
</jsp:useBean>

<%
    String latestTriggerId = (String) pageDescriptor.getRuntimeInfo().getValue(Constants.WORKFLOW_LATEST_TRIGGER);
    Menu topMenu = pageDescriptor.getDependency(Menu.class);
    
    /* determine active menuItem (Tab) */
    String prevActiveMenuItem = null;
    String nextActiveMenuItem = null;
    for (MenuItem item : topMenu.getItems()) {
        /* find previous ACTIVE menuItem */
        if (item.isActive()) {
            prevActiveMenuItem = item.getName();
        }
        /* find next ACTIVE menuItem */
        if (latestTriggerId != null && latestTriggerId.equals(item.getName())) {
            nextActiveMenuItem = latestTriggerId;
        }
    }
    if (nextActiveMenuItem == null) {
//        nextActiveMenuItem = prevActiveMenuItem;
    }
    /* update menuItem statuses (and check if temporary TAB is required) */
    boolean tempTabRequired = true;
    for (MenuItem item : topMenu.getItems()) {
        item.setActive(nextActiveMenuItem != null && nextActiveMenuItem.equals(item.getName()));
        if (item.isActive()) {
            tempTabRequired = false;
        }
    }
    
    /* create a "local" copy of required menuItems */
    List<MenuItem> menuItems = new LinkedList<MenuItem>();
    MenuItem newItem;
    for (MenuItem item : topMenu.getItems()) {
        newItem = new MenuItem(item.getName(), item.getLabel(), item.getDescription(), item.getItemIndex(), item.getAlignment());
        newItem.setActive(item.isActive());
        menuItems.add(newItem);
    }
    /* create temporary tab (if required) */
    if (tempTabRequired) {
        MenuItem temp = new MenuItem("", "Other");
        temp.setActive(true);
        menuItems.add(temp);
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
    for (MenuItem item : menuItems) {
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

