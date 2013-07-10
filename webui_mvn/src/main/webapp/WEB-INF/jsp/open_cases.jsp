<%@page import="com.xa.webui.persistence.domain.component.page.PageDescriptor"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>

<jsp:useBean id="pageDescriptor" class="com.xa.webui.persistence.domain.component.page.BasicPageDescriptor" scope="page">
    <jsp:setProperty name="pageDescriptor" property="content" value="${actionBean.descriptor.content}"/>  
</jsp:useBean>

<%
    String currentPage = pageDescriptor.getContent() != null ? pageDescriptor.getContent().getValue().getValue() : null;
    boolean isHome = currentPage == null || currentPage.contains("home");
    boolean isAbout = currentPage.contains("about");
    boolean isOpenCases = currentPage.contains("open");
    boolean isContactUs = currentPage.contains("contact");
    boolean isHomeOption = currentPage.contains("q_");
%>
    <!-------------------------- Start: PAGE body -------------------------->
    <table class="table table-hover table-condensed">
        <thead>
            <tr style="font-weight: bold; color: rgb(75, 187, 224);">
                <th>Type of Action</th>
                <th>Subject Product</th>
                <th>Tariff Code</th>
                <th>Position Requested</th>
                <th>Countries Impacted</th>
                <th>Applicant</th>
                <th>Due Date</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Duty Reduction</td>
                <td>Laminates of Phenolic Resins with a basis of paper</td>
                <td>3921.90.05</td>
                <td>10% to free of duty</td>
                <td>All</td>
                <td>FX Veneers CC</td>
                <td>21/06/2013</td>
            </tr>
            <tr>
                <td>Duty Increase</td>
                <td>Certain screws, bolts and nuts</td>
                <td>7318.15.39<br/>7318.15.43<br/>7318.16.80</td>
                <td>10% to 30% bound rate</td>
                <td>All</td>
                <td>CBC Fasteners</td>
                <td>21/06/2013</td>
            </tr>
            <tr>
                <td>Rebate</td>
                <td>Polyurethane flat shapes</td>
                <td>3919.10.07</td>
                <td>Full rebate</td>
                <td>All</td>
                <td>3M South Africa</td>
                <td>21/06/2013</td>
            </tr>
            <tr>
                <td>Rebate</td>
                <td>Silicone elastomeric straps</td>
                <td>3926.90.90</td>
                <td>Full rebate</td>
                <td>All</td>
                <td>3M South Africa</td>
                <td>21/06/2013</td>
            </tr>
            <tr>
                <td>Rebate</td>
                <td>Natural rubber straps</td>
                <td>4016.99.90</td>
                <td>Full rebate</td>
                <td>All</td>
                <td>3M South Africa</td>
                <td>21/06/2013</td>
            </tr>
            <tr>
                <td>Rebate</td>
                <td>Inner and outer shells of non-woven material</td>
                <td>6307.90.10</td>
                <td>Full rebate</td>
                <td>All</td>
                <td>3M South Africa</td>
                <td>21/06/2013</td>
            </tr>
        </tbody>
    </table>
    <!-------------------------- End: PAGE body -------------------------->
