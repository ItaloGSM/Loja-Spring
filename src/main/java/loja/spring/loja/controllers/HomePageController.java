package loja.spring.loja.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomePageController {

	public String homePage() {
		return "homePage";
	}
}
