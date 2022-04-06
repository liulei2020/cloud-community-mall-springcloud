package top.liulei.cloud.community.mall.productcategory.model.dao;



import java.util.List;
import org.springframework.stereotype.Repository;
import top.liulei.cloud.community.mall.productcategory.model.pojo.Category;

@Repository
public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    Category selectByName(String name);

    List<Category> selectList();

    List<Category> selectCategoriesByParentId(Integer parentId);
}