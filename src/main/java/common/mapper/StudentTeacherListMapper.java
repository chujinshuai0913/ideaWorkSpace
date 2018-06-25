package common.mapper;

import common.model.StudentTeacherList;
import common.query.StudentTeacherQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentTeacherListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentTeacherList record);

    int insertSelective(StudentTeacherList record);

    int insertStudentTeacherListBatch(@Param("list") List<StudentTeacherList> list);
    StudentTeacherList selectByPrimaryKey(Integer id);
    StudentTeacherList selectBySchoolCode(@Param("idNum") Long idNum);

    int updateByPrimaryKeySelective(StudentTeacherList record);

    int updateStudentTeacherList(@Param("schoolCode") Long schoolCode,@Param("time") int time);

    int updateByPrimaryKey(StudentTeacherList record);

    StudentTeacherList getStudentTeacherList(@Param("schoolCode") Long schoolCode);

    List<StudentTeacherList> getStudentTeacherLists(StudentTeacherQuery query);
   int getStudentTeacherListCount(StudentTeacherQuery query);
}