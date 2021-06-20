package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	@Query("SELECT s from Stock s where s.code='FB' and date like '2019-09-%'")
	List<Stock> getStocksOfFBInSep2019();
	
	@Query("SELECT s from Stock s where s.code='GOOGL' and open>1250")
	List<Stock> getStocksOfGoogleGT1250();
	
	@Query("SELECT s from Stock s order by s.volume DESC")
	List<Stock> getTop3StocksByVolume(Pageable pageable);
	
	@Query("SELECT s from Stock s where s.code='NFLX' order by s.close")
	List<Stock> get3LowestNetflixStocks(Pageable pageable);
}