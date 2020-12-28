package com.stetsko.converter;

import java.util.List;

public interface IConverter<S, T> {

    T convert(S s);

    List<T> convertAll(List<S> S);
}