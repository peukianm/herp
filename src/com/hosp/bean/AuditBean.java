package com.hosp.bean;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.model.SelectItem;

import com.hosp.entities.Auditing;
import javax.annotation.PreDestroy;

public class AuditBean {
	private List<Auditing> auditSearchResults;
	private String searchHospitalID;
	private String searchDepartmentID;
	private String searchActionID;
	private String searchUsername;
	private String searchComment;
	private Timestamp searchFromDate;
	private Timestamp searchToDate;
	private Auditing selectedAudit;
	private SelectItem[] departments;

	@PreDestroy
        public void reset (){
		auditSearchResults = null;
		searchHospitalID = null;
		searchDepartmentID = null;
		searchUsername = null;
		searchFromDate = null;
		searchToDate = null;
		selectedAudit = null;
		departments = null;
		searchActionID = null;
		searchComment = null;
	}

	public List<Auditing> getAuditSearchResults() {
		return auditSearchResults;
	}
	public void setAuditSearchResults(List<Auditing> auditSearchResults) {
		this.auditSearchResults = auditSearchResults;
	}
	public String getSearchHospitalID() {
		return searchHospitalID;
	}
	public void setSearchHospitalID(String searchHospitalID) {
		this.searchHospitalID = searchHospitalID;
	}
	public String getSearchDepartmentID() {
		return searchDepartmentID;
	}
	public void setSearchDepartmentID(String searchDepartmentID) {
		this.searchDepartmentID = searchDepartmentID;
	}
	public String getSearchUsername() {
		return searchUsername;
	}
	public void setSearchUsername(String searchUsername) {
		this.searchUsername = searchUsername;
	}
	public Timestamp getSearchFromDate() {
		return searchFromDate;
	}
	public void setSearchFromDate(Timestamp searchFromDate) {
		this.searchFromDate = searchFromDate;
	}
	public Timestamp getSearchToDate() {
		return searchToDate;
	}
	public void setSearchToDate(Timestamp searchToDate) {
		this.searchToDate = searchToDate;
	}
	public Auditing getSelectedAudit() {
		return selectedAudit;
	}
	public void setSelectedAudit(Auditing selectedAudit) {
		this.selectedAudit = selectedAudit;
	}
	public SelectItem[] getDepartments() {
		return departments;
	}
	public void setDepartments(SelectItem[] departments) {
		this.departments = departments;
	}

	public String getSearchActionID() {
		return searchActionID;
	}

	public void setSearchActionID(String searchActionID) {
		this.searchActionID = searchActionID;
	}

	public String getSearchComment() {
		return searchComment;
	}

	public void setSearchComment(String searchComment) {
		this.searchComment = searchComment;
	}
}
