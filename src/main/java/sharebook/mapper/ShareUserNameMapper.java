package sharebook.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sharebook.model.ShareUserName;
import sharebook.model.ShareUserNameExample;

@Repository
public interface ShareUserNameMapper {
    int countByExample(ShareUserNameExample example);

    int deleteByExample(ShareUserNameExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShareUserName record);

    int insertSelective(ShareUserName record);

    List<ShareUserName> selectByExample(ShareUserNameExample example);

    ShareUserName selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShareUserName record, @Param("example") ShareUserNameExample example);

    int updateByExample(@Param("record") ShareUserName record, @Param("example") ShareUserNameExample example);

    int updateByPrimaryKeySelective(ShareUserName record);

    int updateByPrimaryKey(ShareUserName record);
}