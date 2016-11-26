package io.github.augustoerico

import rx.Observable

class Calculator {

    static Observable sum(values) {
        def result = values.sum()
        // Let's pretend this is a resource hunger operation
        [1..1000000].each {
            println it
        }
        Observable.just(result)
    }

}
