import org.junit.Test
import kotlin.test.assertEquals

class SimpleTestCase {
    
    @Test
    fun `sout without params` () {
         sout {
             1 + 413
         }
    }

    @Test
    fun `sout with prefix` () {
        soutWithPrefix {
            1 + 413
        }
    }
    
    @Test
    fun `HW Test` () {
        println("hello world test is passed")
        assertEquals(null, null)
    }
}