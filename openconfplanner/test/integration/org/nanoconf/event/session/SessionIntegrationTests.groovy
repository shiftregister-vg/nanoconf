package org.nanoconf.event.session

import org.nanoconf.address.Address;
import org.nanoconf.event.Event;
import org.nanoconf.event.speaker.Speaker;

import grails.test.*

class SessionIntegrationTests extends GroovyTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCreate() {
		def event = new Event(name:"Test Event")
		assert event.save(flush:true)
		
		def address = new Address(street:"123 Maple",city:"Dallas",state:"TX",postalCode:"75230")
		assert address.save(flush:true)
		
		def sp = new Speaker(firstName:"Chester",lastName:"Tester",email:"chester@tester.com")
		sp.mailingAddress = address
		sp.billingAddress = address
		sp.event = event
		assert sp.save(flush:true)
		
		def s = new Session(name:"Test Session")
		s.description = 'This is a session created by the Grails test harness.  If you see this in your live database then you did it wrong.'
		s.start = new Date().parse('yyyy-MM-dd h:mm:ss','2011-07-04 8:00:00')
		s.end = new Date().parse('yyyy-MM-dd h:mm:ss','2011-07-04 9:30:00')
		s.event = event
		s.addToSpeakers(sp)
		assert s.save(flush:true)
		
		s.delete()
		sp.delete()
		address.delete()
		event.delete()
    }
}
