package com.down.imp;

import com.down.excel.annotation.ExcelField;


public class LotteryInfo {
	
	private String messengerID;//代理商
	private String packageId;
	private String ticketId;
	private String gameName;
	private String termCode;
	private String playType;
	private String ticketMoney;
	private String amount;//倍数
	private String userName;
	private String cardNumber;
	private String mobile;
	private String anteCode;
	private String dealTime;
	private String stationId;
	private String ticketCode;
	private String backCode;
	private String status;
	private String winMoney;
	private String realName;
	private int isBombBonus;
	private int bonuLevel;
	private String levelBonusMoney;
	private int winNumber;
	private String sex; //性别
	
	private String printTime;
	private String printStatus;
	private String callStatus;
	
//	@ExcelField(title="代理商", align=2, sort=28)
	public String getMessengerID() {
		return messengerID;
	}
	public void setMessengerID(String messengerID) {
		this.messengerID = messengerID;
	}
//	@ExcelField(title="批次号", align=10, sort=4)
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	@ExcelField(title="票号", align=10, sort=1)
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	@ExcelField(title="彩种", align=2, sort=13)
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	@ExcelField(title="期次", align=2, sort=6)
	public String getTermCode() {
		return termCode;
	}
	public void setTermCode(String termCode) {
		this.termCode = termCode;
	}
	@ExcelField(title="玩法", align=2, sort=3)
	public String getPlayType() {
		return playType;
	}
	public void setPlayType(String playType) {
		this.playType = playType;
	}
	@ExcelField(title="票面金额", align=2, sort=5)
	public String getTicketMoney() {
		return ticketMoney;
	}
	public void setTicketMoney(String ticketMoney) {
		this.ticketMoney = ticketMoney;
	}
	@ExcelField(title="投注倍数", align=2, sort=4)
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@ExcelField(title="姓名", align=2, sort=10)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@ExcelField(title="身份证号", align=2, sort=12)
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	@ExcelField(title="电话", align=2, sort=7)
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@ExcelField(title="注码", align=2, sort=2)
	public String getAnteCode() {
		return anteCode;
	}
	public void setAnteCode(String anteCode) {
		this.anteCode = anteCode;
	}
	@ExcelField(title="处理时间", align=2, sort=17)
	public String getDealTime() {
		return dealTime;
	}
	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
	@ExcelField(title="站点号", align=2, sort=9)
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	@ExcelField(title="流水号", align=2, sort=8)
	public String getTicketCode() {
		return ticketCode;
	}
	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}
//	@ExcelField(title="返回码", align=2, sort=14)
	public String getBackCode() {
		return backCode;
	}
	public void setBackCode(String backCode) {
		this.backCode = backCode;
	}
//	@ExcelField(title="状态", align=2, sort=13)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	@ExcelField(title="奖金", align=2, sort=12)
	public String getWinMoney() {
		return winMoney;
	}
	public void setWinMoney(String winMoney) {
		this.winMoney = winMoney;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public int getIsBombBonus() {
		return isBombBonus;
	}
	public void setIsBombBonus(int isBombBonus) {
		this.isBombBonus = isBombBonus;
	}
	public int getBonuLevel() {
		return bonuLevel;
	}
	public void setBonuLevel(int bonuLevel) {
		this.bonuLevel = bonuLevel;
	}
	public String getLevelBonusMoney() {
		return levelBonusMoney;
	}
	public void setLevelBonusMoney(String levelBonusMoney) {
		this.levelBonusMoney = levelBonusMoney;
	}
	public int getWinNumber() {
		return winNumber;
	}
	public void setWinNumber(int winNumber) {
		this.winNumber = winNumber;
	}
	@ExcelField(title="性别", align=2, sort=11)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPrintTime() {
		return printTime;
	}
	public void setPrintTime(String printTime) {
		this.printTime = printTime;
	}
	public String getPrintStatus() {
		return printStatus;
	}
	public void setPrintStatus(String printStatus) {
		this.printStatus = printStatus;
	}
	public String getCallStatus() {
		return callStatus;
	}
	public void setCallStatus(String callStatus) {
		this.callStatus = callStatus;
	}
	
	

}
