/**
 * Copyright (C), 2018-2018
 * FileName: BookServiceImpl
 * Author:   jinshuai
 * Date:     2018/4/9 22:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.service.Impl;

import com.alibaba.fastjson.JSONObject;
import common.constant.*;
import common.mapper.*;
import common.model.*;
import common.query.*;
import common.service.BookService;
import common.util.DateUtils;
import common.util.ServiceResult;
import common.vo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/4/9
 * @since 1.0.0
 */
@Service
public class BookServiceImpl implements BookService {
    private static final Logger logger = Logger.getLogger(BookServiceImpl.class);

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private TypeBook1Mapper typeBook1Mapper;
    @Autowired
    private TypeBook2Mapper typeBook2Mapper;

    @Autowired
    private TypeProfessional1Mapper typeProfessional1Mapper;

    @Autowired
    private TypeProfessional2Mapper typeProfessional2Mapper;

    @Autowired
    private  UserManagerMapper userManagerMapper;

    @Autowired
    private BookSellingMapper bookSellingMapper;

    @Autowired
    private BookAuctionMapper bookAuctionMapper;

    @Autowired
    private  BookGiftMapper bookGiftMapper;

    @Autowired
    private BookBorrowMapper bookBorrowMapper;

    @Autowired
    private UserShareMapper userShareMapper;

    @Autowired
    private  RecordSellingMapper recordSellingMapper;

    @Autowired
    private  RecordBorrowMapper recordBorrowMapper;

    @Autowired
    private  RecordAuctionMapper recordAuctionMapper;
    @Autowired
    private RecordGiftMapper recordGiftMapper;
    @Autowired
    private BookProfessionalListMapper bookProfessionalListMapper;

    @Autowired
    private BookGiftRecMapper bookGiftRecMapper;

    @Override
    public ServiceResult<List<BookVo>> queryBookList(BookQuery bookQuery) {
      try {
          List<BookVo> bookVos=new ArrayList<>();
          ServiceResult<List<Book>> serviceResult=new ServiceResult<>(bookMapper.queryBookList(bookQuery));
          if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
              for (Book book:serviceResult.getBody()) {
                  BookVo bookVo= new BookVo();
                  bookVos.add(this.getBookVo(book,bookVo));
              }
          }
          return new ServiceResult<>(bookVos) ;
      }catch (Exception e){
          logger.error(e.getMessage(),e);
          return new ServiceResult<>(11,e.getMessage());
      }

    }

    @Override
    public ServiceResult<Integer> upateBookUserNumAdd(BookQuery query) {
        return new ServiceResult<>(bookMapper.upateBookUserNumAdd(query));
    }

    @Override
    public ServiceResult<Integer> upateBookUserNumRed(BookQuery query) {
        return new ServiceResult<>(bookMapper.upateBookUserNumRed(query));
    }

    @Override
    public ServiceResult<Integer> upateBookSellUserNumAdd(BookSellingQuery query) {
        return  new ServiceResult<>(bookSellingMapper.upateBookSellUserNumAdd(query));
    }

    @Override
    public ServiceResult<Integer> upateBookSellUserNumRed(BookSellingQuery query) {
        return new ServiceResult<>(bookSellingMapper.upateBookSellUserNumRed(query));
    }

    @Override
    public ServiceResult<Integer> upateBookBorrowUserNumAdd(BookBorrowQuery query){
        return new ServiceResult<>(bookBorrowMapper.upateBookBorrowUserNumAdd(query));
    }

    @Override
    public ServiceResult<Integer> upateBookBorrowUserNumRed(BookBorrowQuery query) {
        return new ServiceResult<>(bookBorrowMapper.upateBookBorrowUserNumRed(query));
    }

    @Override
    public ServiceResult<Integer> upateBookGiftUserNumRed(BookGiftQuery query) {
        return new ServiceResult<>(bookGiftMapper.upateBookGiftUserNumRed(query));
    }

    @Override
    public ServiceResult<Integer> upateBookGiftUserNumAdd(BookGiftQuery query) {
        return new ServiceResult<>(bookGiftMapper.upateBookGiftUserNumAdd(query));
    }

    @Override
    public ServiceResult<Integer> upateBookAuctionlUserNumAdd(BookAuctionQuery query) {
        return null;
    }

    @Override
    public ServiceResult<Integer> upateBookAuctionUserNumRed(BookAuctionQuery query) {
        return null;
    }

    @Override
    public ServiceResult<Integer> insertBook(BookQuery query) {
        return new ServiceResult<>(bookMapper.insert(query));
    }

    @Override
    public ServiceResult<Integer> queryBookCount(BookQuery bookQuery) {
        return new ServiceResult<>(bookMapper.queryBookCount(bookQuery));
    }

    @Override
    public ServiceResult<Integer> insertSellBook(BookSellingQuery query) {
        return new ServiceResult<>(bookSellingMapper.insert(query));
    }

    @Override
    public ServiceResult<Integer> insertBorrowBook(BookBorrowQuery query) {
        return new ServiceResult<>(bookBorrowMapper.insert(query));
    }

    @Override
    public ServiceResult<Integer> insertGiftBook(BookGiftQuery query) {
        return new ServiceResult<>(bookGiftMapper.insert(query));
    }

    @Override
    public ServiceResult<Integer> insertAuctionBook(BookAuctionQuery query) {
        return new ServiceResult<>(bookAuctionMapper.insert(query));
    }

    @Override
    public ServiceResult<Integer> insertRSellBook(RecordSellingQuery query) {
        return new ServiceResult<>(recordSellingMapper.insert(query));
    }

    @Override
    public ServiceResult<Integer> insertRBorrowBook(RecordBorrowQuery query) {
        return new ServiceResult<>(recordBorrowMapper.insert(query));
    }

    @Override
    public ServiceResult<Integer> insertRGiftBook(RecordGiftQuery query) {
        return new ServiceResult<>(recordGiftMapper.insert(query));
    }

    @Override
    public ServiceResult<Integer> insertRAuctionBook(RecordAuctionQuery query) {
        return new ServiceResult<>(recordAuctionMapper.insert(query));
    }

    @Override
    public ServiceResult<BookVo> queryBookByBookId(int bookId) {
        try {
            BookVo bookVo =new BookVo();
            ServiceResult<Book> serviceResult=new ServiceResult<>(bookMapper.queryBookByBookId(bookId));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                Book book=serviceResult.getBody();
                bookVo=this.getBookVo(book,bookVo);
            }
            return new ServiceResult<>(bookVo) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<List<BookVo>> queryBookListByBookIds(List<Integer> bookIds) {
        try {
            List<BookVo> bookVos=new ArrayList<>();

            ServiceResult<List<Book>> serviceResult=new ServiceResult<>(bookMapper.queryBookListByBookIds(bookIds));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (Book book:serviceResult.getBody()) {
                    BookVo bookVo= new BookVo();
                    bookVos.add(this.getBookVo(book,bookVo));
                }
            }
            return new ServiceResult<>(bookVos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }

    }

    @Override
    public ServiceResult<BookVo> queryBookByBookISBN(int ISBN) {
        try {
            BookVo bookVo =new BookVo();
            ServiceResult<Book> serviceResult=new ServiceResult<>(bookMapper.queryBookByBookISBN(ISBN));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                Book book=serviceResult.getBody();
               bookVo= this.getBookVo(book,bookVo);
            }
            return new ServiceResult<>(bookVo) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<List<BookVo>> queryBookListByISBNs(List<Integer> ISBNs) {
        try {
            List<BookVo> bookVos=new ArrayList<>();
            List<Book> books=new ArrayList<>();

            ServiceResult<List<Book>> serviceResult=new ServiceResult<>(bookMapper.queryBookListByISBNs(ISBNs));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (Book book:serviceResult.getBody()) {
                    BookVo bookVo= new BookVo();
                    bookVos.add(this.getBookVo(book,bookVo));
                }
            }
            return new ServiceResult<>(bookVos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public BookVo getBookVo(Book book, BookVo bookVo) {
       try {
           bookVo = JSONObject.parseObject(JSONObject.toJSONString(book),BookVo.class);
           if(book.getcT()!=null&&book.getcT()>0)
           {
               bookVo.setcTime(DateUtils.getDateStringByTimeStamp(book.getcT(),DateUtils.YMDHMS));
           }
           if(book.getExportTime()!=null&&book.getExportTime()>0)
           {
               bookVo.seteTime(DateUtils.getDateStringByTimeStamp(book.getExportTime(),DateUtils.YMDHMS));
           }
           if(book.getImportTime()!=null&&book.getImportTime()>0)
           {
               bookVo.setiTime(DateUtils.getDateStringByTimeStamp(book.getImportTime(),DateUtils.YMDHMS));
           }
           if(book.getPressTime()!=null&&book.getPressTime()>0)
           {
               bookVo.setpTime(DateUtils.getDateStringByTimeStamp(book.getPressTime(),DateUtils.YMD));
           }
           if(book.getPrintTime()!=null&&book.getPrintTime()>0)
           {
               bookVo.setPrTime(DateUtils.getDateStringByTimeStamp(book.getPrintTime(),DateUtils.YMD));
           }
           if (book.getBookType1()!=null&&book.getBookType1()>0){
               bookVo.setBookTypeName1(typeBook1Mapper.queryTypeBook1ById(book.getBookType1()));
           }
           if (book.getBookType2()!=null&&book.getBookType2()>0){
               bookVo.setBookTypeName2(typeBook2Mapper.queryTypeBook2ById(book.getBookType2()));
           }
           if (book.getProfessionalType1()!=null&&book.getProfessionalType1()>0){
               bookVo.setProfessionalTypeName1(typeProfessional1Mapper.queryTypeProfessional1ById(book.getProfessionalType1()));
           }
           if (book.getProfessionalType2()!=null&&book.getProfessionalType2()>0){
               bookVo.setProfessionalTypeName2(typeProfessional2Mapper.queryTypeProfessional2ById(book.getProfessionalType2()));
           }
           if (book.getExportUser()!=null&&book.getExportUser()>0){
               ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(book.getExportUser()));
               if(result.getSuccess()&&result.getBody()!=null){
                   bookVo.seteUser(result.getBody().getUsername());
               }
           }
           if (book.getcU()!=null&&book.getcU()>0){
               ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(book.getcU()));
               if(result.getSuccess()&&result.getBody()!=null){
                   bookVo.setcName(result.getBody().getUsername());
               }
           }
           if (book.getImportUser()!=null&&book.getImportUser()>0){
               ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(book.getImportUser()));
               if(result.getSuccess()&&result.getBody()!=null){
                   bookVo.setiUser(result.getBody().getUsername());
               }
           }
           if (book.getPrintUser()!=null&&book.getPrintUser()>0){
               ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(book.getPrintUser()));
               if(result.getSuccess()&&result.getBody()!=null){
                   bookVo.setPrUser(result.getBody().getUsername());
               }
           }
           return bookVo;
       }catch (Exception e){
           logger.error(e.getMessage(),e);
           return new BookVo();
       }
    }

    @Override
    public BookSellingVo getBookSellingVo(BookSelling bookSelling, BookSellingVo bookSellingVo) {
        try {
            bookSellingVo = JSONObject.parseObject(JSONObject.toJSONString(bookSelling),BookSellingVo.class);
            bookSellingVo.setcName("");
            bookSellingVo.setcTime("");
            bookSellingVo.setdTime("");
            bookSellingVo.seteTime("");
            bookSellingVo.seteUser("");
            bookSellingVo.setiTime("");
            bookSellingVo.setiUser("");
            bookSellingVo.setPrTime("");
            bookSellingVo.setPrUser("");
            bookSellingVo.setSellerName("");
            if (bookSelling.getSellerId()!=null&&bookSelling.getSellerId()>0){
                ServiceResult<UserShare> result=new ServiceResult<>(userShareMapper.getUserShareNameById(bookSelling.getSellerId()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookSellingVo.setSellerName(result.getBody().getUserName());
                    bookSellingVo.setSelfStatus(result.getBody().getStatus());
                    bookSellingVo.setPhoneNumber(result.getBody().getPhoneNumber());
                }
            }
            if (bookSelling.getExportUser()!=null&&bookSelling.getExportUser()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(bookSelling.getExportUser()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookSellingVo.seteUser(result.getBody().getUsername());
                }
            }
            if (bookSelling.getcU()!=null&&bookSelling.getcU()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(bookSelling.getcU()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookSellingVo.setcName(result.getBody().getUsername());
                }
            }
            if (bookSelling.getImportUser()!=null&&bookSelling.getImportUser()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(bookSelling.getImportUser()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookSellingVo.setiUser(result.getBody().getUsername());
                }
            }
            if (bookSelling.getPrintUser()!=null&&bookSelling.getPrintUser()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(bookSelling.getPrintUser()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookSellingVo.setPrUser(result.getBody().getUsername());
                }
            }
            if(bookSelling.getStatus()!=null&&bookSelling.getStatus()>0)
            {
                bookSellingVo.setStatusStr(BookStatusEnum.getNameMap().get(bookSelling.getStatus()));
            }
            if(bookSelling.getUploadTime()!=null&&bookSelling.getUploadTime()>0)
            {
                bookSellingVo.setuTime(DateUtils.getDateStringByTimeStamp(bookSelling.getUploadTime(),DateUtils.YMD));
            }
            if(bookSelling.getExportTime()!=null&&bookSelling.getExportTime()>0)
            {
                bookSellingVo.seteTime(DateUtils.getDateStringByTimeStamp(bookSelling.getExportTime(),DateUtils.YMDHMS));
            }
            if(bookSelling.getImportTime()!=null&&bookSelling.getImportTime()>0)
            {
                bookSellingVo.setiTime(DateUtils.getDateStringByTimeStamp(bookSelling.getImportTime(),DateUtils.YMDHMS));
            }
            if(bookSelling.getcT()!=null&&bookSelling.getcT()>0)
            {
                bookSellingVo.setcTime(DateUtils.getDateStringByTimeStamp(bookSelling.getcT(),DateUtils.YMDHMS));
            }
            if(bookSelling.getPrintTime()!=null&&bookSelling.getPrintTime()>0)
            {
                bookSellingVo.setPrTime(DateUtils.getDateStringByTimeStamp(bookSelling.getPrintTime(),DateUtils.YMDHMS));
            }
            if(bookSelling.getDealTime()!=null&&bookSelling.getDealTime()>0)
            {
                bookSellingVo.setdTime(DateUtils.getDateStringByTimeStamp(bookSelling.getDealTime(),DateUtils.YMDHMS));
            }
            return bookSellingVo;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BookSellingVo();
        }
    }

    @Override
    public BookBorrowVo getBookBorrowVo(BookBorrow bookBorrow, BookBorrowVo bookBorrowVo) {
        try {
            bookBorrowVo = JSONObject.parseObject(JSONObject.toJSONString(bookBorrow),BookBorrowVo.class);
            bookBorrowVo.setcName("");
            bookBorrowVo.setcTime("");
            bookBorrowVo.seteTime("");
            bookBorrowVo.seteUser("");
            bookBorrowVo.setiTime("");
            bookBorrowVo.setiUser("");
            bookBorrowVo.setPrTime("");
            bookBorrowVo.setPrUser("");
            bookBorrowVo.setSellerName("");
            bookBorrowVo.setStatusStr("");
            if (bookBorrow.getSellerId()!=null&&bookBorrow.getSellerId()>0){
                ServiceResult<UserShare> result=new ServiceResult<>(userShareMapper.getUserShareNameById(bookBorrow.getSellerId()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookBorrowVo.setSellerName(result.getBody().getUserName());
                    bookBorrowVo.setSelfStatus(result.getBody().getStatus());
                    bookBorrowVo.setPhoneNumber(result.getBody().getPhoneNumber());
                }
            }
            if (bookBorrow.getExportUser()!=null&&bookBorrow.getExportUser()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(bookBorrow.getExportUser()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookBorrowVo.seteUser(result.getBody().getUsername());
                }
            }
            if (bookBorrow.getcU()!=null&&bookBorrow.getcU()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(bookBorrow.getcU()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookBorrowVo.setcName(result.getBody().getUsername());
                }
            }
            if (bookBorrow.getImportUser()!=null&&bookBorrow.getImportUser()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(bookBorrow.getImportUser()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookBorrowVo.setiUser(result.getBody().getUsername());
                }
            }
            if (bookBorrow.getPrintUser()!=null&&bookBorrow.getPrintUser()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(bookBorrow.getPrintUser()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookBorrowVo.setPrUser(result.getBody().getUsername());
                }
            }
            if(bookBorrow.getStatus()!=null&&bookBorrow.getStatus()>0)
            {
                bookBorrowVo.setStatusStr(BookStatusEnum.getNameMap().get(bookBorrow.getStatus()));
            }
            if(bookBorrow.getExportTime()!=null&&bookBorrow.getExportTime()>0)
            {
                bookBorrowVo.seteTime(DateUtils.getDateStringByTimeStamp(bookBorrow.getExportTime(),DateUtils.YMDHMS));
            }
            if(bookBorrow.getImportTime()!=null&&bookBorrow.getImportTime()>0)
            {
                bookBorrowVo.setiTime(DateUtils.getDateStringByTimeStamp(bookBorrow.getImportTime(),DateUtils.YMDHMS));
            }
            if(bookBorrow.getcT()!=null&&bookBorrow.getcT()>0)
            {
                bookBorrowVo.setcTime(DateUtils.getDateStringByTimeStamp(bookBorrow.getcT(),DateUtils.YMDHMS));
            }
            if(bookBorrow.getPrintTime()!=null&&bookBorrow.getPrintTime()>0)
            {
                bookBorrowVo.setPrTime(DateUtils.getDateStringByTimeStamp(bookBorrow.getPrintTime(),DateUtils.YMDHMS));
            }
            if(bookBorrow.getUploadTime()!=null&&bookBorrow.getUploadTime()>0)
            {
                bookBorrowVo.setuTime(DateUtils.getDateStringByTimeStamp(bookBorrow.getUploadTime(),DateUtils.YMD));
            }
            return bookBorrowVo;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BookBorrowVo();
        }
    }

    @Override
    public BookAuctionVo getBookAuctionVo(BookAuction bookAuction, BookAuctionVo bookAuctionVo) {
        try {
            bookAuctionVo = JSONObject.parseObject(JSONObject.toJSONString(bookAuction),BookAuctionVo.class);
            bookAuctionVo.setcName("");
            bookAuctionVo.setcTime("");
            bookAuctionVo.setBuyerName("");
            bookAuctionVo.seteTime("");
            bookAuctionVo.setsTime("");
            bookAuctionVo.setuTime("");
            bookAuctionVo.setSellerName("");
            if (bookAuction.getSellerId()!=null&&bookAuction.getSellerId()>0){
                ServiceResult<UserShare> result=new ServiceResult<>(userShareMapper.getUserShareNameById(bookAuction.getSellerId()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookAuctionVo.setSellerName(result.getBody().getUserName());
                    bookAuctionVo.setSellName(result.getBody().getUserName());
                    bookAuctionVo.setSellPhoneNumber(result.getBody().getPhoneNumber());
                    bookAuctionVo.setPhoneNumber(result.getBody().getPhoneNumber());
                    bookAuctionVo.setSelfStatus(result.getBody().getStatus());
                }
            }

            if (bookAuction.getBuyerId()!=null&&bookAuction.getBuyerId()>0){
                ServiceResult<UserShare> result=new ServiceResult<>(userShareMapper.getUserShareNameById(bookAuction.getSellerId()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookAuctionVo.setBuyerName(result.getBody().getUserName());
                }
            }
            if (bookAuction.getcU()!=null&&bookAuction.getcU()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(bookAuction.getcU()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookAuctionVo.setcName(result.getBody().getUsername());
                }
            }
            if(bookAuction.getStatus()!=null&&bookAuction.getStatus()>0)
            {
                bookAuctionVo.setStatusStr(BookStatusEnum.getNameMap().get(bookAuction.getStatus()));
            }
            if(bookAuction.getcT()!=null&&bookAuction.getcT()>0)
            {
                bookAuctionVo.setcTime(DateUtils.getDateStringByTimeStamp(bookAuction.getcT(),DateUtils.YMDHMS));
            }

            if(bookAuction.getEndTime()!=null&&bookAuction.getEndTime()>0)
            {
                bookAuctionVo.seteTime(DateUtils.getDateStringByTimeStamp(bookAuction.getEndTime(),DateUtils.YMDHMS));
            }

            if(bookAuction.getStartTime()!=null&&bookAuction.getStartTime()>0)
            {
                bookAuctionVo.setsTime(DateUtils.getDateStringByTimeStamp(bookAuction.getStartTime(),DateUtils.YMDHMS));
            }

            if(bookAuction.getUploadTime()!=null&&bookAuction.getUploadTime()>0)
            {
                bookAuctionVo.setuTime(DateUtils.getDateStringByTimeStamp(bookAuction.getUploadTime(),DateUtils.YMDHMS));
            }
            if(bookAuction.getUploadTime()!=null&&bookAuction.getUploadTime()>0)
            {
                bookAuctionVo.setuTime(DateUtils.getDateStringByTimeStamp(bookAuction.getUploadTime(),DateUtils.YMD));
            }
            return bookAuctionVo;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BookAuctionVo();
        }
    }

    @Override
    public BookGiftVo getBookGiftVo(BookGift bookGift, BookGiftVo bookGiftVo) {
        try {
            bookGiftVo = JSONObject.parseObject(JSONObject.toJSONString(bookGift),BookGiftVo.class);
            bookGiftVo.setcName("");
            bookGiftVo.setcTime("");
            bookGiftVo.seteTime("");
            bookGiftVo.seteUser("");
            bookGiftVo.setdTime("");
            bookGiftVo.setiTime("");
            bookGiftVo.setiUser("");
            bookGiftVo.setPrTime("");
            bookGiftVo.setPrUser("");
            bookGiftVo.setSellerName("");
            if (bookGift.getSellerId()!=null&&bookGift.getSellerId()>0){
                ServiceResult<UserShare> result=new ServiceResult<>(userShareMapper.getUserShareNameById(bookGiftVo.getSellerId()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookGiftVo.setSellerName(result.getBody().getUserName());
                    bookGiftVo.setSelfStatus(result.getBody().getStatus());
                    bookGiftVo.setPhoneNumber(result.getBody().getPhoneNumber());
                }
            }
            if (bookGift.getExportUser()!=null&&bookGift.getExportUser()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(bookGift.getExportUser()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookGiftVo.seteUser(result.getBody().getUsername());
                }
            }
            if (bookGift.getcU()!=null&&bookGift.getcU()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(bookGift.getcU()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookGiftVo.setcName(result.getBody().getUsername());
                }
            }
            if (bookGift.getImportUser()!=null&&bookGift.getImportUser()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(bookGift.getImportUser()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookGiftVo.setiUser(result.getBody().getUsername());
                }
            }
            if (bookGift.getPrintUser()!=null&&bookGift.getPrintUser()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(bookGift.getPrintUser()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookGiftVo.setPrUser(result.getBody().getUsername());
                }
            }
            if(bookGift.getStatus()!=null&&bookGift.getStatus()>0)
            {
                bookGiftVo.setStatusStr(BookStatusEnum.getNameMap().get(bookGift.getStatus()));
            }
            if(bookGift.getFlag()!=null&&bookGift.getFlag()>0)
            {
                bookGiftVo.setFlagStr(BookGiftFlagEnum.getNameMap().get(bookGift.getFlag()));
            }
            if(bookGift.getExportTime()!=null&&bookGift.getExportTime()>0)
            {
                bookGiftVo.seteTime(DateUtils.getDateStringByTimeStamp(bookGift.getExportTime(),DateUtils.YMDHMS));
            }
            if(bookGift.getImportTime()!=null&&bookGift.getImportTime()>0)
            {
                bookGiftVo.setiTime(DateUtils.getDateStringByTimeStamp(bookGift.getImportTime(),DateUtils.YMDHMS));
            }
            if(bookGift.getcT()!=null&&bookGift.getcT()>0)
            {
                bookGiftVo.setcTime(DateUtils.getDateStringByTimeStamp(bookGift.getcT(),DateUtils.YMDHMS));
            }
            if(bookGift.getPrintTime()!=null&&bookGift.getPrintTime()>0)
            {
                bookGiftVo.setPrTime(DateUtils.getDateStringByTimeStamp(bookGift.getPrintTime(),DateUtils.YMDHMS));
            }
            if(bookGift.getDealTime()!=null&&bookGift.getDealTime()>0)
            {
                bookGiftVo.setdTime(DateUtils.getDateStringByTimeStamp(bookGift.getDealTime(),DateUtils.YMDHMS));
            }
            if(bookGift.getUploadTime()!=null&&bookGift.getUploadTime()>0)
            {
                bookGiftVo.setuTime(DateUtils.getDateStringByTimeStamp(bookGift.getUploadTime(),DateUtils.YMD));
            }
            return bookGiftVo;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BookGiftVo();
        }
    }

    @Override
    public RecordSellingVo getRecordSellingVo(RecordSelling recordSelling, RecordSellingVo recordSellingVo) {

      try{
          recordSellingVo = JSONObject.parseObject(JSONObject.toJSONString(recordSelling),RecordSellingVo.class);
            recordSellingVo.setBuyerName("");
            recordSellingVo.setcTime("");
            recordSellingVo.setoTime("");
            recordSellingVo.setStatusStr("");
            recordSellingVo.setPhoneNumber(0L);
            if (recordSelling.getBuyer()!=null&&recordSelling.getBuyer()>0){
                ServiceResult<UserShare> result=new ServiceResult<>(userShareMapper.getUserShareNameById(recordSelling.getBuyer()));
                if(result.getSuccess()&&result.getBody()!=null){
                    recordSellingVo.setPhoneNumber(result.getBody().getPhoneNumber());
                    recordSellingVo.setBuyerName(result.getBody().getUserName());
                }
            }
            if(recordSelling.getSellingId()!=null&&recordSelling.getSellingId()>0){
                   ServiceResult<BookSelling> bookSellingVoServiceResult=new ServiceResult<>(bookSellingMapper.selectByPrimaryKey(recordSelling.getSellingId()));
                  if(bookSellingVoServiceResult.getSuccess()&&bookSellingVoServiceResult.getBody()!=null){
                   BookSelling bookSelling1=bookSellingVoServiceResult.getBody();
                    ServiceResult<UserShare> result1=new ServiceResult<>(userShareMapper.getUserShareNameById(bookSelling1.getSellerId()));
                    if(result1.getSuccess()&&result1.getBody()!=null){
                        recordSellingVo.setSellPhoneNumber(result1.getBody().getPhoneNumber());
                        recordSellingVo.setSellName(result1.getBody().getUserName());
                        recordSellingVo.setBookName(bookSelling1.getBookName());
                        recordSellingVo.setPrice(bookSelling1.getPrice()+"");
                    }
                }
            }
            if(recordSelling.getCompleteTime()!=null&&recordSelling.getCompleteTime()>0)
            {
                recordSellingVo.setcTime(DateUtils.getDateStringByTimeStamp(recordSelling.getCompleteTime(),DateUtils.YMDHMS));
            }
            if(recordSelling.getOrderTime()!=null&&recordSelling.getOrderTime()>0)
            {
                recordSellingVo.setoTime(DateUtils.getDateStringByTimeStamp(recordSelling.getOrderTime(),DateUtils.YMDHMS));
            }
            if(recordSelling.getStatus()!=null&&recordSelling.getStatus()>0)
            {
                recordSellingVo.setStatusStr(BookTardeEnum.getNameMap().get(recordSelling.getStatus()));
            }
            return recordSellingVo;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new RecordSellingVo();
        }
    }

    @Override
    public RecordGiftVo getRecordGiftVo(RecordGift recordGift, RecordGiftVo recordGiftVo) {
        try{
            recordGiftVo = JSONObject.parseObject(JSONObject.toJSONString(recordGift),RecordGiftVo.class);
            recordGiftVo.setBuyerName("");
            recordGiftVo.setcTime("");
            recordGiftVo.setoTime("");
            recordGiftVo.setPhoneNumber(0L);
            if (recordGift.getBuyer()!=null&&recordGift.getBuyer()>0){
                ServiceResult<UserShare> result=new ServiceResult<>(userShareMapper.getUserShareNameById(recordGiftVo.getBuyer()));
                if(result.getSuccess()&&result.getBody()!=null){
                    recordGiftVo.setPhoneNumber(result.getBody().getPhoneNumber());
                    recordGiftVo.setBuyerName(result.getBody().getUserName());
                }
            }
            if(recordGift.getSellingId()!=null&&recordGift.getSellingId()>0){
                ServiceResult<BookGift> bookSellingVoServiceResult=new ServiceResult<>(bookGiftMapper.selectByPrimaryKey(recordGift.getSellingId()));
                if(bookSellingVoServiceResult.getSuccess()&&bookSellingVoServiceResult.getBody()!=null){
                    BookGift bookGift1=bookSellingVoServiceResult.getBody();
                    ServiceResult<UserShare> result1=new ServiceResult<>(userShareMapper.getUserShareNameById(bookGift1.getSellerId()));
                    if(result1.getSuccess()&&result1.getBody()!=null){
                        recordGiftVo.setSellPhoneNumber(result1.getBody().getPhoneNumber());
                        recordGiftVo.setSellName(result1.getBody().getUserName());
                        recordGiftVo.setBookName(bookGift1.getBookName());
                    }
                }
            }
            if(recordGift.getCompleteTime()!=null&&recordGift.getCompleteTime()>0)
            {
                recordGiftVo.setcTime(DateUtils.getDateStringByTimeStamp(recordGift.getCompleteTime(),DateUtils.YMDHMS));
            }
            if(recordGift.getOrderTime()!=null&&recordGift.getOrderTime()>0)
            {
                recordGiftVo.setoTime(DateUtils.getDateStringByTimeStamp(recordGift.getOrderTime(),DateUtils.YMDHMS));
            }
            if(recordGift.getStatus()!=null&&recordGift.getStatus()>0)
            {
                recordGiftVo.setStatusStr(BookTardeEnum.getNameMap().get(recordGift.getStatus()));
            }
            return recordGiftVo;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new RecordGiftVo();
        }
    }

    @Override
    public RecordBorrowVo getRecordBorrowVo(RecordBorrow recordBorrow, RecordBorrowVo recordBorrowVo) {
        try{
            recordBorrowVo = JSONObject.parseObject(JSONObject.toJSONString(recordBorrow),RecordBorrowVo.class);
            recordBorrowVo.setUserName("");
            recordBorrowVo.seteTime("");
            recordBorrowVo.setrTime("");
            recordBorrowVo.setsTime("");
            recordBorrowVo.setPhoneNumber(0L);
            if (recordBorrow.getUserId()!=null&&recordBorrow.getUserId()>0){
                ServiceResult<UserShare> result=new ServiceResult<>(userShareMapper.getUserShareNameById(recordBorrowVo.getUserId()));
                if(result.getSuccess()&&result.getBody()!=null){
                    recordBorrowVo.setPhoneNumber(result.getBody().getPhoneNumber());
                    recordBorrowVo.setUserName(result.getBody().getUserName());
                }
            }

            if(recordBorrow.getAuctionId()!=null&&recordBorrow.getAuctionId()>0){
                ServiceResult<BookBorrow> bookSellingVoServiceResult=new ServiceResult<>(bookBorrowMapper.selectByPrimaryKey(recordBorrow.getAuctionId()));
                if(bookSellingVoServiceResult.getSuccess()&&bookSellingVoServiceResult.getBody()!=null){
                    BookBorrow bookBorrow1=bookSellingVoServiceResult.getBody();
                    ServiceResult<UserShare> result1=new ServiceResult<>(userShareMapper.getUserShareNameById(bookBorrow1.getSellerId()));
                    if(result1.getSuccess()&&result1.getBody()!=null){
                        recordBorrowVo.setSellPhoneNumber(result1.getBody().getPhoneNumber());
                        recordBorrowVo.setSellName(result1.getBody().getUserName());
                        recordBorrowVo.setPrice(bookBorrow1.getPrice()+"");
                        recordBorrowVo.setBookName(bookBorrow1.getBookName());

                        recordBorrowVo.setDepositPricer(bookBorrow1.getDepositPrice()+"");
                        recordBorrowVo.setBeyondPrice(bookBorrow1.getBeyondPrice()+"");
                    }


                }
            }
            if(recordBorrow.getStartTime()!=null&&recordBorrow.getStartTime()>0)
            {
                recordBorrowVo.setsTime(DateUtils.getDateStringByTimeStamp(recordBorrow.getStartTime(),DateUtils.YMDHMS));
            }
            if(recordBorrow.getEndTime()!=null&&recordBorrow.getEndTime()>0)
            {
                recordBorrowVo.seteTime(DateUtils.getDateStringByTimeStamp(recordBorrow.getEndTime(),DateUtils.YMDHMS));
            }
            if(recordBorrow.getRealEndTime()!=null&&recordBorrow.getRealEndTime()>0)
            {
                recordBorrowVo.setrTime(DateUtils.getDateStringByTimeStamp(recordBorrow.getRealEndTime(),DateUtils.YMDHMS));
            }

            return recordBorrowVo;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new RecordBorrowVo();
        }
    }

    @Override
    public RecordAuctionVo getRecordAuctionVo(RecordAuction recordAuction, RecordAuctionVo recordAuctionVo) {
        try{
            recordAuctionVo = JSONObject.parseObject(JSONObject.toJSONString(recordAuction),RecordAuctionVo.class);
            recordAuctionVo.setUserName("");
            recordAuctionVo.setaTime("");
            recordAuctionVo.setPhoneNumber(0L);
            if (recordAuction.getUserId()!=null&&recordAuction.getUserId()>0){
                ServiceResult<UserShare> result=new ServiceResult<>(userShareMapper.getUserShareNameById(recordAuctionVo.getUserId()));
                if(result.getSuccess()&&result.getBody()!=null){
                    recordAuctionVo.setPhoneNumber(result.getBody().getPhoneNumber());
                    recordAuctionVo.setUserName(result.getBody().getUserName());
                }
            }
          /*  if(recordAuction.getAuctionId()!=null&&recordAuction.getAuctionId()>0){
                ServiceResult<BookAuction> bookSellingVoServiceResult=new ServiceResult<>(bookAuctionMapper.selectByPrimaryKey(recordAuction.getAuctionId()));
                if(bookSellingVoServiceResult.getSuccess()&&bookSellingVoServiceResult.getBody()!=null){
                    BookAuction bookAuction1=bookSellingVoServiceResult.getBody();
                    ServiceResult<UserShare> result1=new ServiceResult<>(userShareMapper.getUserShareNameById(bookAuction1.getSellerId()));
                    if(result1.getSuccess()&&result1.getBody()!=null){
                        recordAuctionVo.setSellPhoneNumber(result1.getBody().getPhoneNumber());
                        recordAuctionVo.setSellName(result1.getBody().getUserName());
                    }


                }
            }*/
            if(recordAuction.getAuctionTime()!=null&&recordAuction.getAuctionTime()>0)
            {
                recordAuctionVo.setaTime(DateUtils.getDateStringByTimeStamp(recordAuction.getAuctionTime(),DateUtils.YMDHMS));
            }
            return recordAuctionVo;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new RecordAuctionVo();
        }
    }

    @Override
    public BookProfessionalListVo getBookProfessionalListVo(BookProfessionalList bookProfessionalList, BookProfessionalListVo bookProfessionalListVo) {
        try{
            bookProfessionalListVo = JSONObject.parseObject(JSONObject.toJSONString(bookProfessionalList),BookProfessionalListVo.class);
            bookProfessionalListVo.setcName("");
            bookProfessionalListVo.setcTime("");
            bookProfessionalListVo.seteTime("");
            bookProfessionalListVo.seteUser("");
            bookProfessionalListVo.setGradeName("");
            bookProfessionalListVo.setSemesterName("");
            bookProfessionalListVo.setpTime("");
            bookProfessionalListVo.setpUser("");
            bookProfessionalListVo.setiTime("");
            bookProfessionalListVo.setiUser("");

            if (bookProfessionalList.getImportUser()!=null&&bookProfessionalList.getImportUser()>0){
                ServiceResult<UserShare> result=new ServiceResult<>(userShareMapper.getUserShareNameById(bookProfessionalList.getImportUser()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookProfessionalListVo.setiUser(result.getBody().getUserName());
                }
            }if (bookProfessionalList.getExportUser()!=null&&bookProfessionalList.getExportUser()>0){
                ServiceResult<UserShare> result=new ServiceResult<>(userShareMapper.getUserShareNameById(bookProfessionalList.getExportUser()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookProfessionalListVo.seteUser(result.getBody().getUserName());
                }
            }
            if (bookProfessionalList.getcU()!=null&&bookProfessionalList.getcU()>0){
                ServiceResult<UserShare> result=new ServiceResult<>(userShareMapper.getUserShareNameById(bookProfessionalList.getcU()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookProfessionalListVo.setcName(result.getBody().getUserName());
                }
            }
            if (bookProfessionalList.getPrintUser()!=null&&bookProfessionalList.getPrintUser()>0){
                ServiceResult<UserShare> result=new ServiceResult<>(userShareMapper.getUserShareNameById(bookProfessionalList.getPrintUser()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookProfessionalListVo.setpUser(result.getBody().getUserName());
                }
            }
            if(bookProfessionalList.getExportTime()!=null&&bookProfessionalList.getExportTime()>0)
            {
                bookProfessionalListVo.seteTime(DateUtils.getDateStringByTimeStamp(bookProfessionalList.getExportTime(),DateUtils.YMDHMS));
            }
            if(bookProfessionalList.getImportTime()!=null&&bookProfessionalList.getImportTime()>0)
            {
                bookProfessionalListVo.setiTime(DateUtils.getDateStringByTimeStamp(bookProfessionalList.getImportTime(),DateUtils.YMDHMS));
            }
            if(bookProfessionalList.getcT()!=null&&bookProfessionalList.getcT()>0)
            {
                bookProfessionalListVo.setcTime(DateUtils.getDateStringByTimeStamp(bookProfessionalList.getcT(),DateUtils.YMDHMS));
            }
            if(bookProfessionalList.getPrintTime()!=null&&bookProfessionalList.getPrintTime()>0)
            {
                bookProfessionalListVo.setpTime(DateUtils.getDateStringByTimeStamp(bookProfessionalList.getPrintTime(),DateUtils.YMDHMS));
            }
            if(bookProfessionalList.getPrintTime()!=null&&bookProfessionalList.getPrintTime()>0)
            {
                bookProfessionalListVo.setpTime(DateUtils.getDateStringByTimeStamp(bookProfessionalList.getPrintTime(),DateUtils.YMDHMS));
            }
            if(bookProfessionalList.getGrade()!=null&&bookProfessionalList.getGrade()>0)
            {
                bookProfessionalListVo.setGradeName(BookGradeCodeEnum.getNameMap().get(bookProfessionalList.getGrade()));
            } if(bookProfessionalList.getSemester()!=null&&bookProfessionalList.getSemester()>0)
            {
                bookProfessionalListVo.setSemesterName(BookSemesterEnum.getNameMap().get(bookProfessionalList.getSemester()));
            }
            return bookProfessionalListVo;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BookProfessionalListVo();
        }
    }

    @Override
    public BookGiftRecVo getBookGiftRecVo(BookGiftRec bookGiftRec, BookGiftRecVo bookGiftRecVo) {
        try{
            bookGiftRecVo = JSONObject.parseObject(JSONObject.toJSONString(bookGiftRec),BookGiftRecVo.class);
            bookGiftRecVo.setSellerName("");
            bookGiftRecVo.setBookName("");
            bookGiftRecVo.setcTime("");
            bookGiftRecVo.setgTime("");
            bookGiftRecVo.setcName("");
            bookGiftRecVo.setPhoneNumber(0L);
            if (bookGiftRec.getGiftId()!=null&&bookGiftRec.getGiftId()>0){
                ServiceResult<BookGift> bookGiftServiceResult=new ServiceResult<>(bookGiftMapper.selectByPrimaryKey(bookGiftRec.getGiftId()));
                if(bookGiftServiceResult.getSuccess()&&bookGiftServiceResult.getBody()!=null) {
                    BookGift bookGift=bookGiftServiceResult.getBody();
                    bookGiftRecVo.setBookName(bookGift.getBookName());
                    ServiceResult<UserShare> result=new ServiceResult<>(userShareMapper.getUserShareNameById(bookGift.getSellerId()));
                    if(result.getSuccess()&&result.getBody()!=null){
                        bookGiftRecVo.setPhoneNumber(result.getBody().getPhoneNumber());
                        bookGiftRecVo.setSellerName(result.getBody().getUserName());
                    }
                }
            }
            if(bookGiftRec.getCu()!=null&&bookGiftRec.getCu()>0)
            {
                ServiceResult<UserShare> result=new ServiceResult<>(userShareMapper.getUserShareNameById(bookGiftRec.getCu()));
                if(result.getSuccess()&&result.getBody()!=null){
                    bookGiftRecVo.setcName(result.getBody().getUserName());
                }
            }
            if(bookGiftRec.getCt()!=null&&bookGiftRec.getCt()>0)
            {
                bookGiftRecVo.setcTime(DateUtils.getDateStringByTimeStamp(bookGiftRec.getCt(),DateUtils.YMDHMS));
            }

            if(bookGiftRec.getGiftTime()!=null&&bookGiftRec.getGiftTime()>0)
            {
                bookGiftRecVo.setgTime(DateUtils.getDateStringByTimeStamp(bookGiftRec.getGiftTime(),DateUtils.YMD));
            }

            return bookGiftRecVo;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new BookGiftRecVo();
        }
    }

    @Override
    public List<Integer> getRecordAuctionIds(RecordAuctionQuery query) {
        return recordAuctionMapper.getRecordAuctionIds(query);
    }

    @Override
    public ServiceResult<Integer> queryBookSellingCount(BookSellingQuery bookSellingQuery) {
        return new ServiceResult<>(bookSellingMapper.queryBookSellingCount(bookSellingQuery));
    }

    @Override
    public ServiceResult<List<BookSellingVo>> queryBookSellingVoList(BookSellingQuery bookSellingQuery) {
        try {
            List<BookSellingVo> bookSellingVos=new ArrayList<>();
            ServiceResult<List<BookSelling>> serviceResult=new ServiceResult<>(bookSellingMapper.queryBookSellingList(bookSellingQuery));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (BookSelling bookSelling:serviceResult.getBody()) {
                    BookSellingVo bookSellingVo= new BookSellingVo();
                    bookSellingVos.add(this.getBookSellingVo(bookSelling,bookSellingVo));
                }
            }
            return new ServiceResult<>(bookSellingVos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<BookSellingVo> selectSellByPrimaryKey(BookSellingQuery bookSellingQuery) {
        try {
            BookSellingVo bookSellingVo =new BookSellingVo();
            ServiceResult<BookSelling> serviceResult=new ServiceResult<>(bookSellingMapper.selectByPrimaryKey(bookSellingQuery.getId()));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                      bookSellingVo= this.getBookSellingVo(serviceResult.getBody(),bookSellingVo);
            }
            return new ServiceResult<>(bookSellingVo) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<BookBorrowVo> selectBorrowByPrimaryKey(BookBorrowQuery bookBorrowQuery) {
        try {
            BookBorrowVo bookBorrowVo =new BookBorrowVo();
            ServiceResult<BookBorrow> serviceResult=new ServiceResult<>(bookBorrowMapper.selectByPrimaryKey(bookBorrowQuery.getId()));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                bookBorrowVo= this.getBookBorrowVo(serviceResult.getBody(),bookBorrowVo);
            }
            return new ServiceResult<>(bookBorrowVo) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<BookGiftVo> selectGiftByPrimaryKey(BookGiftQuery bookGiftQuery) {
        try {
            BookGiftVo bookGiftVo =new BookGiftVo();
            ServiceResult<BookGift> serviceResult=new ServiceResult<>(bookGiftMapper.selectByPrimaryKey(bookGiftQuery.getId()));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                bookGiftVo= this.getBookGiftVo(serviceResult.getBody(),bookGiftVo);
            }
            return new ServiceResult<>(bookGiftVo) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<BookAuctionVo> selectAuctionByPrimaryKey(BookAuctionQuery bookAuctionQuery) {
        try {
            BookAuctionVo bookAuctionVo =new BookAuctionVo();
            ServiceResult<BookAuction> serviceResult=new ServiceResult<>(bookAuctionMapper.selectByPrimaryKey(bookAuctionQuery.getId()));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                bookAuctionVo= this.getBookAuctionVo(serviceResult.getBody(),bookAuctionVo);
            }
            return new ServiceResult<>(bookAuctionVo) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<Integer> queryBookAuctionCount(BookAuctionQuery bookAuctionQuery) {
        return new ServiceResult<>(bookAuctionMapper.queryBookAuctionCount(bookAuctionQuery));
    }

    @Override
    public ServiceResult<List<BookAuctionVo>> queryBookAutionVoList(BookAuctionQuery bookAuctionQuery) {
        try {
            List<BookAuctionVo> bookAuctionVos=new ArrayList<>();
            ServiceResult<List<BookAuction>> serviceResult=new ServiceResult<>(bookAuctionMapper.queryBookAuctionList(bookAuctionQuery));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (BookAuction bookAuction:serviceResult.getBody()) {
                    BookAuctionVo bookAuctionVo= new BookAuctionVo();
                    bookAuctionVos.add(this.getBookAuctionVo(bookAuction,bookAuctionVo));
                }
            }
            return new ServiceResult<>(bookAuctionVos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<Integer> queryBookAuctionCountByIds(BookAuctionQuery bookAuctionQuery) {
        return new ServiceResult<>(bookAuctionMapper.queryBookAuctionCountByIds(bookAuctionQuery));
    }

    @Override
    public ServiceResult<List<BookAuctionVo>> queryBookAutionVoListByIds(BookAuctionQuery bookAuctionQuery) {
        try {
            List<BookAuctionVo> bookAuctionVos=new ArrayList<>();
            ServiceResult<List<BookAuction>> serviceResult=new ServiceResult<>(bookAuctionMapper.queryBookAuctionByIds(bookAuctionQuery));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (BookAuction bookAuction:serviceResult.getBody()) {
                    BookAuctionVo bookAuctionVo= new BookAuctionVo();
                    bookAuctionVos.add(this.getBookAuctionVo(bookAuction,bookAuctionVo));
                }
            }
            return new ServiceResult<>(bookAuctionVos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<Integer> queryBookBorrowCount(BookBorrowQuery bookBorrowQuery) {
        return new ServiceResult<>(bookBorrowMapper.queryBookBorrowCount(bookBorrowQuery));
    }

    @Override
    public ServiceResult<List<BookBorrowVo>> queryBookBorrowVoList(BookBorrowQuery bookBorrowQuery) {
        try {
            List<BookBorrowVo> bookBorrowVos=new ArrayList<>();
            ServiceResult<List<BookBorrow>> serviceResult=new ServiceResult<>(bookBorrowMapper.queryBookBorrowList(bookBorrowQuery));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (BookBorrow bookBorrow:serviceResult.getBody()) {
                    BookBorrowVo bookBorrowVo= new BookBorrowVo();
                    bookBorrowVos.add(this.getBookBorrowVo(bookBorrow,bookBorrowVo));
                }
            }
            return new ServiceResult<>(bookBorrowVos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<Integer> queryBookGiftCount(BookGiftQuery bookGiftQuery) {
        return new ServiceResult<>(bookGiftMapper.queryBookGiftCount(bookGiftQuery));
    }

    @Override
    public ServiceResult<List<BookGiftVo>> queryBookBookGiftVoList(BookGiftQuery bookGiftQuery) {
        try {
            List<BookGiftVo> bookGiftVos=new ArrayList<>();
            ServiceResult<List<BookGift>> serviceResult=new ServiceResult<>(bookGiftMapper.queryBookGiftList(bookGiftQuery));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (BookGift bookGift:serviceResult.getBody()) {
                    BookGiftVo bookGiftVo= new BookGiftVo();
                    bookGiftVos.add(this.getBookGiftVo(bookGift,bookGiftVo));
                }
            }
            return new ServiceResult<>(bookGiftVos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<BookGiftVo> queryBookBookGiftVo(Integer id) {
        try {
            ServiceResult<BookGift> serviceResult=new ServiceResult<>(bookGiftMapper.selectByPrimaryKey(id));
            BookGiftVo bookGiftVo =new BookGiftVo();
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                     bookGiftVo= this.getBookGiftVo(serviceResult.getBody(),bookGiftVo);
            }
            return new ServiceResult<>(bookGiftVo) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<List<RecordSellingVo>> getRecordsellingList(RecordSellingQuery query) {
        try {
            List<RecordSellingVo> recordSellingVos=new ArrayList<>();
            ServiceResult<List<RecordSelling>> serviceResult=new ServiceResult<>(recordSellingMapper.getRecordsellingList(query));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (RecordSelling recordSelling:serviceResult.getBody()) {
                    RecordSellingVo recordSellingVo= new RecordSellingVo();
                    recordSellingVos.add(this.getRecordSellingVo(recordSelling,recordSellingVo));
                }
            }
            return new ServiceResult<>(recordSellingVos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<Integer> getRecordsellingCount(RecordSellingQuery query) {
        return new ServiceResult<>(recordSellingMapper.getRecordsellingCount(query));
    }

    @Override
    public ServiceResult<List<RecordBorrowVo>> getRecordBorrowList(RecordBorrowQuery query) {
        try {
            List<RecordBorrowVo> recordSellingVos=new ArrayList<>();
            ServiceResult<List<RecordBorrow>> serviceResult=new ServiceResult<>(recordBorrowMapper.getRecordBorrowList(query));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (RecordBorrow recordBorrow:serviceResult.getBody()) {
                    RecordBorrowVo recordBorrowVo= new RecordBorrowVo();
                    recordSellingVos.add(this.getRecordBorrowVo(recordBorrow,recordBorrowVo));
                }
            }
            return new ServiceResult<>(recordSellingVos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<Integer> getRecordBorrowCount(RecordBorrowQuery query) {
        return new ServiceResult<>(recordBorrowMapper.getRecordBorrowCount(query));
    }

    @Override
    public ServiceResult<List<RecordGiftVo>> getRecordGiftList(RecordGiftQuery query) {
        try {
            List<RecordGiftVo> recordGiftVos=new ArrayList<>();
            ServiceResult<List<RecordGift>> serviceResult=new ServiceResult<>(recordGiftMapper.getRecordGiftList(query));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (RecordGift recordGift:serviceResult.getBody()) {
                    RecordGiftVo recordGiftVo= new RecordGiftVo();
                    recordGiftVos.add(this.getRecordGiftVo(recordGift,recordGiftVo));
                }
            }
            return new ServiceResult<>(recordGiftVos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<Integer> getRecordGiftCount(RecordGiftQuery query) {
        return new ServiceResult<>(recordGiftMapper.getRecordGiftCount(query));
    }

    @Override
    public ServiceResult<List<RecordAuctionVo>> getRecordAuctionList(RecordAuctionQuery query) {
        try {
            List<RecordAuctionVo> recordAuctionVos=new ArrayList<>();
            ServiceResult<List<RecordAuction>> serviceResult=new ServiceResult<>(recordAuctionMapper.getRecordAuctionList(query));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (RecordAuction recordAuction:serviceResult.getBody()) {
                    RecordAuctionVo recordAuctionVo= new RecordAuctionVo();
                    recordAuctionVos.add(this.getRecordAuctionVo(recordAuction,recordAuctionVo));
                }
            }
            return new ServiceResult<>(recordAuctionVos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<Integer> getRecordAuctionCount(RecordAuctionQuery query) {
        return new ServiceResult<>(recordAuctionMapper.getRecordAuctionCount(query));
    }

    @Override
    public ServiceResult<Integer> updateBookSellingStatus(List<Integer> ids,int status,int userId,int cTime) {
        int count = 0;
        ServiceResult<Integer> serviceResult = new ServiceResult();
        serviceResult.setBody(0);
        for (Integer id : ids) {
            count = count + bookSellingMapper.updateBookSellingStatus(id, status,userId,cTime);
        }
        if (count == ids.size()) {
            serviceResult.setBody(1);
        }

        return serviceResult;
    }
    @Override
    public  ServiceResult<List<BookSelling>> queryBookSellingByIds(List<Integer> ids,int status){
        return new ServiceResult<>(bookSellingMapper.queryBookSellingByIds(ids,status));
    }

    @Override
    public ServiceResult<Integer> updateBookBorrowStatus(List<Integer> ids, int status,int userId,int cTime) {
        int count = 0;
        ServiceResult<Integer> serviceResult = new ServiceResult();
        serviceResult.setBody(0);
        for (Integer id : ids) {
            count = count + bookBorrowMapper.updateBookBorrowStatus(id, status,userId,cTime);
        }
        if (count == ids.size()) {
            serviceResult.setBody(1);
        }

        return serviceResult;
    }

    @Override
    public ServiceResult<Integer> updateBookGiftStatus(List<Integer> ids, int status,int userId,int cTime) {
        int count = 0;
        ServiceResult<Integer> serviceResult = new ServiceResult();
        serviceResult.setBody(0);
        for (Integer id : ids) {
            count = count + bookGiftMapper.updateBookGiftStatus(id, status,userId,cTime);
        }
        if (count == ids.size()) {
            serviceResult.setBody(1);
        }

        return serviceResult;
    }

    @Override
    public ServiceResult<Integer> updateBooAuctionStatus(List<Integer> ids, int status,int userId,int cTime) {
        int count = 0;
        ServiceResult<Integer> serviceResult = new ServiceResult();
        serviceResult.setBody(0);
        for (Integer id : ids) {
            count = count + bookAuctionMapper.updateBookAuctionStatus(id, status,userId,cTime);
        }
        if (count == ids.size()) {
            serviceResult.setBody(1);
        }

        return serviceResult;
    }

    @Override
    public ServiceResult<List<BookProfessionalListVo>> getBookProfessionalList(BookProfessionalListQuery query) {
        try {
            List<BookProfessionalListVo> bookProfessionalListVos=new ArrayList<>();
            ServiceResult<List<BookProfessionalList>> serviceResult=new ServiceResult<>(bookProfessionalListMapper.getBookProfessionalList(query));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (BookProfessionalList bookProfessionalList:serviceResult.getBody()) {
                    BookProfessionalListVo bookProfessionalListVo= new BookProfessionalListVo();
                    bookProfessionalListVos.add(this.getBookProfessionalListVo(bookProfessionalList,bookProfessionalListVo));
                }
            }
            return new ServiceResult<>(bookProfessionalListVos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<Integer> updateBookProfessionalList(BookProfessionalListQuery query) {
        return  new ServiceResult<>(bookProfessionalListMapper.updateBookProfessionalList(query));
    }

    @Override
    public ServiceResult<Integer> deleteBookProfessionalList(BookProfessionalListQuery query) {
        List<Integer> ids=query.getIds();
        int count=bookProfessionalListMapper.deleteBookProfessionalList(query);
        if(count==ids.size()){
            count=1;
        }else {
            count=0;
        }
        return new ServiceResult<>(count);
    }

    @Override
    public ServiceResult<Integer> getBookProfessionalListCount(BookProfessionalListQuery query) {
        return new ServiceResult<>(bookProfessionalListMapper.getBookProfessionalListCount(query));
    }

    @Override
    public ServiceResult<Integer> queryBookGiftRecCount(BookGiftRecQuery query) {
        return new ServiceResult<>(bookGiftRecMapper.getBookGiftRecCount(query));
    }

    @Override
    public ServiceResult<List<BookGiftRecVo>> queryBookGiftRecList(BookGiftRecQuery query) {
        try {
            List<BookGiftRecVo> bookGiftRecVos=new ArrayList<>();
            ServiceResult<List<BookGiftRec>> serviceResult=new ServiceResult<>(bookGiftRecMapper.getBookGiftRecList(query));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (BookGiftRec bookGiftRec:serviceResult.getBody()) {
                    BookGiftRecVo bookGiftRecVo= new BookGiftRecVo();
                    bookGiftRecVos.add(this.getBookGiftRecVo(bookGiftRec,bookGiftRecVo));
                }
            }
            return new ServiceResult<>(bookGiftRecVos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }

    @Override
    public ServiceResult<BookVo> queryBookListTopTen(BookQuery query){
        List<Book> bookList = bookMapper.queryBookListTopTen(query);
        BookVo bookVo=new BookVo();
        bookVo.setList(bookList);
        return new ServiceResult<>(bookVo);
    }
}
