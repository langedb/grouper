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

package edu.internet2.middleware.grouper;
import  edu.internet2.middleware.grouper.internal.dao.StemDAO;
import  edu.internet2.middleware.grouper.internal.dto.StemDTO;

/** 
 * @author  blair christensen.
 * @version $Id: DeleteStemValidator.java,v 1.6 2007-08-02 19:25:15 blair Exp $
 * @since   1.2.0
 */
class DeleteStemValidator extends GrouperValidator {

  // PROTECTED CLASS METHODS //

  // @since   1.2.0
  protected static DeleteStemValidator validate(Stem ns) {
    StemDAO             dao = GrouperDAOFactory.getFactory().getStem();
    DeleteStemValidator v   = new DeleteStemValidator();
    if      ( Stem.ROOT_NAME.equals( ns.getName() ) ) {
      v.setErrorMessage("cannot delete root stem");
    }
    else if ( dao.findAllChildStems( (StemDTO) ns.getDTO(), Stem.Scope.ONE ).size() > 0 ) {
      v.setErrorMessage("cannot delete stem with child stems");
    }
    else if ( dao.findAllChildGroups( (StemDTO) ns.getDTO(), Stem.Scope.ONE ).size() > 0 ) {
      v.setErrorMessage("cannot delete stem with child groups");
    }
    else {
      v.setIsValid(true);
    }
    return v;
  } // protected static DeleteStemValidator validate(ns)

} // class DeleteStemValidator extends GrouperValidator
