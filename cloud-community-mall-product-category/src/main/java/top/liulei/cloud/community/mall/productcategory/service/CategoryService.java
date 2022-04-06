package top.liulei.cloud.community.mall.productcategory.service;

import com.github.pagehelper.PageInfo;
import top.liulei.cloud.community.mall.productcategory.model.pojo.Category;
import top.liulei.cloud.community.mall.productcategory.model.request.AddCategoryReq;
import top.liulei.cloud.community.mall.productcategory.model.vo.CategoryVO;


import java.util.List;

/**
 * 描述：     分类目录Service
 */
public interface CategoryService {

    void add(AddCategoryReq addCategoryReq);

    void update(Category updateCategory);

    void delete(Integer id);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    List<CategoryVO> listCategoryForCustomer(Integer parentId);
}
