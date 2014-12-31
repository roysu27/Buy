package com.roy.buy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.roy.buy.dao.IBuyRecordDao;
import com.roy.buy.entity.BuyRecord;

@Repository
public class BuyRecordDao extends BaseDao<BuyRecord> implements IBuyRecordDao {
	
	public BuyRecordDao() {
		super(BuyRecord.class);
	}

	@Override
	public List<BuyRecord> findByOrderId(int orderId) {
		return super.findListBy("orderId", orderId);
	}

}
