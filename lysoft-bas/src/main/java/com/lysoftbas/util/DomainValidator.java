package com.lysoftbas.util;

import org.hibernate.validator.HibernateValidator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class DomainValidator {

	private static Validator validator = Validation.byProvider(HibernateValidator.class).
			configure().failFast(true).buildValidatorFactory().getValidator();
	
	
	
	public static<T> boolean validate(T domain) {
		Set<ConstraintViolation<T>> validateResult =validator.validate(domain);
		if(validateResult.size()>0) {
			System.out.println(validateResult.iterator().next().getMessage()+"校验失败");
			return false;
		}
		return true;
	}
	
	public static <T> boolean validate2(T object, Class group) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object, new Class[]{group});
        if (constraintViolations.size() >0) {
            System.out.println(constraintViolations.iterator().next().getMessage()+"校验失败！！！！！");
            return false;
        }
        return true;
    }
	
}
