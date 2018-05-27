

package common.mapper;

import common.model.Book;
import common.query.BookQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookQuery record);

    Book selectByPrimaryKey(Integer id);

    /*
     * 查询书籍信息book
     */
    List<Book> queryBookList(BookQuery bookQuery);

    /*
     * 查询十大畅销书籍book
     */
    List<Book> queryBookListTopTen(BookQuery bookQuery);

    /** 查询书籍总数count*/

    int queryBookCount(BookQuery bookQuery);


    /* 查询书籍信息根据 BookID*/

    Book queryBookByBookId(@Param("id") int bookId);


    /* 根据bookIDs查询书籍*/

    List<Book> queryBookListByBookIds(@Param("ids") List<Integer> bookIds);

    /* 查询书籍信息根据 ISBN*/

    Book queryBookByBookISBN(@Param("isbn") Long isbn);


    /*  * 根据ISBNs查询书籍*/

    List<Book> queryBookListByISBNs(@Param("isbns") List<Long> isbns);


    int upateBookUserNumAdd(BookQuery query);

    int upateBookUserNumRed(BookQuery query);

}

