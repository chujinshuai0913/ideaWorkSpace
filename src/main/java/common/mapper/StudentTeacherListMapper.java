package common.mapper;

import common.model.StudentTeacherList;
import org.apache.ibatis.annotations.Param;

public interface StudentTeacherListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentTeacherList record);

    int insertSelective(StudentTeacherList record);

    StudentTeacherList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentTeacherList record);

    int updateByPrimaryKey(StudentTeacherList record);

    StudentTeacherList getStudentTeacherList(@Param("schoolCode") Integer schoolCode);
}