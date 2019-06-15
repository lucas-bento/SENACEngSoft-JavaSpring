package tasks.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tasks.dao.UsuarioDao;
import tasks.model.Usuario;

@Controller
public class LoginController {
	
	@RequestMapping("formlogin")
	public String formLogin() {
		return "task/form-login";
	}
	
	@RequestMapping("getlogin")
	public String getLogin(Usuario usuario, HttpSession session) {
		if(new UsuarioDao().existeUsuario(usuario)) {
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
