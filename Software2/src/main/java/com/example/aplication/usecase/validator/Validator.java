package com.example.aplication.usecase.validator;

public interface Validator <I, O>{

	O validate(I data);
}
