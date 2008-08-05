/*
  Copyright (C) 2007 University Corporation for Advanced Internet Development, Inc.
  Copyright (C) 2007 The University Of Chicago

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package edu.internet2.middleware.grouper.internal.dto;
import  edu.internet2.middleware.grouper.GrouperDAOFactory;
import  edu.internet2.middleware.grouper.Membership;
import  edu.internet2.middleware.grouper.internal.dao.GrouperDAO;
import  edu.internet2.middleware.grouper.internal.dao.MembershipDAO;
import  edu.internet2.middleware.grouper.internal.util.GrouperUuid;
import  java.util.Date;
import  org.apache.commons.lang.builder.*;

/** 
 * Basic <code>Membership</code> DTO.
 * <p><b>WARNING: THIS IS AN ALPHA INTERFACE THAT MAY CHANGE AT ANY TIME.</b></p>
 * @author  blair christensen.
 * @version $Id: MembershipDTO.java,v 1.6 2008-01-09 14:07:01 isgwb Exp $
 * @since   1.2.0
 */
public class MembershipDTO implements GrouperDTO {

  // PRIVATE INSTANCE VARIABLES //
  private long    createTime  = new Date().getTime();           // reasonable default
  private String  creatorUUID;
  private int     depth       = 0;                              // reasonable default
  private String  id;
  private String  listName;
  private String  listType;
  private String  memberUUID;
  private MemberDTO  memberDTO;
  private String  ownerUUID;
  private String  parentUUID  = null;                           // reasonable default
  private String  type        = Membership.IMMEDIATE;           // reasonable default
  private String  uuid        = GrouperUuid.getUuid(); // reasonable default
  private String  viaUUID     = null;                           // reasonable default


  // PUBLIC INSTANCE METHODS //

  /**
   * @since   1.2.0
   */  
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof MembershipDTO)) {
      return false;
    }
    MembershipDTO that = (MembershipDTO) other;
    return new EqualsBuilder()
      .append( this.getDepth(),      that.getDepth()      )
      .append( this.getListName(),   that.getListName()   )
      .append( this.getListType(),   that.getListType()   )
      .append( this.getMemberUuid(), that.getMemberUuid() )
      .append( this.getUuid(),       that.getUuid()       )
      .append( this.getOwnerUuid(),  that.getOwnerUuid()  )
      .append( this.getViaUuid(),    that.getViaUuid()    )
      .isEquals();
  } // public boolean equals(other)

  /**
   * @since   1.2.0
   */
  public long getCreateTime() {
    return this.createTime;
  }

  /**
   * @since   1.2.0
   */
  public String getCreatorUuid() {
    return this.creatorUUID;
  }

  /**
   * @since   1.20
   */
  public GrouperDAO getDAO() {
    return GrouperDAOFactory.getFactory().getMembership()
      .setCreateTime( this.getCreateTime() )
      .setCreatorUuid( this.getCreatorUuid() )
      .setDepth( this.getDepth() )
      .setId( this.getId() )
      .setListName( this.getListName() )
      .setListType( this.getListType() )
      .setMemberUuid( this.getMemberUuid() )
      .setOwnerUuid( this.getOwnerUuid() )
      .setParentUuid( this.getParentUuid() )
      .setType( this.getType() )
      .setUuid( this.getUuid() )
      .setViaUuid( this.getViaUuid() )
      ;
  }
  
  /**
   * @since   1.2.0
   */
  public int getDepth() {
    return this.depth;
  }

  /**
   * @since   1.2.0
   */
  public String getId() {
    return this.id;
  }

  /**
   * @since   1.2.0
   */
  public String getListName() {
    return this.listName;
  }

  /**
   * @since   1.2.0
   */
  public String getListType() {
    return this.listType;
  }

  /**
   * @since   1.2.0
   */
  public String getMemberUuid() {
    return this.memberUUID;
  }
    
    /**
     * @since   1.3.0
     */
    public MemberDTO getMemberDTO() {
      return this.memberDTO;
    }

  /**
   * @since   1.2.0
   */
  
  public String getOwnerUuid() {
    return this.ownerUUID;
  }

  /**
   * @since   1.2.0
   */
  public String getParentUuid() {
    return this.parentUUID;

  /**
   * @since   1.2.0
   */
  }
  public String getType() {
    return this.type;
  }

  /**
   * @since   1.2.0
   */
  public String getUuid() {
    return this.uuid;
  }

  /**
   * @since   1.2.0
   */
  public String getViaUuid() {
    return this.viaUUID;
  }

  /**
   * @since   1.2.0
   */
  public int hashCode() {
    return new HashCodeBuilder()
      .append( this.getDepth()      )
      .append( this.getListName()   )
      .append( this.getListType()   )
      .append( this.getMemberUuid() )
      .append( this.getUuid()       )
      .append( this.getOwnerUuid()  )
      .append( this.getViaUuid()    )
      .toHashCode();
  } // public int hashCode()

  /**
   * @since   1.2.0
   */
  public MembershipDTO setCreateTime(long createTime) {
    this.createTime = createTime;
    return this;
  }

  /**
   * @since   1.2.0
   */
  public MembershipDTO setCreatorUuid(String creatorUUID) {
    this.creatorUUID = creatorUUID;
    return this;
  }

  /**
   * @since   1.2.0
   */
  public MembershipDTO setDepth(int depth) {
    this.depth = depth;
    return this;
  }

  /**
   * @since   1.2.0
   */
  public MembershipDTO setId(String id) {
    this.id = id;
    return this;
  }

  /**
   * @since   1.2.0
   */
  public MembershipDTO setListName(String listName) {
    this.listName = listName;
    return this;
  }

  /**
   * @since   1.2.0
   */
  public MembershipDTO setListType(String listType) {
    this.listType = listType;
    return this;

  /**
   * @since   1.2.0
   */
  }
  public MembershipDTO setMemberUuid(String memberUUID) {
    this.memberUUID = memberUUID;
    return this;
  }
  
  /**
   * @since   1.3.0
   */
  
  public MembershipDTO setMemberDTO(MemberDTO memberDTO) {
    this.memberDTO = memberDTO;
    return this;
  }

  /**
   * @since   1.2.0
   */
  public MembershipDTO setOwnerUuid(String ownerUUID) {
    this.ownerUUID = ownerUUID;
    return this;
  }

  /**
   * @since   1.2.0
   */
  public MembershipDTO setParentUuid(String parentUUID) {
    this.parentUUID = parentUUID;
    return this;
  }

  /**
   * @since   1.2.0
   */
  public MembershipDTO setType(String type) {
    this.type = type;
    return this;
  }

  /**
   * @since   1.2.0
   */
  public MembershipDTO setUuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

  /**
   * @since   1.2.0
   */
  public MembershipDTO setViaUuid(String viaUUID) {
    this.viaUUID = viaUUID;
    return this;
  }

  /**
   * @since   1.2.0
   */
  public String toString() {
    return new ToStringBuilder(this)
      .append( "createTime",  this.getCreateTime()  )
      .append( "creatorUuid", this.getCreatorUuid() )
      .append( "depth",       this.getDepth()       )
      .append( "id",          this.getId()          )
      .append( "listName",    this.getListName()    )
      .append( "listType",    this.getListType()    )
      .append( "memberUuid",  this.getMemberUuid()  )
      .append( "ownerUuid",   this.getOwnerUuid()   )
      .append( "parentUuid",  this.getParentUuid()  )
      .append( "type",        this.getType()        )
      .append( "uuid",        this.getUuid()        )
      .append( "viaUuid",     this.getViaUuid()     )
      .toString();
  } // public String toString()
  
  
  // PUBLIC CLASS METHODS //
  
  // @since   1.2.0
  public static MembershipDTO getDTO(MembershipDAO dao) {
    MembershipDTO membershipDTO= new MembershipDTO()
      .setCreateTime( dao.getCreateTime() )
      .setCreatorUuid( dao.getCreatorUuid() )
      .setDepth( dao.getDepth() )
      .setId( dao.getId() )
      .setListName( dao.getListName() )
      .setListType( dao.getListType() )
      .setMemberUuid( dao.getMemberUuid() )
      .setOwnerUuid( dao.getOwnerUuid() )
      .setParentUuid( dao.getParentUuid() )
      .setType( dao.getType() )
      .setUuid( dao.getUuid() )
      .setViaUuid( dao.getViaUuid() )
      ;
    if(dao.getMemberDAO() !=null) {
    	membershipDTO.setMemberDTO( MemberDTO.getDTO(dao.getMemberDAO()) );
    }
    return membershipDTO;
  }
  
} 
