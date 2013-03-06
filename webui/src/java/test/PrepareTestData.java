package test;

import com.xa.webui.persistence.domain.component.Menu;
import com.xa.webui.persistence.domain.component.MenuItem;
import com.xa.webui.persistence.domain.component.Page;
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
        items.add(homeItem = factory.createMenuItem(1, "default.navbar.home", "Home", "Website's home page", null));
        items.add(aboutItem = factory.createMenuItem(2, "default.navbar.about", "About XA", "More about the company behind the name", null));
        items.add(openCasesItem = factory.createMenuItem(3, "default.navbar.opencases", "Open cases", "More about the cases XA is currently involved with", null));
        items.add(contactItem = factory.createMenuItem(4, "default.navbar.contact", "Contact us", "Contact information", null));
        topMenu = factory.createMenu("default.navbar", "Default NavBar", items);
    }
    
    private void createPages(Session session) {
        PathResource resource;
        /* landing page */
        resource = factory.createPathResource(PathResourceType.JSP, Constants.LANDING_PAGE_TARGET_ID, "/WEB-INF/jsp/LandingPage.jsp");
        landingPage = factory.createPage(Constants.LANDING_PAGE_TARGET_ID, "XA Home Page", resource, false);
        landingPage.setTopMenu(topMenu);
    }
    
    private void createWorkflows(Session session) {
        WorkflowRule rule;
        /* default workflow */
        List<WorkflowRule> rules = new LinkedList<WorkflowRule>();
        rules.add(rule = factory.createWorkflowRule(SystemOrchestrator.getInstance(), landingPage));
        rules.add(rule = factory.createWorkflowRule(homeItem, landingPage));
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
    private MenuItem homeItem;
    private MenuItem aboutItem;
    private MenuItem openCasesItem;
    private MenuItem contactItem;
    
    private Page landingPage;
    
    private Workflow defaultWorkflow;
    
}