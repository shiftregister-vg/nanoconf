package org.nanoconf.phone

class Phone {
	
	int npa
	int nxx
	int nxxx
	String extension
	
    static constraints = {
		extenstion nullable:true
    }
}
