package common.mapper;

import common.model.RecordSelling;
import common.query.RecordSellingQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordSellingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecordSellingQuery record);

    int insertSelective(RecordSelling record);

    RecordSelling selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecordSelling record);

    int updateByPrimaryKey(RecordSelling record);

    /*异常用户*/
    List<RecordSelling> getRecordsellingBuyer(RecordSellingQuery query);

    List<RecordSelling> getRecordsellingList(RecordSellingQuery query);

    int getRecordsellingCount(RecordSellingQuery query);

}