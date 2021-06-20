package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.model.Stock;

@Transactional
public interface StockService {
	
	@Transactional(readOnly = true)
	public List<Stock> getAllStocks();
	
	public List<Stock> getStocksOfFBInSep2019();
	
	public List<Stock> getStocksOfGoogleGT1250();
	
	public List<Stock> getTop3StocksByVolume();
	
	public List<Stock> get3LowestNetflixStocks();
}