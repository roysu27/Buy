package com.roy.buy.dao.impl;

import org.springframework.stereotype.Repository;

import com.roy.buy.dao.IBuyRecordDao;
import com.roy.buy.entity.BuyRecord;

@Repository
public class BuyRecordDao extends BaseDao<BuyRecord> implements IBuyRecordDao {
	
	public BuyRecordDao() {
		super(BuyRecord.class);
	}

}
