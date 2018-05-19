package common.mapper;

import common.model.BookSelling;
import common.query.BookSellingQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookSellingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookSelling record);

    int insertSelective(BookSelling record);

    BookSelling selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookSelling record);

    int updateByPrimaryKey(BookSelling record);

    int queryBookSellingCount(BookSellingQuery bookSellingQuery);
    /*根据售卖人*/
    List<BookSelling> queryBookSellingList(BookSellingQuery bookSellingQuery);
    /*根据id和状态*/
    List<BookSelling> queryBookSellingByIds(@Param("ids") List<Integer> ids,@Param("status")  int status);

    /*书籍审核*/
    int updateBookSellingStatus(@Param("id") int id, @Param("status")  int status,@Param("userId") int userId,@Param("cTime") int cTime);
}