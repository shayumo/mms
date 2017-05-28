package com.hiext.mms.admin.controller;

import com.hiext.mms.admin.model.FMember;
import com.hiext.mms.admin.provider.FMemberProvider;
import com.hiext.mms.core.HttpCode;
import com.hiext.mms.core.base.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tk.mybatis.mapper.entity.Example;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * <br>
 * <b>功能:会员管理</b>FMemberController<br>
 */
@Api(value = "MemberApi", description = "会员管理接口")
@RestController
@RequestMapping("/fmember")
public class FMemberController extends BaseController {
	@Autowired
	private FMemberProvider fMemberProvider;
	
	@ApiOperation(value = "所有会员", httpMethod = "POST")
	@PostMapping(value = "/list")
	public Object list(ModelMap modelMap){
		Example example = new Example(FMember.class);
		example.createCriteria().andCondition("datalevel<> 1");
		List<FMember> users=fMemberProvider.selectAllByExample(example);
		return setModelMap(modelMap, HttpCode.OK, users);
	}
	@ApiOperation(value="新增会员",httpMethod="POST")
	@PostMapping(value="/add")
	//@RequiresRoles(value="系统管理员")
	public Object add(ModelMap modelMap,@RequestBody FMember user){
		if(user !=null){
			user.setDatalevel(0);
			user.setCreatorname(getCurrUser().getName());
			user.setCreatorid(getCurrUser().getId());
			fMemberProvider.insert(user);
			return setMap(HttpCode.OK);
		}
		return setSuccessMap("请填写用户信息");
	}
	/**
	 * 修改会员信息
	 * @param modelMap
	 * @param user
	 * @return
	 */
	@ApiOperation(value="修改会员",httpMethod="POST")
	@RequestMapping("update")
	//@RequiresRoles(value="系统管理员")
	public Object update(ModelMap modelMap,@RequestBody FMember user){
		if(user !=null){
			fMemberProvider.update(user);
			return setMap(HttpCode.OK);
		}
		return setSuccessMap();
	}
	/**
	 * 根据会员ID查询会员信息
	 * @param modelMap
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询会员", httpMethod = "POST")
	@PostMapping(value = "/queryOne")
	public Object query(ModelMap modelMap,@RequestBody Long id){
		modelMap.clear();
		return setModelMap(modelMap, HttpCode.OK, fMemberProvider.selectByPrimaryKey(id));
	}
	@ApiOperation(value = "根据会员卡号查询会员", httpMethod = "POST")
	@PostMapping(value = "/queryCard")
	public Object queryCardID(ModelMap modelMap, String tel){
		modelMap.clear();
		Example example = new Example(FMember.class);
		example.createCriteria().andLike("tel", tel).andCondition("datalevel<> 2");
		List<FMember> fmen=fMemberProvider.selectAllByExample(example);
		return setModelMap(modelMap, HttpCode.OK,fmen);
	}
	/**
	 * 删除会员逻辑删除  只做数据级别变更 
	 * @param modelMap
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除会员", httpMethod = "POST")
	@PostMapping(value = "/del")
	public Object del(ModelMap modelMap, Long id){
		FMember fMember = new FMember();
		fMember.setId(id);
		fMember.setDatalevel(1);
		fMemberProvider.delete(fMember);
		return setModelMap(modelMap, HttpCode.OK, "删除成功");
	}
 
}
