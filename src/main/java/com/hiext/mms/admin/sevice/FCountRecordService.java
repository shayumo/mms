package com.hiext.mms.admin.sevice;

import org.springframework.transaction.annotation.Transactional;

import com.hiext.mms.admin.model.FCountRecord;

/**
 * 
 * @author angy.zhang
 *
 */
public interface FCountRecordService {
	/**
	 * 会员充值
	 * @param fCountRecord
	 * @return
	 */
	@Transactional
	Boolean add(FCountRecord fCountRecord);
	/**
	 * 会员消费
	 * 默认有三种消费：0 会员卡余额消费 1现金消费 2先使用会员卡余额再补上差价
	 * @param fCountRecord
	 * @return
	 */
	@Transactional
	Boolean consumption(FCountRecord fCountRecord);
	/**
	 * 计算折扣后的金额
	 * @param fCountRecord
	 * @return
	 */
	double getDisNum(FCountRecord fCountRecord);
}
