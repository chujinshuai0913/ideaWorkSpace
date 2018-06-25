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
import common.mapper.BookAuctionMapper;
import common.mapper.RecordAuctionMapper;
import common.mapper.ShareAnnouncementMapper;
import common.model.BookAuction;
import common.model.RecordAuction;
import common.model.ShareAnnouncement;
import common.query.RecordAuctionQuery;
import common.query.ShareAnnouncementQuery;
import common.service.Impl.BookServiceImpl;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
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
  public class UploadImgQuartz extends QuartzJobBean {
    private static final Logger logger = Logger.getLogger(BookServiceImpl.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ApplicationContext context = new FileSystemXmlApplicationContext( new String []{"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"});
        ShareAnnouncementMapper shareAnnouncementMapper=context.getBean(ShareAnnouncementMapper.class);
        try {
            ShareAnnouncementQuery shareAnnouncementQuery=new ShareAnnouncementQuery();
            shareAnnouncementQuery.setStatus(2);
            shareAnnouncementQuery.setUploadTime(DateUtils.getNowTimeStamp());
            List<ShareAnnouncement> shareAnnouncements = shareAnnouncementMapper.getShareAnnouncementList(shareAnnouncementQuery);
        }
        catch (Exception e){
            logger.error(e.getMessage(),e);
        }


    }
}

