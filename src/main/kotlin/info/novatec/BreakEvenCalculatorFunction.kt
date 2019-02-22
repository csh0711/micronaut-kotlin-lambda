package info.novatec

import io.micronaut.function.FunctionBean
import java.util.function.Function
import kotlin.math.ceil

@FunctionBean("break-even-calculator")
class BreakEvenCalculatorFunction : Function<BreakEvenRequest, BreakEvenResponse> {

    override fun apply(request: BreakEvenRequest): BreakEvenResponse {
        val breakEvenPoint = ceil(request.fixedCosts / (request.price - request.unitCosts)).toInt()
        return BreakEvenResponse(breakEvenPoint = breakEvenPoint)
    }
}