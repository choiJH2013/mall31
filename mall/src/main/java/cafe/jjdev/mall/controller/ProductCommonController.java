package cafe.jjdev.mall.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.mall.commons.PathStr;
import cafe.jjdev.mall.service.ProductCommonService;
import cafe.jjdev.mall.vo.Product;
import cafe.jjdev.mall.vo.ProductCommon;

@Controller
public class ProductCommonController {
	
	@Autowired
	private ProductCommonService productCommonService;
	
	@GetMapping("/product/getProductOne")
	public String getProductOne(Model model,int productCommonNo) {
		System.out.println("컨트롤 상세보기 실행");
		System.out.println("컨트롤 productCommonNo : " + productCommonNo);
		ProductCommon pc = productCommonService.getProductCommonByCategoryOne(productCommonNo);
		System.out.println("●●●●●●●●●●컨트롤 상품 상세보기●●●●●●●●●●●●");
		System.out.println("컨트롤 pc : " + pc);
		System.out.println("●●●●●●●●●●컨트롤 상품 상세보기●●●●●●●●●●●●");
		model.addAttribute("pc", pc);	
		model.addAttribute("path", PathStr.PRODUCT_IMG_PATH);
		if(pc != null) {
			List<Product> products = pc.getProducts();
			
			System.out.println("컨트롤러 db색상,사이즈 옵션의 개수 : " + products.size());
			System.out.println("컨트롤러 products : " + products);
			model.addAttribute("products", products);
		}
		
		
		return "/product/getProductOne";
		
	}
	
	
	@GetMapping("/product/getProductListByCategory")
	public String getProductCommonListByCategoryNo(Model model,@RequestParam(value = "categoryNo", defaultValue = "1" ) int categoryNo,
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
