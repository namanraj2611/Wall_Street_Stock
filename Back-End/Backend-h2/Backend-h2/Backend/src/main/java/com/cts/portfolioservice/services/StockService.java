package com.cts.portfolioservice.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cts.portfolioservice.daos.StockRepository;
import com.cts.portfolioservice.entities.Stock;
import com.cts.portfolioservice.models.StockDTO;

@Service
public class StockService {

	@Autowired private StockRepository brepo;
	@Autowired private VariantService vsrv;
	
	public void saveBike(StockDTO dto) {
		Stock stock=new Stock();
		if(brepo.existsById(dto.getId())) {			
			stock=brepo.getById(dto.getId());
		}		
		BeanUtils.copyProperties(dto, stock);
		stock.setVariant(vsrv.findById(dto.getVarid()));
		brepo.save(stock);
	}
	
	public void updateBike(Stock bk) {
		brepo.save(bk);
	}
	
	public List<Stock> listAll(){
		return brepo.findAll(Sort.by(Direction.DESC, "createdon"));
	}
	
	public Stock findById(String id) {
		return brepo.getById(id);
	}
	
	public List<Stock> filterBikes(int id){
		System.out.println("Filter id "+id);
		if(id==1)
			return brepo.findByStatus("Available");
		else
			return brepo.findByStatus("Not Available");
	}
	
	public List<Stock> listVariantBikes(int varid){
		return brepo.findByVariantAndStatus(vsrv.findById(varid),"Available");
	}
	
	public void deleteBike(String id) {
		if(brepo.existsById(id)) {
			brepo.delete(brepo.getById(id));
		}
	}	
}
