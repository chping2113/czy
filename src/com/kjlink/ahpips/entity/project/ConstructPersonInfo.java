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
@Table(name = "t_construct_personinfo")//��ҵ��Ա��Ϊ��Ϣ
public class ConstructPersonInfo  implements java.io.Serializable{
	
		@Id
		@GeneratedValue(generator = "paymentableGenerator")       
		@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
		private Integer id;
		
		
		@Lob
		@Column(name="person_honor")
		private String personHonor ;//������Ϊ��Ϣ
		@Lob
		@Column(name="person_badrecord")
		private String personBadrecord ;//������Ϊ��Ϣ
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getPersonHonor() {
			return personHonor;
		}
		public void setPersonHonor(String personHonor) {
			//this.personHonor = personHonor;
			this.personHonor = Jsoup.clean(personHonor, Whitelist.basic());
		}
		public String getPersonBadrecord() {
			return personBadrecord;
		}
		public void setPersonBadrecord(String personBadrecord) {
			//this.personBadrecord = personBadrecord;
			this.personBadrecord = Jsoup.clean(personBadrecord, Whitelist.basic());
		}
		
}
