package common.mapper;

import common.model.RecordGift;
import common.model.RecordSelling;
import common.query.RecordGiftQuery;
import common.query.RecordSellingQuery;

import java.util.List;

public interface RecordGiftMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecordGiftQuery record);

    int insertSelective(RecordGiftQuery record);

    RecordGift selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecordGift record);

    int updateByPrimaryKey(RecordGift record);

    List<RecordGift> getRecordGiftList(RecordGiftQuery query);

    int getRecordGiftCount(RecordGiftQuery query);
}