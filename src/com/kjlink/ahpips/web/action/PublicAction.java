/** 
  * @title:  
  * @description:   
  * @copyright: ���ݼ������޹�˾ 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.web.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.struts2.dispatcher.ServletDispatcherResult;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.brady.common.util.Base64;
import com.brady.common.util.MD5Generator;
import com.kjlink.ahpips.Constants;

import com.kjlink.ahpips.dao.system.PermissionDAO;
import com.kjlink.ahpips.entity.info.AttachFile;
import com.kjlink.ahpips.entity.info.Complaint;
import com.kjlink.ahpips.entity.info.News;
import com.kjlink.ahpips.entity.info.NewsCatelog;
import com.kjlink.ahpips.entity.info.Notice;
import com.kjlink.ahpips.entity.info.Scolumn;
import com.kjlink.ahpips.entity.project.BaseInfo;
import com.kjlink.ahpips.entity.project.KeyProject;
import com.kjlink.ahpips.entity.project.KeyProjectKind;
import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.entity.project.ProjectAim;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.project.ProjectApproveDetail;
import com.kjlink.ahpips.entity.project.ProjectApproveFlow;
import com.kjlink.ahpips.entity.project.ProjectConstruct;
import com.kjlink.ahpips.entity.project.ProjectLand;
import com.kjlink.ahpips.entity.project.ProjectMining;
import com.kjlink.ahpips.entity.system.Alexa;
import com.kjlink.ahpips.entity.system.Construct;
import com.kjlink.ahpips.entity.system.District;
import com.kjlink.ahpips.entity.system.HomePage;
import com.kjlink.ahpips.entity.system.Navigate;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.Permission;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.index.IndexService;
import com.kjlink.ahpips.service.info.AttachFileService;
import com.kjlink.ahpips.service.info.ComplaintService;
import com.kjlink.ahpips.service.info.NewsCatelogService;
import com.kjlink.ahpips.service.info.NewsService;
import com.kjlink.ahpips.service.info.NoticeService;
import com.kjlink.ahpips.service.info.ScolumnService;
import com.kjlink.ahpips.service.info.TaskService;
import com.kjlink.ahpips.service.project.ProjectAegisService;
import com.kjlink.ahpips.service.project.ProjectAimService;
import com.kjlink.ahpips.service.project.ProjectApproveDetailService;
import com.kjlink.ahpips.service.project.ProjectApproveFlowService;
import com.kjlink.ahpips.service.project.ProjectApproveService;
import com.kjlink.ahpips.service.project.ProjectConstructService;
import com.kjlink.ahpips.service.project.ProjectIssueService;
import com.kjlink.ahpips.service.project.ProjectLandService;
import com.kjlink.ahpips.service.project.ProjectMiningService;
import com.kjlink.ahpips.service.project.ProjectService;
import com.kjlink.ahpips.service.system.AlexaService;
import com.kjlink.ahpips.service.system.CoderService;
import com.kjlink.ahpips.service.system.ConstructService;
import com.kjlink.ahpips.service.system.DistrictService;
import com.kjlink.ahpips.service.system.HomePageService;
import com.kjlink.ahpips.service.system.NavigateService;
import com.kjlink.ahpips.service.system.SiteService;
import com.kjlink.ahpips.service.system.RoleService;
import com.kjlink.ahpips.service.system.UserService;
import com.kjlink.common.util.DateTypeConvert;
import com.kjlink.common.util.ExcelExport;
import com.opensymphony.xwork2.Result;


/**
 * 
 * ���ߣ�brady.zh
 * ������2010-11-4
 */
public class PublicAction extends BaseAction<User> {
	private IndexService indexService;
	private User model = new User();
	private Complaint complaint = new Complaint();

	private Construct construct=new Construct();
	
	private Integer catelogId;
	private String failType;
	
	private PermissionDAO permissionDAO;
	public PermissionDAO getPermissionDAO() {
		return permissionDAO;
	}

	public void setPermissionDAO(PermissionDAO permissionDAO) {
		this.permissionDAO = permissionDAO;
	}

	//private Permission permission=new Permission();
	
	
	private String input;//���������֤���ֵ

	public void setInput(String input) {
		this.input = input;
	}
	
	private String getInput() {
		return input;
	}

	

	public void setModel(User model) {
		this.model = model;
	}

	private UserService userService;
	

	private String welcome;
	private String loginType; //��¼��ʽ
	private RoleService roleService;
	private NoticeService noticeService;
	private NewsCatelogService newsCatelogService;
	private NewsService newsService;
	private ComplaintService complaintService;
	
	private AttachFileService attachFileService;


	private ConstructService constructService;
	
	private ProjectService projectService ;
	private ProjectApproveService projectApproveService ;
	private ProjectConstructService projectConstructService;
	private ProjectApproveDetailService projectApproveDetailService;
	private ProjectLandService projectLandService ;
	private ProjectMiningService projectMiningService ;
	private ProjectAimService projectAimService;
	private TaskService taskService ;
	private AlexaService alexaService ;
	
	
	private ProjectAegisService projectAegisService;
	private ProjectIssueService projectIssueService;

	
	private SiteService siteService;
	private NavigateService navigateService;
	private ScolumnService scolumnService;
	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public AlexaService getAlexaService() {
		return alexaService;
	}

	public void setAlexaService(AlexaService alexaService) {
		this.alexaService = alexaService;
	}

	public ProjectApproveDetailService getProjectApproveDetailService() {
		return projectApproveDetailService;
	}

	public void setProjectApproveDetailService(
			ProjectApproveDetailService projectApproveDetailService) {
		this.projectApproveDetailService = projectApproveDetailService;
	}

	public ProjectAimService getProjectAimService() {
		return projectAimService;
	}

	public void setProjectAimService(ProjectAimService projectAimService) {
		this.projectAimService = projectAimService;
	}

	public NavigateService getNavigateService() {
		return navigateService;
	}

	public void setNavigateService(NavigateService navigateService) {
		this.navigateService = navigateService;
	}

	private HomePageService homePageService ;
	
	private DistrictService districtService;
	private CoderService coderService;
	private int temp = 0;
	
	
	
	public ProjectMiningService getProjectMiningService() {
		return projectMiningService;
	}

	public void setProjectMiningService(ProjectMiningService projectMiningService) {
		this.projectMiningService = projectMiningService;
	}

	public ProjectAegisService getProjectAegisService() {
		return projectAegisService;
	}

	
	public DistrictService getDistrictService() {
		return districtService;
	}

	public void setDistrictService(DistrictService districtService) {
		this.districtService = districtService;
	}

	public CoderService getCoderService() {
		return coderService;
	}
	public ConstructService getConstructService() {
		return constructService;
	}

	public void setConstructService(ConstructService constructService) {
		this.constructService = constructService;
	}


	public void setCoderService(CoderService coderService) {
		this.coderService = coderService;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public void setProjectAegisService(ProjectAegisService projectAegisService) {
		this.projectAegisService = projectAegisService;
	}

	public ProjectIssueService getProjectIssueService() {
		return projectIssueService;
	}

	public void setProjectIssueService(ProjectIssueService projectIssueService) {
		this.projectIssueService = projectIssueService;
	}

	private String passwordType; //ȡ����������
	
	

	private String creditType;
	private String creditId;
	private String email;
	private String creditPassword;
	private String applyDept;
	private String applyer;
	private String phone;
	private String purpose;
	
	
	public String getApplyDept() {
		return applyDept;
	}

	public void setApplyDept(String applyDept) {
		this.applyDept = applyDept;
	}

	public String getApplyer() {
		return applyer;
	}

	public void setApplyer(String applyer) {
		this.applyer = applyer;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getCreditPassword() {
		return creditPassword;
	}

	public void setCreditPassword(String creditPassword) {
		this.creditPassword = creditPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreditType() {
		return creditType;
	}

	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}

	public String getCreditId() {
		return creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	public String gotoLogin() throws Exception {
		if("no_access".equals(failType)) {
			this.message = "��û��Ȩ�޲�����ϵͳ������ϵͳ����Ա��ϵ��";
		} else if("no_login".equals(failType)) {
			this.message = "����û�е�¼,���ȵ�¼����ϵͳ�ٲ����������!";
		}
		return "login";
	}
	
	/**
	 * Ĭ�ϵ�������ӦAction����������action�����ڣ�����ô�Action������Ӧ
	 * @return
	 * @throws Exception
	 */
	public String invalidPath() throws Exception {
		return "error";
	}
	
	public Result login() throws Exception {
		String code = model.getCode(), password = model.getPassword();
		
		String tPassword = password;
		
		this.getSession().put("tPassword",tPassword);
		
		password = MD5Generator.getMD5Value(password); //MD5����
		//System.out.println("huhu+ " + this.getSession().get("tPassword"));
		//���������֤����е�ֵ
		String input = this.getRequest().getParameter("rand");
		//�����֤��ͼƬ��ֵ
		String rand  =   (String) this.getRequest().getSession().getAttribute("rand");
		
		if(model.getState() == 0){//��������
			User u = this.userService.findByCode(code);
			this.message = "";
			
			if(u == null){
				this.getSession().clear();
				this.message = "��¼ʧ�ܣ�ϵͳ���޴��ʺŻ�ѡ���˴���ĵ�¼����";
			} else if( ! u.getPassword().equals(password) || ! rand.equalsIgnoreCase(input)){
				this.getSession().clear();
				this.message = "��¼ʧ�ܣ�����������벻��ȷ���������˴������֤�룡";
			}else if(! new Integer(1).equals(u.getState())){
				this.getSession().clear();
				this.message = "��¼ʧ�ܣ����ʺ��ѱ����ã�����ϵͳ����Ա��ϵ��";
			}
			
			if(! this.message.equals("")) {
				this.getSession().clear();
				return new ServletDispatcherResult("/WEB-INF/pages/login.jsp");//��̬����һ��Result
			}
			
			//this.getSession().clear();
			
			List permissionList = this.roleService.findRolePermissionListByUserId(u.getId()); //��ǰ�û�����Ӧ����Դ
			
			if(permissionList.size() == 0) { //û���κ�Ȩ��
				this.getSession().clear();
				this.getContext().put("failType", "no_access");
				return new ServletRedirectResult("pub_gotoLogin.action?failType=no_access");//��̬����һ��Result
			}
			
			
			List firstLevelMenuPermissionList = this.roleService.findMenuPermissionByUserId(u.getId()); //��һ���˵���Դ
			Map firstIdSecondPermissionMap = this.roleService.findFirstIdSecondPermissionMap(u.getId(), firstLevelMenuPermissionList);
			this.getSession().put("firstLevelMenuPermissionList", firstLevelMenuPermissionList);
			this.getSession().put("firstIdSecondPermissionMap", firstIdSecondPermissionMap);
			
		    
			
			this.putUserToSession(u); //�����¼��Ϣ
			this.getSession().put("permissionList", permissionList);

			String welcomeUrl = "system/account_showAccount.action";
			//������б������һ�η��ʵ�URL�����¼�ɹ�����ת����URL
			String prevRequestURI = (String)this.getSession().get("prevRequestURI");
			if(prevRequestURI != null) {
				this.getSession().clear();
				this.getSession().remove("prevRequestURI");
				welcomeUrl = prevRequestURI;
			}
			
			return new ServletRedirectResult(welcomeUrl); //��¼��ҳ��
		} 
			
			//this.getSession().clear();
			
			
			String welcomeUrl = "system/account_showAccount.action";
			return new ServletRedirectResult(welcomeUrl); //��¼��ҳ��
	}
	
	public String taskCount(){
		User u=getLoginUserFromSession();
		if(u!=null){
			int projectApproveCount=projectApproveService.findCount(u);
			int projectConstructCount=projectConstructService.findCount(u);
			int projectLandCount=projectLandService.findCount(u);
			int projectMiningCount=projectMiningService.findCount(u);
			int taskCount=taskService.findCount(u.getSite());

			int constructCount=constructService.findCount(u.getSite());


			List<TaskCount> taskCountList=new ArrayList<TaskCount>();
			TaskCount tc= new TaskCount();
//			List firstLevelMenuPermissionList = this.roleService.findMenuPermissionByUserId(u.getId()); //��һ���˵���Դ
//			Map firstIdSecondPermissionMap = this.roleService.findFirstIdSecondPermissionMap(u.getId(), firstLevelMenuPermissionList);
//			this.getSession().put("firstLevelMenuPermissionList", firstLevelMenuPermissionList);
//			this.getSession().put("firstIdSecondPermissionMap", firstIdSecondPermissionMap);
			int taskMenuCount=0;
			int adminMenuCount=0;
			List<Permission> firstLevelMenuPermissionList=(List<Permission>) this.getSession().get("firstLevelMenuPermissionList");
			Map firstIdSecondPermissionMap=(Map) this.getSession().get("firstIdSecondPermissionMap");
			List<Permission> taskList=null;
			List<Permission> adminList=null;
			for(int i=0;i<firstLevelMenuPermissionList.size();i++){
				Permission permission=firstLevelMenuPermissionList.get(i);
				if(permission.getTitle().equals("���칤��")){
					taskMenuCount=i+1;
					taskList=(List<Permission>) firstIdSecondPermissionMap.get(permission.getId());
				}
				if(permission.getTitle().equals("ϵͳ����")){
					adminMenuCount=i+1;
					adminList=(List<Permission>) firstIdSecondPermissionMap.get(permission.getId());
				}
			}

			if(taskList!=null){
				if(projectApproveCount>0){
					tc=new TaskCount();
					tc.setName("����Ŀ������Ϣ����<span>"+projectApproveCount+"</span>����");
					tc.setUrl("project/projectApprove_init.action?type=6");
					tc.setCount(projectApproveCount);
					for(int i=0;i<taskList.size();i++){
						Permission permission=taskList.get(i);
						if(permission.getTitle().indexOf("��Ŀ����")!=-1){
							tc.setId("smaill"+taskMenuCount+(i+1));
						}
					}
					
					tc.setFristMenu(taskMenuCount);
					if(canAccessURL("project/approveProject_initApprove.action"))
					taskCountList.add(tc);
					
				}
				if(projectConstructCount>0){
					tc=new TaskCount();
					tc.setName("�����������Ϣ����<span>"+projectConstructCount+"</span>����");
					tc.setUrl("project/projectConstruct_init.action?type=6");
					tc.setCount(projectConstructCount);
					for(int i=0;i<taskList.size();i++){
						Permission permission=taskList.get(i);
						if(permission.getTitle().indexOf("��Ŀ���������Ϣ")!=-1){
							tc.setId("smaill"+taskMenuCount+(i+1));
						}
					}
					tc.setFristMenu(taskMenuCount);
					if(canAccessURL("project/constructProject_initConstruct.action"))
					taskCountList.add(tc);
				}
				if(projectLandCount>0){
					tc=new TaskCount();
					tc.setName("������Ȩ����������Ϣ���<span>"+projectLandCount+"</span>����");
					tc.setUrl("project/projectLand_init.action?type=6");
					tc.setCount(projectLandCount);
					for(int i=0;i<taskList.size();i++){
						Permission permission=taskList.get(i);
						if(permission.getTitle().indexOf("����Ȩ����������Ϣ")!=-1){
							tc.setId("smaill"+taskMenuCount+(i+1));
						}
					}
					tc.setFristMenu(taskMenuCount);
					if(canAccessURL("project/landProject_initLand.action"))
					taskCountList.add(tc);
				}
				if(projectMiningCount>0){
					tc=new TaskCount();
					tc.setName("����ҵȨ����������Ϣ���<span>"+projectMiningCount+"</span>����");
					tc.setUrl("project/projectMining_init.action?type=6");
					tc.setCount(projectMiningCount);
					tc.setFristMenu(taskMenuCount);
					for(int i=0;i<taskList.size();i++){
						Permission permission=taskList.get(i);
						if(permission.getTitle().indexOf("��ҵȨ����������Ϣ")!=-1){
							tc.setId("smaill"+taskMenuCount+(i+1));
						}
					}
					if(canAccessURL("project/miningProject_initMining.action"))
					taskCountList.add(tc);
				}
				if(taskCount>0){
					tc=new TaskCount();
					tc.setName("��������������<span>"+taskCount+"</span>����");
					tc.setUrl("info/task_todo.action");
					tc.setCount(taskCount);
					tc.setFristMenu(taskMenuCount);
					for(int i=0;i<taskList.size();i++){
						Permission permission=taskList.get(i);
						if(permission.getTitle().indexOf("������������")!=-1){
							tc.setId("smaill"+taskMenuCount+(i+1));
						}
					}
					if(canAccessURL("info/task_"))
					taskCountList.add(tc);
				}
			}
			
			if(adminList!=null){
				
					
				if(constructCount>0){
					tc=new TaskCount();
					tc.setName("�����赥λ�ʻ����<span>"+constructCount+"</span>����");
					tc.setUrl("system/construct_list.action");
					tc.setCount(constructCount);
					tc.setFristMenu(adminMenuCount);
					for(int i=0;i<adminList.size();i++){
						Permission permission=adminList.get(i);
						if(permission.getTitle().indexOf("���赥λ�ʻ�")!=-1){
							tc.setId("smaill"+adminMenuCount+(i+1));
						}
					}
					if(canAccessURL("system/construct_"))
					taskCountList.add(tc);
					
				}
			}
			if(taskList==null && adminList==null){
				return null;
			}
//			if(taskCountList.size()==0){
//				return null;
//			}
			this.getContext().put("taskCountList", taskCountList);
			return "taskCount";
		}else{
			return null;
		}
		
	}
	public Construct getConstruct() {
		return construct;
	}

	public void setConstruct(Construct construct) {
		this.construct = construct;
	}

	@SuppressWarnings("unchecked")
	public String indexLogin() throws Exception {
		String code = model.getCode(), password = model.getPassword();
		
		String tPassword = password;
		
		this.getSession().put("tPassword",tPassword);
		
		password = MD5Generator.getMD5Value(password);
		//����������֤����е�ֵ
		//String input = this.getInput();
		//�����֤��ͼƬ��ֵ
		//String rand  =   (String) this.getRequest().getSession().getAttribute("rand");
		
		if(model.getState() == 0){//��������
			
			User u = this.userService.findByCode(code);
			//�û���¼���������ж�
			if(u == null){
				this.writeToResponse("no");
				return null;
			}
			
//			if(!u.getPassword().equals(password) || !rand.equalsIgnoreCase(input)){
//				this.writeToResponse("pass_err");
//				return null;
//			}else if(! new Integer(1).equals(u.getState())){
//				this.writeToResponse("no_approve");
//				return null;
//			}
			
			//this.getSession().clear(); //���ûỰ
			
			List permissionList = this.roleService.findRolePermissionListByUserId(u.getId()); //��ǰ�û�����Ӧ����Դ
			
			/*for(Object permission:permissionList)
			{
				Permission rs=(Permission)permission;
				System.out.println(rs.getTitle());
			}*/
			if(permissionList.size() == 0) { //û���κ�Ȩ��
				this.writeToResponse("no_access");
				return null;
			}
			
			List firstLevelMenuPermissionList = this.roleService.findMenuPermissionByUserId(u.getId()); //��һ���˵���Դ
			Map firstIdSecondPermissionMap = this.roleService.findFirstIdSecondPermissionMap(u.getId(), firstLevelMenuPermissionList);
			
			this.getSession().put("firstLevelMenuPermissionList", firstLevelMenuPermissionList);
			this.getSession().put("firstIdSecondPermissionMap", firstIdSecondPermissionMap);
			
			this.putUserToSession(u); //�����¼��Ϣ
			this.getSession().put("permissionList", permissionList);

			this.writeToResponse("0");
			
		} 
			//this.getSession().clear();
		
		
		return null;
	}

	public String addRequest() throws Exception {
		
		return "addCredit";
	}
	
	
	
	
	
	
	public String logout() throws Exception {
		this.getSession().clear();
		return "login";
	}
	
	//��ʾʡֱ���С��� ����ͳ��ҳ��
	public String dataCount() throws Exception{
		String type=getRequest().getParameter("type");
		this.getContext().put("type", type);
		Site site=siteService.findByCode(Constants.ANHUI);
		List<Site> siteList=null;
		if(type.equals("1")){
			siteList = this.siteService.findAllZhuanLanSites(site);
		}else if(type.equals("2")){
			siteList = this.siteService.findAllPingTaiSites(site);
		}else if(type.equals("3")){
			siteList= this.siteService.findAllXianSites();
		}

		List<DataCount> dataCountList=this.getDataCountList(siteList,1);
		this.getContext().put("dataCountList", dataCountList);
		return "dataCount";
	}
	//��ʾ����ר������ͳ��ҳ��
	public String showDetail(){
		String code=getRequest().getParameter("code");
		this.getContext().put("o_code", code);
		Site site=siteService.findByCode(code);
		List<Site> siteList=siteService.findDetail(site);
		List<DataCount> dataCountList=this.getDataCountList(siteList,2);
		this.getContext().put("dataCountList", dataCountList);
		return "dataCount";
	}
	
	private Date startTime;
	private Date endTime;
	private String queryStr;
	public String dataQuery() throws Exception{
		Site site = this.getSiteFromSession();
		if(site==null || "".equals(site.getCode())){
			message="1";
			return this.index();
		}
		List<DataCount> dataCountList=new ArrayList<DataCount>();
		List<Site> siteList=siteService.findPZ(site,queryStr);
		for(int i=0;i<siteList.size();i++){
			Site tempSite=siteList.get(i);
			if(tempSite.getState()!=null && tempSite.getState()==1)
				continue;
			int projectApproveCount=projectApproveDetailService.findDataCount(tempSite,startTime,endTime);
			int projectConstructCount=projectConstructService.findDataCount(tempSite,startTime,endTime);
			int projectLandCount=projectLandService.findDataCount(tempSite,startTime,endTime);
			int projectMiningCount=projectMiningService.findDataCount(tempSite,startTime,endTime);
			int projectAimCount=projectAimService.findDataCount(tempSite,startTime,endTime);




		

			DataCount dataCount=new DataCount();
			dataCount.setSite(tempSite);
			dataCount.setProjectApproveCount(projectApproveCount);
			dataCount.setProjectConstructCount(projectConstructCount);
			dataCount.setProjectLandCount(projectLandCount);
			dataCount.setProjectMiningCount(projectMiningCount);
			dataCount.setProjectAimCount(projectAimCount);



			dataCountList.add(dataCount);
			
			//int projectAimCount=projectAimService.fin
		}
		this.getContext().put("dataCountList", dataCountList);
		return "dataCount";
	}
	
	//����ͳ��excel����
	public String excelExport() throws Exception{
		String type = getRequest().getParameter("type");
		String code = getRequest().getParameter("code");
		Site ssite=siteService.findByCode(Constants.ANHUI);
		List<Site> siteList=null;

		List<DataCount> dataCountList = null;
		if("1".equals(type)){
			siteList = this.siteService.findAllZhuanLanSites(ssite);
			dataCountList = this.getDataCountList(siteList,1);
		}else if("2".equals(type)){
			siteList = this.siteService.findAllPingTaiSites(ssite);
			dataCountList = this.getDataCountList(siteList,1);
		}else if("3".equals(type)){
			siteList= this.siteService.findAllXianSites();
			dataCountList = this.getDataCountList(siteList,1);
		}else if(code!=null && !"".equals(code)){
			ssite=siteService.findByCode(code);
			siteList=siteService.findDetail(ssite);
			dataCountList = this.getDataCountList(siteList,2);
		}
		ExcelExport excelExport = new ExcelExport();
		List excelList = new ArrayList<List>();
		for(DataCount dataCount : dataCountList){
			List list = new ArrayList();
			if(dataCount.getSite() != null){
				list.add(dataCount.getSite().getName());
			}else {
				list.add("����");
			}
			list.add(dataCount.getProjectApproveCount());
			list.add(dataCount.getProjectConstructCount());
			list.add(dataCount.getProjectLandCount());
			list.add(dataCount.getProjectMiningCount());
			list.add(dataCount.getProjectAimCount());
			list.add(dataCount.getCompanyCreditCount());
			list.add(dataCount.getCompanyInfoCount());
			list.add(dataCount.getCompanyQualificationCount());
			list.add(dataCount.getPersonQualificationCount());
			list.add(dataCount.getCompanyHonorCount());
			list.add(dataCount.getCompanyBadrecordCount());
			list.add(dataCount.getAllCount());
			excelList.add(list);
		}
		String fileName = "Excel_"+System.currentTimeMillis();
		excelExport.setDataListGetExcel(excelList, fileName);
		this.getContext().put("fileName", fileName+".xls");
		return "downloadExcelFile";
	}
	
	//�õ�ͳ�������б�
	/**
	 * temp������1.���ұ���������ר������������2.���ұ�������������
	 */
	private List<DataCount> getDataCountList(List<Site> siteList , int temp) {
		List<DataCount> dataCountList = new ArrayList<DataCount>();
		int projectApproveSum = 0;
		int projectConstructSum = 0;
		int projectLandSum = 0;
		int projectMiningSum = 0;
		int projectAimSum = 0;
		int companyCreditSum = 0;
		int companyQualificationSum = 0;
		int companyInfoSum = 0;
		int personQualificationSum = 0;
		int companyHonorSum = 0;
		int companyBadrecordSum = 0;
		int allCountSum = 0;
		for (int i = 0; i < siteList.size(); i++) {
			Site tempSite = siteList.get(i);
			if(tempSite.getState()!=null && tempSite.getState()==1)
				continue;
			int projectApproveCount = 0;
			int projectConstructCount = 0;
			int projectLandCount = 0;
			int projectMiningCount =0;
			int projectAimCount = 0;
			int companyCreditCount = 0;
			int companyInfoCount = 0;
			int companyQualificationCount =0;
			int personQualificationCount =0;
			int companyHonorCount = 0;
			int companyBadrecordCount = 0;
			if(temp==2){

				projectApproveCount = projectApproveDetailService.findDataCount(tempSite,null,null);
				projectConstructCount = projectConstructService.findDataCount(tempSite,null,null);
				projectLandCount = projectLandService.findDataCount(tempSite,null,null);
				projectMiningCount = projectMiningService.findDataCount(tempSite,null,null);
				projectAimCount = projectAimService.findDataCount(tempSite,null,null);
				
			}else{
				projectApproveCount = projectApproveDetailService
						.findDataCount(tempSite);
				projectConstructCount = projectConstructService
						.findDataCount(tempSite);
				projectLandCount = projectLandService.findDataCount(tempSite);
				projectMiningCount = projectMiningService
						.findDataCount(tempSite);
				projectAimCount = projectAimService.findDataCount(tempSite);
				
			}
			
			int allCount = projectApproveCount + projectConstructCount
					+ projectLandCount + projectMiningCount + projectAimCount
					+ companyCreditCount + companyInfoCount
					+ companyQualificationCount + personQualificationCount
					+ companyHonorCount + companyBadrecordCount;

			projectApproveSum = projectApproveSum + projectApproveCount;
			projectConstructSum = projectConstructCount + projectConstructSum;
			projectLandSum = projectLandSum + projectLandCount;
			projectMiningSum = projectMiningSum + projectMiningCount;
			projectAimSum = projectAimSum + projectAimCount;
			
			allCountSum = allCountSum + allCount;

			DataCount dataCount = new DataCount();
			dataCount.setSite(tempSite);
			dataCount.setProjectApproveCount(projectApproveCount);
			dataCount.setProjectConstructCount(projectConstructCount);
			dataCount.setProjectLandCount(projectLandCount);
			dataCount.setProjectMiningCount(projectMiningCount);
			dataCount.setProjectAimCount(projectAimCount);
			
			dataCount.setAllCount(allCount);
			dataCountList.add(dataCount);

			// int projectAimCount=projectAimService.fin
		}
		Comparator comp = new Comparator() {
			public int compare(Object o1, Object o2) {
				DataCount p1 = (DataCount) o1;
				DataCount p2 = (DataCount) o2;
				if (p1.getAllCount() < p2.getAllCount())
					return 1;
				else
					return 0;
			}
		};
		Collections.sort(dataCountList, comp);

		DataCount dataCount = new DataCount();
		dataCount.setSite(null);
		dataCount.setProjectApproveCount(projectApproveSum);
		dataCount.setProjectConstructCount(projectConstructSum);
		dataCount.setProjectLandCount(projectLandSum);
		dataCount.setProjectMiningCount(projectMiningSum);
		dataCount.setProjectAimCount(projectAimSum);
		dataCount.setCompanyCreditCount(companyCreditSum);
		dataCount.setCompanyInfoCount(companyInfoSum);
		dataCount.setCompanyQualificationCount(companyQualificationSum);
		dataCount.setPersonQualificationCount(personQualificationSum);
		dataCount.setCompanyHonorCount(companyHonorSum);
		dataCount.setCompanyBadrecordCount(companyBadrecordSum);
		dataCount.setAllCount(allCountSum);
		dataCountList.add(dataCount);
		return dataCountList;
	}
	
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getQueryStr() {
		return queryStr;
	}

	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}

	public String welcome() throws Exception {
		User me = this.getLoginUserFromSession();
		if(me == null) {
			this.message = "�Բ������¼����ִ�б��β�����";
			return "login";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� E", Locale.SIMPLIFIED_CHINESE);
		welcome = sdf.format(new Date());
		return "welcome";
	}
	private String searchSiteCode;
	
	public String getSearchSiteCode() {
		return searchSiteCode;
	}

	public void setSearchSiteCode(String searchSiteCode) {
		this.searchSiteCode = searchSiteCode;
	}

	/**
	 * ��ʾ��ҳ����
	 * @return
	 * @throws Exception
	 */
	public String index() throws Exception {
		String[] tmp = this.getContext().getName().split("_");
		String siteCode = tmp[1];
		if("old".equals(siteCode)){
			siteCode = Constants.ANHUI;
		}
		if("dataCount".equals(siteCode) ||"dataQuery".equals(siteCode) ||"index".equals(siteCode) || "listNewsByCatelogId".equals(siteCode) || "navProjectPublic".equals(siteCode) || "navCreditPublic".equals(siteCode) || "showComplaint".equals(siteCode) ||"listMoreNotice".equals(siteCode)){
			siteCode = Constants.ANHUI;
		}
		searchSiteCode=siteCode;
		Site site = this.siteService.findByCode(siteCode);
		this.getSession().put("session_site", site);
		
		//ȡ���������֪ͨ����
		//List<Notice> noticeList = this.noticeService.findBySite(site, 10);
		//this.getContext().put("noticeList", noticeList);
		
		//ȡ��������ĸ���֪ͨ����
//		List<Notice> floatNoticeList = this.noticeService.findFloatNotice(site,5);
//		this.getContext().put("floatNoticeList", floatNoticeList);
		
		//ȡ��������ı���ͼƬ����
		List<News> imageNewsList = this.newsService.findImageNews(5);
		this.getContext().put("imageNewsList", imageNewsList);
		
		//ȡ��������ķ�ͼƬ��������
		List<News> nonImageNewsList = this.newsService.findNonImageNews(10);
		this.getContext().put("nonImageNewsList", nonImageNewsList);
		

		
//		//ȡ�������ҵ��λ���ŵ���
//		List<Company> companyList = companyService.findCompanyForPulbic(10);
//		this.getContext().put("companyList", companyList);
		
//		//ȡ�������ҵ���˳��ŵ���
//		List<Person> personList = personService.findPersonForPulbic(10);
//		this.getContext().put("personList", personList);

//		//���˻�����Ϣ
//		List<PersonInfo> personBaseList = personInfoService.findPageAllState(1, 10, "").getPageData();
//		this.getContext().put("personBaseList", personBaseList);
////		��λ������Ϣ
//		List<CompanyQualification> companyQualificationList = companyQualificationService.findByState(1,10).getPageData();
//		this.getContext().put("companyQualificationList", companyQualificationList);
////		����������Ϣ
//		List<PersonQualification> personQualificationList = personQualificationService.findByState(1, 10).getPageData();
//		this.getContext().put("personQualificationList", personQualificationList);
		
		//�ص���Ŀ��Ϣ����
		List<KeyProjectKind> keyProjectKindList = projectAegisService.findKeyAll(site);
		Map keyProjectMap = new HashMap();
		if(keyProjectKindList != null && keyProjectKindList.size() > 0){
			for(int i=0; i<keyProjectKindList.size(); i++){
				KeyProjectKind keyProjectKind = (KeyProjectKind)keyProjectKindList.get(i);
				List<KeyProject> keyProjectList =  projectIssueService.findProjectIdByKindId(keyProjectKind);
				keyProjectMap.put(keyProjectKind.getId(), keyProjectList);
			}
		}
		this.getContext().put("keyProjectKindList", keyProjectKindList);
		this.getContext().put("keyProjectMap", keyProjectMap);
		
		//���Ŵ�ҵ��������
		List<NewsCatelog> typicalList=this.newsCatelogService.findSecondCatelogsByParentId(20);
		this.getContext().put("typicalList", typicalList);
		for(int i=0;i<typicalList.size();i++){
			NewsCatelog newsCatelog=typicalList.get(i);
			title=newsCatelog.getParent().getTitle();
			List<News> companyNews=this.newsService.findPageByNewsCatelogId(newsCatelog.getId(), 1, 10).getPageData();
			this.getContext().put("typicalList"+i, companyNews);
		}

		//������ҳ��ʽ��Ϣ
//		HomePage homePage = this.homePageService.findHomePageBySite(site);
//		int count=5;
//		if(homePage.getApprove()==0){
//			count--;
//		}
//		if(homePage.getConstruct()==0){
//			count--;
//		}
//		if(homePage.getLand()==0){
//			count--;
//		}
//		if(homePage.getAim()==0){
//			count--;
//		}
//		if(homePage.getMining()==0){
//			count--;
//		}
//		this.getContext().put("count", count);
//		this.getContext().put("homePage", homePage);
//		this.getSession().put("session_homePage", homePage);
////		if(site.getType()!=1){
			List<Navigate> allNavigateList=this.navigateService.findByType(0, Integer.valueOf(site.getId()));
			this.getContext().put("allNavigateList", allNavigateList);
			List smailList=new ArrayList();
			for(int i=0;i<allNavigateList.size();i++){
				List<Navigate> topNavigateList=this.navigateService.findByTypeParent(1, Integer.valueOf(site.getId()), allNavigateList.get(i).getId());
				smailList.add(topNavigateList);
			}
			this.getContext().put("smailList", smailList);
			
//		}
			List<ProjectApproveDetail> projectApproveDetailList=projectApproveDetailService.findProjectApproveDetailForPulbic(10,site);
			this.getContext().put("projectApproveDetailList", projectApproveDetailList);
	
			//ȡ�����Ŀ�����������Ϣ
			List<ProjectConstruct> projectConstructList = projectConstructService.findProjectConstructForPulbic(10,site);
			this.getContext().put("projectConstructList", projectConstructList);
		
			//ȡ�����������������Ϣ
			List<ProjectLand> projectLandList = projectLandService.findProjectLandForPulbic(10,site);
			this.getContext().put("projectLandList", projectLandList);
			//ȡ�����ҵ����������Ϣ
			List<ProjectMining> projectMiningList = projectMiningService.findProjectMiningForPulbic(10,site);
			this.getContext().put("projectMiningList", projectMiningList);
		
			//ȡ����б�Ͷ����Ϣ
			List<ProjectAim> projectAimList = projectAimService.findProjectAimForPulbic(10,site);
			this.getContext().put("projectAimList", projectAimList);
			
			//��Ŀ����
			List<Permission> list1 =this.permissionDAO.findProjectbyParentId2(3); 
			
			
			  for (int i = 0; i < list1.size(); i++) {  

			       this.getContext().put("list1"+i, list1.get(i));

			   }

			
			//ȡ���������õ���Ŀ������
				List<Scolumn> scolumnList = scolumnService.findAllScolumn();
				this.getContext().put("scolumnList", scolumnList);
			
//			if(homePage!=null){
//				if(homePage.getApprove()==1){
//					//ȡ�����Ŀ����������Ϣ
////					List<ProjectApprove> projectApproveList = projectApproveService.findProjectApproveForPulbic(20,site);
////					this.getContext().put("projectApproveList", projectApproveList);
//					List<ProjectApproveDetail> projectApproveDetailList=projectApproveDetailService.findProjectApproveDetailForPulbic(10,site);
//					this.getContext().put("projectApproveDetailList", projectApproveDetailList);
//				}else if(homePage.getConstruct()==1){
//					//ȡ�����Ŀ�����������Ϣ
//					List<ProjectConstruct> projectConstructList = projectConstructService.findProjectConstructForPulbic(10,site);
//					this.getContext().put("projectConstructList", projectConstructList);
//				}else if(homePage.getLand()==1){
//					//ȡ������ؿ�ҵ����������Ϣ
//					List<ProjectLand> projectLandList = projectLandService.findProjectLandForPulbic(10,site);
//					this.getContext().put("projectLandList", projectLandList);
//				}else if(homePage.getAim()==1){
//					//ȡ����б�Ͷ����Ϣ
//					List<ProjectAim> projectAimList = projectAimService.findProjectAimForPulbic(10,site);
//					this.getContext().put("projectAimList", projectAimList);
//				}
//			}
			
			
			
//			
			
		//��֯������Ϣ
//		List<Site> shengzhiSiteList = this.siteService.findAllShengZhiSites();
//		this.getContext().put("shengzhiSiteList", shengzhiSiteList);
		
//		if(site.getType()==0){
//			Site siteTemp = site.getParent();
//			if(siteTemp!=null){
//				site = siteTemp;
//			}
//		}

		
		
		if(tmp[0].equals("nv")){
			return "index";
		}
		if(tmp[0].equals("gk")){
			return "index";
		}
		if(Constants.ANHUI.equals(tmp[1])){
			return "index";
		}
		if("dataCount".equals(tmp[1]) ||"dataQuery".equals(tmp[1]) ||"listNewsByCatelogId".equals(tmp[1]) || "navProjectPublic".equals(tmp[1]) || "navCreditPublic".equals(tmp[1]) || "showComplaint".equals(tmp[1]) ||"listMoreNotice".equals(tmp[1])){
			return "index";
		}
		
		return tmp[1];
	}

	public String ajaxDataCount(){

			Site ssite=siteService.findByCode(Constants.ANHUI);

			//ֱ��ר����Ϣ
			List<Site> zhuanLanSiteList = this.siteService.findAllZhuanLanSites(ssite);
			this.getContext().put("zhuanLanSiteList", zhuanLanSiteList);
			List<Values> valuesList=new ArrayList<Values>();
			int allSum=0;
			for(int i=0;i<zhuanLanSiteList.size();i++){
				Values values=new Values();
				Site tempSite=zhuanLanSiteList.get(i);
				if(tempSite.getState()!=null && tempSite.getState()==1)
					continue;
				int projectApproveCount=projectApproveDetailService.findDataCount(tempSite);
				int projectConstructCount=projectConstructService.findDataCount(tempSite);
				int projectLandCount=projectLandService.findDataCount(tempSite);
				int projectMiningCount=projectMiningService.findDataCount(tempSite);
				int projectAimCount=projectAimService.findDataCount(tempSite);
			
				values.setName(tempSite.getName());
				valuesList.add(values);
			}
			  Comparator comp = new Comparator(){
			        public int compare(Object o1,Object o2) {
			        	Values p1=(Values)o1;
			        	Values p2=(Values)o2; 
			             if(p1.getValue()<p2.getValue())
			                 return 1;
			             else
			                 return 0;
			             }
			        };
			 Collections.sort(valuesList,comp);
			this.getContext().put("valuesList", valuesList);
			
	 
			//ֱ��ƽ̨��Ϣ
			List<Site> pingTaiSiteList = this.siteService.findAllPingTaiSites(ssite);
			this.getContext().put("pingTaiSiteList", pingTaiSiteList);

			int allSum1=0;
			List<Values> valuesList2=new ArrayList<Values>();
			for(int i=0;i<pingTaiSiteList.size();i++){
				Values values=new Values();
				Site tempSite=pingTaiSiteList.get(i);
				if(tempSite.getState()!=null && tempSite.getState()==1)
					continue;
				int projectApproveCount=projectApproveDetailService.findDataCount(tempSite);
				int projectConstructCount=projectConstructService.findDataCount(tempSite);
				int projectLandCount=projectLandService.findDataCount(tempSite);
				int projectMiningCount=projectMiningService.findDataCount(tempSite);
				int projectAimCount=projectAimService.findDataCount(tempSite);
				values.setName(tempSite.getName());
				valuesList2.add(values);
			}
			 Collections.sort(valuesList2,comp);
			this.getContext().put("valuesList2", valuesList2);
			

			int allSum2=0;
			List<Site> xianSiteList = this.siteService.findAllXianSites();
			this.getContext().put("xianSiteList", xianSiteList);
			List<Values> valuesList3=new ArrayList<Values>();
			for(int i=0;i<xianSiteList.size();i++){
				Values values=new Values();
				Site tempSite=xianSiteList.get(i);
				if(tempSite.getState()!=null && tempSite.getState()==1)
					continue;
				int projectApproveCount=projectApproveDetailService.findDataCount(tempSite);
				int projectConstructCount=projectConstructService.findDataCount(tempSite);
				int projectLandCount=projectLandService.findDataCount(tempSite);
				int projectMiningCount=projectMiningService.findDataCount(tempSite);
				int projectAimCount=projectAimService.findDataCount(tempSite);
				values.setName(tempSite.getName());
				valuesList3.add(values);
			}
			 Collections.sort(valuesList3,comp);
			this.getContext().put("valuesList3", valuesList3);
			this.getContext().put("allSum", allSum);
			this.getContext().put("allSum1", allSum1);
			this.getContext().put("allSum2", allSum2);
			
			
			return "ajaxDataCount";
			
	}


	
	
	
	

	public String ajaxProjectApprove(){

		//ȡ�����Ŀ����������Ϣ
		Site site=siteService.findByCode(searchSiteCode);
//		List<ProjectApprove> projectApproveList = projectApproveService.findProjectApproveForPulbic(20,site);
//		this.getContext().put("projectApproveList", projectApproveList);
		List<ProjectApproveDetail> projectApproveDetailList=projectApproveDetailService.findProjectApproveDetailForPulbic(10,site);
		this.getContext().put("projectApproveDetailList", projectApproveDetailList);
		return "ajaxProjectApprove";
	}
	public String ajaxProjectConstruct() throws Exception{
		//ȡ�����Ŀ�����������Ϣ
		Site site=siteService.findByCode(searchSiteCode);
		List<ProjectConstruct> projectConstructList = projectConstructService.findProjectConstructForPulbic(10,site);
		this.getContext().put("projectConstructList", projectConstructList);
//		Thread.sleep(1000);
		return "ajaxProjectCoustruct";
	}
	public String ajaxProjectLand(){
		//ȡ������ؿ�ҵ����������Ϣ
		Site site=siteService.findByCode(searchSiteCode);
		List<ProjectLand> projectLandList = projectLandService.findProjectLandForPulbic(10,site);
		this.getContext().put("projectLandList", projectLandList);
		return "ajaxProjectLand";
	}
	public String ajaxProjectAim(){
		//ȡ����б�Ͷ����Ϣ
		Site site=siteService.findByCode(searchSiteCode);
		List<ProjectAim> projectAimList = projectAimService.findProjectAimForPulbic(10,site);
		this.getContext().put("projectAimList", projectAimList);
		return "ajaxProjectAim";
	}
	/**
	 * ��ʾ֪ͨ��ϸ��Ϣ
	 * @return
	 * @throws Exception
	 */
//	public String showNotice() throws Exception {
//		Notice notice = this.getNoticeService().findById(id);
//		notice.setHitCount(notice.getHitCount() + 1);
//		this.getNoticeService().update(notice);
//		
//		//ʹ��Base64�����ݽ��н���
//		String content = notice.getContent();
//		if(content != null)
//			notice.setContent(new String(Base64.decode(content)));
//		List<AttachFile> attachFileList = this.attachFileService.findAttachFileByNotice(notice);
//		this.getContext().put("notice", notice);
//		if(attachFileList.size()>0){
//			this.getContext().put("attachFileList", attachFileList);
//		}
//		return "showNotice";
//	}
//	
	/**
	 * Ԥ��֪ͨ���棬�����ӵ������ֵ
	 */
//	public String previewNotice() throws Exception {
//		Notice notice = this.getNoticeService().findById(id);
//		
//		//ʹ��Base64�����ݽ��н���
//		String content = notice.getContent();
//		if(content != null)
//			notice.setContent(new String(Base64.decode(content)));
//		List<AttachFile> attachFileList = this.attachFileService.findAttachFileByProjectApprove(projectApprove);
//		this.getContext().put("notice", notice);
//		if(attachFileList.size()>0){
//			this.getContext().put("attachFileList", attachFileList);
//		}
//		return "showNotice";
//	}
	
	/**
	 * Ԥ�����ţ������ӵ������ֵ
	 */
	public String previewNews() throws Exception {
		News news = this.getNewsService().findById(id);
		
		//ʹ��Base64�����ݽ��н���
		String content = news.getContent();
		if(content != null)
			news.setContent(new String(Base64.decode(content)));
		this.getContext().put("news", news);
		List<AttachFile> attachFileList = this.attachFileService.findAttachFileByNews(news);
		if(attachFileList.size()>0){
			this.getContext().put("attachFileList", attachFileList);
		}
		return "showNews";
	}
	
	/**
	 * ��ʾ������ϸ��Ϣ
	 * @return
	 * @throws Exception
	 */
	public String showNews() throws Exception {
		News news = this.getNewsService().findById(id);
		news.setHitCount(news.getHitCount() + 1);
		this.getNewsService().update(news);
		//ʹ��Base64�����ݽ��н���
		String content = news.getContent();
		
		if(content != null)
			news.setContent(new String(Base64.decode(content)));
		this.getContext().put("news", news);
		List<AttachFile> attachFileList = this.attachFileService.findAttachFileByNews(news);
		if(attachFileList.size()>0){
			this.getContext().put("attachFileList", attachFileList);
		}
		return "showNews";
	}
	private ProjectApproveFlowService  projectApproveFlowService;
	public ProjectApproveFlowService getProjectApproveFlowService() {
		return projectApproveFlowService;
	}

	public void setProjectApproveFlowService(
			ProjectApproveFlowService projectApproveFlowService) {
		this.projectApproveFlowService = projectApproveFlowService;
	}

	/**
	 * ��ʾ��Ŀ������Ϣ����
	 * @return
	 * @throws Exception
	 */
	public String showProjectApprove() throws Exception {
//		List<Site> allSites = this.siteService.findAll();
//		Site siteRoot = this.siteService.findRootSite();
//		ZTree ztree = new ZTree(String.valueOf(siteRoot.getId()), siteRoot.getName(), "", true);
//		this.siteService.bulidSiteTree(allSites, ztree);
//		ArrayList<ZTree> ztreeList = new ArrayList<ZTree>();
//		ztreeList.add(ztree);
//		JSONArray jo = JSONArray.fromObject(ztreeList);
//		this.getContext().put("siteTreeData", jo.toString());
		
		ProjectApprove projectApprove = projectApproveService.findById(id);
//		Project project = projectService.findById(projectApprove.getProject().getId());
//		this.getContext().put("project", project);
		List<ProjectApproveFlow> projectApproveFlowList=projectApproveFlowService.findByProjectApprove(projectApprove);
		for(int i=0;i<projectApproveFlowList.size();i++){
			ProjectApproveFlow projectApproveFlow=projectApproveFlowList.get(i);
			String type=projectApproveFlow.getType();
			Site fsite=projectApproveFlow.getSite();
			if(type.equals("plan")){
				this.getContext().put("planSiteName", fsite.getName());
			}else if(type.equals("propose")){
				this.getContext().put("proposeSiteName", fsite.getName());
			}else if(type.equals("feasibility")){
				this.getContext().put("feasibilitySiteName", fsite.getName());
			}else if(type.equals("design")){
				this.getContext().put("designSiteName", fsite.getName());
			}else if(type.equals("energy")){
				this.getContext().put("energySiteName", fsite.getName());
			}else if(type.equals("address")){
				this.getContext().put("addressSiteName", fsite.getName());
			}else if(type.equals("land")){
				this.getContext().put("landSiteName", fsite.getName());
			}else if(type.equals("environment")){
				this.getContext().put("environmentSiteName", fsite.getName());
			}else if(type.equals("approveResult")){
				this.getContext().put("approveResultSiteName", fsite.getName());
			}else if(type.equals("startReports")){
				this.getContext().put("startReportsSiteName", fsite.getName());
			}
				
			
		}
		this.getContext().put("projectApprove", projectApprove);
		return "showPorjectApprove";
	}
	
	/**
	 * ��ʾ��Ŀ���������Ϣ����
	 * @return
	 * @throws Exception
	 */
	public String showProjectConstruct() throws Exception {

//		List<Site> allSites = this.siteService.findAll();
//		Site siteRoot = this.siteService.findRootSite();
//		ZTree ztree = new ZTree(String.valueOf(siteRoot.getId()), siteRoot.getName(), "", true);
//		this.siteService.bulidSiteTree(allSites, ztree);
//		ArrayList<ZTree> ztreeList = new ArrayList<ZTree>();
//		ztreeList.add(ztree);
//		JSONArray jo = JSONArray.fromObject(ztreeList);
//		this.getContext().put("siteTreeData", jo.toString());
		
		
		
		ProjectConstruct projectConstruct = projectConstructService.findById(id);
//		Project project = projectService.findById(projectConstruct.getProject().getId());
//		this.getContext().put("project", project);
		this.getContext().put("projectConstruct", projectConstruct);
		return "showProjectConstruct";
	}
	
	/**
	 * ��ʾ���ؿ�ҵ����������Ϣ
	 * @return
	 * @throws Exception
	 */
	public String showProjectLand() throws Exception {
		ProjectLand projectLand = projectLandService.findById(id);
//		Project project = projectService.findById(projectLand.getProject().getId());
//		this.getContext().put("project", project);
		this.getContext().put("projectLand", projectLand);
		return "showProjectLand";
	}
	/**
	 * ��ʾ���ؿ�ҵ����������Ϣ
	 * @return
	 * @throws Exception
	 */
	public String showProjectMining() throws Exception {
		ProjectMining projectMining = projectMiningService.findById(id);
//		Project project = projectService.findById(projectLand.getProject().getId());
//		this.getContext().put("project", project);
		this.getContext().put("projectMining", projectMining);
		return "showProjectMining";
	}
	public String showProjectAim() throws Exception {
		ProjectAim projectAim= projectAimService.findById(id);
//		Project project = projectService.findById(projectLand.getProject().getId());
//		this.getContext().put("project", project);
		this.getContext().put("projectAim", projectAim);
		return "showProjectAim";
	}
	/**
	 * ��ʾ��ҵ��λ����������Ϣ
	 * @return
	 * @throws Exception
	 */
	public String showCompanyBadrecord() throws Exception {
//		Company company = companyService.findById(companyBadrecord.getCompany().getId());
//		List<CompanyInfo> companyInfoList = companyInfoService.findByCompany(company);
//		if(companyInfoList!=null && companyInfoList.size()>0){
//			this.getContext().put("companyInfo", companyInfoList.get(0));
//		}
//		this.getContext().put("company", company);
		return "showCompanyBadrecord";
	}
	
	/**
	 * ��ʾ�ص���Ŀ��Ϣ����
	 * @return
	 * @throws Exception
	 */
	public String showPorjectAegis() throws Exception {
		
		ProjectConstruct projectConstruct = projectConstructService.findById(id);
//		Project project = projectService.findById(projectConstruct.getProject().getId());
//		this.getContext().put("project", project);
		this.getContext().put("projectConstruct", projectConstruct);
		return "showProjectConstruct";
	}
	public String projectPublicApprove()throws Exception {
		String code=getRequest().getParameter("code");
//		this.pageInfo = projectApproveService.findPublicAll(getPageNo(), getMaxPageSize(),this.getSiteFromSession());
		if(code!=null){
			Site site=siteService.findByCode(code);
			this.pageInfo=projectApproveDetailService.findPublicAll(getPageNo(), getMaxPageSize(),site);
		}
		return "projectPublicApprove";
	}
	
	public String projectPublicConstruct()throws Exception {
		String code=getRequest().getParameter("code");
		if(code!=null){
			Site site=siteService.findByCode(code);
			this.pageInfo = projectConstructService.findPublicAll(getPageNo(), getMaxPageSize(),site);
		}
		return "projectPublicConstruct";
	}
	
	public String projectPublicLand()throws Exception {
		String code=getRequest().getParameter("code");
		if(code!=null){
			Site site=siteService.findByCode(code);
			this.pageInfo = projectLandService.findPublicAll(getPageNo(), getMaxPageSize(),site);
		}
		return "projectPublicLand";
	}
	public String projectPublicMining()throws Exception {
		String code=getRequest().getParameter("code");
		if(code!=null){
			Site site=siteService.findByCode(code);
			this.pageInfo = projectMiningService.findPublicAll(getPageNo(), getMaxPageSize(),site);
		}
		return "projectPublicMining";
	}
	public String projectPublicAim()throws Exception {
		String code=getRequest().getParameter("code");
		if(code!=null){
			Site site=siteService.findByCode(code);
			this.pageInfo = projectAimService.findPublicAll(getPageNo(), getMaxPageSize(),site);
		}
		return "projectPublicAim";
	}
	public String rightNews()throws Exception {
		NewsCatelog newsCatelog = this.newsCatelogService.findById(18);
		this.getContext().put("newsCatelog", newsCatelog);
		this.pageInfo = this.newsService.findPageByNewsCatelogId(18, this.getPageNo(), this.getMaxPageSize());
		return "rightNews";
	}
	public String rightNotice()throws Exception {
		Site site = this.getSiteFromSession();
		if(site==null || "".equals(site.getCode())){
			message="1";
			return this.index();
		}
		this.pageInfo = this.noticeService.findParentNotice("",this.getPageNo(), this.getMaxPageSize(),site);
		return "rightNotice";
	}
	private String chengxing;
	public String getChengxing() {
		return chengxing;
	}

	public void setChengxing(String chengxing) {
		this.chengxing = chengxing;
	}

	public String rightCompany(){
		this.pageInfo=this.newsService.findPageByNewsCatelogId(id, getPageNo(),getMaxPageSize());
		chengxing=this.newsCatelogService.findById(id).getTitle();
		return "rightCompany";
	}
	public String showComplaintAdd() throws Exception{
		Site site = this.getSiteFromSession();
		if(site==null || "".equals(site.getCode())){
			message="1";
			return this.index();
		}
		this.pageInfo = complaintService.findPageAll(getPageNo(), getMaxPageSize());
		return "showComplaintAdd";
	}
	public String complaintAdd()  throws Exception {
		complaint.setIp(this.getClientIP());
		complaint.setCreateTime(new Date());
		complaint.setDealState(0);
		//ʹ��Base64�����ݽ��б���
		if(complaint.getContent() != null) {
			complaint.setContent(Base64.encode(complaint.getContent().getBytes()));
		}
		this.complaintService.save(complaint);
		String message="���ύ��Ͷ�߾ٱ���Ϣ�Ѿ�����ɹ������ǻ�������ʱ���ڴ�����Ҫʱ��������ϵ��";
		this.getContext().put("message", message);
		this.backURL = "pub_index.action";
		return "success";
	}
	/**
	 * ��ʾ��Ŀ���赥λע��ҳ��
	 */
	public String constructRegister() throws Exception{
		return "constructRegister";
	}
	/**
	 * ��ʾ��Ŀ���赥λҳ��-����
	 */
	public String constructRegisterAdd()  throws Exception {
		construct.setValidState(1);
		construct.setRegisterTime(new Date());
		construct.setState(0);
		if(construct.getPassword() != null){
			construct.setPassword(MD5Generator.getMD5Value(construct.getPassword()));
		}
		this.constructService.save(construct);
		this.getContext().put("message", "���ύ����Ŀ���赥λע����Ϣ�ѱ���ɹ������ǻ�������ʱ���ڽ�����ˣ�������˽�����͵���ע��ʱ�ṩ�������У�������ա�");
		this.getContext().put("flag", "2");
		this.backURL = "pub_index.action";
		return "success";
	}
	 
	
	/**
	 * ��ʾ��ҵ��λע��ҳ��
	 * @return
	 * @throws Exception
	 */
	public String companyRegister() throws Exception {
		return "companyRegister";
	}
	
	/**
	 * ��֤��Ŀ���赥λ��֯��������
	 * @return
	 * @throws Exception
	 */
	public String checkConstructConcode() throws Exception {
		Construct tmp=this.constructService.findByConcode(construct.getConcode());
		String msg = "ok";
		if(tmp != null) {
			msg = "err";
		}
		this.writeToResponse(msg);
		return null;
	}
	
	/**
	 * ��֤��Ŀ���赥λע����
	 * @return
	 * @throws Exception
	 */
	public String checkConstructCode() throws Exception {

			Construct tmp = this.constructService.findByCode(construct.getCode());
			String msg = "ok";
			if(tmp != null) {
				msg = "err";
			}
			this.writeToResponse(msg);
		
		return null;
	}
	/**
	 * ��֤����ע����
	 * @return
	 * @throws Exception
	 */
	public String checkPersonCode()  throws Exception {
		String msg = "ok";
		this.writeToResponse(msg);
		return null;
	}
	
	/**
	 * ��֤��ҵע����
	 * @return
	 * @throws Exception
	 */
	public String checkCompanyCode()  throws Exception {
		String msg = "ok";
		this.writeToResponse(msg);
		return null;
	}
	/**
	 * 
	 *��֤��Ŀ���赥λemail
	 * @return
	 * @throws Exception
	 */
	public String checkConstructEmail() throws Exception {
		Construct tmp = this.constructService.findByEmail(construct.getEmail());
		String msg = "ok";
		if(tmp != null) {
			msg = "err";
		}
		this.writeToResponse(msg);
		return null;
	}
	
	/**
	 * ��������
	 * @return
	 * @throws Exception
	 */
	public String showPassword() throws Exception {
		return "showPassword";
	}
	
	public String subPassword() throws Exception {
		User user = null;
		Construct construct = null;
		
		String email = model.getEmail();
		
		if(0 == model.getState()) { //������������
			user = userService.findByCode(model.getCode()) ;
		}
		//�ж��ʻ��Ƿ���Ч
		if(0 == model.getState()) {
			if(user.getState() != 1) {
				message="���ʺ��Ѿ������ã�����ϵͳ����Ա��ϵ��";
				return "success";
			}else if(!email.equals(user.getEmail())){
				message="�������˺Ų�ƥ�䣬����ϵͳ����Ա��ϵ��";
				return "success";
			}
		} else if(1 == model.getState()) {
		} else if(2 == model.getState()){
		} else if(3 == model.getState()){
			if(construct.getState() != 1) {
				message="���ʺ���δ����ͨ��������ϵͳ����Ա��ϵ��";
				return "success";
			} else if(construct.getValidState() != 1) {
				message="���ʺ��Ѿ������ã�����ϵͳ����Ա��ϵ��";
				return "success";
			}else if(!email.equals(construct.getEmail())){
				message="�������˺Ų�ƥ�䣬����ϵͳ����Ա��ϵ��";
				return "success";
			}
		}
		
		String type = "user";
		if(model.getState() == 1)
			type = "company";
		else if(model.getState() == 2)
			type = "person";
		else if(model.getState() == 3)
			type = "construct";
		String emailTemplateName = this.getApplicationContextRealPath() + Constants.EMAIL_TEMPLATE_NAME;
		this.indexService.takeBakePassword(type, model.getCode(), emailTemplateName);
		
		message="ϵͳ�ѽ����뷢�͵����������У���ע����գ�лл��";
		this.backURL = "pub_index.action";
		return "success";
	}
	
	public String getWelcome() {
		return welcome;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public NoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	
	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}


	public NewsCatelogService getNewsCatelogService() {
		return newsCatelogService;
	}

	public void setNewsCatelogService(NewsCatelogService newsCatelogService) {
		this.newsCatelogService = newsCatelogService;
	}
	
	/**
	 * ����������Ŀ����������ʾ�Ķ���ҳ��
	 */
	
	public String listNewsByCatelogId() throws Exception {
		Site site = this.getSiteFromSession();
		if(site==null || "".equals(site.getCode())){
			message="1";
			return this.index();
		}
		NewsCatelog newsCatelog = this.newsCatelogService.findById(catelogId);
		this.getContext().put("newsCatelog", newsCatelog);
		this.pageInfo = this.newsService.findPageByNewsCatelogId(catelogId, this.getPageNo(), this.getMaxPageSize());
		return "listNews";
	}
	
	public String listMoreNotice() throws Exception {	
		Site site = this.getSiteFromSession();
		if(site==null || "".equals(site.getCode())){
			message="1";
			return this.index();
		}
		this.pageInfo = this.noticeService.findParentNotice("",this.getPageNo(), this.getMaxPageSize(),site);
		temp=2;
		return "listNews";
	}
	private String title;
	private int prostate=0;
	private int post = 0;

	public int getPost() {
		return post;
	}

	public void setPost(int post) {
		this.post = post;
	}

	public int getProstate() {
		return prostate;
	}

	public void setProstate(int prostate) {
		this.prostate = prostate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String searchAll() throws Exception {
		String  sitecode=searchSiteCode;
		Site site=siteService.findByCode(sitecode);
		if(title != null)
			this.getSession().put("pub_title", title);
		else
			title = (String)this.getSession().get("pub_title");
		if(title==null){
			title="";
		}
		if(title.equals("��������Ҫ�����Ĺؼ���......")){
			title="";
		}
		if(id==1){
			message="3";
			this.prostate=1;
			this.pageInfo = this.noticeService.findParentNotice(title, this.getPageNo(), this.getMaxPageSize(),site);
			return "listNotice";
		}else if(id==2){
			message="3";
			this.prostate=2;
			NewsCatelog newsCatelog = this.newsCatelogService.findById(18);
			this.getContext().put("newsCatelog", newsCatelog);
			this.pageInfo = this.newsService.quickSearch(18,title, this.getPageNo(), this.getMaxPageSize());
			return "listNews";
		}else if(id==3){
			message="4";
			this.pageInfo = projectApproveDetailService.findPublicAllByName(this.getPageNo(), this.getMaxPageSize(), site, title);
			this.prostate=3;
			return "projectPublicList";
		}else if(id==4){
			message="4";
			this.prostate=4;
			this.pageInfo = projectConstructService.findPublicAllByName(this.getPageNo(), this.getMaxPageSize(), site, title);
			return "projectPublicList";
		}else if(id==5){
			message="4";
			this.prostate=5;
			this.pageInfo = projectLandService.findPublicAllByName(this.getPageNo(), this.getMaxPageSize(), site, title);
			return "projectPublicList";
		}else if(id==12){
			message="4";
			this.prostate=12;
			this.pageInfo = projectMiningService.findPublicAllByName(this.getPageNo(), this.getMaxPageSize(), site, title);
			return "projectPublicList";
		}else if(id==6){
			message="5";
			this.prostate=6;
			
			return "creditComPublicList";
		}else if(id==7){
			message="5";
			this.prostate=7;
			return "creditComPublicList";
		}else if(id==8){
			message="5";
			this.prostate=8;
			return "creditComPublicList";
		}else if(id==9){
			message="5";
			this.prostate=9;
			
			return "creditComPublicList";
		}else if(id==10){
			message="5";
			this.prostate=10;
			
			return "creditComPublicList";
		}else if(id==11){
			message="4";
			this.prostate=11;
			this.pageInfo=projectAimService.findPublicAllByName(this.getPageNo(), this.getMaxPageSize(), site, title);
			
			return "projectPublicList";
		}
		return null;
	}
	public Integer getCatelogId() {
		return catelogId;
	}

	public void setCatelogId(Integer catelogId) {
		this.catelogId = catelogId;
	}


	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}


	public ProjectConstructService getProjectConstructService() {
		return projectConstructService;
	}

	public void setProjectConstructService(
			ProjectConstructService projectConstructService) {
		this.projectConstructService = projectConstructService;
	}

	public ProjectLandService getProjectLandService() {
		return projectLandService;
	}

	public void setProjectLandService(ProjectLandService projectLandService) {
		this.projectLandService = projectLandService;
	}


	public ProjectApproveService getProjectApproveService() {
		return projectApproveService;
	}

	public void setProjectApproveService(ProjectApproveService projectApproveService) {
		this.projectApproveService = projectApproveService;
	}


	public ComplaintService getComplaintService() {
		return complaintService;
	}

	public void setComplaintService(ComplaintService complaintService) {
		this.complaintService = complaintService;
	}

	
	public void prepare() throws Exception {
		
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

	
	public IndexService getIndexService() {
		return indexService;
	}

	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}


	public String getPasswordType() {
		return passwordType;
	}


	public void setPasswordType(String passwordType) {
		this.passwordType = passwordType;
	}
	public String getFailType() {
		return failType;
	}

	public void setFailType(String failType) {
		this.failType = failType;
	}

	
	public String getAlexaData() throws Exception{
		String type = "ʡֱ��λ";
		if("1".equals(this.message)){
			type = "ʡֱ��λ";
		}else if("2".equals(this.message)){
			type = "��������";
		}else if("3".equals(this.message)){
			type = "�ߵ�ԺУ";
		}else if("4".equals(this.message)){
			type = "��ʡ(�С���)";
		}else if("5".equals(this.message)){
			type = "���벿ί";
		}else if("6".equals(this.message)){
			type = "������վ";
		}
		List<Alexa> alexaList = this.alexaService.getAlexaByType(type);
		this.getContext().put("alexaList", alexaList);
		return "showAlexaData";
	}
	
	/**
	 * ���ϵ���Ŀ��������ץȡ���ݵ��뵽��Ŀ��������
	 */
//	private HttpClient httpClient = new HttpClient();
	
	public String dataImport() throws Exception {
		if("shenpi".equals(message)) { //������Ŀ������Ϣ
			importApproveData();
		//} else { //������Ŀ���������Ϣ
//			importBuildData();
//			improtApprove();
		}
		return null;
	}

	private void improtApprove(){
		List<Project> projectList = this.projectService.findAll();
		for(Project project : projectList){
			ProjectApprove projectApprove = new ProjectApprove();
			projectApprove.setState(1);
			//projectApprove.setProject(project);
			this.projectApproveService.merge(projectApprove);
		}
		return ;
	}

	private void importBuildData() throws InterruptedException, IOException,
			HttpException, Exception {
//		this.saveBuildInfo("http://www.ahxmgk.gov.cn/web/buildView.jsp?strId=127789058864198");
//		if(true)
//		return ;
		int pageCount = 51;//51;
		for(int i =1; i <= pageCount; i++) {
			//�����Ե�1ҳΪ��
			String url = "http://www.ahxmgk.gov.cn/web/projectlist.jsp?iFlag=1&PageSizeIndex=" + i;
			HttpClient httpClient = new HttpClient();
			Thread.sleep(5000);
			GetMethod method = new GetMethod(url);
			try {
				int statusCode = httpClient.executeMethod(method);
				 if (statusCode != HttpStatus.SC_OK) {
					 log.error("Method failed: " + method.getStatusLine());
					 log.info("%%%%%%����ʧ�����ݣ�"+url);
					 return;
				 }
				 
				 BufferedReader br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
				 StringBuffer strBuf = new StringBuffer();
				 String tmp = "";
				 while((tmp = br.readLine()) != null) {
					 strBuf.append(tmp);
				 }
				 
				 String body = strBuf.toString();
				 
//				log.info(body);
				//����������ʽ��������
				String regex = "'buildView\\.jsp\\?strId=\\d+'";
				Pattern pattern = Pattern.compile(regex);
				Matcher mat = pattern.matcher(body);
				ArrayList<String> urlList = new ArrayList<String>();
				while(mat.find()) {
					String group = mat.group();
//					log.info(group);
					String str = group.substring(group.indexOf("=") + 1, group.length()-1);
					urlList.add(str);
				}
				log.info("#########################���ڵ����"+i+"ҳ##########################");
				//ץȡÿһ����Ŀ�Ľ��������Ϣ
				for(String s : urlList) {
					String proUrl = "http://www.ahxmgk.gov.cn/web/buildView.jsp?strId=" +s;
//					log.info("��Ŀ���������Ϣ�� " + s + "�����ݣ�");
					Thread.sleep(3000);
					this.saveBuildInfo(proUrl);
				}
				
			} finally {
				method.releaseConnection();
			}
		}
	}

	private void importApproveData() throws InterruptedException, IOException,
			HttpException, Exception {
		
//		this.saveApproveInfo("http://www.ahxmgk.gov.cn/web/pjcView.jsp?strId=127736161578948");
//		if(true)return;
		
		
		int pageCount =142;
		for(int i =1; i <= pageCount; i++) {
			//�����Ե�1ҳΪ��
			String url = "http://www.ahxmgk.gov.cn/web/projectlist.jsp?iFlag=0&PageSizeIndex=" + i;
			HttpClient httpClient = new HttpClient();
			Thread.sleep(5000);
			GetMethod method = new GetMethod(url);
			try {
				int statusCode = httpClient.executeMethod(method);
				 if (statusCode != HttpStatus.SC_OK) {
					 log.error("Method failed: " + method.getStatusLine());
					 return;
				 }
				 
				 BufferedReader br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
				 StringBuffer strBuf = new StringBuffer();
				 String tmp = "";
				 while((tmp = br.readLine()) != null) {
					 strBuf.append(tmp);
				 }
				 
				 String body = strBuf.toString();
				 
//				log.info(body);
				//����������ʽ��������
				String regex = "'pjcView\\.jsp\\?strId=\\d+'";
				Pattern pattern = Pattern.compile(regex);
				Matcher mat = pattern.matcher(body);
				ArrayList<String> urlList = new ArrayList<String>();
				while(mat.find()) {
					String group = mat.group();
//					log.info(group);
					String str = group.substring(group.indexOf("=") + 1, group.length()-1);
					urlList.add(str);
				}
				log.info("#########################���ڵ�����Ŀ������Ϣ ��"+i+"ҳ##########################");
				//ץȡÿһ����Ŀ��������Ϣ
				for(String s : urlList) {
					String proUrl = "http://www.ahxmgk.gov.cn/web/pjcView.jsp?strId=" +s;
//					log.info("��Ŀ������Ϣ�� " + s + "�����ݣ�");
					Thread.sleep(3000);
//					this.saveApproveInfo(proUrl);
					this.saveApproveInfoNew(proUrl);
					
				}
			} finally {
				method.releaseConnection();
			}
		}
	}
	private void saveApproveInfoNew(String url) throws Exception {
		HttpClient httpClient = new HttpClient();
		GetMethod method = new GetMethod(url);
		try {
			int statusCode = httpClient.executeMethod(method);
			 if (statusCode != HttpStatus.SC_OK) {
				 log.error("Method failed: " + method.getStatusLine());
				 return;
			 }
			 
			 BufferedReader br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
			 StringBuffer strBuf = new StringBuffer();
			 String tmp = "";
			 while((tmp = br.readLine()) != null) {
				 strBuf.append(tmp);
				 strBuf.append("\r\n");
			 }
			 
			 String body = strBuf.toString();
			 int start = body.indexOf("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"showtable\">");
			 String test = body.substring(start, body.length());
			 int end = test.indexOf("</table>");
			 String res = test.substring(0,end+8);
			
			 start = res.indexOf("<tr") +2;
			 start = res.indexOf("<tr", start) +2;
			 start = res.indexOf("<tr", start) +2;
			 if(start<0){
				 tmp = "";
			 }else{
				 start = res.indexOf("<tr", start) +2;
			 }
			 //5th tr
			 if(start<0){
				 tmp = "";
			 }else{
				 start = res.indexOf("<tr", start);
			 }
			 if(start<0){
				 tmp = "";
			 }else{
				 tmp = res.substring(start, res.indexOf("</table"));
				 tmp = "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"showtable\">"+tmp+"</table>";
				 tmp = tmp.replaceAll("style=\"background:#E5F3FF\"", " ");
			 }
			 
//			 log.info("body: \n" + body);
			//����������ʽ��������
			String regex = "<td class=\\\"lt\\\">\\&nbsp;\\s*\\S*</td>";
			Pattern pattern = Pattern.compile(regex);
			Matcher mat = pattern.matcher(body);
			ArrayList<String> strList = new ArrayList<String>();
			
			while(mat.find()) {
				String group = mat.group();
//				log.info(group);
				strList.add(group);
			}

			regex = "<td width=\\\"69%\\\" class=\\\"lt\\\">\\&nbsp;\\s*\\S*</td>";
			pattern = Pattern.compile(regex);
			mat = pattern.matcher(body);
			while(mat.find()) {
				String group = mat.group();
//				log.info(group);
				strList.add(group);
			}
			
			Map<String, String> map = new HashMap<String, String>(strList.size());
			//���赥λ
			map.put("deptName", this.parseString(strList.get(0)));
			//��Ŀ����
			map.put("projectName", this.parseString(strList.get(1))); 

			map.put("code", this.parseString(strList.get(strList.size()-1)));
//			if(strList.size() > 3) {
//				//������λ
//				map.put("approveName", this.parseString(strList.get(4)));
//				//�����ĺ�
//				map.put("approveCode", this.parseString(strList.get(5)));
//				//����ʱ��
//				map.put("approveDate", this.parseString(strList.get(6)));
//				//�����ģ
//				map.put("scale", this.parseString(strList.get(7)));
//				//�����ʽ�
//				map.put("money", this.parseString(strList.get(8)));
//				//����ص�
//				map.put("address", this.parseString(strList.get(9)));
//				//��ֹʱ��
//				map.put("time", this.parseString(strList.get(11)));
//			}
			//������д�����ݿ���
			//��ӡ���ݲ鿴Ч��
//			Set<String> keySet = map.keySet();
//			for(String key : keySet) {
//				log.info(key + ":" + map.get(key));
//			}
			
			if("".equals(map.get("deptName").trim())){
				log.info("######����ʧ������URL��"+url);
				return ;
			}
			

			ProjectApprove projectApprove = new ProjectApprove();
			projectApprove.setCode(map.get("code"));
			//projectApprove.setTitle(map.get("projectName"));
			projectApprove.setName(map.get("projectName"));
			//projectApprove.setConstructName(map.get("constructName"));
//			projectApprove.setSite(site)
//			projectApprove.setFeasibility(tmp);
//			projectApprove.setProject(project);
			projectApprove.setState(1);
			//projectApprove.setRemarks(res);
			this.projectApproveService.merge(projectApprove);
			
			if(temp>9){
				temp = 0;
			}
			
//			log.info("       projectName:"+project.getName());
//			log.info("       projectCode:"+project.getCode());
//			log.info("projectCompanyName:"+project.getCompany().getName());
//			log.info("projectDistrictName:"+project.getDistrict().getName());
		}catch (Exception e) {
			log.info("******����ʧ������URL��"+url);
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
	}
	//������Ŀ������Ϣ
	private void saveApproveInfo(String url) throws Exception {
		HttpClient httpClient = new HttpClient();
		GetMethod method = new GetMethod(url);
		try {
			int statusCode = httpClient.executeMethod(method);
			 if (statusCode != HttpStatus.SC_OK) {
				 log.error("Method failed: " + method.getStatusLine());
				 return;
			 }
			 
			 BufferedReader br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
			 StringBuffer strBuf = new StringBuffer();
			 String tmp = "";
			 while((tmp = br.readLine()) != null) {
				 strBuf.append(tmp);
				 strBuf.append("\r\n");
			 }
			 
			 String body = strBuf.toString();
			 int start = body.indexOf("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"showtable\">");
			 String test = body.substring(start, body.length());
			 int end = test.indexOf("</table>");
			 String res = test.substring(0,end+8);
			
			 start = res.indexOf("<tr") +2;
			 start = res.indexOf("<tr", start) +2;
			 start = res.indexOf("<tr", start) +2;
			 if(start<0){
				 tmp = "";
			 }else{
				 start = res.indexOf("<tr", start) +2;
			 }
			 //5th tr
			 if(start<0){
				 tmp = "";
			 }else{
				 start = res.indexOf("<tr", start);
			 }
			 if(start<0){
				 tmp = "";
			 }else{
				 tmp = res.substring(start, res.indexOf("</table"));
				 tmp = "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"showtable\">"+tmp+"</table>";
				 tmp = tmp.replaceAll("style=\"background:#E5F3FF\"", " ");
			 }
			 
//			 log.info("body: \n" + body);
			//����������ʽ��������
			String regex = "<td class=\\\"lt\\\">\\&nbsp;\\s*\\S*</td>";
			Pattern pattern = Pattern.compile(regex);
			Matcher mat = pattern.matcher(body);
			ArrayList<String> strList = new ArrayList<String>();
			
			while(mat.find()) {
				String group = mat.group();
//				log.info(group);
				strList.add(group);
			}
			
			Map<String, String> map = new HashMap<String, String>(strList.size());
			//���赥λ
			map.put("deptName", this.parseString(strList.get(0)));
			//��Ŀ����
			map.put("projectName", this.parseString(strList.get(1))); 
			
			if(strList.size() > 3) {
				//������λ
				map.put("approveName", this.parseString(strList.get(4)));
				//�����ĺ�
				map.put("approveCode", this.parseString(strList.get(5)));
				//����ʱ��
				map.put("approveDate", this.parseString(strList.get(6)));
				//�����ģ
				map.put("scale", this.parseString(strList.get(7)));
				//�����ʽ�
				map.put("money", this.parseString(strList.get(8)));
				//����ص�
				map.put("address", this.parseString(strList.get(9)));
				//��ֹʱ��
				map.put("time", this.parseString(strList.get(11)));
			}
			//������д�����ݿ���
			//��ӡ���ݲ鿴Ч��
//			Set<String> keySet = map.keySet();
//			for(String key : keySet) {
//				log.info(key + ":" + map.get(key));
//			}
			
			if("".equals(map.get("deptName").trim())){
				log.info("######����ʧ������URL��"+url);
				return ;
			}
			
			
			District district = new District();
			if(map.size()>10){
				district = this.districtService.findByName(map.get("address"));
			}
			if(district.getCode() == null || "".equals(district.getCode())){
				district = districtService.findByCode("340000");
			}
			Project project = new Project();
//			List<Project> projectList = this.projectService.findByName(map.get("projectName"));
//			if(projectList.size()>0){
//				project = projectList.get(0);
//			}else{
				project.setName(map.get("projectName"));
				project.setDistrict(district);
				project.setState(1);
				project.setCreateTime(new Date());
//			}
//			this.projectService.merge(project);
			
			ProjectApprove projectApprove = new ProjectApprove();
			//projectApprove.setFeasibility(tmp);
			//projectApprove.setProject(project);
			projectApprove.setState(1);
			this.projectApproveService.merge(projectApprove);
			
			if(temp>9){
				temp = 0;
			}
			
//			log.info("       projectName:"+project.getName());
//			log.info("       projectCode:"+project.getCode());
//			log.info("projectCompanyName:"+project.getCompany().getName());
//			log.info("projectDistrictName:"+project.getDistrict().getName());
		}catch (Exception e) {
			log.info("******����ʧ������URL��"+url);
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
	}
	
	private String parseString(String str) {
		String tmp = "";
		int beginIndex = str.indexOf("&nbsp;") + 6;
		int endIndex = str.indexOf("</td>");
		if(beginIndex < endIndex) {
			tmp = str.substring(beginIndex, endIndex);
		}
		return tmp;
	}
	
	//���潨�������Ϣ
	private void saveBuildInfo(String url) throws Exception {
		HttpClient httpClient = new HttpClient();
		GetMethod method = new GetMethod(url);
		try {
			int statusCode = httpClient.executeMethod(method);
			 if (statusCode != HttpStatus.SC_OK) {
				 log.error("Method failed: " + method.getStatusLine());
				 log.info("%%%%%%����ʧ�����ݣ�"+url);
				 return;
			 }
			 
			 BufferedReader br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
			 StringBuffer strBuf = new StringBuffer();
			 String tmp = "";
			 while((tmp = br.readLine()) != null) {
				 strBuf.append(tmp);
			 }
			 
			 String body = strBuf.toString();
//			 log.info("body: \n" + body);
			//����������ʽ��������
			String regex = "<td class=\\\"lt\\\" colspan=\\\"4\\\">\\&nbsp;\\s*\\S*</td>";
			Pattern pattern = Pattern.compile(regex);
			Matcher mat = pattern.matcher(body);
			ArrayList<String> strList = new ArrayList<String>();
			
			while(mat.find()) {
				String group = mat.group();
//				log.info(group);
				strList.add(group);
			}
			
			Map<String, String> map = new HashMap<String, String>(strList.size());
			//��Ŀ(����)��λ����
			map.put("deptName", this.parseString(strList.get(0)));
			//��Ŀ����
			map.put("projectName", this.parseString(strList.get(1))); 
			int a = 0 ;
			if(strList.size()<8){
				a = -1 ;
			}
			//Ͷ�ʹ�ģ
			map.put("money", this.parseString(strList.get(3+a)));
			//��Ŀ����
			map.put("projectManager", this.parseString(strList.get(4+a)));
			//���赥λ
			map.put("buildDept", this.parseString(strList.get(5+a)));
			//�ν���λ
			map.put("buildDept2", this.parseString(strList.get(6+a)));
			//��Ŀ��ʼʱ��
			map.put("beginTime", this.parseString(strList.get(7+a)));
			//��Ŀ����ʱ��
			map.put("endTime", this.parseString(strList.get(8+a)));
			
			
			//������д�����ݿ���
			//��ӡ���ݲ鿴Ч��
//			Set<String> keySet = map.keySet();
//			for(String key : keySet) {
//				log.info(key + ":" + map.get(key));
//			}
			
			Project project  = this.projectService.findProjectByName(map.get("projectName"));
			if(project != null && !"".equals(project.getName())){
				BaseInfo baseInfo = new BaseInfo();
				if(!"".equals(map.get("beginTime").trim())){
					baseInfo.setConstructBeginDate(DateTypeConvert.stringToDate(map.get("beginTime").trim()));
				}
				if(!"".equals(map.get("endTime").trim())){
					baseInfo.setConstructEndDate(DateTypeConvert.stringToDate(map.get("endTime").trim()));
				}
				baseInfo.setManager(map.get("projectManager"));
				baseInfo.setOtherCompanys(map.get("buildDept2"));
				baseInfo.setConstructCompany(map.get("buildDept"));
				if(!"".equals(map.get("money").trim())){
					baseInfo.setMoney(Double.valueOf(map.get("money").trim()));
				}
				ProjectConstruct projectConstruct = new ProjectConstruct();
//				projectConstruct.setProject(project);
				projectConstruct.setBaseInfo(baseInfo);
				projectConstruct.setState(1);
				projectConstructService.merge(projectConstruct);
				
//				log.info("       projectName:"+projectConstruct.getProject().getName());
//				log.info("       companyName:"+projectConstruct.getProject().getCompany().getName());
//				log.info("    projectManager:"+projectConstruct.getBaseInfo().getManager());
			}else{
				log.info("@@@@@@����ʧ�����ݣ�"+url);
			}
			
			
		}catch (Exception e) {
			log.info("******����ʧ�����ݣ�"+url);
		} finally {
			method.releaseConnection();
		}
	}

	
	public HomePageService getHomePageService() {
		return homePageService;
	}

	public void setHomePageService(HomePageService homePageService) {
		this.homePageService = homePageService;
	}

	public AttachFileService getAttachFileService() {
		return attachFileService;
	}

	public void setAttachFileService(AttachFileService attachFileService) {
		this.attachFileService = attachFileService;
	}

	public ScolumnService getScolumnService() {
		return scolumnService;
	}

	public void setScolumnService(ScolumnService scolumnService) {
		this.scolumnService = scolumnService;
	}

	public SiteService getSiteService() {
		return siteService;
	}

	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}



}

