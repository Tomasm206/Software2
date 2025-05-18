package com.example.aplication.interactor.usecase;

public interface UseCaseConRetorno <D,O>{
	O ejecutar(D dominio);
}
