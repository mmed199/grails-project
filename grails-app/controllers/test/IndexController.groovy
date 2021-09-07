package test

import org.springframework.web.servlet.ModelAndView

class IndexController {

    BackService backService

    def index() {
        //['listSalesAd' : backService.salesAd()]
        return render(view:'/index', model: [listSalesAd: backService.salesAd()])
    }
}
