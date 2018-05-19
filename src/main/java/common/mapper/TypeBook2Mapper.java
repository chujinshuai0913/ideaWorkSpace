package common.mapper;

import common.model.TypeBook1;
import common.model.TypeBook2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeBook2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TypeBook2 record);

    int insertSelective(TypeBook2 record);

    TypeBook2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TypeBook2 record);

    int updateByPrimaryKey(TypeBook2 record);

    List<TypeBook2> queryTypeBook2List(TypeBook2 typeBook2);

    String queryTypeBook2ById(@Param("id") int id );
}