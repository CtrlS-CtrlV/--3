import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static List<String> validate(Object obj) {
        List<String> errors = new ArrayList<>();
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);

                if (field.isAnnotationPresent(Range.class)) {
                    Range range = field.getAnnotation(Range.class);
                    if (value instanceof Integer) {
                        int intValue = (int) value;
                        if (intValue < range.min() || intValue > range.max()) {
                            errors.add("Field '" + field.getName() + "': " + range.message() + " (Current: " + intValue + ")");
                        }
                    }
                }

                if (field.isAnnotationPresent(Regex.class)) {
                    Regex regex = field.getAnnotation(Regex.class);
                    if (value instanceof String) {
                        String strValue = (String) value;
                        if (!strValue.matches(regex.pattern())) {
                            errors.add("Field '" + field.getName() + "': " + regex.message() + " (Current: '" + strValue + "')");
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return errors;
    }
}
