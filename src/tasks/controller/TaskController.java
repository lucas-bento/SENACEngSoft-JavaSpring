package tasks.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tasks.dao.TaskDao;
import tasks.model.Task;

@Controller
public class TaskController {
	
	private final TaskDao dao;
	
	@Autowired
	public TaskController(TaskDao dao) {
		this.dao = dao;
	}

	@RequestMapping("novatask")
	public String form() {
		return "task/form-tasks";
	}
	
	@RequestMapping("cadastratask")
	public String cadastra(@Valid Task task, BindingResult result) {
		
		if (result.hasErrors()) {
			return "task/form-tasks";
		}
		
		dao.inserir(task);
		
		return "redirect:gettasks";
	}
	
	@RequestMapping("editartask")
	public String editar(Task task) {
		
		dao.edita(task);
		
		return "redirect:gettasks";
	}
	
	@RequestMapping("gettasks")
	public String list(Model model) {
		List<Task> tasks = dao.getTasks();
		
		model.addAttribute("tasks", tasks);
		
		return "task/get-tasks-ajax4";
	}
	
	@RequestMapping("buscartask")
	public String get(Long id, Model model ) {
		
		model.addAttribute("task", dao.getById(id));
		
		return "task/busca-task";
	}
	
	@RequestMapping("deletartask")
	public String delete(Task task) {
		dao.exclui(task);
		
		return "redirect:gettasks";
	}
	
//	@ResponseBody // Essa anotacao entraria em conflito com o Model que esta sendo utilizado
	@RequestMapping("finalizatask")
	public String finaliza(Long id, Model model) {
		dao.finaliza(id);
		
		model.addAttribute("task", dao.getById(id));
		
		return "task/data-finalizada2";
	}
}
