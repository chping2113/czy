package com.kjlink.ahpips.web.action.system;

import java.util.Date;

import com.brady.common.util.MD5Generator;
import com.kjlink.ahpips.entity.system.Construct;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.system.ConstructService;
import com.kjlink.ahpips.service.system.UserService;
import com.kjlink.ahpips.web.action.BaseAction;

public class AccountAction extends BaseAction<User> {
	private User model = new User(); 
	private Construct construct=new Construct();
	
	private UserService userService;
	private ConstructService constructService;
	
	private String password;
	private String newPassword;
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public User getModel() {
		return model;
	}


	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	/**
	 * ʵ��Struts2��preparable�ӿ�
	 */
	public void prepare() throws Exception {
		if (id != null && id > 0) {
			model = this.userService.findById(id);
		}
	}
	
	/**
	 * չʾ�ʻ�������Ϣҳ��
	 * @return
	 * @throws Exception
	 */
	public String showAccount() throws Exception {
		
		int loginType = this.getLoginAccountType();
		if(loginType == 0){//�����û�
			model = this.userService.findByCode(this.getLoginUserFromSession().getCode());

			this.getContext().put("flag","1");
		}else{//δ��¼
			
		}
	
		this.getContext().put("loginType", loginType);
		return "showAccount";
	}
	/**
	 * չʾ�ʻ�������Ϣҳ��
	 * @return
	 * @throws Exception
	 */
	public String updateAccount() throws Exception {
		
		int loginType = this.getLoginAccountType();
		if(loginType == 0){//�����û�
			model = this.userService.findByCode(this.getLoginUserFromSession().getCode());
		}else{//δ��¼
			
		}
	
		this.getContext().put("loginType", loginType);
		return "updateAccount";
	}
	public String addAccount(){
		try{
			
			int loginType = this.getLoginAccountType();
			if(loginType == 0){//�����û�
				userService.merge(model);
			}else if(loginType == 3){ //��Ŀ���赥λ
				Construct construct2=this.constructService.findByCode(this.getLoginConstructFromSession().getCode());
				construct2.setLinkman(construct.getLinkman());
				construct2.setTel(construct.getTel());
				construct2.setEmail(construct.getEmail());
				constructService.merge(construct2);
				construct=construct2;
			}else{//δ��¼
				
			}
		
			this.getContext().put("loginType", loginType);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return "showAccount";
	}
	/**
	 * 
	 *��֤��Ŀ���赥λemail
	 * @return
	 * @throws Exception
	 */
	public String checkConstructEmail() throws Exception {
		Construct tmp = this.constructService.findByEmail(construct.getEmail(),this.constructService.findByCode(this.getLoginConstructFromSession().getCode()));
		String msg = "ok";
		if(tmp != null) {
			msg = "err";
		}
		this.writeToResponse(msg);
		return null;
	}
	/**
	 * ��֤����email
	 * @return
	 * @throws Exception
	 */
	public String checkPersonEmail()  throws Exception {
		String msg = "ok";
		this.writeToResponse(msg);
		return null;
	}
	
	/**
	 * ��֤��ҵemail
	 * @return
	 * @throws Exception
	 */
	public String checkCompanyEmail()  throws Exception {
		return null;
	}
	
	/**
	 * չʾ�޸�����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String showPassword() throws Exception {
		
		int loginType = this.getLoginAccountType();
		this.getContext().put("loginType", loginType);
		return "showPassword";
	}
	
	public Construct getConstruct() {
		return construct;
	}

	public void setConstruct(Construct construct) {
		this.construct = construct;
	}

	public ConstructService getConstructService() {
		return constructService;
	}

	public void setConstructService(ConstructService constructService) {
		this.constructService = constructService;
	}

	public void setModel(User model) {
		this.model = model;
	}

	/**
	 * �޸�����
	 * @return
	 * @throws Exception
	 */
	public String editPassword() throws Exception {
		int loginType = this.getLoginAccountType();
//		System.out.println(loginType+"----"+this.getNewPassword());
		
		password = this.getPassword();
		newPassword = this.getNewPassword();
		
		newPassword = MD5Generator.getMD5Value(newPassword); //MD5����
		password = MD5Generator.getMD5Value(password); //MD5����
		
		if(loginType == 0){
			model = this.userService.findByCode(this.getLoginUserFromSession().getCode());
			model.setPassword(newPassword);
			this.userService.update(model);
			this.putUserToSession(model);
		}else if(loginType == 3){
			construct = this.constructService.findByCode(this.getLoginConstructFromSession().getCode());
			construct.setPassword(newPassword);
			construct.setUpdateTime(new Date());
			this.constructService.update(construct);
			this.putConstructToSession(construct);
		}
		else{
			this.writeToResponse("no");
		}
		
		this.writeToResponse("ok");
	
		return null;
	}
	
	/**
	 * ��������ȷ��
	 * @return
	 * @throws Exception
	 */
	public String checkAccountPw() throws Exception {
		int loginType = this.getLoginAccountType();
	
		password = model.getPassword();
		password = MD5Generator.getMD5Value(password); //MD5����
		
		String msg = "ok";
		if(loginType == 0){
			if(!this.userService.isValidUser(this.getLoginUserFromSession().getCode(), password)){
				msg = "err";
			}
		}else if(loginType == 3){
			if(!this.constructService.isValidCompany(this.getLoginConstructFromSession().getCode(), password)){
				msg = "err";
			}
			}else{
			msg = "err";
		}
		this.writeToResponse(msg);
		return null;
	}
}
