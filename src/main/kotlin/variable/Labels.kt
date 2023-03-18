package variable

import java.lang.StringBuilder


fun main() {


    /**
     * Любое выражение в Kotlin может быть помечено меткой. Метки имеют форму идентификатора, за которым следует знак,
     * например asor. Чтобы пометить выражение, просто добавьте метку перед ним.@abc@fooBar@
     */

    StringBuilder().let fuck@{
        it.append("hello")
        return@fuck
    }

    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (i == 50) break@loop
        }
    }

}