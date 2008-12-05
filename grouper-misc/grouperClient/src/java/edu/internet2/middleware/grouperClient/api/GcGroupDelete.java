/*
 * @author mchyzer
 * $Id: GcGroupDelete.java,v 1.2 2008-12-05 02:24:39 mchyzer Exp $
 */
package edu.internet2.middleware.grouperClient.api;

import java.util.ArrayList;
import java.util.List;

import edu.internet2.middleware.grouperClient.util.GrouperClientUtils;
import edu.internet2.middleware.grouperClient.ws.GcTransactionType;
import edu.internet2.middleware.grouperClient.ws.GrouperClientWs;
import edu.internet2.middleware.grouperClient.ws.beans.WsGroupDeleteResults;
import edu.internet2.middleware.grouperClient.ws.beans.WsGroupLookup;
import edu.internet2.middleware.grouperClient.ws.beans.WsParam;
import edu.internet2.middleware.grouperClient.ws.beans.WsRestGroupDeleteRequest;
import edu.internet2.middleware.grouperClient.ws.beans.WsSubjectLookup;


/**
 * class to run a group delete web service call
 */
public class GcGroupDelete {

  /** delete group lookups */
  private List<WsGroupLookup> groupLookups = new ArrayList<WsGroupLookup>();
  
  /**
   * add group lookup
   * @param wsGroupLookup
   * @return this for chaining
   */
  public GcGroupDelete addGroupLookup(WsGroupLookup wsGroupLookup) {
    this.groupLookups.add(wsGroupLookup);
    return this;
  }
  
  /** params */
  private List<WsParam> params = new ArrayList<WsParam>();

  /**
   * add a param to the list
   * @param paramName
   * @param paramValue
   * @return this for chaining
   */
  public GcGroupDelete addParam(String paramName, String paramValue) {
    this.params.add(new WsParam(paramName, paramValue));
    return this;
  }
  
  /**
   * add a param to the list
   * @param wsParam
   * @return this for chaining
   */
  public GcGroupDelete addParam(WsParam wsParam) {
    this.params.add(wsParam);
    return this;
  }
  
  /** act as subject if any */
  private WsSubjectLookup actAsSubject;

  /**
   * assign the act as subject if any
   * @param theActAsSubject
   * @return this for chaining
   */
  public GcGroupDelete assignActAsSubject(WsSubjectLookup theActAsSubject) {
    this.actAsSubject = theActAsSubject;
    return this;
  }
  
  /**
   * validate this call
   */
  private void validate() {
    if (GrouperClientUtils.length(this.groupLookups) == 0) {
      throw new RuntimeException("Need at least one group to delete: " + this);
    }
  }
  
  /** tx type for request */
  private GcTransactionType txType;

  /**
   * assign the tx type
   * @param gcTransactionType
   * @return self for chaining
   */
  public GcGroupDelete assignTxType(GcTransactionType gcTransactionType) {
    this.txType = gcTransactionType;
    return this;
  }
  
  /** if the group detail should be sent back */
  private Boolean includeGroupDetail;
  
  /**
   * assign if the group detail should be included
   * @param theIncludeGroupDetail
   * @return this for chaining
   */
  public GcGroupDelete assignIncludeGroupDetail(Boolean theIncludeGroupDetail) {
    this.includeGroupDetail = theIncludeGroupDetail;
    return this;
  }
  
  /** client version */
  private String clientVersion;

  /**
   * assign client version
   * @param theClientVersion
   * @return this for chaining
   */
  public GcGroupDelete assignClientVersion(String theClientVersion) {
    this.clientVersion = theClientVersion;
    return this;
  }
  
  /**
   * execute the call and return the results.  If there is a problem calling the service, an
   * exception will be thrown
   * 
   * @return the results
   */
  public WsGroupDeleteResults execute() {
    this.validate();
    WsGroupDeleteResults wsGroupDeleteResults = null;
    try {
      //Make the body of the request, in this case with beans and marshaling, but you can make
      //your request document in whatever language or way you want
      WsRestGroupDeleteRequest groupDelete = new WsRestGroupDeleteRequest();

      groupDelete.setActAsSubjectLookup(this.actAsSubject);

      groupDelete.setTxType(this.txType == null ? null : this.txType.name());
      
      if (this.includeGroupDetail != null) {
        groupDelete.setIncludeGroupDetail(this.includeGroupDetail ? "T" : "F");
      }
      
      groupDelete.setWsGroupLookups(GrouperClientUtils.toArray(this.groupLookups, 
          WsGroupLookup.class));

      //add params if there are any
      if (this.params.size() > 0) {
        groupDelete.setParams(GrouperClientUtils.toArray(this.params, WsParam.class));
      }
      
      GrouperClientWs grouperClientWs = new GrouperClientWs();
      
      //kick off the web service
      wsGroupDeleteResults = (WsGroupDeleteResults)
        grouperClientWs.executeService("groups", groupDelete, "groupDelete", this.clientVersion);
      
      String resultMessage = wsGroupDeleteResults.getResultMetadata().getResultMessage();
      grouperClientWs.handleFailure(resultMessage);
      
    } catch (Exception e) {
      GrouperClientUtils.convertToRuntimeException(e);
    }
    return wsGroupDeleteResults;
    
  }
  
}
