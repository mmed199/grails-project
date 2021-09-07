package test

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MainSpec extends Specification implements DomainUnitTest<Main> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
