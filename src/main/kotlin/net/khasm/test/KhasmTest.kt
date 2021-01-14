package net.khasm.test

import codes.som.anthony.koffee.insns.jvm.*
import net.khasm.transform.KhasmTransformerDispatcher
import java.io.PrintStream

object KhasmTest {
    /**
     * This is functionally equivalent to the fabric-example-mod example mixin (with a slight text change)
     */
    fun registerTest() {
        KhasmTransformerDispatcher.registerTransformer {
            // TitleScreen
            classTarget("net.minecraft.class_442")

            // Screen.init (Called on open or resize)
            methodTarget("net.minecraft.class_437", "method_25426", "()V")

            targets {
                listOf(1)
            }

            action {
                getstatic(System::class, "out", PrintStream::class)
                ldc("This line is printed by the example khasm transformer!")
                invokevirtual(PrintStream::class, "println", void, String::class)
            }
        }
    }
}
