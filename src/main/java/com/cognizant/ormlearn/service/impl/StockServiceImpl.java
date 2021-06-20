package com.cognizant.ormlearn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.StockService;

@Service("stockService")
public class StockServiceImpl implements StockService {
	
	@Autowired
	private StockRepository repository;
	@Override
	public List<Stock> getAllStocks() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	@Override
	public List<Stock> getStocksOfFBInSep2019() {
		return repository.getStocksOfFBInSep2019();
	}
	@Override
	public List<Stock> getStocksOfGoogleGT1250() {
		return repository.getStocksOfGoogleGT1250();
	}
	@Override
	public List<Stock> getTop3StocksByVolume() {
		return repository.getTop3StocksByVolume(PageRequest.of(0, 3));
	}
	@Override
	public List<Stock> get3LowestNetflixStocks() {
		return repository.get3LowestNetflixStocks(PageRequest.of(0, 3));
	}

}