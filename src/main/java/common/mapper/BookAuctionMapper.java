package common.mapper;

import common.model.BookAuction;
import common.model.BookBorrow;
import common.model.BookSelling;
import common.query.BookAuctionQuery;
import common.query.BookBorrowQuery;
import common.query.BookSellingQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookAuctionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookAuctionQuery record);

    int insertSelective(BookAuction record);

    BookAuction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookAuction record);

    int updateByPrimaryKey(BookAuction record);

    int queryBookAuctionCount(BookAuctionQuery bookAuctionQuery);

    List<BookAuction> queryBookAuctionList(BookAuctionQuery bookAuctionQuery);

    List<BookAuction> queryBookAuctionByIds(BookAuctionQuery bookAuctionQuery);


    int queryBookAuctionCountByIds(BookAuctionQuery bookAuctionQuery);
    /*书籍审核*/
    int updateBookAuctionStatus(@Param("id") int id, @Param("status")  int status,@Param("userId") int userId,@Param("cTime") int cTime);
//
//    int upateBookAuctionlUserNumAdd(BookAuctionQuery query);
//
//    int upateBookAuctionUserNumRed(BookAuctionQuery query);
}