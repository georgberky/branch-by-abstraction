package bba.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class QualityTest {

    @ParameterizedTest(name = "{0} → {1}")
    @MethodSource("conversions")
    void of_convertStringRepresentation(String stringRepresentation, Quality expected) {
        assertThat(Quality.of(stringRepresentation))
            .isEqualTo(expected);
    }

    private static Stream<Arguments> conversions() {
        return Stream.of(
            arguments("☀️", Quality.GOOD),
            arguments("🙂", Quality.FAIR),
            arguments("🤮", Quality.BAD)
        );
    }

    @Test
    void of_throws_onUnknownStringRepresentation() {
        assertThatCode(() -> Quality.of("unknownStringRepresentation"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("no such value");
    }
}