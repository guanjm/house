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
 * 角色表
 * @author guanjm
 *
 */
@Entity
@Table(name = "T_ROLE", schema = "HOUSE")
@SuppressWarnings("serial")
public class TbRole implements Serializable {
	
	/**
	 * 角色id
	 */
	private Integer id;
	
	/**
	 * 角色名
	 */
	private String roleName;
	
	/**
	 * 角色描述
	 */
	private String description;
	
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSequence")  
	@SequenceGenerator(name = "roleSequence", initialValue = 1, allocationSize = 1, sequenceName = "T_ROLE_SEQUENCE") 
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	@Column(name = "ROLE_NAME")
	public String getRoleName() {
		return roleName;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
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

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setDescription(String description) {
		this.description = description;
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
