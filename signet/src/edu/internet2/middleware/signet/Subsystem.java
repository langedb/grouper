/*--
$Id: Subsystem.java,v 1.9 2005-11-01 00:07:33 acohen Exp $
$Date: 2005-11-01 00:07:33 $

Copyright 2004 Internet2 and Stanford University.  All Rights Reserved.
Licensed under the Signet License, Version 1,
see doc/license.txt in this distribution.
*/
package edu.internet2.middleware.signet;

import java.util.Map;
import java.util.Set;

import edu.internet2.middleware.signet.choice.ChoiceSet;
import edu.internet2.middleware.signet.tree.Tree;


/**
* Subsystem describes a business entity within the
* enterprise, such as the financial department.
* <p>
* For our September release, the following Subsystem-related entities
* will be implemented:
* <ul>
*     <li>Subsystem</li>
*     <li>Category</li>
*     <li>Function</li>
*     <li>Permission</li>
*     <li>Tree</li>
* </ul>
*
* The following Subsystem-related entities will appear in subsequent
* releases:
* <ul>
*     <li>Condition</li>
*     <li>ProxyType</li>
*     <li>Limit</li>
*     <li>LimitChoice</li>
*     <li>Prerequisite</li>
* </ul>
* 
*/

public interface Subsystem
extends HelpText, NonGrantable, Name, Comparable
{
  /**
   * Gets the ID of this entity.
   * 
   * @return Returns a short mnemonic id which will appear in XML
   *    documents and other documents used by analysts.
   */
  public String getId();
  
  /**
   * Gets the Categories currently associated with this Subsystem.
   * 
   * @return Returns the categories currently associated with this
   *    Subsystem.
   */
  public Set getCategories();
  
  /**
   * Gets a single Category currently associated with this Subsystem.
   * 
   * @return Returns the specified Category.
   */
  public Category getCategory(String categoryId)
  throws ObjectNotFoundException;
  
  /**
   * Gets the Functions currently associated with this Subsystem.
   * 
   * @return Returns the functions currently associated with this
   *    Subsystem.
   */
  public Set getFunctions();
  
  /**
   * Sets the Functions that should be associated with this Subsystem.
   * 
   * @param categories the functions that should be associated with
   *    this Subsystem.
   */
  public void setFunctionsArray(Function[] categories);

  /**
   * Gets a single Function associated with this Subsystem by its ID.
   * @param functionId
   * @return the specified Function
   */
  public Function getFunction(String functionId)
  throws ObjectNotFoundException;

  /**
   * Gets the Tree currently associated with this Subsystem.
   * 
   * @return the Tree currently associated with this Subsystem.
   */
  public Tree getTree();
  
  /**
   * Set the Tree which should be associated with this Subsystem.
   * @param tree
   */
  public void setTree(Tree tree);
  
  /**
   * Add a Category to the set of Categories that are associated with this
   * Subsystem.
   * 
   * @param category
   */
  public void add(Category category);
  
  /**
   * Add a Limit to the set of Limits that are associated with this
   * Subsystem.
   * 
   * @param limit
   */
  public void add(Limit limit);
  
  /**
   * Get the ChoiceSets currently associated with this Subsystem.
   * 
   * @return a Set containing all the ChoiceSets currently associated with
   * this Subsystem.
   */
  public Set getChoiceSets();
  
  /**
   * Gets a single ChoiceSet associated with this Subsystem by its ID.
   * @param id
   * @return the specified ChoiceSet
   * 
   * @throws ObjectNotFoundException
   */
  public ChoiceSet getChoiceSet(String id)
  throws ObjectNotFoundException;
  
  /**
   * Get the Limits currently associated with this Subsystem.
   * 
   * @return a Map of the Limits, indexed by limitId.
   */
  public Map getLimits();

  /**
   * Gets a single Limit associated with this Subsystem by its ID.
   * @param id
   * @return the specified Limit
   */
  public Limit getLimit(String id)
  throws ObjectNotFoundException;
  
  /**
   * Get the Permissions currently associated with this Subsystem.
   * 
   * @return a Map of the Permissions, indexed by permissionId.
   */
  public Map getPermissions();

  /**
   * Gets a single Permission associated with this Subsystem by its ID.
   * @param id
   * @return the specified Permission.
   */
  public Permission getPermission(String id)
  throws ObjectNotFoundException;
}