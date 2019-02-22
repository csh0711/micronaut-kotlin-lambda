package info.novatec

data class BreakEvenRequest(
        val price: Double,
        val fixedCosts: Double,
        val unitCosts: Double
)