package common.mapper;

import common.model.TypeBook1;
import common.model.TypeBook2;
import common.query.TypeBook1Query;
import common.query.TypeBook2Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeBook2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TypeBook2Query query);

    int insertSelective(TypeBook2 record);

    TypeBook2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TypeBook2 record);

    int updateByPrimaryKey(TypeBook2 record);

    List<TypeBook2> queryTypeBook2List(TypeBook2 typeBook2);

    String queryTypeBook2ById(@Param("id") int id );

    List<TypeBook2> queryTypeBook2Lists(TypeBook2Query query);

    int queryTypeBook2Count(TypeBook2Query query);

    int queryTypeBook2ByName(TypeBook2Query query);

    /*书籍审核*/
    int updateBookClass2Status(@Param("id") int id, @Param("status")  int status,@Param("cU") int cU,@Param("cTime") int cTime);

}