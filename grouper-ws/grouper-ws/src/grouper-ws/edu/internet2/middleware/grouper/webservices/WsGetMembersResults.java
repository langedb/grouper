package edu.internet2.middleware.grouper.webservices;

/**
 * <pre>
 * results for the get members call.
 * 
 * result code:
 * code of the result for this group overall
 * SUCCESS: means everything ok
 * GROUP_NOT_FOUND: cant find the group
 * INVALID_QUERY: bad inputs
 * EXCEPTION: something bad happened
 * </pre>
 * @author mchyzer
 */
public class WsGetMembersResults {

	/** if attributes are being sent back per config in the grouper-ws.properties, this is attribute0 name */
	public String attributeName0;
	
	/** if attributes are being sent back per config in the grouper-ws.properties, this is attribute1 name */
	public String attributeName1;
	
	/** if attributes are being sent back per config in the grouper-ws.properties, this is attribute2 name */
	public String attributeName2;
	
	
	/**
	 * result code of a request
	 */
	public enum WsGetMembersResultCode {
		
		/** found the subject */
		SUCCESS, 
		
		/** something bad happened */
		EXCEPTION, 
		
		/** invalid query (e.g. if everything blank) */
		INVALID_QUERY;
				
		/**
		 * if this is a successful result
		 * @return true if success
		 */
		public boolean isSuccess() {
			return this == SUCCESS;
		}
	}
	
	/**
	 * assign the code from the enum
	 * @param getMembersResultCode
	 */
	public void assignResultCode(WsGetMembersResultCode getMembersResultCode) {
		this.setResultCode(getMembersResultCode == null ? null : getMembersResultCode.name());
		this.setSuccess(getMembersResultCode.isSuccess() ? "T" : "F");
	}
	
	/**
	 * error message if there is an error
	 */
	private StringBuilder resultMessage = new StringBuilder();
	
	/**
	 * results for each assignment sent in
	 */
	private WsGetMembersResult[] results;

	/** T or F as to whether it was a successful assignment */
	private String success;

	/** 
	 * <pre>
	 * code of the result for this subject
	 * SUCCESS: means everything ok
	 * SUBJECT_NOT_FOUND: cant find the subject
	 * SUBJECT_DUPLICATE: found multiple subjects
	 *  
	 * </pre>
	 */
	private String resultCode;

	/**
	 * results for each assignment sent in
	 * @return the results
	 */
	public WsGetMembersResult[] getResults() {
		return this.results;
	}

	/**
	 * results for each assignment sent in
	 * @param results1 the results to set
	 */
	public void setResults(WsGetMembersResult[] results1) {
		this.results = results1;
	}

	/**
	 * error message if there is an error
	 * @return the errorMessage
	 */
	public String getResultMessage() {
		return this.resultMessage.toString();
	}
	
	/**
	 * append error message to list of error messages
	 * @param errorMessage
	 */
	public void appendResultMessage(String errorMessage) {
		this.resultMessage.append(errorMessage);
	}
	
	/**
	 * error message if there is an error
	 * @param errorMessage the errorMessage to set
	 */
	public void setResultMessage(String errorMessage) {
		this.resultMessage = new StringBuilder(errorMessage);
	}

	/**
	 * T or F as to whether it was a successful assignment
	 * @return the success
	 */
	public String getSuccess() {
		return this.success;
	}

	/**
	 * T or F as to whether it was a successful assignment
	 * @param success1 the success to set
	 */
	public void setSuccess(String success1) {
		this.success = success1;
	}

	/**
	 * <pre>
	 * code of the result for this subject
	 * SUCCESS: means everything ok
	 * SUBJECT_NOT_FOUND: cant find the subject
	 * SUBJECT_DUPLICATE: found multiple subjects
	 *  
	 * </pre>
	 * @return the resultCode
	 */
	public String getResultCode() {
		return this.resultCode;
	}

	/**
	 * <pre>
	 * code of the result for this subject
	 * SUCCESS: means everything ok
	 * SUBJECT_NOT_FOUND: cant find the subject
	 * SUBJECT_DUPLICATE: found multiple subjects
	 *  
	 * </pre>
	 * @param resultCode1 the resultCode to set
	 */
	public void setResultCode(String resultCode1) {
		this.resultCode = resultCode1;
	}

	/**
	 * if attributes are being sent back per config in the grouper-ws.properties, this is attribute0 name
	 * @return the attributeName0
	 */
	public String getAttributeName0() {
		return this.attributeName0;
	}

	/**
	 * if attributes are being sent back per config in the grouper-ws.properties, this is attribute0 name
	 * @param attributeName0a the attributeName0 to set
	 */
	public void setAttributeName0(String attributeName0a) {
		this.attributeName0 = attributeName0a;
	}

	/**
	 * if attributes are being sent back per config in the grouper-ws.properties, this is attribute1 name
	 * @return the attributeName1
	 */
	public String getAttributeName1() {
		return this.attributeName1;
	}

	/**
	 * if attributes are being sent back per config in the grouper-ws.properties, this is attribute1 name
	 * @param attributeName1a the attributeName1 to set
	 */
	public void setAttributeName1(String attributeName1a) {
		this.attributeName1 = attributeName1a;
	}

	/**
	 * if attributes are being sent back per config in the grouper-ws.properties, this is attribute2 name
	 * @return the attributeName2
	 */
	public String getAttributeName2() {
		return this.attributeName2;
	}

	/**
	 * if attributes are being sent back per config in the grouper-ws.properties, this is attribute2 name
	 * @param attributeName2a the attributeName2 to set
	 */
	public void setAttributeName2(String attributeName2a) {
		this.attributeName2 = attributeName2a;
	}

}
