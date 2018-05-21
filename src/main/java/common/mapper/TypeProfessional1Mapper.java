package common.mapper;

import common.model.TypeBook1;
import common.model.TypeProfessional1;
import common.model.TypeProfessional2;
import common.query.TypeBook2Query;
import common.query.TypeProfessional1Query;
import common.query.TypeProfessional2Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeProfessional1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TypeProfessional1Query record);

    int insertSelective(TypeProfessional1 record);

    TypeProfessional1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TypeProfessional1 record);

    int updateByPrimaryKey(TypeProfessional1 record);
    List<TypeProfessional1> queryTypeProfessional1List(TypeProfessional1 typeProfessional1);

    String queryTypeProfessional1ById(@Param("id") int id );


    List<TypeProfessional1> queryTypeProfessional1Lists(TypeProfessional1Query query);

    int queryTypeProfessional1Count(TypeProfessional1Query query);

    int queryTypeProfessional1ByName(TypeProfessional1Query query);

    int updateTypeProfessional1Status(@Param("id") int id, @Param("status")  int status,@Param("cU") int cU,@Param("cTime") int cTime);
}