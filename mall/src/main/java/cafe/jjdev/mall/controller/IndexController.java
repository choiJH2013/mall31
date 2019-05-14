package cafe.jjdev.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cafe.jjdev.mall.service.CategoryService;
import cafe.jjdev.mall.vo.Category;

@Controller
public class IndexController {
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping(value="/")
	public String index(Model model) {
		List<Category> categoryList = categoryService.getCategoryList();
		model.addAttribute("categoryList", categoryList);
		
		return "index";
	}
}
