package br.com.luiscamposjr.tasks.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.luiscamposjr.tasks.dao.JDBCTaskDAO;
import br.com.luiscamposjr.tasks.model.Task;

@Controller
public class TasksController {
	
	@RequestMapping("newTask")
    public String form() {
        return "tasks/formulario";
    }
	
	 @RequestMapping("adicionaTarefa")
	   public String adiciona(@Valid Task task, BindingResult result) {
		 
		 if(result.hasErrors()) {
		        return "tasks/formulario";
		 }
		 
	       JDBCTaskDAO dao = new JDBCTaskDAO();
	       dao.adiciona(task);
	       return "tasks/adicionada";
	}
	 
	 @RequestMapping("tasksList")
	   public String lista(Model model) {
	       JDBCTaskDAO dao = new JDBCTaskDAO();
	       model.addAttribute("tasks", dao.getList());
	       return "tasks/lista";
	}
	 
	 @RequestMapping("removeTask")
	 public String remove(Task task) {
	     JDBCTaskDAO dao = new JDBCTaskDAO();
	     dao.remove(task);
	     return "redirect:tasksList";
	 }
	 
	 @RequestMapping("showTask")
     public String mostra(Long id, Model model) {
		 JDBCTaskDAO dao = new JDBCTaskDAO();
         model.addAttribute("task", dao.buscaPorId(id, model));
         return "tasks/showTask";
	 }
	 
	 @RequestMapping("updateTask")
     public String altera(Task task) {
		 JDBCTaskDAO dao = new JDBCTaskDAO();
         dao.update(task);
         return "redirect:tasksList";
}

}
