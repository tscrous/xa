package test;

import com.xa.webui.persistence.domain.component.Menu;
import com.xa.webui.persistence.domain.component.MenuItem;
import com.xa.webui.persistence.domain.component.page.BasicPageDescriptor;
import com.xa.webui.persistence.domain.resource.path.PathResource;
import com.xa.webui.persistence.domain.resource.path.PathResourceType;
import com.xa.webui.persistence.domain.system.SystemOrchestrator;
import com.xa.webui.persistence.domain.workflow.Workflow;
import com.xa.webui.persistence.domain.workflow.WorkflowRule;
import com.xa.webui.system.Constants;
import com.xa.webui.system.Defaults;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class PrepareTestData {
    
    public static void main(String[] args) {
        System.out.println("Preparation started...\n");
        new PrepareTestData().execute();
        System.out.println("\nDone!");
    }
    
    public void execute() {
        Session session = startSession();
        factory = new TestDataFactory(session);
        
        createTopMenu(session);
        createPages(session);
        createWorkflows(session);
        
        endSession(session);
     }
    
    private void createTopMenu(Session session) {
        /* DEFAULT TopMenu */
        List<MenuItem> items = new LinkedList<MenuItem>();
        items.add(homeMenuItem = factory.createMenuItem(1, "navbar.home", "Home", "Website's home page", null));
        items.add(aboutXAMenuItem = factory.createMenuItem(2, "navbar.about", "About XA", "More about the company behind the name", null));
        items.add(openCasesMenuItem = factory.createMenuItem(3, "navbar.opencases", "Open cases", "More about the cases XA is currently involved with", null));
        items.add(ourTeamMenuItem = factory.createMenuItem(4, "navbar.ourteam", "Our Team", "Meet the XA team", null));
        items.add(contactUsMenuItem = factory.createMenuItem(5, "navbar.contact", "Contact us", "Contact information", null));
        topMenu = factory.createMenu("navbar", "Default NavBar", items);
    }
    
    private void createPages(Session session) {
        final PathResource BASIC_PAGE = factory.createPathResource(PathResourceType.JSP, Constants.BASIC_PAGE_ID, "/WEB-INF/jsp/template/page.jsp");
        PathResource content;
        /* home */
        content = factory.createPathResource(PathResourceType.JSP, Constants.HOME_PAGE_TARGET_ID +".jsp", "/WEB-INF/jsp/home.jsp");
        homePage = factory.createPage(BASIC_PAGE, Constants.HOME_PAGE_TARGET_ID, "XA Home Page", content);
        homePage.setTopMenu(topMenu);
        /* about xa */
        content = factory.createPathResource(PathResourceType.JSP, Constants.ABOUT_XA_PAGE_TARGET_ID +".jsp", "/WEB-INF/jsp/about.jsp");
        aboutXAPage = factory.createPage(BASIC_PAGE, Constants.ABOUT_XA_PAGE_TARGET_ID, "About XA", content);
        aboutXAPage.setTopMenu(topMenu);
        /* open cases */
        content = factory.createPathResource(PathResourceType.JSP, Constants.OPEN_CASES_PAGE_TARGET_ID +".jsp", "/WEB-INF/jsp/open_cases.jsp");
        openCasesPage = factory.createPage(BASIC_PAGE, Constants.OPEN_CASES_PAGE_TARGET_ID, "Open Cases", content);
        openCasesPage.setTopMenu(topMenu);
        /* our team */
        content = factory.createPathResource(PathResourceType.JSP, Constants.OUR_TEAM_PAGE_TARGET_ID +".jsp", "/WEB-INF/jsp/our_team.jsp");
        ourTeamPage = factory.createPage(BASIC_PAGE, Constants.OUR_TEAM_PAGE_TARGET_ID, "Our Team", content);
        ourTeamPage.setTopMenu(topMenu);
        /* contact us */
        content = factory.createPathResource(PathResourceType.JSP, Constants.CONTACT_US_PAGE_TARGET_ID +".jsp", "/WEB-INF/jsp/contact.jsp");
        contactUsPage = factory.createPage(BASIC_PAGE, Constants.CONTACT_US_PAGE_TARGET_ID, "Our Team", content);
        contactUsPage.setTopMenu(topMenu);
    }
    
    private void createWorkflows(Session session) {
        WorkflowRule rule;
        /* default workflow */
        List<WorkflowRule> rules = new LinkedList<WorkflowRule>();
        rules.add(rule = factory.createWorkflowRule(SystemOrchestrator.getInstance(), homePage));
        rules.add(rule = factory.createWorkflowRule(homeMenuItem, homePage));
        rules.add(rule = factory.createWorkflowRule(aboutXAMenuItem, aboutXAPage));
        rules.add(rule = factory.createWorkflowRule(openCasesMenuItem, openCasesPage));
        rules.add(rule = factory.createWorkflowRule(ourTeamMenuItem, ourTeamPage));
        rules.add(rule = factory.createWorkflowRule(contactUsMenuItem, contactUsPage));
        defaultWorkflow = Defaults.getDefaultWorkflow();
        defaultWorkflow.setRules(rules);
        session.save(defaultWorkflow);
        
    }
    
    /* Utilities */
    
    private Session startSession() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }
    private void endSession(Session session) {
        session.getTransaction().commit();
    }
    
    
    private TestDataFactory factory;

    /* instance recerences */
    private Menu topMenu;
    private MenuItem homeMenuItem;
    private MenuItem aboutXAMenuItem;
    private MenuItem openCasesMenuItem;
    private MenuItem ourTeamMenuItem;
    private MenuItem contactUsMenuItem;
    
    private BasicPageDescriptor homePage;
    private BasicPageDescriptor aboutXAPage;
    private BasicPageDescriptor openCasesPage;
    private BasicPageDescriptor ourTeamPage;
    private BasicPageDescriptor contactUsPage;
    
    private Workflow defaultWorkflow;
    
}
