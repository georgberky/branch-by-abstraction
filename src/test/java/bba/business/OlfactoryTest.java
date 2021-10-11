package bba.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OlfactoryTest {

    @ParameterizedTest(name = "{0} → {1}")
    @MethodSource("conversions")
    void of_convertStringRepresentation(String stringRepresentation, Olfactory expected) {
        assertThat(Olfactory.of(stringRepresentation))
            .isEqualTo(expected);
    }

    private static Stream<Arguments> conversions() {
        return Stream.of(
            arguments("💩", Olfactory.SMELLY),
            arguments("🌹", Olfactory.ROSY),
            arguments("🌸", Olfactory.CHERRY)
        );
    }

    @Test
    void of_throws_onUnknownStringRepresentation() {
        assertThatCode(() -> Olfactory.of("unknownStringRepresentation"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("no such value");
    }
}