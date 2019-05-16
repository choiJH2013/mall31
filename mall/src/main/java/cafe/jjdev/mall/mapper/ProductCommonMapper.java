package cafe.jjdev.mall.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.vo.Product;
import cafe.jjdev.mall.vo.ProductCommon;

@Mapper
public interface ProductCommonMapper {
	
	public int selectProductCommonCount(); // 페이징작업 총개수
	public List<ProductCommon> selectProductCommonList(Map<String, Object> map); //1 리스트
	public ProductCommon selectProductCommonByCategory(Product product);

	
}
