package controller.clientLib;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.ClientLibCommand;
import service.clientLib.ClientLibListService;
import service.clientLib.ClientLibWriteService;

@Controller
@RequestMapping("clientLib")
public class ClientLibController {
	@Autowired
	ClientLibListService clientLibListService;
	@Autowired
	ClientLibWriteService clientLibWriteService;
	
	@RequestMapping("clientLibList")
	public String clientLibList(Model model) {
		clientLibListService.clientLibList(model);
		return "clientLib/clientLibList";
	}
	@RequestMapping("clientLibPost")
	public String clientLibPost() {
		return "clientLib/clientLibPost";
	}
	@RequestMapping(value = "clientLibWrite", method = RequestMethod.POST)
	public String clientLibWrite(ClientLibCommand clientLibCommand, HttpSession session) {
		clientLibWriteService.clientLibWrite(clientLibCommand, session);
		return "redirect:clientLibList";
	}

}
