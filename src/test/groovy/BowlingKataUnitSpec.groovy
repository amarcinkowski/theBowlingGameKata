import spock.lang.Specification
/**
 * Created by amarcinkowski on 14.04.16.
 */
class BowlingKataUnitSpec extends Specification{

    def game = new Game()

    def "gutter one roll game"() {
        when:
            game.roll(0)
        then:
            game.score() == 0
    }

    def "Gutter Game (20x0)"() {
        when:
            rollMany(20, 0)
        then:
            game.score() == 0
    }

    def "All Ones Game (20x1)"() {
        when:
            rollMany(20, 1)
        then:
            game.score() == 20
    }

    def "One spare game: roll spare (2x5) then roll 3"() {
        when:
            rollSpare()
            game.roll(3)
            rollMany(17,0)
        then:
            game.score() == 16
    }

    def "One strike game: roll strike (1x10) then roll 3 and 4"() {
        when:
            rollStrike()
            game.roll(3)
            game.roll(4)
            rollMany(16, 0)
        then:
            game.score() == 24
    }

    private def rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private def rollStrike() {
        game.roll(10)
    }

    private def rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins)
        }
    }
}
