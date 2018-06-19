package common.mapper;

import common.model.BookAuction;
import common.model.BookBorrow;
import common.model.BookSelling;
import common.query.BookAuctionQuery;
import common.query.BookBorrowQuery;
import common.query.BookSellingQuery;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface BookAuctionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookAuctionQuery record);

    int insertSelective(BookAuction record);

    BookAuction selectByPrimaryKey(Integer id);

    BookAuction selectBookAuctionById(@Param("id")  Integer id,@Param("statusList") List<Integer> statusList);

    List<BookAuction> selectBookAuctionByStatus(@Param("statusList") List<Integer> statusList);

    int updateByPrimaryKeySelective(BookAuction record);

    int updateByPrimaryKey(BookAuction record);

    int queryBookAuctionCount(BookAuctionQuery bookAuctionQuery);

    List<BookAuction> queryBookAuctionList(BookAuctionQuery bookAuctionQuery);

    //竞价成功的竞价
    BookAuction queryBookAuction(BookAuctionQuery bookAuctionQuery);

    List<BookAuction> queryBookAuctionByIds(BookAuctionQuery bookAuctionQuery);


    int queryBookAuctionCountByIds(BookAuctionQuery bookAuctionQuery);

    /*书籍审核*/
    int updateBookAuctionStatus(@Param("id") int id, @Param("status")  int status,@Param("userId") Integer userId,@Param("cTime") int cTime);

    /*状态修改*/
    int updateAuctionStatus(@Param("id") int id, @Param("status")  int status);
    /*竞价成功*/
    int updateBookAuction(@Param("id") int id, @Param("status")  int status, @Param("price")BigDecimal price,@Param("buyerId") int buyerId);
//
//    int upateBookAuctionlUserNumAdd(BookAuctionQuery query);
//
//    int upateBookAuctionUserNumRed(BookAuctionQuery query);
}