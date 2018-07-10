package com.it.util;

/**
 * 全局声明
 * @author hht
 * @date 2017年9月10日
 */

public class ExcelCommon
{
    public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
    public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";
    public static final String OFFICE_EXCEL_CSV_POSTFIX = "csv";

    public static final String EMPTY = "";
    public static final String POINT = ".";
    
    public static final String ROOT_PATH = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    //服务器上传文件路径
    public static final String SERVER_UPLOAD_DIRECTORY_PATH = ROOT_PATH.substring(0,ROOT_PATH.lastIndexOf("/classes/")) + "/upload";
    //本地工程上传文件路径
    public static final String LOCAL_UPLOAD_DIRECTORY_PATH = "D://TicketCheck//backups";

}
