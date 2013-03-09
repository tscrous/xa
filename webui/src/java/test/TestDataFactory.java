package test;

import com.xa.webui.persistence.domain.WebObject;
import com.xa.webui.persistence.domain.component.Menu;
import com.xa.webui.persistence.domain.component.MenuItem;
import com.xa.webui.persistence.domain.component.page.PageGroupDescriptor;
import com.xa.webui.persistence.domain.component.page.PageSingleDescriptor;
import com.xa.webui.persistence.domain.resource.path.Path;
import com.xa.webui.persistence.domain.resource.path.PathResource;
import com.xa.webui.persistence.domain.resource.path.PathResourceType;
import com.xa.webui.persistence.domain.workflow.Workflow;
import com.xa.webui.persistence.domain.workflow.WorkflowRule;
import com.xa.webui.system.Alignment;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author theo-alaganze
 */
public class TestDataFactory {
    
    public TestDataFactory(Session session) {
        this.session = session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    /* WORKFLOW */

    public WorkflowRule createWorkflowRule(WebObject trigger, WebObject target) {
        WorkflowRule rule = new WorkflowRule(trigger, target);
        session.save(rule);
        return rule;
    }
    
    public Workflow createWorkflow(String name, List<WorkflowRule> rules) {
        Workflow workflow = new Workflow(name);
        workflow.setRules(rules);
        session.save(workflow);
        return workflow;
    }
    
    /* MENUS */
    
    public Menu createMenu(String name, String desc, List<MenuItem> items) {
        Menu menu = new Menu();
        menu.setName(name);
        menu.setDescription(desc);
        menu.setItems(items);
        session.save(menu);
        return menu;
    }
    
    public MenuItem createMenuItem(int index, String name, String label, String desc, MenuItem parent) {
        MenuItem menuItem = new MenuItem();
        menuItem.setName(name);
        menuItem.setLabel(label);
        menuItem.setDescription(desc);
        menuItem.setItemIndex(index);
        menuItem.setAlignment(Alignment.LEFT);
        session.save(menuItem);
        return menuItem;
    }
    
    /* RESOURCES */
    
    public PathResource createPathResource(PathResourceType type, String name, String path) {
        PathResource resource = new PathResource(type, name, new Path(path));
        session.save(resource);
        return resource;
    }
    
    /* PAGES */
    
    public PageSingleDescriptor createPage(String name, String description, PathResource resource) {
        PageSingleDescriptor page = new PageSingleDescriptor();
        page.setName(name);
        page.setDescription(description);
        page.setValue(resource);
        session.save(page);
        return page;
    }
    
    public PageGroupDescriptor createPageGroup(String name, String description, List<PathResource> resources) {
        PageGroupDescriptor page = new PageGroupDescriptor();
        page.setName(name);
        page.setDescription(description);
//        page.setContent(resource);
        session.save(page);
        return page;
    }
    
    private Session session;
    
}
