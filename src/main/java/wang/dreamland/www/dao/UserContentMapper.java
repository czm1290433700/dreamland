package wang.dreamland.www.dao;

import org.springframework.data.repository.query.Param;
import tk.mybatis.mapper.common.Mapper;
import wang.dreamland.www.entity.UserContent;

import java.util.List;

/**
 * Created by Administrator on 2018/1/9.
 */
public interface UserContentMapper extends Mapper<UserContent> {
    /**
     * 根据用户id查询出梦分类
     * @param uid
     * @return
     */
    List<UserContent> findCategoryByUid(@Param("uid")long uid);
}
