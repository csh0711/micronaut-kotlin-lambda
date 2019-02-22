package info.novatec

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BreakEvenCalculatorFunctionTests {

    companion object {
        val server: EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        val client: BreakEvenCalculatorClient = server.applicationContext.getBean(BreakEvenCalculatorClient::class.java)
    }

    @ParameterizedTest
    @CsvSource(
            "20.00, 100.00, 10.00, 10",
            "6.00, 1000.00, 4.00, 500",
            "2.30, 333.33, 2.10, 1667",
            "3.00, 8000.00, 1.50, 5334"
    )
    fun testBreakEvenCalculatorFunction(price: Double, fixedCosts: Double, unitCosts: Double, breakEvenPoint: Int) {
        val request = BreakEvenRequest(price = price, fixedCosts = fixedCosts, unitCosts = unitCosts)

        val response = client.apply(request).blockingGet()

        assertEquals(response.breakEvenPoint, breakEvenPoint)
    }
}
