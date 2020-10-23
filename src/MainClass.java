import serializer.SerializedClass;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        Employee a = new Employee("hadj", 22, true, new Job(2500, "engineer"));
        Employee b = new Employee("aissa", 29, false, new Job(3600, "SEO"));
        ArrayList<SerializedClass<Employee>> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        System.out.println(a.listedObjects(list));
    }
}
