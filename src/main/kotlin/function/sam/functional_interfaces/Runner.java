package function.sam.functional_interfaces;

/**
 * Поддержка SAM преобразования для Java функциональных интерфейсов есть.
 * Можно интерфейс отметить аннотацией {@link FunctionalInterface} для наглядности, но он нечего не решает
 * Применение SAM преобразование смотрите в {@link function.sam.SamIntroduction}
 */
public interface Runner {
    void run();
}
