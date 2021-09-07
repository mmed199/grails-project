package test

import Test.Role
import Test.User
import Test.UserRole
import grails.gorm.transactions.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional
class BackService {

    def serviceMethod() {

    }

    def createUser (String username ,String password, String role){
        // Creation utilisateur
        def user = new User(username: username, password: password).save()

        if(user) {
            //Creation userRole
            if(role)
                UserRole.create(user, Role.get(role))
            return true
        } else {
            return false
        }
    }

    def listRole() {
        return Role.list()
    }

    def getUser(id) {
        return User.get(id)
    }

    def listUser() {
        return User.list()
    }

    def deleteUser(id) {
        def user =  User.get(id)
        def listRole = UserRole.findAllByUser(user)
        UserRole.deleteAll(listRole)
        user.delete()
    }


    //display Advertise
    def salesAd(){
        def ad = SaleAd.list();
        return  ad;
    }

    //deleteAdvertise
    def deleteAd(id) {
        def ad= SaleAd.get(id)
        ad.delete()
    }

    def editAd(id , String descShort, String descLong, String title, price){
        def advert =  SaleAd.get(id)
        println(advert)
        advert.title = title;
        advert.descShort=descShort;
        advert.descLong=descLong;
        advert.price=price;
        advert.save(flush:true);
    }


    def createSalesAd(params, List illustrations, path){
        def ad = new SaleAd(title:params.title,descShort:params.descShort,descLong:params.descLong,price:params.price).save(flush:true)

        if(ad) {

            if(illustrations!= null && !illustrations.empty && illustrations.size() != 0)  {
                illustrations.forEach( {
                    if(!it.isEmpty()) {
                        def fileName = ad.id + "_" + it.originalFilename
                        def newFile = new File(path + fileName)
                        it.transferTo(newFile)
                        def illustration = new Illustration(filename: fileName)

                        ad.illustrations.add(illustration)
                    }
                })
            }

            return true
        } else {
            return false
        }
    }
}
