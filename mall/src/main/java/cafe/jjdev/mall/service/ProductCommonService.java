package cafe.jjdev.mall.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cafe.jjdev.mall.mapper.ProductCommonMapper;
import cafe.jjdev.mall.vo.ProductCommon;

@Service
@Transactional
public class ProductCommonService {
	@Autowired
	private ProductCommonMapper productCommonMapper;
	
	//접근지정자 //리턴데이터타입	   //메소드명						//입력데이터타입 // 매개변수
	public Map<String, Object> getProductCommonListByCategoryNo(int categoryNo, int currentPage, String searchWord) {
		System.out.println("프로덕트 서비스 시작");
		
		//맵을 사용한다
		Map<String, Object> map = new HashMap<String, Object>();
				
		//받아온값 카테고리 넘버를 맵에 넣는다
		map.put("categoryNo", categoryNo);
		map.put("searchWord", "%"+searchWord+"%");
		System.out.println("categoryNo : " + categoryNo);
		
		//페이징에 사용할 변수를 만든다 ROW_PER_PAGE: 보여줄 데이터 개수
		final int ROW_PER_PAGE = 10;
		
		//페이징에 사용할 변수 startRow:몇번째데이터 부터 보여줄지를 정함
		int startRow = (currentPage-1)*ROW_PER_PAGE;
		System.out.println("startRow : " + startRow);
		
		//매서드를 실행하기위해 필요한 것들을 맵안에 넣는다.
		map.put("startRow", startRow);
		map.put("rowPerPage", ROW_PER_PAGE); 
		System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
		System.out.println("map : " + map);
		System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
		
		// 쿼리문 WHERE절에 필요한값 categoryNo과 LIMIT에 필요한값 startRow,rowPerPage을 맵에 담아 같이 넘긴다
		List<ProductCommon> list = productCommonMapper.selectProductCommonList(map);
		
		// 라스트 페이지를 구하기위해 데이터 총개수를 구함
		int allCount = productCommonMapper.selectProductCommonCount();
		
		// 마지막페이지 구하는 알고리즘 데이터총개수/보여지는데이터개수      
		int lastPage = allCount/ROW_PER_PAGE;
		
		// 나눠서 나머지가 있을경우  예 : 105%10 은 10.5 이므로 완전히 나눌수없어서 나머지가 있다. 이경우 데이터가 남아있기에 페이지를 한장더 있어야 나머지 5개의 데이터를 볼 수 있다.
		// ※ SQL은 알아서 마지막남은걸 보여주지만 / 마지막도 갯수를 알려줘야 하는것도 있다.
		if(allCount%ROW_PER_PAGE != 0) {
			lastPage++;
		}
		
		//맵의 새로운 객체를 만들어서 결과값들을 담자 
		HashMap<String, Object> resultmap = new HashMap<String, Object>();
		// 뷰에서 사용할 출력데이터,마지막페이지 
		resultmap.put("list", list);
		resultmap.put("lastPage", lastPage);
		
		return resultmap;
	}
	
}
