package com;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

@Controller

public class HelloController {
     @RequestMapping(value = "/", method = RequestMethod.GET)
     public String printHello(ModelMap model) {      
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      StoreDAOImpl store = (StoreDAOImpl)context.getBean("store");
      SellerDAOImpl seller = (SellerDAOImpl)context.getBean("seller");
      DepartmentDAOImpl department = (DepartmentDAOImpl)context.getBean("department");
      List<Store> stores = store.listStore();
      List<Seller> sellers = seller.listSeller();
      List<Department> departments = department.listDepartment();
      model.addAttribute("stores", stores);
      model.addAttribute("sellers", sellers);
      model.addAttribute("departments", departments);
      return "index";
   }
     
     
     @RequestMapping(value = "/seller", method = RequestMethod.GET)
     public String seller(ModelMap model) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentDAOImpl store = (DepartmentDAOImpl) context.getBean("department");
        List<Department> departments = store.listDepartment();            
        model.addAttribute("departments", departments); 
       model.addAttribute("command", new Seller());       
       return "seller";
   }
     
     @RequestMapping(value = "/addSeller", method = RequestMethod.POST)
   public String student(@ModelAttribute("SpringWeb")Seller newSeller, ModelMap model) {
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      SellerDAOImpl seller = (SellerDAOImpl) context.getBean("seller");
      seller.createSeller(newSeller.getFirst_name(), newSeller.getLast_name(),newSeller.getDate_of_birth(),newSeller.getSalary(), newSeller.getDepartment_id()); 
      model.addAttribute("newSeller", newSeller);  
      return "result";
   }
   
   
   @RequestMapping(value = "/department", method = RequestMethod.GET)
      public String department(ModelMap model) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StoreDAOImpl store = (StoreDAOImpl) context.getBean("store");
        List<Store> stores = store.listStore();
        model.addAttribute("command", new Department());    
        model.addAttribute("stores", stores); 
        return "department";
   }
      
      
      @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
   public String addDepartment(@ModelAttribute("SpringWeb")Department newDepertment, ModelMap model) {
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      DepartmentDAOImpl department = (DepartmentDAOImpl) context.getBean("department");
      department.createDepartment(newDepertment.getName(), newDepertment.getType(), newDepertment.getStore_id()); 
      model.addAttribute("newDepartment", newDepertment);  
      return "result";
   }
   
    @RequestMapping(value = "/store", method = RequestMethod.GET)
      public String store(ModelMap model) {
        model.addAttribute("command", new Department());       
        return "store";
   }
      
      
      @RequestMapping(value = "/addStore", method = RequestMethod.POST)
   public String addStore(@ModelAttribute("SpringWeb")Store newStore, ModelMap model) {
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      StoreDAOImpl store = (StoreDAOImpl) context.getBean("store");
      store.createStore(newStore.getName(), newStore.getType()); 
      model.addAttribute("newStore", newStore);  
      return "result";
   }
   
   @RequestMapping(value = "/editStore/{id}", method = RequestMethod.GET)
     public String editStore(@PathVariable("id") int id, ModelMap model) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StoreDAOImpl store = (StoreDAOImpl) context.getBean("store");
        Store newStore = store.getStoreById(id);   
        model.addAttribute("command", new Store());
        model.addAttribute("store", newStore);              
        return "editStore";
   }
     
     @RequestMapping(value = "/updateStore", method = RequestMethod.POST)
   public String updateStore(@ModelAttribute("SpringWeb")Store newStore, ModelMap model) {
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      StoreDAOImpl store = (StoreDAOImpl) context.getBean("store");
      store.updateStore(newStore.getId(), newStore.getName(), newStore.getType()); 
      model.addAttribute("newStore", newStore);  
      return "result";
   }
   @RequestMapping(value = "/deleteStore", method = RequestMethod.POST)
   public String deleteStore(@ModelAttribute("SpringWeb")Store newStore, ModelMap model) {
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      StoreDAOImpl store = (StoreDAOImpl) context.getBean("store");
      store.removeStore(newStore.getId());         
      return "index";
   }
   
   @RequestMapping(value = "/editDepartment/{id}", method = RequestMethod.GET)
     public String editDepartment(@PathVariable("id") int id, ModelMap model) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentDAOImpl department = (DepartmentDAOImpl) context.getBean("department");
        StoreDAOImpl store = (StoreDAOImpl) context.getBean("store");
        List<Store> stores = store.listStore();
        model.addAttribute("stores", stores); 
        Department newDepartment = department.getDepartmentById(id);   
        model.addAttribute("command", new Department());
        model.addAttribute("department", newDepartment);              
        return "editDepartment";
   }
     
     @RequestMapping(value = "/updateDepartment", method = RequestMethod.POST)
   public String updateDepartment(@ModelAttribute("SpringWeb")Department newDepartment, ModelMap model) {
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      DepartmentDAOImpl department = (DepartmentDAOImpl) context.getBean("department");
      department.updateDepartment(newDepartment.getId(), newDepartment.getName(), newDepartment.getType(), newDepartment.getStore_id()); 
      model.addAttribute("newDepartment", newDepartment);  
      return "result";
   }
   @RequestMapping(value = "/deleteDepartment", method = RequestMethod.POST)
   public String deleteDepartment(@ModelAttribute("SpringWeb")Department newDepartment, ModelMap model) {
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      DepartmentDAOImpl store = (DepartmentDAOImpl) context.getBean("department");
      store.removeDepartment(newDepartment.getId());         
      return "index";
   }
   
   @RequestMapping(value = "/editSeller/{id}", method = RequestMethod.GET)
     public String editSeller(@PathVariable("id") int id, ModelMap model) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SellerDAOImpl seller = (SellerDAOImpl) context.getBean("seller");
        DepartmentDAOImpl department = (DepartmentDAOImpl) context.getBean("department");
        List<Department> departments = department.listDepartment();
        model.addAttribute("departments", departments); 
        Seller newSeller = seller.getSellerById(id);   
        model.addAttribute("command", new Seller());
        model.addAttribute("seller", newSeller);              
        return "editSeller";
   }
     
     @RequestMapping(value = "/updateSeller", method = RequestMethod.POST)
   public String updateSeller(@ModelAttribute("SpringWeb")Seller newSeller, ModelMap model) {
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      SellerDAOImpl seller = (SellerDAOImpl) context.getBean("seller");
      seller.updateSeller(newSeller.getId(), newSeller.getFirst_name(), newSeller.getLast_name(), newSeller.getDate_of_birth(),newSeller.getSalary(),newSeller.getDepartment_id()); 
      model.addAttribute("newSeller", newSeller);  
      return "result";
   }
   
   
   @RequestMapping(value = "/deleteSeller", method = RequestMethod.POST)
   public String deleteSeller(@ModelAttribute("SpringWeb")Seller newSeller, ModelMap model) {
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      SellerDAOImpl seller = (SellerDAOImpl) context.getBean("seller");
      seller.removeSeller(newSeller.getId());         
      return "index";
   }
}
