package com.test.businessobjects;

import java.math.BigDecimal;
import java.util.Date;

public class Trade {
	
	public static final char BUY = 'B';
	public static final char SELL = 'S';
	
	private Date timestamp;
	private int numberOfShares;
	private char buyOrSell;
	private BigDecimal price;
	
	public Trade(int numberOfShares, char buyOrSell, BigDecimal price) {
		timestamp = new Date();
		this.numberOfShares = numberOfShares;
		this.buyOrSell = buyOrSell;
		this.price = price;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	public char getBuyOrSell() {
		return buyOrSell;
	}
	public void setBuyOrSell(char buyOrSell) {
		this.buyOrSell = buyOrSell;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
