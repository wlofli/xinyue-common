package com.xinyue.manage.model;

/**
 * 上传资料信息
 * @author MK)茅
 *
 */
public class Document {

	private String documentId;
	private String documentName;
	private String documentDir;
	private String documentType;
	/**
	 * @return the documentName
	 */
	public String getDocumentName() {
		return documentName;
	}
	/**
	 * @param documentName the documentName to set
	 */
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	/**
	 * @return the documentDir
	 */
	public String getDocumentDir() {
		return documentDir;
	}
	/**
	 * @param documentDir the documentDir to set
	 */
	public void setDocumentDir(String documentDir) {
		this.documentDir = documentDir;
	}
	/**
	 * @return the documentType
	 */
	public String getDocumentType() {
		return documentType;
	}
	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	/**
	 * @return the documentId
	 */
	public String getDocumentId() {
		return documentId;
	}
	/**
	 * @param documentId the documentId to set
	 */
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
}
