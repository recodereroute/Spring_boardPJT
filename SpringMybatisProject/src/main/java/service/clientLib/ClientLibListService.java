package service.clientLib;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.ClientLibDTO;
import repository.ClientLibRepository;

public class ClientLibListService {
	@Autowired
	ClientLibRepository clientLibRepository;
	public void clientLibList(Model model) {
		List<ClientLibDTO> list = clientLibRepository.clientLibList();
		model.addAttribute("list", list);
	}
}