package common.mapper;

import common.model.Abnormal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AbnormalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Abnormal record);

    int insertSelective(Abnormal record);

    Abnormal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Abnormal record);

    int updateByPrimaryKey(Abnormal record);

    /*清空表*/
    int deleteAbnormal();

    List<Abnormal> getAbnormal();

    int batchInsertAbnormal( @Param("list") List<Abnormal> list);
}