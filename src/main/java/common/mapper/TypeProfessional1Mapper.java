package common.mapper;

import common.model.TypeBook1;
import common.model.TypeProfessional1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeProfessional1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TypeProfessional1 record);

    int insertSelective(TypeProfessional1 record);

    TypeProfessional1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TypeProfessional1 record);

    int updateByPrimaryKey(TypeProfessional1 record);
    List<TypeProfessional1> queryTypeProfessional1List(TypeProfessional1 typeProfessional1);

    String queryTypeProfessional1ById(@Param("id") int id );
}