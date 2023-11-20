package racing.game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.car.Car
import racing.generator.RandomNumberGenerator

class GameTest {

    @Test
    fun `모든 자동차들이 참여한다`() {
        val cars = listOf(Car("우진"), Car("지훈"))
        val game = Game(cars)
        val numberGenerator = RandomNumberGenerator()
        val result = game.run(numberGenerator)
        assertThat(result.size).isEqualTo(cars.size)
    }

    @Test
    fun `우승자는 한명 또는 여러명일 수 있다`() {
        val cars = listOf(Car("1번"), Car("2번"), Car("3번"), Car("4번"), Car("5번"), Car("6번"))
        val game = Game(cars)
        val tryCount = 100

        val numberGenerator = RandomNumberGenerator()
        repeat(tryCount) {
            game.run(numberGenerator)
        }
        val winners = game.end()
        assertThat(winners.size).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(cars.size)
    }
}
