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
 * 权限表
 * @author guanjm
 *
 */
@Entity
@Table(name = "T_PERMISSION", schema = "HOUSE")
@SuppressWarnings("serial")
public class TbPermission implements Serializable {
	
	/**
	 * 权限id
	 */
	private Integer id;
	
	/**
	 * 权限名
	 */
	private String permissionName;
	
	/**
	 * 权限类型
	 */
	private Integer permissionType;
	
	/**
	 * 父权限id
	 */
	private Integer fatherId;
	
	/**
	 * 权限描述
	 */
	private String desription;
	
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissionSequence")  
	@SequenceGenerator(name = "permissionSequence", initialValue = 1, allocationSize = 1, sequenceName = "T_PERMISSION_SEQUENCE") 
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	@Column(name = "PERMISSION_NAME")
	public String getPermissionName() {
		return permissionName;
	}

	@Column(name = "PERMISSION_TYPE")
	public Integer getPermissionType() {
		return permissionType;
	}

	@Column(name = "FATHER_ID")
	public Integer getFatherId() {
		return fatherId;
	}

	@Column(name = "DESCRIPTION")
	public String getDesription() {
		return desription;
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

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public void setPermissionType(Integer permissionType) {
		this.permissionType = permissionType;
	}

	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}

	public void setDesription(String desription) {
		this.desription = desription;
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
