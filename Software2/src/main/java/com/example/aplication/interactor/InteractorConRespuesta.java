package com.example.aplication.interactor;

public interface InteractorConRespuesta<I,O> {
	O ejecutar (I dto);
}
