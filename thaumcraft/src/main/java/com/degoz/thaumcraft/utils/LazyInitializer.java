package com.degoz.thaumcraft.utils;

import com.google.common.base.Suppliers;

import java.util.function.Supplier;

public class LazyInitializer<T> {
    private final Supplier<T> factory;

    public LazyInitializer(Supplier<T> p_13970_) {
        this.factory = Suppliers.memoize(p_13970_::get);
    }

    public T get() {
        return this.factory.get();
    }
}
