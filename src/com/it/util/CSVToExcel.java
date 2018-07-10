package com.it.util;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;


public class CSVToExcel {

	public static void main(String args[]) throws Exception
	{
		
		Converter("");
		
	}
	public static  String Converter(String fName) throws Exception
	{
		ArrayList arList=null;
		ArrayList al=null;
		String newFileName = "";
//		fName = "D://360Downloads//GoogleDownloads//check_stake_day_YanCai_20180705.csv";
		String thisLine;
		int count=0;
		FileInputStream fis = new FileInputStream(fName);
		DataInputStream myInput = new DataInputStream(fis);
		int i=0;
		arList = new ArrayList();
		while ((thisLine = myInput.readLine()) != null)
		{
		al = new ArrayList();
		String strar[] = thisLine.split(",");
		for(int j=0;j<strar.length;j++)
		{
		al.add(strar[j]);
		}
		arList.add(al);
		System.out.println();
		i++;
		}

		try
		{
		HSSFWorkbook hwb = new HSSFWorkbook();
		HSSFSheet sheet = hwb.createSheet("new sheet");
		for(int k=0;k<arList.size();k++)
		{
		ArrayList ardata = (ArrayList)arList.get(k);
		HSSFRow row = sheet.createRow((short) 0+k);
		for(int p=0;p<ardata.size();p++)
		{
		HSSFCell cell = row.createCell((short) p);
		String data = ardata.get(p).toString();
		if(data.startsWith("=")){
		cell.setCellType(Cell.CELL_TYPE_STRING);
		data=data.replaceAll("\"", "");
		data=data.replaceAll("=", "");
		cell.setCellValue(data);
		}else if(data.startsWith("\"")){
		data=data.replaceAll("\"", "");
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue(data);
		}else{
		data=data.replaceAll("\"", "");
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		cell.setCellValue(data);
		}
		//*/
		// cell.setCellValue(ardata.get(p).toString());
		}
		System.out.println();
		}
		newFileName = getFileName(fName)+".xls";
		FileOutputStream fileOut = new FileOutputStream(newFileName);
		hwb.write(fileOut);
		fileOut.close();
		System.out.println("Your excel file has been generated");
		
		} catch ( Exception ex ) {
		ex.printStackTrace();
		} //main method ends
		return newFileName;
	}
	
	public static String getFileName(String fileName)
	{
	    String prefix=fileName.substring(fileName.lastIndexOf("."));//如果想获得不带点的后缀，变为fileName.lastIndexOf(".")+1
	    int num=prefix.length();//得到后缀名长度
	    String fileOtherName=fileName.substring(0, fileName.length()-num);//得到文件名。去掉了后缀
	      return fileOtherName;
	}
	
	
}
