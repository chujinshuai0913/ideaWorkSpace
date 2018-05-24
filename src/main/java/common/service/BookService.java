/**
 * Copyright (C), 2018-2018
 * FileName: BookService
 * Author:   jinshuai
 * Date:     2018/4/9 22:40
 * Description: 书籍操作
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.service;

import common.model.*;
import common.query.*;
import common.util.ServiceResult;
import common.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈书籍操作〉
 *
 * @author jinshuai
 * @create 2018/4/9
 * @since 1.0.0
 */
public interface BookService {

    /*
    * 查询书籍信息book
    */
    ServiceResult<List<BookVo>>  queryBookList(BookQuery bookQuery);


    ServiceResult<Integer> insertBook(BookQuery query);
    /*
    * 查询书籍总数count
    */
    ServiceResult<Integer> queryBookCount(BookQuery bookQuery);

    /*
     * 查询书籍信息根据 BookID
     */
    ServiceResult<BookVo> queryBookByBookId(int bookId);

    /*
     * 根据bookIDs查询书籍
     */
    ServiceResult<List<BookVo>> queryBookListByBookIds(List<Integer> bookIds);

    /*
     * 查询书籍信息根据 ISBN
     */
    ServiceResult<BookVo> queryBookByBookISBN(int ISBN);

    /*
     * 根据ISBNs查询书籍
     */
    ServiceResult<List<BookVo>> queryBookListByISBNs(List<Integer> ISBNs);


    /*拼接数据*/

     BookVo getBookVo(Book book,BookVo bookVo);

    /*拼接数据*/

    BookSellingVo getBookSellingVo(BookSelling bookSelling, BookSellingVo bookSellingVo);

    /*拼接数据*/

    BookBorrowVo getBookBorrowVo(BookBorrow bookBorrow, BookBorrowVo bookBorrowVo);

    /*拼接数据*/

    BookAuctionVo getBookAuctionVo(BookAuction bookAuction, BookAuctionVo bookAuctionVo);

    /*拼接数据*/

    BookGiftVo getBookGiftVo(BookGift bookGift, BookGiftVo bookGiftVo);

    RecordSellingVo  getRecordSellingVo(RecordSelling recordSelling,RecordSellingVo recordSellingVo);

    RecordGiftVo  getRecordGiftVo(RecordGift recordGift,RecordGiftVo recordGiftVo);

    RecordBorrowVo  getRecordBorrowVo(RecordBorrow recordBorrow,RecordBorrowVo recordBorrowVo);

    RecordAuctionVo  getRecordAuctionVo(RecordAuction recordAuction,RecordAuctionVo recordAuctionVo);

    BookProfessionalListVo  getBookProfessionalListVo(BookProfessionalList bookProfessionalList,BookProfessionalListVo bookProfessionalListVo);

    BookGiftRecVo  getBookGiftRecVo(BookGiftRec bookGiftRec,BookGiftRecVo bookGiftRecVo);

    /*
     * 查询书籍总数count
     */
    ServiceResult<Integer> queryBookSellingCount(BookSellingQuery bookSellingQuery);

    /*
     * 查询书籍总数count
     */
    ServiceResult<List<BookSellingVo>> queryBookSellingVoList(BookSellingQuery bookSellingQuery);


    /*
     * 查询书籍总数count
     */
    ServiceResult<Integer> queryBookAuctionCount(BookAuctionQuery bookAuctionQuery);

    /*
     * 查询书籍总数count
     */
    ServiceResult<List<BookAuctionVo>> queryBookAutionVoList(BookAuctionQuery bookAuctionQuery);

    /*
     * 查询书籍总数count
     */
    ServiceResult<Integer> queryBookBorrowCount(BookBorrowQuery bookBorrowQuery);

    /*
     * 查询书籍总数count
     */
    ServiceResult<List<BookBorrowVo>> queryBookBorrowVoList(BookBorrowQuery bookBorrowQuery);
    /*
     * 查询书籍总数count
     */
    ServiceResult<Integer> queryBookGiftCount(BookGiftQuery bookGiftQuery);


    /*
     * 查询书籍总数count
     */
    ServiceResult<List<BookGiftVo>> queryBookBookGiftVoList(BookGiftQuery bookGiftQuery);


    /*
     * 查询书籍总数count
     */
    ServiceResult<BookGiftVo> queryBookBookGiftVo(Integer id);

     /*查询售卖书籍记录*/
     ServiceResult< List<RecordSellingVo>> getRecordsellingList(RecordSellingQuery query);

     ServiceResult<Integer> getRecordsellingCount(RecordSellingQuery query);

    /*查询租借书籍记录*/
    ServiceResult< List<RecordBorrowVo>> getRecordBorrowList(RecordBorrowQuery query);

    ServiceResult<Integer> getRecordBorrowCount(RecordBorrowQuery query);

    /*查询赠予书籍记录*/
    ServiceResult< List<RecordGiftVo>> getRecordGiftList(RecordGiftQuery query);

    ServiceResult<Integer> getRecordGiftCount(RecordGiftQuery query);

    /*查询拍卖书籍记录*/
    ServiceResult< List<RecordAuctionVo>> getRecordAuctionList(RecordAuctionQuery query);

    ServiceResult<Integer> getRecordAuctionCount(RecordAuctionQuery query);

    /*买卖书籍书籍审核*/
    ServiceResult<Integer> updateBookSellingStatus(List<Integer> ids,int status,int userId,int cTime);

    /*根据id和状态*/
    ServiceResult<List<BookSelling>> queryBookSellingByIds(List<Integer> ids,int status);

    /*买卖书籍书籍审核*/
    ServiceResult<Integer> updateBookBorrowStatus(List<Integer> ids,int status,int userId,int cTime);

    /*买卖书籍书籍审核*/
    ServiceResult<Integer> updateBookGiftStatus(List<Integer> ids,int status,int userId,int cTime);

    /*买卖书籍书籍审核*/
    ServiceResult<Integer> updateBooAuctionStatus(List<Integer> ids,int status,int userId,int cTime);

    /*查询书单列表*/
    ServiceResult<List<BookProfessionalListVo>> getBookProfessionalList(BookProfessionalListQuery query);


    /*修改书单列表*/

    ServiceResult<Integer> updateBookProfessionalList(BookProfessionalListQuery query);

    /*删除书单列表*/
    ServiceResult<Integer> deleteBookProfessionalList(BookProfessionalListQuery query);

    /*查询书单总数*/

    ServiceResult<Integer> getBookProfessionalListCount(BookProfessionalListQuery query);

    /*查询书单总数*/

    ServiceResult<Integer> queryBookGiftRecCount(BookGiftRecQuery query);

    ServiceResult<List<BookGiftRecVo>> queryBookGiftRecList(BookGiftRecQuery query);

    ServiceResult<BookVo> queryBookListTopTen(BookQuery query);
}
