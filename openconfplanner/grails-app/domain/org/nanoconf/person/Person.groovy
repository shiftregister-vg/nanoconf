package org.nanoconf.person

import org.nanoconf.address.Address;
import org.nanoconf.phone.Phone;

class Person {
	
	String firstName
	String lastName
	String email
	String twitter
	Address mailingAddress
	Address billingAddress
	Phone homePhone
	Phone officePhone
	Phone mobilePhone
	
    static constraints = {
		firstName      blank:false
		lastName       blank:false
		email          blank:false, unique:true, email:true
		twitter        blank:false, nullable:true
		mailingAddress nullable:false
		billingAddress nullable:false
		homePhone      nullable:true // While it is true that the phones
		officePhone    nullable:true // are not ALL required at least one
		mobilePhone    nullable:true // must be non-null
    }
}
