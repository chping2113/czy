package com.kjlink.ahpips.entity.project;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.kjlink.ahpips.entity.system.Construct;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.common.util.ConvertHtml;

@Entity
@Table(name = "t_project_construct")//��Ŀ���������Ϣ��
public class ProjectConstruct implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length = 40)
	private String code; //��Ŀ����
	
	@Column(length = 100)
	private String name; //��Ŀ����

	@Column(length = 100)
	private String constructName; //����������Ŀ���赥λ����
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="construct_id")
	private Construct construct; //���赥λ��Ŀ���赥λ
	
//	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
//	@JoinColumn(name="project_id")
//	private Project project ;//������Ŀ
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="base_info_id")
	private BaseInfo baseInfo ;//��Ŀ������Ϣ
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="bid_info_id")
	private BidInfo bidInfo ;//�б�Ͷ����Ϣ
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="land_info_id")
	private LandInfo landInfo ;//���ز�Ǩ��Ϣ
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="changes_info_id")
	private ChangesInfo changesInfo ;//�ش���Ʊ����Ϣ
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="construt_info_id")
	private ConstrutInfo construtInfo ;//ʩ��������Ϣ
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="contract_info_id")
	private ContractInfo contractInfo ;//��ͬ��Լ��Ϣ
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="safe_check_info_id")
	private SafeCheckInfo safeCheckInfo ;//������ȫ�����Ϣ
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="money_info_id")
	private MoneyInfo moneyInfo ;//�ʽ������Ϣ
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="acceptance_info_id")
	private AcceptanceInfo acceptanceInfo ;//������������Ϣ
	
	

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="audit_statistics_id")
	private AuditStatistics auditStatistics ;//���ͳ�ƽ����Ϣ
	
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="constructcompany_info_id")
	private ConstructCompanyInfo constructCompanyInfo ;//��ҵ��λ��Ϊ��Ϣ
	
	
	

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="constructperson_info_id")
	private ConstructPersonInfo constructPersonInfo ;//��ҵ��Ա��Ϊ��Ϣ
	
	private Integer state = 0; //���״̬��0��δ��ˣ�1�����ͨ����2�����δͨ����3���ύ���
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="site_id")
	private Site site;	//��������
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime = new Date(); //����ʱ��

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="user_id")
	private User approveUser;//�����Ա
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(updatable = false,name="create_user_id")
	private User createUser;//������Ա

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	private Integer approveType=0;
	
	public Integer getApproveType() {
		return approveType;
	}

	public void setApproveType(Integer approveType) {
		this.approveType = approveType;
	}

	public User getApproveUser() {
		return approveUser;
	}

	public AuditStatistics getAuditStatistics() {
		return auditStatistics;
	}

	public void setAuditStatistics(AuditStatistics auditStatistics) {
		this.auditStatistics = auditStatistics;
	}

	public void setApproveUser(User approveUser) {
		this.approveUser = approveUser;
	}

	public String getConstructName() {
		return constructName;
	}

	public void setConstructName(String constructName) {
		//this.constructName = constructName;
		this.constructName = ConvertHtml.convertInputText(constructName);
	}

	public ConstructCompanyInfo getConstructCompanyInfo() {
		return constructCompanyInfo;
	}

	public void setConstructCompanyInfo(ConstructCompanyInfo constructCompanyInfo) {
		this.constructCompanyInfo = constructCompanyInfo;
	}

	public ConstructPersonInfo getConstructPersonInfo() {
		return constructPersonInfo;
	}

	public void setConstructPersonInfo(ConstructPersonInfo constructPersonInfo) {
		this.constructPersonInfo = constructPersonInfo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BaseInfo getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	public BidInfo getBidInfo() {
		return bidInfo;
	}

	public void setBidInfo(BidInfo bidInfo) {
		this.bidInfo = bidInfo;
	}

	public LandInfo getLandInfo() {
		return landInfo;
	}

	public void setLandInfo(LandInfo landInfo) {
		this.landInfo = landInfo;
	}

	public ChangesInfo getChangesInfo() {
		return changesInfo;
	}

	public void setChangesInfo(ChangesInfo changesInfo) {
		this.changesInfo = changesInfo;
	}

	public ConstrutInfo getConstrutInfo() {
		return construtInfo;
	}

	public void setConstrutInfo(ConstrutInfo construtInfo) {
		this.construtInfo = construtInfo;
	}

	public ContractInfo getContractInfo() {
		return contractInfo;
	}

	public void setContractInfo(ContractInfo contractInfo) {
		this.contractInfo = contractInfo;
	}

	public SafeCheckInfo getSafeCheckInfo() {
		return safeCheckInfo;
	}

	public void setSafeCheckInfo(SafeCheckInfo safeCheckInfo) {
		this.safeCheckInfo = safeCheckInfo;
	}

	public MoneyInfo getMoneyInfo() {
		return moneyInfo;
	}

	public void setMoneyInfo(MoneyInfo moneyInfo) {
		this.moneyInfo = moneyInfo;
	}

	public AcceptanceInfo getAcceptanceInfo() {
		return acceptanceInfo;
	}

	public void setAcceptanceInfo(AcceptanceInfo acceptanceInfo) {
		this.acceptanceInfo = acceptanceInfo;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		//this.code = code;
		this.code = ConvertHtml.convertInputText(code);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		//this.name = name;
		this.name = ConvertHtml.convertInputText(name);
	}

	public Construct getConstruct() {
		return construct;
	}

	public void setConstruct(Construct construct) {
		this.construct = construct;
	}
	
}
