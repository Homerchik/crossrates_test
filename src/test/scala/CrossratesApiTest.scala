import com.homerchik.common.Env
import com.homerchik.helpers.{Currency, HttpRequester, Parser, Rate}
import org.scalatest.FunSuite

/**
  * Created by homerchik on 31.11.16.
  */
class CrossratesApiTest extends FunSuite{
  val response = Parser.parseResponse(
      HttpRequester.get(
        Env.getApiUrl("crossrates")))
  val actualRates = response.payload.rates

  test("Crossrates api returns data") {
    assert(response.resultCode == "OK")
    assert(actualRates.nonEmpty)
  }

  test("Currency ids should be proper for GBP, EUR, USD, RUB") {
    val expected = List((643, "RUB"), (840, "USD"), (978, "EUR"), (826, "GBP"))
    val actualCurrencies = actualRates.flatMap((r: Rate) => List(r.fromCurrency, r.toCurrency))
        .filter((ccy: Currency) =>
          expected.map(c => c._2).contains(ccy.name))
    val (satisf, unsatisf) = actualCurrencies.partition((c: Currency) => expected.contains((c.code, c.name)))
    assert(unsatisf.isEmpty)
    assert(satisf.nonEmpty)
  }

}
