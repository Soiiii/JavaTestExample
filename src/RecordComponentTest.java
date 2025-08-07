import java.lang.reflect.RecordComponent;
import java.util.Arrays;

public class RecordComponentTest {

        public static void main(String[] args) {
            testSampleRecordComponent();
            testTopLevelRecord();
            testStaticInnerRecord();
            testNestedRecordComponent();
        }

        static void testTopLevelRecord() {
            Class<?> clazz = Top.class;

            System.out.println("[TopLevel Record]");
            System.out.println("Name: " + clazz.getName());
            System.out.println("isRecord: " + clazz.isRecord());
            System.out.println("Components: " + Arrays.toString(clazz.getRecordComponents()));
        }

        static void testStaticInnerRecord() {
            Class<?> clazz = Outer.Inner.class;

            System.out.println("[Static Inner Record]");
            System.out.println("Name: " + clazz.getName());
            System.out.println("isRecord: " + clazz.isRecord());
            System.out.println("Components: " + Arrays.toString(clazz.getRecordComponents()));
        }

        static void testSampleRecordComponent() {
            Class<?> clazz = Sample.class;
            RecordComponent[] components = clazz.getRecordComponents();

            if (components == null || components.length != 2) {
                throw new RuntimeException("RC: RecordComponent count mismatch");
            }

            System.out.println("[Sample Record]");
            for (RecordComponent rc : components) {
                System.out.println("getName(): " + rc.getName());
                System.out.println("getType(): " + rc.getType());
                System.out.println("getAccessor(): " + rc.getAccessor());
                System.out.println("getGenericType(): " + rc.getGenericType());
                System.out.println("getGenericSignature(): " + rc.getGenericSignature());
                System.out.println("getDeclaringRecord(): " + rc.getDeclaringRecord());
                System.out.println("getAnnotatedType(): " + rc.getAnnotatedType());
                System.out.println("getAnnotation(Deprecated.class): " + rc.getAnnotation(Deprecated.class));
                System.out.println("getDeclaredAnnotations().length = " + rc.getDeclaredAnnotations().length);
                System.out.println("getAnnotations().length = " + rc.getAnnotations().length);
                System.out.println("toString(): " + rc);
            }
        }

        static void testNestedRecordComponent() {
            Class<?> studentClass = Student.class;
            RecordComponent[] studentComponents = studentClass.getRecordComponents();

            System.out.println("[Student Record]");
            for (RecordComponent rc : studentComponents) {
                System.out.println("Student field name: " + rc.getName());
                System.out.println("Student field type: " + rc.getType());
                System.out.println("DeclaringRecord: " + rc.getDeclaringRecord());

                if (rc.getType().isRecord()) {
                    RecordComponent[] subjectComponents = rc.getType().getRecordComponents();
                    for (RecordComponent subRc : subjectComponents) {
                        System.out.println(" Subject field: " + subRc.getName());
                        System.out.println(" DeclaringRecord: " + subRc.getDeclaringRecord());
                    }
                }
            }
        }

        // 🧩 레코드 정의 모음

        record Top(String name) {}

        public static class Outer {
            public static record Inner(String val) {}
        }

        @Deprecated
        record Sample(@Deprecated String name, int age) {}

        record Subject(String name) {}

        record Student(String name, Subject subject) {}

    }
