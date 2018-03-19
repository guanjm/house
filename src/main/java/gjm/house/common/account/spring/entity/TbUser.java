package gjm.house.common.account.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 用户表
 * @author guanjm
 *
 */
@Entity
@Table(name = "T_USER", schema = "HOUSE")
@SuppressWarnings("serial")
public class TbUser implements Serializable {
	
	/**
	 * 用户id
	 */
	private Integer id;
	
	/**
	 * 账号
	 */
	private String userName;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 昵称
	 */
	private String nickname;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 手机号码
	 */
	private String mobile;
	
	/**
	 * 创建用户id
	 */
	private Integer createUserId;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 更新用户id
	 */
	private Integer updateUserId;
	
	/**
	 * 更新时间
	 */
	private Date updateDate;
	
	/**
	 * 是否失效，0：有效，1：失效
	 */
	private Integer flag;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")  
	@SequenceGenerator(name = "userSequence", initialValue = 1, allocationSize = 1, sequenceName = "T_USER_SEQUENCE") 
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	@Column(name = "USER_NAME")
	public String getUserName() {
		return userName;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	@Column(name = "NICKNAME")
	public String getNickname() {
		return nickname;
	}

	@Column(name = "SEX")
	public String getSex() {
		return sex;
	}

	@Column(name = "MOBILE")
	public String getMobile() {
		return mobile;
	}

	@Column(name = "CREATE_USER_ID")
	public Integer getCreateUserId() {
		return createUserId;
	}

	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}

	@Column(name = "UPDATE_USER_ID")
	public Integer getUpdateUserId() {
		return updateUserId;
	}

	@Column(name = "UPDATE_DATE")
	public Date getUpdateDate() {
		return updateDate;
	}

	@Column(name = "FLAG")
	public Integer getFlag() {
		return flag;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
}
