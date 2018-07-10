package com.down;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.sql.RowSet;

import com.down.imp.LotteryInfo;
import com.it.DBHepler.*;
import com.down.excel.ExportExcel;

public class WYCP {
	
	
	public static void main(String[] args) throws Exception {
		new WYCP().select();
	}
	
	
	
	public  void  select() throws Exception{
		Map<String,LotteryInfo> upK3 = new HashMap<String,LotteryInfo>();
		Map<String,LotteryInfo> downK3 = new HashMap<String,LotteryInfo>();
		List<LotteryInfo>	list = new ArrayList<LotteryInfo>();
		upK3 = getUpList();
		downK3 = getDownList();
		
		for(Entry<String, LotteryInfo>entry:upK3.entrySet())
		{
			LotteryInfo info = entry.getValue();
			
			String ticketId = entry.getKey();
			if(downK3.get(ticketId)!=null)
			{
				info.setAnteCode(downK3.get(ticketId).getAnteCode());
				info.setPlayType(downK3.get(ticketId).getPlayType());
				info.setAmount(downK3.get(ticketId).getAmount());
				info.setTicketMoney(downK3.get(ticketId).getTicketMoney());
			}			
			list.add(info);
		}	
		
		
		String today = DateUtils.getNow("yyyyMMdd");
//		String fileName = "D://TicketCheck//" + today + "查票.xls";
//		try {
//			File file =new File("D://TicketCheck");  
		String fileName = "D://样票抽查//" + today + "查票.xlsx";
		try {
			File file =new File("D://样票抽查");    
			//如果文件夹不存在则创建    
			if  (!file .exists()  && !file .isDirectory())      
			{       
			    file .mkdir();    
			} else   {  
//				logger.info("目录存在");  
			}  
			
			new ExportExcel("", LotteryInfo.class).setDataList(list).writeFile(fileName).dispose();
//			HttpServletResponse response = null;
//			new ExportExcel("", LotteryInfo.class).setDataList(list).write(response,fileName).dispose();
			System.out.println("数据生成成功");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据生成失败，请重试！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	public static List<String> getTicketId()
	{
		List<String> list = new ArrayList<String>();
		String sql = "select ticketnumber from  lottery";
		RowSet rs = DBUtilMysql.execQuery(sql.toString());
		try     {
			while (rs != null && rs.next()) {
				String ticketId = rs.getString(1);
				Pattern p = Pattern.compile("[^0-9]");
				Matcher ticketNumber = p.matcher(ticketId);
				System.out.println(ticketNumber.replaceAll(""));
				list.add(ticketNumber.replaceAll(""));
			} // 显示数据
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 创建连接对象
		return list;
	}
	
	
	public  Map<String,LotteryInfo> getUpList() throws FileNotFoundException
	{
		Map<String, LotteryInfo> map = new HashMap<String, LotteryInfo>();
		int n = 0;
		String time="";
		String date="";
		List<String> list = getTicketId();
			for (int i = 0; i < list.size(); i++) 
			{
				n++;
				time=String.valueOf(list.get(i));
//				System.out.println(list.get(i));
				date = time.substring(13,19);
				
			String sql = "SELECT * FROM "
			+ "up_lottery_request_hb_k3_" + date + " WHERE "
			+ "TicketId = '"+list.get(i)+"'";// sql语句 	---up
			
			RowSet rs = DBUpMysql.execQuery(sql.toString());
			try     {
				
				while (rs != null && rs.next()) {
					LotteryInfo lottery = new LotteryInfo();
					lottery.setTicketId(rs.getString(3));
					lottery.setTicketCode(rs.getString(4));
					lottery.setGameName(rs.getString(5));
					lottery.setTermCode(rs.getString(6));
					lottery.setStationId(rs.getString(7));
					lottery.setUserName(rs.getString(11));
					lottery.setSex(rs.getString(12));
					lottery.setCardNumber(rs.getString(16));
					lottery.setMobile(rs.getString(17));
					lottery.setDealTime(rs.getString(20));
					
					map.put(lottery.getTicketId(), lottery);
					
					String TicketId	 = rs.getString(3);
					String TicketSN	 = rs.getString(4);
					String GameName	 = rs.getString(5);
					String TermCode	 = rs.getString(6);
					String StationID = rs.getString(7);
					String UserName	 = rs.getString(11);
					String Sex	= rs.getString(12);
					String IDCode= rs.getString(16);
					String PhoneNumber	= rs.getString(17);
					String SellTime	= rs.getString(20);
					System.out.println(TicketId+"\t"+0+"\t"+0+"\t"+0+"\t"+0+"\t"+TermCode+"\t"+PhoneNumber+"\t"+TicketSN+"\t"+StationID+"\t"+UserName+"\t"+Sex+"\t"+IDCode+"\t"+GameName+"\t"+0+"\t"+0+"\t"+0+"\t"+SellTime);

				} // 显示数据
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 创建连接对象
		}
			return map;
	}
	
	
	
	public Map<String,LotteryInfo> getDownList() throws FileNotFoundException
	{
		Map<String, LotteryInfo> map = new HashMap<String, LotteryInfo>();
		int n = 0;
		String time="";
		String date="";
		List<String> list = getTicketId();
			for (int i = 0; i < list.size(); i++) 
			{
				n++;
				time=String.valueOf(list.get(i));
//				System.out.println(list.get(i));
				date = time.substring(13,19);
				
				String sql = "SELECT AnteCode, PlayType,"
						+ "TicketAmount,TicketMoney,TicketId FROM "
						+ "down_lottery_request_k3_"+date+" WHERE "
						+ "TicketId = '"+list.get(i)+"'";// sql语句   ---down
				
				RowSet rs = DBDownMysql.execQuery(sql.toString());
			try     {
				while (rs != null && rs.next()) {
					LotteryInfo lottery = new LotteryInfo();
					lottery.setAnteCode(rs.getString(1));
					lottery.setPlayType(rs.getString(2));
					lottery.setAmount(rs.getString(3));
					lottery.setTicketMoney(rs.getString(4));
					lottery.setTicketId(rs.getString(5));
					map.put(lottery.getTicketId(), lottery);

					String antCode = rs.getString(1);
					String type = rs.getString(2);
					String amount = rs.getString(3);
					String money = rs.getString(4);
					System.out.println(antCode+"\t"+type+"\t"+amount+"\t"+money);
				} // 显示数据
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 创建连接对象
		}
			return map;
	}
	
}
