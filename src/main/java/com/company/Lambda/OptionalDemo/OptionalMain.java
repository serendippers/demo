package com.company.Lambda.OptionalDemo;

import java.util.Optional;
import java.util.Properties;
import java.util.function.Supplier;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class OptionalMain {

    public void demo() {
        //创建Optional，Optional.empty()创建空的Optional对象
        Optional<Car> optCar = Optional.empty();

        Car car = new Car();
        //Optional.of，依据一个非空值创建一个Optional对象,传入空值抛NullPointerException
        Optional<Car> optCar1 = Optional.of(car);

        //Optional.ofNullable，创建一个允许null值的Optional 对象
        Optional<Car> optCar2 = Optional.ofNullable(car);

        Insurance insurance = null;
        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
        Optional<Person> optionalPerson = Optional.ofNullable(new Person());

        Optional<String> name = optionalInsurance.map(Insurance::getName);

        //name = optionalPerson.map(Person::getCar).map(Car::getInsurance).map(Insurance::getName);
        name = optionalPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName);

        String nameStr = optionalPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("空");//Optional的结果值为空，设置默认值

        nameStr = optionalPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElseGet(() -> "空");

        optionalPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .ifPresent((s) -> s.length());//随手写，无意义


        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");
    }

    /**
     * filter剔除特定值
     */
    public String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(person1 -> person1.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("null");
    }
}
