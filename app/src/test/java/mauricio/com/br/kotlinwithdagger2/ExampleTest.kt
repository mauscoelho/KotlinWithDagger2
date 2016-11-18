package mauricio.com.br.kotlinwithdagger2

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
class ExampleTest : Spek({

    describe("Simple ExampleTest group"){
        context("simple test context"){
            it("should return true for this test"){
                assertEquals(true, true)
            }
            it("should return false for this test"){
                assertEquals(false, false)
            }
        }

        context("simple text with mockito"){
            it("should return Hello from dependency"){
                val expected = "Hello"

                val dependency : SomeDependency = mock { on { getSomething() } doReturn "Hello" }
                val result = dependency.getSomething()

                assertEquals(expected, result)
            }

        }
    }
})