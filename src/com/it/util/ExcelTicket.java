package com.it.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.it.dto.TicketDto;

/**
 * 解析Excel文件
 * @author hht
 * @date 2017年9月10日
 */
public class ExcelTicket
{
	private final Log logger = LogFactory.getLog(this.getClass());
	
    /**
     * 载入和解析excel文件
     * @param excelPath 文件路径
     * @return
     */
    public List loadAndAnalysisExcel(String excelPath)
    {	
    	List excelModels = new ArrayList();
    	
    	InputStream is = null;
        Workbook workbook = null;
    	
    	if (excelPath == null || ExcelCommon.EMPTY.equals(excelPath)) 
            return null;
        else 
        {
            String postfix = getPostfix(excelPath);
            if (!ExcelCommon.EMPTY.equals(postfix)) 
            {
            	try
            	{
            		is = new FileInputStream(excelPath);
            		if (ExcelCommon.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) 
            		{
                    	workbook = new HSSFWorkbook(is);
            		}
                    else if (ExcelCommon.OFFICE_EXCEL_2010_POSTFIX.equals(postfix))
                    {
                    	workbook = new XSSFWorkbook(is);
                    }
                    else if (ExcelCommon.OFFICE_EXCEL_CSV_POSTFIX.equals(postfix)) 
                    {   
                    	try {
							excelPath = new CSVToExcel().Converter(excelPath);
							is = new FileInputStream(excelPath);
							workbook = new HSSFWorkbook(is);
						} catch (Exception e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
//                    	throw new RuntimeException(String.format("文件[%s]不是Excel文件！", excelPath));
                    }
                    logger.info("载入excel文件：" + excelPath + " 完成！");
            	}catch(IOException e)
            	{
            		throw new RuntimeException(String.format("载入解析[%s] 文件出错！", excelPath));
            	}
            	
            } else 
            {
            	throw new RuntimeException(String.format("文件[%s]不是Excel文件！", excelPath));
            }
        }
        // Read the Sheet
        for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) 
        {
        	if(numSheet == 0){
        		 Sheet sheet = workbook.getSheetAt(numSheet);
                 if (sheet == null) {
                     continue;
                 }
                 	 // Read the Row
//                 System.out.println("----------------->"+sheet.getLastRowNum());
                     for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) 
                     {
                         Row row = sheet.getRow(rowNum);
                         if (row != null) 
                         {
                         	TicketDto excelModel = new TicketDto();
                         	
                         	Cell ticketNumber = row.getCell(1);
                         	System.out.println(ticketNumber);
                         	Cell period = row.getCell(3);
                             
                         	if(ticketNumber != null){
                         		excelModel.setTicketNumber(getValue(ticketNumber));
                         		excelModel.setPeriod(getValue(period));
                              excelModels.add(excelModel);
                         	}
                         }
                     }
        	}
           
        }
        logger.info("解析excel文件完成！");

        return excelModels;
    }

    
    private String getValue(Cell row) 
    {
    	if (null == row)
    		return null;
    	
        if (row.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(row.getBooleanCellValue());
        }else if (row.getCellType() == Cell.CELL_TYPE_NUMERIC){
        	DecimalFormat format = new DecimalFormat("#.##");
        	format.format(row.getNumericCellValue());
        	return format.format(row.getNumericCellValue());
        } 
        else {
            return row.getStringCellValue();
        }
    }
    
    /**
     * 取得文件后缀
     * @param path
     * @return
     */
    public static String getPostfix(String path) 
    {
        if (path == null || ExcelCommon.EMPTY.equals(path.trim())) 
            return ExcelCommon.EMPTY;
        
        if (path.contains(ExcelCommon.POINT)) 
            return path.substring(path.lastIndexOf(ExcelCommon.POINT) + 1, path.length());
        
        return ExcelCommon.EMPTY;
    }
}
