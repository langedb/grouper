/*
 * @author mchyzer
 * $Id: AllDaoHib3Tests.java,v 1.1.2.1 2009-04-07 16:21:08 mchyzer Exp $
 */
package edu.internet2.middleware.grouper.internal.dao.hib3;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 *
 */
public class AllDaoHib3Tests {

  /**
   * 
   * @return test
   */
  public static Test suite() {
    TestSuite suite = new TestSuite(
        "Test for edu.internet2.middleware.grouper.internal.dao.hib3");
    //$JUnit-BEGIN$
    suite.addTestSuite(Hib3MembershipDAOTest.class);
    //$JUnit-END$
    return suite;
  }

}
