package test

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SaleAdServiceSpec extends Specification {

    SaleAdService saleAdService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SaleAd(...).save(flush: true, failOnError: true)
        //new SaleAd(...).save(flush: true, failOnError: true)
        //SaleAd saleAd = new SaleAd(...).save(flush: true, failOnError: true)
        //new SaleAd(...).save(flush: true, failOnError: true)
        //new SaleAd(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //saleAd.id
    }

    void "test get"() {
        setupData()

        expect:
        saleAdService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SaleAd> saleAdList = saleAdService.list(max: 2, offset: 2)

        then:
        saleAdList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        saleAdService.count() == 5
    }

    void "test delete"() {
        Long saleAdId = setupData()

        expect:
        saleAdService.count() == 5

        when:
        saleAdService.delete(saleAdId)
        sessionFactory.currentSession.flush()

        then:
        saleAdService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SaleAd saleAd = new SaleAd()
        saleAdService.save(saleAd)

        then:
        saleAd.id != null
    }
}
