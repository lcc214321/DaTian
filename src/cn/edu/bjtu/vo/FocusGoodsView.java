package cn.edu.bjtu.vo;

// Generated 2015-2-22 16:45:18 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * CarCarrierViewId generated by hbm2java
 */
@Component
public class FocusGoodsView implements java.io.Serializable {

	private String id;
	private String clientId;
	private String focusType;
	private String focusId;
	private String status;
	private String name;
	private Date relDate;
	
	public FocusGoodsView() {
	}

	public FocusGoodsView(String id) {
		this.id = id;
	}

	public FocusGoodsView(String id, String clientId, String focusType,
			String focusId, String status, String name, Date relDate) {
		this.id = id;
		this.clientId = clientId;
		this.focusType = focusType;
		this.focusId = focusId;
		this.status = status;
		this.name = name;
		this.relDate = relDate;
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getFocusType() {
		return this.focusType;
	}

	public void setFocusType(String focusType) {
		this.focusType = focusType;
	}

	public String getFocusId() {
		return this.focusId;
	}

	public void setFocusId(String focusId) {
		this.focusId = focusId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRelDate() {
		return this.relDate;
	}

	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

}