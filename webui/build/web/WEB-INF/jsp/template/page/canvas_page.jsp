<jsp:include page="/WEB-INF/jsp/template/taglibs.jsp"/>

<jsp:useBean id="pageDescriptor" class="com.xa.webui.persistence.domain.component.page.BasicPageDescriptor" scope="page">
    <jsp:setProperty name="pageDescriptor" property="topMenu" value="${actionBean.descriptor.topMenu}"/>  
    <jsp:setProperty name="pageDescriptor" property="content" value="${actionBean.descriptor.content}"/>  
    <jsp:setProperty name="pageDescriptor" property="footerMenu" value="${actionBean.descriptor.footerMenu}"/>  
</jsp:useBean>

<jsp:include page="/WEB-INF/jsp/template/page_start.jsp"/>

    <div id="wrap">
        <img class="body-background-img" src="image/background.jpg"/>
        
        <% if (pageDescriptor.getTopMenu() != null) { %>
                <jsp:include page="/WEB-INF/jsp/template/navbar_main.jsp"/>
        <% } %>
        
        <div class="offset1 span10">
            <div class="canvas">
                
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
        
    <% if (pageDescriptor.getFooterMenu() != null) { %>
            <jsp:include page="/WEB-INF/jsp/template/footer_main.jsp"/>
    <% } %>

    <jsp:include page="/WEB-INF/jsp/template/scripts.jsp"/>
    
<jsp:include page="/WEB-INF/jsp/template/page_end.jsp"/>



