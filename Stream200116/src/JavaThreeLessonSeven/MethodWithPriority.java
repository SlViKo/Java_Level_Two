package JavaThreeLessonSeven;

import java.lang.reflect.Method;

class MethodWithPriority {
    public Method method;
    public Integer priority;

    public MethodWithPriority(Method method, int priority) {
        this.method = method;
        this.priority = priority;
    }

    public int compareTo(MethodWithPriority o2) {
        if (this.priority > o2.priority) {
            return 1;
        } else if (this.priority < o2.priority) {
            return -1;
        } else {
            return 0;

        }
    }
}