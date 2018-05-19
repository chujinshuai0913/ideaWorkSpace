package common.mapper;

import common.model.TypeBook1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeBook1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TypeBook1 record);

    int insertSelective(TypeBook1 record);

    TypeBook1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TypeBook1 record);

    int updateByPrimaryKey(TypeBook1 record);

    List<TypeBook1> queryTypeBook1List(TypeBook1 typeBook1);

    String queryTypeBook1ById(@Param("id") int id );

}