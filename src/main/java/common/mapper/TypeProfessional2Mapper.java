package common.mapper;

import common.model.TypeProfessional1;
import common.model.TypeProfessional2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeProfessional2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TypeProfessional2 record);

    int insertSelective(TypeProfessional2 record);

    TypeProfessional2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TypeProfessional2 record);

    int updateByPrimaryKey(TypeProfessional2 record);

    List<TypeProfessional2> queryTypeProfessional2List(TypeProfessional2 typeProfessional2);

    String queryTypeProfessional2ById(@Param("id") int id );
}