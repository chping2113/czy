package com.kjlink.ahpips.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@Entity
@Table(name = "t_bid_info")//�б�Ͷ����Ϣ��
public class BidInfo implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Lob
	@Column(name = "bid_item")
	private String bidItem ; //�б�����
	
	@Lob
	@Column(name = "bid_notice")
	private String bidNotice ; //�б깫��
	
	@Lob
	@Column(name = "bid_apporve")
	private String bidApporve ; //Ͷ���ʸ�Ԥ�󹫸�
	
	@Lob
	@Column(name = "bid_result")
	private String bidResult ; //�б���

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBidItem() {
		return bidItem;
	}

	public void setBidItem(String bidItem) {
		//this.bidItem = bidItem;
		this.bidItem = Jsoup.clean(bidItem, Whitelist.basic());
	}

	public String getBidNotice() {
		return bidNotice;
	}

	public void setBidNotice(String bidNotice) {
		//this.bidNotice = bidNotice;
		this.bidNotice = Jsoup.clean(bidNotice, Whitelist.basic());
	}

	public String getBidApporve() {
		return bidApporve;
	}

	public void setBidApporve(String bidApporve) {
		//this.bidApporve = bidApporve;
		this.bidApporve = Jsoup.clean(bidApporve, Whitelist.basic());
	}

	public String getBidResult() {
		return bidResult;
	}

	public void setBidResult(String bidResult) {
		//this.bidResult = bidResult;
		this.bidResult = Jsoup.clean(bidResult, Whitelist.basic());
	}
}
