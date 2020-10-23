import serializer.JsonListBuilder;
import serializer.JsonObjectBuilder;
import serializer.SerializedClass;

import java.util.ArrayList;

class Employee extends SerializedClass<Employee> {
    private String first_name;
    private int age;
    private boolean isMale;
    private Job job;
    private ArrayList<SerializedClass> teamMates;

    public Employee(String first_name, int age, boolean isMale, Job job) {
        ArrayList<SerializedClass> teamMates = new ArrayList<>();
        teamMates.add(new Job(1500, "SEE"));
        teamMates.add(new Job(1600, "SEE"));
        teamMates.add(new Job(3500, "SEE"));
        this.first_name = first_name;
        this.age = age;
        this.isMale = isMale;
        this.job = job;
        this.teamMates = teamMates;
    }

    @Override
    public String buildObjectJson() {
        JsonListBuilder listBuilder = new JsonListBuilder();
        for (int i = 0; i < teamMates.size(); i++)
            listBuilder.addNestedObject(teamMates.get(i).buildObjectJson());
        return new JsonObjectBuilder()
                .addString("first_name", this.first_name)
                .addInt("age", age)
                .addBoolean("isMale", isMale)
                .addString("null_value", null)
                .addNestedObject("job", job.buildObjectJson())
                .addNestedList("brothers", listBuilder.buildListJson())
                .buildObject();
    }
}

class Job extends SerializedClass<Job> {
    private int salary;
    private String jobTitle;

    public Job(int salary, String jobTitle) {
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    @Override
    public String buildObjectJson() {
        return new JsonObjectBuilder().addInt("salary", salary).addString("job_title", jobTitle).buildObject();
    }
}
