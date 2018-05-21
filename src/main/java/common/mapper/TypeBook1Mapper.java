package common.mapper;

import common.model.TypeBook1;
import common.query.TypeBook1Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeBook1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TypeBook1Query record);

    int insertSelective(TypeBook1 record);

    TypeBook1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TypeBook1 record);

    int updateByPrimaryKey(TypeBook1 record);

    List<TypeBook1> queryTypeBook1List(TypeBook1 typeBook1);

    List<TypeBook1> queryTypeBook1Lists(TypeBook1Query query);

    int queryTypeBook1Count(TypeBook1Query query);

    int queryTypeBook1ByName(TypeBook1Query query);

    String queryTypeBook1ById(@Param("id") int id );

    /*书籍审核*/
    int updateBookClass1Status(@Param("id") int id, @Param("status")  int status,@Param("cU") int cU,@Param("cTime") int cTime);

}