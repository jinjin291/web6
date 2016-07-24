package com.WEBDEMO.Pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class Users {
	private int USERID;
	private String  UNAME;
	private String UPASSWORD;
	private String  NAME;
	private String USEX;
	private String  UEMAIL;
	private Date  UBIRTHDAY;
	private String  UQQ;
	private String  UHOMEADDRESS;
	private String  UCODE;
	private String  UPHONE;
	public String getUPHONE() {
		return UPHONE;
	}
	public void setUPHONE(String uPHONE) {
		UPHONE = uPHONE;
	}
	public int getUSERID() {
		return USERID;
	}
	public void setUSERID(int uSERID) {
		USERID = uSERID;
	}
	public String getUNAME() {
		return UNAME;
	}
	public void setUNAME(String uNAME) {
		UNAME = uNAME;
	}
	public String getUPASSWORD() {
		return UPASSWORD;
	}
	public void setUPASSWORD(String uPASSWORD) {
		UPASSWORD = uPASSWORD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getUSEX() {
		return USEX;
	}
	public void setUSEX(String uSEX) {
		USEX = uSEX;
	}
	public String getUEMAIL() {
		return UEMAIL;
	}
	public void setUEMAIL(String uEMAIL) {
		UEMAIL = uEMAIL;
	}
	public Date getUBIRTHDAY() {
		return UBIRTHDAY;
	}
	public void setUBIRTHDAY(Date UBIRTHDAY) {
		UBIRTHDAY = UBIRTHDAY;
	}
	public String getUQQ() {
		return UQQ;
	}
	public void setUQQ(String uQQ) {
		UQQ = uQQ;
	}
	public String getUHOMEADDRESS() {
		return UHOMEADDRESS;
	}
	public void setUHOMEADDRESS(String uhomeaddress) {
		this.UHOMEADDRESS = UHOMEADDRESS;
	}
	public String getUCODE() {
		return UCODE;
	}
	public void setUCODE(String uCODE) {
		UCODE = uCODE;
	}
	
}