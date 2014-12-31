package com.roy.buy.dao;

import java.util.List;

import com.roy.buy.entity.BuyRecord;

/**
 * 購買記錄Dao
 */
public interface IBuyRecordDao extends IBaseDao<BuyRecord> {
	
	/**
	 * 根據訂單編號查詢購買記錄
	 * @param orderId
	 * @return
	 */
	public List<BuyRecord> findByOrderId(int orderId);

}
