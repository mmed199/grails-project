package test

import Test.Role
import Test.User
import Test.UserRole

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: "ROLE_ADMIN").save()
        def AdminInstance = new User(username: "admin", password: "admin").save()
        UserRole.create(AdminInstance, adminRole, true)

        def modRole = new Role(authority: "ROLE_MOD").save()
        def modInstance = new User(username: "modo", password: "modo").save()
        UserRole.create(modInstance, modRole, true)

        def userRole = new Role(authority: "ROLE_ADMIN").save()
        def userInstance = new User(username: "user", password: "user").save()
        UserRole.create(userInstance, userRole, true)


        (1..20).each { Integer it ->
            new SaleAd(title: "title " + it,
                    descShort: "Description courte",
                    descLong: "Description longue",
                    price: it)
                    .addToIllustrations(new Illustration(filename: "filename.png"))
                    .save()
        }
        def destroy = {
        }
    }
}