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
 * 用户角色表
 * @author guanjm
 *
 */
@Entity
@Table(name = "T_USER_ROLE", schema = "HOUSE")
@SuppressWarnings("serial")
public class TbUserRole implements Serializable {
	
	/**
	 * 流水id
	 */
	private Integer id;
	
	/**
	 * 用户id
	 */
	private Integer user_id;
	
	/**
	 * 角色id
	 */
	private Integer role_id;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userRoleSequence")  
	@SequenceGenerator(name = "userRoleSequence", initialValue = 1, allocationSize = 1, sequenceName = "T_USER_ROLE_SEQUENCE") 
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	@Column(name = "USER_ID")
	public Integer getUser_id() {
		return user_id;
	}

	@Column(name = "ROLE_ID")
	public Integer getRole_id() {
		return role_id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
}
