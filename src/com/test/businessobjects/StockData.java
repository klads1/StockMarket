package com.test.businessobjects;

import java.math.BigDecimal;
import java.util.HashMap;

public class StockData {
	
	private HashMap<String, StockItem> stockDataTable;
	
	private static final StockData instance = new StockData();
	
	private StockData() {
		
		stockDataTable = new HashMap<String, StockItem>();
		
		stockDataTable.put("TEA", new StockItem(StockItem.COMMON, BigDecimal.ZERO, BigDecimal.ZERO, new BigDecimal(100), new BigDecimal(20)));
		stockDataTable.put("POP", new StockItem(StockItem.COMMON, new BigDecimal(8), BigDecimal.ZERO, new BigDecimal(100), new BigDecimal(10)));
		stockDataTable.put("ALE", new StockItem(StockItem.COMMON, new BigDecimal(23), BigDecimal.ZERO, new BigDecimal(60), new BigDecimal(35)));
		stockDataTable.put("GIN", new StockItem(StockItem.PREFERRED, new BigDecimal(8), new BigDecimal(0.02), new BigDecimal(100), new BigDecimal(17)));
		stockDataTable.put("JOE", new StockItem(StockItem.COMMON, new BigDecimal(13), BigDecimal.ZERO, new BigDecimal(250), new BigDecimal(50)));
	}
	
	public static StockData getInstance() {
		return instance;
	}

	public HashMap<String, StockItem> getStockDataTable() {
		return stockDataTable;
	}
	
	
}
