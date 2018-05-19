package common.mapper;

import common.model.RecordBorrow;
import common.model.RecordSelling;
import common.query.RecordBorrowQuery;
import common.query.RecordSellingQuery;

import java.util.List;

public interface RecordBorrowMapper {
    int insert(RecordBorrow record);

    int insertSelective(RecordBorrow record);

    List<RecordBorrow> getRecordBorrowList(RecordBorrowQuery query);

    int getRecordBorrowCount(RecordBorrowQuery query);
}