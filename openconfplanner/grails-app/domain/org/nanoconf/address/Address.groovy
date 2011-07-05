package org.nanoconf.address

class Address {
	
	String street
	String street2
	String city
	String state
	String postalCode
	
    static constraints = {
		street     blank:false
		street2    blank:true, nullable:true
		city       blank:false
		state      blank:false
		postalCode blank:false
    }
}
