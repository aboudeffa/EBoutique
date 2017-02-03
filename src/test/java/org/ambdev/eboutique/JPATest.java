package org.ambdev.eboutique;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JPATest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1() {
	try {
	    ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(
		    new String[] { "applicationContext.xml" });
	    assertTrue(true);
	} catch (Exception e) {
	    assertTrue(e.getMessage(), false);
	}
    }

}
