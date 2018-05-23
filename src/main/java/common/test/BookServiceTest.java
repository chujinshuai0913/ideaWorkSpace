/**
 * Copyright (C), 2018-2018
 * FileName: BookServiceTest
 * Author:   jinshuai
 * Date:     2018/4/9 23:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.test;

import common.constant.ConstantsUtils;
import common.model.TypeBook1;
import common.query.BookQuery;
import common.service.BookService;
import common.service.ClassTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/4/9
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Autowired
    private ClassTypeService classTypeService;

    @Test
    public void queryBookListTest(){
        BookQuery bookQuery=new BookQuery();
        bookQuery.setId(1);
        System.out.print(bookService.queryBookList(bookQuery));
    }
      /*图书分类*/
//    @Test
//    public void queryTypeBook1List (){
//        TypeBook1 typeBook1=new TypeBook1();
//        typeBook1.setId(1);
//        typeBook1.setStatus(ConstantsUtils.TypeBookClass.TYPE_CLASS_STATUS);
//        typeBook1.setSortOrder("id");
//        System.out.print(classTypeService.queryTypeBook1List(typeBook1));
//    }


}
