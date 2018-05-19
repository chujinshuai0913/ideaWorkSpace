package common.util;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/9 10:26 星期一
 */


//import com.sprucetec.wms.exception.InvalidParamException;
//import com.sprucetec.wms.exception.SystemException;
import common.model.ExcelBean;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletResponse;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelUtil {
    private static Logger log = LoggerFactory.getLogger(ExcelUtil.class);

    public ExcelUtil() {
    }

    public static Map<Integer, List<String[]>> parseExcel(InputStream is, int skipRow) {
        try {
            Map<Integer, List<String[]>> sheetMap = new HashMap();
            Workbook workbook = Workbook.getWorkbook(is);
            Sheet[] sheets = workbook.getSheets();

            for(int i = 0; i < sheets.length; ++i) {
                Sheet sheet = sheets[i];
                List<String[]> rowList = new ArrayList();

                for(int j = Math.max(skipRow, 0); j < sheet.getRows(); ++j) {
                    Cell[] cells = sheet.getRow(j);
                    String[] cellContents = new String[cells.length];

                    for(int k = 0; k < cells.length; ++k) {
                        cellContents[k] = cells[k].getContents();
                    }

                    rowList.add(cellContents);
                }

                sheetMap.put(i, rowList);
            }

            return sheetMap;
        } catch (Exception var12) {
            log.error("", var12);
            return null;
        }
    }

    public static <T> void exportExcel(Class<T> clazz, List<T> data, List<ExcelBean> excelBeanList, OutputStream os) {
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(os);
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            int index = 0;
            Iterator var7 = excelBeanList.iterator();

            while(var7.hasNext()) {
                ExcelBean bean = (ExcelBean)var7.next();
                Label label = new Label(index++, 0, bean.getShowName());
                sheet.addCell(label);
            }

            Map<String, Method> fieldReadMethodMap = getFieldReadMethodMap(clazz);

            label52:
            for(int i = 0; i < data.size(); ++i) {
                index = 0;
                Iterator var20 = excelBeanList.iterator();

                while(true) {
                    while(true) {
                        if (!var20.hasNext()) {
                            continue label52;
                        }

                        ExcelBean bean = (ExcelBean)var20.next();
                        String property = bean.getProperty();
                        Method readMethod = (Method)fieldReadMethodMap.get(property);
                        if (readMethod == null) {
                            //throw new InvalidParamException("属性" + property + "在" + clazz.getName() + "类中没有getter方法");
                        }

                        readMethod.setAccessible(true);
                        Object value = readMethod.invoke(data.get(i));
                        Label label;
                        if (value == null) {
                            label = new Label(index++, i + 1, "");
                            sheet.addCell(label);
                        } else if (!(value instanceof Integer) && !(value instanceof Long)) {
                            if (value instanceof Number) {
                                jxl.write.Number number = new jxl.write.Number(index++, i + 1, ((Number)value).doubleValue());
                                sheet.addCell(number);
                            } else if (value instanceof Date) {
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                String dateStr = sdf.format((Date)value);
                                sheet.addCell(new Label(index++, i + 1, dateStr));
                            } else {
                                label = new Label(index++, i + 1, value.toString());
                                sheet.addCell(label);
                            }
                        } else {
                            label = new Label(index++, i + 1, String.valueOf(value));
                            sheet.addCell(label);
                        }
                    }
                }
            }

            workbook.write();
            workbook.close();
        } catch (Exception var17) {
            log.error("", var17);
        }

    }

    private static <T> Map<String, Method> getFieldReadMethodMap(Class<T> clazz) throws IntrospectionException {
        Map<String, Method> fieldReadMethodMap = new HashMap();
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
        PropertyDescriptor[] proDescrtptors = beanInfo.getPropertyDescriptors();
        if (proDescrtptors != null && proDescrtptors.length > 0) {
            PropertyDescriptor[] var4 = proDescrtptors;
            int var5 = proDescrtptors.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                PropertyDescriptor pd = var4[var6];
                fieldReadMethodMap.put(pd.getName(), pd.getReadMethod());
            }
        }

        return fieldReadMethodMap;
    }

    public static <T> void parsingAndExport(HttpServletResponse response, String excelName, String titleInfo, Map<String, String> mapExcelBean, List<T> dataList, Class<T> clazz) {
        List<ExcelBean> list = new ArrayList();
        Iterator i = mapExcelBean.entrySet().iterator();

        while(i.hasNext()) {
            Entry<String, String> e = (Entry)i.next();
            list.add(new ExcelBean((String)e.getKey(), (String)e.getValue()));
        }

        try {
            response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(excelName, "utf-8") + DateUtils.formatDate(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss") + ".xls");
            response.setContentType("application/msexcel");
            exportExcel(clazz, dataList, list, response.getOutputStream());
        } catch (IOException var9) {
           // throw new SystemException("服务端异常，请重试。");
        }
    }

    public static <T> void parsingAndExport(HttpServletResponse response, String excelName, String titleInfo, List<ExcelBean> listExcelBean, List<T> dataList, Class<T> clazz) {
        try {
            response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(excelName, "utf-8") + DateUtils.formatDate(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss") + ".xls");
            response.setContentType("application/msexcel");
            exportExcel(clazz, dataList, listExcelBean, response.getOutputStream());
        } catch (IOException var7) {
           // throw new SystemException("服务端异常，请重试。");
        }
    }
}
