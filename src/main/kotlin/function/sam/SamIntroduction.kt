package function.sam

import function.sam.functional_interfaces.Killer
import function.sam.functional_interfaces.Runner


class SamIntroduction {
    companion object {

        fun main() {


            /**
             * Аналог объявление анонимного класса в Java. Тут SAM преобразование не используется
             */
            killing(object : Killer {
                override fun kill() {
                    println("kill from anonym object")
                }
            })

            running(object : Runner {
                override fun run() {
                    println("run from anonym object")
                }
            })


            /**
             * Используя SAM преобразование можно писать следующий эквивалентный код:
             */
            killing(Killer { println("kill from sam ") })

            running(Runner { println("run from sam ") })


            /**
             * Используя SAM преобразование можно сокращать до уровня лямбда выражения
             */
            killing { println("kill from sam lambda") }

            running { println("run from sam lambda") }


        }


        private fun killing(killer: Killer) {
            killer.kill()
        }

        private fun running(runner: Runner) {
            runner.run()
        }
    }
}