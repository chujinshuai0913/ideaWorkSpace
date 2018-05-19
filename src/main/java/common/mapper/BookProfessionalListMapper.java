package common.mapper;

import common.model.BookProfessionalList;
import common.query.BookProfessionalListQuery;

import java.util.List;

public interface BookProfessionalListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookProfessionalList record);

    int insertSelective(BookProfessionalList record);

    BookProfessionalList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookProfessionalList record);

    int updateByPrimaryKey(BookProfessionalList record);

    /*查询书单列表*/
     List<BookProfessionalList> getBookProfessionalList(BookProfessionalListQuery bookProfessionalListQuery);

    /*修改书单列表*/

     int updateBookProfessionalList(BookProfessionalListQuery bookProfessionalListQuery);

    /*删除书单列表*/
     int deleteBookProfessionalList(BookProfessionalListQuery bookProfessionalListQuery);

    /*查询书单总数*/

    int getBookProfessionalListCount(BookProfessionalListQuery bookProfessionalListQuery);
}