package test

import grails.plugin.springsecurity.SpringSecurityService

class SecurityTagLib {

    SpringSecurityService springSecurityService
    static defaultEncodeAs = [taglib:'html']
    static returnObjectForTags = ['isLoggedIn']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def username = {
        def user = springSecurityService.getCurrentUser();
        if(user)
            out << user.username
        else
            out << ""
    }

    def isLoggedIn = {
        def isLoggedIn = springSecurityService.isLoggedIn()
        return isLoggedIn
    }
}
