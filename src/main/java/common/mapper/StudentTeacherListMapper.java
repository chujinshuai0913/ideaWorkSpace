package common.mapper;

import common.model.StudentTeacherList;
import common.query.StudentTeacherQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentTeacherListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentTeacherList record);

    int insertSelective(StudentTeacherList record);

    StudentTeacherList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentTeacherList record);

    int updateByPrimaryKey(StudentTeacherList record);

    StudentTeacherList getStudentTeacherList(@Param("schoolCode") Integer schoolCode);

    List<StudentTeacherList> getStudentTeacherLists(StudentTeacherQuery query);
   int getStudentTeacherListCount(StudentTeacherQuery query);
}