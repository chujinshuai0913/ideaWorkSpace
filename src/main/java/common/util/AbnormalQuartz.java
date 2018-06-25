/**
 * Copyright (C), 2018-2018
 * FileName: AuctionProcessQuartz
 * Author:   jinshuai
 * Date:     2018/6/10 14:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.util;

import common.constant.ConstantsUtils;
import common.mapper.BookGiftMapper;
import common.mapper.BookGiftRecMapper;
import common.mapper.RecordGiftMapper;
import common.model.BookGift;
import common.model.BookGiftRec;
import common.query.BookGiftQuery;
import common.query.BookQuery;
import common.query.RecordGiftQuery;
import common.service.Impl.BookServiceImpl;
import common.service.UserService;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/6/10
 * @since 1.0.0
 */
  public class AbnormalQuartz  {
    private static final Logger logger = Logger.getLogger(BookServiceImpl.class);

   @Autowired
   private UserService userService;
    @Autowired
    private  BookGiftMapper bookGiftMapper;
    @Autowired
    private  BookGiftRecMapper bookGiftRecMapper;
    @Autowired
    private RecordGiftMapper recordGiftMapper;


    public void AbnormalAndRec(){
        try {
            userService.insertAbnormal();
            List<Integer> ids=new ArrayList<>();
            /*回收书籍*/
            /*查询展示了一周的书籍*/
            /*加入回收书籍*/
            List<BookGift> list=bookGiftMapper.getBookGiftList();
            if(list.size()>0){
                for(BookGift bookGift:list){
                    BookGiftRec bookGiftRec=new BookGiftRec();
                    bookGiftRec.setGiftId(bookGift.getId());
                    bookGiftRec.setGiftTime(DateUtils.getNowTimeStamp());
                    bookGiftRec.setNum(bookGift.getUseableNum());
                    bookGiftRecMapper.insertSelective(bookGiftRec);
                    ids.add(bookGift.getId());
                    RecordGiftQuery recordGiftQuery=new RecordGiftQuery();
                    recordGiftQuery.setBuyer(0);
                    recordGiftQuery.setTotal(bookGift.getUseableNum());
                    recordGiftQuery.setSellingId(bookGift.getSellerId());
                    recordGiftQuery.setCompleteTime(DateUtils.getNowTimeStamp());
                    recordGiftQuery.setOrderTime(DateUtils.getNowTimeStamp());
                    recordGiftQuery.setStatus(ConstantsUtils.BookTradeCode.TRADE);
                    recordGiftMapper.insertSelective(recordGiftQuery);
                    BookGiftQuery bookGiftQuery=new BookGiftQuery();
                    bookGiftQuery.setId(bookGift.getId());
                    bookGiftQuery.setPreNum(bookGift.getUseableNum());
                    bookGiftQuery.setFlag(1);
                    bookGiftMapper.upateBookGiftUserNumRed(bookGiftQuery);
                }
             }
        }
        catch (Exception e){
            logger.error(e.getMessage(),e);
        }


    }
}

