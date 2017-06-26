package com.test.stock;

import java.math.BigDecimal;
import java.util.Date;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import com.test.businessobjects.Trade;
import com.test.calcs.Calculator;

public class TestStock {

	public static void main(String[] args) throws InterruptedException {
		
		//Test dividend yield (Common)
		System.out.println("Testing Dividend Yield (Common)");
		BigDecimal price = new BigDecimal(2);
		String stockSymbol = "TEA";
		System.out.println(stockSymbol + " - Price is " + price + " Dividend Yield is " + Calculator.getDividendYield(stockSymbol, price) + "\n");
		
		//Test dividend yield (Preferred)
		System.out.println("Testing Dividend Yield (Preferred)");
		stockSymbol = "GIN";
		System.out.println(stockSymbol + " - Price is " + price + " Dividend Yield is " + Calculator.getDividendYield(stockSymbol, price) + "\n");
		
		//Test P/E Ratio
		System.out.println("Testing P/E Ratio");
		stockSymbol = "JOE";
		System.out.println(stockSymbol + " - Price is " + price + " P/E Ratio is " + Calculator.getPERatio(stockSymbol, price) + "\n");
		
		//Test Volume Weighted Stock Price
		//Simulate trades
		TreeMap<Date, Trade> trades = new TreeMap<Date, Trade>();
		trades.put(new Date(), new Trade(5, Trade.BUY, new BigDecimal(2)));
		//Sleep for a second between trades so each has a unique key
		TimeUnit.SECONDS.sleep(1);
		trades.put(new Date(), new Trade(8, Trade.BUY, new BigDecimal(5)));
		TimeUnit.SECONDS.sleep(1);
		trades.put(new Date(), new Trade(3, Trade.SELL, new BigDecimal(3)));
		
		System.out.println("Testing Volume Weighted Stock Price");
		System.out.println("Volume Weighted Stock Price is " + Calculator.getVolumeWeightedStockPrice(trades) + "\n");

		//Test All Share Index
		System.out.println("Testing All Share Index");
		System.out.println("All Share Index is " + Calculator.getAllShareIndex() + "\n");
	}

}
