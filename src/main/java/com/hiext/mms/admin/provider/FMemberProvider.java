package com.hiext.mms.admin.provider;

import com.hiext.mms.admin.model.FMember;
import com.hiext.mms.admin.model.extend.FMemberExtend;
import com.hiext.mms.core.base.service.BaseService;

/**
 * 
 * <br>
 * <b>功能：</b>FMemberProvider<br>
 */
public interface FMemberProvider extends BaseService<FMember> {
 
	FMemberExtend hytj();
}
