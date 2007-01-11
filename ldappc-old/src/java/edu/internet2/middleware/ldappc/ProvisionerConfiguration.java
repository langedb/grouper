/*
 Copyright 2004-2006 University Corporation for Advanced Internet Development, Inc.
 Copyright 2004-2006 The University Of Chicago
 
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

package edu.internet2.middleware.ldappc;

import java.util.Map;

import edu.internet2.middleware.ldappc.util.LdapSearchFilter;

/**
 * This interface defines the common configuration functionality required by all
 * provisioners (e.g., Grouper, Signet).
 */
public interface ProvisionerConfiguration
{
    /**
     * This returns a {@link java.util.Map} of the Source to Subject naming
     * attribute for the Source Subject identifiers.
     * 
     * @return Map of Source Subject naming attribute name/value pairs.
     */
    public Map getSourceSubjectNamingAttributes();

    /**
     * This returns the Subject naming attribute for the given Source for the
     * Source Subject identifiers.
     * 
     * @param source
     *            Source name
     * 
     * @return Subject naming attribute name or <code>null</code> if the
     *         Source is not found
     */
    public String getSourceSubjectNamingAttribute(String source);

    /**
     * This returns a {@link java.util.Map} of the Source to Subject LDAP
     * filters for the Source Subject identifiers.
     * 
     * @return Map of Source Subject LDAP filter name/value pairs.
     */
    public Map getSourceSubjectLdapFilters();

    /**
     * This returns the Subject LDAP filter for the given Source for the Source
     * Subject identifiers.
     * 
     * @param source
     *            Source name
     * 
     * @return Subject LDAP filter or <code>null</code> if the Source is not
     *         found
     */
    public LdapSearchFilter getSourceSubjectLdapFilter(String source);
}