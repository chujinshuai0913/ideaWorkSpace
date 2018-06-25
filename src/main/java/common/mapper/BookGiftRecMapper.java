package common.mapper;

import common.model.BookGiftRec;
import common.query.BookGiftRecQuery;

import java.util.List;

public interface BookGiftRecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookGiftRec record);

    int insertSelective(BookGiftRec record);

    BookGiftRec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookGiftRecQuery record);

    int updateByPrimaryKey(BookGiftRec record);

    List<BookGiftRec> getBookGiftRecList(BookGiftRecQuery query);

    int getBookGiftRecCount(BookGiftRecQuery query);
}