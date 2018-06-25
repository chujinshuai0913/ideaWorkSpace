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
import com.fasterxml.jackson.databind.util.BeanUtil;
import common.constant.ConstantsUtils;
import common.mapper.*;
import common.model.BookAuction;
import common.model.RecordAuction;
import common.query.BookAuctionQuery;
import common.query.RecordAuctionQuery;
import common.service.Impl.BookServiceImpl;
import common.vo.BookAuctionVo;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/6/10
 * @since 1.0.0
 */
  public class AuctionProcessQuartz  {
    private static final Logger logger = Logger.getLogger(BookServiceImpl.class);

    @Autowired
    private  BookAuctionMapper bookAuctionMapper;
    @Autowired
    private RecordAuctionMapper recordAuctionMapper;

    public void AuctionQuartz(){

        List<Integer> statusList=new ArrayList<>();
        statusList.add(ConstantsUtils.BookAuditCode.AUDIT);
        statusList.add(ConstantsUtils.BookAuditCode.AUCTION_START);
        try {
            List<BookAuction> bookAuctions = bookAuctionMapper.selectBookAuctionByStatus(statusList);
            if (bookAuctions.size() > 0) {
                for (BookAuction bookAuction : bookAuctions) {
                    if (bookAuction.getStartTime() <= DateUtils.getNowTimeStamp()&&bookAuction.getEndTime() >= DateUtils.getNowTimeStamp()) {
                        bookAuctionMapper.updateAuctionStatus(bookAuction.getId(), ConstantsUtils.BookAuditCode.AUCTION_START);
                    }
                    if (bookAuction.getEndTime() <= DateUtils.getNowTimeStamp()) {
                        RecordAuctionQuery query = new RecordAuctionQuery();
                        query.setAuctionId(bookAuction.getId());
                        query.setSortName("price");
                        query.setSortOrder("DESC");
                        List<RecordAuction> recordAuctions = recordAuctionMapper.getRecordAuctionList(query);
                        if (recordAuctions.size() > 0) {
                            RecordAuction recordAuction = recordAuctions.get(0);
                            bookAuctionMapper.updateBookAuction(bookAuction.getId(), ConstantsUtils.BookAuditCode.AUCTION_SUCCESS,  recordAuction.getPrice(), recordAuction.getUserId());
                        } else {
                            bookAuctionMapper.updateAuctionStatus(bookAuction.getId(), ConstantsUtils.BookAuditCode.AUCTION_FAIL);
                        }
                    }
                }
            }
        }
        catch (Exception e){
            logger.error(e.getMessage(),e);
        }


    }
}

