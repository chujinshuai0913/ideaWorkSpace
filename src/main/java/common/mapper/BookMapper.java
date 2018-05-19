package common.mapper;

import common.model.Book;
import common.query.BookQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    /*
     * 查询书籍信息book
     */
    List<Book> queryBookList(BookQuery bookQuery);


    /** 查询书籍总数count*/

    int queryBookCount(BookQuery bookQuery);


    /* 查询书籍信息根据 BookID*/

    Book queryBookByBookId(@Param("id") int bookId);


    /* 根据bookIDs查询书籍*/

    List<Book> queryBookListByBookIds(@Param("ids") List<Integer> bookIds);

    /* 查询书籍信息根据 ISBN*/

    Book queryBookByBookISBN(@Param("isbn") int isbn);


    /*  * 根据ISBNs查询书籍*/

    List<Book> queryBookListByISBNs(@Param("isbns") List<Integer> isbns);
}