package org.nanoconf.event.session

import grails.test.*

class SessionTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testDuration() {
		def duration = 90
		
		def start = new Date().parse('yyyy-MM-dd h:mm:ss','2011-07-04 8:00:00')
		def end = new Date().parse('yyyy-MM-dd h:mm:ss','2011-07-04 9:30:00')
		
		def s = new Session()
		s.start = start
		s.end = end
		
		assertEquals duration, s.duration()
    }
}
