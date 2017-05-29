package com.hiext.mms.admin.sevice;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.hiext.mms.admin.model.FPointRecord;
import com.hiext.mms.admin.model.extend.FPointRecordExtend;

public interface FPointService {
	/**
	 * 积分兑换礼品
	 * @param fPointRecord
	 * @return
	 */
	@Transactional
	Boolean duihuan(FPointRecord fPointRecord);
	/**
	 * 检查所需要的积分
	 * @param fPointRecord
	 * @return
	 */
	Double check(FPointRecord fPointRecord);
	/**
	 * 查询历史兑换列表
	 * @param tel
	 * @return
	 */
	List<FPointRecordExtend> list(String tel);
}
