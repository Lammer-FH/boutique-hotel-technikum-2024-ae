package com.example.boutiquehoteltechnikum.transformer;

public interface ITransformer<T, U> {

    U toDto(T roomEntity);
}
