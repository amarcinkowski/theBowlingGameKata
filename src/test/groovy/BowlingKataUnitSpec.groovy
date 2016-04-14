import spock.lang.Specification
/**
 * Created by amarcinkowski on 14.04.16.
 */
class BowlingKataUnitSpec extends Specification{

    def "gutter game"() {
        def game = new Game()

        when:
            game.roll(0)

        then:
            game.score() == 0

    }
}
