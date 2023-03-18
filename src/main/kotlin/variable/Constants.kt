package variable


/**
 * Константа времени компиляции объявляется вне какой-либо функции, даже не в пределах функции main, потому что
 * ее значение присваивается во время компиляции (в момент, когда программа компилируется) — отсюда и такое название.
 * main и другие функции вызываются во время выполнения (когда программа запущена), и переменные внутри функций
 * получают свои значения этот период. Константа времени компиляции уже существует к этому моменту.
 *
 * Константы времени компиляции могут иметь значения только одного из следующих базовых типов —
 * а использование более сложных типов может сделать компиляцию невозможной.
 * Ниже перечислены поддерживаемые базовые типы для констант времени компиляции:
 */
const val STR: String = "String"          // java:   public static final String STR = "String";
const val INT: Int = 12                   // java:   public static final int INT = 12;
const val DOUBLE: Double = 0.4255         // java:   public static final double DOUBLE = 0.4255D;
const val FLOAT: Float = 0.244242F        // java:   public static final float FLOAT = 0.244242F;
const val LONG: Long = 3535246464262L     // java:   public static final long LONG = 3535246464262L;
const val SHORT: Short = 13131            // java:   public static final short SHORT = 13131;
const val BYTE: Byte = 127                // java:   public static final byte BYTE = 127;
const val CHAR: Char = 's'                // java:   public static final char CHAR = 's';
const val BOOLEAN: Boolean = true         // java:   public static final boolean BOOLEAN = true;


/**
 * Модификатор const, предшествующий val, предупреждает компилятор, что нужно следить за тем,
 * чтобы это значение val нигде не изменялось. В этом случае константы гарантированно будет иметь конкретное значение
 * и ничто не сможет его изменить. Это поможет компилятору применить дополнительные оптимизации.
 * Принято выделять const val, используя только прописные буквы и заменяя пробелы на подчеркивания.
 *
 */

