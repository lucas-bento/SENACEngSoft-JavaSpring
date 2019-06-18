package tasks.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tasks.dao.UsuarioDao;
import tasks.model.Usuario;

@Controller
public class LoginController {
	
	private UsuarioDao dao;
	
	@Autowired
	public LoginController(UsuarioDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("formlogin")
	public String formLogin() {
		return "task/form-login";
	}
	
	@RequestMapping("getlogin")
	public String getLogin(Usuario usuario, HttpSession session) {
		if(dao.existeUsuario(usuario)) {
			session.setAttribute("usuariologado", usuario);
			
			System.out.println("Usuario logado " + usuario.getLogin());
			
			return "task/portal";
		}
		
		return "redirect:formlogin";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:formlogin";
	}
}
