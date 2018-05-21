package common.mapper;

import common.model.TypeBook2;
import common.model.TypeProfessional1;
import common.model.TypeProfessional2;
import common.query.TypeBook2Query;
import common.query.TypeProfessional2Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeProfessional2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TypeProfessional2Query record);

    int insertSelective(TypeProfessional2 record);

    TypeProfessional2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TypeProfessional2 record);

    int updateByPrimaryKey(TypeProfessional2 record);

    List<TypeProfessional2> queryTypeProfessional2List(TypeProfessional2 typeProfessional2);

    String queryTypeProfessional2ById(@Param("id") int id );

    List<TypeProfessional2> queryTypeProfessional2Lists(TypeProfessional2Query query);

    int queryTypeProfessional2Count(TypeProfessional2Query query);

    int queryTypeProfessional2ByName(TypeProfessional2Query query);

    /*书籍审核*/
    int updateTypeProfessional2Status(@Param("id") int id, @Param("status")  int status,@Param("cU") int cU,@Param("cTime") int cTime);
}