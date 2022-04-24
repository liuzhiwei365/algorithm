package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ForJson {
    public class Person {

        /**@JSONField 的作用对象:
        1. Field
        2. Setter 和 Getter 方法 ,没有不生效
         */
        @JSONField(name = "AGE", serialize=false)
        private int age;

        @JSONField(name = "FULL NAME", ordinal = 2)
        private String fullName;


        //format 参数用于格式化 date 属性, 使用 ordinal 参数指定字段的顺序
        @JSONField(name = "DATE OF BIRTH",format="dd/MM/yyyy", ordinal = 1)
        private Date dateOfBirth;

        public Person(int age, String fullName, Date dateOfBirth) {
            super();
            this.age = age;
            this.fullName= fullName;
            this.dateOfBirth = dateOfBirth;
        }

        // 标准 getters & setters

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public Date getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }
    }


    private  List<Person> listOfPersons = new ArrayList<Person>();

    @Before
    public void setUp() {
        listOfPersons.add(new Person(15, "John Doe", new Date()));
        listOfPersons.add(new Person(20, "Janette Doe", new Date()));
    }

    @Test
    public void testObjToJson() {
        String jsonOutput= JSON.toJSONString(listOfPersons);

        System.out.println(jsonOutput);
        //[{"DATE OF BIRTH":"31/03/2022","FULL NAME":"John Doe"},{"DATE OF BIRTH":"31/03/2022","FULL NAME":"Janette Doe"}]
    }

    @Test
    public void testObjToJsonArray() {
        String jsonOutput= JSON.toJSONString(listOfPersons, SerializerFeature.BeanToArray);

        System.out.println(jsonOutput);
        //[["31/03/2022","John Doe"],["31/03/2022","Janette Doe"]]
    }


    @Test
    public void whenGenerateJson_thanGenerationCorrect() throws ParseException {
        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i < 2; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("AGE", 10);
            jsonObject.put("FULL NAME", "Doe " + i);
            jsonObject.put("DATE OF BIRTH", "2016/12/12 12:12:12");
            jsonArray.add(jsonObject);
        }
        String jsonOutput = jsonArray.toJSONString();
        System.out.println(jsonOutput);
        //[{"DATE OF BIRTH":"2016/12/12 12:12:12","FULL NAME":"Doe 0","AGE":10},
        // {"DATE OF BIRTH":"2016/12/12 12:12:12","FULL NAME":"Doe 1","AGE":10}]
    }

    @Test
    public void whenJson_thanConvertToObjectCorrect() {
        Person person = new Person(20, "John", new Date());
        String jsonObject = JSON.toJSONString(person);

        Person newPerson = JSON.parseObject(jsonObject, Person.class);

        assertEquals(newPerson.getAge(), 0); // 如果我们设置系列化为 false
        assertEquals(newPerson.getFullName(), listOfPersons.get(0).getFullName());
    }
}
