package cafe.jjdev.mall.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.mall.service.ProductCommonService;

@Controller
public class ProductCommonController {
	
	@Autowired
	private ProductCommonService productCommonService;
	
	@GetMapping("/product/getProductListByCategory")
	public String getProductCommonListByCategoryNo(Model model,@RequestParam(value = "categoryNo") int categoryNo,
															   @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
															   @RequestParam(value = "searchWord", defaultValue = "") String searchWord ) {
		
		Map<String, Object> map = productCommonService.getProductCommonListByCategoryNo(categoryNo, currentPage, searchWord);

		System.out.println("●●●●●●●●●●페이징작업 보여줄 데이터 목록●●●●●●●●●●●●");
		System.out.println("[Controller]map : " + map.toString());
		System.out.println("●●●●●●●●●●페이징작업 보여줄 데이터 목록●●●●●●●●●●●●");
		
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
			
			return "/product/getProductListByCategory";
	}
	
	
	
	
	
}
