package info.novatec

import io.micronaut.function.client.FunctionClient
import io.micronaut.http.annotation.Body
import io.reactivex.Single
import javax.inject.Named

@FunctionClient
interface BreakEvenCalculatorClient {

    @Named("break-even-calculator")
    fun apply(@Body request: BreakEvenRequest): Single<BreakEvenResponse>

}
