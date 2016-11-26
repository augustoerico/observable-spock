package io.github.augustoerico

import spock.lang.Specification
import spock.util.concurrent.AsyncConditions

class CalculatorUnitSpec extends Specification {

    static final Double WAIT_TIME = 5.0

    def 'Should sum all positive values'() {
        def cons = new AsyncConditions()
        def result

        given:
        def values = [1, 2, 3, 4, 5]

        when:
        Calculator.sum(values).subscribe {
            result = it
            cons.evaluate { true }
        }

        then:
        cons.await(WAIT_TIME)
        result == 15

    }

}
