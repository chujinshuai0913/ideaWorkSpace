package common.mapper;

import common.model.BookAuction;
import common.model.BookGift;
import common.query.BookAuctionQuery;
import common.query.BookGiftQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookGiftMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookGift record);

    int insertSelective(BookGift record);

    BookGift selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookGift record);

    int updateByPrimaryKey(BookGift record);

    int queryBookGiftCount(BookGiftQuery bookGiftQuery);

    List<BookGift> queryBookGiftList(BookGiftQuery bookGiftQuery);

    /*书籍审核*/
    int updateBookGiftStatus(@Param("id") int id, @Param("status")  int status,@Param("userId") int userId,@Param("cTime") int cTime);
}