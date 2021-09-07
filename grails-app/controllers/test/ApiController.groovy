package test

import Test.User
import grails.converters.JSON
import grails.converters.XML

class ApiController {

    BackService backService
    SaleAdService saleAdService
    def index() { }

    def users() {
        switch (request.getMethod()) {
            case "GET" :
                def list = backService.listUser()
                withFormat {
                    json { render list as JSON }
                    xml { render list as XML}
                }
                break
            case "POST" :
                if(!request.JSON.username || !request.JSON.password)
                    return response.status = 400
                def user = User.findByUsername(request.JSON.username)
                if(user)
                    withFormat {
                        json { render ([error : true, message : "User not created, username already exists"] as JSON)}
                    }

               def created = backService.createUser(request.JSON.username, request.JSON.password, null)
                if(created)
                    return response.status = 201
                else
                    withFormat {
                        json { render ([error : true, message : "User not created"] as JSON)}
                    }
                break
            default:
                return response.status= 405
                break
        }
    }

    def user() {
        switch (request.getMethod()) {
            case "GET" :
                if(!params.id)
                    return response.status = 400
                def user = backService.getUser(params.id)
                if(!user)
                    return response.status = 404
                def userMap = [
                        user : user,
                        authorities : user.getAuthorities()
                ]
                withFormat {
                    json { render (userMap as JSON)}
                    xml { render (userMap as XML)}
                }
                break
            case "PUT" :
                if(!params.id)
                    return response.status = 400
                def user = backService.getUser(params.id)
                if(!user)
                    return response.status = 404
                def properties = request.JSON
                if(!properties.username || !properties.password)
                    return response.status = 400
                user.properties = properties
                if (user.save(flush:true))
                    return response.status = 200
                else
                    withFormat {
                        json { render ([error : true, message : "User not modified"] as JSON)}
                    }

                break
            case "PATCH" :
                if(!params.id)
                    return response.status = 400
                def user = backService.getUser(params.id)
                if(!user)
                    return response.status = 404
                user.properties = request.JSON
                if (user.save(flush:true))
                    return response.status = 200
                else
                    withFormat {
                        json { render ([error : true, message : "User not modified"] as JSON)}
                    }

                break
            case "DELETE" :
                if(!params.id)
                    return response.status = 400
                def user = backService.getUser(params.id)
                if(!user)
                    return response.status = 404
                backService.deleteUser(params.id)
                return response.status = 200
        }
    }

    def salead(){

        switch(request.getMethod())
        {
            case "GET":
                if (!params.id) {
                   return response.status = 400
               }
                def annonceInstance= SaleAd.get(params.id)
                if (!annonceInstance)
                    return response.status= 404
                response.withFormat {
                     json { render annonceInstance as JSON }
                }

            case "PUT":
                if (!params.id) {
                    return response.status = 400
                }
                def annonceInstance= SaleAd.get(params.id)
                if (!annonceInstance)
                    return response.status= 404
                def ac = request.JSON

                if (!ac.title|| !ac.descLong||!ac.descShort)
                    return response.status = 400

                annonceInstance.properties=ac
                annonceInstance.save(flush:true)
                return response.status=200
                break
            case "PATCH":
                if (!params.id) {
                    return response.status = 400
                }
                def annonceInstance = SaleAd.get(params.id)
                if (!annonceInstance)
                    return response.status = 404
                def ac = request.JSON
                annonceInstance.properties=ac
                annonceInstance.save(flush:true)
                return response.status=200
                break
            case "DELETE":
                if (!params.id) {
                    return response.status = 400
                }
                def annonceInstance= SaleAd.get(params.id)
                if (!annonceInstance)
                    return response.status= 404
                annonceInstance.delete(flush: true)
                return response.status= 200
                break
            default:
                return response.status= 405
                break

        }
        return response.status= 406
 }

    def salesad(){
        switch(request.getMethod()) {
            case "GET":
                def annonceInstance= SaleAd.list()
                if (!annonceInstance)
                    return response.status= 404
                response.withFormat{
                    json{ render annonceInstance as JSON }
                }
                break
            case "POST":
                if( !request.JSON.title || !request.JSON.descShort || !request.JSON.descLong || !request.JSON.price)
                    return response.status = 400

                println(request.JSON)


                //def created =  new SaleAd(title:request.JSON.title,descShort:request.JSON.descShort,descLong:request.JSON.descLong,price:request.JSON.price).save()
                println request.JSON
                def created = backService.createSalesAd(request.JSON,null, null)
                println created
                if(created)
                    return response.status = 201
                else
                    withFormat {
                        json { render ([error : true, message : "Sale not created"] as JSON)}
                    }
                break

            default:
                return response.status= 405
                break}
        return response.status= 406
    }
    }


