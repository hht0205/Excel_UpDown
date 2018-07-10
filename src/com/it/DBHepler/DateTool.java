package com.it.DBHepler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
	/**    
	 * 时锟斤拷丶锟�
	 * @author锟斤拷RIK 
	 * @since锟斤拷2012-7-13 锟斤拷锟斤拷09:20:46 
	 * @version:   
	 */ 
	@SuppressWarnings({"unused","unchecked","deprecation"})
	public class DateTool {
		private static ThreadLocal fmt = new ThreadLocal() {  
	        protected synchronized Object initialValue() {  
	            return new SimpleDateFormat("yyyy-MM-dd");  
	        }  
	    };  
		
	    private static ThreadLocal fmt2 = new ThreadLocal() {  
	        protected synchronized Object initialValue() {  
	            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	        }  
	    };  
	    
	    private static ThreadLocal fmt3 = new ThreadLocal() {  
	        protected synchronized Object initialValue() {  
	            return new SimpleDateFormat("yyyyMMddHHmmss");  
	        }  
	    };  
	    
	    private static ThreadLocal fmt4 = new ThreadLocal() {  
	        protected synchronized Object initialValue() {  
	            return new SimpleDateFormat("HH:mm:ss");  
	        }  
	    };  
	    
	    private static ThreadLocal fmt5 = new ThreadLocal() {  
	        protected synchronized Object initialValue() {  
	            return new SimpleDateFormat("yyyyMMdd");  
	        }  
	    };  
	    

	    private static ThreadLocal fmt6 = new ThreadLocal() {  
	        protected synchronized Object initialValue() {  
	            return new SimpleDateFormat("HHmmsssss");  
	        }  
	    };  
	    
	    private static ThreadLocal fmt7 = new ThreadLocal() {  
	        protected synchronized Object initialValue() {  
	            return new SimpleDateFormat("yyyyMM");  
	        }  
	    }; 
	    
		private static ThreadLocal fmt8 = new ThreadLocal() {  
	        protected synchronized Object initialValue() {  
	            return new SimpleDateFormat("yyyy锟斤拷MM锟斤拷dd锟斤拷");  
	        }  
	    };  
	    
	    private static ThreadLocal fmt9 = new ThreadLocal() {  
	        protected synchronized Object initialValue() {  
	            return new SimpleDateFormat("yy");  
	        }  
	    };  
	    private static ThreadLocal fmt10 = new ThreadLocal() {  
	        protected synchronized Object initialValue() {  
	            return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
	        }  
	    };  
		/**    
		 * yyyy-MM-dd
		 * @return    
		*/
		public static String getToday() {
			Date dt = new java.util.Date();
			DateFormat sdf = (DateFormat) fmt.get();
			return sdf.format(dt);
		}
		
		/**    
		 * yyyy-MM-dd
		 * @param dt
		 * @return    
		*/
		public static String parseDate(Date dt) {
			DateFormat sdf = (DateFormat) fmt.get();
			return sdf.format(dt);
		}

		/**    
		 * yyyy-MM-dd HH:mm:ss
		 * @param dt
		 * @return    
		*/
		public static String parseDate2(Date dt) {
			DateFormat sdf = (DateFormat) fmt2.get();
			return sdf.format(dt);
		}

		/**    
		 * yyyyMMddHHmmss
		 * @param dt
		 * @return    
		*/
		public static String parseDate3(Date dt) {
			DateFormat sdf = (DateFormat) fmt3.get();
			return sdf.format(dt);
		}

		/**   
		 * HH:mm:ss
		 * @param dt
		 * @return    
		*/
		public static String parseDate4(Date dt) {
			DateFormat sdf = (DateFormat) fmt4.get();
			return sdf.format(dt);
		}
		
		/**    
		 * yyyyMMdd
		 * @param dt
		 * @return    
		*/
		public static String parseDate5(Date dt) {
			DateFormat sdf = (DateFormat) fmt5.get();
			return sdf.format(dt);
		}

		/**    
		 * HHmmsssss
		 * @param dt
		 * @return    
		*/
		public static String parseDate6(Date dt) {
			DateFormat sdf = (DateFormat) fmt6.get();
			return sdf.format(dt);
		}
		
		/**    
		 * yyyyMM
		 * @param dt
		 * @return    
		*/
		public static String parseDate7(Date dt) {
			DateFormat sdf = (DateFormat) fmt7.get();
			return sdf.format(dt);
		}
		

		/**  
		 * yyyy锟斤拷MM锟斤拷dd锟斤拷  
		 * @param dt
		 * @return    
		*/
		public static String parseDate8(Date dt) {
			DateFormat sdf = (DateFormat) fmt8.get();
			return sdf.format(dt);
		}
		
		/**  
		 * yy锟斤拷
		 * @param dt
		 * @return    
		*/
		public static String parseDate9(Date dt) {
			DateFormat sdf = (DateFormat) fmt9.get();
			return sdf.format(dt);
		}

		/**    
		 * yyyy-MM-dd
		 * @param ds
		 * @return
		 * @throws ParseException    
		*/
		public static Date strintToDate(String ds) throws ParseException {
			DateFormat sdf = (DateFormat) fmt.get();
			Date d = sdf.parse(ds);
			return d;
		}
		
		/**    
		 * yyyy-MM-dd HH:mm:ss
		 * @param ds
		 * @return
		 * @throws ParseException    
		*/
		public static Date strintToDate2(String ds) throws ParseException {
			DateFormat sdf = (DateFormat) fmt2.get();
			Date d = sdf.parse(ds);
			return d;
		}

		/**    
		 * yyyyMMddHHmmss
		 * @param ds
		 * @return
		 * @throws ParseException    
		*/
		public static Date strintToDate3(String ds) throws ParseException {
			DateFormat sdf = (DateFormat) fmt3.get();
			Date d = sdf.parse(ds);
			return d;
		}
		
		/**    
		 * HH:mm:ss
		 * @param ds
		 * @return
		 * @throws ParseException    
		*/
		public static Date strintToDate4(String ds) throws ParseException {
			DateFormat sdf = (DateFormat) fmt4.get();
			Date d = sdf.parse(ds);
			return d;
		}
		
		/**    
		 * yyyyMMdd
		 * @param ds
		 * @return
		 * @throws ParseException    
		*/
		public static Date strintToDate5(String ds) throws ParseException {
			DateFormat sdf = (DateFormat) fmt5.get();
			Date d = sdf.parse(ds);
			return d;
		}

		/**    
		 * HHmmsssss
		 * @param ds
		 * @return
		 * @throws ParseException    
		*/
		public static Date strintToDate6(String ds) throws ParseException {
			DateFormat sdf = (DateFormat) fmt6.get();
			Date d = sdf.parse(ds);
			return d;
		}
		
		/**    
		 * yyyyMM
		 * @param ds
		 * @return
		 * @throws ParseException    
		*/
		public static Date strintToDate7(String ds) throws ParseException {
			DateFormat sdf = (DateFormat) fmt7.get();
			Date d = sdf.parse(ds);
			return d;
		}
		
		public static Date strintToDate10(String ds) throws ParseException {
			DateFormat sdf = (DateFormat) fmt10.get();
			Date d = sdf.parse(ds);
			return d;
		}
		
		
		/**
		 * 锟斤拷锟斤拷锟街凤拷锟斤拷锟铰革拷式锟斤拷
		 * @param ds
		 * @param format
		 * @return
		 * @throws ParseException
		 */
		public static String strSwapFormat(String ds,String oldFormat,String newFormat) throws ParseException {
			SimpleDateFormat osdf = new java.text.SimpleDateFormat(oldFormat);
			Date d = osdf.parse(ds);
			SimpleDateFormat nsdf = new java.text.SimpleDateFormat(newFormat);
			return nsdf.format(d);
		}
		
		/**
		 * 锟斤拷越锟斤拷锟斤拷锟斤拷锟斤拷sAfter锟斤拷锟绞憋拷洌▂yyy-MM-dd锟斤拷
		 * @param d
		 * @param sAfter
		 * @return
		 * @throws ParseException
		 */
		public static Date getSAfterToD(Date d, int sAfter)
				throws ParseException {
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			c.add(Calendar.SECOND, sAfter);
			Date dt = new Date(c.get(Calendar.YEAR) - 1900, c.get(Calendar.MONTH),
					c.get(Calendar.DAY_OF_MONTH),c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),c.get(Calendar.SECOND));
			return dt;
		}

		/**
		 * 锟斤拷越锟斤拷锟斤拷锟斤拷锟斤拷sAfter锟斤拷锟绞憋拷洌▂yyy-MM-dd锟斤拷
		 * @param d
		 * @param sAfter
		 * @return
		 * @throws ParseException
		 */
		public static String getSAfterToS(Date d, int sAfter)
				throws ParseException {
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			c.add(Calendar.SECOND, sAfter);
			Date dt = new Date(c.get(Calendar.YEAR) - 1900, c.get(Calendar.MONTH),
					c.get(Calendar.DAY_OF_MONTH),c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),c.get(Calendar.SECOND));
			return DateTool.parseDate2(dt);
		}
		
		/**
		 * 锟斤拷越锟斤拷锟斤拷锟斤拷锟斤拷dayAfter锟斤拷锟绞憋拷洌▂yyy-MM-dd锟斤拷
		 * @param d
		 * @param dayAfter
		 * @return
		 * @throws ParseException
		 */
		public static String getDayAfter(Date d, int dayAfter)
				throws ParseException {
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			c.add(Calendar.DAY_OF_MONTH, dayAfter);
			Date dt = new Date(c.get(Calendar.YEAR) - 1900, c.get(Calendar.MONTH),
					c.get(Calendar.DAY_OF_MONTH));
			return DateTool.parseDate(dt);
		}

		/**
		 *  锟斤拷越锟斤拷锟斤拷锟斤拷锟斤拷dayAfter锟斤拷锟接碉拷时锟斤拷锟街凤拷yyyy-MM-dd hh:mm:ss锟斤拷
		 * @param d
		 * @param dayAfter
		 * @return
		 * @throws ParseException
		 */
		public static String getminuteAfter(Date d, int dayAfter)
				throws ParseException {
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			c.add(Calendar.MINUTE, dayAfter);
			Date dt = new Date(c.get(Calendar.YEAR) - 1900, c.get(Calendar.MONTH),
					c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.HOUR_OF_DAY), c
							.get(Calendar.MINUTE), c.get(Calendar.SECOND));
			return DateTool.parseDate2(dt);
		}

		/**
		 * 锟斤拷越锟斤拷锟斤拷锟斤拷锟斤拷dayAfter锟斤拷锟接碉拷时锟斤拷
		 * @param d
		 * @param dayAfter
		 * @return
		 * @throws ParseException
		 */
		public static Date getminuteAfters(Date d, int dayAfter)
				throws ParseException {
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			c.add(Calendar.MINUTE, dayAfter);
			Date dt = new Date(c.get(Calendar.YEAR) - 1900, c.get(Calendar.MONTH),
					c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.HOUR_OF_DAY), c
							.get(Calendar.MINUTE), c.get(Calendar.SECOND));
			return dt;
		}

		/**
		 * 锟斤拷越锟斤拷锟斤拷锟斤拷锟斤拷dayAfter锟斤拷锟铰碉拷时锟戒（yyyy-MM-dd锟斤拷
		 * @param d
		 * @param monthAfter
		 * @return
		 */
		public static String getDayAfterMonth(Date d, int monthAfter) {
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			c.add(Calendar.MONTH, monthAfter);
			Date dt = new Date(c.get(Calendar.YEAR) - 1900, c.get(Calendar.MONTH),
					c.get(Calendar.DAY_OF_MONTH));
			return DateTool.parseDate(dt);
		}


		/**
		 * 锟斤拷越锟斤拷锟斤拷锟斤拷锟斤拷dayAfter锟斤拷锟铰碉拷时锟戒（yyyy-MM-dd锟斤拷
		 * @param d
		 * @param monthAfter
		 * @return
		 */
		public static String getDayAfterMonth2(Date d, int monthAfter) {
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			c.add(Calendar.MONTH, monthAfter);
			Date dt = new Date(c.get(Calendar.YEAR) - 1900, c.get(Calendar.MONTH),
					c.get(Calendar.DAY_OF_MONTH));
			return DateTool.parseDate2(dt);
		}

		/**
		 * 锟斤拷越锟斤拷锟斤拷锟斤拷锟斤拷dayAfter锟斤拷锟铰碉拷时锟戒（yyyyMM锟斤拷
		 * @param d
		 * @param monthAfter
		 * @return
		 */
		public static String getDayAfterMonth7(Date d, int monthAfter) {
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			c.add(Calendar.MONTH, monthAfter);
			Date dt = new Date(c.get(Calendar.YEAR) - 1900, c.get(Calendar.MONTH),
					c.get(Calendar.DAY_OF_MONTH));
			return DateTool.parseDate7(dt);
		}
		
		/**
		 * @param d
		 * @return
		 */
		public static String getFirstDayOfMonth(Date d) {
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			c.set(Calendar.DAY_OF_MONTH, 1);
			Date dt = new Date(c.get(Calendar.YEAR) - 1900, c.get(Calendar.MONTH),
					c.get(Calendar.DAY_OF_MONTH));
			return DateTool.parseDate(dt);
		}

		public static int getDay(String d) {
			int day = 1;
			if (d.length() >= 10) {
				day = Integer.parseInt(d.substring(8, 10));
			}
			return day;
		}

		public static int getMonth(String d) {
			int m = 1;
			if (d.length() >= 10) {
				m = Integer.parseInt(d.substring(5, 7));
			}
			return m;
		}

		public static int getYear(String d) {
			int y = 1;
			if (d.length() >= 10) {
				y = Integer.parseInt(d.substring(0, 4));
			}
			return y;
		}
		
		

		// 锟斤拷荽锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟节硷拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
		public static int getDayBetween(Calendar c1, Calendar c2) {
			int iReturn = 0;
			if (c1 != null && c2 != null) {
				iReturn = (int) ((c2.getTimeInMillis() - c1.getTimeInMillis()) / (24 * 60 * 60 * 1000));
			}
			return iReturn;
		}

		// 锟斤拷荽锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟节硷拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
		public static int getYearBetween(Calendar c1, Calendar c2) {
			int iReturn = 0;
			if (c1 != null && c2 != null) {
				iReturn = (int) (getDayBetween(c1, c2) / 365);
			}
			return iReturn;
		}

		/**
		 * 锟斤拷2005-02-5锟斤拷锟斤拷锟斤拷锟斤拷诟锟绞阶拷锟轿狢alendar锟斤拷锟斤拷
		 * 
		 * @param stringTo
		 * @return
		 * @throws ParseException
		 */
		public static Calendar stringToCalendar(String stringTo)
				throws ParseException {
			Calendar c = Calendar.getInstance();
			if (stringTo != null) {
				SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
				Date d = sdf.parse(stringTo);
				c.setTime(d);
			}
			return c;
		}

		public static String getNextMonday(String s) throws ParseException {
			Calendar c = DateTool.stringToCalendar(s);
			return (DateTool.getDayAfter(DateTool.strintToDate(s), 7 - c
					.get(Calendar.DAY_OF_WEEK) + 2));
		}

		public static String getNextSunday(String s) throws ParseException {
			Calendar c = DateTool.stringToCalendar(s);
			return (DateTool.getDayAfter(DateTool.strintToDate(s), 7 - c
					.get(Calendar.DAY_OF_WEEK) + 2 + 7));
		}

		public static String getThisSaturday(String s) throws ParseException {
			Calendar c = DateTool.stringToCalendar(s);
			return (DateTool.getDayAfter(DateTool.strintToDate(s), 7 - c
					.get(Calendar.DAY_OF_WEEK)));
		}

		public static String getWeekOfYear(String s) throws ParseException {
			Calendar c = DateTool.stringToCalendar(s);
			return String.valueOf(c.get(Calendar.WEEK_OF_YEAR));

		}


		// 锟斤拷荽锟斤拷锟斤拷type锟斤拷锟斤拷转锟斤拷锟斤拷锟节ｏ拷type锟斤拷锟斤拷锟斤拷循Date转锟斤拷锟侥癸拷锟斤拷
		public static String getTime(String type) {
			Date dt = new java.util.Date();
			SimpleDateFormat sdf = new java.text.SimpleDateFormat(type);
			return sdf.format(dt);
		}
		
		/**    
		 * yyyy-MM-dd
		 * @return    
		*/
		public static String getNow() {
			Date dt = new java.util.Date();
			DateFormat sdf = (DateFormat) fmt.get();
			return sdf.format(dt);
		}
		
		/**    
		 * yyyy-MM-dd HH:mm:ss
		 * @return    
		*/
		public static String getNow2() {
			Date dt = new java.util.Date();
			DateFormat sdf = (DateFormat) fmt2.get();
			return sdf.format(dt);
		}
		
		/**    
		 * yyyyMMddHHmmss
		 * @return    
		*/
		public static String getNow3() {
			Date dt = new java.util.Date();
			DateFormat sdf = (DateFormat) fmt3.get();
			return sdf.format(dt);
		}

		/**    
		 * HH:mm:ss
		 * @return    
		*/
		public static String getNow4() {
			Date dt = new java.util.Date();
			DateFormat sdf = (DateFormat) fmt4.get();
			return sdf.format(dt);
		}

		/**    
		 * yyyyMMdd
		 * @return    
		*/
		public static String getNow5() {
			Date dt = new java.util.Date();
			DateFormat sdf = (DateFormat) fmt5.get();
			return sdf.format(dt);
		}
		
		/**    
		 * HHmmsssss
		 * @return    
		*/
		public static String getNow6() {
			Date dt = new java.util.Date();
			DateFormat sdf = (DateFormat) fmt6.get();
			return sdf.format(dt);
		}

		/**    
		 * yyyyMM
		 * @return    
		*/
		public static String getNow7() {
			Date dt = new java.util.Date();
			DateFormat sdf = (DateFormat) fmt7.get();
			return sdf.format(dt);
		}
		
		/**    
		 * yyyyMM
		 * @return    
		*/
		public static String getNow9() {
			Date dt = new java.util.Date();
			DateFormat sdf = (DateFormat) fmt9.get();
			return sdf.format(dt);
		}
		public static String getStreamId() {
			// TODO
			String machineName = "000";// Configuration.getGlobalMsg("sys.machineName");//锟斤拷位锟斤拷锟斤拷锟斤拷
			Date dt = new Date();
			String time = DateTool.parseDate6(dt);// 锟斤拷位时锟斤拷HHmmsssss
			String detail = String.valueOf((int) (Math.random() * 9000 + 1000));// 锟斤拷位锟斤拷锟斤拷锟�
			return new StringBuffer().append(machineName).append(time).append(
					detail).toString();
		}
		public static void main(String[] args) throws ParseException {
			//String date= DateTool.getNow3();
			System.out.println(getNow().substring(0,2));
		}

}
