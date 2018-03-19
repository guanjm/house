package gjm.house.common.account.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 角色权限表
 * @author guanjm
 *
 */
@Entity
@Table(name = "T_ROLE_PERMISSION", schema = "HOUSE")
@SuppressWarnings("serial")
public class TbRolePermission implements Serializable {
	
	/**
	 * 流水id
	 */
	private Integer id;
	
	/**
	 * 角色id
	 */
	private Integer role_id;
	
	/**
	 * 权限id
	 */
	private Integer permission_id;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rolePermissionSequence")  
	@SequenceGenerator(name = "rolePermissionSequence", initialValue = 1, allocationSize = 1, sequenceName = "T_ROLE_PERMISSION_SEQUENCE") 
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	@Column(name = "ROLE_ID")
	public Integer getRole_id() {
		return role_id;
	}

	@Column(name = "PERMISSION_ID")
	public Integer getPermission_id() {
		return permission_id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public void setPermission_id(Integer permission_id) {
		this.permission_id = permission_id;
	}
	
}
