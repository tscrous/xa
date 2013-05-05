package test;

import com.xa.webui.persistence.domain.component.Menu;
import com.xa.webui.persistence.domain.component.MenuItem;
import com.xa.webui.persistence.domain.component.OptionItem;
import com.xa.webui.persistence.domain.component.OptionItemGroup;
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
    
    public PrepareTestData() {
    }
    
    public void execute() {
        Session session = startSession();
        prepare(session);
        createTopMenu(session);
        createMenuPages(session);
        createOptions(session);
        createOptionPages(session);
        createWorkflows(session);
        endSession(session);
    }
    
    private void prepare(Session session) {
        factory = new TestDataFactory(session);
        BASIC_PAGE = factory.createPathResource(PathResourceType.JSP, Constants.BASIC_PAGE_ID, "/WEB-INF/jsp/template/page/page.jsp");
        CANVAS_PAGE = factory.createPathResource(PathResourceType.JSP, Constants.CANVAS_PAGE_ID, "/WEB-INF/jsp/template/page/canvas_page.jsp");
    }
    
    private void createTopMenu(Session session) {
        /* DEFAULT TopMenu */
        List<MenuItem> items = new LinkedList<MenuItem>();
        items.add(homeMenuItem = factory.createMenuItem(1, "navbar.home", "Home", "Website's home page", null));
        items.add(aboutMenuItem = factory.createMenuItem(2, "navbar.about", "About XA", "More about the company behind the name", null));
        items.add(openCasesMenuItem = factory.createMenuItem(3, "navbar.opencases", "Open cases", "More about the cases XA is currently involved with", null));
        items.add(contactMenuItem = factory.createMenuItem(4, "navbar.contact", "Contact us", "Contact information", null));
        topMenu = factory.createMenu("navbar", "Default NavBar", items);
    }
    
    private void createOptions(Session session) {
        /* DEFAULT TopMenu */
        List<OptionItem> options = new LinkedList<OptionItem>();
        options.add(competitionOption = factory.createOptionItem(1, "home.option.competition", "Facing import competition ?", "Some description here..."));
        options.add(dutyIncreaseOption = factory.createOptionItem(2, "home.option.duty_increase", "Facing duty increases ?", "Some description here..."));
        options.add(competitivenessOption = factory.createOptionItem(3, "home.option.competitiveness", "Trying to improve competitiveness ?", "Some description here..."));
        options.add(incentivesOption = factory.createOptionItem(4, "home.option.incentives", "Looking for incentives ?", "Some description here..."));
        homeOptions = factory.createOptions("home.options", "Home options", options);
    }
    
    private void createMenuPages(Session session) {
        PathResource content;
        /* home */
        content = factory.createPathResource(PathResourceType.JSP, Constants.HOME_PAGE_TARGET_ID +".jsp", "/WEB-INF/jsp/home.jsp");
        homePage = factory.createPage(BASIC_PAGE, Constants.HOME_PAGE_TARGET_ID, "Home", content);
        homePage.setTopMenu(topMenu);
        /* about */
        content = factory.createPathResource(PathResourceType.JSP, Constants.ABOUT_XA_PAGE_TARGET_ID +".jsp", "/WEB-INF/jsp/about.jsp");
        aboutPage = factory.createPage(CANVAS_PAGE, Constants.ABOUT_XA_PAGE_TARGET_ID, "About XA", content);
        aboutPage.setTopMenu(topMenu);
        /* open cases */
        content = factory.createPathResource(PathResourceType.JSP, Constants.OPEN_CASES_PAGE_TARGET_ID +".jsp", "/WEB-INF/jsp/open_cases.jsp");
        openCasesPage = factory.createPage(CANVAS_PAGE, Constants.OPEN_CASES_PAGE_TARGET_ID, "Open cases", content);
        openCasesPage.setTopMenu(topMenu);
        /* contact */
        content = factory.createPathResource(PathResourceType.JSP, Constants.CONTACT_US_PAGE_TARGET_ID +".jsp", "/WEB-INF/jsp/contact.jsp");
        contactPage = factory.createPage(CANVAS_PAGE, Constants.CONTACT_US_PAGE_TARGET_ID, "Contact us", content);
        contactPage.setTopMenu(topMenu);
    }
    
    private void createOptionPages(Session session) {
        PathResource content;
        /* competition */
        content = factory.createPathResource(PathResourceType.JSP, Constants.Q_COMPETITION_PAGE_TARGET_ID +".jsp", "/WEB-INF/jsp/q_competition.jsp");
        competitionPage = factory.createPage(CANVAS_PAGE, Constants.Q_COMPETITION_PAGE_TARGET_ID, "Facing import competition", content);
        competitionPage.setTopMenu(topMenu);
        /* duty increases */
        content = factory.createPathResource(PathResourceType.JSP, Constants.Q_DUTY_INCREASE_PAGE_TARGET_ID +".jsp", "/WEB-INF/jsp/q_duty_increase.jsp");
        dutyIncreasePage = factory.createPage(CANVAS_PAGE, Constants.Q_DUTY_INCREASE_PAGE_TARGET_ID, "Facing duty increases", content);
        dutyIncreasePage.setTopMenu(topMenu);
        /* improve competitiveness */
        content = factory.createPathResource(PathResourceType.JSP, Constants.Q_COMPETITIVENESS_PAGE_TARGET_ID +".jsp", "/WEB-INF/jsp/q_competitiveness.jsp");
        competitivenessPage = factory.createPage(CANVAS_PAGE, Constants.Q_COMPETITIVENESS_PAGE_TARGET_ID, "Trying to improve competitiveness", content);
        competitivenessPage.setTopMenu(topMenu);
        /* incentives */
        content = factory.createPathResource(PathResourceType.JSP, Constants.Q_INCENTIVES_PAGE_TARGET_ID +".jsp", "/WEB-INF/jsp/q_incentives.jsp");
        incentivesPage = factory.createPage(CANVAS_PAGE, Constants.Q_INCENTIVES_PAGE_TARGET_ID, "Looking for incentives", content);
        incentivesPage.setTopMenu(topMenu);
    }
    
    private void createWorkflows(Session session) {
        WorkflowRule rule;
        /* default workflow */
        List<WorkflowRule> rules = new LinkedList<WorkflowRule>();
        /* ----> navbar rules */
        rules.add(rule = factory.createWorkflowRule(SystemOrchestrator.getInstance(), homePage));
        rules.add(rule = factory.createWorkflowRule(homeMenuItem, homePage));
        rules.add(rule = factory.createWorkflowRule(aboutMenuItem, aboutPage));
        rules.add(rule = factory.createWorkflowRule(openCasesMenuItem, openCasesPage));
        rules.add(rule = factory.createWorkflowRule(contactMenuItem, contactPage));
        /* ----> home-question rules */
        rules.add(rule = factory.createWorkflowRule(competitionOption, competitionPage));
        rules.add(rule = factory.createWorkflowRule(dutyIncreaseOption, dutyIncreasePage));
        rules.add(rule = factory.createWorkflowRule(competitivenessOption, competitivenessPage));
        rules.add(rule = factory.createWorkflowRule(incentivesOption, incentivesPage));
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
        session.close();
    }
    
    
    private TestDataFactory factory;
    private PathResource BASIC_PAGE;
    private PathResource CANVAS_PAGE;
    

    private Menu topMenu;
    private MenuItem homeMenuItem;
    private MenuItem aboutMenuItem;
    private MenuItem openCasesMenuItem;
    private MenuItem contactMenuItem;
    
    private OptionItemGroup homeOptions;
    private OptionItem competitionOption;
    private OptionItem dutyIncreaseOption;
    private OptionItem competitivenessOption;
    private OptionItem incentivesOption;
    
    private BasicPageDescriptor homePage;
    private BasicPageDescriptor aboutPage;
    private BasicPageDescriptor openCasesPage;
    private BasicPageDescriptor contactPage;
    
    private BasicPageDescriptor competitionPage;
    private BasicPageDescriptor dutyIncreasePage;
    private BasicPageDescriptor competitivenessPage;
    private BasicPageDescriptor incentivesPage;
    
    private Workflow defaultWorkflow;
    
}
