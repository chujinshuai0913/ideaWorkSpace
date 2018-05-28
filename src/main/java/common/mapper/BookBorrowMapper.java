package common.mapper;

import common.model.BookBorrow;
import common.query.BookBorrowQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookBorrowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookBorrowQuery record);

    int insertSelective(BookBorrow record);

    BookBorrow selectByPrimaryKey(Integer id);

    BookBorrow selectBookBorrowById(@Param("id")  Integer id,@Param("status") Integer status);
    int updateByPrimaryKeySelective(BookBorrow record);

    int updateByPrimaryKey(BookBorrow record);

    int queryBookBorrowCount(BookBorrowQuery bookBorrowQuery);

    List<BookBorrow> queryBookBorrowList(BookBorrowQuery bookBorrowQuery);

    /*书籍审核*/
    int updateBookBorrowStatus(@Param("id") int id, @Param("status")  int status,@Param("userId") int userId,@Param("cTime") int cTime);
   int upateBookBorrowUserNumAdd(BookBorrowQuery query);

    int upateBookBorrowUserNumRed(BookBorrowQuery query);

}