import java.util.List;
import java.util.ArrayList;

//实体
class Employee {
    private String name;
    private String gender;
    private String retireStatus;

    public Employee(String name, String gender, String r) {
        this.name = name;
        this.gender = gender;
        this.retireStatus = r;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getRetireStatus() {
        return retireStatus;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", gender=" + gender
                + ", retireStatus=" + retireStatus + "]";
    }
}

//接口 筛选
interface Criteria {
    public List<Employee> meetCriteria(List<Employee> persons);
}

// 具体标准  或者 筛选标准
class CriteriaMale implements Criteria {

    @Override
    public List<Employee> meetCriteria(List<Employee> persons) {
        List<Employee> malePersons = new ArrayList<Employee>();
        for (Employee person : persons) {
            if (person.getGender().equalsIgnoreCase("MALE")) { // 忽视大小写
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
// 具体标准  或者 筛选标准 2
class CriteriaFemale implements Criteria {

    @Override
    public List<Employee> meetCriteria(List<Employee> persons) {
        List<Employee> femalePersons = new ArrayList<Employee>();
        for (Employee person : persons) {
            if (person.getGender().equalsIgnoreCase("FEMALE")) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}

// 具体标准  或者 筛选标准 3
class CriteriaRetire implements Criteria {

    @Override
    public List<Employee> meetCriteria(List<Employee> persons) {
        List<Employee> singlePersons = new ArrayList<Employee>();
        for (Employee person : persons) {
            if (person.getRetireStatus().equalsIgnoreCase("YES")) {
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}

// 具体标准  或者 筛选标准 4
class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Employee> meetCriteria(List<Employee> persons) {
        List<Employee> firstCriteriaPersons = criteria.meetCriteria(persons);
        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}

// 具体标准  或者 筛选标准 5
class OrCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Employee> meetCriteria(List<Employee> persons) {
        List<Employee> firstCriteriaItems = criteria.meetCriteria(persons);
        List<Employee> otherCriteriaItems = otherCriteria.meetCriteria(persons);

        for (Employee person : otherCriteriaItems) {
            if (!firstCriteriaItems.contains(person)) {
                firstCriteriaItems.add(person);
            }
        }
        return firstCriteriaItems;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> persons = new ArrayList<Employee>();

        persons.add(new Employee("Tom", "Male", "YES"));
        persons.add(new Employee("Jack", "Male", "NO"));
        persons.add(new Employee("Jane", "Female", "NO"));
        persons.add(new Employee("Diana", "Female", "YES"));
        persons.add(new Employee("Mike", "Male", "NO"));
        persons.add(new Employee("Bob", "Male", "YES"));

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria retire = new CriteriaRetire();
        Criteria retireMale = new AndCriteria(retire, male);
        Criteria retireOrFemale = new OrCriteria(retire, female);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));

        System.out.println("Females: ");
        printPersons(female.meetCriteria(persons));

        System.out.println("Retire Males: ");
        printPersons(retireMale.meetCriteria(persons));

        System.out.println("Retire Or Females: ");
        printPersons(retireOrFemale.meetCriteria(persons));
    }

    public static void printPersons(List<Employee> persons) {
        for (Employee person : persons) {
            System.out.println(person);
        }
    }
}