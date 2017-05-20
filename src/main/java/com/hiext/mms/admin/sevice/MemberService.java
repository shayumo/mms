package com.hiext.mms.admin.sevice;

import java.util.List;

import com.hiext.mms.admin.model.FMember;

public interface MemberService {
	/**
	 * 根据会员的手机号或者会员卡号查询
	 * @param fMember
	 * @return
	 */
	List<FMember> queryByTelOrNo(FMember fMember);

}
