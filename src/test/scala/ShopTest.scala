import org.scalatest.FlatSpec

/**
  * Created by Administrator on 20/06/2017.
  */
class ShopTest extends FlatSpec {



  "As A manager I want to update the item list with a new product" should "add product to the shop list" in {
    val shop = new Shop
    assert (shop.test == 5)
  }

  "test 2" should "add product to the shop list" in {
    val shop = new Shop
    assert (shop.test == 5)
  }
}
