package common.mapper;

import common.model.RecordAuction;
import common.model.RecordSelling;
import common.query.RecordAuctionQuery;
import common.query.RecordSellingQuery;

import java.util.List;

public interface RecordAuctionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecordAuctionQuery record);

    int insertSelective(RecordAuction record);

    RecordAuction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecordAuction record);

    int updateByPrimaryKey(RecordAuction record);

    List<RecordAuction> getRecordAuctionList(RecordAuctionQuery query);

    int getRecordAuctionCount(RecordAuctionQuery query);

    List<Integer> getRecordAuctionIds(RecordAuctionQuery query);
}