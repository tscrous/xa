<jsp:include page="/WEB-INF/jsp/template/taglibs.jsp"/>

<%@page import="com.xa.webui.persistence.domain.component.Menu"%>
<%@page import="com.xa.webui.persistence.domain.component.FooterMenu"%>
<%@page import="com.xa.webui.system.Constants"%>

<jsp:useBean id="pageDescriptor" class="com.xa.webui.persistence.domain.component.page.BasicPageDescriptor" scope="page">
    <jsp:setProperty name="pageDescriptor" property="name" value="${actionBean.descriptor.name}"/>
    <jsp:setProperty name="pageDescriptor" property="content" value="${actionBean.descriptor.content}"/>
    <jsp:setProperty name="pageDescriptor" property="runtimeInfo" value="${actionBean.descriptor.runtimeInfo}"/>
</jsp:useBean>


<%
    boolean hasTopMenu = pageDescriptor.hasDependencyOn(Menu.class);
    boolean hasFooterMenu = pageDescriptor.hasDependencyOn(FooterMenu.class);

    String latestTriggerId = (String) pageDescriptor.getRuntimeInfo().getValue(Constants.WORKFLOW_LATEST_TRIGGER);
%>

<jsp:include page="/WEB-INF/jsp/template/page_start.jsp"/>

    <div id="wrap">
        <img class="body-background-img" src="image/background.jpg"/>
        

    <% if (hasTopMenu) { %>
                <jsp:include page="/WEB-INF/jsp/template/navbar_main.jsp"/>
        <% } %>
        
        <div class="page-content">
            <div class="canvas-clear">
                
                <table cellpadding="0" cellspacing="0" border="0">
                    <tr> 
                        <td> 
                            <div class="scroll-pane">

                                <% if (pageDescriptor.getContent() != null) { %>
                                        <jsp:include page="<%=pageDescriptor.getContent().getValue().getValue() %>"/>
                                <% } %>

                            </div>
                        </td>
                    </tr>
                </table>
                                
            </div>
        </div>
                                
    </div>
        
    <% if (hasFooterMenu) { %>
            <jsp:include page="/WEB-INF/jsp/template/footer_main.jsp"/>
    <% } %>
    
    <jsp:include page="/WEB-INF/jsp/template/scripts.jsp"/>
    
<jsp:include page="/WEB-INF/jsp/template/page_end.jsp"/>



