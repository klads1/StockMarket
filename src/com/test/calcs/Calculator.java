package com.test.calcs;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import com.test.businessobjects.StockData;
import com.test.businessobjects.StockItem;
import com.test.businessobjects.Trade;

public class Calculator {
	
	/*
	 * Calculate the Dividend Yield
	 */
	public static BigDecimal getDividendYield(String stockSymbol, BigDecimal price) {
		
		HashMap<String, StockItem> stockDataTable = StockData.getInstance().getStockDataTable();

		BigDecimal dividendYield = BigDecimal.ZERO;
		StockItem stock = stockDataTable.get(stockSymbol);
		
		if (stock.getType().equals(StockItem.COMMON)) {
			dividendYield = stock.getLastDividend().divide(price, 2, RoundingMode.HALF_EVEN);
		} else {
			dividendYield = (stock.getFixedDividend().multiply(stock.getParValue())).divide(price, 2, RoundingMode.HALF_EVEN);
		}
		
		return dividendYield;
	}
	
	/*
	 * Calculate the P/E Ratio
	 */
	public static BigDecimal getPERatio(String stockSymbol, BigDecimal price) {
		
		HashMap<String, StockItem> stockDataTable = StockData.getInstance().getStockDataTable();
		StockItem stock = stockDataTable.get(stockSymbol);
		BigDecimal peRatio = BigDecimal.ZERO;
		
		peRatio = price.divide(stock.getLastDividend(), 2, RoundingMode.HALF_EVEN);
		
		return peRatio;
	}
	
	/*
	 * Calculate the Volume Weighted Stock Price
	 */
	public static BigDecimal getVolumeWeightedStockPrice(TreeMap<Date, Trade> trades) {
		
		BigDecimal volumeWeightedStockPrice = BigDecimal.ZERO;
		
		Date now = new Date();
		Date startTime = new Date(now.getTime() - (15 * 60 * 1000));
		
		SortedMap<Date, Trade> inScopeTrades = trades.tailMap(startTime);
		
		int totalNumberOfShares = 0;
		BigDecimal totalPrice = BigDecimal.ZERO;
		
		for (Trade trade: inScopeTrades.values()) {
			totalNumberOfShares = totalNumberOfShares + trade.getNumberOfShares();
			totalPrice = totalPrice.add(trade.getPrice().multiply(new BigDecimal(trade.getNumberOfShares())));
		}
		
		volumeWeightedStockPrice = totalPrice.divide(new BigDecimal(totalNumberOfShares), 2, RoundingMode.HALF_EVEN);
		
		return volumeWeightedStockPrice;
	}

	/*
	 * Calculate the All Share Index
	 */
	public static BigDecimal getAllShareIndex() {
		
		HashMap<String, StockItem> stockDataTable = StockData.getInstance().getStockDataTable();

		BigDecimal allShareIndex;
		
		BigDecimal priceProduct = new BigDecimal(1);
		
		// Calculate the product of all the stock prices
		for (StockItem stock: stockDataTable.values()) {
			priceProduct = priceProduct.multiply(stock.getPrice());
		}
		
		// Divide by the number of stocks
		double allShareIndexDouble = Math.pow(priceProduct.doubleValue(), (1.0 / stockDataTable.size()));
		
		allShareIndex = new BigDecimal(allShareIndexDouble).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		
		return allShareIndex;
	}
}
