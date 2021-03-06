package common.mapper;

import common.model.RecordBorrow;
import common.model.RecordSelling;
import common.query.RecordBorrowQuery;
import common.query.RecordSellingQuery;

import java.util.List;

public interface RecordBorrowMapper {
    int insert(RecordBorrowQuery record);

    int insertSelective(RecordBorrow record);

    List<RecordBorrow> getRecordBorrowList(RecordBorrowQuery query);

    RecordBorrow getRecordBorrowById(RecordBorrowQuery query);
    int updateRecordBorrowBlack(RecordBorrowQuery query);

    int getRecordBorrowCount(RecordBorrowQuery query);
}